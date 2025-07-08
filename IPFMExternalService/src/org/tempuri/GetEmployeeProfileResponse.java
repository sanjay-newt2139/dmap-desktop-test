/**
 * GetEmployeeProfileResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getEmployeeProfileResult;

    public GetEmployeeProfileResponse() {
    }

    public GetEmployeeProfileResponse(
           org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getEmployeeProfileResult) {
           this.getEmployeeProfileResult = getEmployeeProfileResult;
    }


    /**
     * Gets the getEmployeeProfileResult value for this GetEmployeeProfileResponse.
     * 
     * @return getEmployeeProfileResult
     */
    public org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getGetEmployeeProfileResult() {
        return getEmployeeProfileResult;
    }


    /**
     * Sets the getEmployeeProfileResult value for this GetEmployeeProfileResponse.
     * 
     * @param getEmployeeProfileResult
     */
    public void setGetEmployeeProfileResult(org.tempuri.GetEmployeeProfileResponseGetEmployeeProfileResult getEmployeeProfileResult) {
        this.getEmployeeProfileResult = getEmployeeProfileResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileResponse)) return false;
        GetEmployeeProfileResponse other = (GetEmployeeProfileResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeProfileResult==null && other.getGetEmployeeProfileResult()==null) || 
             (this.getEmployeeProfileResult!=null &&
              this.getEmployeeProfileResult.equals(other.getGetEmployeeProfileResult())));
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
        if (getGetEmployeeProfileResult() != null) {
            _hashCode += getGetEmployeeProfileResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeProfileResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileResponse>GetEmployeeProfileResult"));
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
