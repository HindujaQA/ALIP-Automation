package com.alip.selenium.po.elements;

public class GenerationElem {
	
	public static final String GEN_FORM = "#problemReg [name='generationForm']";
	public static final String GEN_PROJECT_NAME = ".//*[@id='problemReg']/form/div/div[3]/h2";
	public static final String GEN_PROJECT_CODE = ".//*[@id='problemReg']/form/div/div[4]/h2";
	public static final String GEN_PROJECT_TYPE = ".//*[@id='problemReg']/form/div/div[5]/h2";
	public static final String GEN_IDEA_CLASSIFIER= "#subCategory[name='ideaClassifier']";
	public static final String GEN_IDEA_TITLE = "#projectName[name='ideaTitle']";
	public static final String GEN_IDEA_DESC = "#Description";
	public static final String GEN_IDEA_TYPE = "#subCategory[name='ideaType']";
	public static final String GEN_IDEA_NO = "#projectName[ng-model='ideaNo']";
	public static final String GEN_LOB = ".ng-scope [model='lobItems'] .btn-group .btn.btn-small.dropdown-toggle";
	public static final String GEN_SEGMENT = ".ng-scope [model='segmentItems'] .btn-group .btn.btn-small.dropdown-toggle";
	public static final String GEN_SUB_SEGMENT = ".ng-scope [model='subSegmentItems'] .btn-group .btn.btn-small.dropdown-toggle";
	public static final String GEN_MODEL= ".ng-scope [model='modelItems'] .btn-group .btn.btn-small.dropdown-toggle";
	public static final String GEN_AGGREGATE= ".ng-scope [model='aggregateItems'] .btn-group .btn.btn-small.dropdown-toggle";
	public static final String GEN_LOB_BTN= ".ng-scope [model='lobItems'] li";
	public static final String GEN_SEGMENT_BTN = ".ng-scope [model='segmentItems'] li";
	public static final String GEN_SUB_SEGMENT_BTN = ".ng-scope [model='subSegmentItems'] li";
	public static final String GEN_MODEL_BTN= ".ng-scope [model='modelItems'] li";
	public static final String GEN_AGGREGATE_BTN= ".ng-scope [model='aggregateItems'] li";
	public static final String GEN_LOB_LIST= ".ng-scope [model='lobItems'] li:nth-of-type(";
	public static final String GEN_SEGMENT_LIST = ".ng-scope [model='segmentItems'] li:nth-of-type(";
	public static final String GEN_SUB_SEGMENT_LIST = ".ng-scope [model='subSegmentItems'] li:nth-of-type(";
	public static final String GEN_MODEL_LIST= ".ng-scope [model='modelItems'] li:nth-of-type(";
	public static final String GEN_AGGREGATE_LIST= ".ng-scope [model='aggregateItems'] li:nth-of-type(";
	public static final String GEN_EMP= ".ng-valid .ng-valid-required[placeholder='Type Emp ID / Name / Division']";
	public static final String GEN_EMP_LIST= ".ng-valid-required .autocomplete .ng-binding.ng-scope";
	public static final String GEN_EMP_LIST_1= ".ng-valid-required .autocomplete .ng-binding.ng-scope:nth-of-type(";
	public static final String GEN_EMP_ADD= ".btn.btn-primary.input-sm.emply-add-btn";
	public static final String GEN_SUBMIT= ".btn.btn-primary.input-sm[ng-click='saveBtnClick(1);']";
	public static final String GEN_NEXT= ".btn.btn-primary.input-sm[ng-click='nextBtnClick();']";
	
	public static final String GEN_SUCCESS=".alert.alert-success.submit-sucess";
	public static final String GEN_SUCCESS_MSG="Idea submitted successfully!";
	
	
}
