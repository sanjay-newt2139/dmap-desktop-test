/**
 * WS_GEN_UpdateAuthenLDAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_GEN_UpdateAuthenLDAPResponse  implements java.io.Serializable {
    private org.tempuri.WS_GEN_UpdateAuthenLDAPResponseWS_GEN_UpdateAuthenLDAPResult WS_GEN_UpdateAuthenLDAPResult;

    public WS_GEN_UpdateAuthenLDAPResponse() {
    }

    public WS_GEN_UpdateAuthenLDAPResponse(
           org.tempuri.WS_GEN_UpdateAuthenLDAPResponseWS_GEN_UpdateAuthenLDAPResult WS_GEN_UpdateAuthenLDAPResult) {
           this.WS_GEN_UpdateAuthenLDAPResult = WS_GEN_UpdateAuthenLDAPResult;
    }


    /**
     * Gets the WS_GEN_UpdateAuthenLDAPResult value for this WS_GEN_UpdateAuthenLDAPResponse.
     * 
     * @return WS_GEN_UpdateAuthenLDAPResult
     */
    public org.tempuri.WS_GEN_UpdateAuthenLDAPResponseWS_GEN_UpdateAuthenLDAPResult getWS_GEN_UpdateAuthenLDAPResult() {
        return WS_GEN_UpdateAuthenLDAPResult;
    }


    /**
     * Sets the WS_GEN_UpdateAuthenLDAPResult value for this WS_GEN_UpdateAuthenLDAPResponse.
     * 
     * @param WS_GEN_UpdateAuthenLDAPResult
     */
    public void setWS_GEN_UpdateAuthenLDAPResult(org.tempuri.WS_GEN_UpdateAuthenLDAPResponseWS_GEN_UpdateAuthenLDAPResult WS_GEN_UpdateAuthenLDAPResult) {
        this.WS_GEN_UpdateAuthenLDAPResult = WS_GEN_UpdateAuthenLDAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_GEN_UpdateAuthenLDAPResponse)) return false;
        WS_GEN_UpdateAuthenLDAPResponse other = (WS_GEN_UpdateAuthenLDAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WS_GEN_UpdateAuthenLDAPResult==null && other.getWS_GEN_UpdateAuthenLDAPResult()==null) || 
             (this.WS_GEN_UpdateAuthenLDAPResult!=null &&
              this.WS_GEN_UpdateAuthenLDAPResult.equals(other.getWS_GEN_UpdateAuthenLDAPResult())));
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
        if (getWS_GEN_UpdateAuthenLDAPResult() != null) {
            _hashCode += getWS_GEN_UpdateAuthenLDAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_GEN_UpdateAuthenLDAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WS_GEN_UpdateAuthenLDAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WS_GEN_UpdateAuthenLDAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WS_GEN_UpdateAuthenLDAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WS_GEN_UpdateAuthenLDAPResponse>WS_GEN_UpdateAuthenLDAPResult"));
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
