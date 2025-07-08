/**
 * GetStaffCountbyOrgCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetStaffCountbyOrgCodeResponse  implements java.io.Serializable {
    private org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getStaffCountbyOrgCodeResult;

    public GetStaffCountbyOrgCodeResponse() {
    }

    public GetStaffCountbyOrgCodeResponse(
           org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getStaffCountbyOrgCodeResult) {
           this.getStaffCountbyOrgCodeResult = getStaffCountbyOrgCodeResult;
    }


    /**
     * Gets the getStaffCountbyOrgCodeResult value for this GetStaffCountbyOrgCodeResponse.
     * 
     * @return getStaffCountbyOrgCodeResult
     */
    public org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getGetStaffCountbyOrgCodeResult() {
        return getStaffCountbyOrgCodeResult;
    }


    /**
     * Sets the getStaffCountbyOrgCodeResult value for this GetStaffCountbyOrgCodeResponse.
     * 
     * @param getStaffCountbyOrgCodeResult
     */
    public void setGetStaffCountbyOrgCodeResult(org.tempuri.GetStaffCountbyOrgCodeResponseGetStaffCountbyOrgCodeResult getStaffCountbyOrgCodeResult) {
        this.getStaffCountbyOrgCodeResult = getStaffCountbyOrgCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStaffCountbyOrgCodeResponse)) return false;
        GetStaffCountbyOrgCodeResponse other = (GetStaffCountbyOrgCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getStaffCountbyOrgCodeResult==null && other.getGetStaffCountbyOrgCodeResult()==null) || 
             (this.getStaffCountbyOrgCodeResult!=null &&
              this.getStaffCountbyOrgCodeResult.equals(other.getGetStaffCountbyOrgCodeResult())));
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
        if (getGetStaffCountbyOrgCodeResult() != null) {
            _hashCode += getGetStaffCountbyOrgCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStaffCountbyOrgCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetStaffCountbyOrgCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getStaffCountbyOrgCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetStaffCountbyOrgCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetStaffCountbyOrgCodeResponse>GetStaffCountbyOrgCodeResult"));
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
