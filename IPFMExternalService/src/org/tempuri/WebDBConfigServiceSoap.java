/**
 * WebDBConfigServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface WebDBConfigServiceSoap extends java.rmi.Remote {
    public th.co.ais.ehr.domain.DatabaseAccount WS_AUTHENDB_DBConfig(java.lang.String strProjectID) throws java.rmi.RemoteException;
    public th.co.ais.ehr.domain.UserAccount WS_AUTHENDB_USERConfig(java.lang.String strProjectID) throws java.rmi.RemoteException;
}
