/**
 * GetCompanyByOrgCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetCompanyByOrgCodeResponse  implements java.io.Serializable {
    private org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getCompanyByOrgCodeResult;

    public GetCompanyByOrgCodeResponse() {
    }

    public GetCompanyByOrgCodeResponse(
           org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getCompanyByOrgCodeResult) {
           this.getCompanyByOrgCodeResult = getCompanyByOrgCodeResult;
    }


    /**
     * Gets the getCompanyByOrgCodeResult value for this GetCompanyByOrgCodeResponse.
     * 
     * @return getCompanyByOrgCodeResult
     */
    public org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getGetCompanyByOrgCodeResult() {
        return getCompanyByOrgCodeResult;
    }


    /**
     * Sets the getCompanyByOrgCodeResult value for this GetCompanyByOrgCodeResponse.
     * 
     * @param getCompanyByOrgCodeResult
     */
    public void setGetCompanyByOrgCodeResult(org.tempuri.GetCompanyByOrgCodeResponseGetCompanyByOrgCodeResult getCompanyByOrgCodeResult) {
        this.getCompanyByOrgCodeResult = getCompanyByOrgCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCompanyByOrgCodeResponse)) return false;
        GetCompanyByOrgCodeResponse other = (GetCompanyByOrgCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCompanyByOrgCodeResult==null && other.getGetCompanyByOrgCodeResult()==null) || 
             (this.getCompanyByOrgCodeResult!=null &&
              this.getCompanyByOrgCodeResult.equals(other.getGetCompanyByOrgCodeResult())));
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
        if (getGetCompanyByOrgCodeResult() != null) {
            _hashCode += getGetCompanyByOrgCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCompanyByOrgCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetCompanyByOrgCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCompanyByOrgCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetCompanyByOrgCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetCompanyByOrgCodeResponse>GetCompanyByOrgCodeResult"));
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
