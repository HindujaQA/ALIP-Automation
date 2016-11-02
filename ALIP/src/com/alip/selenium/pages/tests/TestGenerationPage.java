package com.alip.selenium.pages.tests;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.AnalysisPage;
import com.alip.selenium.po.CreateProjectPage;
import com.alip.selenium.po.DashBoardPage;
import com.alip.selenium.po.GenerationPage;
import com.alip.selenium.po.IdeaListPage;
import com.alip.selenium.po.IdeaSignOffListPage;
import com.alip.selenium.po.IdeaSignOffPage;
import com.alip.selenium.po.LoginPage;
import com.alip.selenium.po.MyProjectsPage;
import com.alip.selenium.po.ObservationPage;
import com.alip.selenium.po.ObservationTollPage;
import com.alip.selenium.po.ProblemApprovalPage;
import com.alip.selenium.po.ProjectTollGate;
import com.alip.selenium.po.UnderImplementationPage;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.GenerationElem;
import com.alip.selenium.po.elements.ReadData;

public class TestGenerationPage extends page{
	private DashBoardPage DbPage ;
	private CreateProjectPage CPPage;
	private ProjectTollGate tollPage;
	private MyProjectsPage MYPROJ;
	private GenerationPage GP;
	private LoginPage home;
	private IdeaSignOffListPage signOffList;
	private IdeaSignOffPage IdeaSignOff;
	private ProblemApprovalPage PAP;
	private UnderImplementationPage UnderImplement;
	private IdeaListPage idea;
	ReadData rd= new ReadData();
	@BeforeTest 
	public DashBoardPage initDBPageBeforeTest() throws InterruptedException{
		if(DbPage == null){
			home= new LoginPage();
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
	public GenerationPage initRegistrationPageBeforeTest() throws InterruptedException{
		if(DbPage == null){
			home= new LoginPage();
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
		
			if(driver.findElements(By.cssSelector(GenerationElem.GEN_FORM)).isEmpty()){
			System.out.println("In before method");
			idea= DbPage.GenerationView(rd.ReadProjectCode(3));
			idea.navToGenPage("All Ideas","Idea generation", rd.ReadProjectCode(3));
			 
		
			System.out.println("In Generation Page");
			
		}
		
		return GP;

	} 
	
	
	@Test (description = "Validate IDEA Generation")
	public void ValidateIdeaGeneration() throws Exception{
		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		System.out.println("timeStamp :"+timeStamp);
		
	
	int rowCnt=testExcel.getRowCount("Registration");
	System.out.println("rowCnt :"+rowCnt);
	for (int i=3;i<=3;i++){
//	try{
		
	String ExpProjectType=rd.ReadProjectType(i);
	//String ExpProjectName=rd.ReadProject_Name(i);
	String ExpProjectName_1=rd.ReadProject_Name(i)+timeStamp;
	String ExpProjectName=ExpProjectName_1.replaceAll("[^A-za-z0-9]", "");
	String IdeaTitle_1="IdeaTitle"+timeStamp;
	String IdeaTitle=IdeaTitle_1.replaceAll("[^A-za-z0-9]", "");
	String TempName_1= rd.ReadImpl_TempName(2)+timeStamp;
	String TempName=TempName_1.replaceAll("[^A-za-z0-9]", "");
	
	/*LoginPage home= new LoginPage();
	DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
	page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));*/
	
	 CPPage=DbPage.NavCreateProject (ExpProjectType);
	page.getLoggerpass( "Logged into ALIP");	
	// Create Project
	 tollPage=CPPage.CreateProjAPS(ExpProjectType, ExpProjectName,"Submit",i);
	page.getLoggerpass( "Project  created");
	String ExpProjCode = CPPage.returnProjCode();
	System.out.println("ExpProjectCode :"+ExpProjCode);
	rd.SetPrjcode(i, ExpProjCode);
	//Project TollGate
	String ExpProjectCode=ExpProjCode;
	if(ExpProjectType.trim().equalsIgnoreCase("APS")){
		tollPage.CreatTollGate();
	page.getLoggerpass( "Project Toll Gate  created");	
		
	
	
	DbPage =CPPage.NavDashboardPage();
	  PAP=DbPage.NavSponsorApprovalByURL();
	 Thread.sleep(500);
	 
	 //String ExpProjectCode=rd.ReadProjectCode(i);
	// SponsorApproval
	 PAP.PendingApproval(ExpProjectCode,"pending for sponsor approval");
	
	 PAP.ModerationApproveAndReject("Approve", "Approved Reason");
	 page.getLoggerpass( "sponsor approval");	
	 home=PAP.PAPlogout();
	}else {
	// Logout
		
	 home=tollPage.logout();
	}
	 System.out.println("Projectownersysout ;"+rd.ReadPrjOwner(2).trim());
	 //Login as Project Approver
	 DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
	  page.getLoggerpass( "Login as Project Approver");	
	  PAP=DbPage.NavSponsorApprovalByURL();
	  PAP.PendingApproval(ExpProjectCode,"pending for approval/sponsor approved");
	  PAP.ModerationApproveAndReject("Approve", "Approved Reason");
	  page.getLoggerpass( " pending for approval/sponsor approved ");	
	// Logout
	 home=PAP.PAPlogout();
	// Login as member and View Project
	 DbPage=home.Login(rd.ReadUserName(),rd.ReadPassword());
	 page.getLoggerpass( "Login as Member");	
	 //view Registered Project
	
	 tollPage=DbPage.RegistrationView(ExpProjectCode);
	 page.getLoggerpass( "RegistrationView");	
	 //Tollgate to Observation
	 
	 ObservationPage OBS=tollPage.NavRegistrationViewToObservation();
	 
	 OBS.CreateObserv(ExpProjectCode, ExpProjectName, ExpProjectType);;
	 page.getLoggerpass( "Create Observation");
	 //navigation to observation Toll Page
	 ObservationTollPage OTP=new ObservationTollPage();
	 //navigation to Analysis 
	 AnalysisPage AP=OTP.CreatTollGate();
	 page.getLoggerpass( "Create Observation Toll gate");
	//navigation to Generation  
	GenerationPage GP= AP.CreateAnalysis(ExpProjectCode, ExpProjectName, ExpProjectType);
	 page.getLoggerpass( "Create Analysis ");
	String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType,IdeaTitle);
	System.out.println("IdeaNo :"+IdeaNo);
	
	
	}
	}
}
