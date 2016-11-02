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
	public void filter(String ExpectedProjectCode,String Exep_Proj_Name,String Exep_Proj_Type){
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FiltersElem.FILTER_FORM)));
		List Tab_Row=page.driver.findElements(By.cssSelector(FiltersElem.RSLT_PJCT_CODE));
		int TabCnt=Tab_Row.size();
		for(int i=1;i<=TabCnt;i++){
		String Proj_Code=FindByCssSelector(FiltersElem.RSLT_PJCT_CODE_1+i+FiltersElem.RSLT_PJCT_CODE_2).getText().toUpperCase();
		if(Proj_Code.equalsIgnoreCase(ExpectedProjectCode)){
		String Proj_Name=FindByCssSelector(FiltersElem.RSLT_PJCT_NAME_1+i+FiltersElem.RSLT_PJCT_NAME_2).getText().toUpperCase();
		String Idea_No=FindByCssSelector(FiltersElem.TBL_IDEA_NO_1+i+FiltersElem.TBL_IDEA_NO_2).getText().toUpperCase();
		String Idea_Title=FindByCssSelector(FiltersElem.TBL_IDEA_TITLE_1+i+FiltersElem.TBL_IDEA_TITLE_2).getText().toUpperCase();
		//String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		Exep_Proj_Name=Exep_Proj_Name.toUpperCase().trim();
		Exep_Proj_Type=Exep_Proj_Type.toUpperCase().trim();
		Assert.assertEquals(Proj_Name, Exep_Proj_Name,"Project name is not equal");
		FindByCssSelector(FiltersElem.TBL_ACTION_1+i+FiltersElem.TBL_ACTION_2);
		}
		
		
		}
		
	}
	
public CampaignApprovalPage navToCampaignApprovalPage(String ExpCampaign, String ExpectedIdeaTitle,String Exep_Proj_Code) throws InterruptedException{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FiltersElem.FILTER_FORM)));
		SelectDropdown(FiltersElem.CAMPAIGN, ExpCampaign);
		Thread.sleep(300);
		
		List Tab_Row=page.driver.findElements(By.cssSelector(FiltersElem.SLT_TABLE));
		int TabCnt=Tab_Row.size();
		for(int i=1;i<=TabCnt;i++){
		String Idea_Title=FindByCssSelector(FiltersElem.SLT_ROW+i+FiltersElem.IDEA_TITLE).getText().toUpperCase();
		System.out.println("Idea_Title"+Idea_Title+" Exp Idea_Title "+ExpectedIdeaTitle);
		if(Idea_Title.equalsIgnoreCase(ExpectedIdeaTitle)){
		String Idea_Desc=FindByCssSelector(FiltersElem.SLT_ROW+i+FiltersElem.IDEA_DESC).getText().toUpperCase();
		String Idea_Owner=FindByCssSelector(FiltersElem.SLT_ROW+i+FiltersElem.IDEA_OWNER).getText().toUpperCase();
		String Idea_Status=FindByCssSelector(FiltersElem.SLT_ROW+i+FiltersElem.IDEA_STATUS).getText().toUpperCase();
		String ProjCode=FindByCssSelector(FiltersElem.CAMP_PROJ_CODE).getText().toUpperCase();
		
		Assert.assertEquals(ProjCode, Exep_Proj_Code,"Project CODE is not equal");
		FindByCssSelector(FiltersElem.SLT_ROW+i+FiltersElem.IDEA_ACTION).click();
		Thread.sleep(500);
		}
		
		
		}
		return new CampaignApprovalPage();
	}
	

}
