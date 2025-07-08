package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NC_ASSIGN"
    ,schema="IPFMBK"
)
public class NCAssign implements Serializable{
	@Column(name="PRG_ID", length=255)
	private String prgId;
	
	@Column(name="ASG_TO", length=255)
	private String asgTo;
	
	@Column(name="JOB_STS", length=255)
	private String jobSts;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="ROW_ID",nullable=false,length=50)
	private String rowId;

	public String getPrgId() {
		return prgId;
	}

	public void setPrgId(String prgId) {
		this.prgId = prgId;
	}

	public String getAsgTo() {
		return asgTo;
	}

	public void setAsgTo(String asgTo) {
		this.asgTo = asgTo;
	}

	public String getJobSts() {
		return jobSts;
	}

	public void setJobSts(String jobSts) {
		this.jobSts = jobSts;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	
	
}





















