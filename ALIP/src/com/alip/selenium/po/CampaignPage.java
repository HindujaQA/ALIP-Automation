package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CampaignElem;
import com.alip.selenium.po.elements.CreateProjectElem;

public class CampaignPage extends page {
	public void  CreateCampaign(String Project, String Campaign, String Objective, String From_Date, String To_Date,String Submit_Save) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CampaignElem.CAMPAIGNFORM)));
		SelectDropdown(CampaignElem.PROJECT, Project);
		txtbox(CampaignElem.CAMPAIGN_NAME, Campaign);
		txtbox(CampaignElem.OBJECTIVE, Objective);
		
		String []USER_GROUPdrpDownExep_Val={ "Office of MD","Operations Controller - Global Bus", "PD"};
		SelectandCheckFrmDrp(CampaignElem.USER_GROUP, CampaignElem.USER_GROUP_DRP_DOWN, USER_GROUPdrpDownExep_Val, CampaignElem.USER_GROUP_DRPDWN_1, CampaignElem.USER_GROUP_LIST_CHK);
		String []FunctionaldrpDownExep_Val={ "CPPS"};
		SelectandCheckFrmDrp(CampaignElem.FUNC_UNIT, CampaignElem.FUNC_UNIT_DRP_DOWN, FunctionaldrpDownExep_Val, CampaignElem.FUNC_UNIT_DRPDWN_1, CampaignElem.FUNC_UNIT_LIST_CHK);
		String []GradedrpDownExep_Val={ "CG27","CG24"};
		SelectandCheckFrmDrp(CampaignElem.GRADE_DRP, CampaignElem.GRADE_DRP_DOWN, GradedrpDownExep_Val, CampaignElem.GRADE_DRPDWN_1, CampaignElem.GRADE_LIST_CHK);
		String []DeptdrpDownExep_Val={ "CSP", "HR"};
		SelectandCheckFrmDrp(CampaignElem.DEPT, CampaignElem.DEPT_DRP_DOWN, DeptdrpDownExep_Val, CampaignElem.DEPT_DRPDWN_1, CampaignElem.DEPT_LIST_CHK);
		SelectDateFrmCalender(CampaignElem.VALID_FROM, From_Date);
		SelectDateFrmCalender(CampaignElem.VALID_TO, To_Date);
		if (Submit_Save.trim().equalsIgnoreCase("Submit")){
			FindByCssSelector(CampaignElem.SUBMIT).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CampaignElem.SUBMIT_SUCESS_MSG)));
	        String successMsg=FindByCssSelector(CampaignElem.SUBMIT_SUCESS_MSG).getText().toUpperCase().trim();
	       // successMsg=successMsg.replaceAll("[^Campaign submitted successfully!]", "");
	        String ExpSuccessMsg=CampaignElem.SUCESS_MSG.toUpperCase().trim();
	      //  ExpSuccessMsg=ExpSuccessMsg;
	        Assert.assertTrue(successMsg.contains(ExpSuccessMsg),"successMsg "+successMsg +"not contains Expected"+ExpSuccessMsg);
    }else{
    	FindByCssSelector(CampaignElem.SAVE).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CampaignElem.SUBMIT_SUCESS_MSG)));
        String successMsg=FindByCssSelector(CampaignElem.SUBMIT_SUCESS_MSG).getText();
      Assert.assertEquals(successMsg.toUpperCase().trim(),CampaignElem.SAVE_MSG.toUpperCase().trim());
    }
			
		
		
		
	}
	
	
	public LoginPage logout() throws InterruptedException{
		Logout();
		return new LoginPage();
	}

}
