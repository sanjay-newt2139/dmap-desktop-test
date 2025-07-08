package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class IPLevel3NatHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
    private String ipAddress;
    private String natIPOld;
    private String natIP;
    private String createdBy;
    private Timestamp createdDate;
    
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getNatIPOld() {
		return natIPOld;
	}
	public void setNatIPOld(String natIPOld) {
		this.natIPOld = natIPOld;
	}
	public String getNatIP() {
		return natIP;
	}
	public void setNatIP(String natIP) {
		this.natIP = natIP;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
    
    
    
}
