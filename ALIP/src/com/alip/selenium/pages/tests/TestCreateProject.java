package com.alip.selenium.pages.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.ActionTollgate;
import com.alip.selenium.po.AnalysisPage;
import com.alip.selenium.po.CompletionListPage;
import com.alip.selenium.po.CreateProjectPage;
import com.alip.selenium.po.DashBoardPage;
import com.alip.selenium.po.EvaluationPage;
import com.alip.selenium.po.GenerationPage;
import com.alip.selenium.po.IdeaSignOffListPage;
import com.alip.selenium.po.IdeaSignOffPage;
import com.alip.selenium.po.LoginPage;
import com.alip.selenium.po.ObservationPage;
import com.alip.selenium.po.ObservationTollPage;
import com.alip.selenium.po.ProblemApprovalPage;
import com.alip.selenium.po.ProjectTollGate;
import com.alip.selenium.po.UnderImplementationPage;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ProjecttollgatElem;
import com.alip.selenium.po.elements.ReadData;

public class TestCreateProject extends page {
	ReadData rd= new ReadData();
	
//	@Test (description = "Validating Creation of APS Create Project ")
	public void APSCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		//Login 
		int rowCnt=testExcel.getRowCount("Registration");
		System.out.println("rowCnt :"+rowCnt);
		int i=2;
		//for (int i=3;i<=rowCnt;i++){
	//	try{
			
				String ExpProjectType=rd.ReadProjectType(i);
		String ExpProjectName=rd.ReadProject_Name(i);
		
		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
		
		CreateProjectPage CP=Db.NavCreateProject (ExpProjectType);
		page.getLoggerpass( "Logged into ALIP");	
		// Create Project
		ProjectTollGate ptg=CP.CreateProjAPS(ExpProjectType, ExpProjectName,"submit",i);
		String ExpProjCode = CP.returnProjCode();
		System.out.println("ExpProjectCode :"+ExpProjCode);
		rd.SetPrjcode(i, ExpProjCode);
		
		page.getLoggerpass( "Project  created");
		
		ptg.CreatTollGate();
		page.getLoggerpass( "Project Toll Gate  created");	
		 Db =CP.NavDashboardPage();
		 ProblemApprovalPage PAP=Db.NavSponsorApprovalByURL();
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
		  Db =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
		  page.getLoggerpass( "Login as Project Approver");	
		  PAP=Db.NavSponsorApprovalByURL();
		  PAP.PendingApproval(ExpProjectCode,"pending for approval/sponsor approved");
		  PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		  page.getLoggerpass( " pending for approval/sponsor approved ");	
		// Logout
		 home=PAP.PAPlogout();
		// Login as member and View Project
		 Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		 page.getLoggerpass( "Login as Member");	
		 //view Registered Project
		
		 ptg=Db.RegistrationView(ExpProjectCode);
		 page.getLoggerpass( "RegistrationView");	
		 //Tollgate to Observation
		 
