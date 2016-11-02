package com.alip.selenium.po;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.IdeaListElem;
import com.alip.selenium.po.elements.IdeaSignOffListElem;

public class IdeaListPage extends page {
	
	public GenerationPage navToGenPage(String FilterBy,String IdeaStage, String expProjectCode) throws InterruptedException{
		Thread.sleep(300);
		
		/*SelectDropdown(IdeaListElem.FLTR_BY, FilterBy);
		SelectDropdown(IdeaListElem.IDEA_STG, IdeaStage);
		SelectDropdown(IdeaListElem.PJCT_CODE, expProjectCode);
		
		FindByCssSelector(IdeaListElem.FLTR_BTN).click();*/
		Thread.sleep(1000);
		List Tab_Row=page.driver.findElements(By.cssSelector(IdeaListElem.TBL_PJCT_CODE));
		int TabCnt=Tab_Row.size();
		System.out.println("TabCnt :"+TabCnt);
		for(int i=1;i<=TabCnt;i++){
		String Proj_Code=FindByCssSelector(IdeaListElem.TBL_PJCT_CODE_1+i+IdeaListElem.TBL_PJCT_CODE_2).getText().toUpperCase().trim();
		String Idea_No=FindByCssSelector(IdeaListElem.TBL_IDEA_NO_1+i+IdeaListElem.TBL_IDEA_NO_2).getText().toUpperCase().trim();
		System.out.println(Proj_Code+" equals"+expProjectCode.toUpperCase().trim());
		//System.out.println(Idea_No+" equals "+ExpIdeaNo.toUpperCase().trim());
			if(Proj_Code.equalsIgnoreCase(expProjectCode.toUpperCase().trim())){
			
			String Idea_Title=FindByCssSelector(IdeaListElem.TBL_IDEA_TITLE_1+i+IdeaListElem.TBL_IDEA_TITLE_2).getText().toUpperCase();
			
			FindByCssSelector(IdeaListElem.TBL_ACTION_1+i+IdeaListElem.TBL_ACTION_2).click();
		
		
			}
		}
		return new GenerationPage();

	}
}
