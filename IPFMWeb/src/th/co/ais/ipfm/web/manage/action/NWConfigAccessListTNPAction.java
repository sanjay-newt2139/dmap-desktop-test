package th.co.ais.ipfm.web.manage.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUrAccessListCdn;
import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpUrAccessListTnpId;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.AccessListService;
import th.co.ais.ipfm.service.AccessListTNPService;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPAccessListTNPBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.AccessListTNPValidate;


public class NWConfigAccessListTNPAction extends AbstractAction{
	public NWConfigAccessListTNPAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void editAccessListTNP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		try {
		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPAccessListTNPBean tnpBean = bean.getAccessListTNP();
		
		String validate = new AccessListTNPValidate(tnpBean).validate();
		if (IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return; 
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
	//			IpUrAccessListTnp tnp = new IpUrAccessListTnp();
	//			IpUrAccessListTnpId id = new IpUrAccessListTnpId();
	//			id.setUrNo(bean.getUrNo());
	//			String subURNo = tnpService.genSubUrNo(bean.getUrNo());
	//			id.setSubUrNo(subURNo.equals("0")?"AT00001":nextVal(subURNo));
	//			tnp.setId(id);
			IpUrAccessListTnp tnp = bean.getListAccessTNP().get(tnpBean.getRowNum());
			
			tnp.setSourceIp(tnpBean.getSourceIP());
			tnp.setSourceHostName(tnpBean.getSourceHostName());
			tnp.setSourceLocationName(tnpBean.getSourceLocation());
			tnp.setSourceNetworkIp(tnpBean.getSourceNetwork());
			tnp.setSourceInterNode(tnpBean.getSourceInterfaceNode());
			tnp.setSourceInterNw(tnpBean.getSourceInterfaceNetwork());
			
			tnp.setDestIp(tnpBean.getDestIP());
			tnp.setDestHostName(tnpBean.getDestHostName());
			tnp.setDestLocationName(tnpBean.getDestLocation());
			tnp.setDestNetworkIp(tnpBean.getDestNetwork());
			tnp.setDestInterNode(tnpBean.getDestInterfaceNode());
			tnp.setDestInterNw(tnpBean.getDestInterfaceNetwork());
			
			tnp.setDescription(tnpBean.getDescription());
			tnp.setReqImpact(tnpBean.getImpact());
			
			tnp.setIsTnp(nwConfigService.isTnp(tnp.getSourceIp()));
			tnp.setUrType("NC");
			if(!isRejecMode(bean))
				tnp.setChangeType("A");
	
			tnp.setCreated(new Date());
			tnp.setCreatedBy(sessionUser.getIpUser().getUserId());
			tnp.setRowId(nwConfigService.genRowId());
			tnpService.saveOrUpdate(tnp);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			bean.setAccessListTNP(new IPAccessListTNPBean());
			bean.getAccessListTNP().setCheckAll(false);
			tnpBean.setSubMode("ADD");
		}

		List<IpUrAccessListTnp> listTNP = tnpService.findByUrNo(bean.getUrNo());
		bean.setListAccessTNP(listTNP);
		
		setNetworkConfigBean(bean);
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}	
	
	public void addAccessListTNP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		try {
		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPAccessListTNPBean tnpBean = bean.getAccessListTNP();
		
		//TODO:NAT
        //System.out.println("inline -->>> " + lines.size());
        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
        int recordRest = 0;
        List<IpUrAccessListTnp> listTNPC = tnpService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listTNPC!=null && listTNPC.size()>0) recordRest = listTNPC.size();
         
        if((recordRest+1)>maxRecord) {     		
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
        	bean.setErrorMsg("");	
        	bean.setErrorFlag(false);
           setNetworkConfigBean(bean);
           return;
        } 
        //TODO:NAT
        
