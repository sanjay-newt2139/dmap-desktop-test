/**
 * ListAllApproverResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllApproverResponse  implements java.io.Serializable {
    private org.tempuri.ListAllApproverResponseListAllApproverResult listAllApproverResult;

    public ListAllApproverResponse() {
    }

    public ListAllApproverResponse(
           org.tempuri.ListAllApproverResponseListAllApproverResult listAllApproverResult) {
           this.listAllApproverResult = listAllApproverResult;
    }


    /**
     * Gets the listAllApproverResult value for this ListAllApproverResponse.
     * 
     * @return listAllApproverResult
     */
    public org.tempuri.ListAllApproverResponseListAllApproverResult getListAllApproverResult() {
        return listAllApproverResult;
    }


    /**
     * Sets the listAllApproverResult value for this ListAllApproverResponse.
     * 
     * @param listAllApproverResult
     */
    public void setListAllApproverResult(org.tempuri.ListAllApproverResponseListAllApproverResult listAllApproverResult) {
        this.listAllApproverResult = listAllApproverResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllApproverResponse)) return false;
        ListAllApproverResponse other = (ListAllApproverResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listAllApproverResult==null && other.getListAllApproverResult()==null) || 
             (this.listAllApproverResult!=null &&
              this.listAllApproverResult.equals(other.getListAllApproverResult())));
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
        if (getListAllApproverResult() != null) {
            _hashCode += getListAllApproverResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllApproverResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllApproverResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listAllApproverResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListAllApproverResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllApproverResponse>ListAllApproverResult"));
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
