
package com.alip.selenium.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.LoginElem;
import com.alip.selenium.po.elements.ReadData;




public class LoginPage extends page {
	ReadData rd= new ReadData();
	
	
	
	public LoginPage (){
		driver.get(CONFG.getProperty("URL_HOMEPAGE"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		 
	}
	
	
	public DashBoardPage  Login(String USERNAME, String Password) throws InterruptedException{
		
			FindById(LoginElem.USERNAME).clear();
			FindById(LoginElem.USERNAME).sendKeys(USERNAME);
		
			FindById(LoginElem.PASSWORD).clear();
			FindById(LoginElem.PASSWORD).sendKeys(Password);

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);	
		 		 
		 FindById(LoginElem.LOGINBTN).click();
		 page.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".sessions-page")));
		 Thread.sleep(1000);
		 return new DashBoardPage();
		
	 }

	
	public void LoginInvalidCredentials() {
		
		FindById(LoginElem.USERNAME).clear();
		 FindById(LoginElem.USERNAME).sendKeys(CONFG.getProperty("INV_USER_EMAIL"));
		 FindById(LoginElem.PASSWORD).clear();
		 FindById(LoginElem.PASSWORD).sendKeys(CONFG.getProperty("INV_USER_PASS_CODE"));

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);	
		 		 
		 FindById(LoginElem.LOGINBTN).click();
		 page.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".sessions-page")));

	}
	
	public DashBoardPage  Login(String Sheet,int Row, String UserColName, String PasswordColName){
		//ReadExcel Excel =new ReadExcel;
		
		FindById(LoginElem.USERNAME).clear();
		 //FindById(ElemProp.UserName).sendKeys(CONFG.getProperty("USER_EMAIL"));
		FindById(LoginElem.USERNAME).sendKeys(page.testExcel.getStringCellData(Sheet,Row,UserColName));
		 
		 FindById(LoginElem.PASSWORD).clear();
		 FindById(LoginElem.PASSWORD).sendKeys(page.testExcel.getStringCellData(Sheet, Row,PasswordColName));
		// FindById(ElemProp.Password).sendKeys(CONFG.getProperty("USER_PASS_CODE"));

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);	
		 		 
		 FindById(LoginElem.LOGINBTN).click();
		 page.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".sessions-page")));
		 return new DashBoardPage();
		
	 }

	


}

