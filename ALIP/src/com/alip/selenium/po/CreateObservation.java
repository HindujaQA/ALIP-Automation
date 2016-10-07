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
import com.alip.selenium.po.elements.ReadData;

public class CreateObservation extends page {
	private static final CharSequence Char = null;
	ReadData rd= new ReadData();
	
	
	
	
	
	
	 
	public void CreateObserv() throws Exception
	{
		txtbox(ObservationProjectElem.Observ_Desc, "Observation description 1234 !@#$#$");
		SelectDateFrmCalender(ObservationProjectElem.Observ_Act_St_date,"25");
		SelectDateFrmCalender(ObservationProjectElem.Observ_Act_end_date, "27");
		
		String []drpDownExep_Val={rd.ReadQC_Tools()};
        SelectandCheckFrmDrp(ObservationProjectElem.Observ_QC_Tools, ObservationProjectElem.Observ_QC_Tools_btn, drpDownExep_Val, ObservationProjectElem.Observ_QC_TOOL_DRPDWN_1, ObservationProjectElem.Observ_QC_TOOL_LIST_CHK);
		
	}

}
