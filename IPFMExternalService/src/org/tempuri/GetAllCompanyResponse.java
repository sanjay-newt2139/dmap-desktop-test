/**
 * GetAllCompanyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetAllCompanyResponse  implements java.io.Serializable {
    private org.tempuri.GetAllCompanyResponseGetAllCompanyResult getAllCompanyResult;

    public GetAllCompanyResponse() {
    }

    public GetAllCompanyResponse(
           org.tempuri.GetAllCompanyResponseGetAllCompanyResult getAllCompanyResult) {
           this.getAllCompanyResult = getAllCompanyResult;
    }


    /**
     * Gets the getAllCompanyResult value for this GetAllCompanyResponse.
     * 
     * @return getAllCompanyResult
     */
    public org.tempuri.GetAllCompanyResponseGetAllCompanyResult getGetAllCompanyResult() {
        return getAllCompanyResult;
    }


    /**
     * Sets the getAllCompanyResult value for this GetAllCompanyResponse.
     * 
     * @param getAllCompanyResult
     */
    public void setGetAllCompanyResult(org.tempuri.GetAllCompanyResponseGetAllCompanyResult getAllCompanyResult) {
        this.getAllCompanyResult = getAllCompanyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAllCompanyResponse)) return false;
        GetAllCompanyResponse other = (GetAllCompanyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAllCompanyResult==null && other.getGetAllCompanyResult()==null) || 
             (this.getAllCompanyResult!=null &&
              this.getAllCompanyResult.equals(other.getGetAllCompanyResult())));
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
        if (getGetAllCompanyResult() != null) {
            _hashCode += getGetAllCompanyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAllCompanyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetAllCompanyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAllCompanyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetAllCompanyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetAllCompanyResponse>GetAllCompanyResult"));
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
