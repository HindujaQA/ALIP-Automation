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
public void NavTollToRegisteration() {
		
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.MODERATION_STATUS)));
       	String ActualSuccessMsg=FindByCssSelector(ProjecttollgatElem.MODERATION_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ProjecttollgatElem.MODERATION_APPROVED_TXT.toUpperCase().trim());
		FindByCssSelector(ProjecttollgatElem.PREV).click();
		
		}
	
	public void CreatTollGate() throws Exception{
		int RowCnt=testExcel.getRowCount("Toll");
    	System.out.println("TollRowCnt :"+RowCnt);
    	for(int j=2;j<=RowCnt;j++){
    		System.out.println("TollRowCnt J :"+j);
    		Proj_TollGate(rd.ReadMilestones(j),rd.ReadRYG(j),rd.ReadRemarks(j));
    	}
    	FindByCssSelector(ProjecttollgatElem.SUBMIT).click();
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.MODERATION_STATUS)));
    	Thread.sleep(1000);
    	String ActualSuccessMsg=FindByCssSelector(ProjecttollgatElem.MODERATION_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ProjecttollgatElem.MODERATION_STATUS_TXT.toUpperCase().trim());
    	
		
	}
	 
	public void Proj_TollGate(String KeyMiles, String RYG,String Remarks) throws Exception{
		
		TollGate( KeyMiles,  RYG, Remarks) ;
	}
	}

