package com.alip.selenium.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.FiltersElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ReadData;

public class FiltersPage extends page{
	ReadData rd= new ReadData();
	public void filter(String ExpectedProjectCode){
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FiltersElem.FILTER_FORM)));
		List Tab_Row=page.driver.findElements(By.cssSelector(FiltersElem.RSLT_PJCT_CODE));
		int TabCnt=Tab_Row.size();
		for(int i=0;i<=TabCnt;i++){
		String Proj_Code=FindByCssSelector(FiltersElem.RSLT_PJCT_CODE_1+i+FiltersElem.RSLT_PJCT_CODE_2).getText().toUpperCase();
		if(Proj_Code.equalsIgnoreCase(ExpectedProjectCode)){
		String Proj_Name=FindByCssSelector(FiltersElem.RSLT_PJCT_NAME_1+i+FiltersElem.RSLT_PJCT_NAME_2).getText().toUpperCase();
		String Idea_No=FindByCssSelector(FiltersElem.TBL_IDEA_NO_1+i+FiltersElem.TBL_IDEA_NO_2).getText().toUpperCase();
		String Idea_Title=FindByCssSelector(FiltersElem.TBL_IDEA_TITLE_1+i+FiltersElem.TBL_IDEA_TITLE_2).getText().toUpperCase();
		//String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		String Exep_Proj_Name=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Type=rd.ReadProjectType().toUpperCase().trim();
		Assert.assertEquals(Proj_Name, Exep_Proj_Name,"Project name is not equal");
		FindByCssSelector(FiltersElem.TBL_ACTION_1+i+FiltersElem.TBL_ACTION_2);
		}
		
		
		}
		
	}

}
