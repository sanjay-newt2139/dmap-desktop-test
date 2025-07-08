package th.co.ais.ipfm.domain1;

import java.util.ArrayList;
import java.util.List;

public class PMAssetDTO {
	private String subURType;
	private String roleId;
	private String teamName;
	private List<String> selectUserIdList = new ArrayList<String>();
	
	public String getSubURType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSubURType
		return subURType;
	}
	public void setSubURType(String subURType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSubURType
		this.subURType = subURType;
	}
	public String getRoleId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRoleId
		return roleId;
	}
	public void setRoleId(String roleId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRoleId
		this.roleId = roleId;
	}
	public List<String> getSelectUserIdList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectUserIdList
		return selectUserIdList;
	}
	public void setSelectUserIdList(List<String> selectUserIdList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectUserIdList
		this.selectUserIdList = selectUserIdList;
	}
	public String getTeamName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTeamName
		return teamName;
	}
	public void setTeamName(String teamName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamName
		this.teamName = teamName;
	}
	
	
	
}
