package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CampaignElem;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.CrowdsourcingElem;
import com.alip.selenium.po.elements.DashBoardElem;

public class CrowdSourcingPage extends page {
	
	public void CreateCrowdSourcing (String expCampaign, String expProject, String expProjCode, String IdeaTitle, String IdeaClassifier, 
			String IdeaDesc, String CurrentMethod, String Add_Info,String ReadKPI_code,String ReadKPI_1,String ReadKPI_2,String Impact,String RECR_ANNUM,
			String ONE_TIME,String INTANGIBLE_BENEFITS,String Submit_Save)  throws InterruptedException{
		Thread.sleep(500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CrowdsourcingElem.CROWD_SOURCING_FORM)));
		/*String Campaign=FindByCssSelector(CrowdsourcingElem.CAMPAIGN).getText().toUpperCase().trim();
		String Project=FindByCssSelector(CrowdsourcingElem.PJCT_NAME).getText().toUpperCase().trim();
		String ProjCode=FindByCssSelector(CrowdsourcingElem.PJCT_CODE).getText().toUpperCase().trim();
		Assert.assertTrue(Campaign.contains(expCampaign.toUpperCase().trim()), "Campaign name :"+Campaign +" is different from Exp"+expCampaign);
		Assert.assertTrue(Project.contains(expProject.toUpperCase().trim()), "Project name :"+Project +" is different from Exp Project"+expProject);
		Assert.assertTrue(ProjCode.contains(expProjCode.toUpperCase().trim()), "ProjCode name :"+ProjCode+" is different from Exp ProjCode"+expProjCode);*/
		txtbox(CrowdsourcingElem.IDEA_TITLE, IdeaTitle);
		selectOptionFromDropDown(CrowdsourcingElem.IDEA_CLASSIFIER, IdeaClassifier);
		txtbox(CrowdsourcingElem.IDEA_DESC, IdeaDesc);
		txtbox(CrowdsourcingElem.CURR_METHOD, CurrentMethod);
		txtbox(CrowdsourcingElem.ADD_INFO, Add_Info);
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CrowdsourcingElem.KPICODE)));
	     AutoSuggest(CrowdsourcingElem.KPICODE, CrowdsourcingElem.KPICODE_AUTO, CrowdsourcingElem.KPICODE_AUTO_1,ReadKPI_code,ReadKPI_1,ReadKPI_2);
	     txtbox(CrowdsourcingElem.IMPACT, Impact);
	     txtbox(CrowdsourcingElem.RECR_ANNUM, RECR_ANNUM);
	     txtbox(CrowdsourcingElem.ONE_TIME, ONE_TIME);
	     FindByCssSelector(CrowdsourcingElem.KPI_ADD).click();
	     
	     
	     txtbox(CrowdsourcingElem.INTANGIBLE_BENEFITS, INTANGIBLE_BENEFITS);
	     if (Submit_Save.trim().equalsIgnoreCase("Submit")){
				FindByCssSelector(CrowdsourcingElem.SUBMIT).click();
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CrowdsourcingElem.SUBMIT_SUCESS_MSG)));
		        String successMsg=FindByCssSelector(CrowdsourcingElem.SUBMIT_SUCESS_MSG).getText().toUpperCase().trim();
		       // successMsg=successMsg.replaceAll("[^Campaign submitted successfully!]", "");
		        String ExpSuccessMsg=CrowdsourcingElem.SUCESS_MSG.toUpperCase().trim();
		       // ExpSuccessMsg=ExpSuccessMsg;
		        Assert.assertTrue(successMsg.contains(ExpSuccessMsg),"successMsg "+successMsg+" not contains expsuccessMsg"+ExpSuccessMsg);
	    }else{
	    	FindByCssSelector(CrowdsourcingElem.SAVE).click();
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CrowdsourcingElem.SUBMIT_SUCESS_MSG)));
	        String successMsg=FindByCssSelector(CrowdsourcingElem.SUBMIT_SUCESS_MSG).getText();
	      Assert.assertEquals(successMsg.toUpperCase().trim(),CrowdsourcingElem.SAVE_MSG.toUpperCase().trim());
	    }
	     
	
	}
	
	public LoginPage logout() throws InterruptedException{
		Logout();
		return new LoginPage();
	}

	public DashBoardPage NavtoDBPage() throws InterruptedException{
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.IDEAL_LOGO))); 
		   Thread.sleep(500);
		   FindByCssSelector(DashBoardElem.IDEAL_LOGO).click();
		 Thread.sleep(500);
		return new DashBoardPage();
	}

}
