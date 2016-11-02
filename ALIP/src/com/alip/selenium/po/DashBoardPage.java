package com.alip.selenium.po;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.alip.selenium.basePage.page;
import com.alip.selenium.po.elements.CampaignElem;
import com.alip.selenium.po.elements.CompletionListElem;
import com.alip.selenium.po.elements.CreateProjectElem;
import com.alip.selenium.po.elements.CrowdsourcingElem;
import com.alip.selenium.po.elements.DashBoardElem;
import com.alip.selenium.po.elements.EvaluationElem;
import com.alip.selenium.po.elements.FiltersElem;
import com.alip.selenium.po.elements.IdeaSignOffElem;
import com.alip.selenium.po.elements.IdeaSignOffListElem;
import com.alip.selenium.po.elements.LoginElem;
import com.alip.selenium.po.elements.MyProjectsElem;
import com.alip.selenium.po.elements.ProblemApprovalElem;
import com.alip.selenium.po.elements.ReadData;
import com.alip.selenium.po.elements.UndeImplListElem;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

      
public class DashBoardPage extends page {
	
	public LoginPage DBlogout() throws InterruptedException{
		Logout();
		return new LoginPage();
	}
	
	public CreateProjectPage NavCreateProject (String ProjType) throws InterruptedException  {
		Thread.sleep(300);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.PROFILE_SLIDER_BTN)));
		FindByCssSelector(DashBoardElem.PROFILE_SLIDER_BTN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROFILE_SLIDER)));
		String Proj=FindByCssSelector(DashBoardElem.SLT_PROJ_TYP).getText();
		System.out.println(Proj);
		Thread.sleep(300);
		FindByCssSelector(DashBoardElem.SLT_PROJ_TYP).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROJ_TYP)));
		
		List Proj_Type=page.driver.findElements(By.cssSelector(DashBoardElem.PROJ_TYP));
		int Proj_Type_CNT= Proj_Type.size();
		System.out.println("Proj type :"+Proj_Type_CNT);
		for (int i=1;i<=Proj_Type_CNT;i++){
		String 	Proj_Type_Val= FindByCssSelector(DashBoardElem.PROJ_TYP_1+i+DashBoardElem.PROJ_TYP_2).getText();
		Proj_Type_Val=Proj_Type_Val.replaceAll("[^A-Za-z]", "").toUpperCase();
		ProjType=ProjType.replaceAll("[^A-Za-z]", "").toUpperCase();
		System.out.println("Proj_Type_Val "+Proj_Type_Val+ " and "+ProjType);
			if (Proj_Type_Val.equalsIgnoreCase(ProjType)){
				FindByCssSelector(DashBoardElem.PROJ_TYP_1+i+DashBoardElem.PROJ_TYP_2).click();
				page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.CREATE_PROJ)));
				FindByCssSelector(DashBoardElem.CREATE_PROJ).click();
				page.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CreateProjectElem.REG_PAGE)));
				String proj=FindByCssSelector(CreateProjectElem.PROJ_TYPE).getText();
				proj=proj.replaceAll("[^A-Za-z]", "").toUpperCase();
				Assert.assertEquals(proj, Proj_Type_Val,"Project type is mismatch");
				break;
			}
		}
		
		return new CreateProjectPage () ;
		
	}
	
	public CreateProjectPage NavCreateProjectByUrl (String ProjType) throws InterruptedException  {
		Thread.sleep(300);
		String currentUrl = page.driver.getCurrentUrl();
		System.out.println("currentUrl:(actual )"+currentUrl);
		
			
			currentUrl = CONFG.getProperty("URL_HOMEPAGE").replaceAll("home", "")+DashBoardElem.REGISTRATION;
			System.out.println("currentUrl:(in if )"+currentUrl);
			
			
		page.driver.navigate().to(currentUrl);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CreateProjectElem.PROB_TXT)));
		
	
		return new CreateProjectPage () ;
		
	}
	
	
	public LoginPage NavLoginPageByUrl() throws InterruptedException  {
		Thread.sleep(300);
		String currentUrl = page.driver.getCurrentUrl();
		System.out.println("currentUrl:(actual )"+currentUrl);
		
			
			currentUrl = CONFG.getProperty("URL_HOMEPAGE").replaceAll("home", "");
			System.out.println("currentUrl:(in if )"+currentUrl);
			
			
		page.driver.navigate().to(currentUrl);
		Thread.sleep(1000);
		
			
		return new LoginPage() ;
		
	}
	
	
	public CampaignPage NavCampaignPageByUrl () throws InterruptedException  {
		Thread.sleep(300);
		String currentUrl = page.driver.getCurrentUrl();
		System.out.println("currentUrl:(actual )"+currentUrl);
			currentUrl = CONFG.getProperty("URL_HOMEPAGE").replaceAll("home", "")+DashBoardElem.CAMPAIGN;
			System.out.println("currentUrl:(in if )"+currentUrl);
			page.driver.navigate().to(currentUrl);
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CampaignElem.CAMPAIGNFORM)));
		
	
		return new CampaignPage () ;
		
	}
	
	
	public ProblemApprovalPage NavSponsorApprovalByURL() {
		String currentUrl = page.driver.getCurrentUrl();
		System.out.println("currentUrl:(actual )"+currentUrl);
		
			
			currentUrl = CONFG.getProperty("URL_HOMEPAGE").replaceAll("home", "")+DashBoardElem.INITPROBLEM_APPROVAL;
			System.out.println("currentUrl:(in if )"+currentUrl);
			
			
		page.driver.navigate().to(currentUrl);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProblemApprovalElem.FILTER_BTN)));
		return new ProblemApprovalPage () ;
		
	}
	
	public IdeaSignOffListPage NavIdeaSignOffListByURL() {
		String currentUrl = page.driver.getCurrentUrl();
		System.out.println("currentUrl:(actual )"+currentUrl);
		
			
			currentUrl = CONFG.getProperty("URL_HOMEPAGE").replaceAll("home", "")+DashBoardElem.IDEA_SIGNOFF;
			System.out.println("currentUrl:"+currentUrl);
			
			
		page.driver.navigate().to(currentUrl);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(IdeaSignOffElem.IDEASIGNOFF)));
		return new IdeaSignOffListPage()  ;
		
	}
