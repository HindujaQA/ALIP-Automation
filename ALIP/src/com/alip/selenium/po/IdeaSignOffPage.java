package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.EvaluationElem;
import com.alip.selenium.po.elements.IdeaSignOffElem;

public class IdeaSignOffPage extends page{
	
	public LoginPage ApproveIdeaSignOff(String Exep_Proj_Code,String Exep_Proj_Name,String Exep_Proj_Type,String IDeaSignOff_Comments,String Acceptance, String Risk) throws InterruptedException{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(IdeaSignOffElem.IDEA_NO)));
		Thread.sleep(1000);
		String Idea_No=FindByCssSelector(IdeaSignOffElem.IDEA_NO).getText().toUpperCase().trim();
		String Idea_Title=FindByCssSelector(IdeaSignOffElem.IDEA_TITLE).getText().toUpperCase().trim();
		String Proj_Code=FindByCssSelector(IdeaSignOffElem.PJCT_CODE).getText().toUpperCase().trim();
		String Proj_Name=FindByCssSelector(IdeaSignOffElem.PJCT_NAME).getText().toUpperCase().trim();
		String Proj_Type=FindByCssSelector(IdeaSignOffElem.PJCT_TYPE).getText().toUpperCase().trim();
		
		//String Exep_Idea_No=rd.ReadProjectCode().toUpperCase().trim();
		//String Exep_Idea_Title=rd.ReadProject_Name().toUpperCase().trim();
		/*String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		String Exep_Proj_Name=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Type=rd.ReadProjectType().toUpperCase().trim();*/
		System.out.println("Proj_Code :"+Proj_Code+" Exep_Proj_Code :"+Exep_Proj_Code);
		System.out.println("Proj_Name :"+Proj_Name+" Exep_Proj_Name :"+Exep_Proj_Name);
		System.out.println("Proj_Type :"+Proj_Type+" Exep_Proj_Type :"+Exep_Proj_Type);
		Assert.assertEquals(Proj_Name,Exep_Proj_Name.toUpperCase().trim(),"Project name is mismatch");
		Assert.assertEquals(Proj_Type,Exep_Proj_Type.toUpperCase().trim(), "Proj_Type name is mismatch");
		Assert.assertEquals(Proj_Code,Exep_Proj_Code.toUpperCase().trim(), "Proj_Code "+Proj_Code+"  name is mismatch");
		
		FindByCssSelector(IdeaSignOffElem.COMMENTS).sendKeys(IDeaSignOff_Comments);
		SelectDropdown(IdeaSignOffElem.ACCPTNC, Acceptance);
		SelectDropdown(IdeaSignOffElem.RISK, Risk);
		FindByCssSelector(IdeaSignOffElem.SUBMIT_BTN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(IdeaSignOffElem.SUCCESS)));
		String SucessMSG=FindByCssSelector(IdeaSignOffElem.SUCCESS).getText().toUpperCase().trim();
		Thread.sleep(500);
		Assert.assertEquals(SucessMSG, IdeaSignOffElem.SUCCESS_MSG.toUpperCase().trim(), "Idea Sign Off is not Successful");
		Logout();
		return new LoginPage();
	}
	

}
