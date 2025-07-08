package th.co.ais.ipfm.web.master.bean;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.web.bean.File;

public class SystemParameterFileUploadBean implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6896023696600485084L;
	private ArrayList<File> files = new ArrayList<File>();
    private int uploadsAvailable = 1;
    private boolean autoUpload = false;
    private boolean useFlash = false;
    private String acceptedTypes = "xls";
    private String acceptedTypesImg = "jpg, gif, png";
    private boolean displayImportForm = true;
    
    public String getAcceptedTypesImg() {
		return acceptedTypesImg;
	}

	public void setAcceptedTypesImg(String acceptedTypesImg) {
		this.acceptedTypesImg = acceptedTypesImg;
	}

	public boolean isDisplayImportForm() {
		if(uploadsAvailable>0){
			return true;
		}else{
			return false;
		}
	}

	public void setDisplayImportForm(boolean displayImportForm) {
		this.displayImportForm = displayImportForm;
	}

	public String getAcceptedTypes() {
		return acceptedTypes;
	}

	public void setAcceptedTypes(String acceptedTypes) {
		this.acceptedTypes = acceptedTypes;
	}

	public int getSize() {
        if (getFiles().size()>0){
            return getFiles().size();
        }else 
        {
            return 0;
        }
    }

    public SystemParameterFileUploadBean() {
    }

    public long getTimeStamp(){
        return System.currentTimeMillis();
    }
    
    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) { 
        this.files = files;
    }

    public int getUploadsAvailable() {
        return uploadsAvailable;
    }

    public void setUploadsAvailable(int uploadsAvailable) {
        this.uploadsAvailable = uploadsAvailable;
    }

    public boolean isAutoUpload() {
        return autoUpload;
    }

    public void setAutoUpload(boolean autoUpload) {
        this.autoUpload = autoUpload;
    }

    public boolean isUseFlash() {
        return useFlash;
    }

    public void setUseFlash(boolean useFlash) {
        this.useFlash = useFlash;
    }

}
