package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class IPLevel3NatHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	 // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
    private String ipAddress;
    private String natIPOld;
    private String natIP;
    private String createdBy;
    private Timestamp createdDate;
    
	public String getIpAddress() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpAddress
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpAddress
		this.ipAddress = ipAddress;
	}
	public String getNatIPOld() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNatIPOld
		return natIPOld;
	}
	public void setNatIPOld(String natIPOld) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNatIPOld
		this.natIPOld = natIPOld;
	}
	public String getNatIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNatIP
		return natIP;
	}
	public void setNatIP(String natIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNatIP
		this.natIP = natIP;
	}
	public String getCreatedBy() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedBy
		return createdBy;
	}
	public void setCreatedBy(String createdBy) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedBy
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCreatedDate
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCreatedDate
		this.createdDate = createdDate;
	}
    
    
    
}
