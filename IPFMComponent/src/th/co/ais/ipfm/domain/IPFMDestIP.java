package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IPFMDestIP implements Serializable{
	
	@Column(name="DEST_IP", length=100)
	private String ip;
	
	@Column(name="DEST_HOST_NAME", length=100)
	private String hostName;
	
	@Column(name="DEST_EMAIL", length=100)
	private String email;
	
	@Column(name="DEST_NAT_IP", length=100)
	private String natIp;

	public String getIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIp
		return ip;
	}

	public void setIp(String ip) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIp
		this.ip = ip;
	}

	public String getHostName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHostName
		return hostName;
	}

	public void setHostName(String hostName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHostName
		this.hostName = hostName;
	}

	public String getEmail() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEmail
		return email;
	}

	public void setEmail(String email) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEmail
		this.email = email;
	}

	public String getNatIp() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getNatIp
		return natIp;
	}

	public void setNatIp(String natIp) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setNatIp
		this.natIp = natIp;
	}

	

	
}





