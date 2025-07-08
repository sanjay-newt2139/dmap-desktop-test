package th.co.ais.ipfm.domain1;

import java.util.List;

public class PmAssign {
	private String assignForTeam;
	private String assignForPerson;
	
	private Boolean isTeamCdno = false;
	private Boolean isTeamSta1 = false;
	private Boolean isTeamSta2 = false;
	private Boolean isTeamTdno = false;
	private Boolean isTeamCdn = false;
	
	private Boolean isPersonCdno = false;
	private Boolean isPersonSta1 = false;
	private Boolean isPersonSta2 = false;
	private Boolean isPersonTdno = false;
	private Boolean isPersonCdn = false;
	
	private boolean teamEnable;
	private boolean personEnable;
	
	
	private Boolean showTNP = false;
	private Boolean showCDN = false;
	
	private List<String> selectedPerson;
	private List<String> selectedDelegatePerson;
	private String homeUrl;
	
	private String mgrRemark;

	public String getAssignForTeam() {
		return assignForTeam;
	}

	public void setAssignForTeam(String assignForTeam) {
		this.assignForTeam = assignForTeam;
	}

	public String getAssignForPerson() {
		return assignForPerson;
	}

	public void setAssignForPerson(String assignForPerson) {
		this.assignForPerson = assignForPerson;
	}

	public Boolean getIsTeamCdno() {
		return isTeamCdno;
	}

	public void setIsTeamCdno(Boolean isTeamCdno) {
		this.isTeamCdno = isTeamCdno;
	}

	public Boolean getIsTeamSta1() {
		return isTeamSta1;
	}

	public void setIsTeamSta1(Boolean isTeamSta1) {
		this.isTeamSta1 = isTeamSta1;
	}

	public Boolean getIsTeamSta2() {
		return isTeamSta2;
	}

	public void setIsTeamSta2(Boolean isTeamSta2) {
		this.isTeamSta2 = isTeamSta2;
	}

	public Boolean getIsTeamTdno() {
		return isTeamTdno;
	}

	public void setIsTeamTdno(Boolean isTeamTdno) {
		this.isTeamTdno = isTeamTdno;
	}

	public Boolean getIsTeamCdn() {
		return isTeamCdn;
	}

	public void setIsTeamCdn(Boolean isTeamCdn) {
		this.isTeamCdn = isTeamCdn;
	}

	public Boolean getIsPersonCdno() {
		return isPersonCdno;
	}

	public void setIsPersonCdno(Boolean isPersonCdno) {
		this.isPersonCdno = isPersonCdno;
	}

	public Boolean getIsPersonSta1() {
		return isPersonSta1;
	}

	public void setIsPersonSta1(Boolean isPersonSta1) {
		this.isPersonSta1 = isPersonSta1;
	}

	public Boolean getIsPersonSta2() {
		return isPersonSta2;
	}

	public void setIsPersonSta2(Boolean isPersonSta2) {
		this.isPersonSta2 = isPersonSta2;
	}

	public Boolean getIsPersonTdno() {
		return isPersonTdno;
	}

	public void setIsPersonTdno(Boolean isPersonTdno) {
		this.isPersonTdno = isPersonTdno;
	}

	public Boolean getIsPersonCdn() {
		return isPersonCdn;
	}

	public void setIsPersonCdn(Boolean isPersonCdn) {
		this.isPersonCdn = isPersonCdn;
	}

	public List<String> getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(List<String> selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public String getMgrRemark() {
		return mgrRemark;
	}

	public void setMgrRemark(String mgrRemark) {
		this.mgrRemark = mgrRemark;
	}

	public boolean isTeamEnable() {
		return teamEnable;
	}

	public void setTeamEnable(boolean teamEnable) {
		this.teamEnable = teamEnable;
	}

	public boolean isPersonEnable() {
		return personEnable;
	}

	public void setPersonEnable(boolean personEnable) {
		this.personEnable = personEnable;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public Boolean getShowTNP() {
		return showTNP;
	}

	public void setShowTNP(Boolean showTNP) {
		this.showTNP = showTNP;
	}

	public Boolean getShowCDN() {
		return showCDN;
	}

	public void setShowCDN(Boolean showCDN) {
		this.showCDN = showCDN;
	}

	public List<String> getSelectedDelegatePerson() {
		return selectedDelegatePerson;
	}

	public void setSelectedDelegatePerson(List<String> selectedDelegatePerson) {
		this.selectedDelegatePerson = selectedDelegatePerson;
	}


	
}
