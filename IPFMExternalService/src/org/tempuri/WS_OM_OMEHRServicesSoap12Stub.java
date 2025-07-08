/**
 * WS_OM_OMEHRServicesSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_OM_OMEHRServicesSoap12Stub extends org.apache.axis.client.Stub implements org.tempuri.WS_OM_OMEHRServicesSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[70];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Get_LogK2_ChangeApprover_Input_DataSet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_LogK2_ChangeApprover_Input_DataSet>ds"), org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_LogK2_ChangeApprover_Input_DataSetResponse>Get_LogK2_ChangeApprover_Input_DataSetResult"));
        oper.setReturnClass(org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Get_LogK2_ChangeApprover_Input_DataSetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllemployeeunderApprover_Input_DataSet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pinManager"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "positionManager"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllemployeeunderApprover_Input_DataSet>ds"), org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllemployeeunderApprover_Input_DataSetResponse>ListAllemployeeunderApprover_Input_DataSetResult"));
        oper.setReturnClass(org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllemployeeunderApprover_Input_DataSetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListEmployeeProfileByPIN_MultiPosition");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_MultiPositionResponse>ListEmployeeProfileByPIN_MultiPositionResult"));
        oper.setReturnClass(org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_MultiPositionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("List_EmpProfile_Time_ChangeApprover_Input_DataSet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>List_EmpProfile_Time_ChangeApprover_Input_DataSet>ds"), org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_EmpProfile_Time_ChangeApprover_Input_DataSetResponse>List_EmpProfile_Time_ChangeApprover_Input_DataSetResult"));
        oper.setReturnClass(org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "List_EmpProfile_Time_ChangeApprover_Input_DataSetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetChangeApproverK2_Summary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "StartDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "End_Date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "type"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetChangeApproverK2_SummaryResponse>GetChangeApproverK2_SummaryResult"));
        oper.setReturnClass(org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetChangeApproverK2_SummaryResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("List_LogK2_ChangeApprover_Detail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Log_Date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "type"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_LogK2_ChangeApprover_DetailResponse>List_LogK2_ChangeApprover_DetailResult"));
        oper.setReturnClass(org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "List_LogK2_ChangeApprover_DetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrgInfobyOrgCode_IN_DataSet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCode_IN_DataSet>ds"), org.tempuri.GetOrgInfobyOrgCode_IN_DataSetDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCode_IN_DataSetResponse>GetOrgInfobyOrgCode_IN_DataSetResult"));
        oper.setReturnClass(org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgInfobyOrgCode_IN_DataSetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListEmployeeProfileByPIN_Input_DataSet");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSet>ds"), org.tempuri.ListEmployeeProfileByPIN_Input_DataSetDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetResponse>ListEmployeeProfileByPIN_Input_DataSetResult"));
        oper.setReturnClass(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_Input_DataSetResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListEmployeeProfileByPIN_Input_DataSetByPowerSearch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetByPowerSearch>ds"), org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponse>ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult"));
        oper.setReturnClass(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("List_Log_OM_TransForm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ProcessID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "StartDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "EndDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_Log_OM_TransFormResponse>List_Log_OM_TransFormResult"));
        oper.setReturnClass(org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "List_Log_OM_TransFormResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listOrganize");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "LowerOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "HigherOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeResponse>listOrganizeResult"));
        oper.setReturnClass(org.tempuri.ListOrganizeResponseListOrganizeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganizeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listOrganizeLower");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Level"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeLowerResponse>listOrganizeLowerResult"));
        oper.setReturnClass(org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganizeLowerResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCostCenter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Costcenter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "CompanyCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCostCenterResponse>GetCostCenterResult"));
        oper.setReturnClass(org.tempuri.GetCostCenterResponseGetCostCenterResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCostCenterResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListOrganizeLowerByListOrg");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLowerByListOrg>ds"), org.tempuri.ListOrganizeLowerByListOrgDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLowerByListOrgResponse>ListOrganizeLowerByListOrgResult"));
        oper.setReturnClass(org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeLowerByListOrgResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("listOrganizeUpper");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Level"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeUpperResponse>listOrganizeUpperResult"));
        oper.setReturnClass(org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganizeUpperResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CHECKMANAGER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "POSITION"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "CHECKMANAGERResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetManagerByOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetManagerByOrgCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrgPersInfoByBossPostID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "PIN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "BossPosition"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Organization"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NickName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Position"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Tel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Job"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoByBossPostIDResponse>GetOrgPersInfoByBossPostIDResult"));
        oper.setReturnClass(org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfoByBossPostIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrgPersInfoByOrgHRMPIN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "PIN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Organization"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NickName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Position"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Tel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Job"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoByOrgHRMPINResponse>GetOrgPersInfoByOrgHRMPINResult"));
        oper.setReturnClass(org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfoByOrgHRMPINResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrgPersInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Organization"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "NickName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Position"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Tel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Job"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoResponse>GetOrgPersInfoResult"));
        oper.setReturnClass(org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListEmployee_By_CompanyCode_Name_PIN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "CompanyCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployee_By_CompanyCode_Name_PINResponse>ListEmployee_By_CompanyCode_Name_PINResult"));
        oper.setReturnClass(org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployee_By_CompanyCode_Name_PINResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllOrgInfobyEmpID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllOrgInfobyEmpIDResponse>GetAllOrgInfobyEmpIDResult"));
        oper.setReturnClass(org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllOrgInfobyEmpIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrgInfobyOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCodeResponse>GetOrgInfobyOrgCodeResult"));
        oper.setReturnClass(org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgInfobyOrgCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListPinsbyOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListPinsbyOrgCodeResponse>ListPinsbyOrgCodeResult"));
        oper.setReturnClass(org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListPinsbyOrgCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStaffCountByPositionID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Position"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetStaffCountByPositionIDResponse>GetStaffCountByPositionIDResult"));
        oper.setReturnClass(org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetStaffCountByPositionIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllPG");
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllPGResponse>GetAllPGResult"));
        oper.setReturnClass(org.tempuri.GetAllPGResponseGetAllPGResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllPGResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetApprover");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "EmpID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetApproverResponse>GetApproverResult"));
        oper.setReturnClass(org.tempuri.GetApproverResponseGetApproverResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetApproverResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStaffCountbyOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetStaffCountbyOrgCodeResponse>GetStaffCountbyOrgCodeResult"));
        oper.setReturnClass(org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetStaffCountbyOrgCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrganizationName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrganizationNameResponse>GetOrganizationNameResult"));
        oper.setReturnClass(org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrganizationNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCompanyByOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCompanyByOrgCodeResponse>GetCompanyByOrgCodeResult"));
        oper.setReturnClass(org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCompanyByOrgCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeIDByEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeIDByEmailResponse>GetEmployeeIDByEmailResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeIDByEmailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetListEmployeePositionAndOrganization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "userStamp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetListEmployeePositionAndOrganizationResponse>GetListEmployeePositionAndOrganizationResult"));
        oper.setReturnClass(org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetListEmployeePositionAndOrganizationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllPinsUnderOrgCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeResponse>ListAllPinsUnderOrgCodeResult"));
        oper.setReturnClass(org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllPinsUnderOrgCodeByPrefixPin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixPinResponse>ListAllPinsUnderOrgCodeByPrefixPinResult"));
        oper.setReturnClass(org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixPinResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllPinsUnderOrgCodeByPrefixEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixEmailResponse>ListAllPinsUnderOrgCodeByPrefixEmailResult"));
        oper.setReturnClass(org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixEmailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllPinsUnderOrgCodeByPrefixThaiName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vThName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixThaiNameResponse>ListAllPinsUnderOrgCodeByPrefixThaiNameResult"));
        oper.setReturnClass(org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixThaiNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllPinsUnderOrgCodeByPrefixThaiSurName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vThSurname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse>ListAllPinsUnderOrgCodeByPrefixThaiSurNameResult"));
        oper.setReturnClass(org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixThaiSurNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllPosition");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllPositionResponse>GetAllPositionResult"));
        oper.setReturnClass(org.tempuri.GetAllPositionResponseGetAllPositionResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllPositionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchOrgInfoByOrgCodeOrOrgDesc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vCompanyCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchOrgInfoByOrgCodeOrOrgDescResponse>SearchOrgInfoByOrgCodeOrOrgDescResult"));
        oper.setReturnClass(org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchOrgInfoByOrgCodeOrOrgDescResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchOrgInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vCompanyCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchOrgInfoResponse>SearchOrgInfoResult"));
        oper.setReturnClass(org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchOrgInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListTemporaryPinByNewPin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListTemporaryPinByNewPinResponse>ListTemporaryPinByNewPinResult"));
        oper.setReturnClass(org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListTemporaryPinByNewPinResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllCompany");
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllCompanyResponse>GetAllCompanyResult"));
        oper.setReturnClass(org.tempuri.GetAllCompanyResponseGetAllCompanyResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllCompanyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileResponse>GetEmployeeProfileResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrganization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgdesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrganizationResponse>GetOrganizationResult"));
        oper.setReturnClass(org.tempuri.GetOrganizationResponseGetOrganizationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrganizationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListEmployeeProfileByPIN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPINResponse>ListEmployeeProfileByPINResult"));
        oper.setReturnClass(org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPINResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetApproverProfileByPIN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetApproverProfileByPINResponse>GetApproverProfileByPINResult"));
        oper.setReturnClass(org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetApproverProfileByPINResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixEngName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empEngName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixEngNameResponse>GetEmployeeProfileByPrefixEngNameResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixEngNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixEngLastName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empEngLastName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixEngLastNameResponse>GetEmployeeProfileByPrefixEngLastNameResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixEngLastNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixThaiName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empThaiName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixThaiNameResponse>GetEmployeeProfileByPrefixThaiNameResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixThaiNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixThaiLastName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empThaiLastName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixThaiLastNameResponse>GetEmployeeProfileByPrefixThaiLastNameResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixThaiLastNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixEmailResponse>GetEmployeeProfileByPrefixEmailResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixEmailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixPin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empPin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixPinResponse>GetEmployeeProfileByPrefixPinResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixPinResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixOrgcode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empOrgcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgcodeResponse>GetEmployeeProfileByPrefixOrgcodeResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgcodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixOrgname");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empOrgname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgnameResponse>GetEmployeeProfileByPrefixOrgnameResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgnameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByPrefixOrgdesc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "empOrgdesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgdescResponse>GetEmployeeProfileByPrefixOrgdescResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgdescResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByEmail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "vEmail"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByEmailResponse>GetEmployeeProfileByEmailResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByEmailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListAllApprover");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "position"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllApproverResponse>ListAllApproverResult"));
        oper.setReturnClass(org.tempuri.ListAllApproverResponseListAllApproverResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllApproverResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetListEmployeeUnderApprover");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetListEmployeeUnderApproverResponse>GetListEmployeeUnderApproverResult"));
        oper.setReturnClass(org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetListEmployeeUnderApproverResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetJobKey");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "jobKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetJobKeyResponse>GetJobKeyResult"));
        oper.setReturnClass(org.tempuri.GetJobKeyResponseGetJobKeyResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetJobKeyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchEmpDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "co"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "bu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "dp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "sc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "fc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "engName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "engSurName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "thName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "thSurName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "nickName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "job"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "userStamp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "TelNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "MobileNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ManagerName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchEmpDetailResponse>SearchEmpDetailResult"));
        oper.setReturnClass(org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchEmpDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Search_Employee");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Employee_ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Emp_Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Emp_Last_Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ENGEmp_Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ENGEmp_Last_Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Org_ID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Org_Name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Search_EmployeeResponse>Search_EmployeeResult"));
        oper.setReturnClass(org.tempuri.Search_EmployeeResponseSearch_EmployeeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Search_EmployeeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("List_ActingApprover");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://tempuri.org/", ">>List_ActingApprover>ds"), org.tempuri.List_ActingApproverDs.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_ActingApproverResponse>List_ActingApproverResult"));
        oper.setReturnClass(org.tempuri.List_ActingApproverResponseList_ActingApproverResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "List_ActingApproverResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListOrganizeByOrganizeLevel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "CompanyCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrganizeLevel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrganizeCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeByOrganizeLevelResponse>ListOrganizeByOrganizeLevelResult"));
        oper.setReturnClass(org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeByOrganizeLevelResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SearchEmployeeOrg");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "employeeID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "enName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "enSurName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "thName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "thSurName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "company"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "buname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "buhname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "dpname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "positiondesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "positionid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "EMPLOYEETYPE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "EMPLOYEEGROUP"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchEmployeeOrgResponse>SearchEmployeeOrgResult"));
        oper.setReturnClass(org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchEmployeeOrgResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("List_LineApproverPositionAVPUP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Pin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "Position"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_LineApproverPositionAVPUPResponse>List_LineApproverPositionAVPUPResult"));
        oper.setReturnClass(org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "List_LineApproverPositionAVPUPResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListOrganizeLevelByCompany");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "CompanyCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrganizeLevel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLevelByCompanyResponse>ListOrganizeLevelByCompanyResult"));
        oper.setReturnClass(org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeLevelByCompanyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEmployeeProfileByUsername");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByUsernameResponse>GetEmployeeProfileByUsernameResult"));
        oper.setReturnClass(org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByUsernameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListLineOrganizeByOrganizeCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "OrgCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListLineOrganizeByOrganizeCodeResponse>ListLineOrganizeByOrganizeCodeResult"));
        oper.setReturnClass(org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListLineOrganizeByOrganizeCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[67] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListOrgDescByPrefix");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "orgDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrgDescByPrefixResponse>ListOrgDescByPrefixResult"));
        oper.setReturnClass(org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrgDescByPrefixResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[68] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListGradeDescByPrefix");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "gradeDesc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListGradeDescByPrefixResponse>ListGradeDescByPrefixResult"));
        oper.setReturnClass(org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "ListGradeDescByPrefixResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[69] = oper;

    }

    public WS_OM_OMEHRServicesSoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WS_OM_OMEHRServicesSoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WS_OM_OMEHRServicesSoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
        addBindings2();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_LogK2_ChangeApprover_Input_DataSet>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_LogK2_ChangeApprover_Input_DataSetResponse>Get_LogK2_ChangeApprover_Input_DataSetResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllCompanyResponse>GetAllCompanyResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllCompanyResponseGetAllCompanyResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllOrgInfobyEmpIDResponse>GetAllOrgInfobyEmpIDResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllPGResponse>GetAllPGResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllPGResponseGetAllPGResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllPositionResponse>GetAllPositionResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllPositionResponseGetAllPositionResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetApproverProfileByPINResponse>GetApproverProfileByPINResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetApproverResponse>GetApproverResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetApproverResponseGetApproverResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetChangeApproverK2_SummaryResponse>GetChangeApproverK2_SummaryResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCompanyByOrgCodeResponse>GetCompanyByOrgCodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCostCenterResponse>GetCostCenterResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetCostCenterResponseGetCostCenterResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeIDByEmailResponse>GetEmployeeIDByEmailResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByEmailResponse>GetEmployeeProfileByEmailResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixEmailResponse>GetEmployeeProfileByPrefixEmailResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixEngLastNameResponse>GetEmployeeProfileByPrefixEngLastNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixEngNameResponse>GetEmployeeProfileByPrefixEngNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgcodeResponse>GetEmployeeProfileByPrefixOrgcodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgdescResponse>GetEmployeeProfileByPrefixOrgdescResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgnameResponse>GetEmployeeProfileByPrefixOrgnameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixPinResponse>GetEmployeeProfileByPrefixPinResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixThaiLastNameResponse>GetEmployeeProfileByPrefixThaiLastNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixThaiNameResponse>GetEmployeeProfileByPrefixThaiNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByUsernameResponse>GetEmployeeProfileByUsernameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileResponse>GetEmployeeProfileResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetJobKeyResponse>GetJobKeyResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetJobKeyResponseGetJobKeyResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetListEmployeePositionAndOrganizationResponse>GetListEmployeePositionAndOrganizationResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetListEmployeeUnderApproverResponse>GetListEmployeeUnderApproverResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrganizationNameResponse>GetOrganizationNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrganizationResponse>GetOrganizationResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrganizationResponseGetOrganizationResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCode_IN_DataSet>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCode_IN_DataSetDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCode_IN_DataSetResponse>GetOrgInfobyOrgCode_IN_DataSetResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCodeResponse>GetOrgInfobyOrgCodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoByBossPostIDResponse>GetOrgPersInfoByBossPostIDResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoByOrgHRMPINResponse>GetOrgPersInfoByOrgHRMPINResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoResponse>GetOrgPersInfoResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetStaffCountbyOrgCodeResponse>GetStaffCountbyOrgCodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>GetStaffCountByPositionIDResponse>GetStaffCountByPositionIDResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_ActingApprover>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_ActingApproverDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_ActingApproverResponse>List_ActingApproverResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_ActingApproverResponseList_ActingApproverResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_EmpProfile_Time_ChangeApprover_Input_DataSet>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_EmpProfile_Time_ChangeApprover_Input_DataSetResponse>List_EmpProfile_Time_ChangeApprover_Input_DataSetResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_LineApproverPositionAVPUPResponse>List_LineApproverPositionAVPUPResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_Log_OM_TransFormResponse>List_Log_OM_TransFormResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>List_LogK2_ChangeApprover_DetailResponse>List_LogK2_ChangeApprover_DetailResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllApproverResponse>ListAllApproverResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllApproverResponseListAllApproverResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllemployeeunderApprover_Input_DataSet>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllemployeeunderApprover_Input_DataSetResponse>ListAllemployeeunderApprover_Input_DataSetResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixEmailResponse>ListAllPinsUnderOrgCodeByPrefixEmailResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixPinResponse>ListAllPinsUnderOrgCodeByPrefixPinResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixThaiNameResponse>ListAllPinsUnderOrgCodeByPrefixThaiNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse>ListAllPinsUnderOrgCodeByPrefixThaiSurNameResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeResponse>ListAllPinsUnderOrgCodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployee_By_CompanyCode_Name_PINResponse>ListEmployee_By_CompanyCode_Name_PINResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSet>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetByPowerSearch>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponse>ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetResponse>ListEmployeeProfileByPIN_Input_DataSetResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_MultiPositionResponse>ListEmployeeProfileByPIN_MultiPositionResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPINResponse>ListEmployeeProfileByPINResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListGradeDescByPrefixResponse>ListGradeDescByPrefixResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListLineOrganizeByOrganizeCodeResponse>ListLineOrganizeByOrganizeCodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeByOrganizeLevelResponse>ListOrganizeByOrganizeLevelResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLevelByCompanyResponse>ListOrganizeLevelByCompanyResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLowerByListOrg>ds");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLowerByListOrgDs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLowerByListOrgResponse>ListOrganizeLowerByListOrgResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeLowerResponse>listOrganizeLowerResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeResponse>listOrganizeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeResponseListOrganizeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeUpperResponse>listOrganizeUpperResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrgDescByPrefixResponse>ListOrgDescByPrefixResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListPinsbyOrgCodeResponse>ListPinsbyOrgCodeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>ListTemporaryPinByNewPinResponse>ListTemporaryPinByNewPinResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Search_EmployeeResponse>Search_EmployeeResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.Search_EmployeeResponseSearch_EmployeeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchEmpDetailResponse>SearchEmpDetailResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchEmployeeOrgResponse>SearchEmployeeOrgResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchOrgInfoByOrgCodeOrOrgDescResponse>SearchOrgInfoByOrgCodeOrOrgDescResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchOrgInfoResponse>SearchOrgInfoResult");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">CHECKMANAGER");
            cachedSerQNames.add(qName);
            cls = org.tempuri.CHECKMANAGER.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">CHECKMANAGERResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.CHECKMANAGERResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Get_LogK2_ChangeApprover_Input_DataSetResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllCompany");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllCompany.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllCompanyResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllCompanyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllOrgInfobyEmpID");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllOrgInfobyEmpID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllOrgInfobyEmpIDResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllOrgInfobyEmpIDResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllPG");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllPG.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllPGResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllPGResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllPosition");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllPositionResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetAllPositionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetApprover");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetApprover.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetApproverProfileByPIN");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetApproverProfileByPIN.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetApproverProfileByPINResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetApproverProfileByPINResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetApproverResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetApproverResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetChangeApproverK2_Summary");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetChangeApproverK2_Summary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetChangeApproverK2_SummaryResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetChangeApproverK2_SummaryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetCompanyByOrgCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetCompanyByOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetCompanyByOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetCompanyByOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetCostCenter");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetCostCenter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetCostCenterResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetCostCenterResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeIDByEmail");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeIDByEmail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeIDByEmailResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeIDByEmailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfile");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByEmail");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByEmail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByEmailResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByEmailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEmail");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEmail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEmailResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEmailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEngLastName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEngLastName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEngLastNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEngName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEngName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEngNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixEngNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgcode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgcode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgcodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgdesc");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgdesc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgdescResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgdescResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgname");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgname.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgnameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixOrgnameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixPin");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixPin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixPinResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixPinResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixThaiLastName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixThaiLastName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixThaiLastNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixThaiName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixThaiName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixThaiNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByPrefixThaiNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByUsername");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByUsername.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByUsernameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileByUsernameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetEmployeeProfileResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetJobKey");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetJobKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetJobKeyResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetJobKeyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetListEmployeePositionAndOrganization");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetListEmployeePositionAndOrganization.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetListEmployeePositionAndOrganizationResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetListEmployeePositionAndOrganizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetListEmployeeUnderApprover");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetListEmployeeUnderApprover.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetListEmployeeUnderApproverResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetListEmployeeUnderApproverResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetManagerByOrgCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetManagerByOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetManagerByOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetManagerByOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganization");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrganization.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganizationName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrganizationName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganizationNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrganizationNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganizationResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrganizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgInfobyOrgCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgInfobyOrgCode_IN_DataSet");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCode_IN_DataSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgInfobyOrgCode_IN_DataSetResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgInfobyOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgInfobyOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfo");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfoByBossPostID");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoByBossPostID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfoByBossPostIDResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoByBossPostIDResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfoByOrgHRMPIN");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoByOrgHRMPIN.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfoByOrgHRMPINResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoByOrgHRMPINResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfoResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetOrgPersInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetStaffCountbyOrgCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetStaffCountbyOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetStaffCountbyOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetStaffCountbyOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetStaffCountByPositionID");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetStaffCountByPositionID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">GetStaffCountByPositionIDResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.GetStaffCountByPositionIDResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_ActingApprover");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_ActingApprover.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_ActingApproverResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_ActingApproverResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_EmpProfile_Time_ChangeApprover_Input_DataSet");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_EmpProfile_Time_ChangeApprover_Input_DataSetResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_LineApproverPositionAVPUP");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_LineApproverPositionAVPUP.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_LineApproverPositionAVPUPResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_LineApproverPositionAVPUPResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_Log_OM_TransForm");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_Log_OM_TransForm.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_Log_OM_TransFormResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_Log_OM_TransFormResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_LogK2_ChangeApprover_Detail");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_LogK2_ChangeApprover_Detail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">List_LogK2_ChangeApprover_DetailResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.List_LogK2_ChangeApprover_DetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllApprover");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllApprover.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllApproverResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllApproverResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllemployeeunderApprover_Input_DataSet");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllemployeeunderApprover_Input_DataSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllemployeeunderApprover_Input_DataSetResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixEmail");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixEmailResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixPin");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixPin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixPinResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiSurName");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListAllPinsUnderOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployee_By_CompanyCode_Name_PIN");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployee_By_CompanyCode_Name_PIN.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployee_By_CompanyCode_Name_PINResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_Input_DataSet");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_Input_DataSetByPowerSearch");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_Input_DataSetResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_MultiPosition");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_MultiPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_MultiPositionResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPINResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListEmployeeProfileByPINResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListGradeDescByPrefix");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListGradeDescByPrefix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListGradeDescByPrefixResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListGradeDescByPrefixResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListLineOrganizeByOrganizeCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListLineOrganizeByOrganizeCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListLineOrganizeByOrganizeCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListLineOrganizeByOrganizeCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganize");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganize.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeByOrganizeLevel");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeByOrganizeLevel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeByOrganizeLevelResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeByOrganizeLevelResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeLevelByCompany");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLevelByCompany.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeLevelByCompanyResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLevelByCompanyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganizeLower");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLower.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeLowerByListOrg");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLowerByListOrg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeLowerByListOrgResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLowerByListOrgResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganizeLowerResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeLowerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganizeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganizeUpper");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeUpper.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganizeUpperResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrganizeUpperResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrgDescByPrefix");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrgDescByPrefix.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings2() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrgDescByPrefixResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListOrgDescByPrefixResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListPinsbyOrgCode");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListPinsbyOrgCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListPinsbyOrgCodeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListPinsbyOrgCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListTemporaryPinByNewPin");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListTemporaryPinByNewPin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">ListTemporaryPinByNewPinResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.ListTemporaryPinByNewPinResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Search_Employee");
            cachedSerQNames.add(qName);
            cls = org.tempuri.Search_Employee.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Search_EmployeeResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.Search_EmployeeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchEmpDetail");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchEmpDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchEmpDetailResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchEmpDetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchEmployeeOrg");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchEmployeeOrg.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchEmployeeOrgResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchEmployeeOrgResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchOrgInfo");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchOrgInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchOrgInfoByOrgCodeOrOrgDesc");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchOrgInfoByOrgCodeOrOrgDesc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchOrgInfoByOrgCodeOrOrgDescResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">SearchOrgInfoResponse");
            cachedSerQNames.add(qName);
            cls = org.tempuri.SearchOrgInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult get_LogK2_ChangeApprover_Input_DataSet(org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Get_LogK2_ChangeApprover_Input_DataSet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Get_LogK2_ChangeApprover_Input_DataSet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.Get_LogK2_ChangeApprover_Input_DataSetResponseGet_LogK2_ChangeApprover_Input_DataSetResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult listAllemployeeunderApprover_Input_DataSet(java.lang.String pinManager, java.lang.String positionManager, org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllemployeeunderApprover_Input_DataSet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllemployeeunderApprover_Input_DataSet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pinManager, positionManager, ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllemployeeunderApprover_Input_DataSetResponseListAllemployeeunderApprover_Input_DataSetResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult listEmployeeProfileByPIN_MultiPosition(java.lang.String pin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListEmployeeProfileByPIN_MultiPosition");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_MultiPosition"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListEmployeeProfileByPIN_MultiPositionResponseListEmployeeProfileByPIN_MultiPositionResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult list_EmpProfile_Time_ChangeApprover_Input_DataSet(org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/List_EmpProfile_Time_ChangeApprover_Input_DataSet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "List_EmpProfile_Time_ChangeApprover_Input_DataSet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.List_EmpProfile_Time_ChangeApprover_Input_DataSetResponseList_EmpProfile_Time_ChangeApprover_Input_DataSetResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getChangeApproverK2_Summary(java.lang.String startDate, java.lang.String end_Date, java.lang.String status, java.lang.String type) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetChangeApproverK2_Summary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetChangeApproverK2_Summary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {startDate, end_Date, status, type});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult list_LogK2_ChangeApprover_Detail(java.lang.String log_Date, java.lang.String type, java.lang.String status) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/List_LogK2_ChangeApprover_Detail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "List_LogK2_ChangeApprover_Detail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {log_Date, type, status});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getOrgInfobyOrgCode_IN_DataSet(org.tempuri.GetOrgInfobyOrgCode_IN_DataSetDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrgInfobyOrgCode_IN_DataSet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgInfobyOrgCode_IN_DataSet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult listEmployeeProfileByPIN_Input_DataSet(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListEmployeeProfileByPIN_Input_DataSet");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_Input_DataSet"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult listEmployeeProfileByPIN_Input_DataSetByPowerSearch(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListEmployeeProfileByPIN_Input_DataSetByPowerSearch");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_Input_DataSetByPowerSearch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchResponseListEmployeeProfileByPIN_Input_DataSetByPowerSearchResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult list_Log_OM_TransForm(java.lang.String processID, java.lang.String status, java.lang.String startDate, java.lang.String endDate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/List_Log_OM_TransForm");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "List_Log_OM_TransForm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {processID, status, startDate, endDate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrganizeResponseListOrganizeResult listOrganize(java.lang.String lowerOrgCode, java.lang.String higherOrgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/listOrganize");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganize"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {lowerOrgCode, higherOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrganizeResponseListOrganizeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrganizeResponseListOrganizeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrganizeResponseListOrganizeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult listOrganizeLower(java.lang.String orgCode, java.lang.String level) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/listOrganizeLower");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganizeLower"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgCode, level});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetCostCenterResponseGetCostCenterResult getCostCenter(java.lang.String costcenter, java.lang.String companyCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetCostCenter");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCostCenter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {costcenter, companyCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetCostCenterResponseGetCostCenterResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetCostCenterResponseGetCostCenterResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetCostCenterResponseGetCostCenterResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult listOrganizeLowerByListOrg(org.tempuri.ListOrganizeLowerByListOrgDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListOrganizeLowerByListOrg");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeLowerByListOrg"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult listOrganizeUpper(java.lang.String orgCode, java.lang.String level) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/listOrganizeUpper");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganizeUpper"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgCode, level});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrganizeUpperResponseListOrganizeUpperResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean CHECKMANAGER(java.lang.String POSITION) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/CHECKMANAGER");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "CHECKMANAGER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {POSITION});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String getManagerByOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetManagerByOrgCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetManagerByOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult getOrgPersInfoByBossPostID(java.lang.String PIN, java.lang.String bossPosition, java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrgPersInfoByBossPostID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfoByBossPostID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {PIN, bossPosition, organization, name, nickName, position, tel, job});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrgPersInfoByBossPostIDResponseGetOrgPersInfoByBossPostIDResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getOrgPersInfoByOrgHRMPIN(java.lang.String PIN, java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrgPersInfoByOrgHRMPIN");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfoByOrgHRMPIN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {PIN, organization, name, nickName, position, tel, job});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult getOrgPersInfo(java.lang.String organization, java.lang.String name, java.lang.String nickName, java.lang.String position, java.lang.String tel, java.lang.String job) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrgPersInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {organization, name, nickName, position, tel, job});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrgPersInfoResponseGetOrgPersInfoResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult listEmployee_By_CompanyCode_Name_PIN(java.lang.String pin, java.lang.String name, java.lang.String companyCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListEmployee_By_CompanyCode_Name_PIN");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployee_By_CompanyCode_Name_PIN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin, name, companyCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult getAllOrgInfobyEmpID(java.lang.String pin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetAllOrgInfobyEmpID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllOrgInfobyEmpID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetAllOrgInfobyEmpIDResponseGetAllOrgInfobyEmpIDResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult getOrgInfobyOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrgInfobyOrgCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgInfobyOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrgInfobyOrgCodeResponseGetOrgInfobyOrgCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult listPinsbyOrgCode(java.lang.String orgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListPinsbyOrgCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListPinsbyOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult getStaffCountByPositionID(java.lang.String position) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetStaffCountByPositionID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetStaffCountByPositionID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {position});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetStaffCountByPositionIDResponseGetStaffCountByPositionIDResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetAllPGResponseGetAllPGResult getAllPG() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetAllPG");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllPG"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetAllPGResponseGetAllPGResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetAllPGResponseGetAllPGResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetAllPGResponseGetAllPGResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetApproverResponseGetApproverResult getApprover(java.lang.String empID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetApprover");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetApprover"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetApproverResponseGetApproverResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetApproverResponseGetApproverResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetApproverResponseGetApproverResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getStaffCountbyOrgCode(java.lang.String orgcode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetStaffCountbyOrgCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetStaffCountbyOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgcode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getOrganizationName(java.lang.String vOrgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrganizationName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrganizationName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getCompanyByOrgCode(java.lang.String vOrgID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetCompanyByOrgCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCompanyByOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getEmployeeIDByEmail(java.lang.String vEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeIDByEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeIDByEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult getListEmployeePositionAndOrganization(java.lang.String userStamp) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetListEmployeePositionAndOrganization");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetListEmployeePositionAndOrganization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userStamp});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetListEmployeePositionAndOrganizationResponseGetListEmployeePositionAndOrganizationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult listAllPinsUnderOrgCode(java.lang.String vOrgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllPinsUnderOrgCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult listAllPinsUnderOrgCodeByPrefixPin(java.lang.String vOrgCode, java.lang.String vPin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllPinsUnderOrgCodeByPrefixPin");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixPin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgCode, vPin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult listAllPinsUnderOrgCodeByPrefixEmail(java.lang.String vOrgCode, java.lang.String vEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllPinsUnderOrgCodeByPrefixEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgCode, vEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllPinsUnderOrgCodeByPrefixEmailResponseListAllPinsUnderOrgCodeByPrefixEmailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult listAllPinsUnderOrgCodeByPrefixThaiName(java.lang.String vOrgCode, java.lang.String vThName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllPinsUnderOrgCodeByPrefixThaiName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixThaiName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgCode, vThName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult listAllPinsUnderOrgCodeByPrefixThaiSurName(java.lang.String vOrgCode, java.lang.String vThSurname) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllPinsUnderOrgCodeByPrefixThaiSurName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixThaiSurName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vOrgCode, vThSurname});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetAllPositionResponseGetAllPositionResult getAllPosition(java.lang.String vPin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetAllPosition");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllPosition"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vPin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetAllPositionResponseGetAllPositionResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetAllPositionResponseGetAllPositionResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetAllPositionResponseGetAllPositionResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult searchOrgInfoByOrgCodeOrOrgDesc(java.lang.String vCompanyCode, java.lang.String vOrgDesc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SearchOrgInfoByOrgCodeOrOrgDesc");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchOrgInfoByOrgCodeOrOrgDesc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vCompanyCode, vOrgDesc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult searchOrgInfo(java.lang.String vCompanyCode, java.lang.String vOrgDesc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SearchOrgInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchOrgInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vCompanyCode, vOrgDesc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.SearchOrgInfoResponseSearchOrgInfoResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult listTemporaryPinByNewPin(java.lang.String pin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListTemporaryPinByNewPin");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListTemporaryPinByNewPin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListTemporaryPinByNewPinResponseListTemporaryPinByNewPinResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetAllCompanyResponseGetAllCompanyResult getAllCompany() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetAllCompany");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllCompany"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetAllCompanyResponseGetAllCompanyResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetAllCompanyResponseGetAllCompanyResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetAllCompanyResponseGetAllCompanyResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getEmployeeProfile(java.lang.String vPin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfile");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vPin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetOrganizationResponseGetOrganizationResult getOrganization(java.lang.String orgcode, java.lang.String orgname, java.lang.String orgdesc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetOrganization");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrganization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgcode, orgname, orgdesc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetOrganizationResponseGetOrganizationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetOrganizationResponseGetOrganizationResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetOrganizationResponseGetOrganizationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult listEmployeeProfileByPIN(java.lang.String pin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListEmployeeProfileByPIN");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getApproverProfileByPIN(java.lang.String pin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetApproverProfileByPIN");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetApproverProfileByPIN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult getEmployeeProfileByPrefixEngName(java.lang.String empEngName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixEngName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixEngName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empEngName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixEngNameResponseGetEmployeeProfileByPrefixEngNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult getEmployeeProfileByPrefixEngLastName(java.lang.String empEngLastName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixEngLastName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixEngLastName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empEngLastName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixEngLastNameResponseGetEmployeeProfileByPrefixEngLastNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getEmployeeProfileByPrefixThaiName(java.lang.String empThaiName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixThaiName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixThaiName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empThaiName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult getEmployeeProfileByPrefixThaiLastName(java.lang.String empThaiLastName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixThaiLastName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixThaiLastName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empThaiLastName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixThaiLastNameResponseGetEmployeeProfileByPrefixThaiLastNameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult getEmployeeProfileByPrefixEmail(java.lang.String empEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixEmailResponseGetEmployeeProfileByPrefixEmailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getEmployeeProfileByPrefixPin(java.lang.String empPin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixPin");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixPin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empPin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getEmployeeProfileByPrefixOrgcode(java.lang.String empOrgcode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixOrgcode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgcode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empOrgcode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getEmployeeProfileByPrefixOrgname(java.lang.String empOrgname) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixOrgname");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgname"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empOrgname});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult getEmployeeProfileByPrefixOrgdesc(java.lang.String empOrgdesc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByPrefixOrgdesc");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgdesc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {empOrgdesc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByPrefixOrgdescResponseGetEmployeeProfileByPrefixOrgdescResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult getEmployeeProfileByEmail(java.lang.String vEmail) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByEmail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByEmail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {vEmail});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByEmailResponseGetEmployeeProfileByEmailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListAllApproverResponseListAllApproverResult listAllApprover(java.lang.String pin, java.lang.String position) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListAllApprover");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllApprover"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin, position});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListAllApproverResponseListAllApproverResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListAllApproverResponseListAllApproverResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListAllApproverResponseListAllApproverResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getListEmployeeUnderApprover(java.lang.String pin) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetListEmployeeUnderApprover");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetListEmployeeUnderApprover"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetJobKeyResponseGetJobKeyResult getJobKey(java.lang.String jobKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetJobKey");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetJobKey"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {jobKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetJobKeyResponseGetJobKeyResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetJobKeyResponseGetJobKeyResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetJobKeyResponseGetJobKeyResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult searchEmpDetail(java.lang.String co, java.lang.String bu, java.lang.String dp, java.lang.String sc, java.lang.String fc, java.lang.String engName, java.lang.String engSurName, java.lang.String thName, java.lang.String thSurName, java.lang.String pos, java.lang.String nickName, java.lang.String job, java.lang.String pin, java.lang.String userStamp, java.lang.String telNo, java.lang.String mobileNo, java.lang.String managerName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SearchEmpDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchEmpDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {co, bu, dp, sc, fc, engName, engSurName, thName, thSurName, pos, nickName, job, pin, userStamp, telNo, mobileNo, managerName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.Search_EmployeeResponseSearch_EmployeeResult search_Employee(java.lang.String employee_ID, java.lang.String emp_Name, java.lang.String emp_Last_Name, java.lang.String ENGEmp_Name, java.lang.String ENGEmp_Last_Name, java.lang.String org_ID, java.lang.String org_Name) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Search_Employee");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Search_Employee"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {employee_ID, emp_Name, emp_Last_Name, ENGEmp_Name, ENGEmp_Last_Name, org_ID, org_Name});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.Search_EmployeeResponseSearch_EmployeeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.Search_EmployeeResponseSearch_EmployeeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.Search_EmployeeResponseSearch_EmployeeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.List_ActingApproverResponseList_ActingApproverResult list_ActingApprover(org.tempuri.List_ActingApproverDs ds) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/List_ActingApprover");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "List_ActingApprover"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.List_ActingApproverResponseList_ActingApproverResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.List_ActingApproverResponseList_ActingApproverResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.List_ActingApproverResponseList_ActingApproverResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult listOrganizeByOrganizeLevel(java.lang.String companyCode, java.lang.String organizeLevel, java.lang.String organizeCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListOrganizeByOrganizeLevel");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeByOrganizeLevel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {companyCode, organizeLevel, organizeCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrganizeByOrganizeLevelResponseListOrganizeByOrganizeLevelResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult searchEmployeeOrg(java.lang.String employeeID, java.lang.String enName, java.lang.String enSurName, java.lang.String thName, java.lang.String thSurName, java.lang.String email, java.lang.String company, java.lang.String buname, java.lang.String buhname, java.lang.String orgname, java.lang.String dpname, java.lang.String positiondesc, java.lang.String positionid, java.lang.String EMPLOYEETYPE, java.lang.String EMPLOYEEGROUP) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SearchEmployeeOrg");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchEmployeeOrg"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {employeeID, enName, enSurName, thName, thSurName, email, company, buname, buhname, orgname, dpname, positiondesc, positionid, EMPLOYEETYPE, EMPLOYEEGROUP});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult list_LineApproverPositionAVPUP(java.lang.String pin, java.lang.String position) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/List_LineApproverPositionAVPUP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "List_LineApproverPositionAVPUP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pin, position});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult listOrganizeLevelByCompany(java.lang.String companyCode, java.lang.String organizeLevel) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListOrganizeLevelByCompany");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeLevelByCompany"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {companyCode, organizeLevel});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getEmployeeProfileByUsername(java.lang.String username) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetEmployeeProfileByUsername");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByUsername"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult listLineOrganizeByOrganizeCode(java.lang.String orgCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListLineOrganizeByOrganizeCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListLineOrganizeByOrganizeCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult listOrgDescByPrefix(java.lang.String orgDesc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[68]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListOrgDescByPrefix");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrgDescByPrefix"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {orgDesc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult listGradeDescByPrefix(java.lang.String gradeDesc) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[69]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListGradeDescByPrefix");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "ListGradeDescByPrefix"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {gradeDesc});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
