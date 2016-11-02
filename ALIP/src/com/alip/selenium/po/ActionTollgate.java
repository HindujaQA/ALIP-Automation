package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.ActionTollgateElem;

import com.alip.selenium.po.elements.ReadData;

public class ActionTollgate extends page {
	ReadData rd= new ReadData();
	
	public void CreatTollGate() throws Exception{
		int RowCnt=testExcel.getRowCount("Toll");
    	System.out.println("TollRowCnt :"+RowCnt);
    	for(int j=2;j<=RowCnt;j++){
    		System.out.println("TollRowCnt J :"+j);
    		Action_TollGate(rd.ReadAct_Milestones(j),rd.ReadAct_RYG(j),rd.ReadAct_Remarks(j));
    	}
    	FindByCssSelector(ActionTollgateElem.SUBMIT).click();
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ActionTollgateElem.SUBMIT_STATUS)));
    	//Thread.sleep(1000);
    	String ActualSuccessMsg=FindByCssSelector(ActionTollgateElem.SUBMIT_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ActionTollgateElem.SUBMIT_STATUS_TXT.toUpperCase().trim());
		FindByCssSelector(ActionTollgateElem.NEXT).click();
    	Thread.sleep(1000);
	
	}
	
	public void Action_TollGate(String KeyMiles, String RYG,String Remarks) throws Exception{
		 
		 TollGate( KeyMiles,  RYG,Remarks) ;
	}

}
