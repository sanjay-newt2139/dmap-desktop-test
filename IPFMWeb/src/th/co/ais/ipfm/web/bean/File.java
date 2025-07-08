package th.co.ais.ipfm.web.bean;

import java.io.Serializable;

public class File implements Serializable{
	private String Name;
    private String mime;
    private long length;
    private byte[] data;
    public byte[] getData() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getData
        return data;
    }
    public void setData(byte[] data) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setData
        this.data = data;
    }
    public String getName() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getName
        return Name;
    }
    public void setName(String name) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setName
        Name = name;
        int extDot = name.lastIndexOf('.');
        if(extDot > 0){
            String extension = name.substring(extDot +1);
            if("bmp".equals(extension)){
                mime="image/bmp";
            } else if("jpg".equals(extension)){
                mime="image/jpeg";
            } else if("gif".equals(extension)){
                mime="image/gif";
            } else if("png".equals(extension)){
                mime="image/png";
            } else if("xls".equals(extension)){
            	mime="application/vnd.ms-excel";
            } else if("doc".equals(extension)){
            	mime="application/msword";
            } else {
                mime = "image/unknown";
            }
        }
    }
    public long getLength() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLength
        return length;
    }
    public void setLength(long length) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLength
        this.length = length;
    }
    
    public String getMime(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getMime
        return mime;
    }
}
