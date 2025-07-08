/**
 * ListOrgDescByPrefixResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListOrgDescByPrefixResponse  implements java.io.Serializable {
    private org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult listOrgDescByPrefixResult;

    public ListOrgDescByPrefixResponse() {
    }

    public ListOrgDescByPrefixResponse(
           org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult listOrgDescByPrefixResult) {
           this.listOrgDescByPrefixResult = listOrgDescByPrefixResult;
    }


    /**
     * Gets the listOrgDescByPrefixResult value for this ListOrgDescByPrefixResponse.
     * 
     * @return listOrgDescByPrefixResult
     */
    public org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult getListOrgDescByPrefixResult() {
        return listOrgDescByPrefixResult;
    }


    /**
     * Sets the listOrgDescByPrefixResult value for this ListOrgDescByPrefixResponse.
     * 
     * @param listOrgDescByPrefixResult
     */
    public void setListOrgDescByPrefixResult(org.tempuri.ListOrgDescByPrefixResponseListOrgDescByPrefixResult listOrgDescByPrefixResult) {
        this.listOrgDescByPrefixResult = listOrgDescByPrefixResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListOrgDescByPrefixResponse)) return false;
        ListOrgDescByPrefixResponse other = (ListOrgDescByPrefixResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listOrgDescByPrefixResult==null && other.getListOrgDescByPrefixResult()==null) || 
             (this.listOrgDescByPrefixResult!=null &&
              this.listOrgDescByPrefixResult.equals(other.getListOrgDescByPrefixResult())));
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
        if (getListOrgDescByPrefixResult() != null) {
            _hashCode += getListOrgDescByPrefixResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListOrgDescByPrefixResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrgDescByPrefixResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOrgDescByPrefixResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrgDescByPrefixResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrgDescByPrefixResponse>ListOrgDescByPrefixResult"));
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
