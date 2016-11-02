package com.alip.selenium.pages.tests;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.ActionTollgate;
import com.alip.selenium.po.AnalysisPage;
import com.alip.selenium.po.CampaignApprovalPage;
import com.alip.selenium.po.CampaignPage;
import com.alip.selenium.po.CompletionListPage;
import com.alip.selenium.po.CreateProjectPage;
import com.alip.selenium.po.CrowdSourcingPage;
import com.alip.selenium.po.DashBoardPage;
import com.alip.selenium.po.EvaluationPage;
import com.alip.selenium.po.FiltersPage;
import com.alip.selenium.po.GenerationPage;
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
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ProjecttollgatElem;
import com.alip.selenium.po.elements.ReadData;

public class TestWorkflow extends page {
	ReadData rd= new ReadData();
 
	private DashBoardPage DbPage ;
	private CreateProjectPage CPPage;
	private ProjectTollGate tollPage;
	private MyProjectsPage MYPROJ;
	private LoginPage home;
	private IdeaSignOffListPage signOffList;
	private IdeaSignOffPage IdeaSignOff;
	private ProblemApprovalPage PAP;
	private UnderImplementationPage UnderImplement;
	private CampaignPage Camp;
	private GenerationPage GP;
	private CrowdSourcingPage Crowd;
	private static int RegCnt =0;
	
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
	public DashBoardPage initRegistrationPageBeforeTest() throws InterruptedException{
		System.out.println("BeforeMethod ");
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
				ProjDashboard=ProjDashboard.replaceAll("[^a-zA-Z]", "");
				String ExpProjDash=DashBoardElem.HDR_PROJ_STATUS_TXT.replaceAll("[^a-zA-Z]", "").trim().toUpperCase();
				System.out.println("ProjDashboard: "+ProjDashboard+" ExpProjDash: "+ExpProjDash);
				Assert.assertTrue(ProjDashboard.contains(ExpProjDash));
			//	Assert.assertEquals(DashBoardElem.HDR_PROJ_STATUS_TXT.trim().toUpperCase(),DbPage.FindByCssSelector(DashBoardElem.HDR_PROJ_STATUS).getText().trim().toUpperCase(), "Not in ALIP Home Page");
				}
		}
		
			
			 
		
			System.out.println("In DashBoard Page");
			
		
		
		return DbPage ;

	} 
	
	@AfterMethod
	public LoginPage LogoutAfterTest() throws InterruptedException{
		System.out.println("AfterMethod ");
		if(home != null){
			NavLoginPageByUrl() ;
			DbPage=null;
			
		}
		
			
			 
		
			System.out.println("In Login Page");
			
		
		
		return home ;

	} 
	
	
	
	@Test (description = "Validating Creation of APS Project (all Steps Covered) ")
	public void APSCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		System.out.println("timeStamp :"+timeStamp);
		
		//Login 
		int rowCnt=testExcel.getRowCount("Registration");
		System.out.println("rowCnt :"+rowCnt);
		int i=2;
		//for (int i=2;i<=3;i++){
	//	try{
			
		String ExpProjectType=rd.ReadProjectType(i);
		String ExpProjectName_1=rd.ReadProject_Name(i)+timeStamp;
		String ExpProjectName=ExpProjectName_1.replaceAll("[^A-za-z0-9]", "");
		String IdeaTitle_1="IdeaTitle"+timeStamp;
		String IdeaTitle=IdeaTitle_1.replaceAll("[^A-za-z0-9]", "");
		String TempName_1= rd.ReadImpl_TempName(2)+timeStamp;
		String TempName=TempName_1.replaceAll("[^A-za-z0-9]", "");
