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

	public String getAssignForTeam() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignForTeam
		return assignForTeam;
	}

	public void setAssignForTeam(String assignForTeam) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignForTeam
		this.assignForTeam = assignForTeam;
	}

	public String getAssignForPerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssignForPerson
		return assignForPerson;
	}

	public void setAssignForPerson(String assignForPerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssignForPerson
		this.assignForPerson = assignForPerson;
	}

	public Boolean getIsTeamCdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamCdno
		return isTeamCdno;
	}

	public void setIsTeamCdno(Boolean isTeamCdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamCdno
		this.isTeamCdno = isTeamCdno;
	}

	public Boolean getIsTeamSta1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamSta1
		return isTeamSta1;
	}

	public void setIsTeamSta1(Boolean isTeamSta1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamSta1
		this.isTeamSta1 = isTeamSta1;
	}

	public Boolean getIsTeamSta2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamSta2
		return isTeamSta2;
	}

	public void setIsTeamSta2(Boolean isTeamSta2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamSta2
		this.isTeamSta2 = isTeamSta2;
	}

	public Boolean getIsTeamTdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamTdno
		return isTeamTdno;
	}

	public void setIsTeamTdno(Boolean isTeamTdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamTdno
		this.isTeamTdno = isTeamTdno;
	}

	public Boolean getIsTeamCdn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsTeamCdn
		return isTeamCdn;
	}

	public void setIsTeamCdn(Boolean isTeamCdn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsTeamCdn
		this.isTeamCdn = isTeamCdn;
	}

	public Boolean getIsPersonCdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonCdno
		return isPersonCdno;
	}

	public void setIsPersonCdno(Boolean isPersonCdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonCdno
		this.isPersonCdno = isPersonCdno;
	}

	public Boolean getIsPersonSta1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonSta1
		return isPersonSta1;
	}

	public void setIsPersonSta1(Boolean isPersonSta1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonSta1
		this.isPersonSta1 = isPersonSta1;
	}

	public Boolean getIsPersonSta2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonSta2
		return isPersonSta2;
	}

	public void setIsPersonSta2(Boolean isPersonSta2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonSta2
		this.isPersonSta2 = isPersonSta2;
	}

	public Boolean getIsPersonTdno() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonTdno
		return isPersonTdno;
	}

	public void setIsPersonTdno(Boolean isPersonTdno) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonTdno
		this.isPersonTdno = isPersonTdno;
	}

	public Boolean getIsPersonCdn() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIsPersonCdn
		return isPersonCdn;
	}

	public void setIsPersonCdn(Boolean isPersonCdn) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIsPersonCdn
		this.isPersonCdn = isPersonCdn;
	}

	public List<String> getSelectedPerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectedPerson
		return selectedPerson;
	}

	public void setSelectedPerson(List<String> selectedPerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectedPerson
		this.selectedPerson = selectedPerson;
	}

	public String getMgrRemark() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMgrRemark
		return mgrRemark;
	}

	public void setMgrRemark(String mgrRemark) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMgrRemark
		this.mgrRemark = mgrRemark;
	}

	public boolean isTeamEnable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isTeamEnable
		return teamEnable;
	}

	public void setTeamEnable(boolean teamEnable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTeamEnable
		this.teamEnable = teamEnable;
	}

	public boolean isPersonEnable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isPersonEnable
		return personEnable;
	}

	public void setPersonEnable(boolean personEnable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPersonEnable
		this.personEnable = personEnable;
	}

	public String getHomeUrl() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHomeUrl
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHomeUrl
		this.homeUrl = homeUrl;
	}

	public Boolean getShowTNP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShowTNP
		return showTNP;
	}

	public void setShowTNP(Boolean showTNP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowTNP
		this.showTNP = showTNP;
	}

	public Boolean getShowCDN() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShowCDN
		return showCDN;
	}

	public void setShowCDN(Boolean showCDN) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShowCDN
		this.showCDN = showCDN;
	}

	public List<String> getSelectedDelegatePerson() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSelectedDelegatePerson
		return selectedDelegatePerson;
	}

	public void setSelectedDelegatePerson(List<String> selectedDelegatePerson) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSelectedDelegatePerson
		this.selectedDelegatePerson = selectedDelegatePerson;
	}


	
}
