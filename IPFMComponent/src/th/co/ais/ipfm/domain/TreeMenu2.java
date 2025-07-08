package th.co.ais.ipfm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.NamedNativeQuery(name = "ToDoList", 
											query = "call LIST_TODO(:userID,?);", 
											callable = true,
											resultClass=TreeMenu2.class)

public class TreeMenu2 implements Serializable {
	@Column(name="LV1",nullable=false,length=50)
	private String level1;
	
	@Column(name="LV2",nullable=false,length=50)
	private String level2;
	
	@Column(name="LV3",nullable=false,length=50)
	private String level3;
	
	@Column(name="LV4",nullable=false,length=50)
	private String level4;
	
	@Column(name="ACTION_NAME",nullable=false,length=50)
	private String actionName;
	
	
	
	
	public String getLevel1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLevel1
		return level1;
	}
	public void setLevel1(String level1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLevel1
		this.level1 = level1;
	}
	public String getLevel2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLevel2
		return level2;
	}
	public void setLevel2(String level2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLevel2
		this.level2 = level2;
	}
	public String getLevel3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLevel3
		return level3;
	}
	public void setLevel3(String level3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLevel3
		this.level3 = level3;
	}
	public String getLevel4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLevel4
		return level4;
	}
	public void setLevel4(String level4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLevel4
		this.level4 = level4;
	}
	public String getActionName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getActionName
		return actionName;
	}
	public void setActionName(String actionName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setActionName
		this.actionName = actionName;
	}
	
	
}
