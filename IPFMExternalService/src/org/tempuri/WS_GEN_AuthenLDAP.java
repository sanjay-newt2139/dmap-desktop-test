/**
 * WS_GEN_AuthenLDAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_GEN_AuthenLDAP  implements java.io.Serializable {
    private java.lang.String userName;

    private java.lang.String passWd;

    private java.lang.String projectCode;

    public WS_GEN_AuthenLDAP() {
    }

    public WS_GEN_AuthenLDAP(
           java.lang.String userName,
           java.lang.String passWd,
           java.lang.String projectCode) {
           this.userName = userName;
           this.passWd = passWd;
           this.projectCode = projectCode;
    }


    /**
     * Gets the userName value for this WS_GEN_AuthenLDAP.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this WS_GEN_AuthenLDAP.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the passWd value for this WS_GEN_AuthenLDAP.
     * 
     * @return passWd
     */
    public java.lang.String getPassWd() {
        return passWd;
    }


    /**
     * Sets the passWd value for this WS_GEN_AuthenLDAP.
     * 
     * @param passWd
     */
    public void setPassWd(java.lang.String passWd) {
        this.passWd = passWd;
    }


    /**
     * Gets the projectCode value for this WS_GEN_AuthenLDAP.
     * 
     * @return projectCode
     */
    public java.lang.String getProjectCode() {
        return projectCode;
    }


    /**
     * Sets the projectCode value for this WS_GEN_AuthenLDAP.
     * 
     * @param projectCode
     */
    public void setProjectCode(java.lang.String projectCode) {
        this.projectCode = projectCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_GEN_AuthenLDAP)) return false;
        WS_GEN_AuthenLDAP other = (WS_GEN_AuthenLDAP) obj;
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
            ((this.passWd==null && other.getPassWd()==null) || 
             (this.passWd!=null &&
              this.passWd.equals(other.getPassWd()))) &&
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
        if (getPassWd() != null) {
            _hashCode += getPassWd().hashCode();
        }
        if (getProjectCode() != null) {
            _hashCode += getProjectCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_GEN_AuthenLDAP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WS_GEN_AuthenLDAP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passWd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "passWd"));
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
