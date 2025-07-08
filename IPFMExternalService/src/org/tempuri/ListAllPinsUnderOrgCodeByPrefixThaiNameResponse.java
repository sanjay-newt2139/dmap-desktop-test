/**
 * ListAllPinsUnderOrgCodeByPrefixThaiNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixThaiNameResponse  implements java.io.Serializable {
    private org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult listAllPinsUnderOrgCodeByPrefixThaiNameResult;

    public ListAllPinsUnderOrgCodeByPrefixThaiNameResponse() {
    }

    public ListAllPinsUnderOrgCodeByPrefixThaiNameResponse(
           org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult listAllPinsUnderOrgCodeByPrefixThaiNameResult) {
           this.listAllPinsUnderOrgCodeByPrefixThaiNameResult = listAllPinsUnderOrgCodeByPrefixThaiNameResult;
    }


    /**
     * Gets the listAllPinsUnderOrgCodeByPrefixThaiNameResult value for this ListAllPinsUnderOrgCodeByPrefixThaiNameResponse.
     * 
     * @return listAllPinsUnderOrgCodeByPrefixThaiNameResult
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult getListAllPinsUnderOrgCodeByPrefixThaiNameResult() {
        return listAllPinsUnderOrgCodeByPrefixThaiNameResult;
    }


    /**
     * Sets the listAllPinsUnderOrgCodeByPrefixThaiNameResult value for this ListAllPinsUnderOrgCodeByPrefixThaiNameResponse.
     * 
     * @param listAllPinsUnderOrgCodeByPrefixThaiNameResult
     */
    public void setListAllPinsUnderOrgCodeByPrefixThaiNameResult(org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiNameResponseListAllPinsUnderOrgCodeByPrefixThaiNameResult listAllPinsUnderOrgCodeByPrefixThaiNameResult) {
        this.listAllPinsUnderOrgCodeByPrefixThaiNameResult = listAllPinsUnderOrgCodeByPrefixThaiNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixThaiNameResponse)) return false;
        ListAllPinsUnderOrgCodeByPrefixThaiNameResponse other = (ListAllPinsUnderOrgCodeByPrefixThaiNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listAllPinsUnderOrgCodeByPrefixThaiNameResult==null && other.getListAllPinsUnderOrgCodeByPrefixThaiNameResult()==null) || 
             (this.listAllPinsUnderOrgCodeByPrefixThaiNameResult!=null &&
              this.listAllPinsUnderOrgCodeByPrefixThaiNameResult.equals(other.getListAllPinsUnderOrgCodeByPrefixThaiNameResult())));
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
        if (getListAllPinsUnderOrgCodeByPrefixThaiNameResult() != null) {
            _hashCode += getListAllPinsUnderOrgCodeByPrefixThaiNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixThaiNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listAllPinsUnderOrgCodeByPrefixThaiNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixThaiNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixThaiNameResponse>ListAllPinsUnderOrgCodeByPrefixThaiNameResult"));
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
