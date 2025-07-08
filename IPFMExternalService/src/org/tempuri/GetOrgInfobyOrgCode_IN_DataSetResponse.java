/**
 * GetOrgInfobyOrgCode_IN_DataSetResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetOrgInfobyOrgCode_IN_DataSetResponse  implements java.io.Serializable {
    private org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getOrgInfobyOrgCode_IN_DataSetResult;

    public GetOrgInfobyOrgCode_IN_DataSetResponse() {
    }

    public GetOrgInfobyOrgCode_IN_DataSetResponse(
           org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getOrgInfobyOrgCode_IN_DataSetResult) {
           this.getOrgInfobyOrgCode_IN_DataSetResult = getOrgInfobyOrgCode_IN_DataSetResult;
    }


    /**
     * Gets the getOrgInfobyOrgCode_IN_DataSetResult value for this GetOrgInfobyOrgCode_IN_DataSetResponse.
     * 
     * @return getOrgInfobyOrgCode_IN_DataSetResult
     */
    public org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getGetOrgInfobyOrgCode_IN_DataSetResult() {
        return getOrgInfobyOrgCode_IN_DataSetResult;
    }


    /**
     * Sets the getOrgInfobyOrgCode_IN_DataSetResult value for this GetOrgInfobyOrgCode_IN_DataSetResponse.
     * 
     * @param getOrgInfobyOrgCode_IN_DataSetResult
     */
    public void setGetOrgInfobyOrgCode_IN_DataSetResult(org.tempuri.GetOrgInfobyOrgCode_IN_DataSetResponseGetOrgInfobyOrgCode_IN_DataSetResult getOrgInfobyOrgCode_IN_DataSetResult) {
        this.getOrgInfobyOrgCode_IN_DataSetResult = getOrgInfobyOrgCode_IN_DataSetResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOrgInfobyOrgCode_IN_DataSetResponse)) return false;
        GetOrgInfobyOrgCode_IN_DataSetResponse other = (GetOrgInfobyOrgCode_IN_DataSetResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getOrgInfobyOrgCode_IN_DataSetResult==null && other.getGetOrgInfobyOrgCode_IN_DataSetResult()==null) || 
             (this.getOrgInfobyOrgCode_IN_DataSetResult!=null &&
              this.getOrgInfobyOrgCode_IN_DataSetResult.equals(other.getGetOrgInfobyOrgCode_IN_DataSetResult())));
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
        if (getGetOrgInfobyOrgCode_IN_DataSetResult() != null) {
            _hashCode += getGetOrgInfobyOrgCode_IN_DataSetResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOrgInfobyOrgCode_IN_DataSetResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrgInfobyOrgCode_IN_DataSetResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getOrgInfobyOrgCode_IN_DataSetResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetOrgInfobyOrgCode_IN_DataSetResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetOrgInfobyOrgCode_IN_DataSetResponse>GetOrgInfobyOrgCode_IN_DataSetResult"));
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
