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

	public String getProjectId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectId
		return projectId;
	}

	public void setProjectId(String projectId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectId
		this.projectId = projectId;
	}

	public String getProjectName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectName
		return projectName;
	}

	public void setProjectName(String projectName) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectName
		this.projectName = projectName;
	}

	public String getProjectManagerPin() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProjectManagerPin
		return projectManagerPin;
	}

	public void setProjectManagerPin(String projectManagerPin) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProjectManagerPin
		this.projectManagerPin = projectManagerPin;
	}
	
}
