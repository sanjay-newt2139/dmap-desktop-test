/**
 * GetOrgInfobyOrgCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetOrgInfobyOrgCode  implements java.io.Serializable {
    private java.lang.String orgCode;

    public GetOrgInfobyOrgCode() {
    }

    public GetOrgInfobyOrgCode(
           java.lang.String orgCode) {
           this.orgCode = orgCode;
    }


    /**
     * Gets the orgCode value for this GetOrgInfobyOrgCode.
     * 
     * @return orgCode
     */
    public java.lang.String getOrgCode() {
        return orgCode;
    }


    /**
     * Sets the orgCode value for this GetOrgInfobyOrgCode.
     * 
     * @param orgCode
     */
    public void setOrgCode(java.lang.String orgCode) {
        this.orgCode = orgCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOrgInfobyOrgCode)) return false;
        GetOrgInfobyOrgCode other = (GetOrgInfobyOrgCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orgCode==null && other.getOrgCode()==null) || 
             (this.orgCode!=null &&
              this.orgCode.equals(other.getOrgCode())));
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
        if (getOrgCode() != null) {
            _hashCode += getOrgCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOrgInfobyOrgCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgInfobyOrgCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "orgCode"));
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