		 ObservationPage OBS=ptg.NavTollToObservation();
		 
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
			String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType);
			System.out.println("IdeaNo :"+IdeaNo);
		 //navigation to Evaluation
		EvaluationPage EP= GP.NavtoEvaluationPage();
		 page.getLoggerpass( "Create Generation ");
		Db=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
		 page.getLoggerpass( "Create Evaluation ");
		//Navigation to Idea Signoff page
		IdeaSignOffListPage signOffList=Db.NavIdeaSignOffListByURL();
		//Navigating To Idea SignOff Page
		
		Thread.sleep(500);
		System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
		IdeaSignOffPage IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
		 page.getLoggerpass( "SelectAndAction GO ");
		home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
		
		
		// Login as second member and View Project
		Db =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
		page.getLoggerpass( "Login as second member and View Project ");
		//Navigation to Idea Signoff page
		 	signOffList=Db.NavIdeaSignOffListByURL();	
		 	Thread.sleep(500);
			System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
			IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode, rd.ReadIdea_ExpStatus(2));
			home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
			 page.getLoggerpass( "Approve Idea SignOff ");
			 
			 //Log in 
			Db=home.Login(rd.ReadUserName(),rd.ReadPassword());
			//Under Implementation
			UnderImplementationPage UnderImplement=Db.NavUnderImplement(ExpProjectCode);
			 page.getLoggerpass( "Nav Under Implemention ");
			UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),rd.ReadGen_Idea_Title(2),ExpProjectCode, ExpProjectName, ExpProjectType);
			page.getLoggerpass( "Under Implemention Template Valdation ");
			home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
					rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
					rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), rd.ReadImpl_TempName(2));
			page.getLoggerpass( "Under Implemention Template Creation ");
			// Login as Completion Approver and View Project
			Db =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
			page.getLoggerpass( "Logged in as Team Member");
			CompletionListPage CLP=Db.NavCompletionListPage(ExpProjectCode);
			ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
			page.getLoggerpass( "Completion List Submission");
			ATG.CreatTollGate();
			page.getLoggerpass( "Action Toll Completed");
			Logout();
			
		/*}catch(Exception e){
			String ExpProjectType=rd.ReadProjectType(i);
			System.out.println(ExpProjectType+"is  completed with error");
		  }  */
				
			}
	//	}
		 
	
	@Test (description = "Validating Creation of APS Create Project ")
	public void BPSCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		//Login 
		 ProblemApprovalPage PAP;
		
		int rowCnt=testExcel.getRowCount("Registration");
		System.out.println("rowCnt :"+rowCnt);
		for (int i=3;i<=rowCnt;i++){
	//	try{
			
		String ExpProjectType=rd.ReadProjectType(i);
		String ExpProjectName=rd.ReadProject_Name(i);
		
		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
		
		CreateProjectPage CP=Db.NavCreateProject (ExpProjectType);
		//page.getLoggerpass( "Logged into ALIP");	
		// Create Project
		ProjectTollGate ptg=CP.CreateProjAPS(ExpProjectType, ExpProjectName,"Submit",i);
		//page.getLoggerpass( "Project  created");
		String ExpProjCode = CP.returnProjCode();
		System.out.println("ExpProjectCode :"+ExpProjCode);
		rd.SetPrjcode(i, ExpProjCode);
		//Project TollGate
		String ExpProjectCode=ExpProjCode;
		if(ExpProjectType.trim().equalsIgnoreCase("APS")){
			ptg.CreatTollGate();
			//page.getLoggerpass( "Project Toll Gate  created");	
			
		
		
		Db =CP.NavDashboardPage();
		  PAP=Db.NavSponsorApprovalByURL();
		 Thread.sleep(500);
		 
		 //String ExpProjectCode=rd.ReadProjectCode(i);
		// SponsorApproval
		 PAP.PendingApproval(ExpProjectCode,"pending for sponsor approval");
		
		 PAP.ModerationApproveAndReject("Approve", "Approved Reason");
	//	 page.getLoggerpass( "sponsor approval");	
		 home=PAP.PAPlogout();
		}else {
		// Logout
			
		 home=ptg.logout();
		}
		 System.out.println("Projectownersysout ;"+rd.ReadPrjOwner(2).trim());
		 //Login as Project Approver
		  Db =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
		 // page.getLoggerpass( "Login as Project Approver");	
		  PAP=Db.NavSponsorApprovalByURL();
		  PAP.PendingApproval(ExpProjectCode,"pending for approval/sponsor approved");
		  PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		 // page.getLoggerpass( " pending for approval/sponsor approved ");	
		// Logout
		 home=PAP.PAPlogout();
		// Login as member and View Project
		 Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		// page.getLoggerpass( "Login as Member");	
		 //view Registered Project
		
		 ptg=Db.RegistrationView(ExpProjectCode);
	//	 page.getLoggerpass( "RegistrationView");	
		 //Tollgate to Observation
		 
		 ObservationPage OBS=ptg.NavRegistrationViewToObservation();
		 
		 OBS.CreateObserv(ExpProjectCode, ExpProjectName, ExpProjectType);;
	//	 page.getLoggerpass( "Create Observation");
		 //navigation to observation Toll Page
		 ObservationTollPage OTP=new ObservationTollPage();
		 //navigation to Analysis 
		 AnalysisPage AP=OTP.CreatTollGate();
	//	 page.getLoggerpass( "Create Observation Toll gate");
		//navigation to Generation  
		GenerationPage GP= AP.CreateAnalysis(ExpProjectCode, ExpProjectName, ExpProjectType);
//		 page.getLoggerpass( "Create Analysis ");
		String IdeaNo=GP.CreateGeneration(ExpProjectCode, ExpProjectName, ExpProjectType);
		System.out.println("IdeaNo :"+IdeaNo);
		 //navigation to Evaluation
		EvaluationPage EP= GP.NavtoEvaluationPage();
//		 page.getLoggerpass( "Create Generation ");
		Db=EP.CreateEvaluation(ExpProjectCode, ExpProjectName, ExpProjectType);
//		 page.getLoggerpass( "Create Evaluation ");
		//Navigation to Idea Signoff page
		IdeaSignOffListPage signOffList=Db.NavIdeaSignOffListByURL();
		//Navigating To Idea SignOff Page
		
		Thread.sleep(500);
		System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
		IdeaSignOffPage IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode,  rd.ReadIdea_ExpStatus(2));
	//	 page.getLoggerpass( "SelectAndAction GO ");
		home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
		
		
		// Login as second member and View Project
		Db =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
	//	page.getLoggerpass( "Login as second member and View Project ");
		//Navigation to Idea Signoff page
		 	signOffList=Db.NavIdeaSignOffListByURL();	
		 	Thread.sleep(500);
			System.out.println("Gen_Idea_No "+rd.ReadGen_Idea_No(2));
			IdeaSignOff =signOffList.SelectAndActionFromGO(ExpProjectCode, rd.ReadIdea_ExpStatus(2));
			home=IdeaSignOff.ApproveIdeaSignOff(ExpProjectCode, ExpProjectName, ExpProjectType, rd.ReadIdea_Comments(2), rd.ReadIdea_Acceptance(2), rd.ReadIdea_Risk(2));
	//		 page.getLoggerpass( "Approve Idea SignOff ");
			 
			 //Log in 
			Db=home.Login(rd.ReadUserName(),rd.ReadPassword());
			//Under Implementation
			UnderImplementationPage UnderImplement=Db.NavUnderImplement(ExpProjectCode);
	//		 page.getLoggerpass( "Nav Under Implemention ");
			UnderImplement.ImplementationTempValidation(rd.ReadGen_Idea_No(2),rd.ReadGen_Idea_Title(2),ExpProjectCode, ExpProjectName, ExpProjectType);
	//		page.getLoggerpass( "Under Implemention Template Valdation ");
			home=UnderImplement.ImplementationTempCreation(rd.ReadImpl_ImplGroup(2), rd.ReadImpl_ActivityName(2),
					rd.ReadImpl_Exp_RS_MEM(2), rd.ReadImpl_Exp_RS_MEM_1(2),rd.ReadImpl_Exp_RS_MEM_2(2), rd.ReadImpl_EstimatedHrs(2),rd.ReadImpl_Proj_Plan_Startdt(2),rd.ReadImpl_Proj_Plan_Enddt(2),
					rd.ReadImpl_Instruction(2),rd.ReadImpl_Predecessor(2), rd.ReadImpl_TempName(2));
	//		page.getLoggerpass( "Under Implemention Template Creation ");
			// Login as Completion Approver and View Project
			Db =home.Login(rd.ReadEval_Emp_name(3),rd.ReadPassword());
	//		page.getLoggerpass( "Logged in as Team Member");
			CompletionListPage CLP=Db.NavCompletionListPage(ExpProjectCode);
			ActionTollgate ATG=CLP.CompletionListSubmission("500", "3", "24", "Yes", "Test Comment",i);
	//		page.getLoggerpass( "Completion List Submission");
			ATG.CreatTollGate();
	//		page.getLoggerpass( "Action Toll Completed");
			Logout();
			
		/*}catch(Exception e){
			String ExpProjectType=rd.ReadProjectType(i);
			System.out.println(ExpProjectType+"is  completed with error");
		  }  */
				
			}
		}
		 
	
	
	//@Test (description = "Validating Creation of APS Create Project ")
	public void CreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		//Login 
		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		///Db.EvaluationView(rd.ReadProjectCode(i));
		
		
	}
	
	
	
		
	
		
	

}
