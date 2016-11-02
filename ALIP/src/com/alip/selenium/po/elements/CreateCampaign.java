package com.alip.selenium.po.elements;

public class CreateCampaign {

	public static final String PROJECT = "#subCategory[ng-model='projectListVal']";
	public static final String CAMPAIGN_NAME = "#projectName[ng-model='campaignValue']";
	public static final String OBJECTIVE = "#Description[ng-model='objective']";
	public static final String USER_GROUP = ".col-md-4 [dropdown-title='Select user group.'] .btn-group button:nth-child(2)";
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
}
