/**
 * GetEmployeeProfileByUsernameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetEmployeeProfileByUsernameResponse  implements java.io.Serializable {
    private org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getEmployeeProfileByUsernameResult;

    public GetEmployeeProfileByUsernameResponse() {
    }

    public GetEmployeeProfileByUsernameResponse(
           org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getEmployeeProfileByUsernameResult) {
           this.getEmployeeProfileByUsernameResult = getEmployeeProfileByUsernameResult;
    }


    /**
     * Gets the getEmployeeProfileByUsernameResult value for this GetEmployeeProfileByUsernameResponse.
     * 
     * @return getEmployeeProfileByUsernameResult
     */
    public org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getGetEmployeeProfileByUsernameResult() {
        return getEmployeeProfileByUsernameResult;
    }


    /**
     * Sets the getEmployeeProfileByUsernameResult value for this GetEmployeeProfileByUsernameResponse.
     * 
     * @param getEmployeeProfileByUsernameResult
     */
    public void setGetEmployeeProfileByUsernameResult(org.tempuri.GetEmployeeProfileByUsernameResponseGetEmployeeProfileByUsernameResult getEmployeeProfileByUsernameResult) {
        this.getEmployeeProfileByUsernameResult = getEmployeeProfileByUsernameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmployeeProfileByUsernameResponse)) return false;
        GetEmployeeProfileByUsernameResponse other = (GetEmployeeProfileByUsernameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEmployeeProfileByUsernameResult==null && other.getGetEmployeeProfileByUsernameResult()==null) || 
             (this.getEmployeeProfileByUsernameResult!=null &&
              this.getEmployeeProfileByUsernameResult.equals(other.getGetEmployeeProfileByUsernameResult())));
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
        if (getGetEmployeeProfileByUsernameResult() != null) {
            _hashCode += getGetEmployeeProfileByUsernameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmployeeProfileByUsernameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetEmployeeProfileByUsernameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEmployeeProfileByUsernameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetEmployeeProfileByUsernameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetEmployeeProfileByUsernameResponse>GetEmployeeProfileByUsernameResult"));
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
