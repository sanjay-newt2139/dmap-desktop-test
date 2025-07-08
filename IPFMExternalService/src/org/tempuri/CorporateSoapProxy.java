package org.tempuri;

public class CorporateSoapProxy implements org.tempuri.CorporateSoap {
  private String _endpoint = null;
  private org.tempuri.CorporateSoap corporateSoap = null;
  
  public CorporateSoapProxy() {
    _initCorporateSoapProxy();
  }
  
  public CorporateSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCorporateSoapProxy();
  }
  
  private void _initCorporateSoapProxy() {
    try {
      corporateSoap = (new org.tempuri.CorporateLocator()).getCorporateSoap();
      if (corporateSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)corporateSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)corporateSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (corporateSoap != null)
      ((javax.xml.rpc.Stub)corporateSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.CorporateSoap getCorporateSoap() {
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap;
  }
  
  public org.tempuri.WS_GEN_DeleteAuthenLDAPResponseWS_GEN_DeleteAuthenLDAPResult WS_GEN_DeleteAuthenLDAP(java.lang.String userName, java.lang.String projectCode) throws java.rmi.RemoteException{
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap.WS_GEN_DeleteAuthenLDAP(userName, projectCode);
  }
  
  public org.tempuri.WS_GEN_SearchAuthenLDAPResponseWS_GEN_SearchAuthenLDAPResult WS_GEN_SearchAuthenLDAP(java.lang.String userName, java.lang.String passWd, java.lang.String projectCode) throws java.rmi.RemoteException{
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap.WS_GEN_SearchAuthenLDAP(userName, passWd, projectCode);
  }
  
  public org.tempuri.WS_GEN_ADDAuthenLDAPResponseWS_GEN_ADDAuthenLDAPResult WS_GEN_ADDAuthenLDAP(java.lang.String userName, java.lang.String passWd, java.lang.String projectCode, java.lang.String EECODE) throws java.rmi.RemoteException{
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap.WS_GEN_ADDAuthenLDAP(userName, passWd, projectCode, EECODE);
  }
  
  public org.tempuri.WS_GEN_GetUserInfoResponseWS_GEN_GetUserInfoResult WS_GEN_GetUserInfo(java.lang.String userName, java.lang.String projectCode) throws java.rmi.RemoteException{
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap.WS_GEN_GetUserInfo(userName, projectCode);
  }
  
  public org.tempuri.WS_GEN_AuthenLDAPResponseWS_GEN_AuthenLDAPResult WS_GEN_AuthenLDAP(java.lang.String userName, java.lang.String passWd, java.lang.String projectCode) throws java.rmi.RemoteException{
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap.WS_GEN_AuthenLDAP(userName, passWd, projectCode);
  }
  
  public org.tempuri.WS_GEN_UpdateAuthenLDAPResponseWS_GEN_UpdateAuthenLDAPResult WS_GEN_UpdateAuthenLDAP(java.lang.String userName, java.lang.String oldPassWd, java.lang.String newPassWd, java.lang.String projectCode) throws java.rmi.RemoteException{
    if (corporateSoap == null)
      _initCorporateSoapProxy();
    return corporateSoap.WS_GEN_UpdateAuthenLDAP(userName, oldPassWd, newPassWd, projectCode);
  }
  
  
}