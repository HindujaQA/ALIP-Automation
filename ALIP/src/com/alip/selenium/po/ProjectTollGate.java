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
	
	public void CreatTollGate() throws Exception{
		int RowCnt=testExcel.getRowCount("Toll");
    	System.out.println("TollRowCnt :"+RowCnt);
    	for(int j=2;j<=RowCnt;j++){
    		System.out.println("TollRowCnt J :"+j);
    		TollGate(rd.ReadMilestones(j),rd.ReadRYG(j),rd.ReadRemarks(j));
    	}
    	FindByCssSelector(ProjecttollgatElem.SUBMIT).click();
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.MODERATION_STATUS)));
    	Thread.sleep(1000);
    	String ActualSuccessMsg=FindByCssSelector(ProjecttollgatElem.MODERATION_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ProjecttollgatElem.MODERATION_STATUS_TXT.toUpperCase().trim());
    	
		
	}
	 
	public void TollGate(String KeyMiles, String RYG,String Remarks) throws Exception{
	/*	int RowCnt=testExcel.getRowCount("Role");
    	System.out.println("RowCnt :"+RowCnt);*/
		
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjecttollgatElem.TABLE)));
		List tableRow=page.driver.findElements(By.cssSelector(ProjecttollgatElem.TABLE_SNO));
		int tableRowCnt=tableRow.size();
		System.out.println("tableRowCnt "+tableRowCnt);
		for(int i=1;i<=tableRowCnt;i++){
			String actualKeyMiles=FindByCssSelector(ProjecttollgatElem.TABLE_KMILESTONE_1+i+ProjecttollgatElem.TABLE_KMILESTONE_2).getText();
			actualKeyMiles=actualKeyMiles.replaceAll("[^A-Za-z1-9]", "").toUpperCase().trim();
			KeyMiles=KeyMiles.replaceAll("[^A-Za-z1-9]", "").toUpperCase();
			System.out.println("Expected KeyMiles "+KeyMiles+" Actual "+actualKeyMiles);
			if (KeyMiles.equalsIgnoreCase(actualKeyMiles)){
				RYG=RYG.toUpperCase();
				switch (RYG) {
				
				case "RED":
					
					FindByCssSelector(ProjecttollgatElem.TABLE_RYG_STATUS_1+i+ProjecttollgatElem.TABLE_RYG_STATUS_RED).click();
					FindByCssSelector(ProjecttollgatElem.TABLE_REMARKS_1+i+ProjecttollgatElem.TABLE_REMARKS_2).sendKeys(Remarks);
					break;
				case "YELLOW":
					FindByCssSelector(ProjecttollgatElem.TABLE_RYG_STATUS_1+i+ProjecttollgatElem.TABLE_RYG_STATUS_YELLOW).click();
					FindByCssSelector(ProjecttollgatElem.TABLE_REMARKS_1+i+ProjecttollgatElem.TABLE_REMARKS_2).sendKeys(Remarks);
					break;
				case "GREEN":
					FindByCssSelector(ProjecttollgatElem.TABLE_RYG_STATUS_1+i+ProjecttollgatElem.TABLE_RYG_STATUS_GREEN).click();
					FindByCssSelector(ProjecttollgatElem.TABLE_REMARKS_1+i+ProjecttollgatElem.TABLE_REMARKS_2).sendKeys(Remarks);
					break;

				default:
					break;
				}
				break;
				
			}
		}
    	}
	}

