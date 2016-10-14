package com.alip.selenium.pages.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.AnalysisPage;
import com.alip.selenium.po.CreateProjectPage;
import com.alip.selenium.po.DashBoardPage;
import com.alip.selenium.po.EvaluationPage;
import com.alip.selenium.po.GenerationPage;
import com.alip.selenium.po.LoginPage;
import com.alip.selenium.po.ObservationPage;
import com.alip.selenium.po.ObservationTollPage;
import com.alip.selenium.po.ProblemApprovalPage;
import com.alip.selenium.po.ProjectTollGate;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ProjecttollgatElem;
import com.alip.selenium.po.elements.ReadData;

public class TestCreateProject extends page {
	ReadData rd= new ReadData();
	
	@Test (description = "Validating Creation of APS Create Project ")
	public void APSCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		
		//Login 
		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
		CreateProjectPage CP=Db.NavCreateProject ("APS");
	
		// Create Project
		ProjectTollGate ptg=CP.CreateProjAPS("APS");
		ptg.CreatTollGate();
		 Db =CP.NavDashboardPage();
		 ProblemApprovalPage PAP=Db.NavSponsorApprovalByURL();
		 Thread.sleep(500);
		// SponsorApproval
		 PAP.PendingApproval(rd.ReadProjectCode(),"pending for sponsor approval");
		 PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		// Logout
		 home=PAP.PAPlogout();
		 System.out.println("Projectownersysout ;"+rd.ReadPrjOwner(2).trim());
		 //Login as Project Approver
		  Db =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
		  PAP=Db.NavSponsorApprovalByURL();
		  PAP.PendingApproval(rd.ReadProjectCode(),"pending for approval/sponsor approved");
		  PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		// Logout
		 home=PAP.PAPlogout();
		// Login as member and View Project
		 Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		 //view Registered Project
		 ptg=Db.RegistrationView(rd.ReadProjectCode());
		 //Tollgate to Observation
		 ObservationPage OBS=ptg.NavTollToObservation();
		 OBS.CreateObserv();
		 //navigation to observation Toll Page
		 ObservationTollPage OTP=new ObservationTollPage();
		 //navigation to Analysis 
		 AnalysisPage AP=OTP.CreatTollGate();
		//navigation to Generation  
		GenerationPage GP= AP.CreateAnalysis();
		 //navigation to Evaluation
		EvaluationPage EP= GP.CreateGeneration();
		 
		EP.CreateEvaluation();
		 
	}
	
	
	
	
	
		
	
		
	

}
