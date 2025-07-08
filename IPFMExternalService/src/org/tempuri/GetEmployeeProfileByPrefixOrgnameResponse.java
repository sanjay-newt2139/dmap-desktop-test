/**
 * GetEmployeeProfileByPrefixOrgnameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByPrefixOrgnameResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getEmployeeProfileByPrefixOrgnameResult;

    public GetEmployeeProfileByPrefixOrgnameResponse() {
    }

    public GetEmployeeProfileByPrefixOrgnameResponse(
           org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getEmployeeProfileByPrefixOrgnameResult) {
           this.getEmployeeProfileByPrefixOrgnameResult = getEmployeeProfileByPrefixOrgnameResult;
    }


    /**
     * Gets the getEmployeeProfileByPrefixOrgnameResult value for this GetEmployeeProfileByPrefixOrgnameResponse.
     * 
     * @return getEmployeeProfileByPrefixOrgnameResult
     */
    public org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getGetEmployeeProfileByPrefixOrgnameResult() {
        return getEmployeeProfileByPrefixOrgnameResult;
    }


    /**
     * Sets the getEmployeeProfileByPrefixOrgnameResult value for this GetEmployeeProfileByPrefixOrgnameResponse.
     * 
     * @param getEmployeeProfileByPrefixOrgnameResult
     */
    public void setGetEmployeeProfileByPrefixOrgnameResult(org.tempuri.GetEmployeeProfileByPrefixOrgnameResponseGetEmployeeProfileByPrefixOrgnameResult getEmployeeProfileByPrefixOrgnameResult) {
        this.getEmployeeProfileByPrefixOrgnameResult = getEmployeeProfileByPrefixOrgnameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByPrefixOrgnameResponse)) return false;
        GetEmployeeProfileByPrefixOrgnameResponse other = (GetEmployeeProfileByPrefixOrgnameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeProfileByPrefixOrgnameResult==null && other.getGetEmployeeProfileByPrefixOrgnameResult()==null) || 
             (this.getEmployeeProfileByPrefixOrgnameResult!=null &&
              this.getEmployeeProfileByPrefixOrgnameResult.equals(other.getGetEmployeeProfileByPrefixOrgnameResult())));
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
        if (getGetEmployeeProfileByPrefixOrgnameResult() != null) {
            _hashCode += getGetEmployeeProfileByPrefixOrgnameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByPrefixOrgnameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByPrefixOrgnameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeProfileByPrefixOrgnameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByPrefixOrgnameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByPrefixOrgnameResponse>GetEmployeeProfileByPrefixOrgnameResult"));
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
