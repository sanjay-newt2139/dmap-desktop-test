/**
 * GetEmployeeProfileByPrefixEngName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixEngName  implements java.io.Serializable {
    private java.lang.String empEngName;

    public GetEmployeeProfileByPrefixEngName() {
    }

    public GetEmployeeProfileByPrefixEngName(
           java.lang.String empEngName) {
           this.empEngName = empEngName;
    }


    /**
     * Gets the empEngName value for this GetEmployeeProfileByPrefixEngName.
     * 
     * @return empEngName
     */
    public java.lang.String getEmpEngName() {
        return empEngName;
    }


    /**
     * Sets the empEngName value for this GetEmployeeProfileByPrefixEngName.
     * 
     * @param empEngName
     */
    public void setEmpEngName(java.lang.String empEngName) {
        this.empEngName = empEngName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixEngName)) return false;
        GetEmployeeProfileByPrefixEngName other = (GetEmployeeProfileByPrefixEngName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empEngName==null && other.getEmpEngName()==null) || 
             (this.empEngName!=null &&
              this.empEngName.equals(other.getEmpEngName())));
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
        if (getEmpEngName() != null) {
            _hashCode += getEmpEngName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixEngName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixEngName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empEngName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "empEngName"));
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
