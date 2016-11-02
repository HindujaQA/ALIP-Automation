package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.EvaluationElem;
import com.alip.selenium.po.elements.UndeImplListElem;

public class UnderImplementationPage extends page{
	
	
	
	
	public void ImplementationTempValidation(String expIdea_No, String expIdea_Title, String expProj_Code, 
			String expProj_Name,String expProj_Type) throws InterruptedException{
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UndeImplListElem.UNDERIMPL_FORM)));
		
		String Idea_No=FindByCssSelector(UndeImplListElem.IDEA_NO).getText().toUpperCase().trim();
		String Idea_Title=FindByCssSelector(UndeImplListElem.IDEA_TITLE).getText().toUpperCase().trim();
		String Proj_Code=FindByCssSelector(UndeImplListElem.PJCT_CODE).getText().toUpperCase().trim();
		String Proj_Name=FindByCssSelector(UndeImplListElem.PJCT_NAME).getText().toUpperCase().trim();
		String Proj_Type=FindByCssSelector(UndeImplListElem.PJCT_TYPE).getText().toUpperCase().trim();
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

	public LoginPage ImplementationTempCreation(String ImplGroup, String ActivityName, String Exp_RS_MEM,String Exp_RS_MEM_1,String Exp_RS_MEM_2, 
			String EstimatedHrs,String Proj_Plan_Startdt ,String Proj_Plan_Enddt,String Instruction,String predecessor,String TempName) throws InterruptedException{
		//Template Save
		SelectDropdown(UndeImplListElem.IMPL_GRP, ImplGroup);
		txtbox(UndeImplListElem.ACTV_NAME, ActivityName);
		AutoSuggest(UndeImplListElem.RS_MEM, UndeImplListElem.RS_MEM_AUTO,UndeImplListElem.RS_MEM_AUTO_1, Exp_RS_MEM, Exp_RS_MEM_1, Exp_RS_MEM_2);
		txtbox(UndeImplListElem.EST_HRS, EstimatedHrs);
		SelectDateFrmCalender(UndeImplListElem.S_ST_DT, Proj_Plan_Startdt);		
		SelectDateFrmCalender(UndeImplListElem.S_END_DT, Proj_Plan_Enddt);		
		txtbox(UndeImplListElem.INSTRUCT, Instruction);
		txtbox(UndeImplListElem.PREDECESSOR, predecessor);
		FindByCssSelector(UndeImplListElem.ADD_BTN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UndeImplListElem.UNDERIMPL_FORM)));
		txtbox(UndeImplListElem.TMPLT_NAME_TXT, TempName);
		FindByCssSelector(UndeImplListElem.SAVE_AS_TMPLT).click();
		//Submit
		Thread.sleep(1000);
		FindByCssSelector(UndeImplListElem.SUBMIT_BTN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UndeImplListElem.SUCCESS)));
		String SucessMSG=FindByCssSelector(UndeImplListElem.SUCCESS).getText().toUpperCase().trim();
		Thread.sleep(500);
		Assert.assertEquals(SucessMSG, UndeImplListElem.SUCCESS_MSG.toUpperCase().trim(), "Activity Plan is not Successful");
		Logout();
		
		return new LoginPage();
		
		
	}
}
