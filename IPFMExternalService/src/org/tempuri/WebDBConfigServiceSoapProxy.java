package org.tempuri;

public class WebDBConfigServiceSoapProxy implements org.tempuri.WebDBConfigServiceSoap {
  private String _endpoint = null;
  private org.tempuri.WebDBConfigServiceSoap webDBConfigServiceSoap = null;
  
  public WebDBConfigServiceSoapProxy() {
    _initWebDBConfigServiceSoapProxy();
  }
  
  public WebDBConfigServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebDBConfigServiceSoapProxy();
  }
  
  public WebDBConfigServiceSoapProxy(String endpoint, String username, String password) {
	    _endpoint = endpoint;
	    _initWebDBConfigServiceSoapProxy(username, password);
  }
  
  private void _initWebDBConfigServiceSoapProxy() {
    try {
      webDBConfigServiceSoap = (new org.tempuri.WebDBConfigServiceLocator()).getWebDBConfigServiceSoap();
      if (webDBConfigServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webDBConfigServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webDBConfigServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  private void _initWebDBConfigServiceSoapProxy(String username, String password) {
	    try {
	      webDBConfigServiceSoap = (new org.tempuri.WebDBConfigServiceLocator()).getWebDBConfigServiceSoap();
	      if (webDBConfigServiceSoap != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)webDBConfigServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)webDBConfigServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	      ((javax.xml.rpc.Stub)webDBConfigServiceSoap)._setProperty(javax.xml.rpc.Stub.USERNAME_PROPERTY, username);
	      ((javax.xml.rpc.Stub)webDBConfigServiceSoap)._setProperty(javax.xml.rpc.Stub.PASSWORD_PROPERTY, password);
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webDBConfigServiceSoap != null)
      ((javax.xml.rpc.Stub)webDBConfigServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.WebDBConfigServiceSoap getWebDBConfigServiceSoap() {
    if (webDBConfigServiceSoap == null)
      _initWebDBConfigServiceSoapProxy();
    return webDBConfigServiceSoap;
  }
  
  public th.co.ais.ehr.domain.DatabaseAccount WS_AUTHENDB_DBConfig(java.lang.String strProjectID) throws java.rmi.RemoteException{
    if (webDBConfigServiceSoap == null)
      _initWebDBConfigServiceSoapProxy();
    return webDBConfigServiceSoap.WS_AUTHENDB_DBConfig(strProjectID);
  }
  
  public th.co.ais.ehr.domain.UserAccount WS_AUTHENDB_USERConfig(java.lang.String strProjectID) throws java.rmi.RemoteException{
    if (webDBConfigServiceSoap == null)
      _initWebDBConfigServiceSoapProxy();
    return webDBConfigServiceSoap.WS_AUTHENDB_USERConfig(strProjectID);
  }
  
  
}