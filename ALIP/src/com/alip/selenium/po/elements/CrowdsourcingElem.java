package com.alip.selenium.po.elements;

public class CrowdsourcingElem {
	public static final String CROWD_SOURCING_FORM= "#problemReg [name='crowdForm']";
	public static final String CAMPAIGN = "#projectName[ng-model='campaignName']";
	public static final String PJCT_NAME = "#projectName[ng-model='projectName']";
	public static final String PJCT_CODE = "#gembaUnitName[ng-model='projectCode']";
	public static final String IDEA_TITLE = "#gembaUnitName[ng-model='ideaTitle']";
	public static final String IDEA_CLASSIFIER = "#subCategory[ng-model='ideaClassifierVal']";
	public static final String IDEA_DESC = "#Description[ng-model='ideaDescription']";
	public static final String CURR_METHOD = "#Description[ng-model='currentMethod']";
	public static final String ADD_INFO = "#Description[ng-model='proposedMethod']";
	//public static final String KPI_CODE = ".ng-valid.ng-valid-required[ng-model='searchParam']";
	
	 public static final String KPICODE=".ng-valid-required[placeholder='Type KPI code / KPI Name / UOM']";
	    public static final String KPICODE_AUTO="[ng-model='kpiCode'] .autocomplete  .ng-binding.ng-scope";
	    public static final String KPICODE_AUTO_1="[ng-model='kpiCode'] .autocomplete  .ng-binding.ng-scope:nth-of-type(";
	   
	public static final String IMPACT = "#gembaUnitName[ng-model='impactData']";
	public static final String RECR_ANNUM = "#gembaUnitName[ng-model='RecurringPerAnnum']";
	public static final String ONE_TIME = "#gembaUnitName[ng-model='oneTime']";
	public static final String KPI_ADD = ".btn.btn-primary.input-sm.KPI-add-btn.floatRight[ng-click='kpidetailsAdd();']";
	public static final String INTANGIBLE_BENEFITS = "#projectName[ng-model='intangibleBenefits']";
	public static final String KPI_TBL_KPI_CODE = ".table-responsive .table .ng-scope:nth-child(";
	public static final String KPI_TBL_KPI_CODE_1 = ") >td:nth-child(1)";
	public static final String KPI_TBL_KPI_NAME = ".table-responsive .table .ng-scope:nth-child(";
	public static final String KPI_TBL_KPI_NAME_1 = ") >td:nth-child(2)";
	public static final String KPI_TBL_UOM = ".table-responsive .table .ng-scope:nth-child(";
	public static final String KPI_TBL_UOM_1 = ") >td:nth-child(3)";
	public static final String KPI_TBL_IMPACT = ".table-responsive .table .ng-scope:nth-child(";
	public static final String KPI_TBL_IMPACT_1 = ") >td:nth-child(4)";
	public static final String KPI_TBL_RSA = ".table-responsive .table .ng-scope:nth-child(";
	public static final String KPI_TBL_RSA_1 = ") >td:nth-child(5)";
	public static final String KPI_TBL_OTS = ".table-responsive .table .ng-scope:nth-child(";
	public static final String KPI_TBL_OTS_1 = ") >td:nth-child(6)";
	public static final String KPI_TBL_DELETE = ".ng-scope>td>img";
	public static final String SAVE = ".saveBtn[ng-show='showSaveBtn']";
	public static final String SUBMIT = ".submitBtn[ng-show='showSubmitBtn']";
	public static final String SUBMIT_SUCESS_MSG=".submit-sucess";
	public static final String SUCESS_MSG="Crowd Sourcing submitted successfully";
	public static final String SAVE_MSG="Crowd Sourcing saved successfully.";
}
