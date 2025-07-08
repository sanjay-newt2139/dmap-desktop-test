package th.co.ais.ehr.domain;

import java.util.HashMap;

public class EmployeeProfileQueryResponse {

	private String responseDataList = null;
	private HashMap<String, String> responseHeader = null;

	public HashMap<String, String> getResponseHeader() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResponseHeader
		return responseHeader;
	}

	public void setResponseHeader(HashMap<String, String> responseHeader) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResponseHeader
		this.responseHeader = responseHeader;
	}

	public String getResponseDataList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResponseDataList
		return responseDataList;
	}

	public void setResponseDataList(String responseDataList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResponseDataList
		this.responseDataList = responseDataList;
	}

}
