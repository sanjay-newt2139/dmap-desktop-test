package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IPFMServiceInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTcpStatus() {
		return tcpStatus;
	}

	public void setTcpStatus(String tcpStatus) {
		this.tcpStatus = tcpStatus;
	}

	public String getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(String tcpPort) {
		this.tcpPort = tcpPort;
	}

	public String getUdpStatus() {
		return udpStatus;
	}

	public void setUdpStatus(String udpStatus) {
		this.udpStatus = udpStatus;
	}

	public String getUdpPort() {
		return udpPort;
	}

	public void setUdpPort(String udpPort) {
		this.udpPort = udpPort;
	}


	
	
}









