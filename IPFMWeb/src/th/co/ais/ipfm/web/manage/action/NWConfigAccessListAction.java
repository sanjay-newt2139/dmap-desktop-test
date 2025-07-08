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
import th.co.ais.ipfm.domain1.IpUrAccessListCdnId;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.AccessListService;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPAccessListBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.AccessListValidate;


public class NWConfigAccessListAction extends AbstractAction{
	public NWConfigAccessListAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void addAccessList(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		try {
			
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPAccessListBean cdnBean = bean.getAccessList();
		
		//TODO:NAT
        //System.out.println("inline -->>> " + lines.size());
        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
        int recordRest = 0;
        List<IpUrAccessListCdn> listCDNC = cdnService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listCDNC!=null && listCDNC.size()>0) recordRest = listCDNC.size();
         
        if((recordRest+1)>maxRecord) {     		
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
        	bean.setErrorMsg("");	
        	bean.setErrorFlag(false);
           setNetworkConfigBean(bean);
           return;
        } 
        //TODO:NAT
		
		cdnBean.setSourceIPStart(cdnBean.getSourceIPStart().trim());
		cdnBean.setSourceIPEnd(cdnBean.getSourceIPEnd().trim());
		cdnBean.setDestIPStart(cdnBean.getDestIPStart().trim());
		cdnBean.setDestIPEnd(cdnBean.getDestIPEnd().trim());
		
		
		String lastIPSource = cdnBean.getSourceIPEnd();
		int p = cdnBean.getSourceIPStart().lastIndexOf(".")+1;
		String endIp = cdnBean.getSourceIPStart().substring(0, p)+cdnBean.getSourceIPEnd();
		cdnBean.setSourceIPEnd(endIp);
		
		String lastIPDest = cdnBean.getDestIPEnd();
		p = cdnBean.getDestIPStart().lastIndexOf(".")+1;
		endIp = cdnBean.getDestIPStart().substring(0, p)+cdnBean.getDestIPEnd();
		cdnBean.setDestIPEnd(endIp);
		
		
		
		String validate = new AccessListValidate(cdnBean).validate();
		if(IPFMMessageUtils.hasMessages()){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			cdnBean.setSourceIPEnd(lastIPSource);
			cdnBean.setDestIPEnd(lastIPDest);
		} else {
		
			IpUrAccessListCdn cdn = new IpUrAccessListCdn();
			IpUrAccessListCdnId id = new IpUrAccessListCdnId();
			id.setUrNo(bean.getUrNo());
			String subURNo = cdnService.genSubUrNo(bean.getUrNo());
			id.setSubUrNo(subURNo.equals("0")?"AL00001":nextVal(subURNo));
			cdn.setId(id);
			
			
			String lastNumberSrc = cdnBean.getSourceIPStart().substring(cdnBean.getSourceIPStart().lastIndexOf("."));
			String sourceIP = (cdnBean.getSourceIPEnd().endsWith(lastNumberSrc))?cdnBean.getSourceIPStart():(cdnBean.getSourceIPStart()+"-"+lastIPSource);
			
			String lastNumberDes = cdnBean.getDestIPStart().substring(cdnBean.getDestIPStart().lastIndexOf("."));
			String destIP = (cdnBean.getDestIPEnd().endsWith(lastNumberDes))?cdnBean.getDestIPStart():(cdnBean.getDestIPStart()+"-"+lastIPDest);
			
			cdn.setSourceIp(sourceIP);
			cdn.setSourceIp1(cdnBean.getSourceIPStart());
			cdn.setSourceIp2(cdnBean.getSourceIPEnd());
			cdn.setSourceHostName(cdnBean.getSourceName());
			cdn.setSourceEmail(cdnBean.getSourceEmail());
			
			cdn.setDestIp(destIP);
			cdn.setDestIp1(cdnBean.getDestIPStart());
			cdn.setDestIp2(cdnBean.getDestIPEnd());
			cdn.setDestHostName(cdnBean.getDestName());
			cdn.setDestEmail(cdnBean.getDestEmail());
			
			cdn.setUrType("NC");
			cdn.setIsTnp(nwConfigService.isTnp(cdn.getSourceIp1()));
			if(!isRejecMode(bean)) {
				cdn.setChangeType("A");
			}
			cdn.setCreated(new Date());
			cdn.setCreatedBy(sessionUser.getIpUser().getUserId());
			cdn.setLastUpd(new Date());
			cdn.setLastUpdBy(sessionUser.getIpUser().getUserId());
			cdn.setRowId(nwConfigService.genRowId());
			cdnService.saveOrUpdate(cdn);
			
			bean.setErrorFlag(false);
			bean.setErrorMsg("");
			bean.setAccessList(new IPAccessListBean());
		}

		List<IpUrAccessListCdn> listCDN = cdnService.findByUrNo(bean.getUrNo());
		bean.setListAccessList(listCDN);
		bean.getAccessList().setCheckAll(false);
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void findSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPAccessListBean cdn = bean.getAccessList();
		try {
				String errMsg ="";
				bean.setErrorMsg(errMsg);
				bean.setErrorFlag(false);
				List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
				bean.setValidateResult(validate);
			if(!IPFMDataValidateUtil.validateIPFormat(cdn.getSourceIPStart().trim())){
				cdn.setSourceIPStart("");
				cdn.setSourceIPEnd("");
				cdn.setSourceName("");
				cdn.setSourceEmail("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"),"IP","255.255.255.255"));
				return;
			}
			IpInfo info = cdnService.getIPInfoWithUsedStatus(cdn.getSourceIPStart());
			cdn.setSourceFound("0");
			
