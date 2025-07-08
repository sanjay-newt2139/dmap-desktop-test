/**
 * GetApproverResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetApproverResponse  implements java.io.Serializable {
    private org.tempuri.GetApproverResponseGetApproverResult getApproverResult;

    public GetApproverResponse() {
    }

    public GetApproverResponse(
           org.tempuri.GetApproverResponseGetApproverResult getApproverResult) {
           this.getApproverResult = getApproverResult;
    }


    /**
     * Gets the getApproverResult value for this GetApproverResponse.
     * 
     * @return getApproverResult
     */
    public org.tempuri.GetApproverResponseGetApproverResult getGetApproverResult() {
        return getApproverResult;
    }


    /**
     * Sets the getApproverResult value for this GetApproverResponse.
     * 
     * @param getApproverResult
     */
    public void setGetApproverResult(org.tempuri.GetApproverResponseGetApproverResult getApproverResult) {
        this.getApproverResult = getApproverResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetApproverResponse)) return false;
        GetApproverResponse other = (GetApproverResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getApproverResult==null && other.getGetApproverResult()==null) || 
             (this.getApproverResult!=null &&
              this.getApproverResult.equals(other.getGetApproverResult())));
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
        if (getGetApproverResult() != null) {
            _hashCode += getGetApproverResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetApproverResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetApproverResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getApproverResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetApproverResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetApproverResponse>GetApproverResult"));
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
