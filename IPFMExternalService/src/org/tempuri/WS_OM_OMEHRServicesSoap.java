/**
 * WS_OM_OMEHRServicesSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface WS_OM_OMEHRServicesSoap extends java.rmi.Remote {

    /**
     * Get_LogK2_ChangeApprover_Input_DataSet
     */
    public org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult get_LogK2_ChangeApprover_Input_DataSet(org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetDs ds) throws java.rmi.RemoteException;

    /**
     * ListAllemployeeunderApprover_Input_DataSet
     */
    public org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult listAllemployeeunderApprover_Input_DataSet(java.lang.String pinManager, java.lang.String positionManager, org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs ds) throws java.rmi.RemoteException;

    /**
     * ListEmployeeProfileByPIN_MultiPosition
     */
    public org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult listEmployeeProfileByPIN_MultiPosition(java.lang.String pin) throws java.rmi.RemoteException;

    /**
     * List_EmpProfile_Time_ChangeApprover_Input_DataSet
     */
    public org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult list_EmpProfile_Time_ChangeApprover_Input_DataSet(org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetDs ds) throws java.rmi.RemoteException;

    /**
     * GetChangeApproverK2_Summary
     */
    public org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getChangeApproverK2_Summary(java.lang.String startDate, java.lang.String end_Date, java.lang.String status, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * List_LogK2_ChangeApprover_Detail
     */
    public org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult list_LogK2_ChangeApprover_Detail(java.lang.String log_Date, java.lang.String type, java.lang.String status) throws java.rmi.RemoteException;

    /**
     * GetOrgInfobyOrgCode_IN_DataSet
     */
    public org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getOrgInfobyOrgCode_IN_DataSet(org.tempuri.GetOrgInfobyOrgCode_IN_DataSetDs ds) throws java.rmi.RemoteException;

    /**
     * ListEmployeeProfileByPIN_InputDataSet Col Validate 'Pin','THFIRSTNAME','THLASTNAME'
     */
    public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult listEmployeeProfileByPIN_Input_DataSet(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetDs ds) throws java.rmi.RemoteException;

    /**
     * ListEmployeeProfileByPIN_Input_DataSetByPowerSearch
     */
    public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult listEmployeeProfileByPIN_Input_DataSetByPowerSearch(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs ds) throws java.rmi.RemoteException;

    /**
     * List Log OM TransForm
     */
    public org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult list_Log_OM_TransForm(java.lang.String processID, java.lang.String status, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException;

    /**
     * List Organization
     */
    public org.tempuri.ListOrganizeResponseListOrganizeResult listOrganize(java.lang.String lowerOrgCode, java.lang.String higherOrgCode) throws java.rmi.RemoteException;

    /**
     * List Organization Lower
     */
    public org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult listOrganizeLower(java.lang.String orgCode, java.lang.String level) throws java.rmi.RemoteException;

    /**
     * Get CostCenter
     */
    public org.tempuri.GetCostCenterResponseGetCostCenterResult getCostCenter(java.lang.String costcenter, java.lang.String companyCode) throws java.rmi.RemoteException;

    /**
     * List Organization Lower Input Parameter DataSet require column
     * Orgid
     */
    public org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult listOrganizeLowerByListOrg(org.tempuri.ListOrganizeLowerByListOrgDs ds) throws java.rmi.RemoteException;

    /**
     * List Organization Upper
     */
    public org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult listOrganizeUpper(java.lang.String orgCode, java.lang.String level) throws java.rmi.RemoteException;

    /**
     * Check manager
     */
    public boolean CHECKMANAGER(java.lang.String POSITION) throws java.rmi.RemoteException;

    /**
     * Get Manager By Organization Code
     */
    public java.lang.String getManagerByOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException;

    /**
     * Get organization Info By Boss Position ID
     */
    public org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult getOrgPersInfoByBossPostID(java.lang.String PIN, java.lang.String bossPosition, java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException;

    /**
     * Get organization Info By Organization HRM PIN
     */
    public org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getOrgPersInfoByOrgHRMPIN(java.lang.String PIN, java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException;

    /**
     * Get organization Info
     */
    public org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult getOrgPersInfo(java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException;

    /**
     * ListEmployee_By_CompanyCode Or Name OrPIN  Ex. ListEmployee_By_CompanyCode_Name_PIN('','','AIS')
     * or ListEmployee_By_CompanyCode_Name_PIN('','','AI')
     */
    public org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult listEmployee_By_CompanyCode_Name_PIN(java.lang.String pin, java.lang.String name, java.lang.String companyCode) throws java.rmi.RemoteException;

    /**
     * Get organization information by empID
     */
    public org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult getAllOrgInfobyEmpID(java.lang.String pin) throws java.rmi.RemoteException;

    /**
     * Get organization information by orgcode
     */
    public org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult getOrgInfobyOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException;

    /**
     * List pins that belong to the organization by orgcode
     */
    public org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult listPinsbyOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException;

    /**
     * Get StaffCount From OM_GEN_STAFFCOUNT By PositionID
     */
    public org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult getStaffCountByPositionID(java.lang.String position) throws java.rmi.RemoteException;

    /**
     * Get All of PG
     */
    public org.tempuri.GetAllPGResponseGetAllPGResult getAllPG() throws java.rmi.RemoteException;

    /**
     * Get Approver from Employee
     */
    public org.tempuri.GetApproverResponseGetApproverResult getApprover(java.lang.String empID) throws java.rmi.RemoteException;

    /**
     * Get Orgcode Profile And Staff Count By OrgCode
     */
    public org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getStaffCountbyOrgCode(java.lang.String orgcode) throws java.rmi.RemoteException;

    /**
     * Get OrganizationName Able to input multiple OrgCode Ex. GetOrganizationName(50013906,50013914)
     * or GetOrganizationName(50013906)
     */
    public org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getOrganizationName(java.lang.String vOrgCode) throws java.rmi.RemoteException;

    /**
     * Get Company By OrgCode
     */
    public org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getCompanyByOrgCode(java.lang.String vOrgID) throws java.rmi.RemoteException;

    /**
     * Get EmployeeID By Email
     */
    public org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getEmployeeIDByEmail(java.lang.String vEmail) throws java.rmi.RemoteException;

    /**
     * Get EmployeePosition And Organization. Able to input multiple
     * userid[userstamp] as must has separate. Ex. GetListEmployeePositionAndOrganization(ladawanv)
     * or GetListEmployeePositionAndOrganization(ladawanv,nuttanuy)
     */
    public org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult getListEmployeePositionAndOrganization(java.lang.String userStamp) throws java.rmi.RemoteException;

    /**
     * Get All EmployeeID Under OrgCode
     */
    public org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult listAllPinsUnderOrgCode(java.lang.String vOrgCode) throws java.rmi.RemoteException;

    /**
     * Get All EmployeeID Under OrgCode by PrefixPin
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult listAllPinsUnderOrgCodeByPrefixPin(java.lang.String vOrgCode, java.lang.String vPin) throws java.rmi.RemoteException;

    /**
     * Get All EmployeeID Under OrgCode by PrefixEmail
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult listAllPinsUnderOrgCodeByPrefixEmail(java.lang.String vOrgCode, java.lang.String vEmail) throws java.rmi.RemoteException;

    /**
     * Get All EmployeeID Under OrgCode by PrefixThaiName
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult listAllPinsUnderOrgCodeByPrefixThaiName(java.lang.String vOrgCode, java.lang.String vThName) throws java.rmi.RemoteException;

    /**
     * Get All EmployeeID Under OrgCode by PrefixThaiSurname
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult listAllPinsUnderOrgCodeByPrefixThaiSurName(java.lang.String vOrgCode, java.lang.String vThSurname) throws java.rmi.RemoteException;

    /**
     * Get All Position By PIN
     */
    public org.tempuri.GetAllPositionResponseGetAllPositionResult getAllPosition(java.lang.String vPin) throws java.rmi.RemoteException;

    /**
     * Search Organization information By Company Code and (Org Name
     * or OrgCode)
     */
    public org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult searchOrgInfoByOrgCodeOrOrgDesc(java.lang.String vCompanyCode, java.lang.String vOrgDesc) throws java.rmi.RemoteException;

    /**
     * Search Organization information By Company Code and Org Name
     */
    public org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult searchOrgInfo(java.lang.String vCompanyCode, java.lang.String vOrgDesc) throws java.rmi.RemoteException;

    /**
     * Get List TemporaryPin Able to input multiple pin as must has
     * separate. Ex.ListEmployeeProfileByPIN("00007851") or ListEmployeeProfileByPIN("00007851","00020389").
     */
    public org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult listTemporaryPinByNewPin(java.lang.String pin) throws java.rmi.RemoteException;

    /**
     * Get All Company Data,have employee in ehr
     */
    public org.tempuri.GetAllCompanyResponseGetAllCompanyResult getAllCompany() throws java.rmi.RemoteException;

    /**
     * Get Employee Profile
     */
    public org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getEmployeeProfile(java.lang.String vPin) throws java.rmi.RemoteException;

    /**
     * Get Organization Detail
     */
    public org.tempuri.GetOrganizationResponseGetOrganizationResult getOrganization(java.lang.String orgcode, java.lang.String orgname, java.lang.String orgdesc) throws java.rmi.RemoteException;

    /**
     * List for EmployeeProfile by PIN And Organization. Able to input
     * multiple pin as must has separate. Ex.ListEmployeeProfileByPIN("00007851")
     * or ListEmployeeProfileByPIN("00007851","00020389").
     */
    public org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult listEmployeeProfileByPIN(java.lang.String pin) throws java.rmi.RemoteException;

    /**
     * Get ApproverProfile by PIN And Organization. Able to input
     * single pin only.
     */
    public org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getApproverProfileByPIN(java.lang.String pin) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix English Name. Recommend using
     * for AutoComplete Text. Able to input single prefix English name only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult getEmployeeProfileByPrefixEngName(java.lang.String empEngName) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix English lastname. Recommend using
     * for AutoComplete Text. Able to input single prefix English lastname
     * only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult getEmployeeProfileByPrefixEngLastName(java.lang.String empEngLastName) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix Thai Name. Recommend using for
     * AutoComplete Text. Able to input single prefix Thai name only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getEmployeeProfileByPrefixThaiName(java.lang.String empThaiName) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix Thai lastname. Recommend using
     * for AutoComplete Text. Able to input single prefix Thai lastname only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult getEmployeeProfileByPrefixThaiLastName(java.lang.String empThaiLastName) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix email. Recommend using for AutoComplete
     * Text. Able to input single prefix email only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult getEmployeeProfileByPrefixEmail(java.lang.String empEmail) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix pin. Recommend using for AutoComplete
     * Text. Able to input single prefix pin only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getEmployeeProfileByPrefixPin(java.lang.String empPin) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix Organization code. Recommend
     * using for AutoComplete Text. Able to input single prefix Organization
     * code only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getEmployeeProfileByPrefixOrgcode(java.lang.String empOrgcode) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix Organization name. Recommend
     * using for AutoComplete Text. Able to input single Organization name
     * only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getEmployeeProfileByPrefixOrgname(java.lang.String empOrgname) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Prefix Organization description. Recommend
     * using for AutoComplete Text. Able to input single Organization description
     * only.
     */
    public org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult getEmployeeProfileByPrefixOrgdesc(java.lang.String empOrgdesc) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By Email Ex. 'ladawanv%' or 'ladawanv@ais.co.th'
     */
    public org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult getEmployeeProfileByEmail(java.lang.String vEmail) throws java.rmi.RemoteException;

    /**
     * List All Alll Approver By pin,postition
     */
    public org.tempuri.ListAllApproverResponseListAllApproverResult listAllApprover(java.lang.String pin, java.lang.String position) throws java.rmi.RemoteException;

    /**
     * List Employee Profile Under Approver
     */
    public org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getListEmployeeUnderApprover(java.lang.String pin) throws java.rmi.RemoteException;

    /**
     * Get Job Key
     */
    public org.tempuri.GetJobKeyResponseGetJobKeyResult getJobKey(java.lang.String jobKey) throws java.rmi.RemoteException;

    /**
     * Search Employee Detail
     */
    public org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult searchEmpDetail(java.lang.String co, java.lang.String bu, java.lang.String dp, java.lang.String sc, java.lang.String fc, java.lang.String engName, java.lang.String engSurName, java.lang.String thName, java.lang.String thSurName, java.lang.String pos, java.lang.String nickName, java.lang.String job, java.lang.String pin, java.lang.String userStamp, java.lang.String telNo, java.lang.String mobileNo, java.lang.String managerName) throws java.rmi.RemoteException;

    /**
     * Search Employee ID,Employee Name,Employee SurName,Org ID,OrgName
     */
    public org.tempuri.Search_EmployeeResponseSearch_EmployeeResult search_Employee(java.lang.String employee_ID, java.lang.String emp_Name, java.lang.String emp_Last_Name, java.lang.String ENGEmp_Name, java.lang.String ENGEmp_Last_Name, java.lang.String org_ID, java.lang.String org_Name) throws java.rmi.RemoteException;

    /**
     * List for Acting Approver by PIN And Prosition. (Input DataSet
     * Column PIN,PrositionID)
     */
    public org.tempuri.List_ActingApproverResponseList_ActingApproverResult list_ActingApprover(org.tempuri.List_ActingApproverDs ds) throws java.rmi.RemoteException;

    /**
     * List Organize By company Code organizecode and organizeLevel
     */
    public org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult listOrganizeByOrganizeLevel(java.lang.String companyCode, java.lang.String organizeLevel, java.lang.String organizeCode) throws java.rmi.RemoteException;

    /**
     * List Detail Employee
     */
    public org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult searchEmployeeOrg(java.lang.String employeeID, java.lang.String enName, java.lang.String enSurName, java.lang.String thName, java.lang.String thSurName, java.lang.String email, java.lang.String company, java.lang.String buname, java.lang.String buhname, java.lang.String orgname, java.lang.String dpname, java.lang.String positiondesc, java.lang.String positionid, java.lang.String EMPLOYEETYPE, java.lang.String EMPLOYEEGROUP) throws java.rmi.RemoteException;

    /**
     * List Line Approver For Position AVP UP  By Pin And Position
     * ID
     */
    public org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult list_LineApproverPositionAVPUP(java.lang.String pin, java.lang.String position) throws java.rmi.RemoteException;

    /**
     * List OrganizeLevel by CompanyCode
     */
    public org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult listOrganizeLevelByCompany(java.lang.String companyCode, java.lang.String organizeLevel) throws java.rmi.RemoteException;

    /**
     * Get EmployeeProfile By username or userstamp Ex. 'ladawanv'
     */
    public org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getEmployeeProfileByUsername(java.lang.String username) throws java.rmi.RemoteException;

    /**
     * ListLine's Organize By Organize's Code
     */
    public org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult listLineOrganizeByOrganizeCode(java.lang.String orgCode) throws java.rmi.RemoteException;

    /**
     * List OrgDesc By Prefix of OrgDesc. Recommend using for AutoComplete
     * Text. Able to input single and multiple prefix. Ex.ListGradeDescByPrefix("Per")
     */
    public org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult listOrgDescByPrefix(java.lang.String orgDesc) throws java.rmi.RemoteException;

    /**
     * List GradeDesc By Prefix of GradeDesc. Recommend using for
     * AutoComplete Text. Able to input single and multiple prefix. Ex.ListGradeDescByPrefix("Advanc")
     */
    public org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult listGradeDescByPrefix(java.lang.String gradeDesc) throws java.rmi.RemoteException;
}
