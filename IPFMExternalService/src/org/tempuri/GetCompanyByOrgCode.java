/**
 * GetCompanyByOrgCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetCompanyByOrgCode  implements java.io.Serializable {
    private java.lang.String vOrgID;

    public GetCompanyByOrgCode() {
    }

    public GetCompanyByOrgCode(
           java.lang.String vOrgID) {
           this.vOrgID = vOrgID;
    }


    /**
     * Gets the vOrgID value for this GetCompanyByOrgCode.
     * 
     * @return vOrgID
     */
    public java.lang.String getVOrgID() {
        return vOrgID;
    }


    /**
     * Sets the vOrgID value for this GetCompanyByOrgCode.
     * 
     * @param vOrgID
     */
    public void setVOrgID(java.lang.String vOrgID) {
        this.vOrgID = vOrgID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCompanyByOrgCode)) return false;
        GetCompanyByOrgCode other = (GetCompanyByOrgCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vOrgID==null && other.getVOrgID()==null) || 
             (this.vOrgID!=null &&
              this.vOrgID.equals(other.getVOrgID())));
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
        if (getVOrgID() != null) {
            _hashCode += getVOrgID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCompanyByOrgCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetCompanyByOrgCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VOrgID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "vOrgID"));
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
