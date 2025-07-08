package th.co.ais.ipfm.domain;

import java.io.Serializable;


public class IPMasterValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String valueGroup;
    private String valueName;
    private String valueData;
    private String valueDescription;
	public String getValueGroup() {
		return valueGroup;
	}
	public void setValueGroup(String valueGroup) {
		this.valueGroup = valueGroup;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public String getValueData() {
		return valueData;
	}
	public void setValueData(String valueData) {
		this.valueData = valueData;
	}
	public String getValueDescription() {
		return valueDescription;
	}
	public void setValueDescription(String valueDescription) {
		this.valueDescription = valueDescription;
	}

    
}
