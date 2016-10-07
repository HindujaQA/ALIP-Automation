package com.alip.selenium.pages.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




import com.alip.selenium.basePage.page;



public class initializeStop {
	

	private page emptyPage = null;
	
	@BeforeSuite
	public page initBrowser(){
		
		emptyPage = new page();
		
		return emptyPage;
	}
	
	@AfterSuite
	 public void stop(){
		
		page.driver.close();
		 
	 }
	
}
