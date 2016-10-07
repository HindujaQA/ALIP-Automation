package com.alip.selenium.po.elements;

import com.alip.selenium.basePage.page;
import com.alip.selenium.util.ReadExcel;



public class ReadData extends page {
	
	private static String UserName ;
	private static  String Password ;
	
	
			public String ReadUserName(){
			  UserName=testExcel.getStringCellData("Login", 2, "UserName");
				return UserName;
				
			}
			public String ReadPassword(){
				 Password=testExcel.getStringCellData("Login", 2, "Password");
				return Password;
				
			}
			public String ReadProjectCode(){
				String ProjectCode=testExcel.getStringCellData("Registration", 2, "ProjectCode");
				return ProjectCode;
				
			}
			public String ReadProjectType(){
				String Project_type=testExcel.getStringCellData("Registration", 2, "Project_type");
				return Project_type;
				
			}
			public String Readlocation(){
				String location=testExcel.getStringCellData("Registration", 2, "location");
				return location;
				
			}
			public String ReadProject_Name(){
				String Project_Name=testExcel.getStringCellData("Registration", 2, "Project_Name");
				return Project_Name;
				
			}
			public String ReadGemba_Unit(){
				String Gemba_Unit=testExcel.getStringCellData("Registration", 2, "Gemba_Unit");
				return Gemba_Unit;
				
			}
			public String ReadDescription(){
				String Description=testExcel.getStringCellData("Registration", 2, "Description");
				return Description;
				
			}
			public String ReadDivision(){
				String Division=testExcel.getStringCellData("Registration", 2, "Division");
				return Division;
				
			}
			public String ReadQC_Tools(){
				String QC_Tools=testExcel.getStringCellData("Registration", 2, "QC_Tools");
				return QC_Tools;
				
			}
			public String ReadCategory(){
				String Category=testExcel.getStringCellData("Registration", 2, "Category");
				return Category;
				
			}
			public String ReadSub_Category(){
				String Sub_Category=testExcel.getStringCellData("Registration", 2, "Sub_Category");
				return Sub_Category;
				
			}
			public String ReadProject_Planned(){
				String Project_Planned=testExcel.getStringCellData("Registration", 2, "Project_Planned");
				return Project_Planned;
				
			}
			public String ReadProject_Pl_end(){
				String Project_Pl_end=testExcel.getStringCellData("Registration", 2, "Project_Pl_end");
				return Project_Pl_end;
				
			}
			public String Parent_Project(){
				String Parent_Project=testExcel.getStringCellData("Registration", 2, "Parent_Project");
				return Parent_Project;
				
			}
			
			public String ReadCustomer(){
				String Customer=testExcel.getStringCellData("Registration", 2, "Customer");
				return Customer;
				
			}
			
			public String ReadProblem_start_date(){
				String Problem_start_date=testExcel.getStringCellData("Registration", 2, "Problem_start_date");
				return Problem_start_date;
				
			}
			public String ReadProblem_end_date(){
				String Problem_end_date=testExcel.getStringCellData("Registration", 2, "Problem_end_date");
				return Problem_end_date;
				
			}
			public String Readkeywords(){
				String keywords=testExcel.getStringCellData("Registration", 2, "keywords");
				return keywords;
				
			}
			public String ReadGantt_chart_plan(){
				String Gantt_chart_plan=testExcel.getStringCellData("Registration", 2, "Gantt_chart_plan");
				return Gantt_chart_plan;
				
			}
			public String ReadReg_Start_date(){
				String Reg_Start_date=testExcel.getStringCellData("Registration", 2, "Reg_Start_date");
				return Reg_Start_date;
			}
			public String ReadReg_end_date(){
				String Reg_end_date=testExcel.getStringCellData("Registration", 2, "Reg_end_date");
				return Reg_end_date;
				
			}
			public String ReadObservation_st_date(){
				String Observation_st_date=testExcel.getStringCellData("Registration", 2, "Observation_st_date");
				return Observation_st_date;
				
			}
			public String ReadObservation_end_date(){
				String Observation_end_date=testExcel.getStringCellData("Registration", 2, "Observation_end_date");
				return Observation_end_date;
				
			}
			public String ReadAnalysis_st_date(){
				String Analysis_st_date=testExcel.getStringCellData("Registration", 2, "Analysis_st_date");
				return Analysis_st_date;
				
			}
			public String ReadAnalysis_end_date(){
				String Analysis_end_date=testExcel.getStringCellData("Registration", 2, "Analysis_end_date");
				return Analysis_end_date;
				
			}
			public String ReadAction_Start_date(){
				String Action_st_date=testExcel.getStringCellData("Registration", 2, "Action_st_date");
				return Action_st_date;
				
			}
			public String ReadAction_end_date(){
				String Action_end_date=testExcel.getStringCellData("Registration", 2, "Action_end_date");
				return Action_end_date;
				
			}
			
