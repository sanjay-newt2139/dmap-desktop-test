package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="IP_PARAMETER", schema="IPFMBK")
public class IPParameter extends MasterDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowId;
	private Integer version;
	private String parameterGroup;
	private String parameterSubGroup;
	private String stringValue;
	private BigDecimal numericValue;
	private String booleanValue;

	private String realBooleanValue;
	
	
	@Transient
	public String getRealBooleanValue() {
		if(getBooleanValue()!=null && getBooleanValue().trim().equalsIgnoreCase("T")){
			return "TRUE";
		}else{
			return "FALSE";
		}
	}

	public void setRealBooleanValue(String realBooleanValue) {
		this.realBooleanValue = realBooleanValue;
	}
	
/*	@Transient
	public Boolean getRealBooleanValue() {
		if(getBooleanValue()!=null && getBooleanValue().trim().equalsIgnoreCase("T")){
			return new Boolean(true);
		}else{
			return new Boolean(false);
		}
	}

	public void setRealBooleanValue(Boolean realBooleanValue) {
		this.realBooleanValue = realBooleanValue;
	}*/
	
	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	
	@Version
	@Column(name="VERSION")
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Column(name="PARAMETER_GROUP")
	public String getParameterGroup() {
		return parameterGroup;
	}
	
	public void setParameterGroup(String parameterGroup) {
		this.parameterGroup = parameterGroup;
	}
	
	@Column(name="PARAMETER_SUBGROUP")
	public String getParameterSubGroup() {
		return parameterSubGroup;
	}
	
	public void setParameterSubGroup(String parameterSubGroup) {
		this.parameterSubGroup = parameterSubGroup;
	}
	
	@Column(name="STRING_VALUE")
	public String getStringValue() {
		return stringValue;
	}
	
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Column(name="NUMERIC_VALUE")
	public BigDecimal getNumericValue() {
		return numericValue;
	}
	
	public void setNumericValue(BigDecimal numericValue) {
		this.numericValue = numericValue;
	}
	
	@Column(name="BOOLEAN_VALUE")
	public String getBooleanValue() {
		return booleanValue;
	}
	
	public void setBooleanValue(String booleanValue) {
		this.booleanValue = booleanValue;
	}
	
	@Column(name="CREATE_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="CREATE_DATE")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name="UPDATE_BY")
	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	
	@Column(name="UPDATE_DATE")
	public Date getLastUpd() {
		return lastUpd;
	}
	
	public void setLastUpd(Date lastUpd) {
		this.lastUpd = lastUpd;
	}

	

}
