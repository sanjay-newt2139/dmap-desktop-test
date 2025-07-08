/**
 * ListAllemployeeunderApprover_Input_DataSet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ListAllemployeeunderApprover_Input_DataSet  implements java.io.Serializable {
    private java.lang.String pinManager;

    private java.lang.String positionManager;

    private org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs ds;

    public ListAllemployeeunderApprover_Input_DataSet() {
    }

    public ListAllemployeeunderApprover_Input_DataSet(
           java.lang.String pinManager,
           java.lang.String positionManager,
           org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs ds) {
           this.pinManager = pinManager;
           this.positionManager = positionManager;
           this.ds = ds;
    }


    /**
     * Gets the pinManager value for this ListAllemployeeunderApprover_Input_DataSet.
     * 
     * @return pinManager
     */
    public java.lang.String getPinManager() {
        return pinManager;
    }


    /**
     * Sets the pinManager value for this ListAllemployeeunderApprover_Input_DataSet.
     * 
     * @param pinManager
     */
    public void setPinManager(java.lang.String pinManager) {
        this.pinManager = pinManager;
    }


    /**
     * Gets the positionManager value for this ListAllemployeeunderApprover_Input_DataSet.
     * 
     * @return positionManager
     */
    public java.lang.String getPositionManager() {
        return positionManager;
    }


    /**
     * Sets the positionManager value for this ListAllemployeeunderApprover_Input_DataSet.
     * 
     * @param positionManager
     */
    public void setPositionManager(java.lang.String positionManager) {
        this.positionManager = positionManager;
    }


    /**
     * Gets the ds value for this ListAllemployeeunderApprover_Input_DataSet.
     * 
     * @return ds
     */
    public org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs getDs() {
        return ds;
    }


    /**
     * Sets the ds value for this ListAllemployeeunderApprover_Input_DataSet.
     * 
     * @param ds
     */
    public void setDs(org.tempuri.ListAllemployeeunderApprover_Input_DataSetDs ds) {
        this.ds = ds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListAllemployeeunderApprover_Input_DataSet)) return false;
        ListAllemployeeunderApprover_Input_DataSet other = (ListAllemployeeunderApprover_Input_DataSet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pinManager==null && other.getPinManager()==null) || 
             (this.pinManager!=null &&
              this.pinManager.equals(other.getPinManager()))) &&
            ((this.positionManager==null && other.getPositionManager()==null) || 
             (this.positionManager!=null &&
              this.positionManager.equals(other.getPositionManager()))) &&
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
        if (getPinManager() != null) {
            _hashCode += getPinManager().hashCode();
        }
        if (getPositionManager() != null) {
            _hashCode += getPositionManager().hashCode();
        }
        if (getDs() != null) {
            _hashCode += getDs().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListAllemployeeunderApprover_Input_DataSet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ListAllemployeeunderApprover_Input_DataSet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinManager");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pinManager"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("positionManager");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "positionManager"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ListAllemployeeunderApprover_Input_DataSet>ds"));
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
