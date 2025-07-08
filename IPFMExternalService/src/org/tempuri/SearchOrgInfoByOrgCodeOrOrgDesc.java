/**
 * SearchOrgInfoByOrgCodeOrOrgDesc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SearchOrgInfoByOrgCodeOrOrgDesc  implements java.io.Serializable {
    private java.lang.String vCompanyCode;

    private java.lang.String vOrgDesc;

    public SearchOrgInfoByOrgCodeOrOrgDesc() {
    }

    public SearchOrgInfoByOrgCodeOrOrgDesc(
           java.lang.String vCompanyCode,
           java.lang.String vOrgDesc) {
           this.vCompanyCode = vCompanyCode;
           this.vOrgDesc = vOrgDesc;
    }


    /**
     * Gets the vCompanyCode value for this SearchOrgInfoByOrgCodeOrOrgDesc.
     * 
     * @return vCompanyCode
     */
    public java.lang.String getVCompanyCode() {
        return vCompanyCode;
    }


    /**
     * Sets the vCompanyCode value for this SearchOrgInfoByOrgCodeOrOrgDesc.
     * 
     * @param vCompanyCode
     */
    public void setVCompanyCode(java.lang.String vCompanyCode) {
        this.vCompanyCode = vCompanyCode;
    }


    /**
     * Gets the vOrgDesc value for this SearchOrgInfoByOrgCodeOrOrgDesc.
     * 
     * @return vOrgDesc
     */
    public java.lang.String getVOrgDesc() {
        return vOrgDesc;
    }


    /**
     * Sets the vOrgDesc value for this SearchOrgInfoByOrgCodeOrOrgDesc.
     * 
     * @param vOrgDesc
     */
    public void setVOrgDesc(java.lang.String vOrgDesc) {
        this.vOrgDesc = vOrgDesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchOrgInfoByOrgCodeOrOrgDesc)) return false;
        SearchOrgInfoByOrgCodeOrOrgDesc other = (SearchOrgInfoByOrgCodeOrOrgDesc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vCompanyCode==null && other.getVCompanyCode()==null) || 
             (this.vCompanyCode!=null &&
              this.vCompanyCode.equals(other.getVCompanyCode()))) &&
            ((this.vOrgDesc==null && other.getVOrgDesc()==null) || 
             (this.vOrgDesc!=null &&
              this.vOrgDesc.equals(other.getVOrgDesc())));
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
        if (getVCompanyCode() != null) {
            _hashCode += getVCompanyCode().hashCode();
        }
        if (getVOrgDesc() != null) {
            _hashCode += getVOrgDesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchOrgInfoByOrgCodeOrOrgDesc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchOrgInfoByOrgCodeOrOrgDesc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VCompanyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vCompanyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VOrgDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgDesc"));
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
