package th.co.ais.ehr.domain;

public class Approver {

	private String PinManager;
	private String PositionManager;
	private String level;
	private String employeetype;
	private String Email;
	private String Name;
	private String Surname;
	private String ENGName;
	private String ENGSurname;
	private String UserStamp;
	private String PositionDescription;
	private String PositionbyExpense;

	public String getPinManager() {
		return PinManager;
	}
	public void setPinManager(String pinManager) {
		PinManager = pinManager;
	}
	public String getPositionManager() {
		return PositionManager;
	}
	public void setPositionManager(String positionManager) {
		PositionManager = positionManager;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getEmployeetype() {
		return employeetype;
	}
	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getENGName() {
		return ENGName;
	}
	public void setENGName(String eNGName) {
		ENGName = eNGName;
	}
	public String getENGSurname() {
		return ENGSurname;
	}
	public void setENGSurname(String eNGSurname) {
		ENGSurname = eNGSurname;
	}
	public String getUserStamp() {
		return UserStamp;
	}
	public void setUserStamp(String userStamp) {
		UserStamp = userStamp;
	}
	public String getPositionDescription() {
		return PositionDescription;
	}
	public void setPositionDescription(String positionDescription) {
		PositionDescription = positionDescription;
	}
	public String getPositionbyExpense() {
		return PositionbyExpense;
	}
	public void setPositionbyExpense(String positionbyExpense) {
		PositionbyExpense = positionbyExpense;
	}
	
}
