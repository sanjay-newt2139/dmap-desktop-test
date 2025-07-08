/**
 * ListGradeDescByPrefixResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListGradeDescByPrefixResponse  implements java.io.Serializable {
    private org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult listGradeDescByPrefixResult;

    public ListGradeDescByPrefixResponse() {
    }

    public ListGradeDescByPrefixResponse(
           org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult listGradeDescByPrefixResult) {
           this.listGradeDescByPrefixResult = listGradeDescByPrefixResult;
    }


    /**
     * Gets the listGradeDescByPrefixResult value for this ListGradeDescByPrefixResponse.
     * 
     * @return listGradeDescByPrefixResult
     */
    public org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult getListGradeDescByPrefixResult() {
        return listGradeDescByPrefixResult;
    }


    /**
     * Sets the listGradeDescByPrefixResult value for this ListGradeDescByPrefixResponse.
     * 
     * @param listGradeDescByPrefixResult
     */
    public void setListGradeDescByPrefixResult(org.tempuri.ListGradeDescByPrefixResponseListGradeDescByPrefixResult listGradeDescByPrefixResult) {
        this.listGradeDescByPrefixResult = listGradeDescByPrefixResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListGradeDescByPrefixResponse)) return false;
        ListGradeDescByPrefixResponse other = (ListGradeDescByPrefixResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listGradeDescByPrefixResult==null && other.getListGradeDescByPrefixResult()==null) || 
             (this.listGradeDescByPrefixResult!=null &&
              this.listGradeDescByPrefixResult.equals(other.getListGradeDescByPrefixResult())));
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
        if (getListGradeDescByPrefixResult() != null) {
            _hashCode += getListGradeDescByPrefixResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListGradeDescByPrefixResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListGradeDescByPrefixResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listGradeDescByPrefixResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListGradeDescByPrefixResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListGradeDescByPrefixResponse>ListGradeDescByPrefixResult"));
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
