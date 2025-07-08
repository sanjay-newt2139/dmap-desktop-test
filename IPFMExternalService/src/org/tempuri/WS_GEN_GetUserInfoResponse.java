/**
 * WS_GEN_GetUserInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_GEN_GetUserInfoResponse  implements java.io.Serializable {
    private org.tempuri.WS_GEN_GetUserInfoResponseWS_GEN_GetUserInfoResult WS_GEN_GetUserInfoResult;

    public WS_GEN_GetUserInfoResponse() {
    }

    public WS_GEN_GetUserInfoResponse(
           org.tempuri.WS_GEN_GetUserInfoResponseWS_GEN_GetUserInfoResult WS_GEN_GetUserInfoResult) {
           this.WS_GEN_GetUserInfoResult = WS_GEN_GetUserInfoResult;
    }


    /**
     * Gets the WS_GEN_GetUserInfoResult value for this WS_GEN_GetUserInfoResponse.
     * 
     * @return WS_GEN_GetUserInfoResult
     */
    public org.tempuri.WS_GEN_GetUserInfoResponseWS_GEN_GetUserInfoResult getWS_GEN_GetUserInfoResult() {
        return WS_GEN_GetUserInfoResult;
    }


    /**
     * Sets the WS_GEN_GetUserInfoResult value for this WS_GEN_GetUserInfoResponse.
     * 
     * @param WS_GEN_GetUserInfoResult
     */
    public void setWS_GEN_GetUserInfoResult(org.tempuri.WS_GEN_GetUserInfoResponseWS_GEN_GetUserInfoResult WS_GEN_GetUserInfoResult) {
        this.WS_GEN_GetUserInfoResult = WS_GEN_GetUserInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_GEN_GetUserInfoResponse)) return false;
        WS_GEN_GetUserInfoResponse other = (WS_GEN_GetUserInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WS_GEN_GetUserInfoResult==null && other.getWS_GEN_GetUserInfoResult()==null) || 
             (this.WS_GEN_GetUserInfoResult!=null &&
              this.WS_GEN_GetUserInfoResult.equals(other.getWS_GEN_GetUserInfoResult())));
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
        if (getWS_GEN_GetUserInfoResult() != null) {
            _hashCode += getWS_GEN_GetUserInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_GEN_GetUserInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WS_GEN_GetUserInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WS_GEN_GetUserInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WS_GEN_GetUserInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WS_GEN_GetUserInfoResponse>WS_GEN_GetUserInfoResult"));
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
