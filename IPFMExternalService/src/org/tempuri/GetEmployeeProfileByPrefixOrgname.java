/**
 * GetEmployeeProfileByPrefixOrgname.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixOrgname  implements java.io.Serializable {
    private java.lang.String empOrgname;

    public GetEmployeeProfileByPrefixOrgname() {
    }

    public GetEmployeeProfileByPrefixOrgname(
           java.lang.String empOrgname) {
           this.empOrgname = empOrgname;
    }


    /**
     * Gets the empOrgname value for this GetEmployeeProfileByPrefixOrgname.
     * 
     * @return empOrgname
     */
    public java.lang.String getEmpOrgname() {
        return empOrgname;
    }


    /**
     * Sets the empOrgname value for this GetEmployeeProfileByPrefixOrgname.
     * 
     * @param empOrgname
     */
    public void setEmpOrgname(java.lang.String empOrgname) {
        this.empOrgname = empOrgname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixOrgname)) return false;
        GetEmployeeProfileByPrefixOrgname other = (GetEmployeeProfileByPrefixOrgname) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empOrgname==null && other.getEmpOrgname()==null) || 
             (this.empOrgname!=null &&
              this.empOrgname.equals(other.getEmpOrgname())));
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
        if (getEmpOrgname() != null) {
            _hashCode += getEmpOrgname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixOrgname.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgname"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empOrgname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "empOrgname"));
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
