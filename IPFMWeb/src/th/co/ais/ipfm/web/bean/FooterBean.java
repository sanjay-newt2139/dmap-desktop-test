package th.co.ais.ipfm.web.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import th.co.ais.ipfm.service.IPUserService;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;


public class FooterBean extends IPFMBaseBean {
	private static final long serialVersionUID = 1L;
	private Integer onlineUser;
	private Integer webCounter;
	
	public FooterBean(){
		init();
	}

	private void init() {
		try{
			IPUserService ipUserService = (IPUserService)JSFServiceFinderUtil.getInstance().getBean("ipUserService");
			setOnlineUser(ipUserService.getOnlineUser());
			setWebCounter(getWebCounterOnline());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public Integer getOnlineUser() {
		return onlineUser;
	}

	public void setOnlineUser(Integer onlineUser) {
		this.onlineUser = onlineUser;
	}

	public Integer getWebCounter() {		
		return webCounter;
	}

	public void setWebCounter(Integer webCounter) {
		this.webCounter = webCounter;
	}
	
	public Integer getWebCounterOnline(){
		int count = 0;
		try {
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			File file = new File(ipfmConfigBean.getWebCounterPath(),ipfmConfigBean.getWebCounterFile());
		    if(file.exists()) {
				FileReader input = new FileReader(file);
				BufferedReader bufRead = new BufferedReader(input);
				count = Integer.parseInt(bufRead.readLine().toString());
			}
		    
		    writeCountToFile(++count);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		} finally {	
		    
		}
		return count;
	}
	private void writeCountToFile(int count) {
		BufferedWriter out = null;
		try{
		    // Create file 
			IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ipfmConfigBean.getWebCounterPath()+"/"+ipfmConfigBean.getWebCounterFile()),"UTF8"));
			out.write(String.valueOf(count));
		    //Close the output stream
		    out.close();
	    }catch (Exception e){//Catch exception if any
	    	e.printStackTrace();
	    }finally{
	    	if (out!=null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	}

}
