package org.tempuri;

public class WS_OM_OMEHRServicesSoapProxy implements org.tempuri.WS_OM_OMEHRServicesSoap {
  private String _endpoint = null;
  private org.tempuri.WS_OM_OMEHRServicesSoap wS_OM_OMEHRServicesSoap = null;
  
  public WS_OM_OMEHRServicesSoapProxy() {
    _initWS_OM_OMEHRServicesSoapProxy();
  }
  
  public WS_OM_OMEHRServicesSoapProxy(String username, String password) {
	_initWS_OM_OMEHRServicesSoapProxy(username, password);
  }  
  
  public WS_OM_OMEHRServicesSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_OM_OMEHRServicesSoapProxy();
  }
  
  public WS_OM_OMEHRServicesSoapProxy(String endpoint, String username, String password) {
	    _endpoint = endpoint;
	    _initWS_OM_OMEHRServicesSoapProxy(username, password);
  }  
  
  private void _initWS_OM_OMEHRServicesSoapProxy() {
    try {
      wS_OM_OMEHRServicesSoap = (new org.tempuri.WS_OM_OMEHRServicesLocator()).getWS_OM_OMEHRServicesSoap();
      if (wS_OM_OMEHRServicesSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
//      ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty(javax.xml.rpc.Stub.USERNAME_PROPERTY, "corp-aispilot\\ehr_test1");
//      ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty(javax.xml.rpc.Stub.PASSWORD_PROPERTY, "Ais.co.th");

    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  private void _initWS_OM_OMEHRServicesSoapProxy(String username, String password) {
	    try {
	      wS_OM_OMEHRServicesSoap = (new org.tempuri.WS_OM_OMEHRServicesLocator(username, password)).getWS_OM_OMEHRServicesSoap();
	      if (wS_OM_OMEHRServicesSoap != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	     
	      ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty(javax.xml.rpc.Stub.USERNAME_PROPERTY, username);
	      ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty(javax.xml.rpc.Stub.PASSWORD_PROPERTY, password);
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }  
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_OM_OMEHRServicesSoap != null)
      ((javax.xml.rpc.Stub)wS_OM_OMEHRServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.WS_OM_OMEHRServicesSoap getWS_OM_OMEHRServicesSoap() {
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap;
  }
  
  public org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult get_LogK2_ChangeApprover_Input_DataSet(org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.get_LogK2_ChangeApprover_Input_DataSet(ds);
  }
  
  public org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult listAllemployeeunderApprover_Input_DataSet(java.lang.String pinManager, java.lang.String positionManager, org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllemployeeunderApprover_Input_DataSet(pinManager, positionManager, ds);
  }
  
  public org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult listEmployeeProfileByPIN_MultiPosition(java.lang.String pin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listEmployeeProfileByPIN_MultiPosition(pin);
  }
  
  public org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult list_EmpProfile_Time_ChangeApprover_Input_DataSet(org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.list_EmpProfile_Time_ChangeApprover_Input_DataSet(ds);
  }
  
  public org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getChangeApproverK2_Summary(java.lang.String startDate, java.lang.String end_Date, java.lang.String status, java.lang.String type) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getChangeApproverK2_Summary(startDate, end_Date, status, type);
  }
  
  public org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult list_LogK2_ChangeApprover_Detail(java.lang.String log_Date, java.lang.String type, java.lang.String status) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.list_LogK2_ChangeApprover_Detail(log_Date, type, status);
  }
  
  public org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getOrgInfobyOrgCode_IN_DataSet(org.tempuri.GetOrgInfobyOrgCode_IN_DataSetDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrgInfobyOrgCode_IN_DataSet(ds);
  }
  
  public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult listEmployeeProfileByPIN_Input_DataSet(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listEmployeeProfileByPIN_Input_DataSet(ds);
  }
  
  public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult listEmployeeProfileByPIN_Input_DataSetByPowerSearch(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listEmployeeProfileByPIN_Input_DataSetByPowerSearch(ds);
  }
  
  public org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult list_Log_OM_TransForm(java.lang.String processID, java.lang.String status, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.list_Log_OM_TransForm(processID, status, startDate, endDate);
  }
  
  public org.tempuri.ListOrganizeResponseListOrganizeResult listOrganize(java.lang.String lowerOrgCode, java.lang.String higherOrgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrganize(lowerOrgCode, higherOrgCode);
  }
  
  public org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult listOrganizeLower(java.lang.String orgCode, java.lang.String level) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrganizeLower(orgCode, level);
  }
  
  public org.tempuri.GetCostCenterResponseGetCostCenterResult getCostCenter(java.lang.String costcenter, java.lang.String companyCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getCostCenter(costcenter, companyCode);
  }
  
  public org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult listOrganizeLowerByListOrg(org.tempuri.ListOrganizeLowerByListOrgDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrganizeLowerByListOrg(ds);
  }
  
  public org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult listOrganizeUpper(java.lang.String orgCode, java.lang.String level) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrganizeUpper(orgCode, level);
  }
  
  public boolean CHECKMANAGER(java.lang.String POSITION) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.CHECKMANAGER(POSITION);
  }
  
  public java.lang.String getManagerByOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getManagerByOrgCode(orgCode);
  }
  
  public org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult getOrgPersInfoByBossPostID(java.lang.String PIN, java.lang.String bossPosition, java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrgPersInfoByBossPostID(PIN, bossPosition, organization, name, nickName, position, tel, job);
  }
  
  public org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getOrgPersInfoByOrgHRMPIN(java.lang.String PIN, java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrgPersInfoByOrgHRMPIN(PIN, organization, name, nickName, position, tel, job);
  }
  
  public org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult getOrgPersInfo(java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrgPersInfo(organization, name, nickName, position, tel, job);
  }
  
  public org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult listEmployee_By_CompanyCode_Name_PIN(java.lang.String pin, java.lang.String name, java.lang.String companyCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listEmployee_By_CompanyCode_Name_PIN(pin, name, companyCode);
  }
  
  public org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult getAllOrgInfobyEmpID(java.lang.String pin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getAllOrgInfobyEmpID(pin);
  }
  
  public org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult getOrgInfobyOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrgInfobyOrgCode(orgCode);
  }
  
  public org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult listPinsbyOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listPinsbyOrgCode(orgCode);
  }
  
  public org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult getStaffCountByPositionID(java.lang.String position) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getStaffCountByPositionID(position);
  }
  
  public org.tempuri.GetAllPGResponseGetAllPGResult getAllPG() throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getAllPG();
  }
  
  public org.tempuri.GetApproverResponseGetApproverResult getApprover(java.lang.String empID) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getApprover(empID);
  }
  
  public org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getStaffCountbyOrgCode(java.lang.String orgcode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getStaffCountbyOrgCode(orgcode);
  }
  
  public org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getOrganizationName(java.lang.String vOrgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrganizationName(vOrgCode);
  }
  
  public org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getCompanyByOrgCode(java.lang.String vOrgID) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getCompanyByOrgCode(vOrgID);
  }
  
  public org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getEmployeeIDByEmail(java.lang.String vEmail) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeIDByEmail(vEmail);
  }
  
  public org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult getListEmployeePositionAndOrganization(java.lang.String userStamp) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getListEmployeePositionAndOrganization(userStamp);
  }
  
  public org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult listAllPinsUnderOrgCode(java.lang.String vOrgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllPinsUnderOrgCode(vOrgCode);
  }
  
  public org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult listAllPinsUnderOrgCodeByPrefixPin(java.lang.String vOrgCode, java.lang.String vPin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllPinsUnderOrgCodeByPrefixPin(vOrgCode, vPin);
  }
  
  public org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult listAllPinsUnderOrgCodeByPrefixEmail(java.lang.String vOrgCode, java.lang.String vEmail) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllPinsUnderOrgCodeByPrefixEmail(vOrgCode, vEmail);
  }
  
  public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult listAllPinsUnderOrgCodeByPrefixThaiName(java.lang.String vOrgCode, java.lang.String vThName) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllPinsUnderOrgCodeByPrefixThaiName(vOrgCode, vThName);
  }
  
  public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult listAllPinsUnderOrgCodeByPrefixThaiSurName(java.lang.String vOrgCode, java.lang.String vThSurname) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllPinsUnderOrgCodeByPrefixThaiSurName(vOrgCode, vThSurname);
  }
  
  public org.tempuri.GetAllPositionResponseGetAllPositionResult getAllPosition(java.lang.String vPin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getAllPosition(vPin);
  }
  
  public org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult searchOrgInfoByOrgCodeOrOrgDesc(java.lang.String vCompanyCode, java.lang.String vOrgDesc) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.searchOrgInfoByOrgCodeOrOrgDesc(vCompanyCode, vOrgDesc);
  }
  
  public org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult searchOrgInfo(java.lang.String vCompanyCode, java.lang.String vOrgDesc) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.searchOrgInfo(vCompanyCode, vOrgDesc);
  }
  
  public org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult listTemporaryPinByNewPin(java.lang.String pin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listTemporaryPinByNewPin(pin);
  }
  
  public org.tempuri.GetAllCompanyResponseGetAllCompanyResult getAllCompany() throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getAllCompany();
  }
  
  public org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getEmployeeProfile(java.lang.String vPin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfile(vPin);
  }
  
  public org.tempuri.GetOrganizationResponseGetOrganizationResult getOrganization(java.lang.String orgcode, java.lang.String orgname, java.lang.String orgdesc) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getOrganization(orgcode, orgname, orgdesc);
  }
  
  public org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult listEmployeeProfileByPIN(java.lang.String pin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listEmployeeProfileByPIN(pin);
  }
  
  public org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getApproverProfileByPIN(java.lang.String pin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getApproverProfileByPIN(pin);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult getEmployeeProfileByPrefixEngName(java.lang.String empEngName) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixEngName(empEngName);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult getEmployeeProfileByPrefixEngLastName(java.lang.String empEngLastName) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixEngLastName(empEngLastName);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getEmployeeProfileByPrefixThaiName(java.lang.String empThaiName) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixThaiName(empThaiName);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult getEmployeeProfileByPrefixThaiLastName(java.lang.String empThaiLastName) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixThaiLastName(empThaiLastName);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult getEmployeeProfileByPrefixEmail(java.lang.String empEmail) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixEmail(empEmail);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getEmployeeProfileByPrefixPin(java.lang.String empPin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixPin(empPin);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getEmployeeProfileByPrefixOrgcode(java.lang.String empOrgcode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixOrgcode(empOrgcode);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getEmployeeProfileByPrefixOrgname(java.lang.String empOrgname) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixOrgname(empOrgname);
  }
  
  public org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult getEmployeeProfileByPrefixOrgdesc(java.lang.String empOrgdesc) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByPrefixOrgdesc(empOrgdesc);
  }
  
  public org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult getEmployeeProfileByEmail(java.lang.String vEmail) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByEmail(vEmail);
  }
  
  public org.tempuri.ListAllApproverResponseListAllApproverResult listAllApprover(java.lang.String pin, java.lang.String position) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listAllApprover(pin, position);
  }
  
  public org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getListEmployeeUnderApprover(java.lang.String pin) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getListEmployeeUnderApprover(pin);
  }
  
  public org.tempuri.GetJobKeyResponseGetJobKeyResult getJobKey(java.lang.String jobKey) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getJobKey(jobKey);
  }
  
  public org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult searchEmpDetail(java.lang.String co, java.lang.String bu, java.lang.String dp, java.lang.String sc, java.lang.String fc, java.lang.String engName, java.lang.String engSurName, java.lang.String thName, java.lang.String thSurName, java.lang.String pos, java.lang.String nickName, java.lang.String job, java.lang.String pin, java.lang.String userStamp, java.lang.String telNo, java.lang.String mobileNo, java.lang.String managerName) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.searchEmpDetail(co, bu, dp, sc, fc, engName, engSurName, thName, thSurName, pos, nickName, job, pin, userStamp, telNo, mobileNo, managerName);
  }
  
  public org.tempuri.Search_EmployeeResponseSearch_EmployeeResult search_Employee(java.lang.String employee_ID, java.lang.String emp_Name, java.lang.String emp_Last_Name, java.lang.String ENGEmp_Name, java.lang.String ENGEmp_Last_Name, java.lang.String org_ID, java.lang.String org_Name) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.search_Employee(employee_ID, emp_Name, emp_Last_Name, ENGEmp_Name, ENGEmp_Last_Name, org_ID, org_Name);
  }
  
  public org.tempuri.List_ActingApproverResponseList_ActingApproverResult list_ActingApprover(org.tempuri.List_ActingApproverDs ds) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.list_ActingApprover(ds);
  }
  
  public org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult listOrganizeByOrganizeLevel(java.lang.String companyCode, java.lang.String organizeLevel, java.lang.String organizeCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrganizeByOrganizeLevel(companyCode, organizeLevel, organizeCode);
  }
  
  public org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult searchEmployeeOrg(java.lang.String employeeID, java.lang.String enName, java.lang.String enSurName, java.lang.String thName, java.lang.String thSurName, java.lang.String email, java.lang.String company, java.lang.String buname, java.lang.String buhname, java.lang.String orgname, java.lang.String dpname, java.lang.String positiondesc, java.lang.String positionid, java.lang.String EMPLOYEETYPE, java.lang.String EMPLOYEEGROUP) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.searchEmployeeOrg(employeeID, enName, enSurName, thName, thSurName, email, company, buname, buhname, orgname, dpname, positiondesc, positionid, EMPLOYEETYPE, EMPLOYEEGROUP);
  }
  
  public org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult list_LineApproverPositionAVPUP(java.lang.String pin, java.lang.String position) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.list_LineApproverPositionAVPUP(pin, position);
  }
  
  public org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult listOrganizeLevelByCompany(java.lang.String companyCode, java.lang.String organizeLevel) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrganizeLevelByCompany(companyCode, organizeLevel);
  }
  
  public org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getEmployeeProfileByUsername(java.lang.String username) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.getEmployeeProfileByUsername(username);
  }
  
  public org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult listLineOrganizeByOrganizeCode(java.lang.String orgCode) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listLineOrganizeByOrganizeCode(orgCode);
  }
  
  public org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult listOrgDescByPrefix(java.lang.String orgDesc) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listOrgDescByPrefix(orgDesc);
  }
  
  public org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult listGradeDescByPrefix(java.lang.String gradeDesc) throws java.rmi.RemoteException{
    if (wS_OM_OMEHRServicesSoap == null)
      _initWS_OM_OMEHRServicesSoapProxy();
    return wS_OM_OMEHRServicesSoap.listGradeDescByPrefix(gradeDesc);
  }
  
  
}