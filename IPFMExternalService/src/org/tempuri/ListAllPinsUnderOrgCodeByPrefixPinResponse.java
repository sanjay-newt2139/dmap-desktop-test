/**
 * ListAllPinsUnderOrgCodeByPrefixPinResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixPinResponse  implements java.io.Serializable {
    private org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult listAllPinsUnderOrgCodeByPrefixPinResult;

    public ListAllPinsUnderOrgCodeByPrefixPinResponse() {
    }

    public ListAllPinsUnderOrgCodeByPrefixPinResponse(
           org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult listAllPinsUnderOrgCodeByPrefixPinResult) {
           this.listAllPinsUnderOrgCodeByPrefixPinResult = listAllPinsUnderOrgCodeByPrefixPinResult;
    }


    /**
     * Gets the listAllPinsUnderOrgCodeByPrefixPinResult value for this ListAllPinsUnderOrgCodeByPrefixPinResponse.
     * 
     * @return listAllPinsUnderOrgCodeByPrefixPinResult
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult getListAllPinsUnderOrgCodeByPrefixPinResult() {
        return listAllPinsUnderOrgCodeByPrefixPinResult;
    }


    /**
     * Sets the listAllPinsUnderOrgCodeByPrefixPinResult value for this ListAllPinsUnderOrgCodeByPrefixPinResponse.
     * 
     * @param listAllPinsUnderOrgCodeByPrefixPinResult
     */
    public void setListAllPinsUnderOrgCodeByPrefixPinResult(org.tempuri.ListAllPinsUnderOrgCodeByPrefixPinResponseListAllPinsUnderOrgCodeByPrefixPinResult listAllPinsUnderOrgCodeByPrefixPinResult) {
        this.listAllPinsUnderOrgCodeByPrefixPinResult = listAllPinsUnderOrgCodeByPrefixPinResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixPinResponse)) return false;
        ListAllPinsUnderOrgCodeByPrefixPinResponse other = (ListAllPinsUnderOrgCodeByPrefixPinResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listAllPinsUnderOrgCodeByPrefixPinResult==null && other.getListAllPinsUnderOrgCodeByPrefixPinResult()==null) || 
             (this.listAllPinsUnderOrgCodeByPrefixPinResult!=null &&
              this.listAllPinsUnderOrgCodeByPrefixPinResult.equals(other.getListAllPinsUnderOrgCodeByPrefixPinResult())));
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
        if (getListAllPinsUnderOrgCodeByPrefixPinResult() != null) {
            _hashCode += getListAllPinsUnderOrgCodeByPrefixPinResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixPinResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixPinResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listAllPinsUnderOrgCodeByPrefixPinResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixPinResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixPinResponse>ListAllPinsUnderOrgCodeByPrefixPinResult"));
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