		String validate = new AccessListTNPValidate(tnpBean).validate();
		if (IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return; 
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
			IpUrAccessListTnp tnp = new IpUrAccessListTnp();
			IpUrAccessListTnpId id = new IpUrAccessListTnpId();
			id.setUrNo(bean.getUrNo());
			String subURNo = tnpService.genSubUrNo(bean.getUrNo());
			id.setSubUrNo(subURNo.equals("0")?"AT00001":nextVal(subURNo));
			tnp.setId(id);
			
			
			
			tnp.setSourceIp(tnpBean.getSourceIP());
			tnp.setSourceHostName(tnpBean.getSourceHostName());
			tnp.setSourceLocationName(tnpBean.getSourceLocation());
			tnp.setSourceNetworkIp(tnpBean.getSourceNetwork());
			tnp.setSourceInterNode(tnpBean.getSourceInterfaceNode());
			tnp.setSourceInterNw(tnpBean.getSourceInterfaceNetwork());
			
			tnp.setDestIp(tnpBean.getDestIP());
			tnp.setDestHostName(tnpBean.getDestHostName());
			tnp.setDestLocationName(tnpBean.getDestLocation());
			tnp.setDestNetworkIp(tnpBean.getDestNetwork());
			tnp.setDestInterNode(tnpBean.getDestInterfaceNode());
			tnp.setDestInterNw(tnpBean.getDestInterfaceNetwork());
			
			tnp.setDescription(tnpBean.getDescription());
			tnp.setReqImpact(tnpBean.getImpact());
			
			tnp.setIsTnp(nwConfigService.isTnp(tnp.getSourceIp()));
			tnp.setUrType("NC");
			if(!isRejecMode(bean))
				tnp.setChangeType("A");
	
			tnp.setCreated(new Date());
			tnp.setCreatedBy(sessionUser.getIpUser().getUserId());
			tnp.setRowId(nwConfigService.genRowId());
			tnpService.saveOrUpdate(tnp);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			bean.setAccessListTNP(new IPAccessListTNPBean());
		}

		List<IpUrAccessListTnp> listTNP = tnpService.findByUrNo(bean.getUrNo());
		bean.setListAccessTNP(listTNP);
		bean.getAccessListTNP().setCheckAll(false);
		setNetworkConfigBean(bean);
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void findSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPAccessListTNPBean tnp = bean.getAccessListTNP();
		
