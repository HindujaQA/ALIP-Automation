package com.alip.selenium.pages.tests;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.CreateProjectPage;
import com.alip.selenium.po.DashBoardPage;
import com.alip.selenium.po.LoginPage;
import com.alip.selenium.po.MyProjectsPage;
import com.alip.selenium.po.ProjectTollGate;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ReadData;

public class TestRegistration extends page{
	private DashBoardPage DbPage ;
	private CreateProjectPage CPPage;
	private ProjectTollGate tollPage;
	private MyProjectsPage MYPROJ;
	private static int RegCnt =0;
	ReadData rd= new ReadData();
	@BeforeTest 
	public DashBoardPage initDBPageBeforeTest() throws InterruptedException{
		if(DbPage == null){
			LoginPage home= new LoginPage();
			DbPage =home.Login(rd.ReadUserName(),rd.ReadPassword());
			//System.out.println("page title:"+dbPage.getTitle());
			if (page.driver.getTitle().trim().toUpperCase().contains("ACTION CONTROLLER")|| 
					page.driver.getTitle().trim().toUpperCase().contains("EXCEPTION CAUGHT")||
					page.driver.getTitle().trim().toUpperCase().contains("RPX 500 ERROR")){
				
				System.out.println("In 500 error loop");
				String ProjDashboard=DbPage.FindByCssSelector(DashBoardElem.HDR_PROJ_STATUS).getText().trim().toUpperCase();
				ProjDashboard=ProjDashboard.replaceAll("[^a-zA_Z]", "");
				String ExpProjDash=DashBoardElem.HDR_PROJ_STATUS_TXT.replaceAll("[^a-zA_Z]", "").trim().toUpperCase();
				Assert.assertTrue(ProjDashboard.contains(ExpProjDash));
				//Assert.assertEquals(ExpProjDash,ProjDashboard, "Not in ALIP Home Page");
			
			
			}else{
				System.out.println("In ALIP Home Page");
				String ProjDashboard=DbPage.FindByCssSelector(DashBoardElem.HDR_PROJ_STATUS).getText().trim().toUpperCase();
				ProjDashboard=ProjDashboard.replaceAll("[^a-zA-Z]", "");
				String ExpProjDash=DashBoardElem.HDR_PROJ_STATUS_TXT.replaceAll("[^a-zA-Z]", "").trim().toUpperCase();
				Assert.assertTrue(ProjDashboard.contains(ExpProjDash));
				}
		}
		return DbPage;

	} 
	
	
	@BeforeMethod 
	public CreateProjectPage initRegistrationPageBeforeTest() throws InterruptedException{
		if(DbPage == null){
			LoginPage home= new LoginPage();
			DbPage =home.Login(rd.ReadUserName(),rd.ReadPassword());
			//System.out.println("page title:"+dbPage.getTitle());
			if (page.driver.getTitle().trim().toUpperCase().contains("ACTION CONTROLLER")|| 
					page.driver.getTitle().trim().toUpperCase().contains("EXCEPTION CAUGHT")||
					page.driver.getTitle().trim().toUpperCase().contains("RPX 500 ERROR")){
				
				System.out.println("In 500 error loop");
				String ProjDashboard=DbPage.FindByCssSelector(DashBoardElem.HDR_PROJ_STATUS).getText().trim().toUpperCase();
				ProjDashboard=ProjDashboard.replaceAll("[^a-zA-Z]", "");
				String ExpProjDash=DashBoardElem.HDR_PROJ_STATUS_TXT.replaceAll("[^a-zA-Z]", "").trim().toUpperCase();
				Assert.assertTrue(ProjDashboard.contains(ExpProjDash));	
				}else{
				System.out.println("In ALIP Home Page");
				String ProjDashboard=DbPage.FindByCssSelector(DashBoardElem.HDR_PROJ_STATUS).getText().trim().toUpperCase();
				ProjDashboard=ProjDashboard.replaceAll("[^a-zA_Z]", "");
				String ExpProjDash=DashBoardElem.HDR_PROJ_STATUS_TXT.replaceAll("[^a-zA_Z]", "").trim().toUpperCase();
				Assert.assertTrue(ProjDashboard.contains(ExpProjDash));
			//	Assert.assertEquals(DashBoardElem.HDR_PROJ_STATUS_TXT.trim().toUpperCase(),DbPage.FindByCssSelector(DashBoardElem.HDR_PROJ_STATUS).getText().trim().toUpperCase(), "Not in ALIP Home Page");
				}
		}
		
			if(driver.findElements(By.xpath(CreateProjectElem.PROB_TXT)).isEmpty()){
			System.out.println("In before method");
			 RegCnt=DbPage.ReturnStageCnt("Registration");
			System.out.println("Before Test Start RegCnt"+RegCnt);
			 CPPage=DbPage.NavCreateProject(rd.ReadProjectType(2));
			 
		
			System.out.println("In Registration Page");
			
		}
		
		return CPPage;

	} 
	

	
	@Test (description = "Validate Save")
	public void SaveRegistration() throws Exception{
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		System.out.println("timeStamp :"+timeStamp);
		String ExpProjectName_1=rd.ReadProject_Name(2)+timeStamp;
		String ExpProjectName=ExpProjectName_1.replaceAll("[^A-za-z0-9]", "");
		tollPage =CPPage.CreateProjAPS(rd.ReadProjectType(2), ExpProjectName,"Save",2);
		Thread.sleep(1000);
		String ExpProjCode = CPPage.returnProjCode();
		System.out.println("ExpProjectCode :"+ExpProjCode);
		rd.SetPrjcode(2, ExpProjCode);
		//Project TollGate
		String ExpProjectCode=ExpProjCode;
		FindByCssSelector(DashBoardElem.LOGO).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.HDR_PROJ_STATUS)));
		int PostRegCnt=DbPage.ReturnStageCnt("Registration");
		System.out.println("Before Test Start RegCnt"+RegCnt+"After Registration CNT"+PostRegCnt);
		/*if(RegCnt==PostRegCnt){
			System.out.println("Count passed");
		}*/
		
		MYPROJ=DbPage.NavMyProj(ExpProjectCode);
		MYPROJ.SelectProjectStatus("Problem registration", ExpProjectCode, "DRAFT");
		
	}

}