/*		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));*/
		
		 CPPage=DbPage.NavCreateProject (ExpProjectType);
		page.getLoggerpass( "Logged into ALIP");	
		// Create Project
		 tollPage=CPPage.CreateProjAPS(ExpProjectType, ExpProjectName,"submit",i);
		String ExpProjCode = CPPage.returnProjCode();
		System.out.println("ExpProjectCode :"+ExpProjCode);
		rd.SetPrjcode(i, ExpProjCode);
		
		page.getLoggerpass( "Project  created");
		
		tollPage.CreatTollGate(ExpProjectType);
		page.getLoggerpass( "Project Toll Gate  created");	
		DbPage =CPPage.NavDashboardPage();
		 PAP=DbPage.NavSponsorApprovalByURL();
		 Thread.sleep(500);
		  
		 String ExpProjectCode=ExpProjCode;
		// SponsorApproval
		 PAP.PendingApproval(ExpProjectCode,"pending for sponsor approval");
		
		 PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		 page.getLoggerpass( "sponsor approval");	
		// Logout
		 home=PAP.PAPlogout();
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
		 DbPage =home.Login(rd.ReadUserName(),rd.ReadPassword());
		 page.getLoggerpass( "Login as Member");	
		 //view Registered Project
		
		 tollPage=DbPage.RegistrationView(ExpProjectCode);
		 page.getLoggerpass( "RegistrationView");	
		 //Tollgate to Observation
		 
		 ObservationPage OBS=tollPage.NavTollToObservation();
		 
		 OBS.CreateObserv(ExpProjectCode, ExpProjectName, ExpProjectType);;
		 page.getLoggerpass( "Create Observation");
		 //navigation to observation Toll Page
		 ObservationTollPage OTP=new ObservationTollPage();
		 //navigation to Analysis 
		 AnalysisPage AP=OTP.CreatTollGate();
		 page.getLoggerpass( "Create Observation Toll gate");
		//navigation to Generation  
		GP= AP.CreateAnalysis(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Analysis ");
			String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType,IdeaTitle);
			System.out.println("IdeaNo :"+IdeaNo);
		 //navigation to Evaluation
		EvaluationPage EP= GP.NavtoEvaluationPage();
		 page.getLoggerpass( "Create Generation ");
		 DbPage=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Evaluation ");
		//Navigation to Idea Signoff page
		signOffList=DbPage.NavIdeaSignOffListByURL();
		//Navigating To Idea SignOff Page
		
		Thread.sleep(500);
		System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
		IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
		 page.getLoggerpass( "SelectAndAction GO ");
		home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
		
		
		// Login as second member and View Project
		DbPage =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
		page.getLoggerpass( "Login as second member and View Project ");
		//Navigation to Idea Signoff page
		 	signOffList=DbPage.NavIdeaSignOffListByURL();	
		 	Thread.sleep(500);
			System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
			IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode, rd.ReadIdea_ExpStatus(2));
			home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
			 page.getLoggerpass( "Approve Idea SignOff ");
			 
			 //Log in 
			 DbPage=home.Login(rd.ReadUserName(),rd.ReadPassword());
			//Under Implementation
			UnderImplement=DbPage.NavUnderImplement(ExpProjectCode);
			 page.getLoggerpass( "Nav Under Implemention ");
			UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),IdeaTitle,ExpProjectCode, ExpProjectName, ExpProjectType);
			page.getLoggerpass( "Under Implemention Template Valdation ");
			home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
					rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
					rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), TempName);
			page.getLoggerpass( "Under Implemention Template Creation ");
			// Login as Completion Approver and View Project
			DbPage=home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
			page.getLoggerpass( "Logged in as Team Member");
			CompletionListPage CLP=DbPage.NavCompletionListPage(ExpProjectCode);
			ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
			page.getLoggerpass( "Completion List Submission");
			ATG.CreatTollGate();
			page.getLoggerpass( "Action Toll Completed");
			//Logout();
			
		/*}catch(Exception e){
			String ExpProjectType=rd.ReadProjectType(i);
			System.out.println(ExpProjectType+"is  completed with error");
		  }  */
				
			}
	//	}
	
	
	
	
	//-------------------------------------------------------------------------------------------------
	
	@Test (description = "Validating Creation of BPS  Project (Except ProblemToll gate and Sponsor Approval) ")
	public void BPSCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		//Login 
		
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
			tollPage.CreatTollGate(ExpProjectType);
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
		GP= AP.CreateAnalysis(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Analysis ");
		String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType,IdeaTitle);
		System.out.println("IdeaNo :"+IdeaNo);
		 //navigation to Evaluation
		EvaluationPage EP= GP.NavtoEvaluationPage();
		 page.getLoggerpass( "Create Generation ");
		 DbPage=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Evaluation ");
		//Navigation to Idea Signoff page
		signOffList=DbPage.NavIdeaSignOffListByURL();
		//Navigating To Idea SignOff Page
		
		Thread.sleep(500);
		System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
		IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
		 page.getLoggerpass( "SelectAndAction GO ");
		home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
		
		
		// Login as second member and View Project
		DbPage =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
		page.getLoggerpass( "Login as second member and View Project ");
		//Navigation to Idea Signoff page
		 	signOffList=DbPage.NavIdeaSignOffListByURL();	
		 	Thread.sleep(500);
			System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
			IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode, rd.ReadIdea_ExpStatus(2));
			home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
			 page.getLoggerpass( "Approve Idea SignOff ");
			 
			 //Log in 
			 DbPage=home.Login(rd.ReadUserName(),rd.ReadPassword());
			//Under Implementation
			 UnderImplement=DbPage.NavUnderImplement(ExpProjectCode);
			 page.getLoggerpass( "Nav Under Implemention ");
			UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),IdeaTitle,ExpProjectCode, ExpProjectName, ExpProjectType);
			page.getLoggerpass( "Under Implemention Template Valdation ");
			home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
					rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
					rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), TempName);
			page.getLoggerpass( "Under Implemention Template Creation ");
			// Login as Completion Approver and View Project
			DbPage =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
			page.getLoggerpass( "Logged in as Team Member");
			CompletionListPage CLP=DbPage.NavCompletionListPage(ExpProjectCode);
			ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
			page.getLoggerpass( "Completion List Submission");
			ATG.CreatTollGate();
			page.getLoggerpass( "Action Toll Completed");
			//Logout();
			
		/*}catch(Exception e){
			String ExpProjectType=rd.ReadProjectType(i);
			System.out.println(ExpProjectType+"is  completed with error");
		  }  */
				
			}
		}
		 
	
	
	//-------------------------------------------------------------------------------------------------
	
	@Test (description = "Validating Creation of Aspire Project (Campaign Included) ")
	public void AspireCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
