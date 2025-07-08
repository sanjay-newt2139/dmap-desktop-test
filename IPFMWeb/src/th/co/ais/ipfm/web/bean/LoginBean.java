package th.co.ais.ipfm.web.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private String username;
	private String password;
	private String errorMsg;
	private boolean displayErrorMsg = false;
	
	public LoginBean() {
		super();
		this.displayErrorMsg = false;
	}

	public boolean isDisplayErrorMsg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayErrorMsg
		return displayErrorMsg;
	}

	public void setDisplayErrorMsg(boolean displayErrorMsg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayErrorMsg
		this.displayErrorMsg = displayErrorMsg;
	}

	public String getErrorMsg() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMsg
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMsg
		this.errorMsg = errorMsg;
	}

	public String getUsername() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUsername
		return username;
	}
	
	public void setUsername(String username) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUsername
		this.username = username;
	}
	
	public String getPassword() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPassword
		return password;
	}
	
	public void setPassword(String password) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPassword
		this.password = password;
	}
}
