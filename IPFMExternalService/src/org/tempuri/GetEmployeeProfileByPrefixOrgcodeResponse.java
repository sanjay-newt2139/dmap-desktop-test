/**
 * GetEmployeeProfileByPrefixOrgcodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixOrgcodeResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getEmployeeProfileByPrefixOrgcodeResult;

    public GetEmployeeProfileByPrefixOrgcodeResponse() {
    }

    public GetEmployeeProfileByPrefixOrgcodeResponse(
           org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getEmployeeProfileByPrefixOrgcodeResult) {
           this.getEmployeeProfileByPrefixOrgcodeResult = getEmployeeProfileByPrefixOrgcodeResult;
    }


    /**
     * Gets the getEmployeeProfileByPrefixOrgcodeResult value for this GetEmployeeProfileByPrefixOrgcodeResponse.
     * 
     * @return getEmployeeProfileByPrefixOrgcodeResult
     */
    public org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getGetEmployeeProfileByPrefixOrgcodeResult() {
        return getEmployeeProfileByPrefixOrgcodeResult;
    }


    /**
     * Sets the getEmployeeProfileByPrefixOrgcodeResult value for this GetEmployeeProfileByPrefixOrgcodeResponse.
     * 
     * @param getEmployeeProfileByPrefixOrgcodeResult
     */
    public void setGetEmployeeProfileByPrefixOrgcodeResult(org.tempuri.GetEmployeeProfileByPrefixOrgcodeResponseGetEmployeeProfileByPrefixOrgcodeResult getEmployeeProfileByPrefixOrgcodeResult) {
        this.getEmployeeProfileByPrefixOrgcodeResult = getEmployeeProfileByPrefixOrgcodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixOrgcodeResponse)) return false;
        GetEmployeeProfileByPrefixOrgcodeResponse other = (GetEmployeeProfileByPrefixOrgcodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeProfileByPrefixOrgcodeResult==null && other.getGetEmployeeProfileByPrefixOrgcodeResult()==null) || 
             (this.getEmployeeProfileByPrefixOrgcodeResult!=null &&
              this.getEmployeeProfileByPrefixOrgcodeResult.equals(other.getGetEmployeeProfileByPrefixOrgcodeResult())));
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
        if (getGetEmployeeProfileByPrefixOrgcodeResult() != null) {
            _hashCode += getGetEmployeeProfileByPrefixOrgcodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixOrgcodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgcodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeProfileByPrefixOrgcodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgcodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgcodeResponse>GetEmployeeProfileByPrefixOrgcodeResult"));
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
