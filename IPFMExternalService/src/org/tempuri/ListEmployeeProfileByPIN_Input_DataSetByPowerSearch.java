/**
 * ListEmployeeProfileByPIN_Input_DataSetByPowerSearch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListEmployeeProfileByPIN_Input_DataSetByPowerSearch  implements java.io.Serializable {
    private org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs ds;

    public ListEmployeeProfileByPIN_Input_DataSetByPowerSearch() {
    }

    public ListEmployeeProfileByPIN_Input_DataSetByPowerSearch(
           org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs ds) {
           this.ds = ds;
    }


    /**
     * Gets the ds value for this ListEmployeeProfileByPIN_Input_DataSetByPowerSearch.
     * 
     * @return ds
     */
    public org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs getDs() {
        return ds;
    }


    /**
     * Sets the ds value for this ListEmployeeProfileByPIN_Input_DataSetByPowerSearch.
     * 
     * @param ds
     */
    public void setDs(org.tempuri.ListEmployeeProfileByPIN_Input_DataSetByPowerSearchDs ds) {
        this.ds = ds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListEmployeeProfileByPIN_Input_DataSetByPowerSearch)) return false;
        ListEmployeeProfileByPIN_Input_DataSetByPowerSearch other = (ListEmployeeProfileByPIN_Input_DataSetByPowerSearch) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ds==null && other.getDs()==null) || 
             (this.ds!=null &&
              this.ds.equals(other.getDs())));
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
        if (getDs() != null) {
            _hashCode += getDs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListEmployeeProfileByPIN_Input_DataSetByPowerSearch.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListEmployeeProfileByPIN_Input_DataSetByPowerSearch"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListEmployeeProfileByPIN_Input_DataSetByPowerSearch>ds"));
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