public ProblemApprovalPage NavSponsorApproval() throws InterruptedException{
		
		/*while(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.PROJ_INIT_APPROVAL)) != null){
			System.out.println("test");
		}
		*/
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(DashBoardElem.PROJ_INIT_APPROVAL)));
		FindByCssSelector(DashBoardElem.PROJ_INIT_APPROVAL).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProblemApprovalElem.FILTER_BTN)));
		
		return new ProblemApprovalPage () ;
	}

public ProblemApprovalPage NavPendSponsorApproval() throws InterruptedException{
		Thread.sleep(1000);
		//boolean slider=FindByCssSelector(DashBoardElem.PROFILE_SLIDER);
		//System.out.println("slider :"+slider);
		if(!page.driver.findElements(By.cssSelector(DashBoardElem.PROFILE_SLIDER)).isEmpty()){
			Thread.sleep(1000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.SLIDER_CLOSE)));
			FindByCssSelector(DashBoardElem.SLIDER_CLOSE).click();	
			System.out.println("Click close");
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.PROJ_INIT_APPROVAL)));
		
		FindByCssSelector(DashBoardElem.PROJ_INIT_APPROVAL).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProblemApprovalElem.FILTER_BTN)));
		
		return new ProblemApprovalPage () ;
	}

public  ProjectTollGate  RegistrationView(String ExepProjectCode) throws InterruptedException{
	OutPutView( ExepProjectCode,DashBoardElem.REGISTRATION_ICON);
	return new ProjectTollGate() ;
	
}


public  IdeaListPage  GenerationView(String ExepProjectCode) throws InterruptedException{
	OutPutView( ExepProjectCode,DashBoardElem.GENERATION_ICON);
	return new IdeaListPage() ;
	
}

