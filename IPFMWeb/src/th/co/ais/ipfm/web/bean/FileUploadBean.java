package th.co.ais.ipfm.web.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class FileUploadBean implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6896023696600485084L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private ArrayList<File> files = new ArrayList<File>();
    private int uploadsAvailable = 1;
    private boolean autoUpload = false;
    private boolean useFlash = false;
    private String acceptedTypes = "xls,xlsx";
    private boolean displayImportForm = true;
    
    public boolean isDisplayImportForm() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isDisplayImportForm
		if(uploadsAvailable>0){
			return true;
		}else{
			return false;
		}
	}

	public void setDisplayImportForm(boolean displayImportForm) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setDisplayImportForm
		this.displayImportForm = displayImportForm;
	}

	public String getAcceptedTypes() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAcceptedTypes
		return acceptedTypes;
	}

	public void setAcceptedTypes(String acceptedTypes) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAcceptedTypes
		this.acceptedTypes = acceptedTypes;
	}

	public int getSize() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSize
        if (getFiles().size()>0){
            return getFiles().size();
        }else 
        {
            return 0;
        }
    }

    public FileUploadBean() {
    }

    public long getTimeStamp(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getTimeStamp
        return System.currentTimeMillis();
    }
    
    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {  // DMAP Comment : Dead Code Detected - The Following Method has no reference setFiles
        this.files = files;
    }

    public int getUploadsAvailable() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUploadsAvailable
        return uploadsAvailable;
    }

    public void setUploadsAvailable(int uploadsAvailable) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUploadsAvailable
        this.uploadsAvailable = uploadsAvailable;
    }

    public boolean isAutoUpload() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isAutoUpload
        return autoUpload;
    }

    public void setAutoUpload(boolean autoUpload) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAutoUpload
        this.autoUpload = autoUpload;
    }

    public boolean isUseFlash() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isUseFlash
        return useFlash;
    }

    public void setUseFlash(boolean useFlash) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUseFlash
        this.useFlash = useFlash;
    }
}
