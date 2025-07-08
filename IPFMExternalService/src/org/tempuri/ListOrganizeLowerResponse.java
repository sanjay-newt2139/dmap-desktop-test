/**
 * ListOrganizeLowerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListOrganizeLowerResponse  implements java.io.Serializable {
    private org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult listOrganizeLowerResult;

    public ListOrganizeLowerResponse() {
    }

    public ListOrganizeLowerResponse(
           org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult listOrganizeLowerResult) {
           this.listOrganizeLowerResult = listOrganizeLowerResult;
    }


    /**
     * Gets the listOrganizeLowerResult value for this ListOrganizeLowerResponse.
     * 
     * @return listOrganizeLowerResult
     */
    public org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult getListOrganizeLowerResult() {
        return listOrganizeLowerResult;
    }


    /**
     * Sets the listOrganizeLowerResult value for this ListOrganizeLowerResponse.
     * 
     * @param listOrganizeLowerResult
     */
    public void setListOrganizeLowerResult(org.tempuri.ListOrganizeLowerResponseListOrganizeLowerResult listOrganizeLowerResult) {
        this.listOrganizeLowerResult = listOrganizeLowerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListOrganizeLowerResponse)) return false;
        ListOrganizeLowerResponse other = (ListOrganizeLowerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listOrganizeLowerResult==null && other.getListOrganizeLowerResult()==null) || 
             (this.listOrganizeLowerResult!=null &&
              this.listOrganizeLowerResult.equals(other.getListOrganizeLowerResult())));
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
        if (getListOrganizeLowerResult() != null) {
            _hashCode += getListOrganizeLowerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListOrganizeLowerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">listOrganizeLowerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOrganizeLowerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "listOrganizeLowerResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>listOrganizeLowerResponse>listOrganizeLowerResult"));
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
