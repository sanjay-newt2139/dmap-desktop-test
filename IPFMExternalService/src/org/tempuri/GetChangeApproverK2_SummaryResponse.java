/**
 * GetChangeApproverK2_SummaryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetChangeApproverK2_SummaryResponse  implements java.io.Serializable {
    private org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getChangeApproverK2_SummaryResult;

    public GetChangeApproverK2_SummaryResponse() {
    }

    public GetChangeApproverK2_SummaryResponse(
           org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getChangeApproverK2_SummaryResult) {
           this.getChangeApproverK2_SummaryResult = getChangeApproverK2_SummaryResult;
    }


    /**
     * Gets the getChangeApproverK2_SummaryResult value for this GetChangeApproverK2_SummaryResponse.
     * 
     * @return getChangeApproverK2_SummaryResult
     */
    public org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getGetChangeApproverK2_SummaryResult() {
        return getChangeApproverK2_SummaryResult;
    }


    /**
     * Sets the getChangeApproverK2_SummaryResult value for this GetChangeApproverK2_SummaryResponse.
     * 
     * @param getChangeApproverK2_SummaryResult
     */
    public void setGetChangeApproverK2_SummaryResult(org.tempuri.GetChangeApproverK2_SummaryResponseGetChangeApproverK2_SummaryResult getChangeApproverK2_SummaryResult) {
        this.getChangeApproverK2_SummaryResult = getChangeApproverK2_SummaryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetChangeApproverK2_SummaryResponse)) return false;
        GetChangeApproverK2_SummaryResponse other = (GetChangeApproverK2_SummaryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getChangeApproverK2_SummaryResult==null && other.getGetChangeApproverK2_SummaryResult()==null) || 
             (this.getChangeApproverK2_SummaryResult!=null &&
              this.getChangeApproverK2_SummaryResult.equals(other.getGetChangeApproverK2_SummaryResult())));
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
        if (getGetChangeApproverK2_SummaryResult() != null) {
            _hashCode += getGetChangeApproverK2_SummaryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetChangeApproverK2_SummaryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetChangeApproverK2_SummaryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getChangeApproverK2_SummaryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetChangeApproverK2_SummaryResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetChangeApproverK2_SummaryResponse>GetChangeApproverK2_SummaryResult"));
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
