package com.alip.selenium.po;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.ReadData;

public class CreateProjectPage extends page {
    
	private static final CharSequence Char = null;
	ReadData rd= new ReadData();

	public DashBoardPage NavDashboardPage()  {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.LOGO)));
		FindByCssSelector(DashBoardElem.LOGO).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.STAGE)));
		
		return new DashBoardPage() ;
		}
	
	public void  SelectandCheckFrmDrp(String Field,String ElemDrpDown,String [] drpDownExep_Val,String ElemDropDown_1, String ElemChkVal_1){
        FindByCssSelector(Field).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ElemDrpDown)));
        List drpDown=page.driver.findElements(By.cssSelector(ElemDrpDown));
        int drpDown_CNT= drpDown.size();
        System.out.println("drpDown list :"+drpDown_CNT);
        System.out.println("drpDownExep_Val");
        System.out.println("length: "+drpDownExep_Val.length);
        for (int j=0;j<drpDownExep_Val.length;j++){
            
            for (int i=1;i<=drpDown_CNT;i++){
                
                String drpDown_Val= FindByCssSelector(ElemDropDown_1+i+CreateProjectElem.QC_TOOL_DRPDWN_2).getText();
                drpDown_Val=drpDown_Val.replaceAll("[^A-Za-z]", "").toUpperCase();
                drpDownExep_Val[j]=drpDownExep_Val[j].replaceAll("[^A-Za-z]", "").toUpperCase();
                System.out.println("drpDown_Val "+drpDown_Val+ "drpDownExep_Val"+drpDownExep_Val[j]);
                
                
                    if (drpDown_Val.equalsIgnoreCase(drpDownExep_Val[j])){
                        FindByCssSelector(ElemChkVal_1+i+CreateProjectElem.QC_TOOL_LIST_CHK_1).click();            
                    break;
                    }
            }
            
            }
        FindByCssSelector(Field).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ElemDrpDown)));
        }
	
	public void txtbox(String Elemloc,String txt)
	{

		FindByCssSelector(Elemloc).sendKeys(txt);
	}
    
    public void SelectDateFrmCalender(String ElemDateFld, String Date){
        FindByCssSelector(ElemDateFld).click(); 
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ui-datepicker-div")));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Date)));
        FindByLink(Date).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ui-datepicker-div")));
        
    }
    public void SelectDropdown(String Locator,String Value){
        WebElement option = FindByCssSelector(Locator);
        //option.click();
        Select dropdown = new Select(option);
        //System.out.println(dropdown.getFirstSelectedOption());
        dropdown.selectByVisibleText(Value);
    }
    public void AutoSuggest(String Locator,String ValLocator,String ValLocator_1, String  Exp_Value, String Exp_Value_1, String Exp_Value_2) throws InterruptedException{
    	page.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Locator)));
    	FindByCssSelector(Locator).clear();
    	FindByCssSelector(Locator).click();
        FindByCssSelector(Locator).sendKeys(Exp_Value_1);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ValLocator)));
        page.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	
        FindByCssSelector(Locator).sendKeys(Exp_Value_2);
        page.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ValLocator)));
        
    	
        List cnt=page.driver.findElements(By.cssSelector(ValLocator));
        System.out.println("Exp_Value:"+Exp_Value);
        for(int i=1;i<=cnt.size();i++){
            String Actual_val=FindByCssSelector(ValLocator_1+i+")").getText();
            Actual_val=Actual_val.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
           // int Actual_val_int=Integer.parseInt( Actual_val);
            Exp_Value=(Exp_Value).replaceAll("[^A-Za-z0-9]", "").toUpperCase();
            //int Exp_Value_int=Integer.parseInt(Exp_Value);
            System.out.println("Exp_Value: "+Exp_Value +" ,Actual_val "+Actual_val);
            page.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            if (Actual_val.startsWith(Exp_Value)){
            	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ValLocator_1+i+")")));	
                FindByCssSelector(ValLocator_1+i+")").click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ValLocator_1+i+")")));	
                Thread.sleep(500);
                break;
            }
        }

        
    }
    public void ScrollPageToElement(String Locator) throws Exception {
       
        JavascriptExecutor jse = (JavascriptExecutor) driver;
     
        WebElement element = FindByCssSelector(Locator);
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    
    public void ValidateKPISection() throws InterruptedException{
        //KPI
    	Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println("Page down");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.KPICODE_LABEL)));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.KPICODE)));
       
        AutoSuggest(CreateProjectElem.KPICODE, CreateProjectElem.KPICODE_AUTO, CreateProjectElem.KPICODE_AUTO_1,rd.ReadKPI_code(),rd.ReadKPI_1(),rd.ReadKPI_2());
        txtbox(CreateProjectElem.BASELINE,rd.ReadBaseline());
        txtbox(CreateProjectElem.TARGET,rd.ReadTarget());
        FindByCssSelector(CreateProjectElem.KPI_ADD).click();
        
    	
    }
    
   
    public void TeamList(String Exp_Project) throws InterruptedException{
    	int RowCnt=testExcel.getRowCount("Role");
    	System.out.println("RowCnt :"+RowCnt);
    	
    	for(int i=2;i<=RowCnt;i++){
    		  
    		String actual_Project=rd.ReadRoleProject(i);
    		System.out.println("actual_Project :"+actual_Project);
    		if (Exp_Project.equalsIgnoreCase(actual_Project)){
    			  
    		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.TEAMLIST)));
    		        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.ROLE)));
    		        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.EMPLOYEE_NAME)));
    		       /* FindByCssSelector(CreateProjectElem.PROJECT_OWNER_ICON).click();
    		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.PROJECT_OWNER)));
    		        
    		        String ProjectOwner=FindByCssSelector(CreateProjectElem.PROJECT_OWNER).getText();
    		        System.out.println("ProjectOwner :"+ProjectOwner);
    		        rd.SetPrjOwner(2, ProjectOwner);
    		      */  System.out.println("Employee_name; "+rd.ReadEmployee_name(i));
    		        FindByCssSelector(CreateProjectElem.PROJECT_OWNER_ICON).click();
    		        System.out.println("Role; "+rd.ReadRole(i));
    		       System.out.println("Employee_name_1; "+rd.ReadEmployee_name_1(i));
    		       System.out.println("Employee_name_2; "+rd.ReadEmployee_name_2(i));
    		        SelectDropdown(CreateProjectElem.ROLE,rd.ReadRole(i));
    		        AutoSuggest(CreateProjectElem.EMPLOYEE_NAME, CreateProjectElem.EMP_NAME_AUTO, CreateProjectElem.EMP_NAME_AUTO_1, rd.ReadEmployee_name(i),rd.ReadEmployee_name_1(i),rd.ReadEmployee_name_2(i));
    		        FindByCssSelector(CreateProjectElem.EMP_ADD).click();
    		       
    			
    		}
    		
    	}
    	
    }
    
    public ProjectTollGate CreateProjAPS (String ProjectType) throws Exception{
    	
    	String probText = FindByXpath(CreateProjectElem.PROB_TXT).getText();
    	String regText = FindByXpath(CreateProjectElem.REG_TXT).getText();;
		Assert.assertEquals("PROBLEM", probText);
		Assert.assertEquals("Registration", regText);
		String projType = FindByCssSelector(CreateProjectElem.PROJ_TYPE).getText();
		Assert.assertEquals(ProjectType.toUpperCase().trim(), projType.toUpperCase().trim());
		System.out.println(projType +" "+regText+" "+probText);
		
		
    	Actions action = new Actions(driver);
		SelectDropdown(CreateProjectElem.LOCATION, rd.Readlocation());
		txtbox(CreateProjectElem.PROJECT_NAME, rd.ReadProject_Name());
		txtbox(CreateProjectElem.DESCRIPTION, rd.ReadDescription());
		SelectDropdown(CreateProjectElem.GEMBA_UNIT, rd.ReadGemba_Unit());
		SelectDropdown(CreateProjectElem.DIVISION, rd.ReadDivision());
		String []drpDownExep_Val={rd.ReadQC_Tools()};
        SelectandCheckFrmDrp(CreateProjectElem.QC_TOOL, CreateProjectElem.QC_TOOL_DRPDWN, drpDownExep_Val, CreateProjectElem.QC_TOOL_DRPDWN_1, CreateProjectElem.QC_TOOL_LIST_CHK);
        SelectDropdown(CreateProjectElem.CATEGORY, rd.ReadCategory());
        SelectDropdown(CreateProjectElem.SUB_CATEGORY, rd.ReadSub_Category());
        
        //parent project
        SelectDropdown(CreateProjectElem.CUSTOMER, rd.ReadCustomer());
        
        SelectDateFrmCalender(CreateProjectElem.PLANNED_STRT, rd.ReadProject_Planned());
        SelectDateFrmCalender(CreateProjectElem.PLANNED_END, rd.ReadProject_Pl_end());
        SelectDateFrmCalender(CreateProjectElem.PROBLEM_START_DATE, rd.ReadProblem_start_date());
        SelectDateFrmCalender(CreateProjectElem.PROBLEM_END_DATE, rd.ReadProblem_end_date());
        txtbox(CreateProjectElem.KEYWORDS, rd.Readkeywords());
        // Gantt chart Plan
        FindByCssSelector(".chart.col-md-5.col-lg-5.col-sm-3.col-xs-3.margin-top-15").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#problemSubMenu1 .page-header.margin-top-15>h1")));
        
        SelectDateFrmCalender(CreateProjectElem.REG_START_DATE,rd.ReadReg_Start_date());
        SelectDateFrmCalender(CreateProjectElem.REG_END_DATE,rd.ReadReg_end_date());
        SelectDateFrmCalender(CreateProjectElem.OBSER_ST_DATE,rd.ReadObservation_st_date());
        SelectDateFrmCalender(CreateProjectElem.OBSER_END_DATE,rd.ReadObservation_end_date());
        SelectDateFrmCalender(CreateProjectElem.ANALYSIS_ST_DATE,rd.ReadAnalysis_st_date());
        SelectDateFrmCalender(CreateProjectElem.ANALYSIS_END_DATE,rd.ReadAnalysis_end_date());
        SelectDateFrmCalender(CreateProjectElem.ACTION_ST_DATE,rd.ReadAction_Start_date());
        SelectDateFrmCalender(CreateProjectElem.ACTION_END_DATE,rd.ReadAction_end_date());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.Check_STDT_FLD)));
        System.out.println("IN TEST");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.Check_ST_DATE)));
        SelectDateFrmCalender(CreateProjectElem.Check_ST_DATE,rd.ReadCheck_Start_date());
        SelectDateFrmCalender(CreateProjectElem.Check_END_DATE,rd.ReadCheck_end_date());
        SelectDateFrmCalender(CreateProjectElem.STD_ST_DATE,rd.ReadStd_st_date());
        SelectDateFrmCalender(CreateProjectElem.STD_END_DATE,rd.ReadStd_end_date());
        SelectDateFrmCalender(CreateProjectElem.CONCLUDE_ST_DATE,rd.ReadConclude_st_date());
        SelectDateFrmCalender(CreateProjectElem.CONCLUDE_END_DATE,rd.ReadConclude_end_date());
     
        //KPI
        action.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println("KPIPage down");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.KPICODE_LABEL)));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.KPICODE)));
       
        AutoSuggest(CreateProjectElem.KPICODE, CreateProjectElem.KPICODE_AUTO, CreateProjectElem.KPICODE_AUTO_1,rd.ReadKPI_code(),rd.ReadKPI_1(),rd.ReadKPI_2());
        txtbox(CreateProjectElem.BASELINE,rd.ReadBaseline());
        txtbox(CreateProjectElem.TARGET,rd.ReadTarget());
        FindByCssSelector(CreateProjectElem.KPI_ADD).click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println("Page down");
        
        TeamList("APS");
    
        FindByCssSelector(CreateProjectElem.SUBMIT).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(CreateProjectElem.SUBMIT_SUCESS_MSG)));
        String successMsg=FindByCssSelector(CreateProjectElem.SUBMIT_SUCESS_MSG).getText();
        String ProjCode=FindByXpath(CreateProjectElem.PROJ_CODE).getText();
        System.out.println("ProjCode : "+ProjCode);
        rd.SetPrjcode(2, ProjCode);
       // Assert.assertEquals(successMsg.toUpperCase().trim(),CreateProjectElem.SUCESS_MSG.toUpperCase().trim());
        return new ProjectTollGate();
        
    }
    
    
