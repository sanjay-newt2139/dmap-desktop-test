/**
 * GetEmployeeProfileByPrefixOrgdesc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixOrgdesc  implements java.io.Serializable {
    private java.lang.String empOrgdesc;

    public GetEmployeeProfileByPrefixOrgdesc() {
    }

    public GetEmployeeProfileByPrefixOrgdesc(
           java.lang.String empOrgdesc) {
           this.empOrgdesc = empOrgdesc;
    }


    /**
     * Gets the empOrgdesc value for this GetEmployeeProfileByPrefixOrgdesc.
     * 
     * @return empOrgdesc
     */
    public java.lang.String getEmpOrgdesc() {
        return empOrgdesc;
    }


    /**
     * Sets the empOrgdesc value for this GetEmployeeProfileByPrefixOrgdesc.
     * 
     * @param empOrgdesc
     */
    public void setEmpOrgdesc(java.lang.String empOrgdesc) {
        this.empOrgdesc = empOrgdesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixOrgdesc)) return false;
        GetEmployeeProfileByPrefixOrgdesc other = (GetEmployeeProfileByPrefixOrgdesc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empOrgdesc==null && other.getEmpOrgdesc()==null) || 
             (this.empOrgdesc!=null &&
              this.empOrgdesc.equals(other.getEmpOrgdesc())));
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
        if (getEmpOrgdesc() != null) {
            _hashCode += getEmpOrgdesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixOrgdesc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgdesc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empOrgdesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "empOrgdesc"));
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
