package com.alip.selenium.po;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.LoginElem;
import com.alip.selenium.po.elements.ProblemApprovalElem;
import com.alip.selenium.po.elements.ReadData;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

      
public class DashBoardPage extends page {
	
	
	
	public CreateProjectPage NavCreateProject (String ProjType)  {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.PROFILE_SLIDER_BTN)));
		FindByCssSelector(DashBoardElem.PROFILE_SLIDER_BTN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_SLIDER)));
		String Proj=FindByCssSelector(DashBoardElem.SLT_PROJ_TYP).getText();
		System.out.println(Proj);
		
		FindByCssSelector(DashBoardElem.SLT_PROJ_TYP).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROJ_TYP)));
		
		List Proj_Type=page.driver.findElements(By.cssSelector(DashBoardElem.PROJ_TYP));
		int Proj_Type_CNT= Proj_Type.size();
		System.out.println("Proj type :"+Proj_Type_CNT);
		for (int i=1;i<=Proj_Type_CNT;i++){
		String 	Proj_Type_Val= FindByCssSelector(DashBoardElem.PROJ_TYP_1+i+DashBoardElem.PROJ_TYP_2).getText();
		Proj_Type_Val=Proj_Type_Val.replaceAll("[^A-Za-z]", "").toUpperCase();
		ProjType=ProjType.replaceAll("[^A-Za-z]", "").toUpperCase();
		System.out.println("Proj_Type_Val "+Proj_Type_Val+ " and "+ProjType);
			if (Proj_Type_Val.equalsIgnoreCase(ProjType)){
				FindByCssSelector(DashBoardElem.PROJ_TYP_1+i+DashBoardElem.PROJ_TYP_2).click();
				page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.CREATE_PROJ)));
				FindByCssSelector(DashBoardElem.CREATE_PROJ).click();
				page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.REG_PAGE)));
				String proj=FindByCssSelector(CreateProjectElem.PROJ_TYPE).getText();
				proj=proj.replaceAll("[^A-Za-z]", "").toUpperCase();
				Assert.assertEquals(proj, Proj_Type_Val,"Project type is mismatch");
				break;
			}
		}
		
		return new CreateProjectPage () ;
		
	}
	
public ProblemApprovalPage NavSponsorApproval() throws InterruptedException{
		
		while(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.PROJ_INIT_APPROVAL)) != null){
			System.out.println("test");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.PROJ_INIT_APPROVAL)));
		FindByCssSelector(DashBoardElem.PROJ_INIT_APPROVAL).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProblemApprovalElem.FILTER_BTN)));
		
		return new ProblemApprovalPage () ;
	}

public ProblemApprovalPage NavPendSponsorApproval() throws InterruptedException{
		Thread.sleep(1000);
		boolean slider=FindByCssSelector(DashBoardElem.PROFILE_SLIDER).isDisplayed();
		System.out.println("slider :"+slider);
		if(slider==true){
			Thread.sleep(1000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.SLIDER_CLOSE)));
			FindByCssSelector(DashBoardElem.SLIDER_CLOSE).click();	
			System.out.println("Click close");
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROJ_INIT_APPROVAL)));
		
		FindByCssSelector(DashBoardElem.PROJ_INIT_APPROVAL).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProblemApprovalElem.FILTER_BTN)));
		
		return new ProblemApprovalPage () ;
	}

public void RegistrationView(String ExepProjectCode) throws InterruptedException{
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.REGISTRATION_ICON)));
	FindByCssSelector(DashBoardElem.REGISTRATION_ICON).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.REGISTRATION)));
	List projectRow=driver.findElements(By.cssSelector(DashBoardElem.REGISTRATION));
	int projectRowCnt=projectRow.size();
	System.out.println("projectRowCnt :"+projectRowCnt);
	for (int i=1;i<=projectRowCnt;i++){
		String actualProjectCode=driver.findElement(By.cssSelector(DashBoardElem.REGISTRATION_1+i+DashBoardElem.REGISTRATION_2)).getText();
		System.out.println("actualProjectCode :"+actualProjectCode.trim()+" and Exp ProjCode "+ExepProjectCode.trim());
		if (actualProjectCode.trim().equalsIgnoreCase(ExepProjectCode.trim())){
			System.out.println("i value ;"+i);
			String ProjectCode =FindByCssSelector(DashBoardElem.REGISTRATION_1+i+DashBoardElem.REGISTRATION_2).getText();
			System.out.println("ProjectCode :"+ProjectCode);
			String ProjectName =FindByCssSelector(DashBoardElem.REGISTRATION_1+i+DashBoardElem.PROJECTNAME_2).getText();
			System.out.println("ProjectName :"+ProjectName);
			Thread.sleep(500);
			FindByCssSelector(DashBoardElem.REGISTRATION_1+i+DashBoardElem.ACTION_2).click();
			break;
			
		}
		
	}
	
	
}

}
