package th.co.ais.ipfm.web.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class SystemParams extends AbstractAction implements Serializable{

	private static final long serialVersionUID = 1L;

	public void checkFile() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	         File file = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUserManualFile());
	        if (!file.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
	        File file2 = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUserManualFile2());
	        if (!file2.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	public String getManualDownloadURL(){
//		System.out.println("------------getManualDownloadURL------------");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		try {
			File file = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUserManualFile());
			if (!file.isFile()) { //IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
			}else{ downloadFile(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUserManualFile()); }
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0057") , ipfmConfigBean.getIpfmUserManualFile()));
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
		return getRequestParameter("programIDParam");
//		IIPParameterService paramService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
//		return paramService.getDownloadDocumentURL();
		
	}
		
	public String getManualDownloadURL2(){
//		System.out.println("------------getManualDownloadURL------------");
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		try {
			File file = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUserManualFile2());
			if (!file.isFile()) { //IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
			}else{ downloadFile(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUserManualFile2()); }
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0057") , ipfmConfigBean.getIpfmUserManualFile2()));
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
		return getRequestParameter("programIDParam");
//		IIPParameterService paramService = (IIPParameterService)JSFServiceFinderUtil.getInstance().getBean("ipParameterService");
//		return paramService.getDownloadDocumentURL();
		
	}
	
	public String getDownloadIPFMtraining(){
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		try {
			File file = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmtraininglFile());
			if (!file.isFile()) { 
			}else{ downloadFile(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmtraininglFile()); }
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0057") , ipfmConfigBean.getIpfmtraininglFile()));
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
		return getRequestParameter("programIDParam");
		
	}
	
	public String getDownloadNWRequest(){
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		try {
			File file = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmRequestNwFile());
			if (!file.isFile()) { 
			}else{ downloadFile(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmRequestNwFile()); }
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0057") , ipfmConfigBean.getIpfmRequestNwFile()));
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
		return getRequestParameter("programIDParam");
		
	}
	
	public String getDownloadURStatus(){
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		try {
			File file = new File(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUrStatusFile());
			if (!file.isFile()) {
			}else{ downloadFile(ipfmConfigBean.getIpfmUserManualPath(),ipfmConfigBean.getIpfmUrStatusFile()); }
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0057") , ipfmConfigBean.getIpfmUrStatusFile()));
		} catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
		return getRequestParameter("programIDParam");
		
	}
	
	public String getUserProfileProgram(){
		return "IPURS007_01";
	}

	@Override
	public String init() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String init(String programID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
}
