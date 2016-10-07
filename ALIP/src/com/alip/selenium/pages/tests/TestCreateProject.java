package com.alip.selenium.pages.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.CreateProjectPage;
import com.alip.selenium.po.DashBoardPage;
import com.alip.selenium.po.LoginPage;
import com.alip.selenium.po.ProblemApprovalPage;
import com.alip.selenium.po.ProjectTollGate;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ProjecttollgatElem;
import com.alip.selenium.po.elements.ReadData;

public class TestCreateProject {
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
		 ProblemApprovalPage PAP=Db.NavSponsorApproval();
		// SponsorApproval
		 PAP.PendingApproval(rd.ReadProjectCode(),"pending for sponsor approval");
		 PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		// Logout
		 home=PAP.PAPlogout();
		 System.out.println("Projectownersysout ;"+rd.ReadPrjOwner(2).trim());
		 //Login as Project Approver
		  Db =home.Login(rd.ReadPrjOwner(2).trim(),rd.ReadPassword());
		  PAP=Db.NavPendSponsorApproval();
		  PAP.PendingApproval(rd.ReadProjectCode(),"pending for approval/sponsor approved");
		  PAP.ModerationApproveAndReject("Approve", "Approved Reason");
		// Logout
		 home=PAP.PAPlogout();
		 Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		 Db.RegistrationView(rd.ReadProjectCode());
		 
	}
	
	
	//@Test (description = "Validating Creation of AchieveMore Create Project ")
	public void AchieveMoreCreateProj() throws Exception{
		/*if(!TestUtil.isTestExecutable("checkLogin", page.testExcel))
			throw new SkipException("Test execution is set to NO for reason:"+TestUtil.getReasonForNoExecution("checkLogin", page.testExcel));
		*/
		LoginPage home= new LoginPage();
		DashBoardPage Db =home.Login(rd.ReadUserName(),rd.ReadPassword());
		page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_NAME)));
		CreateProjectPage CP=Db.NavCreateProject ("Achieve More");
		CP.CreateProjAchieveMore("Achieve More");
		ProjectTollGate ptg=new ProjectTollGate();
		ptg.CreatTollGate();
		
	}

}
