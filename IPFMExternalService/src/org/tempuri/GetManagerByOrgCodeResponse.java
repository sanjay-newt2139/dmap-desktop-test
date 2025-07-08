/**
 * GetManagerByOrgCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetManagerByOrgCodeResponse  implements java.io.Serializable {
    private java.lang.String getManagerByOrgCodeResult;

    public GetManagerByOrgCodeResponse() {
    }

    public GetManagerByOrgCodeResponse(
           java.lang.String getManagerByOrgCodeResult) {
           this.getManagerByOrgCodeResult = getManagerByOrgCodeResult;
    }


    /**
     * Gets the getManagerByOrgCodeResult value for this GetManagerByOrgCodeResponse.
     * 
     * @return getManagerByOrgCodeResult
     */
    public java.lang.String getGetManagerByOrgCodeResult() {
        return getManagerByOrgCodeResult;
    }


    /**
     * Sets the getManagerByOrgCodeResult value for this GetManagerByOrgCodeResponse.
     * 
     * @param getManagerByOrgCodeResult
     */
    public void setGetManagerByOrgCodeResult(java.lang.String getManagerByOrgCodeResult) {
        this.getManagerByOrgCodeResult = getManagerByOrgCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetManagerByOrgCodeResponse)) return false;
        GetManagerByOrgCodeResponse other = (GetManagerByOrgCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getManagerByOrgCodeResult==null && other.getGetManagerByOrgCodeResult()==null) || 
             (this.getManagerByOrgCodeResult!=null &&
              this.getManagerByOrgCodeResult.equals(other.getGetManagerByOrgCodeResult())));
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
        if (getGetManagerByOrgCodeResult() != null) {
            _hashCode += getGetManagerByOrgCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetManagerByOrgCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetManagerByOrgCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getManagerByOrgCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetManagerByOrgCodeResult"));
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
