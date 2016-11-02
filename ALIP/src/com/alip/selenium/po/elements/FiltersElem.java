package com.alip.selenium.po.elements;

public class FiltersElem {

	public static final String FILTER_FORM = "#problemReg";
	//public static final String GEN_TITLE = "";
	public static final String FILTER_BY = ".form-control.input-sm.ng-pristine[ng-model='filterByVal']";
	public static final String IDEA_STAGE = ".form-control.input-sm.ng-pristine[ng-model='searchStageVal']";
	public static final String PJCT_CODE = "#projectName[ng-model='filterprojectCode']";
	public static final String PJCT_NAME = "#projectName[ng-model='filterprojectName']";
	public static final String FILTER_BTN = ".btn.btn-primary.input-sm.marginTop-25[ng-click='filterData();']";
	public static final String FILTER_RST = ".btn.btn-primary.input-sm.marginTop-25[ng-click='resetData();']";
	public static final String RSLT_PJCT_CODE = ".table .ng-scope .text-Left-align.ng-binding";
	public static final String RSLT_PJCT_CODE_1 = ".table .ng-scope:nth-child(";
	public static final String RSLT_PJCT_CODE_2 = ") .text-Left-align.ng-binding";
	public static final String RSLT_PJCT_NAME_1 = ".table .ng-scope:nth-child(";
	public static final String RSLT_PJCT_NAME_2 = ") >td:nth-child(3) .projectName-ontable";
	public static final String TBL_IDEA_NO = ".table-responsive .table .ng-scope >td:nth-child(4)";
	public static final String TBL_IDEA_NO_1 =".table-responsive .table .ng-scope:nth-child(";
	public static final String TBL_IDEA_NO_2 =") >td:nth-child(4)";
	public static final String TBL_IDEA_TITLE = ".table-responsive .table .ng-scope >td:nth-child(5)";
	public static final String TBL_IDEA_TITLE_1 =".table-responsive .table .ng-scope:nth-child(";
	public static final String TBL_IDEA_TITLE_2 =") >td:nth-child(5)";
	public static final String TBL_ACTION = ".table-responsive .table .ng-scope >td:nth-child(6)";
	public static final String TBL_ACTION_1 =".table-responsive .table .ng-scope:nth-child(";
	public static final String TBL_ACTION_2 =") >td:nth-child(6) [ng-click='showideaDetails(dat);']";
	public static final String PG_LEFT_FIRST = ".paginationIcons[src='images/first.png']";
	public static final String PG_LEFT = ".paginationIcons[src='images/prev.png']";
	public static final String PG_RIGHT_NEXT = ".paginationIcons[src='images/next.png']";
	public static final String PG_RIGHT = ".paginationIcons[src='images/last.png']";
	
	//cAMPAIGN rESULT
	
	public static final String CAMPAIGN = "[ng-model='searchStageVal']";
	public static final String CAMP_PROJ_CODE = ".ng-pristine .col-md-4 .margin-bottom-20.ng-binding:nth-child(2)";
	public static final String SLT_TABLE = ".table .ng-scope [name='selectedideas[]']";
	public static final String SLT_ROW = ".table .ng-scope:nth-child(";
	public static final String SLT_IDEAS = ") [name='selectedideas[]']";
	public static final String IDEA_TITLE = ") .text-Left-align:nth-of-type(2)";
	public static final String IDEA_DESC = ") .text-Left-align:nth-of-type(3)";
	public static final String IDEA_OWNER = ") .text-Left-align:nth-of-type(4)";
	public static final String IDEA_STATUS = ") .text-Left-align:nth-of-type(5)";
	public static final String IDEA_ACTION = ") [ng-click='goTocrowdEditingPage(event,dat)'] .display-inlineBlock";
	public static final String IDEA_MERGE_BTN = ".btn.btn-primary.input-sm[ng-click='mergeIdeas();']";
	public static final String RELATED_IDEA_BTN = ".btn.btn-primary.input-sm[ng-click='showRelatedIdeas();']";
	public static final String CREATE_PROJ_BTN = ".btn.btn-primary.input-sm[ng-click='createProject();']";
	
}
