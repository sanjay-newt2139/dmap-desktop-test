/**
 * ListOrganizeByOrganizeLevel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListOrganizeByOrganizeLevel  implements java.io.Serializable {
    private java.lang.String companyCode;

    private java.lang.String organizeLevel;

    private java.lang.String organizeCode;

    public ListOrganizeByOrganizeLevel() {
    }

    public ListOrganizeByOrganizeLevel(
           java.lang.String companyCode,
           java.lang.String organizeLevel,
           java.lang.String organizeCode) {
           this.companyCode = companyCode;
           this.organizeLevel = organizeLevel;
           this.organizeCode = organizeCode;
    }


    /**
     * Gets the companyCode value for this ListOrganizeByOrganizeLevel.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this ListOrganizeByOrganizeLevel.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the organizeLevel value for this ListOrganizeByOrganizeLevel.
     * 
     * @return organizeLevel
     */
    public java.lang.String getOrganizeLevel() {
        return organizeLevel;
    }


    /**
     * Sets the organizeLevel value for this ListOrganizeByOrganizeLevel.
     * 
     * @param organizeLevel
     */
    public void setOrganizeLevel(java.lang.String organizeLevel) {
        this.organizeLevel = organizeLevel;
    }


    /**
     * Gets the organizeCode value for this ListOrganizeByOrganizeLevel.
     * 
     * @return organizeCode
     */
    public java.lang.String getOrganizeCode() {
        return organizeCode;
    }


    /**
     * Sets the organizeCode value for this ListOrganizeByOrganizeLevel.
     * 
     * @param organizeCode
     */
    public void setOrganizeCode(java.lang.String organizeCode) {
        this.organizeCode = organizeCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListOrganizeByOrganizeLevel)) return false;
        ListOrganizeByOrganizeLevel other = (ListOrganizeByOrganizeLevel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.organizeLevel==null && other.getOrganizeLevel()==null) || 
             (this.organizeLevel!=null &&
              this.organizeLevel.equals(other.getOrganizeLevel()))) &&
            ((this.organizeCode==null && other.getOrganizeCode()==null) || 
             (this.organizeCode!=null &&
              this.organizeCode.equals(other.getOrganizeCode())));
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
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getOrganizeLevel() != null) {
            _hashCode += getOrganizeLevel().hashCode();
        }
        if (getOrganizeCode() != null) {
            _hashCode += getOrganizeCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListOrganizeByOrganizeLevel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeByOrganizeLevel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CompanyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizeLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "OrganizeLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "OrganizeCode"));
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
