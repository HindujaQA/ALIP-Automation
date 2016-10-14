package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.AnalysisElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ReadData;

public class AnalysisPage extends page {
	ReadData rd= new ReadData();
	public GenerationPage CreateAnalysis() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(AnalysisElem.ANALYSIS_FORM)));
		String Proj_Code=FindByXpath(AnalysisElem.ANALYSIS_PROJECT_CODE).getText();
		String Proj_Name=FindByXpath(AnalysisElem.ANALYSIS_PROJECT_NAME).getText();
		String Proj_Type=FindByXpath(AnalysisElem.ANALYSIS_PROJECT_TYPE).getText();
		String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		String Exep_Proj_Name=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Type=rd.ReadProjectType().toUpperCase().trim();
		System.out.println("Proj_Code :"+Proj_Code+" Exep_Proj_Code :"+Exep_Proj_Code);
		System.out.println("Proj_Name :"+Proj_Name+" Exep_Proj_Name :"+Exep_Proj_Name);
		System.out.println("Proj_Type :"+Proj_Type+" Exep_Proj_Type :"+Exep_Proj_Type);
		Assert.assertEquals(Exep_Proj_Name, Proj_Name,"Project name is mismatch");
		Assert.assertEquals(Exep_Proj_Type, Proj_Type,"Proj_Type name is mismatch");
		Assert.assertEquals(Exep_Proj_Code, Proj_Code,"Proj_Code name is mismatch");
		//Probable cause
		txtbox(AnalysisElem.ANLYS_DESC, rd.ReadANALYS_Description(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AnalysisElem.PBL_CAUSE)));
		txtbox(AnalysisElem.PBL_CAUSE, rd.ReadProbable_Cause(2));
		FindByCssSelector(AnalysisElem.PBL_ADD).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AnalysisElem.PBL_TABLE)));
		//Root cause
		txtbox(AnalysisElem.ROOT_CAUSE, rd.ReadANALYS_Root_Cause(2));
		FindByCssSelector(AnalysisElem.ROOT_ADD).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AnalysisElem.ROOT_TABLE)));
		SelectDateFrmCalender(AnalysisElem.ACT_ST_DATE,rd.ReadOBS_Actual_ST(2));
		SelectDateFrmCalender(AnalysisElem.ACT_END_DATE,rd.ReadOBS_Actual_END(2));
		String []drpDownExep_Val={rd.ReadOBS_QCtool(2)};
        SelectandCheckFrmDrp(AnalysisElem.QC_TOOLS, AnalysisElem.QC_TOOLS_BTN,  drpDownExep_Val, AnalysisElem.ANLYS_QC_TOOL_DRPDWN_1,AnalysisElem.ANLYS_QC_TOOL_LIST_CHK);
		
              
        Thread.sleep(500);
        FindByCssSelector(AnalysisElem.ANLYS_SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AnalysisElem.ANLYS_SUCCESS)));
		String SucessMSG=FindByCssSelector(AnalysisElem.ANLYS_SUCCESS).getText().toUpperCase().trim();
		Thread.sleep(500);
		Assert.assertEquals(SucessMSG, AnalysisElem.ANLYS_SUCCESS_MSG.toUpperCase().trim(), "Analysis is not Successful");
		FindByCssSelector(AnalysisElem.ANLYS_NEXT_BTN).click();
		return new GenerationPage();
	}


}
