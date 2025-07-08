/**
 * WS_GEN_SearchAuthenLDAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WS_GEN_SearchAuthenLDAPResponse  implements java.io.Serializable {
    private org.tempuri.WS_GEN_SearchAuthenLDAPResponseWS_GEN_SearchAuthenLDAPResult WS_GEN_SearchAuthenLDAPResult;

    public WS_GEN_SearchAuthenLDAPResponse() {
    }

    public WS_GEN_SearchAuthenLDAPResponse(
           org.tempuri.WS_GEN_SearchAuthenLDAPResponseWS_GEN_SearchAuthenLDAPResult WS_GEN_SearchAuthenLDAPResult) {
           this.WS_GEN_SearchAuthenLDAPResult = WS_GEN_SearchAuthenLDAPResult;
    }


    /**
     * Gets the WS_GEN_SearchAuthenLDAPResult value for this WS_GEN_SearchAuthenLDAPResponse.
     * 
     * @return WS_GEN_SearchAuthenLDAPResult
     */
    public org.tempuri.WS_GEN_SearchAuthenLDAPResponseWS_GEN_SearchAuthenLDAPResult getWS_GEN_SearchAuthenLDAPResult() {
        return WS_GEN_SearchAuthenLDAPResult;
    }


    /**
     * Sets the WS_GEN_SearchAuthenLDAPResult value for this WS_GEN_SearchAuthenLDAPResponse.
     * 
     * @param WS_GEN_SearchAuthenLDAPResult
     */
    public void setWS_GEN_SearchAuthenLDAPResult(org.tempuri.WS_GEN_SearchAuthenLDAPResponseWS_GEN_SearchAuthenLDAPResult WS_GEN_SearchAuthenLDAPResult) {
        this.WS_GEN_SearchAuthenLDAPResult = WS_GEN_SearchAuthenLDAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_GEN_SearchAuthenLDAPResponse)) return false;
        WS_GEN_SearchAuthenLDAPResponse other = (WS_GEN_SearchAuthenLDAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WS_GEN_SearchAuthenLDAPResult==null && other.getWS_GEN_SearchAuthenLDAPResult()==null) || 
             (this.WS_GEN_SearchAuthenLDAPResult!=null &&
              this.WS_GEN_SearchAuthenLDAPResult.equals(other.getWS_GEN_SearchAuthenLDAPResult())));
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
        if (getWS_GEN_SearchAuthenLDAPResult() != null) {
            _hashCode += getWS_GEN_SearchAuthenLDAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_GEN_SearchAuthenLDAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WS_GEN_SearchAuthenLDAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WS_GEN_SearchAuthenLDAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WS_GEN_SearchAuthenLDAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WS_GEN_SearchAuthenLDAPResponse>WS_GEN_SearchAuthenLDAPResult"));
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
