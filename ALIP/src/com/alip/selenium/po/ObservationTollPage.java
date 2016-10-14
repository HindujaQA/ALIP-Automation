package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.ObservationTollElem;
import com.alip.selenium.po.elements.ProjecttollgatElem;
import com.alip.selenium.po.elements.ReadData;

public class ObservationTollPage extends page{
	ReadData rd= new ReadData();
	public AnalysisPage CreatTollGate() throws Exception{
		int RowCnt=testExcel.getRowCount("Toll");
    	System.out.println("TollRowCnt :"+RowCnt);
    	for(int j=2;j<=RowCnt;j++){
    		System.out.println("TollRowCnt J :"+j);
    		OBS_TollGate(rd.ReadOBS_Milestones(j),rd.ReadOBS_RYG(j),rd.ReadOBS_Remarks(j));
    	}
    	FindByCssSelector(ObservationTollElem.SUBMIT).click();
    	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ObservationTollElem.SUBMIT_STATUS)));
    	//Thread.sleep(1000);
    	String ActualSuccessMsg=FindByCssSelector(ObservationTollElem.SUBMIT_STATUS).getText();
    	System.out.println("ActualSuccessMsg :"+ActualSuccessMsg);
		Assert.assertEquals(ActualSuccessMsg.toUpperCase().trim(), ObservationTollElem.SUBMIT_STATUS_TXT.toUpperCase().trim());
		FindByCssSelector(ObservationTollElem.NEXT).click();
    	Thread.sleep(1000);
		return new AnalysisPage();
	}
	
	public void OBS_TollGate(String KeyMiles, String RYG,String Remarks) throws Exception{
		 
		 TollGate( KeyMiles,  RYG,Remarks) ;
	}

}
