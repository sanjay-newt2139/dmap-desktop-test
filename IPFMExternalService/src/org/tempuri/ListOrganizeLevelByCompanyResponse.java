/**
 * ListOrganizeLevelByCompanyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListOrganizeLevelByCompanyResponse  implements java.io.Serializable {
    private org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult listOrganizeLevelByCompanyResult;

    public ListOrganizeLevelByCompanyResponse() {
    }

    public ListOrganizeLevelByCompanyResponse(
           org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult listOrganizeLevelByCompanyResult) {
           this.listOrganizeLevelByCompanyResult = listOrganizeLevelByCompanyResult;
    }


    /**
     * Gets the listOrganizeLevelByCompanyResult value for this ListOrganizeLevelByCompanyResponse.
     * 
     * @return listOrganizeLevelByCompanyResult
     */
    public org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult getListOrganizeLevelByCompanyResult() {
        return listOrganizeLevelByCompanyResult;
    }


    /**
     * Sets the listOrganizeLevelByCompanyResult value for this ListOrganizeLevelByCompanyResponse.
     * 
     * @param listOrganizeLevelByCompanyResult
     */
    public void setListOrganizeLevelByCompanyResult(org.tempuri.ListOrganizeLevelByCompanyResponseListOrganizeLevelByCompanyResult listOrganizeLevelByCompanyResult) {
        this.listOrganizeLevelByCompanyResult = listOrganizeLevelByCompanyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListOrganizeLevelByCompanyResponse)) return false;
        ListOrganizeLevelByCompanyResponse other = (ListOrganizeLevelByCompanyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listOrganizeLevelByCompanyResult==null && other.getListOrganizeLevelByCompanyResult()==null) || 
             (this.listOrganizeLevelByCompanyResult!=null &&
              this.listOrganizeLevelByCompanyResult.equals(other.getListOrganizeLevelByCompanyResult())));
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
        if (getListOrganizeLevelByCompanyResult() != null) {
            _hashCode += getListOrganizeLevelByCompanyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListOrganizeLevelByCompanyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListOrganizeLevelByCompanyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOrganizeLevelByCompanyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListOrganizeLevelByCompanyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListOrganizeLevelByCompanyResponse>ListOrganizeLevelByCompanyResult"));
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
