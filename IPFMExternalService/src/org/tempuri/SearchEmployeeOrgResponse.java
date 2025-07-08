/**
 * SearchEmployeeOrgResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SearchEmployeeOrgResponse  implements java.io.Serializable {
    private org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult searchEmployeeOrgResult;

    public SearchEmployeeOrgResponse() {
    }

    public SearchEmployeeOrgResponse(
           org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult searchEmployeeOrgResult) {
           this.searchEmployeeOrgResult = searchEmployeeOrgResult;
    }


    /**
     * Gets the searchEmployeeOrgResult value for this SearchEmployeeOrgResponse.
     * 
     * @return searchEmployeeOrgResult
     */
    public org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult getSearchEmployeeOrgResult() {
        return searchEmployeeOrgResult;
    }


    /**
     * Sets the searchEmployeeOrgResult value for this SearchEmployeeOrgResponse.
     * 
     * @param searchEmployeeOrgResult
     */
    public void setSearchEmployeeOrgResult(org.tempuri.SearchEmployeeOrgResponseSearchEmployeeOrgResult searchEmployeeOrgResult) {
        this.searchEmployeeOrgResult = searchEmployeeOrgResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchEmployeeOrgResponse)) return false;
        SearchEmployeeOrgResponse other = (SearchEmployeeOrgResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchEmployeeOrgResult==null && other.getSearchEmployeeOrgResult()==null) || 
             (this.searchEmployeeOrgResult!=null &&
              this.searchEmployeeOrgResult.equals(other.getSearchEmployeeOrgResult())));
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
        if (getSearchEmployeeOrgResult() != null) {
            _hashCode += getSearchEmployeeOrgResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchEmployeeOrgResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SearchEmployeeOrgResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchEmployeeOrgResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SearchEmployeeOrgResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>SearchEmployeeOrgResponse>SearchEmployeeOrgResult"));
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
