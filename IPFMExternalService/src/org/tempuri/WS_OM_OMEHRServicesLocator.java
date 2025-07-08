/**
 * WS_OM_OMEHRServicesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_OM_OMEHRServicesLocator extends org.apache.axis.client.Service implements org.tempuri.WS_OM_OMEHRServices {
	
	private String username;
	private String password;
	
    public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WS_OM_OMEHRServicesLocator() {
    }
	
	public WS_OM_OMEHRServicesLocator(String username, String password) {
		setUsername(username);
		setPassword(password);
    }

    public WS_OM_OMEHRServicesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_OM_OMEHRServicesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_OM_OMEHRServicesSoap
    private java.lang.String WS_OM_OMEHRServicesSoap_address = "http://test-omservices.ais.co.th/ExternalServices/WS_OM_OMEHRServices.asmx";

    public java.lang.String getWS_OM_OMEHRServicesSoapAddress() {
        return WS_OM_OMEHRServicesSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_OM_OMEHRServicesSoapWSDDServiceName = "WS_OM_OMEHRServicesSoap";

    public java.lang.String getWS_OM_OMEHRServicesSoapWSDDServiceName() {
        return WS_OM_OMEHRServicesSoapWSDDServiceName;
    }

    public void setWS_OM_OMEHRServicesSoapWSDDServiceName(java.lang.String name) {
        WS_OM_OMEHRServicesSoapWSDDServiceName = name;
    }

    public org.tempuri.WS_OM_OMEHRServicesSoap getWS_OM_OMEHRServicesSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_OM_OMEHRServicesSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_OM_OMEHRServicesSoap(endpoint);
    }

    public org.tempuri.WS_OM_OMEHRServicesSoap getWS_OM_OMEHRServicesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	org.tempuri.WS_OM_OMEHRServicesSoapStub _stub = null;
        	if(username!=null && password!=null){
            	_stub = new org.tempuri.WS_OM_OMEHRServicesSoapStub(portAddress, this, username, password);
            }else{
            	_stub = new org.tempuri.WS_OM_OMEHRServicesSoapStub(portAddress, this);	
            }            	
            _stub.setPortName(getWS_OM_OMEHRServicesSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_OM_OMEHRServicesSoapEndpointAddress(java.lang.String address) {
        WS_OM_OMEHRServicesSoap_address = address;
    }


    // Use to get a proxy class for WS_OM_OMEHRServicesSoap12
    private java.lang.String WS_OM_OMEHRServicesSoap12_address = "http://test-omservices.ais.co.th/ExternalServices/WS_OM_OMEHRServices.asmx";

    public java.lang.String getWS_OM_OMEHRServicesSoap12Address() {
        return WS_OM_OMEHRServicesSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_OM_OMEHRServicesSoap12WSDDServiceName = "WS_OM_OMEHRServicesSoap12";

    public java.lang.String getWS_OM_OMEHRServicesSoap12WSDDServiceName() {
        return WS_OM_OMEHRServicesSoap12WSDDServiceName;
    }

    public void setWS_OM_OMEHRServicesSoap12WSDDServiceName(java.lang.String name) {
        WS_OM_OMEHRServicesSoap12WSDDServiceName = name;
    }

    public org.tempuri.WS_OM_OMEHRServicesSoap getWS_OM_OMEHRServicesSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_OM_OMEHRServicesSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_OM_OMEHRServicesSoap12(endpoint);
    }

    public org.tempuri.WS_OM_OMEHRServicesSoap getWS_OM_OMEHRServicesSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.WS_OM_OMEHRServicesSoap12Stub _stub = new org.tempuri.WS_OM_OMEHRServicesSoap12Stub(portAddress, this);
            _stub.setPortName(getWS_OM_OMEHRServicesSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_OM_OMEHRServicesSoap12EndpointAddress(java.lang.String address) {
        WS_OM_OMEHRServicesSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.WS_OM_OMEHRServicesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
            	org.tempuri.WS_OM_OMEHRServicesSoapStub _stub = null;
            	if(username!=null && password!=null){
                	_stub = new org.tempuri.WS_OM_OMEHRServicesSoapStub(new java.net.URL(WS_OM_OMEHRServicesSoap_address), this, username, password);
                }else{
                	_stub = new org.tempuri.WS_OM_OMEHRServicesSoapStub(new java.net.URL(WS_OM_OMEHRServicesSoap_address), this);	
                }            	
                _stub.setPortName(getWS_OM_OMEHRServicesSoapWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.WS_OM_OMEHRServicesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.WS_OM_OMEHRServicesSoap12Stub _stub = new org.tempuri.WS_OM_OMEHRServicesSoap12Stub(new java.net.URL(WS_OM_OMEHRServicesSoap12_address), this);
                _stub.setPortName(getWS_OM_OMEHRServicesSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WS_OM_OMEHRServicesSoap".equals(inputPortName)) {
            return getWS_OM_OMEHRServicesSoap();
        }
        else if ("WS_OM_OMEHRServicesSoap12".equals(inputPortName)) {
            return getWS_OM_OMEHRServicesSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WS_OM_OMEHRServices");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_OM_OMEHRServicesSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WS_OM_OMEHRServicesSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_OM_OMEHRServicesSoap".equals(portName)) {
            setWS_OM_OMEHRServicesSoapEndpointAddress(address);
        }
        else 
if ("WS_OM_OMEHRServicesSoap12".equals(portName)) {
            setWS_OM_OMEHRServicesSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
