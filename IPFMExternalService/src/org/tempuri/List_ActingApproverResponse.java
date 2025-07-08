/**
 * List_ActingApproverResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class List_ActingApproverResponse  implements java.io.Serializable {
    private org.tempuri.List_ActingApproverResponseList_ActingApproverResult list_ActingApproverResult;

    public List_ActingApproverResponse() {
    }

    public List_ActingApproverResponse(
           org.tempuri.List_ActingApproverResponseList_ActingApproverResult list_ActingApproverResult) {
           this.list_ActingApproverResult = list_ActingApproverResult;
    }


    /**
     * Gets the list_ActingApproverResult value for this List_ActingApproverResponse.
     * 
     * @return list_ActingApproverResult
     */
    public org.tempuri.List_ActingApproverResponseList_ActingApproverResult getList_ActingApproverResult() {
        return list_ActingApproverResult;
    }


    /**
     * Sets the list_ActingApproverResult value for this List_ActingApproverResponse.
     * 
     * @param list_ActingApproverResult
     */
    public void setList_ActingApproverResult(org.tempuri.List_ActingApproverResponseList_ActingApproverResult list_ActingApproverResult) {
        this.list_ActingApproverResult = list_ActingApproverResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof List_ActingApproverResponse)) return false;
        List_ActingApproverResponse other = (List_ActingApproverResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.list_ActingApproverResult==null && other.getList_ActingApproverResult()==null) || 
             (this.list_ActingApproverResult!=null &&
              this.list_ActingApproverResult.equals(other.getList_ActingApproverResult())));
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
        if (getList_ActingApproverResult() != null) {
            _hashCode += getList_ActingApproverResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(List_ActingApproverResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">List_ActingApproverResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list_ActingApproverResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "List_ActingApproverResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_ActingApproverResponse>List_ActingApproverResult"));
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
