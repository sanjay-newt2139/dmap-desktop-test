package th.co.ais.ipfm.vo.ws;

import java.io.Serializable;
import java.util.List;

public class IPInfoResponseWrapper implements Serializable {

	private List<IPInfoResponse> ipInfoResponse;

	public List<IPInfoResponse> getIpInfoResponse() {
		return ipInfoResponse;
	}

	public void setIpInfoResponse(List<IPInfoResponse> ipInfoResponse) {
		this.ipInfoResponse = ipInfoResponse;
	}
	
	
}
