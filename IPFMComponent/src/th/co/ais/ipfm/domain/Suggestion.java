package th.co.ais.ipfm.domain;

public class Suggestion {
	private String key;
	private String value;
	
	public Suggestion(){
	}
	
	public Suggestion(String key,String value){
		this.key=key;
		this.value=value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
