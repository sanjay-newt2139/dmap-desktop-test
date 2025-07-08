/**
 * List_Log_OM_TransFormResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class List_Log_OM_TransFormResponse  implements java.io.Serializable {
    private org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult list_Log_OM_TransFormResult;

    public List_Log_OM_TransFormResponse() {
    }

    public List_Log_OM_TransFormResponse(
           org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult list_Log_OM_TransFormResult) {
           this.list_Log_OM_TransFormResult = list_Log_OM_TransFormResult;
    }


    /**
     * Gets the list_Log_OM_TransFormResult value for this List_Log_OM_TransFormResponse.
     * 
     * @return list_Log_OM_TransFormResult
     */
    public org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult getList_Log_OM_TransFormResult() {
        return list_Log_OM_TransFormResult;
    }


    /**
     * Sets the list_Log_OM_TransFormResult value for this List_Log_OM_TransFormResponse.
     * 
     * @param list_Log_OM_TransFormResult
     */
    public void setList_Log_OM_TransFormResult(org.tempuri.List_Log_OM_TransFormResponseList_Log_OM_TransFormResult list_Log_OM_TransFormResult) {
        this.list_Log_OM_TransFormResult = list_Log_OM_TransFormResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof List_Log_OM_TransFormResponse)) return false;
        List_Log_OM_TransFormResponse other = (List_Log_OM_TransFormResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.list_Log_OM_TransFormResult==null && other.getList_Log_OM_TransFormResult()==null) || 
             (this.list_Log_OM_TransFormResult!=null &&
              this.list_Log_OM_TransFormResult.equals(other.getList_Log_OM_TransFormResult())));
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
        if (getList_Log_OM_TransFormResult() != null) {
            _hashCode += getList_Log_OM_TransFormResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(List_Log_OM_TransFormResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">List_Log_OM_TransFormResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("list_Log_OM_TransFormResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "List_Log_OM_TransFormResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>List_Log_OM_TransFormResponse>List_Log_OM_TransFormResult"));
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
