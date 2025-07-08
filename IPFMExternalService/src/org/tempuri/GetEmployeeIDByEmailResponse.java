/**
 * GetEmployeeIDByEmailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeIDByEmailResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getEmployeeIDByEmailResult;

    public GetEmployeeIDByEmailResponse() {
    }

    public GetEmployeeIDByEmailResponse(
           org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getEmployeeIDByEmailResult) {
           this.getEmployeeIDByEmailResult = getEmployeeIDByEmailResult;
    }


    /**
     * Gets the getEmployeeIDByEmailResult value for this GetEmployeeIDByEmailResponse.
     * 
     * @return getEmployeeIDByEmailResult
     */
    public org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getGetEmployeeIDByEmailResult() {
        return getEmployeeIDByEmailResult;
    }


    /**
     * Sets the getEmployeeIDByEmailResult value for this GetEmployeeIDByEmailResponse.
     * 
     * @param getEmployeeIDByEmailResult
     */
    public void setGetEmployeeIDByEmailResult(org.tempuri.GetEmployeeIDByEmailResponseGetEmployeeIDByEmailResult getEmployeeIDByEmailResult) {
        this.getEmployeeIDByEmailResult = getEmployeeIDByEmailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeIDByEmailResponse)) return false;
        GetEmployeeIDByEmailResponse other = (GetEmployeeIDByEmailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeIDByEmailResult==null && other.getGetEmployeeIDByEmailResult()==null) || 
             (this.getEmployeeIDByEmailResult!=null &&
              this.getEmployeeIDByEmailResult.equals(other.getGetEmployeeIDByEmailResult())));
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
        if (getGetEmployeeIDByEmailResult() != null) {
            _hashCode += getGetEmployeeIDByEmailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeIDByEmailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeIDByEmailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeIDByEmailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeIDByEmailResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeIDByEmailResponse>GetEmployeeIDByEmailResult"));
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
