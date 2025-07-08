/**
 * GetEmployeeProfileByPrefixPinResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixPinResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getEmployeeProfileByPrefixPinResult;

    public GetEmployeeProfileByPrefixPinResponse() {
    }

    public GetEmployeeProfileByPrefixPinResponse(
           org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getEmployeeProfileByPrefixPinResult) {
           this.getEmployeeProfileByPrefixPinResult = getEmployeeProfileByPrefixPinResult;
    }


    /**
     * Gets the getEmployeeProfileByPrefixPinResult value for this GetEmployeeProfileByPrefixPinResponse.
     * 
     * @return getEmployeeProfileByPrefixPinResult
     */
    public org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getGetEmployeeProfileByPrefixPinResult() {
        return getEmployeeProfileByPrefixPinResult;
    }


    /**
     * Sets the getEmployeeProfileByPrefixPinResult value for this GetEmployeeProfileByPrefixPinResponse.
     * 
     * @param getEmployeeProfileByPrefixPinResult
     */
    public void setGetEmployeeProfileByPrefixPinResult(org.tempuri.GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult getEmployeeProfileByPrefixPinResult) {
        this.getEmployeeProfileByPrefixPinResult = getEmployeeProfileByPrefixPinResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixPinResponse)) return false;
        GetEmployeeProfileByPrefixPinResponse other = (GetEmployeeProfileByPrefixPinResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeProfileByPrefixPinResult==null && other.getGetEmployeeProfileByPrefixPinResult()==null) || 
             (this.getEmployeeProfileByPrefixPinResult!=null &&
              this.getEmployeeProfileByPrefixPinResult.equals(other.getGetEmployeeProfileByPrefixPinResult())));
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
        if (getGetEmployeeProfileByPrefixPinResult() != null) {
            _hashCode += getGetEmployeeProfileByPrefixPinResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixPinResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixPinResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeProfileByPrefixPinResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixPinResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixPinResponse>GetEmployeeProfileByPrefixPinResult"));
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
