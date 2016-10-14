package com.alip.selenium.po;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ReadData;

public class ObservationPage extends page {
	
	ReadData rd= new ReadData();
	
	
	
	
	
	
	 
	public void CreateObserv() throws Exception
	{
		Thread.sleep(500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ObservationProjectElem.OBSERVATION_FORM)));
		String Proj_Code=FindByXpath(ObservationProjectElem.OBSERVATION_PROJECT_CODE).getText();
		String Proj_Name=FindByXpath(ObservationProjectElem.OBSERVATION_PROJECT_NAME).getText();
		String Proj_Type=FindByXpath(ObservationProjectElem.OBSERVATION_PROJECT_TYPE).getText();
		String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		String Exep_Proj_Name=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Type=rd.ReadProjectType().toUpperCase().trim();
		System.out.println("Proj_Code :"+Proj_Code+" Exep_Proj_Code :"+Exep_Proj_Code);
		System.out.println("Proj_Name :"+Proj_Name+" Exep_Proj_Name :"+Exep_Proj_Name);
		System.out.println("Proj_Type :"+Proj_Type+" Exep_Proj_Type :"+Exep_Proj_Type);
		Assert.assertEquals(Exep_Proj_Name, Proj_Name,"Project name is mismatch");
		Assert.assertEquals(Exep_Proj_Type, Proj_Type,"Proj_Type name is mismatch");
		Assert.assertEquals(Exep_Proj_Code, Proj_Code,"Proj_Code name is mismatch");
		txtbox(ObservationProjectElem.OBSERVATION_DESC, rd.ReadOBS_Description(2));
		SelectDateFrmCalender(ObservationProjectElem.OBSERVATION_ACT_ST_DATE,rd.ReadOBS_Actual_ST(2));
		SelectDateFrmCalender(ObservationProjectElem.OBSERVATION_ACT_END_DATE,rd.ReadOBS_Actual_END(2));
		String []drpDownExep_Val={rd.ReadOBS_QCtool(2)};
        SelectandCheckFrmDrp(ObservationProjectElem.OBSERVATION_QC_TOOLS, ObservationProjectElem.OBSERVATION_QC_TOOLS_BTN, drpDownExep_Val, ObservationProjectElem.OBSERVATION_QC_TOOL_DRPDWN_1, ObservationProjectElem.OBSERVATION_QC_TOOL_LIST_CHK);
		Thread.sleep(500);
        FindByCssSelector(ObservationProjectElem.OBSERVATION_SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObservationProjectElem.OBSERVATION_SUCCESS)));
		String SucessMSG=FindByCssSelector(ObservationProjectElem.OBSERVATION_SUCCESS).getText().toUpperCase().trim();
		Thread.sleep(500);
		Assert.assertEquals(SucessMSG, ObservationProjectElem.OBSERVATION_SUCCESS_MSG.toUpperCase().trim(), "Observation is not Successful");
		FindByCssSelector(ObservationProjectElem.OBSERVATION_NEXT).click();
	}

}
