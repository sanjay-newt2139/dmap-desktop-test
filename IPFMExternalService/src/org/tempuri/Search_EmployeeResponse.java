/**
 * Search_EmployeeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Search_EmployeeResponse  implements java.io.Serializable {
    private org.tempuri.Search_EmployeeResponseSearch_EmployeeResult search_EmployeeResult;

    public Search_EmployeeResponse() {
    }

    public Search_EmployeeResponse(
           org.tempuri.Search_EmployeeResponseSearch_EmployeeResult search_EmployeeResult) {
           this.search_EmployeeResult = search_EmployeeResult;
    }


    /**
     * Gets the search_EmployeeResult value for this Search_EmployeeResponse.
     * 
     * @return search_EmployeeResult
     */
    public org.tempuri.Search_EmployeeResponseSearch_EmployeeResult getSearch_EmployeeResult() {
        return search_EmployeeResult;
    }


    /**
     * Sets the search_EmployeeResult value for this Search_EmployeeResponse.
     * 
     * @param search_EmployeeResult
     */
    public void setSearch_EmployeeResult(org.tempuri.Search_EmployeeResponseSearch_EmployeeResult search_EmployeeResult) {
        this.search_EmployeeResult = search_EmployeeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Search_EmployeeResponse)) return false;
        Search_EmployeeResponse other = (Search_EmployeeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.search_EmployeeResult==null && other.getSearch_EmployeeResult()==null) || 
             (this.search_EmployeeResult!=null &&
              this.search_EmployeeResult.equals(other.getSearch_EmployeeResult())));
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
        if (getSearch_EmployeeResult() != null) {
            _hashCode += getSearch_EmployeeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Search_EmployeeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Search_EmployeeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("search_EmployeeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Search_EmployeeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Search_EmployeeResponse>Search_EmployeeResult"));
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
