/**
 * GetEmployeeProfileByPrefixThaiNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixThaiNameResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getEmployeeProfileByPrefixThaiNameResult;

    public GetEmployeeProfileByPrefixThaiNameResponse() {
    }

    public GetEmployeeProfileByPrefixThaiNameResponse(
           org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getEmployeeProfileByPrefixThaiNameResult) {
           this.getEmployeeProfileByPrefixThaiNameResult = getEmployeeProfileByPrefixThaiNameResult;
    }


    /**
     * Gets the getEmployeeProfileByPrefixThaiNameResult value for this GetEmployeeProfileByPrefixThaiNameResponse.
     * 
     * @return getEmployeeProfileByPrefixThaiNameResult
     */
    public org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getGetEmployeeProfileByPrefixThaiNameResult() {
        return getEmployeeProfileByPrefixThaiNameResult;
    }


    /**
     * Sets the getEmployeeProfileByPrefixThaiNameResult value for this GetEmployeeProfileByPrefixThaiNameResponse.
     * 
     * @param getEmployeeProfileByPrefixThaiNameResult
     */
    public void setGetEmployeeProfileByPrefixThaiNameResult(org.tempuri.GetEmployeeProfileByPrefixThaiNameResponseGetEmployeeProfileByPrefixThaiNameResult getEmployeeProfileByPrefixThaiNameResult) {
        this.getEmployeeProfileByPrefixThaiNameResult = getEmployeeProfileByPrefixThaiNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixThaiNameResponse)) return false;
        GetEmployeeProfileByPrefixThaiNameResponse other = (GetEmployeeProfileByPrefixThaiNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeProfileByPrefixThaiNameResult==null && other.getGetEmployeeProfileByPrefixThaiNameResult()==null) || 
             (this.getEmployeeProfileByPrefixThaiNameResult!=null &&
              this.getEmployeeProfileByPrefixThaiNameResult.equals(other.getGetEmployeeProfileByPrefixThaiNameResult())));
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
        if (getGetEmployeeProfileByPrefixThaiNameResult() != null) {
            _hashCode += getGetEmployeeProfileByPrefixThaiNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixThaiNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixThaiNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeProfileByPrefixThaiNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixThaiNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixThaiNameResponse>GetEmployeeProfileByPrefixThaiNameResult"));
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
