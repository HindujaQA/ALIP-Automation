package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CompletionListElem;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.ReadData;
import com.alip.selenium.po.elements.UndeImplListElem;

public class CompletionListPage extends page {
	ReadData rd= new ReadData();
	public void ImplementationTempValidation(String expIdea_No, String expIdea_Title, String expProj_Code, 
		String expProj_Name,String expProj_Type) throws InterruptedException{
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CompletionListElem.COMPL_FORM)));
		
		String Idea_No=FindByCssSelector(CompletionListElem.IDEA_NO).getText().toUpperCase().trim();
		String Idea_Title=FindByCssSelector(CompletionListElem.IDEA_TITLE).getText().toUpperCase().trim();
		String Proj_Code=FindByCssSelector(CompletionListElem.PJCT_CODE).getText().toUpperCase().trim();
		String Proj_Name=FindByCssSelector(CompletionListElem.PJCT_NAME).getText().toUpperCase().trim();
		String Proj_Type=FindByCssSelector(CompletionListElem.PJCT_TYPE).getText().toUpperCase().trim();
		System.out.println("Idea_Title :"+Idea_Title+" Exep_Idea_Title :"+expIdea_Title);
		System.out.println("Idea_No :"+Idea_No+" Exep_Idea_No :"+expIdea_No);
		System.out.println("Proj_Code :"+Proj_Code+" Exep_Proj_Code :"+expProj_Code);
		System.out.println("Proj_Name :"+Proj_Name+" Exep_Proj_Name :"+expProj_Name);
		System.out.println("Proj_Type :"+Proj_Type+" Exep_Proj_Type :"+expProj_Type);
		Assert.assertEquals(Proj_Name,expProj_Name.toUpperCase().trim(),"Project name is mismatch");
		Assert.assertEquals(Proj_Type,expProj_Type.toUpperCase().trim(), "Proj_Type name is mismatch");
		Assert.assertEquals(Proj_Code,expProj_Code.toUpperCase().trim(), "Proj_Code "+Proj_Code+"  name is mismatch");
		Assert.assertEquals(Idea_Title,expIdea_Title.toUpperCase().trim(),"Idea Title"+Idea_Title + "name is mismatch");
		
		
	}

public ActionTollgate CompletionListSubmission(String ActualHrs,String StartDt,String EndDt,String CompletionStatus, String Comments,int i)throws InterruptedException{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 450);");
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CompletionListElem.TBL_EDIT)));
	FindByCssSelector(CompletionListElem.TBL_EDIT).click();
	Thread.sleep(500);
	txtbox(CompletionListElem.ACT_HRS, ActualHrs);
	SelectDateFrmCalender(CompletionListElem.ST_DATE, StartDt);
	SelectDateFrmCalender(CompletionListElem.END_DATE, EndDt);
	SelectDropdown(CompletionListElem.COMPL_STATUS, CompletionStatus);
	txtbox(CompletionListElem.COMMENTS, Comments);
	FindByCssSelector(CompletionListElem.UPDATE).click();
	Thread.sleep(100);
	//SelectandCheckFrmDrp(CompletionListElem.QC_TOOL_DRPDWN, CompletionListElem., drpDownExep_Val, ElemDropDown_1, ElemChkVal_1);
	String []drpDownExep_Val={rd.ReadQC_Tools(i)};
	SelectandCheckFrmDrp(CompletionListElem.QC_TOOL, CompletionListElem.QC_TOOL_DRPDWN, drpDownExep_Val, CompletionListElem.QC_TOOL_DRPDWN_1, CompletionListElem.QC_TOOL_LIST_CHK);
    FindByCssSelector(CompletionListElem.SUBMIT).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CompletionListElem.SUCCESS)));
	String SucessMSG=FindByCssSelector(CompletionListElem.SUCCESS).getText().toUpperCase().trim();
	Thread.sleep(500);
	Assert.assertEquals(SucessMSG, CompletionListElem.SUCCESS_MSG.toUpperCase().trim(), "Completion is not Successful");
	jse.executeScript("scroll(0, 250);");
	FindByCssSelector(CompletionListElem.NEXT).click();
	
  return new ActionTollgate()  ;
	
	
	
	
}
}
