package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.AnalysisElem;
import com.alip.selenium.po.elements.GenerationElem;
import com.alip.selenium.po.elements.ReadData;

public class GenerationPage extends page{
	
	ReadData rd= new ReadData();
	public EvaluationPage CreateGeneration() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(GenerationElem.GEN_FORM)));
		String Proj_Code=FindByXpath(GenerationElem.GEN_PROJECT_CODE).getText();
		String Proj_Name=FindByXpath(GenerationElem.GEN_PROJECT_NAME).getText();
		String Proj_Type=FindByXpath(GenerationElem.GEN_PROJECT_TYPE).getText();
		String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		String Exep_Proj_Name=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Type=rd.ReadProjectType().toUpperCase().trim();
		System.out.println("Proj_Code :"+Proj_Code+" Exep_Proj_Code :"+Exep_Proj_Code);
		System.out.println("Proj_Name :"+Proj_Name+" Exep_Proj_Name :"+Exep_Proj_Name);
		System.out.println("Proj_Type :"+Proj_Type+" Exep_Proj_Type :"+Exep_Proj_Type);
		Assert.assertEquals(Exep_Proj_Name, Proj_Name,"Project name is mismatch");
		Assert.assertEquals(Exep_Proj_Type, Proj_Type,"Proj_Type name is mismatch");
		Assert.assertEquals(Exep_Proj_Code, Proj_Code,"Proj_Code name is mismatch");
	
		
		
		txtbox(GenerationElem.GEN_IDEA_TITLE, rd.ReadANALYS_Description(2));
		txtbox(GenerationElem.GEN_IDEA_DESC, rd.ReadANALYS_Description(2));
		selectOptionFromDropDown(GenerationElem.GEN_IDEA_CLASSIFIER,rd.ReadGen_Idea_Classifier(2));
		selectOptionFromDropDown(GenerationElem.GEN_IDEA_TYPE,rd.ReadGen_Idea_Type(2));
		
		
		
		String []drpDownExep_Val={rd.ReadGen_Line_of_Business(2)};
		SelectandCheckFrmDrp(GenerationElem.GEN_LOB,GenerationElem.GEN_LOB_BTN ,  drpDownExep_Val, GenerationElem.GEN_LOB_LIST,GenerationElem.GEN_LOB_LIST);
		String []drpDownSegment={rd.ReadGen_Segment(2)};
		SelectandCheckFrmDrp(GenerationElem.GEN_SEGMENT,GenerationElem.GEN_SEGMENT_BTN ,  drpDownSegment, GenerationElem.GEN_SEGMENT_LIST,GenerationElem.GEN_SEGMENT_LIST);
		String []drpDownSub_Segment={rd.ReadGen_Sub_Segment(2)};
		SelectandCheckFrmDrp(GenerationElem.GEN_SUB_SEGMENT,GenerationElem.GEN_SUB_SEGMENT_BTN ,  drpDownSub_Segment, GenerationElem.GEN_SUB_SEGMENT_LIST,GenerationElem.GEN_SUB_SEGMENT_LIST);
		String []drpDownModel={rd.ReadGen_Model(2)};
		SelectandCheckFrmDrp(GenerationElem.GEN_MODEL,GenerationElem.GEN_MODEL_BTN ,  drpDownModel, GenerationElem.GEN_MODEL_LIST,GenerationElem.GEN_MODEL_LIST);
		String []drpDownAgg={rd.ReadGen_Aggregate(2)};
		SelectandCheckFrmDrp(GenerationElem.GEN_AGGREGATE,GenerationElem.GEN_AGGREGATE_BTN ,  drpDownAgg, GenerationElem.GEN_AGGREGATE_LIST,GenerationElem.GEN_AGGREGATE_LIST);
		
        AutoSuggest(GenerationElem.GEN_EMP, GenerationElem.GEN_EMP_LIST, GenerationElem.GEN_EMP_LIST_1, rd.ReadGen_Employee_No(2), rd.ReadGen_Emp_No_1(2), rd.ReadGen_Emp_No_2(2));
        System.out.println("GEN_EMP");    
        FindByCssSelector(GenerationElem.GEN_EMP_ADD).click();
        Thread.sleep(300);
        FindByCssSelector(GenerationElem.GEN_SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(GenerationElem.GEN_SUCCESS)));
		String SucessMSG=FindByCssSelector(GenerationElem.GEN_SUCCESS).getText().toUpperCase().trim();
		Thread.sleep(500);
		Assert.assertEquals(SucessMSG, GenerationElem.GEN_SUCCESS_MSG.toUpperCase().trim(), "Generation is not Successful");
		String ideaNo=FindByCssSelector(GenerationElem.GEN_IDEA_NO).getText();
		System.out.println("ideaNo :"+ideaNo);
		rd.SetGen_Idea_No(2, ideaNo);
		FindByCssSelector(GenerationElem.GEN_NEXT).click();
		
		return new EvaluationPage();
	}



}
