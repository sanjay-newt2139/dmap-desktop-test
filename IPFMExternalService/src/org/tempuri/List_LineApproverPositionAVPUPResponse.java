/**
 * List_LineApproverPositionAVPUPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class List_LineApproverPositionAVPUPResponse  implements java.io.Serializable {
    private org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult list_LineApproverPositionAVPUPResult;

    public List_LineApproverPositionAVPUPResponse() {
    }

    public List_LineApproverPositionAVPUPResponse(
           org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult list_LineApproverPositionAVPUPResult) {
           this.list_LineApproverPositionAVPUPResult = list_LineApproverPositionAVPUPResult;
    }


    /**
     * Gets the list_LineApproverPositionAVPUPResult value for this List_LineApproverPositionAVPUPResponse.
     * 
     * @return list_LineApproverPositionAVPUPResult
     */
    public org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult getList_LineApproverPositionAVPUPResult() {
        return list_LineApproverPositionAVPUPResult;
    }


    /**
     * Sets the list_LineApproverPositionAVPUPResult value for this List_LineApproverPositionAVPUPResponse.
     * 
     * @param list_LineApproverPositionAVPUPResult
     */
    public void setList_LineApproverPositionAVPUPResult(org.tempuri.List_LineApproverPositionAVPUPResponseList_LineApproverPositionAVPUPResult list_LineApproverPositionAVPUPResult) {
        this.list_LineApproverPositionAVPUPResult = list_LineApproverPositionAVPUPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof List_LineApproverPositionAVPUPResponse)) return false;
        List_LineApproverPositionAVPUPResponse other = (List_LineApproverPositionAVPUPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.list_LineApproverPositionAVPUPResult==null && other.getList_LineApproverPositionAVPUPResult()==null) || 
             (this.list_LineApproverPositionAVPUPResult!=null &&
              this.list_LineApproverPositionAVPUPResult.equals(other.getList_LineApproverPositionAVPUPResult())));
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
        if (getList_LineApproverPositionAVPUPResult() != null) {
            _hashCode += getList_LineApproverPositionAVPUPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(List_LineApproverPositionAVPUPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">List_LineApproverPositionAVPUPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list_LineApproverPositionAVPUPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "List_LineApproverPositionAVPUPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_LineApproverPositionAVPUPResponse>List_LineApproverPositionAVPUPResult"));
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