			public String ReadCheck_Start_date(){
				String Check_Start_date=testExcel.getStringCellData("Registration", 2, "Check_Start_date");
				return Check_Start_date;
				
			}
			public String ReadCheck_end_date(){
				String Check_end_date=testExcel.getStringCellData("Registration", 2, "Check_end_date");
				return Check_end_date;
				
			}
			public String ReadStd_st_date(){
				String Std_st_date=testExcel.getStringCellData("Registration", 2, "Std_st_date");
				return Std_st_date;
				
			}
			public String ReadStd_end_date(){
				String Std_end_date=testExcel.getStringCellData("Registration", 2, "Std_end_date");
				return Std_end_date;
				
			}
			public String ReadConclude_st_date(){
				String Conclude_st_date=testExcel.getStringCellData("Registration", 2, "Conclude_st_date");
				return Conclude_st_date;
				
			}
			public String ReadConclude_end_date(){
				String Conclude_end_date=testExcel.getStringCellData("Registration", 2, "Conclude_end_date");
				return Conclude_end_date;
				
			}
			public String ReadKPI_code(){
				String KPI_code=testExcel.getStringCellData("Registration", 2, "KPI_code");
				System.out.println(KPI_code);
				return KPI_code;
				
			}
			public String ReadKPI_1(){
				String KPI_code=testExcel.getStringCellData("Registration", 2, "KPI_1");
				return KPI_code;
				
			}
			public String ReadKPI_2(){
				String KPI_code=testExcel.getStringCellData("Registration", 2, "KPI_2");
				return KPI_code;
				
			}
			public String ReadBaseline(){
				String Baseline=testExcel.getStringCellData("Registration", 2, "Baseline");
				return Baseline;
				
			}
			public String ReadTarget(){
				String Target=testExcel.getStringCellData("Registration", 2, "Target");
				return Target;
				
			}
			public String ReadKPI_Name(){
				String KPI_Name=testExcel.getStringCellData("Registration", 2, "KPI_Name");
				return KPI_Name;
				
			}
			public String ReadUOM(){
				String UOM=testExcel.getStringCellData("Registration", 2, "UOM");
				return UOM;
				
			}
			public String ReadAspiration(){
				String Aspiration=testExcel.getStringCellData("Registration", 2, "Aspiration");
				return Aspiration;
				
			}
			public String ReadRole(int i){
				String Role=testExcel.getStringCellData("Role", i, "Role");
				return Role;
				
			}
			public String ReadEmployee_name(int i){
				String Employee_name=testExcel.getStringCellData("Role", i, "Employee_name");
				return Employee_name;
				
			}
			public String ReadEmployee_name_1(int i){
				String Employee_name_1=testExcel.getStringCellData("Role", i, "Employee_name_1");
				return Employee_name_1;
				
			}
			public String ReadEmployee_name_2(int i){
				String Employee_name_2=testExcel.getStringCellData("Role", i, "Employee_name_2");
				return Employee_name_2;
				
			}
			
			public String ReadRoleProject(int i){
				String RoleProject=testExcel.getStringCellData("Role", i, "Project");
				return RoleProject;
				
			}
			public String ReadGrade(){
				String Grade=testExcel.getStringCellData("Registration", 2, "Grade");
				return Grade;
				
			}
			
		
			public String ReadMilestones(int i){
				String Milestones=testExcel.getStringCellData("Toll", i, "Milestones");
				return Milestones;
				
			}public String ReadRYG(int i){
				String RYG=testExcel.getStringCellData("Toll", i, "RYG");
				return RYG;
				
			}public String ReadRemarks(int i){
				String Remarks=testExcel.getStringCellData("Toll", i, "Remarks");
				return Remarks;
				
			}
			public String ReadPrjOwner(int i){
				String Project_Owner=testExcel.getStringCellData("Registration", i, "Project_Owner");
				return Project_Owner;
				
			}
			
			public void SetPrjcode(int i,String ProjCode){
				testExcel.setCellData("Registration", i, "ProjectCode", ProjCode);				
				
			}
			public void SetPrjOwner(int i,String PrjOwner){
				testExcel.setCellData("Registration", i, "Project_Owner", PrjOwner);				
				
			}
			

}
