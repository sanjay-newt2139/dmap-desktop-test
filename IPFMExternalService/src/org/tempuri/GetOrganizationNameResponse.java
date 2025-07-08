/**
 * GetOrganizationNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetOrganizationNameResponse  implements java.io.Serializable {
    private org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getOrganizationNameResult;

    public GetOrganizationNameResponse() {
    }

    public GetOrganizationNameResponse(
           org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getOrganizationNameResult) {
           this.getOrganizationNameResult = getOrganizationNameResult;
    }


    /**
     * Gets the getOrganizationNameResult value for this GetOrganizationNameResponse.
     * 
     * @return getOrganizationNameResult
     */
    public org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getGetOrganizationNameResult() {
        return getOrganizationNameResult;
    }


    /**
     * Sets the getOrganizationNameResult value for this GetOrganizationNameResponse.
     * 
     * @param getOrganizationNameResult
     */
    public void setGetOrganizationNameResult(org.tempuri.GetOrganizationNameResponseGetOrganizationNameResult getOrganizationNameResult) {
        this.getOrganizationNameResult = getOrganizationNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOrganizationNameResponse)) return false;
        GetOrganizationNameResponse other = (GetOrganizationNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getOrganizationNameResult==null && other.getGetOrganizationNameResult()==null) || 
             (this.getOrganizationNameResult!=null &&
              this.getOrganizationNameResult.equals(other.getGetOrganizationNameResult())));
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
        if (getGetOrganizationNameResult() != null) {
            _hashCode += getGetOrganizationNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOrganizationNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganizationNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getOrganizationNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrganizationNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrganizationNameResponse>GetOrganizationNameResult"));
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
