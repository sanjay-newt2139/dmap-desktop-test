/**
 * ListAllPinsUnderOrgCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllPinsUnderOrgCodeResponse  implements java.io.Serializable {
    private org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult listAllPinsUnderOrgCodeResult;

    public ListAllPinsUnderOrgCodeResponse() {
    }

    public ListAllPinsUnderOrgCodeResponse(
           org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult listAllPinsUnderOrgCodeResult) {
           this.listAllPinsUnderOrgCodeResult = listAllPinsUnderOrgCodeResult;
    }


    /**
     * Gets the listAllPinsUnderOrgCodeResult value for this ListAllPinsUnderOrgCodeResponse.
     * 
     * @return listAllPinsUnderOrgCodeResult
     */
    public org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult getListAllPinsUnderOrgCodeResult() {
        return listAllPinsUnderOrgCodeResult;
    }


    /**
     * Sets the listAllPinsUnderOrgCodeResult value for this ListAllPinsUnderOrgCodeResponse.
     * 
     * @param listAllPinsUnderOrgCodeResult
     */
    public void setListAllPinsUnderOrgCodeResult(org.tempuri.ListAllPinsUnderOrgCodeResponseListAllPinsUnderOrgCodeResult listAllPinsUnderOrgCodeResult) {
        this.listAllPinsUnderOrgCodeResult = listAllPinsUnderOrgCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllPinsUnderOrgCodeResponse)) return false;
        ListAllPinsUnderOrgCodeResponse other = (ListAllPinsUnderOrgCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listAllPinsUnderOrgCodeResult==null && other.getListAllPinsUnderOrgCodeResult()==null) || 
             (this.listAllPinsUnderOrgCodeResult!=null &&
              this.listAllPinsUnderOrgCodeResult.equals(other.getListAllPinsUnderOrgCodeResult())));
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
        if (getListAllPinsUnderOrgCodeResult() != null) {
            _hashCode += getListAllPinsUnderOrgCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllPinsUnderOrgCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllPinsUnderOrgCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listAllPinsUnderOrgCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllPinsUnderOrgCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllPinsUnderOrgCodeResponse>ListAllPinsUnderOrgCodeResult"));
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
