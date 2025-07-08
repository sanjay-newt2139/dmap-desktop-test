/**
 * ListEmployeeProfileByPINResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListEmployeeProfileByPINResponse  implements java.io.Serializable {
    private org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult listEmployeeProfileByPINResult;

    public ListEmployeeProfileByPINResponse() {
    }

    public ListEmployeeProfileByPINResponse(
           org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult listEmployeeProfileByPINResult) {
           this.listEmployeeProfileByPINResult = listEmployeeProfileByPINResult;
    }


    /**
     * Gets the listEmployeeProfileByPINResult value for this ListEmployeeProfileByPINResponse.
     * 
     * @return listEmployeeProfileByPINResult
     */
    public org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult getListEmployeeProfileByPINResult() {
        return listEmployeeProfileByPINResult;
    }


    /**
     * Sets the listEmployeeProfileByPINResult value for this ListEmployeeProfileByPINResponse.
     * 
     * @param listEmployeeProfileByPINResult
     */
    public void setListEmployeeProfileByPINResult(org.tempuri.ListEmployeeProfileByPINResponseListEmployeeProfileByPINResult listEmployeeProfileByPINResult) {
        this.listEmployeeProfileByPINResult = listEmployeeProfileByPINResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEmployeeProfileByPINResponse)) return false;
        ListEmployeeProfileByPINResponse other = (ListEmployeeProfileByPINResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listEmployeeProfileByPINResult==null && other.getListEmployeeProfileByPINResult()==null) || 
             (this.listEmployeeProfileByPINResult!=null &&
              this.listEmployeeProfileByPINResult.equals(other.getListEmployeeProfileByPINResult())));
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
        if (getListEmployeeProfileByPINResult() != null) {
            _hashCode += getListEmployeeProfileByPINResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListEmployeeProfileByPINResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPINResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEmployeeProfileByPINResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployeeProfileByPINResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPINResponse>ListEmployeeProfileByPINResult"));
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
