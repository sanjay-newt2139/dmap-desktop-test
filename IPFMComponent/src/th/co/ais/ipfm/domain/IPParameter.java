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
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private String rowId;
	private Integer version;
	private String parameterGroup;
	private String parameterSubGroup;
	private String stringValue;
	private BigDecimal numericValue;
	private String booleanValue;

	private String realBooleanValue;
	
	
	@Transient
	public String getRealBooleanValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRealBooleanValue
		if(getBooleanValue()!=null && getBooleanValue().trim().equalsIgnoreCase("T")){
			return "TRUE";
		}else{
			return "FALSE";
		}
	}

	public void setRealBooleanValue(String realBooleanValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRealBooleanValue
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
	public String getRowId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowId
		return rowId;
	}

	public void setRowId(String rowId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowId
		this.rowId = rowId;
	}

	
	@Version
	@Column(name="VERSION")
	public Integer getVersion() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVersion
		return version;
	}
	
	public void setVersion(Integer version) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVersion
		this.version = version;
	}
	
	@Column(name="PARAMETER_GROUP")
	public String getParameterGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParameterGroup
		return parameterGroup;
	}
	
	public void setParameterGroup(String parameterGroup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParameterGroup
		this.parameterGroup = parameterGroup;
	}
	
	@Column(name="PARAMETER_SUBGROUP")
	public String getParameterSubGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParameterSubGroup
		return parameterSubGroup;
	}
	
	public void setParameterSubGroup(String parameterSubGroup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParameterSubGroup
		this.parameterSubGroup = parameterSubGroup;
	}
	
	@Column(name="STRING_VALUE")
	public String getStringValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStringValue
		return stringValue;
	}
	
	public void setStringValue(String stringValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStringValue
		this.stringValue = stringValue;
	}
	
	@Column(name="NUMERIC_VALUE")
	public BigDecimal getNumericValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNumericValue
		return numericValue;
	}
	
	public void setNumericValue(BigDecimal numericValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNumericValue
		this.numericValue = numericValue;
	}
	
	@Column(name="BOOLEAN_VALUE")
	public String getBooleanValue() {
		return booleanValue;
	}
	
	public void setBooleanValue(String booleanValue) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setBooleanValue
		this.booleanValue = booleanValue;
	}
	
	@Column(name="CREATE_BY")
	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		return createdBy;
	}

	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		this.createdBy = createdBy;
	}

	@Column(name="CREATE_DATE")
	public Date getCreated() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreated
		return created;
	}

	public void setCreated(Date created) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreated
		this.created = created;
	}

	@Column(name="UPDATE_BY")
	public String getLastUpdBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpdBy
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpdBy
		this.lastUpdBy = lastUpdBy;
	}
	
	@Column(name="UPDATE_DATE")
	public Date getLastUpd() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLastUpd
		return lastUpd;
	}
	
	public void setLastUpd(Date lastUpd) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLastUpd
		this.lastUpd = lastUpd;
	}

	

}
