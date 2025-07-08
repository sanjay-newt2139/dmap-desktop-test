/**
 * GetOrganizationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetOrganizationResponse  implements java.io.Serializable {
    private org.tempuri.GetOrganizationResponseGetOrganizationResult getOrganizationResult;

    public GetOrganizationResponse() {
    }

    public GetOrganizationResponse(
           org.tempuri.GetOrganizationResponseGetOrganizationResult getOrganizationResult) {
           this.getOrganizationResult = getOrganizationResult;
    }


    /**
     * Gets the getOrganizationResult value for this GetOrganizationResponse.
     * 
     * @return getOrganizationResult
     */
    public org.tempuri.GetOrganizationResponseGetOrganizationResult getGetOrganizationResult() {
        return getOrganizationResult;
    }


    /**
     * Sets the getOrganizationResult value for this GetOrganizationResponse.
     * 
     * @param getOrganizationResult
     */
    public void setGetOrganizationResult(org.tempuri.GetOrganizationResponseGetOrganizationResult getOrganizationResult) {
        this.getOrganizationResult = getOrganizationResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOrganizationResponse)) return false;
        GetOrganizationResponse other = (GetOrganizationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getOrganizationResult==null && other.getGetOrganizationResult()==null) || 
             (this.getOrganizationResult!=null &&
              this.getOrganizationResult.equals(other.getGetOrganizationResult())));
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
        if (getGetOrganizationResult() != null) {
            _hashCode += getGetOrganizationResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOrganizationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganizationResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getOrganizationResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrganizationResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrganizationResponse>GetOrganizationResult"));
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
