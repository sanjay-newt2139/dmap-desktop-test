package th.co.ais.ipfm.domain1;

public class MsgUploadError {
	private String rowNumber;
	private String description;
	private String[] errorMsg;
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String[] errorMsg) {
		this.errorMsg = errorMsg;
	}
}
