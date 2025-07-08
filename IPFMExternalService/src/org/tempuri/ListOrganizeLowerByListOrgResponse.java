/**
 * ListOrganizeLowerByListOrgResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListOrganizeLowerByListOrgResponse  implements java.io.Serializable {
    private org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult listOrganizeLowerByListOrgResult;

    public ListOrganizeLowerByListOrgResponse() {
    }

    public ListOrganizeLowerByListOrgResponse(
           org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult listOrganizeLowerByListOrgResult) {
           this.listOrganizeLowerByListOrgResult = listOrganizeLowerByListOrgResult;
    }


    /**
     * Gets the listOrganizeLowerByListOrgResult value for this ListOrganizeLowerByListOrgResponse.
     * 
     * @return listOrganizeLowerByListOrgResult
     */
    public org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult getListOrganizeLowerByListOrgResult() {
        return listOrganizeLowerByListOrgResult;
    }


    /**
     * Sets the listOrganizeLowerByListOrgResult value for this ListOrganizeLowerByListOrgResponse.
     * 
     * @param listOrganizeLowerByListOrgResult
     */
    public void setListOrganizeLowerByListOrgResult(org.tempuri.ListOrganizeLowerByListOrgResponseListOrganizeLowerByListOrgResult listOrganizeLowerByListOrgResult) {
        this.listOrganizeLowerByListOrgResult = listOrganizeLowerByListOrgResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListOrganizeLowerByListOrgResponse)) return false;
        ListOrganizeLowerByListOrgResponse other = (ListOrganizeLowerByListOrgResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listOrganizeLowerByListOrgResult==null && other.getListOrganizeLowerByListOrgResult()==null) || 
             (this.listOrganizeLowerByListOrgResult!=null &&
              this.listOrganizeLowerByListOrgResult.equals(other.getListOrganizeLowerByListOrgResult())));
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
        if (getListOrganizeLowerByListOrgResult() != null) {
            _hashCode += getListOrganizeLowerByListOrgResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListOrganizeLowerByListOrgResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeLowerByListOrgResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOrganizeLowerByListOrgResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeLowerByListOrgResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLowerByListOrgResponse>ListOrganizeLowerByListOrgResult"));
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
