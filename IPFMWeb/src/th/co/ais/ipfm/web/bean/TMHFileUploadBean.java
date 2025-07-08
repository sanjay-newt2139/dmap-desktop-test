package th.co.ais.ipfm.web.bean;

import javax.faces.event.ActionEvent;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class TMHFileUploadBean {
	
	private UploadedFile uploadedFile;
	private String uploadedFilename;
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	public String getUploadedFilename() {
		return uploadedFilename;
	}
	public void setUploadedFilename(String uploadedFilename) {
		this.uploadedFilename = uploadedFilename;
	}
	
	public void uploadFile(final ActionEvent event) {
		if (null != this.uploadedFile) {
			System.out.println("file-size '"+this.uploadedFile.getSize()+"'");
	    }
	}

}