public  MyProjectsPage  NavMyProj(String ExepProjectCode) throws InterruptedException{
	FindByCssSelector(DashBoardElem.MYPROJECT).click();
	
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MyProjectsElem.PROJECT_STAGE)));
	return new MyProjectsPage() ;
	
}


public  CampaignPage  NavCampaignPage() throws InterruptedException{
	FindByCssSelector(DashBoardElem.CAMPAIGN_CREATE).click();
	
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CampaignElem.CAMPAIGNFORM)));
	return new CampaignPage() ;
	
}


public  CrowdSourcingPage  NavCrowdPage(String expCampaignTitle) throws InterruptedException{
	
	List CampaignRow=driver.findElements(By.cssSelector(DashBoardElem.CAMPAIGN_LIST));
	int Cnt=CampaignRow.size();
	System.out.println("Cnt Campaign :"+Cnt);
	for(int i=1;i<=Cnt;i++){
		
		String Camp_Title=FindByCssSelector(DashBoardElem.CAMPAIGN_PROJ_TITLE_1+i+DashBoardElem.CAMPAIGN_PROJ_TITLE_2).getText().trim();
		System.out.println("Camp_Title : "+Camp_Title+ " EXP Camp_Title : "+expCampaignTitle);
		if (Camp_Title.equalsIgnoreCase(expCampaignTitle.trim())){
			FindByCssSelector(DashBoardElem.CAMPAIGN_PROJ_TITLE_1+i+DashBoardElem.CAMPAIGN_PROJ_TITLE_2).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CrowdsourcingElem.CROWD_SOURCING_FORM)));
			break;
		}
				
		
	}
	
	
	Thread.sleep(500);
	
	return new CrowdSourcingPage() ;
	 
}


public  EvaluationPage  EvaluationView(String ExepProjectCode) throws InterruptedException{
	OutPutView( ExepProjectCode,DashBoardElem.EVALUATION_ICON);
	return new EvaluationPage() ;
	
}
public  void OutPutView(String ExepProjectCode, String Stages) throws InterruptedException{
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Stages)));
	System.out.println("Stages :"+Stages);
	FindByCssSelector(Stages).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.OUTPUT)));
	List projectRow=driver.findElements(By.cssSelector(DashBoardElem.OUTPUT));
	int projectRowCnt=projectRow.size();
	System.out.println("projectRowCnt :"+projectRowCnt);
	for (int i=1;i<=projectRowCnt;i++){
		String actualProjectCode=driver.findElement(By.cssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.OUTPUT_2)).getText();
		System.out.println("actualProjectCode :"+actualProjectCode.trim()+" and Exp ProjCode "+ExepProjectCode.trim());
		if (actualProjectCode.trim().equalsIgnoreCase(ExepProjectCode.trim())){
			System.out.println("i value ;"+i);
			String ProjectCode =FindByCssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.OUTPUT_2).getText();
			System.out.println("ProjectCode :"+ProjectCode);
			String ProjectName =FindByCssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.PROJECTNAME_2).getText();
			System.out.println("ProjectName :"+ProjectName);
			Thread.sleep(500);
			FindByCssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.ACTION_2).click();
			break;
			
		}
		
	}
	
	
}

public  FiltersPage OutPutViewCampaign(String ExepProjectCode,String Campaign, String Stages) throws InterruptedException{
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Stages)));
	System.out.println("Stages :"+Stages);
	FindByCssSelector(Stages).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DashBoardElem.OUTPUT)));
	List projectRow=driver.findElements(By.cssSelector(DashBoardElem.OUTPUT));
	int projectRowCnt=projectRow.size();
	System.out.println("projectRowCnt :"+projectRowCnt);
	for (int i=1;i<=projectRowCnt;i++){
		String actualProjectCode=driver.findElement(By.cssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.OUTPUT_2)).getText();
		System.out.println("actualProjectCode :"+actualProjectCode.trim()+" and Exp ProjCode "+ExepProjectCode.trim());
		if (actualProjectCode.trim().equalsIgnoreCase(ExepProjectCode.trim())){
			System.out.println("i value ;"+i);
			String ProjectCode =FindByCssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.OUTPUT_2).getText();
			System.out.println("ProjectCode :"+ProjectCode);
			String CampaignName =FindByCssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.PROJECTNAME_2).getText();
			System.out.println("Campaign :"+CampaignName);
			Thread.sleep(500);
			if (CampaignName.trim().equalsIgnoreCase(Campaign.trim())){
			FindByCssSelector(DashBoardElem.OUTPUT_1+i+DashBoardElem.IDEA_CNT).click();
			break;
			}
			
			
		}
		
	}
	
	return new FiltersPage();
}


