/**
 * ListAllPinsUnderOrgCodeByPrefixPin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixPin  implements java.io.Serializable {
    private java.lang.String vOrgCode;

    private java.lang.String vPin;

    public ListAllPinsUnderOrgCodeByPrefixPin() {
    }

    public ListAllPinsUnderOrgCodeByPrefixPin(
           java.lang.String vOrgCode,
           java.lang.String vPin) {
           this.vOrgCode = vOrgCode;
           this.vPin = vPin;
    }


    /**
     * Gets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixPin.
     * 
     * @return vOrgCode
     */
    public java.lang.String getVOrgCode() {
        return vOrgCode;
    }


    /**
     * Sets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixPin.
     * 
     * @param vOrgCode
     */
    public void setVOrgCode(java.lang.String vOrgCode) {
        this.vOrgCode = vOrgCode;
    }


    /**
     * Gets the vPin value for this ListAllPinsUnderOrgCodeByPrefixPin.
     * 
     * @return vPin
     */
    public java.lang.String getVPin() {
        return vPin;
    }


    /**
     * Sets the vPin value for this ListAllPinsUnderOrgCodeByPrefixPin.
     * 
     * @param vPin
     */
    public void setVPin(java.lang.String vPin) {
        this.vPin = vPin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixPin)) return false;
        ListAllPinsUnderOrgCodeByPrefixPin other = (ListAllPinsUnderOrgCodeByPrefixPin) obj;
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
            ((this.vPin==null && other.getVPin()==null) || 
             (this.vPin!=null &&
              this.vPin.equals(other.getVPin())));
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
        if (getVPin() != null) {
            _hashCode += getVPin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixPin.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixPin"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VPin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vPin"));
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
