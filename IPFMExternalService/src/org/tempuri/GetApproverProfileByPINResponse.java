/**
 * GetApproverProfileByPINResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetApproverProfileByPINResponse  implements java.io.Serializable {
    private org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getApproverProfileByPINResult;

    public GetApproverProfileByPINResponse() {
    }

    public GetApproverProfileByPINResponse(
           org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getApproverProfileByPINResult) {
           this.getApproverProfileByPINResult = getApproverProfileByPINResult;
    }


    /**
     * Gets the getApproverProfileByPINResult value for this GetApproverProfileByPINResponse.
     * 
     * @return getApproverProfileByPINResult
     */
    public org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getGetApproverProfileByPINResult() {
        return getApproverProfileByPINResult;
    }


    /**
     * Sets the getApproverProfileByPINResult value for this GetApproverProfileByPINResponse.
     * 
     * @param getApproverProfileByPINResult
     */
    public void setGetApproverProfileByPINResult(org.tempuri.GetApproverProfileByPINResponseGetApproverProfileByPINResult getApproverProfileByPINResult) {
        this.getApproverProfileByPINResult = getApproverProfileByPINResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetApproverProfileByPINResponse)) return false;
        GetApproverProfileByPINResponse other = (GetApproverProfileByPINResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getApproverProfileByPINResult==null && other.getGetApproverProfileByPINResult()==null) || 
             (this.getApproverProfileByPINResult!=null &&
              this.getApproverProfileByPINResult.equals(other.getGetApproverProfileByPINResult())));
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
        if (getGetApproverProfileByPINResult() != null) {
            _hashCode += getGetApproverProfileByPINResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetApproverProfileByPINResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetApproverProfileByPINResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getApproverProfileByPINResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetApproverProfileByPINResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetApproverProfileByPINResponse>GetApproverProfileByPINResult"));
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