public int ReturnStageCnt(String Stage){
	String Cnt = null;
	if(Stage.trim().equalsIgnoreCase("REGISTRATION")){
	Cnt= FindByCssSelector(DashBoardElem.REGISTRATION_ICON).getText();
	}else if(Stage.trim().equalsIgnoreCase("OBSERVATION")){
		 Cnt= FindByCssSelector(DashBoardElem.OBSERVATION).getText();
		}else if(Stage.trim().equalsIgnoreCase("ANALYSIS")){
			Cnt= FindByCssSelector(DashBoardElem.ANALYSIS).getText();
			}else if(Stage.trim().equalsIgnoreCase("ACTION")){
				 Cnt= FindByCssSelector(DashBoardElem.ACTION).getText();
			}else if(Stage.trim().equalsIgnoreCase("CHECK")){
				 Cnt= FindByCssSelector(DashBoardElem.CHECK_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("STANDARDIZE")){
				 Cnt= FindByCssSelector(DashBoardElem.STANDARDIZE_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("CONCLUDE")){
				Cnt= FindByCssSelector(DashBoardElem.CONCLUDE_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("CAMPAIGN")){
				Cnt= FindByCssSelector(DashBoardElem.CAMPAIGN_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("GENERATION")){
				 Cnt= FindByCssSelector(DashBoardElem.GENERATION_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("EVALUATION")){
				 Cnt= FindByCssSelector(DashBoardElem.EVALUATION_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("SIGN-OFF")){
				 Cnt= FindByCssSelector(DashBoardElem.SIGNOFF_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("UNDER IMPL")){
				 Cnt= FindByCssSelector(DashBoardElem.UNDERIMPLEMENTATION_ICON).getText();
			}else if(Stage.trim().equalsIgnoreCase("COMPLETION")){
				 Cnt= FindByCssSelector(DashBoardElem.COMPLETION_ICON).getText();
			}
	String Val=Cnt.replaceAll("[^0-9]", "");
	int Count=Integer.valueOf(Val);
	return Count;
	
}
public  UnderImplementationPage  NavUnderImplement(String ExepProjectCode) throws InterruptedException{
	Actions action = new Actions(driver);
	OutPutView( ExepProjectCode,DashBoardElem.SIGNOFF_ICON);
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FiltersElem.TBL_ACTION)));
	FindByCssSelector(FiltersElem.TBL_ACTION).click();
	Thread.sleep(500);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(IdeaSignOffListElem.TBL_STATUS)));
	String acceptStatus=FindByCssSelector(IdeaSignOffListElem.TBL_STATUS).getText();
	System.out.println("acceptStatus :"+acceptStatus );
	action.sendKeys(Keys.PAGE_DOWN).perform();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EvaluationElem.NEXT)));
	FindByCssSelector(EvaluationElem.NEXT).click();
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UndeImplListElem.UNDERIMPL_FORM)));
	return new UnderImplementationPage() ;
	
}


public  CompletionListPage  NavCompletionListPage (String ExepProjectCode) throws InterruptedException{
	OutPutView( ExepProjectCode,DashBoardElem.UNDERIMPLEMENTATION_ICON);
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FiltersElem.TBL_ACTION)));
	FindByCssSelector(FiltersElem.TBL_ACTION).click();
	Thread.sleep(500);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(300);
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).perform();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(UndeImplListElem.NEXT_BTN)));
	Thread.sleep(300);
	FindByCssSelector(UndeImplListElem.NEXT_BTN).click();
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CompletionListElem.COMPL_FORM)));
	return new CompletionListPage () ;
	
}



}