		IpInfo info = cdnService.getIPInfoWithUsedStatus(tnp.getSourceIP());
		tnp.setSourceFound("0");
		if(info!=null){
			tnp.setSourceHostName(info.getHostName());
			tnp.setSourceLocation(info.getLocationName());
			tnp.setSourceNetwork(info.getNetworkIp());
			tnp.setSourceFound("1");
		}
		bean.setAccessListTNP(tnp);
		setNetworkConfigBean(bean);
	}
	
	public void findDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPAccessListTNPBean tnp = bean.getAccessListTNP();
		
		IpInfo info = cdnService.getIPInfoWithUsedStatus(tnp.getDestIP());
		tnp.setDestFound("0");
		if(info!=null){
			tnp.setDestHostName(info.getHostName());
			tnp.setDestLocation(info.getLocationName());
			tnp.setDestNetwork(info.getNetworkIp());
			tnp.setDestFound("1");
		}
		bean.setAccessListTNP(tnp);
		setNetworkConfigBean(bean);	
	}
	
	private String nextVal(String subUrNo){
		String resultString = "AT";
		int no =  Integer.parseInt(subUrNo.substring(2));
		String nnn = String.valueOf(++no);
		for(int i=0;i<5-nnn.length();i++) resultString+="0";
		resultString+=nnn;
		return resultString;
	}
	
	public void findSubUr(){
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrAccessListTnp tnp = tnpService.findAccessListTnp(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		IPAccessListTNPBean tnpBean = new IPAccessListTNPBean();
		tnpBean.setSearchResult(tnp);
//		tnpBean.setJobAssign(jobAssign);
		tnpBean.setJobAssignList(jobAssignList);
		bean.setAccessListTNP(tnpBean);
		setNetworkConfigBean(bean);
	}

	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",2);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrAccessListTnp> tnpList = new ArrayList<IpUrAccessListTnp>();

      //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord();
        int recordRest = 0;
        List<IpUrAccessListTnp> listTNPC = tnpService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listTNPC!=null && listTNPC.size()>0) recordRest = maxRecord - listTNPC.size();
        else recordRest = maxRecord;
        
        if(lines!=null && lines.size()>recordRest) {
        	MsgUploadError error = new MsgUploadError();
    		error.setRowNumber("-");
    		error.setDescription(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
    		validate.add(error);
    		
        	ReqNWConfigBean bean = getNetworkConfigBean();        	
        	bean.setValidateResult(validate);
            bean.setErrorFlag(true);
            setNetworkConfigBean(bean);
            return;
        } 
        //TODO:NAT
        
        for(int pos=0;pos<lines.size();pos++){
            boolean hasError = false;
        	Map<Integer,String> data = (Map<Integer,String>)lines.get(pos);
        	IPAccessListTNPBean tnpBean = new IPAccessListTNPBean();
        	tnpBean.setSourceInterfaceNode(data.get(4));
        	tnpBean.setSourceInterfaceNetwork(data.get(5));
        	tnpBean.setSourceIP(data.get(6));
        	tnpBean.setDestInterfaceNode(data.get(9));
        	tnpBean.setDestInterfaceNetwork(data.get(8));
        	tnpBean.setDestIP(data.get(7));
        	tnpBean.setDescription(data.get(13));
        	tnpBean.setImpact(data.get(14));
        	 
        	String validateResult = new AccessListTNPValidate(tnpBean).validate();
        	
        	if((validateResult!=null) && !validateResult.equals("")){
        		MsgUploadError error = new MsgUploadError();
        		error.setRowNumber(String.valueOf(pos+1));
        		error.setDescription(validateResult);
        		validate.add(error);
        		System.out.println("Error inline "+error.getRowNumber());
        		System.out.println("Error Msg >> "+error.getDescription());
        		hasError = true;
        	}
        	
        	if(!hasError){
	        	IpUrAccessListTnp subUr = new IpUrAccessListTnp();
	        	
	        	subUr.setSourceIp(tnpBean.getSourceIP());
	        	subUr.setSourceInterNode(tnpBean.getSourceInterfaceNode());
	        	subUr.setSourceInterNw(tnpBean.getSourceInterfaceNetwork());
				
	        	subUr.setDestIp(tnpBean.getDestIP());
	        	subUr.setDestInterNode(tnpBean.getDestInterfaceNode());
	        	subUr.setDestInterNw(tnpBean.getDestInterfaceNetwork());
				
	        	subUr.setDescription(tnpBean.getDescription());
	        	subUr.setReqImpact(tnpBean.getImpact());
	        	
	        	// source 
	        	IpInfo infoSource = tnpService.getIPInfo(tnpBean.getSourceIP());
	        	if(infoSource!=null){
	        		subUr.setSourceHostName(infoSource.getHostName());
	        		subUr.setSourceLocationName(infoSource.getLocationName());
	        		subUr.setSourceNetworkIp(infoSource.getNetworkIp());
	        	}

	        	
	        	// destination
	        	IpInfo infoDest = tnpService.getIPInfo(tnpBean.getDestIP());
	        	if(infoDest!=null){
	        		subUr.setDestHostName(infoDest.getHostName());
	        		subUr.setDestLocationName(infoDest.getLocationName());
	        		subUr.setDestNetworkIp(infoDest.getNetworkIp());
	        	}
	        	tnpList.add(subUr);
        	}
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        if(validate.size()==0){
        	for(IpUrAccessListTnp at : tnpList){
        		String subUrNo = tnpService.genSubUrNo(bean.getUrNo());
        		IpUrAccessListTnpId id = new IpUrAccessListTnpId(bean.getUrNo(), subUrNo.equals("0")?"AT00001":nextVal(subUrNo));
        		at.setId(id);
        		at.setUrType("NC");
        		at.setIsTnp(nwConfigService.isTnp(at.getSourceIp()));
	        	at.setRowId(nwConfigService.genRowId());
	        	if(!isRejecMode(bean))
	        		at.setChangeType("A");
	        	
        		at.setCreated(new Date());
    			at.setCreatedBy(sessionUser.getIpUser().getUserId());
    			tnpService.saveOrUpdate(at);
        	}
        }
        
        List<IpUrAccessListTnp> listTNP = tnpService.findByUrNo(bean.getUrNo());
		bean.setListAccessTNP(listTNP);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 
	
	public void editTnpInit(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");
		//FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
		
		IpUrAccessListTnp tnp = tnpService.findAccessListTnp(urNo, subUrNo);
		IPAccessListTNPBean atBean = bean.getAccessListTNP();
		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			atBean.setRowNum(rowInt);
		}	
		atBean.setSearchResult(tnp);
		atBean.setSourceIP(tnp.getSourceIp());
		atBean.setSourceHostName(tnp.getSourceHostName());
		atBean.setSourceLocation(tnp.getSourceLocationName());
		atBean.setSourceNetwork(tnp.getSourceNetworkIp());
		atBean.setSourceInterfaceNode(tnp.getSourceInterNode());
		atBean.setSourceInterfaceNetwork(tnp.getSourceInterNw());
		
		atBean.setDestIP(tnp.getDestIp());
		atBean.setDestHostName(tnp.getDestHostName());
		atBean.setDestLocation(tnp.getDestLocationName());
		atBean.setDestNetwork(tnp.getDestNetworkIp());
		atBean.setDestInterfaceNode(tnp.getDestInterNode());
		atBean.setDestInterfaceNetwork(tnp.getDestInterNw());
		
		atBean.setDescription(tnp.getDescription());
		atBean.setImpact(tnp.getReqImpact());
		atBean.setSubMode("EDIT");
		bean.setAccessListTNP(atBean);
		
		setNetworkConfigBean(bean);
	}
	
//	public void editTnp(){
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		UserSession sessionUser = IPFMWebUtil.getUserSession();
//		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
//		String urNo = getRequestParameter("urNo");
//		String subUrNo = getRequestParameter("subUrNo");
//		
//
//		IPAccessListTNPBean tnpBean = bean.getAccessListTNP();
//		
//		String validate = new AccessListTNPValidate(tnpBean).validate();
//		if (IPFMMessageUtils.hasMessages()) {
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//			return;
//		}
//		if(!validate.equals("")){
////				bean.setErrorMsg(validate);
////				bean.setErrorFlag(true);
//		} else {
//			IpUrAccessListTnp tnp = tnpBean.getSearchResult();
//			
//			tnp.setSourceIp(tnpBean.getSourceIP());
//			tnp.setSourceHostName(tnpBean.getSourceHostName());
//			tnp.setSourceLocationName(tnpBean.getSourceLocation());
//			tnp.setSourceNetworkIp(tnpBean.getSourceNetwork());
//			tnp.setSourceInterNode(tnpBean.getSourceInterfaceNode());
//			tnp.setSourceInterNw(tnpBean.getSourceInterfaceNetwork());
//			
//			tnp.setDestIp(tnpBean.getDestIP());
//			tnp.setDestHostName(tnpBean.getDestHostName());
//			tnp.setDestLocationName(tnpBean.getDestLocation());
//			tnp.setDestNetworkIp(tnpBean.getDestNetwork());
//			tnp.setDestInterNode(tnpBean.getDestInterfaceNode());
//			tnp.setDestInterNw(tnpBean.getDestInterfaceNetwork());
//			
//			tnp.setDescription(tnpBean.getDescription());
//			tnp.setReqImpact(tnpBean.getImpact());
//	
//			tnp.setLastUpd(new Date());
//			tnp.setLastUpdBy(sessionUser.getIpUser().getUserId());
//			tnpService.saveOrUpdate(tnp);
//			
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//		}
//
//		List<IpUrAccessListTnp> listTNP = tnpService.findByUrNo(bean.getUrNo());
//		bean.setListAccessTNP(listTNP);
//		bean.setAccessListTNP(new IPAccessListTNPBean());
//		setNetworkConfigBean(bean);
//	}
	
	public void deleteTNP(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
		IpUrAccessListTnp tnp = tnpService.findAccessListTnp(urNo, subUrNo);
		String changeType = (tnp.getChangeType()!=null)?tnp.getChangeType():""; 
		if(changeType.equals("A")){
			tnpService.delete(tnp);
		} else {
			tnp.setChangeType("D");
			tnpService.update(tnp);
		}
		List<IpUrAccessListTnp> listTNP = tnpService.findByUrNo(bean.getUrNo());
		bean.setListAccessTNP(listTNP);
		bean.getAccessListTNP().setDescription("");
		bean.getAccessListTNP().setDestFound("");
		bean.getAccessListTNP().setDestHostName("");
		bean.getAccessListTNP().setDestInterfaceNetwork("");
		bean.getAccessListTNP().setDestInterfaceNode("");
		bean.getAccessListTNP().setDestIP("");
		bean.getAccessListTNP().setDestLocation("");
		bean.getAccessListTNP().setDestNetwork("");
		
		bean.getAccessListTNP().setImpact("");
		bean.getAccessListTNP().setSourceFound("");
		bean.getAccessListTNP().setSourceHostName("");
		bean.getAccessListTNP().setSourceInterfaceNetwork("");
		bean.getAccessListTNP().setSourceInterfaceNode("");
		bean.getAccessListTNP().setSourceIP("");
		bean.getAccessListTNP().setSourceNetwork("");
		bean.getAccessListTNP().setSourceLocation("");		
		bean.getAccessListTNP().setSubMode("ADD");
		
		bean.getAccessListTNP().setCheckAll(false);
		setNetworkConfigBean(bean);
		
	}
	
	public void clearSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPAccessListTNPBean tnp = bean.getAccessListTNP();
		tnp.setSourceFound("0");
		tnp.setSourceIP("");
		tnp.setSourceHostName("");
		tnp.setSourceLocation("");
		tnp.setSourceNetwork("");

		bean.setAccessListTNP(tnp);
		setNetworkConfigBean(bean);		
	}
	
	public void clearDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPAccessListTNPBean tnp = bean.getAccessListTNP();
		tnp.setDestFound("0");
		tnp.setDestIP("");
		tnp.setDestHostName("");
		tnp.setDestLocation("");
		tnp.setDestNetwork("");
		bean.setAccessListTNP(tnp);
		setNetworkConfigBean(bean);		
	}
	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestAccessListTNP();
	        File file = new File(path,fileName);
	        if (!file.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }

	
	public void downloadTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestAccessListTNP();
	        downloadFile(path, fileName);	        
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
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
