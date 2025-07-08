package th.co.ais.ipfm.web.util;

import org.apache.commons.fileupload.ProgressListener;

public class FileUploadListener implements ProgressListener{
	private volatile long bytesRead = 0L;
	private volatile long contentLength = 0L;
	private volatile long item = 0L;   

  public FileUploadListener(){
    super();
  }

  public void update(long aBytesRead, long aContentLength,int anItem){ // DMAP Comment : Dead Code Detected - The Following Method has no reference update
    bytesRead = aBytesRead;
    contentLength = aContentLength;
    item = anItem;
 }

  public long getBytesRead(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getBytesRead
    return bytesRead;
  }

  public long getContentLength(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getContentLength
    return contentLength;
  }

  public long getItem(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getItem
    return item;
  }
}
