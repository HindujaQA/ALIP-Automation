package com.alip.selenium.po.elements;

public class ObservationProjectElem {
	
public static final String OBSERVATION_FORM = ".ng-pristine[name='observationForm']";
public static final String OBSERVATION_TITLE = ".page-header>h1";
public static final String OBSERVATION_PROJECT_NAME = ".//*[@id='problemReg']/form/div/div[3]/h2";
public static final String OBSERVATION_PROJECT_CODE = ".//*[@id='problemReg']/form/div/div[4]/h2";
public static final String OBSERVATION_PROJECT_TYPE = ".//*[@id='problemReg']/form/div/div[5]/h2";
public static final String OBSERVATION_DESC="#Description";
public static final String OBSERVATION_QC_TOOLS = ".ng-scope[dropdown-title='Select QC Tools'] .btn-group .dropdown-toggle";
public static final String OBSERVATION_QC_TOOLS_BTN = ".ng-scope[dropdown-title='Select QC Tools'] li";
public static final String OBSERVATION_ACT_ST_DATE = "#datepicker[ng-model='observation_plannedStartDate']";
public static final String OBSERVATION_ACT_END_DATE ="#datepicker1[ng-model='observation_plannedEndDate']";
public static final String OBSERVATION_SUBMIT = ".submitBtn .btn.btn-primary.input-sm[ng-click='saveBtnClick(1);']";
public static final String OBSERVATION_NEXT = ".NextpageBtn[ng-show='showNextBtn']";
public static final String OBSERVATION_QC_TOOL_DRPDWN_1=".ng-scope[dropdown-title='Select QC Tools'] li:nth-of-type(";
public static final String OBSERVATION_QC_TOOL_DRPDWN_2=")";
public static final String OBSERVATION_QC_TOOL_LIST_CHK=".ng-scope[dropdown-title='Select QC Tools'] li:nth-of-type(";
public static final String OBSERVATION_QC_TOOL_LIST_CHK_1=") .ng-pristine";
public static final String OBSERVATION_SUCCESS_MSG="Observation submitted successfully!";
public static final String OBSERVATION_SUCCESS=".alert.alert-success.submit-sucess";

}
