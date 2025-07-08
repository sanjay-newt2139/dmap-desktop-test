/**
 * ListAllPinsUnderOrgCodeByPrefixEmail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixEmail  implements java.io.Serializable {
    private java.lang.String vOrgCode;

    private java.lang.String vEmail;

    public ListAllPinsUnderOrgCodeByPrefixEmail() {
    }

    public ListAllPinsUnderOrgCodeByPrefixEmail(
           java.lang.String vOrgCode,
           java.lang.String vEmail) {
           this.vOrgCode = vOrgCode;
           this.vEmail = vEmail;
    }


    /**
     * Gets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixEmail.
     * 
     * @return vOrgCode
     */
    public java.lang.String getVOrgCode() {
        return vOrgCode;
    }


    /**
     * Sets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixEmail.
     * 
     * @param vOrgCode
     */
    public void setVOrgCode(java.lang.String vOrgCode) {
        this.vOrgCode = vOrgCode;
    }


    /**
     * Gets the vEmail value for this ListAllPinsUnderOrgCodeByPrefixEmail.
     * 
     * @return vEmail
     */
    public java.lang.String getVEmail() {
        return vEmail;
    }


    /**
     * Sets the vEmail value for this ListAllPinsUnderOrgCodeByPrefixEmail.
     * 
     * @param vEmail
     */
    public void setVEmail(java.lang.String vEmail) {
        this.vEmail = vEmail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixEmail)) return false;
        ListAllPinsUnderOrgCodeByPrefixEmail other = (ListAllPinsUnderOrgCodeByPrefixEmail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vOrgCode==null && other.getVOrgCode()==null) || 
             (this.vOrgCode!=null &&
              this.vOrgCode.equals(other.getVOrgCode()))) &&
            ((this.vEmail==null && other.getVEmail()==null) || 
             (this.vEmail!=null &&
              this.vEmail.equals(other.getVEmail())));
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
        if (getVOrgCode() != null) {
            _hashCode += getVOrgCode().hashCode();
        }
        if (getVEmail() != null) {
            _hashCode += getVEmail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixEmail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixEmail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vEmail"));
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
