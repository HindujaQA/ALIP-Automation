package com.alip.selenium.po.elements;

public class CampaignElem {

	public static final String CAMPAIGNFORM = "#problemReg [name='campaignForm']";
	public static final String PROJECT = "#subCategory[ng-model='projectListVal']";
	public static final String CAMPAIGN_NAME = "#projectName[ng-model='campaignValue']";
	public static final String OBJECTIVE = "#Description[ng-model='objective']";
	public static final String USER_GROUP = ".col-md-4 [dropdown-title='Select user group.'] .btn-group button:nth-child(2)";
	public static final String USER_GROUP_DRP_DOWN = ".ng-scope[dropdown-title='Select user group.'] li";
	public static final String USER_GROUP_DRPDWN_1="[dropdown-title='Select user group.'] li:nth-of-type(";
    public static final String USER_GROUP_DRPDWN_2=")";
    public static final String USER_GROUP_LIST_CHK=".ng-scope[dropdown-title='Select user group.'] li:nth-of-type(";
    
	public static final String FUNC_UNIT = ".col-md-4 [dropdown-title='Select functional Unit.'] .btn-group button:nth-child(2)";
	public static final String FUNC_UNIT_DRP_DOWN = ".ng-scope[dropdown-title='Select functional Unit.'] li";
	public static final String FUNC_UNIT_DRPDWN_1="[dropdown-title='Select functional Unit.'] li:nth-of-type(";
    public static final String FUNC_UNIT_DRPDWN_2=")";
    public static final String FUNC_UNIT_LIST_CHK=".ng-scope[dropdown-title='Select functional Unit.'] li:nth-of-type(";
    
    public static final String GRADE_DRP = ".col-md-4 [dropdown-title='Select grade.'] .btn-group button:nth-child(2)";
	public static final String GRADE_DRP_DOWN = ".ng-scope[dropdown-title='Select grade.'] li";
	public static final String GRADE_DRPDWN_1="[dropdown-title='Select grade.'] li:nth-of-type(";
    public static final String GRADE_DRPDWN_2=")";
    public static final String GRADE_LIST_CHK=".ng-scope[dropdown-title='Select grade.'] li:nth-of-type(";
    
    public static final String DEPARTMENT = ".col-md-4 [dropdown-title='Select department.'] .btn-group button:nth-child(2)";
	public static final String DEPT_DRP_DOWN = ".ng-scope[dropdown-title='Select department.'] li";
	public static final String DEPT_DRPDWN_1="[dropdown-title='Select department.'] li:nth-of-type(";
    public static final String DEPT_DRPDWN_2=")";
    public static final String DEPT_LIST_CHK=".ng-scope[dropdown-title='Select department.'] li:nth-of-type(";
    
    
	public static final String FUNCTIONAL_UNIT = ".col-md-4 [dropdown-title='Select functional Unit.'] .btn-group button:nth-child(2)";
	public static final String GRADE = ".col-md-4 [dropdown-title='Select grade.'] .btn-group button:nth-child(2)";
	public static final String DEPT = ".col-md-4 [dropdown-title='Select department.'] .btn-group button:nth-child(2)";
	public static final String VALID_FROM = "#datepicker[ng-model='validFrom']";
	public static final String VALID_TO = "#datepicker1[ng-model='validTo']";
	public static final String DWNLD_TEMPLATE = ".btn.btn-primary.input-sm[ng-click='downloadTemplete();']";
	public static final String BROWSE = ".Upload_section .col-md-12 .fileUpload";
	public static final String UPLOAD = ".btn.btn-primary.input-sm[ng-click='uploadTemplete();']";
	public static final String SAVE = ".saveBtn[ng-show='showSaveBtn']";
	public static final String SUBMIT = ".submitBtn[ng-show='showSubmitBtn']";
	 public static final String SUBMIT_SUCESS_MSG=".submit-sucess";
	   // public static final String NEXTBTN="#problemReg .NextpageBtn[ng-show='showNextBtn'] .btn";
	    public static final String SUCESS_MSG="Campaign submitted successfully!";
	    public static final String SAVE_MSG="Campaign saved successfully!";
	   
}
