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
	
	public boolean isCheckBox() {
		return checkBox;
	}
	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getDataObj() {
		return dataObj;
	}
	public void setDataObj(T dataObj) {
		this.dataObj = dataObj;
	}
	
	
}
