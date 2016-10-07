package com.alip.selenium.pages.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.*;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.LoginElem;
import com.alip.selenium.po.elements.ReadData;
import com.alip.selenium.util.TestUtil;

import org.testng.SkipException;

public class TestLogin {
	ReadData rd= new ReadData();
	
	@Test (description = "Login ")
	public void checkLogin() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
		
		
		
	
	}
}