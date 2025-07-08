/**
 * GetOrgPersInfoByOrgHRMPINResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetOrgPersInfoByOrgHRMPINResponse  implements java.io.Serializable {
    private org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getOrgPersInfoByOrgHRMPINResult;

    public GetOrgPersInfoByOrgHRMPINResponse() {
    }

    public GetOrgPersInfoByOrgHRMPINResponse(
           org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getOrgPersInfoByOrgHRMPINResult) {
           this.getOrgPersInfoByOrgHRMPINResult = getOrgPersInfoByOrgHRMPINResult;
    }


    /**
     * Gets the getOrgPersInfoByOrgHRMPINResult value for this GetOrgPersInfoByOrgHRMPINResponse.
     * 
     * @return getOrgPersInfoByOrgHRMPINResult
     */
    public org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getGetOrgPersInfoByOrgHRMPINResult() {
        return getOrgPersInfoByOrgHRMPINResult;
    }


    /**
     * Sets the getOrgPersInfoByOrgHRMPINResult value for this GetOrgPersInfoByOrgHRMPINResponse.
     * 
     * @param getOrgPersInfoByOrgHRMPINResult
     */
    public void setGetOrgPersInfoByOrgHRMPINResult(org.tempuri.GetOrgPersInfoByOrgHRMPINResponseGetOrgPersInfoByOrgHRMPINResult getOrgPersInfoByOrgHRMPINResult) {
        this.getOrgPersInfoByOrgHRMPINResult = getOrgPersInfoByOrgHRMPINResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOrgPersInfoByOrgHRMPINResponse)) return false;
        GetOrgPersInfoByOrgHRMPINResponse other = (GetOrgPersInfoByOrgHRMPINResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getOrgPersInfoByOrgHRMPINResult==null && other.getGetOrgPersInfoByOrgHRMPINResult()==null) || 
             (this.getOrgPersInfoByOrgHRMPINResult!=null &&
              this.getOrgPersInfoByOrgHRMPINResult.equals(other.getGetOrgPersInfoByOrgHRMPINResult())));
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
        if (getGetOrgPersInfoByOrgHRMPINResult() != null) {
            _hashCode += getGetOrgPersInfoByOrgHRMPINResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOrgPersInfoByOrgHRMPINResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgPersInfoByOrgHRMPINResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getOrgPersInfoByOrgHRMPINResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgPersInfoByOrgHRMPINResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgPersInfoByOrgHRMPINResponse>GetOrgPersInfoByOrgHRMPINResult"));
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
