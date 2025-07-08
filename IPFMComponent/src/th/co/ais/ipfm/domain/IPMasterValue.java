package th.co.ais.ipfm.domain;

import java.io.Serializable;


public class IPMasterValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
    private String valueGroup;
    private String valueName;
    private String valueData;
    private String valueDescription;
	public String getValueGroup() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValueGroup
		return valueGroup;
	}
	public void setValueGroup(String valueGroup) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValueGroup
		this.valueGroup = valueGroup;
	}
	public String getValueName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValueName
		return valueName;
	}
	public void setValueName(String valueName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValueName
		this.valueName = valueName;
	}
	public String getValueData() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValueData
		return valueData;
	}
	public void setValueData(String valueData) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValueData
		this.valueData = valueData;
	}
	public String getValueDescription() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getValueDescription
		return valueDescription;
	}
	public void setValueDescription(String valueDescription) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setValueDescription
		this.valueDescription = valueDescription;
	}

    
}
