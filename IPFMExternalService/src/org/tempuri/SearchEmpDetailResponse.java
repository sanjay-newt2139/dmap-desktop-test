/**
 * SearchEmpDetailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SearchEmpDetailResponse  implements java.io.Serializable {
    private org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult searchEmpDetailResult;

    public SearchEmpDetailResponse() {
    }

    public SearchEmpDetailResponse(
           org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult searchEmpDetailResult) {
           this.searchEmpDetailResult = searchEmpDetailResult;
    }


    /**
     * Gets the searchEmpDetailResult value for this SearchEmpDetailResponse.
     * 
     * @return searchEmpDetailResult
     */
    public org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult getSearchEmpDetailResult() {
        return searchEmpDetailResult;
    }


    /**
     * Sets the searchEmpDetailResult value for this SearchEmpDetailResponse.
     * 
     * @param searchEmpDetailResult
     */
    public void setSearchEmpDetailResult(org.tempuri.SearchEmpDetailResponseSearchEmpDetailResult searchEmpDetailResult) {
        this.searchEmpDetailResult = searchEmpDetailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchEmpDetailResponse)) return false;
        SearchEmpDetailResponse other = (SearchEmpDetailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchEmpDetailResult==null && other.getSearchEmpDetailResult()==null) || 
             (this.searchEmpDetailResult!=null &&
              this.searchEmpDetailResult.equals(other.getSearchEmpDetailResult())));
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
        if (getSearchEmpDetailResult() != null) {
            _hashCode += getSearchEmpDetailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchEmpDetailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchEmpDetailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchEmpDetailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchEmpDetailResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchEmpDetailResponse>SearchEmpDetailResult"));
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
