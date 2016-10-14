package com.alip.selenium.po.elements;

public class AnalysisElem {

	public static final String ANALYSIS_FORM = ".ng-pristine[name='analysisForm']";
	public static final String ANALYSIS_PROJECT_NAME = ".//*[@id='problemReg']/form/div/div[3]/h2";
	public static final String ANALYSIS_PROJECT_CODE = ".//*[@id='problemReg']/form/div/div[4]/h2";
	public static final String ANALYSIS_PROJECT_TYPE = ".//*[@id='problemReg']/form/div/div[5]/h2";
	public static final String PJCT_NAME = ".col-md-8  .margin-bottom-20.lg-margin-btm-36.ng-binding";
	//public static final String PJCT_CODE = "";
	public static final String ANLYS_DESC = "#Description[ng-model='analysis_Analysis']";
	public static final String PBL_TABLE = "#problemCause_table .ng-scope";
	public static final String PBL_CAUSE_NAME = "#projectName[ng-model='probableCauseValue']";
	
	public static final String PBL_ADD = ".btn.btn-primary.input-sm.KPI-add-btn";
	//public static final String PBL_SNO = ".ng-scope:nth-of-type(1) >td:nth-of-type(";
	//public static final String PBL_SNO1 = ")";
	public static final String PBL_CAUSE = "#projectName[ng-model='probableCauseValue']";

	public static final String ROOT_TITLE = "";
	public static final String ROOT_CAUSE_NAME = "";
	public static final String ROOT_ADD = ".btn.btn-primary.input-sm.KPI-root-add-btn";
	public static final String ROOT_TABLE = "#rootCause_table .ng-scope";
	public static final String ROOT_SNO = "";
	public static final String ROOT_CAUSE = "#projectName[ng-model='analysis_rootCause']";

	public static final String ACT_ST_DATE = "#datepicker1[ng-model='analysis_plannedStartDate']";
	public static final String ACT_END_DATE = "#datepicker2[ng-model='analysis_plannedEndDate']";
	public static final String QC_TOOLS = ".ng-scope[dropdown-title='Select QC Tools'] .btn-group .dropdown-toggle";
	public static final String QC_TOOLS_BTN = ".ng-scope[dropdown-title='Select QC Tools'] li";
	public static final String ANLYS_QC_TOOL_DRPDWN_1=".ng-scope[dropdown-title='Select QC Tools'] li:nth-of-type(";
	public static final String ANLYS_QC_TOOL_LIST_CHK=".ng-scope[dropdown-title='Select QC Tools'] li:nth-of-type(";
	public static final String ANLYS_SAVE = ".col-md-offset-8 .saveBtn[ng-show='showSaveBtn']";
	public static final String ANLYS_SUBMIT = ".col-md-offset-8 .submitBtn[ng-show='showSubmitBtn']";
	public static final String ANLYS_NEXT_BTN = ".col-md-offset-8 .NextpageBtn[ng-show='showNextBtn']";
	public static final String ANLYS_SUCCESS_MSG="Analysis submitted successfully!";
	public static final String ANLYS_SUCCESS=".alert.alert-success.submit-sucess";
}
