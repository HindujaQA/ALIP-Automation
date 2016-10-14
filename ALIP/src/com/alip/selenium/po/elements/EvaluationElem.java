package com.alip.selenium.po.elements;

public class EvaluationElem {

	public static final String EVAL_FORM = "#problemReg [name='eveluationForm']";
	public static final String EVAL_TITLE = "#problemReg .page-header:nth-child(1)";
	public static final String IDEA_NO = "#problemReg >form >div >div:nth-child(3) >div >h2";
	public static final String IDEA_TITLE = ".col-md-8 .margin-bottom-20.lg-margin-btm-36";
	public static final String PJCT_NAME = "#problemReg >form >div >div:nth-child(5) >div >h2";
	public static final String PJCT_CODE = "#problemReg >form >div >div:nth-child(6) >h2";
	public static final String PJCT_TYPE = "#problemReg >form >div >div:nth-child(7) >h2";
	public static final String PRIORITY = "#subCategory[ng-model='priorityID']";
	public static final String MINOR_IDEA = "#subCategory[ng-model='minorIdeaId']";
	public static final String COMMENTS = "#Description[ng-model='comments']";
	public static final String IMPACT_DRPDWN = "#subCategory[ng-model='impactId']";
	public static final String FEASIBILITY = "#subCategory[ng-model='feasibilityId']";
	public static final String BACK_UP_IDEA = ".ng-valid-parse.ng-touched[ng-model='backUpFlag']";
	public static final String BACK_UP_IDEA_NO = "#subCategory[ng-model='backUpIdeaNumber']";
	public static final String CANCEL_IDEA = ".col-md-6 #cancelIdea[ng-model='cancelFlag']";
	public static final String IDEA_ON_HOLD = ".col-md-6 #onHold[ng-model='ideaOnHoldFlag']";
	public static final String KPI_TITLE = "#problemReg .page-header:nth-child(2)>h1";
	public static final String KPICODE = ".ng-valid-required[placeholder='Type KPI code / KPI Name / UOM']";
	public static final String KPICODE_AUTO=".autocomplete .ng-binding.ng-scope";
	public static final String KPICODE_AUTO_1=".autocomplete .ng-binding.ng-scope:nth-of-type(";
	public static final String IMPACT = "#gembaUnitName[ng-model='impactVal']";
	public static final String SOB = "#gembaUnitName[ng-model='sob']";
	public static final String ONE_TIME = "#gembaUnitName[ng-model='oneTime']";
	public static final String ACR_SAVINGS = ".ng-pristine.ng-untouched.ng-valid[ng-model='autoCompute']";
	public static final String RECURR_ANNUM = "#gembaUnitName[ng-model='annum']";
	public static final String KPI_ADD_BTN = ".btn.KPI-add-btn";
	
	/*public static final String TBL_KPI_CODE = "";
	public static final String TBL_KPI_NAME = "";
	public static final String TBL_UOM = "";
	public static final String TBL_IMPCT = "";
	public static final String TBL_RS = "";
	public static final String TBL_OTS = "";*/
	public static final String CUR_METHOD = "#Description[ng-model='currentMethod']";
	public static final String ADV = "#Description[ng-model='advantages']";
	public static final String IB = "#Description[ng-model='intangibleBenefits']";
	public static final String DOWNSIDES = "#Description[ng-model='downsides']";
	public static final String INVES_DETAILS_TITLE = "#problemReg .page-header:nth-child(4)>h1";
	public static final String CAP = "#projectName[ng-model='capital']";
	public static final String NON_CAP = "#projectName[ng-model='nonCapital']";
	public static final String RECURR = "#projectName[ng-model='recurring']";
	public static final String EVAL_TEAM_TITLE = "#problemReg .page-header:nth-child(3)>h1";
	public static final String EMP_NAME = ".ng-valid.ng-valid-required[placeholder='Type Emp ID / Name / Division']";
	public static final String EMP_NAME_AUTO=".autoCompleteInput[ng-model='employeeVal'] .autocomplete .ng-binding.ng-scope";
	public static final String EMP_NAME_AUTO_1=".autoCompleteInput[ng-model='employeeVal'] .autocomplete .ng-binding.ng-scope:nth-of-type(";
	public static final String MAIL_ID = "#projectName[ng-model='employeeMailID']";
	public static final String SEQ_NO = "#projectName[ng-model='sequenceNumber']";
	public static final String EMP_ADD_BTN = ".btn.btn-primary.input-sm.emply-add-btn.margin-bottom-20";
	public static final String TBL_EVAL_ID = "";
	public static final String TBL_EVAL_NAME = "";
	public static final String TBL_MAIL = "";
	public static final String TBL_SEQ = "";
	public static final String TBL_ACP_TYPE = "";
	public static final String TBL_CMTS = "";
	public static final String SAVE = ".saveBtn[ng-show='showSaveBtn']";
	public static final String SUBMIT = ".submitBtn[ng-show='showSubmitBtn']";
	public static final String EVAL_SUCCESS_MSG="Idea submitted for Evaluation!";
	public static final String EVAL_SUCCESS=".alert.alert-success.submit-sucess";
	public static final String NEXT = ".NextpageBtn[ng-show='showNextBtn']";
	
	
}
