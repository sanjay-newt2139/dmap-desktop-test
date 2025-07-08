/**
 * GetOrganization.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GetOrganization  implements java.io.Serializable {
    private java.lang.String orgcode;

    private java.lang.String orgname;

    private java.lang.String orgdesc;

    public GetOrganization() {
    }

    public GetOrganization(
           java.lang.String orgcode,
           java.lang.String orgname,
           java.lang.String orgdesc) {
           this.orgcode = orgcode;
           this.orgname = orgname;
           this.orgdesc = orgdesc;
    }


    /**
     * Gets the orgcode value for this GetOrganization.
     * 
     * @return orgcode
     */
    public java.lang.String getOrgcode() {
        return orgcode;
    }


    /**
     * Sets the orgcode value for this GetOrganization.
     * 
     * @param orgcode
     */
    public void setOrgcode(java.lang.String orgcode) {
        this.orgcode = orgcode;
    }


    /**
     * Gets the orgname value for this GetOrganization.
     * 
     * @return orgname
     */
    public java.lang.String getOrgname() {
        return orgname;
    }


    /**
     * Sets the orgname value for this GetOrganization.
     * 
     * @param orgname
     */
    public void setOrgname(java.lang.String orgname) {
        this.orgname = orgname;
    }


    /**
     * Gets the orgdesc value for this GetOrganization.
     * 
     * @return orgdesc
     */
    public java.lang.String getOrgdesc() {
        return orgdesc;
    }


    /**
     * Sets the orgdesc value for this GetOrganization.
     * 
     * @param orgdesc
     */
    public void setOrgdesc(java.lang.String orgdesc) {
        this.orgdesc = orgdesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOrganization)) return false;
        GetOrganization other = (GetOrganization) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orgcode==null && other.getOrgcode()==null) || 
             (this.orgcode!=null &&
              this.orgcode.equals(other.getOrgcode()))) &&
            ((this.orgname==null && other.getOrgname()==null) || 
             (this.orgname!=null &&
              this.orgname.equals(other.getOrgname()))) &&
            ((this.orgdesc==null && other.getOrgdesc()==null) || 
             (this.orgdesc!=null &&
              this.orgdesc.equals(other.getOrgdesc())));
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
        if (getOrgcode() != null) {
            _hashCode += getOrgcode().hashCode();
        }
        if (getOrgname() != null) {
            _hashCode += getOrgname().hashCode();
        }
        if (getOrgdesc() != null) {
            _hashCode += getOrgdesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOrganization.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetOrganization"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "orgcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "orgname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgdesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "orgdesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
