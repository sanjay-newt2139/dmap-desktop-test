package th.co.ais.ipfm.domain1;

public class ExcelErrorMsg {
	private String rowNo;
	private String errorMsg;
	
	public ExcelErrorMsg(){
	}

	public ExcelErrorMsg(String rowNo, String errorMsg) {
		super();
		this.rowNo = rowNo;
		this.errorMsg = errorMsg;
	}

	public String getRowNo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowNo
		return rowNo;
	}

	public void setRowNo(String rowNo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowNo
		this.rowNo = rowNo;
	}

	public String getErrorMsg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMsg
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMsg
		this.errorMsg = errorMsg;
	}

}
