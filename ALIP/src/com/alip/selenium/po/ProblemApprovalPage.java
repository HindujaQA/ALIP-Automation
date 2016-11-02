package com.alip.selenium.po;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ProblemApprovalElem;

public class ProblemApprovalPage extends page {
	
	public LoginPage PAPlogout() throws InterruptedException{
		Logout();
		return new LoginPage();
	}
	
	 

	public void ModerationApproveAndReject(String Decision, String Reason){
	    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.APPROVE)));
	    	if (Decision.trim().equalsIgnoreCase(CreateProjectElem.APPROVE_TXT.trim())){
	    		FindByCssSelector(CreateProjectElem.APPROVE).click();
	    	}else if (Decision.trim().equalsIgnoreCase(CreateProjectElem.REJECT_TXT.trim())) {
	    		FindByCssSelector(CreateProjectElem.REJECT).click();
			}
	    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.COMMENT)));   
	    	FindByCssSelector(CreateProjectElem.COMMENT).clear();
	    	FindByCssSelector(CreateProjectElem.COMMENT).sendKeys(Reason);
	    	FindByCssSelector(CreateProjectElem.MODERATION_SUBMIT).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.MODERATION_SUBMIT_MSG)));   
	    	String actSuccessMsg=FindByCssSelector(CreateProjectElem.MODERATION_SUBMIT_MSG).getText();
	    	Assert.assertEquals(CreateProjectElem.MODERATION_SUBMIT_MSG_TXT.toUpperCase().trim(), actSuccessMsg.toUpperCase().trim());
	    }
	    
	public void PendingApproval(String ExepProjectCode, String Filter) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProblemApprovalElem.FILTER_BTN)));
		txtbox(ProblemApprovalElem.FIL_PROJECT_CODE, ExepProjectCode);
		SelectDropdown(ProblemApprovalElem.FILTER_STATUS, Filter);
		FindByCssSelector(ProblemApprovalElem.FILTER_BTN).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProblemApprovalElem.PROJECT_TAB)));
		List projectRow=driver.findElements(By.cssSelector(ProblemApprovalElem.PROJECT_CODE));
		int projectRowCnt=projectRow.size();
		System.out.println("projectRowCnt :"+projectRowCnt);
		for (int i=1;i<=projectRowCnt;i++){
			Thread.sleep(300);
			String actualProjectCode=driver.findElement(By.cssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.PROJECT_CODE_1)).getText();
			System.out.println("actualProjectCode :"+actualProjectCode.trim()+" and Exp ProjCode "+ExepProjectCode.trim());
			if (actualProjectCode.trim().equalsIgnoreCase(ExepProjectCode.trim())){
				System.out.println("i value ;"+i);
				String ProjectName =FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.PROJECT_NAME_1).getText();
				System.out.println("ProjectName :"+ProjectName);
				String ProjectType =FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.PROJECT_TYPE_1).getText();
				System.out.println("ProjectType :"+ProjectType);
				String Location =FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.LOCATION_1).getText();
				System.out.println("Location :"+Location);
				String Division =FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.DIVISION_1).getText();
				System.out.println("Division :"+Division);
				String Gemba =FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.GEMBA_1).getText();
				System.out.println("Gemba :"+Gemba);
				String regDate =FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.REG_DATE_1).getText();
				System.out.println("regDate :"+regDate);
				Thread.sleep(500);
				FindByCssSelector(ProblemApprovalElem.PROJECT_1+i+ProblemApprovalElem.ACTION_1).click();
				break;
				
			}
			
		}
		
		
	}

}
