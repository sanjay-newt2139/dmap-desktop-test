/**
 * ListEmployee_By_CompanyCode_Name_PINResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListEmployee_By_CompanyCode_Name_PINResponse  implements java.io.Serializable {
    private org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult listEmployee_By_CompanyCode_Name_PINResult;

    public ListEmployee_By_CompanyCode_Name_PINResponse() {
    }

    public ListEmployee_By_CompanyCode_Name_PINResponse(
           org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult listEmployee_By_CompanyCode_Name_PINResult) {
           this.listEmployee_By_CompanyCode_Name_PINResult = listEmployee_By_CompanyCode_Name_PINResult;
    }


    /**
     * Gets the listEmployee_By_CompanyCode_Name_PINResult value for this ListEmployee_By_CompanyCode_Name_PINResponse.
     * 
     * @return listEmployee_By_CompanyCode_Name_PINResult
     */
    public org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult getListEmployee_By_CompanyCode_Name_PINResult() {
        return listEmployee_By_CompanyCode_Name_PINResult;
    }


    /**
     * Sets the listEmployee_By_CompanyCode_Name_PINResult value for this ListEmployee_By_CompanyCode_Name_PINResponse.
     * 
     * @param listEmployee_By_CompanyCode_Name_PINResult
     */
    public void setListEmployee_By_CompanyCode_Name_PINResult(org.tempuri.ListEmployee_By_CompanyCode_Name_PINResponseListEmployee_By_CompanyCode_Name_PINResult listEmployee_By_CompanyCode_Name_PINResult) {
        this.listEmployee_By_CompanyCode_Name_PINResult = listEmployee_By_CompanyCode_Name_PINResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEmployee_By_CompanyCode_Name_PINResponse)) return false;
        ListEmployee_By_CompanyCode_Name_PINResponse other = (ListEmployee_By_CompanyCode_Name_PINResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listEmployee_By_CompanyCode_Name_PINResult==null && other.getListEmployee_By_CompanyCode_Name_PINResult()==null) || 
             (this.listEmployee_By_CompanyCode_Name_PINResult!=null &&
              this.listEmployee_By_CompanyCode_Name_PINResult.equals(other.getListEmployee_By_CompanyCode_Name_PINResult())));
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
        if (getListEmployee_By_CompanyCode_Name_PINResult() != null) {
            _hashCode += getListEmployee_By_CompanyCode_Name_PINResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListEmployee_By_CompanyCode_Name_PINResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployee_By_CompanyCode_Name_PINResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listEmployee_By_CompanyCode_Name_PINResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ListEmployee_By_CompanyCode_Name_PINResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployee_By_CompanyCode_Name_PINResponse>ListEmployee_By_CompanyCode_Name_PINResult"));
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
