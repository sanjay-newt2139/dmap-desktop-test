/**
 * WS_GEN_UpdateAuthenLDAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_GEN_UpdateAuthenLDAP  implements java.io.Serializable {
    private java.lang.String userName;

    private java.lang.String oldPassWd;

    private java.lang.String newPassWd;

    private java.lang.String projectCode;

    public WS_GEN_UpdateAuthenLDAP() {
    }

    public WS_GEN_UpdateAuthenLDAP(
           java.lang.String userName,
           java.lang.String oldPassWd,
           java.lang.String newPassWd,
           java.lang.String projectCode) {
           this.userName = userName;
           this.oldPassWd = oldPassWd;
           this.newPassWd = newPassWd;
           this.projectCode = projectCode;
    }


    /**
     * Gets the userName value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the oldPassWd value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @return oldPassWd
     */
    public java.lang.String getOldPassWd() {
        return oldPassWd;
    }


    /**
     * Sets the oldPassWd value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @param oldPassWd
     */
    public void setOldPassWd(java.lang.String oldPassWd) {
        this.oldPassWd = oldPassWd;
    }


    /**
     * Gets the newPassWd value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @return newPassWd
     */
    public java.lang.String getNewPassWd() {
        return newPassWd;
    }


    /**
     * Sets the newPassWd value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @param newPassWd
     */
    public void setNewPassWd(java.lang.String newPassWd) {
        this.newPassWd = newPassWd;
    }


    /**
     * Gets the projectCode value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @return projectCode
     */
    public java.lang.String getProjectCode() {
        return projectCode;
    }


    /**
     * Sets the projectCode value for this WS_GEN_UpdateAuthenLDAP.
     * 
     * @param projectCode
     */
    public void setProjectCode(java.lang.String projectCode) {
        this.projectCode = projectCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_GEN_UpdateAuthenLDAP)) return false;
        WS_GEN_UpdateAuthenLDAP other = (WS_GEN_UpdateAuthenLDAP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.oldPassWd==null && other.getOldPassWd()==null) || 
             (this.oldPassWd!=null &&
              this.oldPassWd.equals(other.getOldPassWd()))) &&
            ((this.newPassWd==null && other.getNewPassWd()==null) || 
             (this.newPassWd!=null &&
              this.newPassWd.equals(other.getNewPassWd()))) &&
            ((this.projectCode==null && other.getProjectCode()==null) || 
             (this.projectCode!=null &&
              this.projectCode.equals(other.getProjectCode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getOldPassWd() != null) {
            _hashCode += getOldPassWd().hashCode();
        }
        if (getNewPassWd() != null) {
            _hashCode += getNewPassWd().hashCode();
        }
        if (getProjectCode() != null) {
            _hashCode += getProjectCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_GEN_UpdateAuthenLDAP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WS_GEN_UpdateAuthenLDAP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oldPassWd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "OldPassWd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newPassWd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NewPassWd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "projectCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