public void CreateProjAchieveMore (String ProjectType) throws Exception{
    	
  	String probText = FindByXpath(CreateProjectElem.PROB_TXT).getText();
	String regText = FindByXpath(CreateProjectElem.REG_TXT).getText();;
	Assert.assertEquals("PROBLEM", probText);
	Assert.assertEquals("Registration", regText);
	String projType = FindByCssSelector(CreateProjectElem.PROJ_TYPE).getText();
	Assert.assertEquals(ProjectType.toUpperCase().trim(), projType.toUpperCase().trim());
	System.out.println(projType +" "+regText+" "+probText);
	
	
	Actions action = new Actions(driver);
	SelectDropdown(CreateProjectElem.LOCATION, rd.Readlocation());
	txtbox(CreateProjectElem.PROJECT_NAME, "Test Project created through automation");
	txtbox(CreateProjectElem.DESCRIPTION, "Description for the test project");
	SelectDropdown(CreateProjectElem.GEMBA_UNIT, rd.ReadGemba_Unit());
	SelectDropdown(CreateProjectElem.DIVISION, rd.ReadDivision());
	String []drpDownExep_Val={rd.ReadQC_Tools()};
    SelectandCheckFrmDrp(CreateProjectElem.QC_TOOL, CreateProjectElem.QC_TOOL_DRPDWN, drpDownExep_Val, CreateProjectElem.QC_TOOL_DRPDWN_1, CreateProjectElem.QC_TOOL_LIST_CHK);
    SelectDropdown(CreateProjectElem.CATEGORY, rd.ReadCategory());
    SelectDropdown(CreateProjectElem.SUB_CATEGORY, rd.ReadSub_Category());
    
    //parent project
    SelectDropdown(CreateProjectElem.CUSTOMER, rd.ReadCustomer());
    
    SelectDateFrmCalender(CreateProjectElem.PLANNED_STRT, rd.ReadProject_Planned());
    SelectDateFrmCalender(CreateProjectElem.PLANNED_END, rd.ReadProject_Pl_end());
    SelectDateFrmCalender(CreateProjectElem.PROBLEM_START_DATE, rd.ReadProblem_start_date());
    SelectDateFrmCalender(CreateProjectElem.PROBLEM_END_DATE, rd.ReadProblem_end_date());
    txtbox(CreateProjectElem.KEYWORDS, rd.Readkeywords());
    // Gantt chart Plan
    FindByCssSelector(".chart.col-md-5.col-lg-5.col-sm-3.col-xs-3.margin-top-15").click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#problemSubMenu1 .page-header.margin-top-15>h1")));
   // String gantchart = driver.findElement(By.cssSelector(""#problemSubMenu1 .page-header.margin-top-15>h1"")).getTitle();
    
    
    SelectDateFrmCalender(CreateProjectElem.REG_START_DATE,rd.ReadReg_Start_date());
    SelectDateFrmCalender(CreateProjectElem.REG_END_DATE,rd.ReadReg_end_date());
    SelectDateFrmCalender(CreateProjectElem.OBSER_ST_DATE,rd.ReadObservation_st_date());
    SelectDateFrmCalender(CreateProjectElem.OBSER_END_DATE,rd.ReadObservation_end_date());
    SelectDateFrmCalender(CreateProjectElem.ANALYSIS_ST_DATE,rd.ReadAnalysis_st_date());
    SelectDateFrmCalender(CreateProjectElem.ANALYSIS_END_DATE,rd.ReadAnalysis_end_date());
    SelectDateFrmCalender(CreateProjectElem.ACTION_ST_DATE,rd.ReadAction_Start_date());
    SelectDateFrmCalender(CreateProjectElem.ACTION_END_DATE,rd.ReadAction_end_date());
    action.sendKeys(Keys.PAGE_DOWN).perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.Check_STDT_FLD)));
    System.out.println("IN TEST");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.Check_ST_DATE)));
    SelectDateFrmCalender(CreateProjectElem.Check_ST_DATE,rd.ReadCheck_Start_date());
    SelectDateFrmCalender(CreateProjectElem.Check_END_DATE,rd.ReadCheck_end_date());
    SelectDateFrmCalender(CreateProjectElem.STD_ST_DATE,rd.ReadStd_st_date());
    SelectDateFrmCalender(CreateProjectElem.STD_END_DATE,rd.ReadStd_end_date());
    SelectDateFrmCalender(CreateProjectElem.CONCLUDE_ST_DATE,rd.ReadConclude_st_date());
    SelectDateFrmCalender(CreateProjectElem.CONCLUDE_END_DATE,rd.ReadConclude_end_date());
 
    
    //ScrollPageToElement(CreateProjectElem.KPI_CODE);
    FindByCssSelector(CreateProjectElem.PROJECT_OWNER_ICON).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.PROJECT_OWNER)));
    String ProjectOwner=FindByCssSelector(CreateProjectElem.PROJECT_OWNER).getText();
    System.out.println("ProjectOwner :"+ProjectOwner);
    rd.SetPrjOwner(2, ProjectOwner);
  
    //KPI
    action.sendKeys(Keys.PAGE_DOWN).perform();
    System.out.println("Page down");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.KPICODE_LABEL)));
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.KPICODE)));
   
    AutoSuggest(CreateProjectElem.KPICODE, CreateProjectElem.KPICODE_AUTO, CreateProjectElem.KPICODE_AUTO_1,rd.ReadKPI_code(),rd.ReadKPI_1(),rd.ReadKPI_2());
    txtbox(CreateProjectElem.BASELINE,rd.ReadBaseline());
    txtbox(CreateProjectElem.TARGET,rd.ReadTarget());
    FindByCssSelector(CreateProjectElem.KPI_ADD).click();
    
    
    //Team List
  //  SelectDropdown(CreateProjectElem.ROLE,rd.ReadRole());
    action.sendKeys(Keys.PAGE_DOWN).perform();
    System.out.println("Page down");
    TeamList("Achieve More");
    /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.TEAMLIST)));
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CreateProjectElem.EMPLOYEE_NAME)));
   
    AutoSuggest(CreateProjectElem.EMPLOYEE_NAME, CreateProjectElem.EMP_NAME_AUTO, CreateProjectElem.EMP_NAME_AUTO_1, rd.ReadEmployee_name(),rd.ReadEmployee_name_1(),rd.ReadEmployee_name_2());
    FindByCssSelector(CreateProjectElem.EMP_ADD).click();*/
    FindByCssSelector(CreateProjectElem.SUBMIT).click();
    
    
    
        
        
    }
}