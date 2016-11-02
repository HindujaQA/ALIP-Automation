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
import com.alip.selenium.po.elements.ProjecttollgatElem;
import com.alip.selenium.po.elements.ReadData;

public class ProjectTollGate extends page {
	ReadData rd= new ReadData();
	
	
	public ObservationPage NavTollToObservation() {
		
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.MODERATION_STATUS)));
       	String ActualSuccessMsg=FindByCssSelector(ProjecttollgatElem.MODERATION_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ProjecttollgatElem.MODERATION_APPROVED_TXT.toUpperCase().trim());
		FindByCssSelector(ProjecttollgatElem.NEXT).click();
		page.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ObservationProjectElem.OBSERVATION_FORM)));
		return new ObservationPage();
		}
	
public ObservationPage NavRegistrationViewToObservation() throws InterruptedException {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	//String Elem=document.getElementById("content");
	//System.out.println(jse.executeScript("document.getElementsByClassName('login-page').scrollHeight;"));
	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(300);
	//FindByCssSelector(CreateProjectElem.KPICODE_EDIT).click();
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).perform();
	System.out.println("4000 scroll ");
	Thread.sleep(1000);
    FindByCssSelector(CreateProjectElem.NEXTBTN).click();
		return new ObservationPage();
		}
public void NavTollToRegisteration() {
		
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.MODERATION_STATUS)));
       	String ActualSuccessMsg=FindByCssSelector(ProjecttollgatElem.MODERATION_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ProjecttollgatElem.MODERATION_APPROVED_TXT.toUpperCase().trim());
		FindByCssSelector(ProjecttollgatElem.PREV).click();
		
		}
	
	public void CreatTollGate(String ExpProject) throws Exception{
		int RowCnt=testExcel.getRowCount("Toll");
    	System.out.println("TollRowCnt :"+RowCnt);
    	for(int j=2;j<=RowCnt;j++){
    		System.out.println("TollRowCnt J :"+j);
    		Proj_TollGate(rd.ReadMilestones(j),rd.ReadRYG(j),rd.ReadRemarks(j));
    	}
    	FindByCssSelector(ProjecttollgatElem.SUBMIT).click();
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.MODERATION_STATUS)));
    	Thread.sleep(1200);
    	String ActualSuccessMsg=FindByCssSelector(ProjecttollgatElem.MODERATION_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
    	if (!ExpProject.trim().equalsIgnoreCase("Deep Dive".trim())){
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ProjecttollgatElem.MODERATION_STATUS_TXT.toUpperCase().trim());
    	}
		
	}
	 
	
	public void Proj_TollGate(String KeyMiles, String RYG,String Remarks) throws Exception{
		
		TollGate( KeyMiles,  RYG, Remarks) ;
	}
	
	
	public LoginPage logout() throws InterruptedException{
		Logout();
		return new LoginPage();
	}
	
	public DashBoardPage NavDbPageFrmToll() throws InterruptedException{
		
			Thread.sleep(300);
			String currentUrl = page.driver.getCurrentUrl();
			System.out.println("currentUrl:(actual )"+currentUrl);
			
				
				currentUrl = CONFG.getProperty("URL_HOMEPAGE").replaceAll("home", "")+DashBoardElem.REGISTRATION;
				System.out.println("currentUrl:(in if )"+currentUrl);
				
				
			page.driver.navigate().to(currentUrl);
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CreateProjectElem.PROB_TXT)));
			
		
	
		
		return new DashBoardPage();
	}
	}

