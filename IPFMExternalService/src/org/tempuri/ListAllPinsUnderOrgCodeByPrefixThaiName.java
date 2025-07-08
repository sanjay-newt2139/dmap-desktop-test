/**
 * ListAllPinsUnderOrgCodeByPrefixThaiName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixThaiName  implements java.io.Serializable {
    private java.lang.String vOrgCode;

    private java.lang.String vThName;

    public ListAllPinsUnderOrgCodeByPrefixThaiName() {
    }

    public ListAllPinsUnderOrgCodeByPrefixThaiName(
           java.lang.String vOrgCode,
           java.lang.String vThName) {
           this.vOrgCode = vOrgCode;
           this.vThName = vThName;
    }


    /**
     * Gets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixThaiName.
     * 
     * @return vOrgCode
     */
    public java.lang.String getVOrgCode() {
        return vOrgCode;
    }


    /**
     * Sets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixThaiName.
     * 
     * @param vOrgCode
     */
    public void setVOrgCode(java.lang.String vOrgCode) {
        this.vOrgCode = vOrgCode;
    }


    /**
     * Gets the vThName value for this ListAllPinsUnderOrgCodeByPrefixThaiName.
     * 
     * @return vThName
     */
    public java.lang.String getVThName() {
        return vThName;
    }


    /**
     * Sets the vThName value for this ListAllPinsUnderOrgCodeByPrefixThaiName.
     * 
     * @param vThName
     */
    public void setVThName(java.lang.String vThName) {
        this.vThName = vThName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixThaiName)) return false;
        ListAllPinsUnderOrgCodeByPrefixThaiName other = (ListAllPinsUnderOrgCodeByPrefixThaiName) obj;
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
            ((this.vThName==null && other.getVThName()==null) || 
             (this.vThName!=null &&
              this.vThName.equals(other.getVThName())));
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
        if (getVThName() != null) {
            _hashCode += getVThName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixThaiName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VThName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vThName"));
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
