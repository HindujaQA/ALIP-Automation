package com.alip.selenium.po;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.MyProjectsElem;

public class MyProjectsPage extends page  {
	
	
	public void SelectProjectStatus(String Stage, String ExpPrjCode, String Status) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MyProjectsElem.MYPROJECT_HDR)));
		Thread.sleep(500);
		SelectDropdown(MyProjectsElem.PROJECT_STAGE, Stage);
		Thread.sleep(500);
		List Tab_Row=driver.findElements(By.cssSelector(MyProjectsElem.MYPROJECT_TBL));
		int TabCnt=Tab_Row.size();
		System.out.println("TabCount :"+TabCnt);
		for(int i=1;i<=TabCnt;i++){
			System.out.println("i "+i);
			String ProjectCode=FindByCssSelector(MyProjectsElem.MYPROJECT_TBL_1+i+MyProjectsElem.TBL_PROJCODE).getText().trim();
			System.out.println("ProjectCode :"+ProjectCode+ " ExpPrjCode :"+ExpPrjCode);
			if (ProjectCode.equals(ExpPrjCode)){
				String ProjectName=FindByCssSelector(MyProjectsElem.MYPROJECT_TBL_1+i+MyProjectsElem.TBL_PROJNAME).getText().trim();
				String ProjectStatus=FindByCssSelector(MyProjectsElem.MYPROJECT_TBL_1+i+MyProjectsElem.TBL_STATUS).getText();
				System.out.println("ProjectName :"+ProjectName+" Project Code:"+ProjectCode+ " ProjStatus:"+ProjectStatus);
				Assert.assertEquals(ProjectStatus.trim().toUpperCase(), Status.trim().toUpperCase());
				break;
			}
			
		}
	}
	
	public LoginPage logout() throws InterruptedException{
		Logout();
		return new LoginPage();
	}

}
