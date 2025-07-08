/**
 * GetEmployeeProfileByPrefixOrgcode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixOrgcode  implements java.io.Serializable {
    private java.lang.String empOrgcode;

    public GetEmployeeProfileByPrefixOrgcode() {
    }

    public GetEmployeeProfileByPrefixOrgcode(
           java.lang.String empOrgcode) {
           this.empOrgcode = empOrgcode;
    }


    /**
     * Gets the empOrgcode value for this GetEmployeeProfileByPrefixOrgcode.
     * 
     * @return empOrgcode
     */
    public java.lang.String getEmpOrgcode() {
        return empOrgcode;
    }


    /**
     * Sets the empOrgcode value for this GetEmployeeProfileByPrefixOrgcode.
     * 
     * @param empOrgcode
     */
    public void setEmpOrgcode(java.lang.String empOrgcode) {
        this.empOrgcode = empOrgcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixOrgcode)) return false;
        GetEmployeeProfileByPrefixOrgcode other = (GetEmployeeProfileByPrefixOrgcode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empOrgcode==null && other.getEmpOrgcode()==null) || 
             (this.empOrgcode!=null &&
              this.empOrgcode.equals(other.getEmpOrgcode())));
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
        if (getEmpOrgcode() != null) {
            _hashCode += getEmpOrgcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixOrgcode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgcode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empOrgcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "empOrgcode"));
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
