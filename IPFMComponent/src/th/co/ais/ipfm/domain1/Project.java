package th.co.ais.ipfm.domain1;

public class Project {
	private String projectId;
	private String projectName;
	private String projectManagerPin;
	
	public Project(){
	}

	public Project(String projectId, String projectName, String projectManagerPin) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManagerPin = projectManagerPin;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectManagerPin() {
		return projectManagerPin;
	}

	public void setProjectManagerPin(String projectManagerPin) {
		this.projectManagerPin = projectManagerPin;
	}
	
}
