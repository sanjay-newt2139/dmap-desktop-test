package th.co.ais.ipfm.util;

public class WrapperBeanObject<T> {
	private T dataObj;
	private String message;
	private boolean checkBox;
	
	public WrapperBeanObject() {
	}	

	
	public WrapperBeanObject(T dataObj) {
		super();
		this.dataObj = dataObj;
	}	
	
	public boolean isCheckBox() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isCheckBox
		return checkBox;
	}
	public void setCheckBox(boolean checkBox) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCheckBox
		this.checkBox = checkBox;
	}
	public String getMessage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMessage
		return message;
	}
	public void setMessage(String message) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMessage
		this.message = message;
	}
	public Object getDataObj() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getDataObj
		return dataObj;
	}
	public void setDataObj(T dataObj) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDataObj
		this.dataObj = dataObj;
	}
	
	
}