			String stIp  = cdn.getSourceIPStart().trim();
			String endIp = cdn.getSourceIPEnd().trim();
			StringBuffer result = new StringBuffer("");
			
			if(!stIp.endsWith("."+endIp)){
				cdn.setSourceName("");
				cdn.setSourceEmail("");
				cdn.setSourceFound("1");
				
				String[]  ip = stIp.split("\\.");
				String ipStart= IPFMDataUtility.convertIpStringToBinary(stIp);
				String ipEnd = IPFMDataUtility.convertIpStringToBinary(ip[0]+"."+ip[1]+"."+ip[2]+"."+endIp);
				//List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
				boolean hasError = false;
				
				List<IpInfo> ipInfoList = cdnService.findIpInfoAssignIp(ipStart, ipEnd);
				MsgUploadError error = null;
				
				for (IpInfo ipInfo : ipInfoList) {
					if (!ipInfo.getIpStatus().equalsIgnoreCase("U")) {
						hasError = true;
						cdn.setSourceIPEnd("");
						error = new MsgUploadError();
						String[] errorMsg = new String[4];
						errorMsg[0] = ipInfo.getIpAddress();
						errorMsg[1] = ipInfo.getSystemOwnerName();
						errorMsg[2] = ipInfo.getSystemOwnerTeamName();
						errorMsg[3] = ipInfo.getIpStatusName();
						error.setErrorMsg(errorMsg);
						validate.add(error);
					}
				}
				if (hasError) {
					cdn.setSourceIPEnd("");
					bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0104")));
					//bean.setValidateResult(validate);
				}
//				int count = cdnService.fineIpinfo(ipStart, ipEnd);
//				if(count>0){
//					int countT2TeamId  = cdnService.findTier2TeamID(ipStart, ipEnd);
//					if(countT2TeamId>1){
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088")));
////						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088"));
////						result.append("<li>"+errMsg+"</li>");
////						bean.setErrorFlag(true);
//						cdn.setSourceIPEnd("");
//					}
//					int countsystemOwnerTeamID  = cdnService.findSystemOwnerTeamID(ipStart, ipEnd);
//					if(countsystemOwnerTeamID>1){
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089")));
////						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089"));
////						result.append("<li>"+errMsg+"</li>");
////						bean.setErrorFlag(true);
//						cdn.setSourceIPEnd("");
//					}
//					
////					bean.setErrorMsg(result.toString());
//					if (IPFMMessageUtils.hasMessages()) return;
//				}
					
			} else if(info!=null){
				if (info.getSystemOwner()==null || info.getSystemOwner().trim().length()==0) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"))); 
					return;
				}
				cdn.setSourceName(info.getHostName());
				cdn.setSourceEmail(info.getSystemOwnerId().getEmail());
				cdn.setSourceFound("1");
			} else {
				cdn.setSourceIPStart("");
				cdn.setSourceIPEnd("");
				cdn.setSourceName("");
				cdn.setSourceEmail("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),cdn.getSourceIPStart().trim()));
				return;
			}
			bean.setAccessList(cdn);
			setNetworkConfigBean(bean);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPAccessListBean cdn = bean.getAccessList();
		try{
			String errMsg ="";
			bean.setErrorMsg(errMsg);
			bean.setErrorFlag(false);
			bean.setValidateResult(new ArrayList<MsgUploadError>());
			if(!IPFMDataValidateUtil.validateIPFormat(cdn.getDestIPStart().trim())){
				cdn.setDestIPStart("");
				cdn.setDestIPEnd("");
				cdn.setDestName("");
				cdn.setDestEmail("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"),"IP","255.255.255.255"));
				return;
			}
			IpInfo info = cdnService.getIPInfoWithUsedStatus(cdn.getDestIPStart());
			cdn.setDestFound("0");
			
			String stIp  = cdn.getDestIPStart().trim();
			String endIp = cdn.getDestIPEnd().trim();