System.out.println("timeStamp :"+timeStamp);
		//Login 
		
		
		
		 
		
		int rowCnt=testExcel.getRowCount("Registration");
		System.out.println("rowCnt :"+rowCnt);
		for (int i=4;i<=4;i++){
	//	try{
			
		String ExpProjectType=rd.ReadProjectType(i);
		String ExpProjectName_1=rd.ReadProject_Name(i)+timeStamp;
		String ExpProjectName=ExpProjectName_1.replaceAll("[^A-za-z0-9]", "");
		System.out.println(ExpProjectName);
		String TempName_1= rd.ReadImpl_TempName(2)+timeStamp;
		String TempName=TempName_1.replaceAll("[^A-za-z0-9]", "");
		
		/*LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
		*/
		 CPPage=DbPage.NavCreateProject (ExpProjectType);
		page.getLoggerpass( "Logged into ALIP");	
		// Create Project
		 tollPage=CPPage.CreateProjAPS(ExpProjectType, ExpProjectName,"Submit",i);
		page.getLoggerpass( "Project  created");
		String ExpProjCode = CPPage.returnProjCode();
		System.out.println("ExpProjectCode :"+ExpProjCode);
		rd.SetPrjcode(i, ExpProjCode);
		//Logout
		String ExpProjectCode=ExpProjCode;
		
		 home=tollPage.logout();
		 
			
		 System.out.println("ProjectMember ;"+rd.ReadPrjOwner(2).trim());
		 //Login as Member to create Campaign
		 DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
		  page.getLoggerpass( "Login as Project Approver");	
		  Camp=DbPage.NavCampaignPageByUrl();
		  String Campaign_1="Campaign"+timeStamp;
		  String Campaign=Campaign_1.replaceAll("[^A-za-z0-9]", "");
		  String IdeaTitle_1="IdeaTitle"+timeStamp;
		  String IdeaTitle=IdeaTitle_1.replaceAll("[^A-za-z0-9]", "");
		  System.out.println(Campaign);
		  Camp.CreateCampaign(ExpProjectName, Campaign, "Objective","1", "30", "Submit");
		  home=Camp.logout();
		  
		  System.out.println("ProjectMember ;"+rd.ReadPrjOwner(2).trim());
		//Login as Member to create Campaign Crowd Sourcing 
		  DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
			  page.getLoggerpass( "Login as Project Approver");	
			  Crowd=DbPage.NavCrowdPage(Campaign);
			  Crowd.CreateCrowdSourcing(Campaign, ExpProjectName, ExpProjCode, IdeaTitle, "Design", "IdeaDesc", "CurrentMethod", "Add_Info", "K010", "K01", "0", "2", "1", "1", "INTANGIBLE_BENEFITS", "Submit");
			  DbPage=Crowd.NavtoDashboardPage();
			FiltersPage FP=DbPage.OutPutViewCampaign(ExpProjCode,Campaign, DashBoardElem.CAMPAIGN_ICON);
			CampaignApprovalPage CAP=FP.navToCampaignApprovalPage(Campaign, IdeaTitle, ExpProjCode);
			 GP=CAP.ApproveCampaign("Approve", "Comment Approved");
			
			  

		String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType,IdeaTitle);
		System.out.println("IdeaNo :"+IdeaNo);
		 //navigation to Evaluation
		EvaluationPage EP= GP.NavtoEvaluationPage();
		 page.getLoggerpass( "Create Generation ");
		 DbPage=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
		home=DbPage.NavLoginPageByUrl();
		 page.getLoggerpass( "Create Evaluation ");
		
		
		//Login as Approver
		int RowCnt=testExcel.getRowCount("Eval_EmpSeq");
    	System.out.println("RowCnt :"+RowCnt);
    	
    	for(int r=2;r<=RowCnt;r++){
    		DbPage =home.Login(rd.ReadEval_Emp_name(r),rd.ReadPassword());
		//Navigation to Idea Signoff page
		signOffList=DbPage.NavIdeaSignOffListByURL();
		//Navigating To Idea SignOff Page
    	
		Thread.sleep(500);
		System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
		 IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
		 page.getLoggerpass( "SelectAndAction GO ");
		home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
		
    	}
		
		
			 
			 //Log in 
			DbPage=home.Login(rd.ReadUserName(),rd.ReadPassword());
			//Under Implementation
			 UnderImplement=DbPage.NavUnderImplement(ExpProjectCode);
			 page.getLoggerpass( "Nav Under Implemention ");
			UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),IdeaTitle,ExpProjectCode, ExpProjectName, ExpProjectType);
			page.getLoggerpass( "Under Implemention Template Valdation ");
			home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
					rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
					rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), TempName);
			page.getLoggerpass( "Under Implemention Template Creation ");
			// Login as Completion Approver and View Project
			DbPage =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
			page.getLoggerpass( "Logged in as Team Member");
			CompletionListPage CLP=DbPage.NavCompletionListPage(ExpProjectCode);
			ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
	
	//		page.getLoggerpass( "Action Toll Completed");
		//	Logout();
			
		  
				
			}
		
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	
		@Test (description = "Validating Creation of AchieveMore Project (Campaign Included)")
		public void AchieveMoreProj() throws Exception{
			/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
				throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
			*/
			Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
	System.out.println("timeStamp :"+timeStamp);
			//Login 
			
			
			
			 
			
			int rowCnt=testExcel.getRowCount("Registration");
			System.out.println("rowCnt :"+rowCnt);
			for (int i=5;i<=rowCnt;i++){
		//	try{
				
			String ExpProjectType=rd.ReadProjectType(i);
			String ExpProjectName_1=rd.ReadProject_Name(i)+timeStamp;
			String ExpProjectName=ExpProjectName_1.replaceAll("[^A-za-z0-9]", "");
			System.out.println(ExpProjectName);
			String TempName_1= rd.ReadImpl_TempName(2)+timeStamp;
			String TempName=TempName_1.replaceAll("[^A-za-z0-9]", "");
			
			/*LoginPage home= new LoginPage();
			DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
			page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
			*/
			 CPPage=DbPage.NavCreateProject (ExpProjectType);
			page.getLoggerpass( "Logged into ALIP");	
			// Create Project
			 tollPage=CPPage.CreateProjAPS(ExpProjectType, ExpProjectName,"Submit",i);
			page.getLoggerpass( "Project  created");
			String ExpProjCode = CPPage.returnProjCode();
			System.out.println("ExpProjectCode :"+ExpProjCode);
			rd.SetPrjcode(i, ExpProjCode);
			//Logout
			String ExpProjectCode=ExpProjCode;
			
			 home=tollPage.logout();
			 
				
			 System.out.println("ProjectMember ;"+rd.ReadPrjOwner(2).trim());
			 //Login as Member to create Campaign
			 DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
			  page.getLoggerpass( "Login as Project Approver");	
			  Camp=DbPage.NavCampaignPageByUrl();
			  String Campaign_1="Campaign"+timeStamp;
			  String Campaign=Campaign_1.replaceAll("[^A-za-z0-9]", "");
			  String IdeaTitle_1="IdeaTitle"+timeStamp;
			  String IdeaTitle=IdeaTitle_1.replaceAll("[^A-za-z0-9]", "");
			  System.out.println(Campaign);
			  Camp.CreateCampaign(ExpProjectName, Campaign, "Objective","1", "30", "Submit");
			  home=Camp.logout();
			  
			  System.out.println("ProjectMember ;"+rd.ReadPrjOwner(2).trim());
			//Login as Member to create Campaign Crowd Sourcing 
			  DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
				  page.getLoggerpass( "Login as Project Approver");	
				  Crowd=DbPage.NavCrowdPage(Campaign);
				  Crowd.CreateCrowdSourcing(Campaign, ExpProjectName, ExpProjCode, IdeaTitle, "Design", "IdeaDesc", "CurrentMethod", "Add_Info", "K010", "K01", "0", "2", "1", "1", "INTANGIBLE_BENEFITS", "Submit");
				  DbPage=Crowd.NavtoDashboardPage();
				FiltersPage FP=DbPage.OutPutViewCampaign(ExpProjCode,Campaign, DashBoardElem.CAMPAIGN_ICON);
				CampaignApprovalPage CAP=FP.navToCampaignApprovalPage(Campaign, IdeaTitle, ExpProjCode);
				 GP=CAP.ApproveCampaign("Approve", "Comment Approved");
				
				  

			String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType,IdeaTitle);
			System.out.println("IdeaNo :"+IdeaNo);
			 //navigation to Evaluation
			EvaluationPage EP= GP.NavtoEvaluationPage();
			 page.getLoggerpass( "Create Generation ");
			 DbPage=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
			home=DbPage.NavLoginPageByUrl();
			 page.getLoggerpass( "Create Evaluation ");
			
			
			//Login as Approver
			int RowCnt=testExcel.getRowCount("Eval_EmpSeq");
	    	System.out.println("RowCnt :"+RowCnt);
	    	
	    	for(int r=2;r<=RowCnt;r++){
	    		DbPage =home.Login(rd.ReadEval_Emp_name(r),rd.ReadPassword());
			//Navigation to Idea Signoff page
			signOffList=DbPage.NavIdeaSignOffListByURL();
			//Navigating To Idea SignOff Page
	    	
			Thread.sleep(500);
			System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
			 IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
			 page.getLoggerpass( "SelectAndAction GO ");
			home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
			
	    	}
			
			
				 
				 //Log in 
				DbPage=home.Login(rd.ReadUserName(),rd.ReadPassword());
				//Under Implementation
				 UnderImplement=DbPage.NavUnderImplement(ExpProjectCode);
				 page.getLoggerpass( "Nav Under Implemention ");
				UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),IdeaTitle,ExpProjectCode, ExpProjectName, ExpProjectType);
				page.getLoggerpass( "Under Implemention Template Valdation ");
				home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
						rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
						rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), TempName);
				page.getLoggerpass( "Under Implemention Template Creation ");
				// Login as Completion Approver and View Project
				DbPage =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
				page.getLoggerpass( "Logged in as Team Member");
				CompletionListPage CLP=DbPage.NavCompletionListPage(ExpProjectCode);
				ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
		
		//		page.getLoggerpass( "Action Toll Completed");
			//	Logout();
				
			  
					
				}
			
			
		}
		
		//------------------------------------------------------------------------------------------------------
		
		@Test (description = "Validating Creation of DeepDive Project ( Except Sponsor Approval , included Campaign)")
		public void DeepDiveProj() throws Exception{
			/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		//Login 
		
			Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
			System.out.println("timeStamp :"+timeStamp);
			
		
		int rowCnt=testExcel.getRowCount("Registration");
		System.out.println("rowCnt :"+rowCnt);
		for (int i=6;i<=6;i++){
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
		
			tollPage.CreatTollGate(ExpProjectType);
		page.getLoggerpass( "Project Toll Gate  created");	
			
		
		
		DbPage =CPPage.NavDashboardPage();
		  PAP=DbPage.NavSponsorApprovalByURL();
		 Thread.sleep(500);
		 
		 //String ExpProjectCode=rd.ReadProjectCode(i);
		/*// SponsorApproval
		 PAP.PendingApproval(ExpProjectCode,"pending for sponsor approval");
		
		 PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		 page.getLoggerpass( "sponsor approval");	*/
		 home=PAP.PAPlogout();
		
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
		 AP.CreateAnalysis(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Analysis ");
		 NavLoginPageByUrl();
	
		 
		 //Login as Member to create Campaign
		 DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
		  page.getLoggerpass( "Login as Project Approver");	
		  Camp=DbPage.NavCampaignPageByUrl();
		 String Campaign_1="Campaign"+timeStamp;
		  String Campaign=Campaign_1.replaceAll("[^A-za-z0-9]", "");
		
		  System.out.println(Campaign);
		  Camp.CreateCampaign(ExpProjectName, Campaign, "Objective","1", "30", "Submit");
		  home=Camp.logout();
		  
		  System.out.println("ProjectMember ;"+rd.ReadPrjOwner(2).trim());
		//Login as Member to create Campaign Crowd Sourcing 
		  DbPage =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
			  page.getLoggerpass( "Login as Project Approver");	
			  Crowd=DbPage.NavCrowdPage(Campaign);
			  Crowd.CreateCrowdSourcing(Campaign, ExpProjectName, ExpProjCode, IdeaTitle, "Design", "IdeaDesc", "CurrentMethod", "Add_Info", "K010", "K01", "0", "2", "1", "1", "INTANGIBLE_BENEFITS", "Submit");
			  DbPage=Crowd.NavtoDashboardPage();
			FiltersPage FP=DbPage.OutPutViewCampaign(ExpProjCode,Campaign, DashBoardElem.CAMPAIGN_ICON);
			CampaignApprovalPage CAP=FP.navToCampaignApprovalPage(Campaign, IdeaTitle, ExpProjCode);
			 GP=CAP.ApproveCampaign("Approve", "Comment Approved");
			
			  
		String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType,IdeaTitle);
		System.out.println("IdeaNo :"+IdeaNo);
		 //navigation to Evaluation
		EvaluationPage EP= GP.NavtoEvaluationPage();
		 page.getLoggerpass( "Create Generation ");
		 DbPage=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Evaluation ");
		 
		 home =DbPage.NavLoginPageByUrl();
			
			//Login as Approver
			int RowCnt=testExcel.getRowCount("Eval_EmpSeq");
	    	System.out.println("RowCnt :"+RowCnt);
	    	
	    	for(int r=2;r<=RowCnt;r++){
	    		DbPage =home.Login(rd.ReadEval_Emp_name(r),rd.ReadPassword());
			//Navigation to Idea Signoff page
			signOffList=DbPage.NavIdeaSignOffListByURL();
			//Navigating To Idea SignOff Page
	    	
			Thread.sleep(500);
			System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
			 IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
			 page.getLoggerpass( "SelectAndAction GO ");
			home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
			System.out.println("Idea SignOff Completed");
	    	}
			
			
				 
				 //Log in 
				DbPage=home.Login(rd.ReadUserName(),rd.ReadPassword());
				//Under Implementation
				 UnderImplement=DbPage.NavUnderImplement(ExpProjectCode);
				 page.getLoggerpass( "Nav Under Implemention ");
				UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),IdeaTitle,ExpProjectCode, ExpProjectName, ExpProjectType);
				page.getLoggerpass( "Under Implemention Template Valdation ");
				home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
						rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
						rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), TempName);
				page.getLoggerpass( "Under Implemention Template Creation ");
				// Login as Completion Approver and View Project
				DbPage =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
				page.getLoggerpass( "Logged in as Team Member");
				CompletionListPage CLP=DbPage.NavCompletionListPage(ExpProjectCode);
				ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
		
		//		page.getLoggerpass( "Action Toll Completed");
			//	Logout();
				
			  
					
				}
		}
}
