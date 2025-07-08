/**
 * ListAllPinsUnderOrgCodeByPrefixThaiSurName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixThaiSurName  implements java.io.Serializable {
    private java.lang.String vOrgCode;

    private java.lang.String vThSurname;

    public ListAllPinsUnderOrgCodeByPrefixThaiSurName() {
    }

    public ListAllPinsUnderOrgCodeByPrefixThaiSurName(
           java.lang.String vOrgCode,
           java.lang.String vThSurname) {
           this.vOrgCode = vOrgCode;
           this.vThSurname = vThSurname;
    }


    /**
     * Gets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixThaiSurName.
     * 
     * @return vOrgCode
     */
    public java.lang.String getVOrgCode() {
        return vOrgCode;
    }


    /**
     * Sets the vOrgCode value for this ListAllPinsUnderOrgCodeByPrefixThaiSurName.
     * 
     * @param vOrgCode
     */
    public void setVOrgCode(java.lang.String vOrgCode) {
        this.vOrgCode = vOrgCode;
    }


    /**
     * Gets the vThSurname value for this ListAllPinsUnderOrgCodeByPrefixThaiSurName.
     * 
     * @return vThSurname
     */
    public java.lang.String getVThSurname() {
        return vThSurname;
    }


    /**
     * Sets the vThSurname value for this ListAllPinsUnderOrgCodeByPrefixThaiSurName.
     * 
     * @param vThSurname
     */
    public void setVThSurname(java.lang.String vThSurname) {
        this.vThSurname = vThSurname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixThaiSurName)) return false;
        ListAllPinsUnderOrgCodeByPrefixThaiSurName other = (ListAllPinsUnderOrgCodeByPrefixThaiSurName) obj;
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
            ((this.vThSurname==null && other.getVThSurname()==null) || 
             (this.vThSurname!=null &&
              this.vThSurname.equals(other.getVThSurname())));
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
        if (getVThSurname() != null) {
            _hashCode += getVThSurname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixThaiSurName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiSurName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VThSurname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vThSurname"));
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