//			StringBuffer result = new StringBuffer("");
			
			if(!stIp.endsWith("."+endIp)){
				cdn.setDestName("");
				cdn.setDestEmail("");
				cdn.setDestFound("1");
				String[]  ip = stIp.split("\\.");
				String ipStart= IPFMDataUtility.convertIpStringToBinary(stIp);
				String ipEnd = IPFMDataUtility.convertIpStringToBinary(ip[0]+"."+ip[1]+"."+ip[2]+"."+endIp);
				
				List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
				boolean hasError = false;
				
				List<IpInfo> ipInfoList = cdnService.findIpInfoAssignIp(ipStart, ipEnd);
				MsgUploadError error = null;
				String tmpOwnerId = "";
				String tmpTeamOwnerId = "";
				for (IpInfo ipInfo : ipInfoList) {
					if (IPFMUtils.ifBlank(tmpOwnerId,"").equalsIgnoreCase("")) tmpOwnerId = ipInfo.getSystemOwner();
					if (IPFMUtils.ifBlank(tmpTeamOwnerId,"").equalsIgnoreCase("")) tmpTeamOwnerId = ipInfo.getSystemOwnerTeamId();
					if (!tmpOwnerId.equalsIgnoreCase(ipInfo.getSystemOwner())) hasError = true;
					if (tmpOwnerId.equalsIgnoreCase(ipInfo.getSystemOwner()) 
						&& !tmpTeamOwnerId.equalsIgnoreCase(ipInfo.getSystemOwnerTeamId())) hasError = true;
					if (!ipInfo.getIpStatus().equalsIgnoreCase("U")) hasError = true;
					error = new MsgUploadError();
					String[] errorMsg = new String[4];
					errorMsg[0] = ipInfo.getIpAddress();
					errorMsg[1] = ipInfo.getSystemOwnerName();
					errorMsg[2] = ipInfo.getSystemOwnerTeamName();
					errorMsg[3] = ipInfo.getIpStatusName();
					error.setErrorMsg(errorMsg);
					validate.add(error);
				}
				if (hasError) {
					cdn.setDestIPEnd("");
					bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0103")));
					bean.setValidateResult(validate);
				}
				
//				int count = cdnService.fineIpinfo(ipStart, ipEnd);
//				if(count>0){
//					int countT2TeamId  = cdnService.findTier2TeamID(ipStart, ipEnd);
//					if(countT2TeamId>1){
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088")));
////						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088"));
////						result.append("<li>"+errMsg+"</li>");
////						bean.setErrorFlag(true);
//						cdn.setDestIPEnd("");
//					}
//					int countsystemOwnerTeamID  = cdnService.findSystemOwnerTeamID(ipStart, ipEnd);
//					if(countsystemOwnerTeamID>1){
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089")));
////						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089"));
////						result.append("<li>"+errMsg+"</li>");
////						bean.setErrorFlag(true);
//						cdn.setDestIPEnd("");
//					}
//					if (IPFMMessageUtils.hasMessages()) return;
////					bean.setErrorMsg(result.toString());
//					
//				}
	
			} else if(info!=null){
				if (info.getSystemOwner()==null || info.getSystemOwner().trim().length()==0) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"))); 
					return;
				}
				cdn.setDestName(info.getHostName());
				cdn.setDestEmail(info.getSystemOwnerId().getEmail());
				cdn.setDestFound("1");
			} else {
				cdn.setDestIPStart("");
				cdn.setDestIPEnd("");
				cdn.setDestName("");
				cdn.setDestEmail("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),cdn.getDestIPStart().trim()));
				return;
			}
			bean.setAccessList(cdn);
			setNetworkConfigBean(bean);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String nextVal(String subUrNo){
		String resultString = "AL";
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
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrAccessListCdn cdn = cdnService.findAccessListCdn(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		
		IPAccessListBean cdnBean = new IPAccessListBean(); 
		cdnBean.setSearchResult(cdn);
//		cdnBean.setJobAssign(jobAssign);
		cdnBean.setJobAssignList(jobAssignList); 
		bean.setAccessList(cdnBean);
		setNetworkConfigBean(bean);
	}
	
	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",3);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrAccessListCdn> cdnList = new ArrayList<IpUrAccessListCdn>();

        
      //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord();
        int recordRest = 0;
        List<IpUrAccessListCdn> listCDNC = cdnService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listCDNC!=null && listCDNC.size()>0) recordRest = maxRecord - listCDNC.size();
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
        	IPAccessListBean cdnBean = new IPAccessListBean();
        	cdnBean.setSourceIPStart(data.get(0).trim());
        	cdnBean.setSourceIPEnd(data.get(1).trim());
        	cdnBean.setDestIPStart(data.get(2).trim());
        	cdnBean.setDestIPEnd(data.get(3).trim());
        	 
        	String validateResult = new AccessListValidate(cdnBean).validate();
        	
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
	        	IpUrAccessListCdn subUr = new IpUrAccessListCdn();
	        	
	        	// source 
	        	String sourceIp = "";
	        	if(cdnBean.getSourceIPStart().equals(cdnBean.getSourceIPEnd())){
	        		sourceIp = cdnBean.getSourceIPStart();
	        		IpInfo info = cdnService.getIPInfo(sourceIp);
	        		if(info!=null){
	        			subUr.setSourceHostName(info.getHostName());
	        			String email = (info.getSystemOwnerId().getEmail()!=null)?info.getSystemOwnerId().getEmail():"";
	        			subUr.setSourceEmail(email);
	        		} else {
	        			cdnBean.setSourceEmail("");
	        		}
	        	} else {
	        		int no = cdnBean.getSourceIPEnd().lastIndexOf(".")+1;
	                sourceIp = cdnBean.getSourceIPStart()+" - "+cdnBean.getSourceIPEnd().substring(no);
	        	}
	        	subUr.setSourceIp(sourceIp);
	        	subUr.setSourceIp1(cdnBean.getSourceIPStart());
	        	subUr.setSourceIp2(cdnBean.getSourceIPEnd());
	        	// destination
	        	String destIp = "";
	        	if(cdnBean.getDestIPStart().equals(cdnBean.getDestIPEnd())){
	        		destIp = cdnBean.getDestIPStart();
	        		IpInfo info = cdnService.getIPInfo(destIp);
	        		if(info!=null){
	        			subUr.setDestHostName(info.getHostName());
	        			String email = (info.getSystemOwnerId().getEmail()!=null)?info.getSystemOwnerId().getEmail():"";
	        			subUr.setDestEmail(email);
	        		} else {
	        			cdnBean.setDestEmail("");
	        		}
	        	} else {
	        		int no = cdnBean.getDestIPEnd().lastIndexOf(".")+1;
	        		destIp = cdnBean.getDestIPStart()+" - "+cdnBean.getDestIPEnd().substring(no);
	        	}
	        	subUr.setDestIp(destIp);
	        	subUr.setDestIp1(cdnBean.getDestIPStart());
	        	subUr.setDestIp2(cdnBean.getDestIPEnd());
	        	

	        	
				cdnList.add(subUr);
        	}
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        if(validate.size()==0){
        	for(IpUrAccessListCdn al : cdnList){
        		String subUrNo = cdnService.genSubUrNo(bean.getUrNo());
        		IpUrAccessListCdnId id = new IpUrAccessListCdnId(bean.getUrNo(), subUrNo.equals("0")?"AL00001":nextVal(subUrNo));
        		al.setId(id);
        		al.setUrType("NC");
        		al.setIsTnp(nwConfigService.isTnp(al.getSourceIp1()));
	        	al.setRowId(nwConfigService.genRowId());
	        	if(!isRejecMode(bean))
	        		al.setChangeType("A");
	        	
        		al.setCreated(new Date());
    			al.setCreatedBy(sessionUser.getIpUser().getUserId());
    			al.setLastUpd(new Date());
    			al.setLastUpdBy(sessionUser.getIpUser().getUserId());
    			cdnService.save(al);
        	}
        }
        
        List<IpUrAccessListCdn> listCDN = cdnService.findByUrNo(bean.getUrNo());
		bean.setListAccessList(listCDN);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 
	
	public void editCdnInit(){
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");
		
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
//		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrAccessListCdn cdn = cdnService.findAccessListCdn(urNo, subUrNo);

//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		
		IPAccessListBean cdnBean = bean.getAccessList();
		cdnBean.setDestEmail(cdn.getDestEmail());
		cdnBean.setDestName(cdn.getDestHostName());
		

		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			cdnBean.setRowNum(rowInt);
		}
		
		String destIps = cdn.getDestIp();
		if(destIps != null) {
			String[] ips = destIps.split("[-]");
			if(ips.length == 1) {
				cdnBean.setDestIPStart(ips[0]);
				int p = ips[0].lastIndexOf(".")+1;
				String endIp = ips[0].substring(p);
				cdnBean.setDestIPEnd(endIp);	
			} else if(ips.length > 1) {
				cdnBean.setDestIPStart(ips[0]);
				cdnBean.setDestIPEnd(ips[1]);
			}
		}

		cdnBean.setSourceEmail(cdn.getSourceEmail());
		cdnBean.setSourceName(cdn.getSourceHostName());
		String sourceIps = cdn.getSourceIp();
		if(sourceIps != null) {
			String[] ips = sourceIps.split("[-]");
			if(ips.length == 1) {
				cdnBean.setSourceIPStart(ips[0]);
				int p = ips[0].lastIndexOf(".")+1;
				String endIp = ips[0].substring(p);
				cdnBean.setSourceIPEnd(endIp);				
			} else if(ips.length > 1) {
				cdnBean.setSourceIPStart(ips[0]);
				cdnBean.setSourceIPEnd(ips[1]);
			}
		}
				
		cdnBean.setSearchResult(cdn);
