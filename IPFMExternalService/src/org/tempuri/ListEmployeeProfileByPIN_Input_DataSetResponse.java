/**
 * ListEmployeeProfileByPIN_Input_DataSetResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListEmployeeProfileByPIN_Input_DataSetResponse  implements java.io.Serializable {
    private org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult listEmployeeProfileByPIN_Input_DataSetResult;

    public ListEmployeeProfileByPIN_Input_DataSetResponse() {
    }

    public ListEmployeeProfileByPIN_Input_DataSetResponse(
           org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult listEmployeeProfileByPIN_Input_DataSetResult) {
           this.listEmployeeProfileByPIN_Input_DataSetResult = listEmployeeProfileByPIN_Input_DataSetResult;
    }


    /**
     * Gets the listEmployeeProfileByPIN_Input_DataSetResult value for this ListEmployeeProfileByPIN_Input_DataSetResponse.
     * 
     * @return listEmployeeProfileByPIN_Input_DataSetResult
     */
    public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult getListEmployeeProfileByPIN_Input_DataSetResult() {
        return listEmployeeProfileByPIN_Input_DataSetResult;
    }


    /**
     * Sets the listEmployeeProfileByPIN_Input_DataSetResult value for this ListEmployeeProfileByPIN_Input_DataSetResponse.
     * 
     * @param listEmployeeProfileByPIN_Input_DataSetResult
     */
    public void setListEmployeeProfileByPIN_Input_DataSetResult(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetResponseListEmployeeProfileByPIN_Input_DataSetResult listEmployeeProfileByPIN_Input_DataSetResult) {
        this.listEmployeeProfileByPIN_Input_DataSetResult = listEmployeeProfileByPIN_Input_DataSetResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEmployeeProfileByPIN_Input_DataSetResponse)) return false;
        ListEmployeeProfileByPIN_Input_DataSetResponse other = (ListEmployeeProfileByPIN_Input_DataSetResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listEmployeeProfileByPIN_Input_DataSetResult==null && other.getListEmployeeProfileByPIN_Input_DataSetResult()==null) || 
             (this.listEmployeeProfileByPIN_Input_DataSetResult!=null &&
              this.listEmployeeProfileByPIN_Input_DataSetResult.equals(other.getListEmployeeProfileByPIN_Input_DataSetResult())));
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
        if (getListEmployeeProfileByPIN_Input_DataSetResult() != null) {
            _hashCode += getListEmployeeProfileByPIN_Input_DataSetResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListEmployeeProfileByPIN_Input_DataSetResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_Input_DataSetResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEmployeeProfileByPIN_Input_DataSetResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPIN_Input_DataSetResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetResponse>ListEmployeeProfileByPIN_Input_DataSetResult"));
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
