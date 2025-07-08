/**
 * Search_Employee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Search_Employee  implements java.io.Serializable {
    private java.lang.String employee_ID;

    private java.lang.String emp_Name;

    private java.lang.String emp_Last_Name;

    private java.lang.String ENGEmp_Name;

    private java.lang.String ENGEmp_Last_Name;

    private java.lang.String org_ID;

    private java.lang.String org_Name;

    public Search_Employee() {
    }

    public Search_Employee(
           java.lang.String employee_ID,
           java.lang.String emp_Name,
           java.lang.String emp_Last_Name,
           java.lang.String ENGEmp_Name,
           java.lang.String ENGEmp_Last_Name,
           java.lang.String org_ID,
           java.lang.String org_Name) {
           this.employee_ID = employee_ID;
           this.emp_Name = emp_Name;
           this.emp_Last_Name = emp_Last_Name;
           this.ENGEmp_Name = ENGEmp_Name;
           this.ENGEmp_Last_Name = ENGEmp_Last_Name;
           this.org_ID = org_ID;
           this.org_Name = org_Name;
    }


    /**
     * Gets the employee_ID value for this Search_Employee.
     * 
     * @return employee_ID
     */
    public java.lang.String getEmployee_ID() {
        return employee_ID;
    }


    /**
     * Sets the employee_ID value for this Search_Employee.
     * 
     * @param employee_ID
     */
    public void setEmployee_ID(java.lang.String employee_ID) {
        this.employee_ID = employee_ID;
    }


    /**
     * Gets the emp_Name value for this Search_Employee.
     * 
     * @return emp_Name
     */
    public java.lang.String getEmp_Name() {
        return emp_Name;
    }


    /**
     * Sets the emp_Name value for this Search_Employee.
     * 
     * @param emp_Name
     */
    public void setEmp_Name(java.lang.String emp_Name) {
        this.emp_Name = emp_Name;
    }


    /**
     * Gets the emp_Last_Name value for this Search_Employee.
     * 
     * @return emp_Last_Name
     */
    public java.lang.String getEmp_Last_Name() {
        return emp_Last_Name;
    }


    /**
     * Sets the emp_Last_Name value for this Search_Employee.
     * 
     * @param emp_Last_Name
     */
    public void setEmp_Last_Name(java.lang.String emp_Last_Name) {
        this.emp_Last_Name = emp_Last_Name;
    }


    /**
     * Gets the ENGEmp_Name value for this Search_Employee.
     * 
     * @return ENGEmp_Name
     */
    public java.lang.String getENGEmp_Name() {
        return ENGEmp_Name;
    }


    /**
     * Sets the ENGEmp_Name value for this Search_Employee.
     * 
     * @param ENGEmp_Name
     */
    public void setENGEmp_Name(java.lang.String ENGEmp_Name) {
        this.ENGEmp_Name = ENGEmp_Name;
    }


    /**
     * Gets the ENGEmp_Last_Name value for this Search_Employee.
     * 
     * @return ENGEmp_Last_Name
     */
    public java.lang.String getENGEmp_Last_Name() {
        return ENGEmp_Last_Name;
    }


    /**
     * Sets the ENGEmp_Last_Name value for this Search_Employee.
     * 
     * @param ENGEmp_Last_Name
     */
    public void setENGEmp_Last_Name(java.lang.String ENGEmp_Last_Name) {
        this.ENGEmp_Last_Name = ENGEmp_Last_Name;
    }


    /**
     * Gets the org_ID value for this Search_Employee.
     * 
     * @return org_ID
     */
    public java.lang.String getOrg_ID() {
        return org_ID;
    }


    /**
     * Sets the org_ID value for this Search_Employee.
     * 
     * @param org_ID
     */
    public void setOrg_ID(java.lang.String org_ID) {
        this.org_ID = org_ID;
    }


    /**
     * Gets the org_Name value for this Search_Employee.
     * 
     * @return org_Name
     */
    public java.lang.String getOrg_Name() {
        return org_Name;
    }


    /**
     * Sets the org_Name value for this Search_Employee.
     * 
     * @param org_Name
     */
    public void setOrg_Name(java.lang.String org_Name) {
        this.org_Name = org_Name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Search_Employee)) return false;
        Search_Employee other = (Search_Employee) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.employee_ID==null && other.getEmployee_ID()==null) || 
             (this.employee_ID!=null &&
              this.employee_ID.equals(other.getEmployee_ID()))) &&
            ((this.emp_Name==null && other.getEmp_Name()==null) || 
             (this.emp_Name!=null &&
              this.emp_Name.equals(other.getEmp_Name()))) &&
            ((this.emp_Last_Name==null && other.getEmp_Last_Name()==null) || 
             (this.emp_Last_Name!=null &&
              this.emp_Last_Name.equals(other.getEmp_Last_Name()))) &&
            ((this.ENGEmp_Name==null && other.getENGEmp_Name()==null) || 
             (this.ENGEmp_Name!=null &&
              this.ENGEmp_Name.equals(other.getENGEmp_Name()))) &&
            ((this.ENGEmp_Last_Name==null && other.getENGEmp_Last_Name()==null) || 
             (this.ENGEmp_Last_Name!=null &&
              this.ENGEmp_Last_Name.equals(other.getENGEmp_Last_Name()))) &&
            ((this.org_ID==null && other.getOrg_ID()==null) || 
             (this.org_ID!=null &&
              this.org_ID.equals(other.getOrg_ID()))) &&
            ((this.org_Name==null && other.getOrg_Name()==null) || 
             (this.org_Name!=null &&
              this.org_Name.equals(other.getOrg_Name())));
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
        if (getEmployee_ID() != null) {
            _hashCode += getEmployee_ID().hashCode();
        }
        if (getEmp_Name() != null) {
            _hashCode += getEmp_Name().hashCode();
        }
        if (getEmp_Last_Name() != null) {
            _hashCode += getEmp_Last_Name().hashCode();
        }
        if (getENGEmp_Name() != null) {
            _hashCode += getENGEmp_Name().hashCode();
        }
        if (getENGEmp_Last_Name() != null) {
            _hashCode += getENGEmp_Last_Name().hashCode();
        }
        if (getOrg_ID() != null) {
            _hashCode += getOrg_ID().hashCode();
        }
        if (getOrg_Name() != null) {
            _hashCode += getOrg_Name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Search_Employee.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Search_Employee"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employee_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Employee_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emp_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Emp_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emp_Last_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Emp_Last_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ENGEmp_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ENGEmp_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ENGEmp_Last_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ENGEmp_Last_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("org_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Org_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("org_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Org_Name"));
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