//		cdnBean.setJobAssign(jobAssign);
		bean.setAccessList(cdnBean);
		cdnBean.setSubMode("EDIT");
		setNetworkConfigBean(bean);
	}
	
	public void editAccessList(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		try {
			
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPAccessListBean cdnBean = bean.getAccessList();
		
		cdnBean.setSourceIPStart(cdnBean.getSourceIPStart().trim());
		cdnBean.setSourceIPEnd(cdnBean.getSourceIPEnd().trim());
		cdnBean.setDestIPStart(cdnBean.getDestIPStart().trim());
		cdnBean.setDestIPEnd(cdnBean.getDestIPEnd().trim());
		
		
		String lastIPSource = cdnBean.getSourceIPEnd();
		int p = cdnBean.getSourceIPStart().lastIndexOf(".")+1;
		String endIp = cdnBean.getSourceIPStart().substring(0, p)+cdnBean.getSourceIPEnd();
		cdnBean.setSourceIPEnd(endIp);
		
		String lastIPDest = cdnBean.getDestIPEnd();
		p = cdnBean.getDestIPStart().lastIndexOf(".")+1;
		endIp = cdnBean.getDestIPStart().substring(0, p)+cdnBean.getDestIPEnd();
		cdnBean.setDestIPEnd(endIp);
		
		
		
		String validate = new AccessListValidate(cdnBean).validate();
		if(IPFMMessageUtils.hasMessages()){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			cdnBean.setSourceIPEnd(lastIPSource);
			cdnBean.setDestIPEnd(lastIPDest);
		} else {
		
//			IpUrAccessListCdn cdn = new IpUrAccessListCdn();
//			IpUrAccessListCdnId id = new IpUrAccessListCdnId();
//			id.setUrNo(bean.getUrNo());
//			String subURNo = cdnService.genSubUrNo(bean.getUrNo());
//			id.setSubUrNo(subURNo.equals("0")?"AL00001":nextVal(subURNo));
//			cdn.setId(id);
			
			IpUrAccessListCdn cdn = bean.getListAccessList().get(cdnBean.getRowNum());
			
			String lastNumber = cdnBean.getSourceIPStart().substring(cdnBean.getSourceIPStart().lastIndexOf("."));
			String sourceIP = (cdnBean.getSourceIPEnd().endsWith(lastNumber))?cdnBean.getSourceIPStart():(cdnBean.getSourceIPStart()+"-"+lastIPSource);
			
			lastNumber = cdnBean.getDestIPStart().substring(cdnBean.getDestIPStart().lastIndexOf("."));
			String destIP = (cdnBean.getDestIPEnd().endsWith(lastNumber))?cdnBean.getDestIPStart():(cdnBean.getDestIPStart()+"-"+lastIPDest);
			
			cdn.setSourceIp(sourceIP);
			cdn.setSourceIp1(cdnBean.getSourceIPStart());
			cdn.setSourceIp2(cdnBean.getSourceIPEnd());
			cdn.setSourceHostName(cdnBean.getSourceName());
			cdn.setSourceEmail(cdnBean.getSourceEmail());
			
			cdn.setDestIp(destIP);
			cdn.setDestIp1(cdnBean.getDestIPStart());
			cdn.setDestIp2(cdnBean.getDestIPEnd());
			cdn.setDestHostName(cdnBean.getDestName());
			cdn.setDestEmail(cdnBean.getDestEmail());
			
			cdn.setUrType("NC");
			cdn.setIsTnp(nwConfigService.isTnp(cdn.getSourceIp1()));
			if(!isRejecMode(bean))
				cdn.setChangeType("A");
			
			cdn.setCreated(new Date());
			cdn.setCreatedBy(sessionUser.getIpUser().getUserId());
			cdn.setLastUpd(new Date());
			cdn.setLastUpdBy(sessionUser.getIpUser().getUserId());
			cdn.setRowId(nwConfigService.genRowId());
			cdnService.saveOrUpdate(cdn);
			
			bean.setErrorFlag(false);
			bean.setErrorMsg("");
			bean.setAccessList(new IPAccessListBean());
			cdnBean.setSubMode("ADD");
		}

		List<IpUrAccessListCdn> listCDN = cdnService.findByUrNo(bean.getUrNo());
		bean.setListAccessList(listCDN);
		bean.getAccessList().setCheckAll(false);
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	
//	public void editCdn(){
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		UserSession sessionUser = IPFMWebUtil.getUserSession();
//		try {
//		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
//		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
//		IPAccessListBean cdnBean = bean.getAccessList();
//		
//		cdnBean.setSourceIPStart(cdnBean.getSourceIPStart().trim());
//		cdnBean.setSourceIPEnd(cdnBean.getSourceIPEnd().trim());
//		cdnBean.setDestIPStart(cdnBean.getDestIPStart().trim());
//		cdnBean.setDestIPEnd(cdnBean.getDestIPEnd().trim());
//		
//		
//		String lastIPSource = cdnBean.getSourceIPEnd();
//		int p = cdnBean.getSourceIPStart().lastIndexOf(".")+1;
//		String endIp = cdnBean.getSourceIPStart().substring(0, p)+cdnBean.getSourceIPEnd();
//		cdnBean.setSourceIPEnd(endIp);
//		
//		String lastIPDest = cdnBean.getDestIPEnd();
//		p = cdnBean.getDestIPStart().lastIndexOf(".")+1;
//		endIp = cdnBean.getDestIPStart().substring(0, p)+cdnBean.getDestIPEnd();
//		cdnBean.setDestIPEnd(endIp);
//		
//		
//		
//		String validate = new AccessListValidate(cdnBean).validate();
//		if (IPFMMessageUtils.hasMessages()) {
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//			return;
//		}
//		if(!validate.equals("")){
////				bean.setErrorMsg(validate);
////				bean.setErrorFlag(true);
//		} else {
//			IpUrAccessListCdn cdn = cdnBean.getSearchResult();
//			
//			String lastNumber = cdnBean.getSourceIPStart().substring(cdnBean.getSourceIPStart().lastIndexOf("."));
//			String sourceIP = (cdnBean.getSourceIPEnd().endsWith(lastNumber))?cdnBean.getSourceIPStart():(cdnBean.getSourceIPStart()+"-"+lastIPSource);
//			
//			lastNumber = cdnBean.getDestIPStart().substring(cdnBean.getDestIPStart().lastIndexOf("."));
//			String destIP = (cdnBean.getDestIPEnd().endsWith(lastNumber))?cdnBean.getDestIPStart():(cdnBean.getDestIPStart()+"-"+lastIPDest);
//			
//			cdn.setSourceIp(sourceIP);
//			cdn.setSourceIp1(cdnBean.getSourceIPStart());
//			cdn.setSourceIp2(cdnBean.getSourceIPEnd());
//			cdn.setSourceHostName(cdnBean.getSourceName());
//			cdn.setSourceEmail(cdnBean.getSourceEmail());
//			
//			cdn.setDestIp(destIP);
//			cdn.setDestIp1(cdnBean.getDestIPStart());
//			cdn.setDestIp2(cdnBean.getDestIPEnd());
//			cdn.setDestHostName(cdnBean.getDestName());
//			cdn.setDestEmail(cdnBean.getDestEmail());
//			
//			cdn.setUrType("NC");
//			cdn.setIsTnp(nwConfigService.isTnp(cdn.getSourceIp1()));
//			cdn.setChangeType("A");
////			cdn.setCreated(new Date());
////			cdn.setCreatedBy(sessionUser.getIpUser().getUserId());
//			cdn.setLastUpd(new Date());
//			cdn.setLastUpdBy(sessionUser.getIpUser().getUserId());
//			cdn.setRowId(nwConfigService.genRowId());
//			cdnService.saveOrUpdate(cdn);
//			
//			bean.setErrorFlag(false);
//			bean.setErrorMsg("");
//			bean.setAccessList(new IPAccessListBean());
//		}
//
//		List<IpUrAccessListCdn> listCDN = cdnService.findByUrNo(bean.getUrNo());
//		bean.setListAccessList(listCDN);
//		setNetworkConfigBean(bean);
//		
//		}catch (Exception e) {
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
//		}
//	}	
	
	public void deleteCDN(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
		IpUrAccessListCdn accessList = cdnService.findAccessListCdn(urNo, subUrNo);
		String changeType = (accessList.getChangeType()!=null)?accessList.getChangeType():""; 
		if(changeType.equals("A")){
			cdnService.delete(accessList);
		} else {
			accessList.setChangeType("D");
			try {
				cdnService.update(accessList);
			} catch (IPFMBusinessException e) {
				e.printStackTrace();
			}
		}
		List<IpUrAccessListCdn> listCDN = cdnService.findByUrNo(bean.getUrNo());
		bean.getAccessList().setSubMode("ADD");
		bean.setListAccessList(listCDN);
		
		IPAccessListBean cdnBean = bean.getAccessList();
		cdnBean.setDestEmail("");
		cdnBean.setDestFound("");
		cdnBean.setDestIPEnd("");
		cdnBean.setDestIPStart("");
		cdnBean.setDestName("");
		cdnBean.setSourceEmail("");
		cdnBean.setSourceFound("");
		cdnBean.setSourceIPEnd("");
		cdnBean.setSourceIPStart("");
		cdnBean.setSourceName("");
		cdnBean.setCheckAll(false);
		setNetworkConfigBean(bean);
		
	}
	
	public void clearSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPAccessListBean cdn = bean.getAccessList();
		cdn.setSourceFound("0");
		cdn.setSourceIPStart("");
		cdn.setSourceIPEnd("");
		cdn.setSourceName("");
		cdn.setSourceEmail("");
		bean.setAccessList(cdn);
		setNetworkConfigBean(bean);		
	}
	
	public void clearDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPAccessListBean cdn = bean.getAccessList();
		cdn.setDestFound("0");
		cdn.setDestIPStart("");
		cdn.setDestIPEnd("");
		cdn.setDestName("");
		cdn.setDestEmail("");
		bean.setAccessList(cdn);
		setNetworkConfigBean(bean);		
	}

	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestAcessListCDN();
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
	        String fileName = ipfmConfigBean.getTemplateRequestAcessListCDN();
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
