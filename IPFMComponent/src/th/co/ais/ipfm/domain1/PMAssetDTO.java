package th.co.ais.ipfm.domain1;

import java.util.ArrayList;
import java.util.List;

public class PMAssetDTO {
	private String subURType;
	private String roleId;
	private String teamName;
	private List<String> selectUserIdList = new ArrayList<String>();
	
	public String getSubURType() {
		return subURType;
	}
	public void setSubURType(String subURType) {
		this.subURType = subURType;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public List<String> getSelectUserIdList() {
		return selectUserIdList;
	}
	public void setSelectUserIdList(List<String> selectUserIdList) {
		this.selectUserIdList = selectUserIdList;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
}
