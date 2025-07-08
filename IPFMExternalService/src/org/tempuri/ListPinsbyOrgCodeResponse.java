/**
 * ListPinsbyOrgCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListPinsbyOrgCodeResponse  implements java.io.Serializable {
    private org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult listPinsbyOrgCodeResult;

    public ListPinsbyOrgCodeResponse() {
    }

    public ListPinsbyOrgCodeResponse(
           org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult listPinsbyOrgCodeResult) {
           this.listPinsbyOrgCodeResult = listPinsbyOrgCodeResult;
    }


    /**
     * Gets the listPinsbyOrgCodeResult value for this ListPinsbyOrgCodeResponse.
     * 
     * @return listPinsbyOrgCodeResult
     */
    public org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult getListPinsbyOrgCodeResult() {
        return listPinsbyOrgCodeResult;
    }


    /**
     * Sets the listPinsbyOrgCodeResult value for this ListPinsbyOrgCodeResponse.
     * 
     * @param listPinsbyOrgCodeResult
     */
    public void setListPinsbyOrgCodeResult(org.tempuri.ListPinsbyOrgCodeResponseListPinsbyOrgCodeResult listPinsbyOrgCodeResult) {
        this.listPinsbyOrgCodeResult = listPinsbyOrgCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListPinsbyOrgCodeResponse)) return false;
        ListPinsbyOrgCodeResponse other = (ListPinsbyOrgCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listPinsbyOrgCodeResult==null && other.getListPinsbyOrgCodeResult()==null) || 
             (this.listPinsbyOrgCodeResult!=null &&
              this.listPinsbyOrgCodeResult.equals(other.getListPinsbyOrgCodeResult())));
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
        if (getListPinsbyOrgCodeResult() != null) {
            _hashCode += getListPinsbyOrgCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListPinsbyOrgCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListPinsbyOrgCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listPinsbyOrgCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListPinsbyOrgCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListPinsbyOrgCodeResponse>ListPinsbyOrgCodeResult"));
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
