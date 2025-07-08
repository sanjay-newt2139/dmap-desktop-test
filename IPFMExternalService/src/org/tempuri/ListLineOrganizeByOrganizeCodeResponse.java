/**
 * ListLineOrganizeByOrganizeCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListLineOrganizeByOrganizeCodeResponse  implements java.io.Serializable {
    private org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult listLineOrganizeByOrganizeCodeResult;

    public ListLineOrganizeByOrganizeCodeResponse() {
    }

    public ListLineOrganizeByOrganizeCodeResponse(
           org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult listLineOrganizeByOrganizeCodeResult) {
           this.listLineOrganizeByOrganizeCodeResult = listLineOrganizeByOrganizeCodeResult;
    }


    /**
     * Gets the listLineOrganizeByOrganizeCodeResult value for this ListLineOrganizeByOrganizeCodeResponse.
     * 
     * @return listLineOrganizeByOrganizeCodeResult
     */
    public org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult getListLineOrganizeByOrganizeCodeResult() {
        return listLineOrganizeByOrganizeCodeResult;
    }


    /**
     * Sets the listLineOrganizeByOrganizeCodeResult value for this ListLineOrganizeByOrganizeCodeResponse.
     * 
     * @param listLineOrganizeByOrganizeCodeResult
     */
    public void setListLineOrganizeByOrganizeCodeResult(org.tempuri.ListLineOrganizeByOrganizeCodeResponseListLineOrganizeByOrganizeCodeResult listLineOrganizeByOrganizeCodeResult) {
        this.listLineOrganizeByOrganizeCodeResult = listLineOrganizeByOrganizeCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListLineOrganizeByOrganizeCodeResponse)) return false;
        ListLineOrganizeByOrganizeCodeResponse other = (ListLineOrganizeByOrganizeCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listLineOrganizeByOrganizeCodeResult==null && other.getListLineOrganizeByOrganizeCodeResult()==null) || 
             (this.listLineOrganizeByOrganizeCodeResult!=null &&
              this.listLineOrganizeByOrganizeCodeResult.equals(other.getListLineOrganizeByOrganizeCodeResult())));
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
        if (getListLineOrganizeByOrganizeCodeResult() != null) {
            _hashCode += getListLineOrganizeByOrganizeCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListLineOrganizeByOrganizeCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListLineOrganizeByOrganizeCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listLineOrganizeByOrganizeCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListLineOrganizeByOrganizeCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListLineOrganizeByOrganizeCodeResponse>ListLineOrganizeByOrganizeCodeResult"));
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
