package th.co.ais.ipfm.web.bean;

import javax.faces.event.ActionEvent;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class TMHFileUploadBean {
	
	private UploadedFile uploadedFile;
	private String uploadedFilename;
	public UploadedFile getUploadedFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUploadedFile
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUploadedFile
		this.uploadedFile = uploadedFile;
	}
	public String getUploadedFilename() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUploadedFilename
		return uploadedFilename;
	}
	public void setUploadedFilename(String uploadedFilename) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUploadedFilename
		this.uploadedFilename = uploadedFilename;
	}
	
	public void uploadFile(final ActionEvent event) { // DMAP Comment : Dead Code Detected - The Following Method has no reference uploadFile
		if (null != this.uploadedFile) {
			System.out.println("file-size '"+this.uploadedFile.getSize()+"'");
	    }
	}

}
