/**
 * List_LogK2_ChangeApprover_DetailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class List_LogK2_ChangeApprover_DetailResponse  implements java.io.Serializable {
    private org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult list_LogK2_ChangeApprover_DetailResult;

    public List_LogK2_ChangeApprover_DetailResponse() {
    }

    public List_LogK2_ChangeApprover_DetailResponse(
           org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult list_LogK2_ChangeApprover_DetailResult) {
           this.list_LogK2_ChangeApprover_DetailResult = list_LogK2_ChangeApprover_DetailResult;
    }


    /**
     * Gets the list_LogK2_ChangeApprover_DetailResult value for this List_LogK2_ChangeApprover_DetailResponse.
     * 
     * @return list_LogK2_ChangeApprover_DetailResult
     */
    public org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult getList_LogK2_ChangeApprover_DetailResult() {
        return list_LogK2_ChangeApprover_DetailResult;
    }


    /**
     * Sets the list_LogK2_ChangeApprover_DetailResult value for this List_LogK2_ChangeApprover_DetailResponse.
     * 
     * @param list_LogK2_ChangeApprover_DetailResult
     */
    public void setList_LogK2_ChangeApprover_DetailResult(org.tempuri.List_LogK2_ChangeApprover_DetailResponseList_LogK2_ChangeApprover_DetailResult list_LogK2_ChangeApprover_DetailResult) {
        this.list_LogK2_ChangeApprover_DetailResult = list_LogK2_ChangeApprover_DetailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof List_LogK2_ChangeApprover_DetailResponse)) return false;
        List_LogK2_ChangeApprover_DetailResponse other = (List_LogK2_ChangeApprover_DetailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.list_LogK2_ChangeApprover_DetailResult==null && other.getList_LogK2_ChangeApprover_DetailResult()==null) || 
             (this.list_LogK2_ChangeApprover_DetailResult!=null &&
              this.list_LogK2_ChangeApprover_DetailResult.equals(other.getList_LogK2_ChangeApprover_DetailResult())));
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
        if (getList_LogK2_ChangeApprover_DetailResult() != null) {
            _hashCode += getList_LogK2_ChangeApprover_DetailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(List_LogK2_ChangeApprover_DetailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">List_LogK2_ChangeApprover_DetailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list_LogK2_ChangeApprover_DetailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "List_LogK2_ChangeApprover_DetailResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_LogK2_ChangeApprover_DetailResponse>List_LogK2_ChangeApprover_DetailResult"));
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
