package com.alip.selenium.po.elements;

public class ProjecttollgatElem {
	public static final String TABLE= "#checklistTable";
	public static final String PTG_TITLE = ".page-header .ng-binding";
	public static final String PTG_TITLE1 = ".page-header>h2";
	public static final String MOD_STATUS = ".moderationStatus.capitalize.ng-binding";
	public static final String MOD_COMMENT = ".moderationComments.capitalize.ng-binding";
	public static final String TABLE_SNO_TXT = ".col-md-1.col-lg-1.text-right-align";
	public static final String TABLE_SNO = "#checklistTable .ng-scope .text-right-align";
	public static final String TABLE_SNO_1 = "#checklistTable .ng-scope:nth-child(";
	public static final String TABLE_SNO_2=	") .text-right-align";
	
	public static final String TABLE_KMILESTONE_TXT = ".col-md-5.col-lg-5.text-Left-align";
	public static final String TABLE_KMILESTONE= "#checklistTable .ng-scope .text-Left-align.ng-binding";
	public static final String TABLE_KMILESTONE_1 = "#checklistTable .ng-scope:nth-child(";
	public static final String TABLE_KMILESTONE_2 = ") .text-Left-align.ng-binding";
	
	public static final String TABLE_RYG_STATUS_TXT = ".col-md-2.col-lg-2.text-Left-align";
	public static final String TABLE_RYG_STATUS= "#checklistTable .ng-scope .text-Left-align.ng-binding";
	public static final String TABLE_RYG_STATUS_1 = "#checklistTable .ng-scope:nth-child(";
	public static final String TABLE_RYG_STATUS_RED = ") .rygStatus.statusRed.floatLeft.marginRight-10";
	public static final String TABLE_RYG_STATUS_YELLOW = ") .rygStatus.statusYellow.floatLeft.marginRight-10";
	public static final String TABLE_RYG_STATUS_GREEN = ") .rygStatus.statusGreen.floatLeft.marginRight-10";
	
	
	
	public static final String TABLE_REMARKS_TXT = ".col-md-4.col-lg-4.text-Left-align";
	public static final String TABLE_REMARKS= "#checklistTable .ng-scope .text-Left-align.ng-binding";
	public static final String TABLE_REMARKS_1 = "#checklistTable .ng-scope:nth-child(";
	public static final String TABLE_REMARKS_2 = ") .form-control.input-sm.ng-pristine.ng-untouched.ng-valid";
	
	public static final String SUBMIT = ".submitBtn[ng-show='showSubmitBtn']";
	public static final String MODERATION_STATUS = ".pending-msg .moderationStatus";
	public static final String MODERATION_STATUS_TXT = "pending for sponsor approval";
	public static final String MODERATION_APPROVED_TXT = "Approved";
	public static final String PREV = ".prevPageBtn[ng-show='showPreviousBtn']";
	public static final String NEXT = ".NextpageBtn[ng-show='showNextBtn']";
}
