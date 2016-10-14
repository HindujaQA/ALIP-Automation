package com.alip.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.EvaluationElem;
import com.alip.selenium.po.elements.ObservationProjectElem;
import com.alip.selenium.po.elements.ReadData;

public class EvaluationPage extends page {
	ReadData rd= new ReadData();
	public void CreateEvaluation() throws Exception
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EvaluationElem.EVAL_FORM)));
		String Idea_No=FindByCssSelector(EvaluationElem.IDEA_NO).getText().toUpperCase().trim();
		String Idea_Title=FindByCssSelector(EvaluationElem.IDEA_TITLE).getText().toUpperCase().trim();
		String Proj_Code=FindByCssSelector(EvaluationElem.PJCT_CODE).getText().toUpperCase().trim();
		String Proj_Name=FindByCssSelector(EvaluationElem.PJCT_NAME).getText().toUpperCase().trim();
		String Proj_Type=FindByCssSelector(EvaluationElem.PJCT_TYPE).getText().toUpperCase().trim();
		//String Exep_Idea_No=rd.ReadProjectCode().toUpperCase().trim();
		//String Exep_Idea_Title=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Code=rd.ReadProjectCode().toUpperCase().trim();
		String Exep_Proj_Name=rd.ReadProject_Name().toUpperCase().trim();
		String Exep_Proj_Type=rd.ReadProjectType().toUpperCase().trim();
		System.out.println("Proj_Code :"+Proj_Code+" Exep_Proj_Code :"+Exep_Proj_Code);
		System.out.println("Proj_Name :"+Proj_Name+" Exep_Proj_Name :"+Exep_Proj_Name);
		System.out.println("Proj_Type :"+Proj_Type+" Exep_Proj_Type :"+Exep_Proj_Type);
		Assert.assertEquals(Proj_Name,Exep_Proj_Name,"Project name is mismatch");
		Assert.assertEquals(Proj_Type,Exep_Proj_Type, "Proj_Type name is mismatch");
		Assert.assertEquals(Proj_Code,Exep_Proj_Code, "Proj_Code "+Proj_Code+"  name is mismatch");
		//Assert.assertEquals(Exep_Idea_No, Idea_No,"Idea_No number is mismatch");
		//Assert.assertEquals(Exep_Idea_Title, Idea_Title,"Idea_Title name is mismatch");

		
		SelectDropdown(EvaluationElem.PRIORITY, rd.ReadEval_Priority(2));
		SelectDropdown(EvaluationElem.MINOR_IDEA, rd.ReadEval_MinorIdea(2));
		txtbox(EvaluationElem.COMMENTS, rd.ReadEval_Comment(2));
		SelectDropdown(EvaluationElem.IMPACT_DRPDWN, rd.ReadEval_Impact(2));
		SelectDropdown(EvaluationElem.FEASIBILITY, rd.ReadEval_Feasibility(2));
		BackupIdea(rd.ReadEval_BackupIdea(2));
		CancelIdea(rd.ReadEval_CancelIdea(2));
		IdeaHold(rd.ReadEval_IdeaHold(2));
		
		//KPI
		
		AutoSuggest(EvaluationElem.KPICODE, EvaluationElem.KPICODE_AUTO, EvaluationElem.KPICODE_AUTO_1,rd.ReadEval_KPI(2),rd.ReadEval_KPI_1(2),rd.ReadEval_KPI_2(2));

        txtbox(EvaluationElem.IMPACT,rd.ReadEval_KPI_Impact(2));
        txtbox(EvaluationElem.SOB,rd.ReadEval_ShareOfBusiness(2));
        txtbox(EvaluationElem.ONE_TIME,rd.ReadEval_OneTime(2));
       // txtbox(EvaluationElem.SOB,rd.ReadEval_ShareOfBusiness(2));
        Recurring(rd.ReadEval_AutoCompute(2), rd.ReadEval_RecurringAnnum(2));
        Thread.sleep(500);
        FindByCssSelector(EvaluationElem.KPI_ADD_BTN).click();
        
        txtbox(EvaluationElem.CUR_METHOD,rd.ReadEval_CurrentMethod(2));
        txtbox(EvaluationElem.IB,rd.ReadEval_IntangibleBenefit(2));
        txtbox(EvaluationElem.DOWNSIDES,rd.ReadEval_Downsides(2));
        txtbox(EvaluationElem.ADV,rd.ReadEval_Advantages(2));
       //Investment Details
        txtbox(EvaluationElem.CAP,rd.ReadEval_Capital(2));
        txtbox(EvaluationElem.NON_CAP,rd.ReadEval_NonCapital(2));
        txtbox(EvaluationElem.RECURR,rd.ReadEval_Recurring(2));
        TeamList("APS");
        Thread.sleep(500);
        FindByCssSelector(EvaluationElem.SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EvaluationElem.EVAL_SUCCESS)));
		String SucessMSG=FindByCssSelector(EvaluationElem.EVAL_SUCCESS).getText().toUpperCase().trim();
		Thread.sleep(500);
		Assert.assertEquals(SucessMSG, EvaluationElem.EVAL_SUCCESS_MSG.toUpperCase().trim(), "Evaluation is not Successful");
		//FindByCssSelector(DashBoardElem.LOGO).click();
		
		
	
	}
	
	public void BackupIdea(String Decision){
		if(Decision.equalsIgnoreCase("YES")){
			FindByCssSelector(EvaluationElem.BACK_UP_IDEA).click();
			SelectDropdown(EvaluationElem.BACK_UP_IDEA_NO, rd.ReadEval_BackUpIdeaNo(2));
		}else {
			System.out.println("BackupIdea Decision"+Decision);
		}
		
	}

	public void CancelIdea(String Decision){
		if(Decision.equalsIgnoreCase("YES")){
			FindByCssSelector(EvaluationElem.CANCEL_IDEA).click();
			
		}else {
			System.out.println("CancelIdea Decision"+Decision);
		}
		
	}
	public void IdeaHold(String Decision){
		if(Decision.equalsIgnoreCase("YES")){
			FindByCssSelector(EvaluationElem.IDEA_ON_HOLD).click();
			
		}else {
			System.out.println("IdeaHold"+Decision);
		}
		
	}
	public void Recurring(String Decision, String Value){
		if(Decision.equalsIgnoreCase("YES")){
			FindByCssSelector(EvaluationElem.ACR_SAVINGS).click();
			
		}else {
			System.out.println("Recurring"+Decision);
			FindByCssSelector(EvaluationElem.RECURR_ANNUM).sendKeys(Value);;
		}
		
	}
	
	 public void TeamList(String Exp_Project) throws InterruptedException{
	    	int RowCnt=testExcel.getRowCount("Eval_EmpSeq");
	    	System.out.println("RowCnt :"+RowCnt);
	    	
	    	for(int i=2;i<=RowCnt;i++){
	    		  
	    		String actual_Project=rd.ReadRoleProject(i);
	    		System.out.println("actual_Project :"+actual_Project);
	    		if (Exp_Project.equalsIgnoreCase(actual_Project)){
	    			  
	    		        
	    		        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(EvaluationElem.EMP_NAME)));
	    		       System.out.println("Employee_name; "+rd.ReadEval_Emp_no(i));
	    		        
	    		       System.out.println("Employee_name_1; "+rd.ReadEval_Emp_no_1(i));
	    		       System.out.println("Employee_name_2; "+rd.ReadEval_Emp_no_2(i));
	    		       
	    		        AutoSuggest(EvaluationElem.EMP_NAME, EvaluationElem.EMP_NAME_AUTO, EvaluationElem.EMP_NAME_AUTO_1, rd.ReadEval_Emp_no(i),rd.ReadEval_Emp_no_1(i),rd.ReadEval_Emp_no_2(i));
	    		        txtbox(EvaluationElem.SEQ_NO, rd.ReadEval_Sequence(i));
	    		        FindByCssSelector(EvaluationElem.EMP_ADD_BTN).click();
	    		       
	    			
	    		}
	    		
	    	}
	    	
	    }
	
	
	
}
