/**
 * CorporateSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface CorporateSoap extends java.rmi.Remote {

    /**
     * Authen Corporate Delete LDAP Service
     */
    public org.tempuri.WS_GEN_DeleteAuthenLDAPResponseWS_GEN_DeleteAuthenLDAPResult WS_GEN_DeleteAuthenLDAP(java.lang.String userName, java.lang.String projectCode) throws java.rmi.RemoteException;

    /**
     * Authen Corporate Search LDAP Service
     */
    public org.tempuri.WS_GEN_SearchAuthenLDAPResponseWS_GEN_SearchAuthenLDAPResult WS_GEN_SearchAuthenLDAP(java.lang.String userName, java.lang.String passWd, java.lang.String projectCode) throws java.rmi.RemoteException;

    /**
     * Authen Corporate LDAP Service
     */
    public org.tempuri.WS_GEN_ADDAuthenLDAPResponseWS_GEN_ADDAuthenLDAPResult WS_GEN_ADDAuthenLDAP(java.lang.String userName, java.lang.String passWd, java.lang.String projectCode, java.lang.String EECODE) throws java.rmi.RemoteException;

    /**
     * Authen Corporate Get User Info
     */
    public org.tempuri.WS_GEN_GetUserInfoResponseWS_GEN_GetUserInfoResult WS_GEN_GetUserInfo(java.lang.String userName, java.lang.String projectCode) throws java.rmi.RemoteException;

    /**
     * Authen Corporate LDAP Service
     */
    public org.tempuri.WS_GEN_AuthenLDAPResponseWS_GEN_AuthenLDAPResult WS_GEN_AuthenLDAP(java.lang.String userName, java.lang.String passWd, java.lang.String projectCode) throws java.rmi.RemoteException;

    /**
     * Authen Corporate Change Password LDAP Service
     */
    public org.tempuri.WS_GEN_UpdateAuthenLDAPResponseWS_GEN_UpdateAuthenLDAPResult WS_GEN_UpdateAuthenLDAP(java.lang.String userName, java.lang.String oldPassWd, java.lang.String newPassWd, java.lang.String projectCode) throws java.rmi.RemoteException;
}
