/**
 * ListOrganize.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListOrganize  implements java.io.Serializable {
    private java.lang.String lowerOrgCode;

    private java.lang.String higherOrgCode;

    public ListOrganize() {
    }

    public ListOrganize(
           java.lang.String lowerOrgCode,
           java.lang.String higherOrgCode) {
           this.lowerOrgCode = lowerOrgCode;
           this.higherOrgCode = higherOrgCode;
    }


    /**
     * Gets the lowerOrgCode value for this ListOrganize.
     * 
     * @return lowerOrgCode
     */
    public java.lang.String getLowerOrgCode() {
        return lowerOrgCode;
    }


    /**
     * Sets the lowerOrgCode value for this ListOrganize.
     * 
     * @param lowerOrgCode
     */
    public void setLowerOrgCode(java.lang.String lowerOrgCode) {
        this.lowerOrgCode = lowerOrgCode;
    }


    /**
     * Gets the higherOrgCode value for this ListOrganize.
     * 
     * @return higherOrgCode
     */
    public java.lang.String getHigherOrgCode() {
        return higherOrgCode;
    }


    /**
     * Sets the higherOrgCode value for this ListOrganize.
     * 
     * @param higherOrgCode
     */
    public void setHigherOrgCode(java.lang.String higherOrgCode) {
        this.higherOrgCode = higherOrgCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListOrganize)) return false;
        ListOrganize other = (ListOrganize) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lowerOrgCode==null && other.getLowerOrgCode()==null) || 
             (this.lowerOrgCode!=null &&
              this.lowerOrgCode.equals(other.getLowerOrgCode()))) &&
            ((this.higherOrgCode==null && other.getHigherOrgCode()==null) || 
             (this.higherOrgCode!=null &&
              this.higherOrgCode.equals(other.getHigherOrgCode())));
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
        if (getLowerOrgCode() != null) {
            _hashCode += getLowerOrgCode().hashCode();
        }
        if (getHigherOrgCode() != null) {
            _hashCode += getHigherOrgCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListOrganize.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganize"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowerOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LowerOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("higherOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HigherOrgCode"));
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
