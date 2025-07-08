package th.co.ais.ehr.domain;

import java.util.HashMap;

public class EmployeeProfileQueryResponse {

	private String responseDataList = null;
	private HashMap<String, String> responseHeader = null;

	public HashMap<String, String> getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(HashMap<String, String> responseHeader) {
		this.responseHeader = responseHeader;
	}

	public String getResponseDataList() {
		return responseDataList;
	}

	public void setResponseDataList(String responseDataList) {
		this.responseDataList = responseDataList;
	}

}
