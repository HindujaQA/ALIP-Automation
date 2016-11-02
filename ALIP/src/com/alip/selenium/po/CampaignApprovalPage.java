package com.alip.selenium.po;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CampaignApprovalElem;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.CrowdsourcingElem;

public class CampaignApprovalPage extends page{
	public GenerationPage ApproveCampaign(String Decision, String Comment) throws InterruptedException{
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CrowdsourcingElem.CROWD_SOURCING_FORM)));
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		if (Decision.trim().equalsIgnoreCase(CampaignApprovalElem.APPROVE_TXT.trim())){
    		FindByCssSelector(CampaignApprovalElem.APPROVE).click();
    	}else if (Decision.trim().equalsIgnoreCase(CampaignApprovalElem.REJECT_TXT.trim())) {
    		FindByCssSelector(CampaignApprovalElem.REJECT).click();
		}
    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CampaignApprovalElem.COMMENT)));   
    	FindByCssSelector(CampaignApprovalElem.COMMENT).clear();
    	FindByCssSelector(CampaignApprovalElem.COMMENT).sendKeys(Comment);
    	FindByCssSelector(CampaignApprovalElem.CAMPAIGN_SUBMIT).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CampaignApprovalElem.CAMPAIGN_SUBMIT_MSG)));   
    	String actSuccessMsg=FindByCssSelector(CampaignApprovalElem.CAMPAIGN_SUBMIT_MSG).getText();
    	Assert.assertEquals(CampaignApprovalElem.CAMPAIGN_SUBMIT_MSG_TXT.toUpperCase().trim(), actSuccessMsg.toUpperCase().trim());
    	action.sendKeys(Keys.PAGE_DOWN).perform();
    	FindByCssSelector(CampaignApprovalElem.NEXT).click();
    	Thread.sleep(500);
		return new GenerationPage();
		
	}

}
