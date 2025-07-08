/**
 * ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse  implements java.io.Serializable {
    private org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult listAllPinsUnderOrgCodeByPrefixThaiSurNameResult;

    public ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse() {
    }

    public ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse(
           org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult listAllPinsUnderOrgCodeByPrefixThaiSurNameResult) {
           this.listAllPinsUnderOrgCodeByPrefixThaiSurNameResult = listAllPinsUnderOrgCodeByPrefixThaiSurNameResult;
    }


    /**
     * Gets the listAllPinsUnderOrgCodeByPrefixThaiSurNameResult value for this ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse.
     * 
     * @return listAllPinsUnderOrgCodeByPrefixThaiSurNameResult
     */
    public org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult getListAllPinsUnderOrgCodeByPrefixThaiSurNameResult() {
        return listAllPinsUnderOrgCodeByPrefixThaiSurNameResult;
    }


    /**
     * Sets the listAllPinsUnderOrgCodeByPrefixThaiSurNameResult value for this ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse.
     * 
     * @param listAllPinsUnderOrgCodeByPrefixThaiSurNameResult
     */
    public void setListAllPinsUnderOrgCodeByPrefixThaiSurNameResult(org.tempuri.ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponseListAllPinsUnderOrgCodeByPrefixThaiSurNameResult listAllPinsUnderOrgCodeByPrefixThaiSurNameResult) {
        this.listAllPinsUnderOrgCodeByPrefixThaiSurNameResult = listAllPinsUnderOrgCodeByPrefixThaiSurNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse)) return false;
        ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse other = (ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listAllPinsUnderOrgCodeByPrefixThaiSurNameResult==null && other.getListAllPinsUnderOrgCodeByPrefixThaiSurNameResult()==null) || 
             (this.listAllPinsUnderOrgCodeByPrefixThaiSurNameResult!=null &&
              this.listAllPinsUnderOrgCodeByPrefixThaiSurNameResult.equals(other.getListAllPinsUnderOrgCodeByPrefixThaiSurNameResult())));
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
        if (getListAllPinsUnderOrgCodeByPrefixThaiSurNameResult() != null) {
            _hashCode += getListAllPinsUnderOrgCodeByPrefixThaiSurNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listAllPinsUnderOrgCodeByPrefixThaiSurNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeByPrefixThaiSurNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeByPrefixThaiSurNameResponse>ListAllPinsUnderOrgCodeByPrefixThaiSurNameResult"));
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
