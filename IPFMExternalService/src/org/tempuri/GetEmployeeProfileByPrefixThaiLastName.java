/**
 * GetEmployeeProfileByPrefixThaiLastName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixThaiLastName  implements java.io.Serializable {
    private java.lang.String empThaiLastName;

    public GetEmployeeProfileByPrefixThaiLastName() {
    }

    public GetEmployeeProfileByPrefixThaiLastName(
           java.lang.String empThaiLastName) {
           this.empThaiLastName = empThaiLastName;
    }


    /**
     * Gets the empThaiLastName value for this GetEmployeeProfileByPrefixThaiLastName.
     * 
     * @return empThaiLastName
     */
    public java.lang.String getEmpThaiLastName() {
        return empThaiLastName;
    }


    /**
     * Sets the empThaiLastName value for this GetEmployeeProfileByPrefixThaiLastName.
     * 
     * @param empThaiLastName
     */
    public void setEmpThaiLastName(java.lang.String empThaiLastName) {
        this.empThaiLastName = empThaiLastName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixThaiLastName)) return false;
        GetEmployeeProfileByPrefixThaiLastName other = (GetEmployeeProfileByPrefixThaiLastName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empThaiLastName==null && other.getEmpThaiLastName()==null) || 
             (this.empThaiLastName!=null &&
              this.empThaiLastName.equals(other.getEmpThaiLastName())));
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
        if (getEmpThaiLastName() != null) {
            _hashCode += getEmpThaiLastName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixThaiLastName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixThaiLastName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empThaiLastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "empThaiLastName"));
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
