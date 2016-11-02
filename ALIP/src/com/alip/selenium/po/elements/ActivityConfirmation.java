package com.alip.selenium.po.elements;
public class ActivityConfirmation {
	public static final String AC_TITLE = ".page-header>h1";
	public static final String PJCT_NAME = ".ng-pristine >div >div:nth-child(3) >h2";
	public static final String PJCT_CODe = ".ng-pristine >div >div:nth-child(4) >h2";
	public static final String PJCT_TYPE = ".ng-pristine >div >div:nth-child(5) >h2";
	public static final String IDEA_NO = "#projectName[ng-model='ideaNo']";
	public static final String IDEA_TITLE = "#projectName[ng-model='ideaTitle']";
    public static final String ACTV_NAME = "#projectName[ng-model='activityName']";
	public static final String RS_MEM = "#projectName[ng-model='memberName']";
	public static final String S_ST_DATE = ".form-control.input-sm.date-field.margin-bottom-20.ng-pristine.ng-untouched.ng-valid[ng-model='scheduledStartDate']";
	public static final String S_END_DATE=".form-control.input-sm.margin-bottom-20.date-field.ng-pristine.ng-untouched.ng-valid[ng-model='scheduledEndDate']"; 
	public static final String EST_HRS="#projectName[ng-model='estimatedHours']";
	public static final String ACT_ST_DATE = "#datepicker1[ng-model='actualStartDate']']";
	public static final String ACT_END_DATE="#datepicker2[ng-model='actualEndDate']";
	public static final String ACT_HRS_INV = "#projectName[ng-model='actualHoursInvested']";
	public static final String COMMENTS = "#Description[ng-model='command']";
	public static final String SUBMIT = ".submitBtn[ng-show='showSubmitBtn']";
}
