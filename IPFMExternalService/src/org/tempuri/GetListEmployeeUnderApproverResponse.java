/**
 * GetListEmployeeUnderApproverResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetListEmployeeUnderApproverResponse  implements java.io.Serializable {
    private org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getListEmployeeUnderApproverResult;

    public GetListEmployeeUnderApproverResponse() {
    }

    public GetListEmployeeUnderApproverResponse(
           org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getListEmployeeUnderApproverResult) {
           this.getListEmployeeUnderApproverResult = getListEmployeeUnderApproverResult;
    }


    /**
     * Gets the getListEmployeeUnderApproverResult value for this GetListEmployeeUnderApproverResponse.
     * 
     * @return getListEmployeeUnderApproverResult
     */
    public org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getGetListEmployeeUnderApproverResult() {
        return getListEmployeeUnderApproverResult;
    }


    /**
     * Sets the getListEmployeeUnderApproverResult value for this GetListEmployeeUnderApproverResponse.
     * 
     * @param getListEmployeeUnderApproverResult
     */
    public void setGetListEmployeeUnderApproverResult(org.tempuri.GetListEmployeeUnderApproverResponseGetListEmployeeUnderApproverResult getListEmployeeUnderApproverResult) {
        this.getListEmployeeUnderApproverResult = getListEmployeeUnderApproverResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetListEmployeeUnderApproverResponse)) return false;
        GetListEmployeeUnderApproverResponse other = (GetListEmployeeUnderApproverResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getListEmployeeUnderApproverResult==null && other.getGetListEmployeeUnderApproverResult()==null) || 
             (this.getListEmployeeUnderApproverResult!=null &&
              this.getListEmployeeUnderApproverResult.equals(other.getGetListEmployeeUnderApproverResult())));
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
        if (getGetListEmployeeUnderApproverResult() != null) {
            _hashCode += getGetListEmployeeUnderApproverResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetListEmployeeUnderApproverResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetListEmployeeUnderApproverResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getListEmployeeUnderApproverResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetListEmployeeUnderApproverResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetListEmployeeUnderApproverResponse>GetListEmployeeUnderApproverResult"));
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
