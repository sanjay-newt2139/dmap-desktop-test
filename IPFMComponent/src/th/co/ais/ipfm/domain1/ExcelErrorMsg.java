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

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}