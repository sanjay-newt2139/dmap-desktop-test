package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IPFMServiceInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	@Column(name="SERVICE_STATUS", length=100)
	private String status;
	
	@Column(name="SERVICE_ID", length=100)
	private String serviceId;
	
	@Column(name="SERVICE_NAME", length=100)
	private String serviceName;
	
	@Column(name="SERVICE_TCP_STATUS", length=100)
	private String tcpStatus;
	
	@Column(name="SERVICE_TCP_PORT", length=100)
	private String tcpPort;
	
	@Column(name="SERVICE_UDP_STATUS", length=100)
	private String udpStatus;
	
	@Column(name="SERVICE_UDP_PORT", length=100)
	private String udpPort;

	public String getStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getStatus
		return status;
	}

	public void setStatus(String status) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setStatus
		this.status = status;
	}

	public String getServiceId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceId
		return serviceId;
	}

	public void setServiceId(String serviceId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServiceId
		this.serviceId = serviceId;
	}

	public String getServiceName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getServiceName
		return serviceName;
	}

	public void setServiceName(String serviceName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setServiceName
		this.serviceName = serviceName;
	}

	public String getTcpStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTcpStatus
		return tcpStatus;
	}

	public void setTcpStatus(String tcpStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTcpStatus
		this.tcpStatus = tcpStatus;
	}

	public String getTcpPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTcpPort
		return tcpPort;
	}

	public void setTcpPort(String tcpPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTcpPort
		this.tcpPort = tcpPort;
	}

	public String getUdpStatus() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUdpStatus
		return udpStatus;
	}

	public void setUdpStatus(String udpStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUdpStatus
		this.udpStatus = udpStatus;
	}

	public String getUdpPort() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUdpPort
		return udpPort;
	}

	public void setUdpPort(String udpPort) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUdpPort
		this.udpPort = udpPort;
	}


	
	
}









