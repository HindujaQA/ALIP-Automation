package com.alip.selenium.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.FiltersElem;
import com.alip.selenium.po.elements.IdeaSignOffListElem;

public class IdeaSignOffListPage extends page {
	
	public IdeaSignOffPage SelectAndActionFromGO (String ExpProjectCode, String ExpStatus) throws InterruptedException{

	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(IdeaSignOffListElem.IDEA_TITLE)));
	FindByCssSelector(IdeaSignOffListElem.PJCT_CODE).sendKeys(ExpProjectCode);
	selectOptionFromDropDown(IdeaSignOffListElem.STATUS, ExpStatus);
	FindByCssSelector(IdeaSignOffListElem.FILTER).click();
	Thread.sleep(1000);
	List Tab_Row=page.driver.findElements(By.cssSelector(IdeaSignOffListElem.TBL_PJCT_CODE));
	int TabCnt=Tab_Row.size();
	System.out.println("TabCnt :"+TabCnt);
	for(int i=1;i<=TabCnt;i++){
	String Proj_Code=FindByCssSelector(IdeaSignOffListElem.TBL_PJCT_CODE_1+i+IdeaSignOffListElem.TBL_PJCT_CODE_2).getText().toUpperCase().trim();
	String Idea_No=FindByCssSelector(IdeaSignOffListElem.TBL_IDEA_NO_1+i+IdeaSignOffListElem.TBL_IDEA_NO_2).getText().toUpperCase().trim();
	System.out.println(Proj_Code+" equals"+ExpProjectCode.toUpperCase().trim());
	//System.out.println(Idea_No+" equals "+ExpIdeaNo.toUpperCase().trim());
		if(Proj_Code.equalsIgnoreCase(ExpProjectCode.toUpperCase().trim())){
		String Status=FindByCssSelector(IdeaSignOffListElem.TBL_STATUS_1+i+IdeaSignOffListElem.TBL_STATUS_2).getText().toUpperCase().trim();
		String ActIdea_No=FindByCssSelector(IdeaSignOffListElem.TBL_IDEA_NO_1+i+IdeaSignOffListElem.TBL_IDEA_NO_2).getText().toUpperCase();
		String Idea_Title=FindByCssSelector(IdeaSignOffListElem.TBL_IDEA_TITLE_1+i+IdeaSignOffListElem.TBL_IDEA_TITLE_2).getText().toUpperCase();
		//String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		
		Assert.assertEquals(Status, ExpStatus.toUpperCase().trim(),"ExpStatus is not equal");
		FindByCssSelector(IdeaSignOffListElem.TBL_ACTION_1+i+IdeaSignOffListElem.TBL_ACTION_2).click();
		}
	
	
	}
	
	return new IdeaSignOffPage();
	}
}
