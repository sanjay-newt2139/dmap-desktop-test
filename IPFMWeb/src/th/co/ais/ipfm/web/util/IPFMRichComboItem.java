package th.co.ais.ipfm.web.util;

import java.io.Serializable;

public class IPFMRichComboItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3498687968603865330L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private String label;
	private String value;
	private String value1;
	private String value2;
	
	public IPFMRichComboItem(){
	}
	
	public IPFMRichComboItem(String value, String label){
		this.value = value;
		this.label = label;
	}
	
	public IPFMRichComboItem(String label, String value, String value1) {
		this.label = label;
		this.value = value;
		this.value1 = value1;
	}
	public IPFMRichComboItem(String label, String value, String value1, String value2) {
		this.label = label;
		this.value = value;
		this.value1 = value1;
		this.value2 = value2;
	}

	public String getValue2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValue2
		return value2;
	}

	public void setValue2(String value2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValue2
		this.value2 = value2;
	}

	public String getValue1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValue1
		return value1;
	}

	public void setValue1(String value1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValue1
		this.value1 = value1;
	}

	public String getValue() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValue
		return value;
	}
	public void setValue(String value) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValue
		this.value = value;
	}
	public String getLabel() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLabel
		return label;
	}
	public void setLabel(String label) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLabel
		this.label = label;
	}
	 
	public String toString() { // DMAP Comment : Dead Code Detected - The Following Method has no reference toString
		return label;
	}
}
