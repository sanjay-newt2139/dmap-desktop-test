/**
 * SearchOrgInfoByOrgCodeOrOrgDescResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SearchOrgInfoByOrgCodeOrOrgDescResponse  implements java.io.Serializable {
    private org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult searchOrgInfoByOrgCodeOrOrgDescResult;

    public SearchOrgInfoByOrgCodeOrOrgDescResponse() {
    }

    public SearchOrgInfoByOrgCodeOrOrgDescResponse(
           org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult searchOrgInfoByOrgCodeOrOrgDescResult) {
           this.searchOrgInfoByOrgCodeOrOrgDescResult = searchOrgInfoByOrgCodeOrOrgDescResult;
    }


    /**
     * Gets the searchOrgInfoByOrgCodeOrOrgDescResult value for this SearchOrgInfoByOrgCodeOrOrgDescResponse.
     * 
     * @return searchOrgInfoByOrgCodeOrOrgDescResult
     */
    public org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult getSearchOrgInfoByOrgCodeOrOrgDescResult() {
        return searchOrgInfoByOrgCodeOrOrgDescResult;
    }


    /**
     * Sets the searchOrgInfoByOrgCodeOrOrgDescResult value for this SearchOrgInfoByOrgCodeOrOrgDescResponse.
     * 
     * @param searchOrgInfoByOrgCodeOrOrgDescResult
     */
    public void setSearchOrgInfoByOrgCodeOrOrgDescResult(org.tempuri.SearchOrgInfoByOrgCodeOrOrgDescResponseSearchOrgInfoByOrgCodeOrOrgDescResult searchOrgInfoByOrgCodeOrOrgDescResult) {
        this.searchOrgInfoByOrgCodeOrOrgDescResult = searchOrgInfoByOrgCodeOrOrgDescResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchOrgInfoByOrgCodeOrOrgDescResponse)) return false;
        SearchOrgInfoByOrgCodeOrOrgDescResponse other = (SearchOrgInfoByOrgCodeOrOrgDescResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchOrgInfoByOrgCodeOrOrgDescResult==null && other.getSearchOrgInfoByOrgCodeOrOrgDescResult()==null) || 
             (this.searchOrgInfoByOrgCodeOrOrgDescResult!=null &&
              this.searchOrgInfoByOrgCodeOrOrgDescResult.equals(other.getSearchOrgInfoByOrgCodeOrOrgDescResult())));
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
        if (getSearchOrgInfoByOrgCodeOrOrgDescResult() != null) {
            _hashCode += getSearchOrgInfoByOrgCodeOrOrgDescResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchOrgInfoByOrgCodeOrOrgDescResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchOrgInfoByOrgCodeOrOrgDescResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchOrgInfoByOrgCodeOrOrgDescResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchOrgInfoByOrgCodeOrOrgDescResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchOrgInfoByOrgCodeOrOrgDescResponse>SearchOrgInfoByOrgCodeOrOrgDescResult"));
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
