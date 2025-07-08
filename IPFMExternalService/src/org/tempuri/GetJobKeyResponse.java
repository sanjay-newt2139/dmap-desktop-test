/**
 * GetJobKeyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetJobKeyResponse  implements java.io.Serializable {
    private org.tempuri.GetJobKeyResponseGetJobKeyResult getJobKeyResult;

    public GetJobKeyResponse() {
    }

    public GetJobKeyResponse(
           org.tempuri.GetJobKeyResponseGetJobKeyResult getJobKeyResult) {
           this.getJobKeyResult = getJobKeyResult;
    }


    /**
     * Gets the getJobKeyResult value for this GetJobKeyResponse.
     * 
     * @return getJobKeyResult
     */
    public org.tempuri.GetJobKeyResponseGetJobKeyResult getGetJobKeyResult() {
        return getJobKeyResult;
    }


    /**
     * Sets the getJobKeyResult value for this GetJobKeyResponse.
     * 
     * @param getJobKeyResult
     */
    public void setGetJobKeyResult(org.tempuri.GetJobKeyResponseGetJobKeyResult getJobKeyResult) {
        this.getJobKeyResult = getJobKeyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetJobKeyResponse)) return false;
        GetJobKeyResponse other = (GetJobKeyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getJobKeyResult==null && other.getGetJobKeyResult()==null) || 
             (this.getJobKeyResult!=null &&
              this.getJobKeyResult.equals(other.getGetJobKeyResult())));
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
        if (getGetJobKeyResult() != null) {
            _hashCode += getGetJobKeyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetJobKeyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetJobKeyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getJobKeyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetJobKeyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetJobKeyResponse>GetJobKeyResult"));
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
