package th.co.ais.ipfm.web.manage.action;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPFirewallBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.FirewallValidate;


public class NWConfigFirewallAction extends AbstractAction{
	public NWConfigFirewallAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void toggleTCPField(ActionEvent event) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPFirewallBean fwBean = bean.getFirewall();
		boolean t = fwBean.getTcpCheck();
		//fwBean.setTcpCheck(t ? false : true);
		if(!t) {
			fwBean.setTcpPort("");
		}
	}

	public void toggleUDPField(ActionEvent event) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPFirewallBean fwBean = bean.getFirewall();
		boolean t = fwBean.getUdpCheck();
		//fwBean.setUdpCheck(t ? false : true);
		if(!t) {
			fwBean.setTcpPort("");
		}
	}
	
	public void toggleOtherField(ActionEvent event) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPFirewallBean fwBean = bean.getFirewall();
		boolean t = fwBean.getOtherCheck();
		//fwBean.setOtherCheck(t ? false : true);		
		if(!t) {
			fwBean.setTcpPort("");
		}
	}
	
	public void editFirewall(ActionEvent event) {
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
     try{
		String tcpPortHidden = getRequestParameter("tcpPortHidden");
		
		IPFirewallBean fwBean = bean.getFirewall();
		
		fwBean.setSourceIPStart(fwBean.getSourceIPStart().trim());
		fwBean.setSourceIpEndDisp(fwBean.getSourceIpEndDisp().trim());
		fwBean.setDestIPStart(fwBean.getDestIPStart().trim());
		fwBean.setDestIpEndDisp(fwBean.getDestIpEndDisp().trim());


			String lastIPSource = fwBean.getSourceIpEndDisp();
			int p = fwBean.getSourceIPStart().lastIndexOf(".")+1;
			String endIp = fwBean.getSourceIPStart().substring(0, p)+lastIPSource;
			fwBean.setSourceIPEnd(endIp);

		
		String lastIPDest = fwBean.getDestIpEndDisp();
		p = fwBean.getDestIPStart().lastIndexOf(".")+1;
		endIp = fwBean.getDestIPStart().substring(0, p)+lastIPDest;
		fwBean.setDestIPEnd(endIp);
		
		if(fwBean.getSelectList().size()>0){
			fwBean.setServiceName(fwBean.getSelectList().get(0));
		}
		
		String validate = new FirewallValidate(fwBean).validate();
		if(IPFMMessageUtils.hasMessages()){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				fwBean.setSourceIPEnd(lastIPSource);
				fwBean.setDestIPEnd(lastIPDest);	

		} else {
//			IpUrFirewall fw = new IpUrFirewall();
//			IpUrFirewallId id = new IpUrFirewallId();
//			id.setUrNo(bean.getUrNo());
//			id.setSubUrNo(firewallService.genSubUrNo(bean.getUrNo()));
//			String subURNo = firewallService.genSubUrNo(bean.getUrNo());
//			id.setSubUrNo(subURNo.equals("0")?"FW00001":nextVal(subURNo));
//			fw.setId(id);
			
			IpUrFirewall fw = bean.getListFirewall().get(fwBean.getRowNum());
			
			String lastNumber = fwBean.getSourceIPStart().substring(fwBean.getSourceIPStart().lastIndexOf("."));
			String sourceIP = (fwBean.getSourceIPEnd().endsWith(lastNumber))?fwBean.getSourceIPStart():(fwBean.getSourceIPStart()+"-"+lastIPSource);
			
			lastNumber = fwBean.getDestIPStart().substring(fwBean.getDestIPStart().lastIndexOf("."));
			String destIP = (fwBean.getDestIPEnd().endsWith(lastNumber))?fwBean.getDestIPStart():(fwBean.getDestIPStart()+"-"+lastIPDest);
			
			fw.setSourceIp(sourceIP);
			fw.setSourceIp1(fwBean.getSourceIPStart());
			fw.setSourceIp2(fwBean.getSourceIPEnd());
			fw.setSourceHostName(fwBean.getSourceName());
			fw.setSourceEmail(fwBean.getSourceEmail());
			fw.setSourceVip(fwBean.getSourceVip());
			fw.setSourceNatIp(fwBean.getSourceNatIP());
			
			fw.setDestIp(destIP);
			fw.setDestIp1(fwBean.getDestIPStart());
			fw.setDestIp2(fwBean.getDestIPEnd());
			fw.setDestHostName(fwBean.getDestName());
			fw.setDestEmail(fwBean.getDestEmail());
			fw.setDestVip(fwBean.getDestVip());
			fw.setDestNatIp(fwBean.getDestNatIP());
			
			fw.setServiceStatus((fwBean.getSelectList().size()>0)?"Y":"N");
			String serviceId = "";
			String serviceName = "";
			String serviceDesc = "";
			
			for(String sel : fwBean.getSelectList()){
				fw.setServiceName(sel);
				IpMasterTable master = firewallService.getServiceByRefID(sel);
				serviceId+=(master.getId().getRefKey()+";");
				serviceName+=(master.getShortDesc()+";");
				String temp = "";
				if(master.getTcp()!=null) temp+=(" - TCP:"+master.getTcp());
				if(master.getUdp()!=null) temp+=(" - UDP:"+master.getUdp());
				if(master.getOther()!=null) temp+=(" - Other:"+master.getOther());
				serviceDesc+=(master.getShortDesc()+temp+"<br>");
			}
			
			fw.setServiceId(serviceId);
			fw.setServiceName(serviceName);
			fw.setServiceDesc(serviceDesc);
			fw.setServiceTcpStatus(fwBean.getTcpCheck()?"Y":"N");
			fw.setServiceTcpPort(fwBean.getTcpPort());
			fw.setServiceUdpStatus(fwBean.getUdpCheck()?"Y":"N");
			fw.setServiceUdpPort(fwBean.getUdpPort());
			fw.setServiceOtherStatus(fwBean.getOtherCheck()?"Y":"N");
			fw.setServiceOtherPort(fwBean.getOtherPort());
			
			fw.setCreated(new Date());
			fw.setCreatedBy(sessionUser.getIpUser().getUserId());
			fw.setLastUpd(new Date());
			fw.setLastUpdBy(sessionUser.getIpUser().getUserId());
			fw.setRowId(nwConfigService.genRowId());
			if(!isRejecMode(bean))
				fw.setChangeType("A");
			
			fw.setUrType("NC");
			fw.setIsTnp(nwConfigService.isTnp(fw.getSourceIp1()));

			firewallService.saveOrUpdate(fw);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			
			fwBean = new IPFirewallBean();
			
			List<SelectItem> select = new ArrayList<SelectItem>();
			List<IpMasterTable> service = firewallService.getService();
			System.out.println("List Size >>> "+service.size());
			for(IpMasterTable items : service){
				SelectItem item = new SelectItem();
				item.setLabel(items.getShortDesc());
				item.setValue(items.getId().getRefKey());
				select.add(item);
			}
			
			fwBean.setServiveList(select);
			fwBean.setSelectList(new ArrayList<String>());
			fwBean.setSubMode("ADD");
		}
		
		List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
		
		bean.setListFirewall(listFirewall);
		fwBean.setCheckAll(false);
		bean.setFirewall(fwBean);
		
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
	}
	
	public void addFirewall(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
     try{
    	 
    	 //TODO:NAT
         //System.out.println("inline -->>> " + lines.size());
         
         int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
         int recordRest = 0;
         List<IpUrFirewall> listFirewallC = firewallService.findByUrNo(getNetworkConfigBean().getUrNo());
         if(listFirewallC!=null && listFirewallC.size()>0) recordRest = listFirewallC.size();
          
         if((recordRest+1)>maxRecord) {     		
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
        	bean.setErrorMsg("");	
        	bean.setErrorFlag(false);		
            setNetworkConfigBean(bean);
            return;
         } 
         //TODO:NAT
    	 
		String tcpPortHidden = getRequestParameter("tcpPortHidden");
		
		IPFirewallBean fwBean = bean.getFirewall();
		
		fwBean.setSourceIPStart(fwBean.getSourceIPStart().trim());
		fwBean.setSourceIpEndDisp(fwBean.getSourceIpEndDisp().trim());
		fwBean.setDestIPStart(fwBean.getDestIPStart().trim());
		fwBean.setDestIpEndDisp(fwBean.getDestIpEndDisp().trim());


			String lastIPSource = fwBean.getSourceIpEndDisp();
			int p = fwBean.getSourceIPStart().lastIndexOf(".")+1;
			String endIp = fwBean.getSourceIPStart().substring(0, p)+lastIPSource;
			fwBean.setSourceIPEnd(endIp);

		
		String lastIPDest = fwBean.getDestIpEndDisp();
		p = fwBean.getDestIPStart().lastIndexOf(".")+1;
		endIp = fwBean.getDestIPStart().substring(0, p)+lastIPDest;
		fwBean.setDestIPEnd(endIp);
		
		if(fwBean.getSelectList().size()>0){
			fwBean.setServiceName(fwBean.getSelectList().get(0));
		}
		
		
		String validate = new FirewallValidate(fwBean).validate();
		if(IPFMMessageUtils.hasMessages()){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
				bean.setErrorMsg("");
				bean.setErrorFlag(false);

		} else {
			IpUrFirewall fw = new IpUrFirewall();
			IpUrFirewallId id = new IpUrFirewallId();
			id.setUrNo(bean.getUrNo());
			id.setSubUrNo(firewallService.genSubUrNo(bean.getUrNo()));
			String subURNo = firewallService.genSubUrNo(bean.getUrNo());
			id.setSubUrNo(subURNo.equals("0")?"FW00001":nextVal(subURNo));
			fw.setId(id);
			
			String lastNumber = fwBean.getSourceIPStart().substring(fwBean.getSourceIPStart().lastIndexOf("."));
			String sourceIP = (fwBean.getSourceIPEnd().endsWith(lastNumber))?fwBean.getSourceIPStart():(fwBean.getSourceIPStart()+"-"+lastIPSource);
			
			lastNumber = fwBean.getDestIPStart().substring(fwBean.getDestIPStart().lastIndexOf("."));
			String destIP = (fwBean.getDestIPEnd().endsWith(lastNumber))?fwBean.getDestIPStart():(fwBean.getDestIPStart()+"-"+lastIPDest);
			
			fw.setSourceIp(sourceIP);
			fw.setSourceIp1(fwBean.getSourceIPStart());
			fw.setSourceIp2(fwBean.getSourceIPEnd());
			fw.setSourceHostName(fwBean.getSourceName());
			fw.setSourceEmail(fwBean.getSourceEmail());
			fw.setSourceVip(fwBean.getSourceVip());
			fw.setSourceNatIp(fwBean.getSourceNatIP());
			
			fw.setDestIp(destIP);
			fw.setDestIp1(fwBean.getDestIPStart());
			fw.setDestIp2(fwBean.getDestIPEnd());
			fw.setDestHostName(fwBean.getDestName());
			fw.setDestEmail(fwBean.getDestEmail());
			fw.setDestVip(fwBean.getDestVip());
			fw.setDestNatIp(fwBean.getDestNatIP());
			
			fw.setServiceStatus((fwBean.getSelectList().size()>0)?"Y":"N");
			String serviceId = "";
			String serviceName = "";
			String serviceDesc = "";
			
			for(String sel : fwBean.getSelectList()){
				fw.setServiceName(sel);
				IpMasterTable master = firewallService.getServiceByRefID(sel);
				serviceId+=(master.getId().getRefKey()+";");
				serviceName+=(master.getShortDesc()+";");
				String temp = "";
				if(master.getTcp()!=null) temp+=(" - TCP:"+master.getTcp());
				if(master.getUdp()!=null) temp+=(" - UDP:"+master.getUdp());
				if(master.getOther()!=null) temp+=(" - Other:"+master.getOther());
				serviceDesc+=(master.getShortDesc()+temp+"<br>");
			}
			
			fw.setServiceId(serviceId);
			fw.setServiceName(serviceName);
			fw.setServiceDesc(serviceDesc);
			fw.setServiceTcpStatus(fwBean.getTcpCheck()?"Y":"N");
			fw.setServiceTcpPort(fwBean.getTcpPort());
			fw.setServiceUdpStatus(fwBean.getUdpCheck()?"Y":"N");
			fw.setServiceUdpPort(fwBean.getUdpPort());
			fw.setServiceOtherStatus(fwBean.getOtherCheck()?"Y":"N");
			fw.setServiceOtherPort(fwBean.getOtherPort());
			
			fw.setCreated(new Date());
			fw.setCreatedBy(sessionUser.getIpUser().getUserId());
			fw.setLastUpd(new Date());
			fw.setLastUpdBy(sessionUser.getIpUser().getUserId());
			fw.setRowId(nwConfigService.genRowId());
			if(!isRejecMode(bean))
				fw.setChangeType("A");
			
			fw.setUrType("NC");
			fw.setIsTnp(nwConfigService.isTnp(fw.getDestIp1()));

			firewallService.saveOrUpdate(fw);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			
			fwBean = new IPFirewallBean();
			
			List<SelectItem> select = new ArrayList<SelectItem>();
			List<IpMasterTable> service = firewallService.getService();
			System.out.println("List Size >>> "+service.size());
			for(IpMasterTable items : service){
				SelectItem item = new SelectItem();
				item.setLabel(items.getShortDesc());
				item.setValue(items.getId().getRefKey());
				select.add(item);
			}
			
			fwBean.setServiveList(select);
			fwBean.setSelectList(new ArrayList<String>());
		}
		
		List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
		
		bean.setListFirewall(listFirewall);
		fwBean.setCheckAll(false);
		bean.setFirewall(fwBean);
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void findSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IPFirewallBean firewall = bean.getFirewall();
		try {
			String errMsg ="";
			bean.setErrorMsg(errMsg);
			bean.setErrorFlag(false);
			List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
			bean.setValidateResult(validate);
		if(!IPFMDataValidateUtil.validateIPFormat(firewall.getSourceIPStart().trim())){
			firewall.setSourceIPStart("");
			firewall.setSourceIPEnd("");
			firewall.setSourceIpEndDisp("");
			firewall.setSourceName("");
			firewall.setSourceEmail("");
			firewall.setSourceVip("");
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"),"IP","255.255.255.255"));
			return;
		}
		

			IpInfo info = firewallService.getIPInfoWithUsedStatus(firewall.getSourceIPStart().trim());
			firewall.setSourceFound("0");
			String stIp  = firewall.getSourceIPStart().trim();
			String endIp = firewall.getSourceIpEndDisp().trim();
			//StringBuffer result = new StringBuffer("");
			 if(!stIp.endsWith("."+endIp)){
				firewall.setSourceName("");
				firewall.setSourceEmail("");
				firewall.setSourceVip("");
				firewall.setSourceFound("1");
			
				String[]  ip = stIp.split("\\.");
				String ipStart = IPFMDataUtility.convertIpStringToBinary(stIp);
				String ipEnd = IPFMDataUtility.convertIpStringToBinary(ip[0]+"."+ip[1]+"."+ip[2]+"."+endIp);
				
				
				boolean hasError = false;
				
				List<IpInfo> ipInfoList = firewallService.findIpInfoAssignIp(ipStart, ipEnd);
				MsgUploadError error = null;
				
				for (IpInfo ipInfo : ipInfoList) {
					if (!ipInfo.getIpStatus().equalsIgnoreCase("U")) {
						hasError = true;
						error = new MsgUploadError();
						firewall.setSourceIPEnd("");
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
					firewall.setSourceIpEndDisp("");
					bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0104")));
					//bean.setValidateResult(validate);
				}
					
//					int count = firewallService.fineIpinfo(ipStart, ipEnd);
//					if(count>0){
//						int countT2TeamId  = firewallService.findTier2TeamID(ipStart, ipEnd);
//						if(countT2TeamId>1){
//							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088")));
//	//						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088"));
//	//						result.append("<li>"+errMsg+"</li>");
//	//						bean.setErrorFlag(true);
//							firewall.setSourceIPEnd("");
//						}
//						int countsystemOwnerTeamID  = firewallService.findSystemOwnerTeamID(ipStart, ipEnd);
//						if(countsystemOwnerTeamID>1){
//							IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089")));
//	//						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089"));
//	//						result.append("<li>"+errMsg+"</li>");
//	//						bean.setErrorFlag(true);
//							firewall.setSourceIPEnd("");
//						}
//						if (IPFMMessageUtils.hasMessages()) return;
//	//					bean.setErrorMsg(result.toString());
//					}
//				 
//			} else 
				
			 } else if(info!=null){
				if (info.getSystemOwner()==null || info.getSystemOwner().trim().length()==0) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"))); 
					return;
				}
				firewall.setSourceName(info.getHostName());
				String email = (info.getSystemOwnerId()!=null)?info.getSystemOwnerId().getEmail():"";
				firewall.setSourceEmail(email);
				firewall.setSourceVip(info.getVip());
				firewall.setSourceFound("1");
			} else {
				firewall.setSourceIPStart("");
				firewall.setSourceIPEnd("");
				firewall.setSourceIpEndDisp("");
				firewall.setSourceName("");
				firewall.setSourceEmail("");
				firewall.setSourceVip("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),firewall.getSourceIPStart().trim()));
				return;
			}

		bean.setFirewall(firewall);
		setNetworkConfigBean(bean);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IPFirewallBean firewall = bean.getFirewall();
		try {
			String errMsg ="";
			bean.setErrorMsg(errMsg);
			bean.setErrorFlag(false);
			bean.setValidateResult(new ArrayList<MsgUploadError>());
			
			if(!IPFMDataValidateUtil.validateIPFormat(firewall.getDestIPStart().trim())){
				firewall.setDestIPStart("");
				firewall.setDestIPEnd("");
				firewall.setDestIpEndDisp("");
				firewall.setDestName("");
				firewall.setDestEmail("");
				firewall.setDestVip("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"),"IP","255.255.255.255"));
				return;
			}
			IpInfo info = firewallService.getIPInfoWithUsedStatus(firewall.getDestIPStart());
			firewall.setDestFound("0");
			
			String stIp  = firewall.getDestIPStart().trim();
			String endIp = firewall.getDestIpEndDisp().trim();
			StringBuffer result = new StringBuffer("");
			
			if(!stIp.endsWith("."+endIp)){
				firewall.setDestName("");
				firewall.setDestEmail("");
				firewall.setDestVip("");
				firewall.setDestFound("1");
				
				String[]  ip = stIp.split("\\.");
				String ipStart = IPFMDataUtility.convertIpStringToBinary(stIp);
				String ipEnd = IPFMDataUtility.convertIpStringToBinary(ip[0]+"."+ip[1]+"."+ip[2]+"."+endIp);
				
				List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
				boolean hasError = false;
				
				List<IpInfo> ipInfoList = firewallService.findIpInfoAssignIp(ipStart, ipEnd);
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
					firewall.setDestIpEndDisp("");
					bean.setErrorMsg(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0103")));
					bean.setValidateResult(validate);
				}
//				int count = firewallService.fineIpinfo(ipStart, ipEnd);
//				if(count>0){
//					int countT2TeamId  = firewallService.findTier2TeamID(ipStart, ipEnd);
//					if(countT2TeamId>1){
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088")));
////						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088"));
////						result.append("<li>"+errMsg+"</li>");
////						bean.setErrorFlag(true);
//						firewall.setDestIpEndDisp("");
//					}
//					int countsystemOwnerTeamID  = firewallService.findSystemOwnerTeamID(ipStart, ipEnd);
//					if(countsystemOwnerTeamID>1){
//						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089")));
////						errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089"));
////						result.append("<li>"+errMsg+"</li>");
////						bean.setErrorFlag(true);
//						firewall.setDestIpEndDisp("");
//					}
//					
////					bean.setErrorMsg(result.toString());
//				}
				
			} else if(info!=null){
				if (info.getSystemOwner()==null || info.getSystemOwner().trim().length()==0) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"))); 
					return;
				}
				firewall.setDestName(info.getHostName());
				String email = (info.getSystemOwnerId()!=null)?info.getSystemOwnerId().getEmail():"";
				firewall.setDestEmail(email);
				firewall.setDestVip(info.getVip());
				firewall.setDestFound("1");
			} else {
				firewall.setDestIPStart("");
				firewall.setDestIPEnd("");
				firewall.setDestIpEndDisp("");
				firewall.setDestName("");
				firewall.setDestEmail("");
				firewall.setDestVip("");
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),firewall.getDestIPStart().trim()));
			}
			bean.setFirewall(firewall);
			setNetworkConfigBean(bean);		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String nextVal(String subUrNo){
		String resultString = "FW";
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
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrFirewall rsFirewall = firewallService.findFirewall(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		
		IPFirewallBean fw = new IPFirewallBean();
		fw.setSearchResult(rsFirewall);
//		fw.setJobAssign(jobAssign);
		fw.setJobAssignList(jobAssignList);
		bean.setFirewall(fw);
		setNetworkConfigBean(bean);
	}
	
	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",3);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrFirewall> firewallList = new ArrayList<IpUrFirewall>();
        
        //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());
        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
        int recordRest = 0;
        List<IpUrFirewall> listFirewallC = firewallService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listFirewallC!=null && listFirewallC.size()>0) recordRest = maxRecord - listFirewallC.size();
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
        	IPFirewallBean firewall = new IPFirewallBean();
        	firewall.setSourceIPStart(data.get(0).trim());
        	firewall.setSourceIPEnd(data.get(1).trim());
        	firewall.setSourceEmail(data.get(2).trim());
        	firewall.setSourceNatIP(data.get(3).trim());
        	firewall.setDestIPStart(data.get(4).trim());
        	firewall.setDestIPEnd(data.get(5).trim());
        	firewall.setDestNatIP(data.get(6).trim());
        	firewall.setTcpPort(data.get(7).trim());
        	firewall.setUdpPort(data.get(8).trim());
        	firewall.setOtherPort("");
        	firewall.setServiceName(data.get(9).trim());
        	/*firewall.setOtherPort(data.get(9).trim());
        	firewall.setServiceName(data.get(10).trim());*/
        	 
        	
        	
        	
        	
        	String validateResult = new FirewallValidate(firewall).validate();
        	
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
	        	IpUrFirewall subUr = new IpUrFirewall();
	        	
	        	// source 
	        	String sourceIp = "";
	        	if(firewall.getSourceIPStart().equals(firewall.getSourceIPEnd())){
	        		sourceIp = firewall.getSourceIPStart();
	        		IpInfo info = firewallService.getIPInfo(sourceIp);
	        		if(info!=null){
	        			subUr.setSourceHostName(info.getHostName());
	        			subUr.setSourceEmail(info.getSystemOwnerId().getEmail());
	        			subUr.setSourceVip(info.getVip());
	        		}
	        	} else {
	        		int no = firewall.getSourceIPEnd().lastIndexOf(".")+1;
	                sourceIp = firewall.getSourceIPStart()+" - "+firewall.getSourceIPEnd().substring(no);
	        	}
	        	subUr.setSourceIp(sourceIp);
	        	subUr.setSourceIp1(firewall.getSourceIPStart());
	        	subUr.setSourceIp2(firewall.getSourceIPEnd());
	        	subUr.setSourceNatIp(firewall.getSourceNatIP());
	        	if(!firewall.getSourceEmail().equals("")){
	        		subUr.setSourceEmail(firewall.getSourceEmail());
	        	}
	        	// destination
	        	String destIp = "";
	        	if(firewall.getDestIPStart().equals(firewall.getDestIPEnd())){
	        		destIp = firewall.getDestIPStart();
	        		IpInfo info = firewallService.getIPInfo(destIp);
	        		if(info!=null){
	        			subUr.setDestHostName(info.getHostName());
	        			subUr.setDestEmail(info.getSystemOwnerId().getEmail());
	        			subUr.setDestVip(info.getVip());
	        		}
	        	} else {
	        		int no = firewall.getDestIPEnd().lastIndexOf(".")+1;
	        		destIp = firewall.getDestIPStart()+" - "+firewall.getDestIPEnd().substring(no);
	        	}
	        	subUr.setDestIp(destIp);
	        	subUr.setDestIp1(firewall.getDestIPStart());
	        	subUr.setDestIp2(firewall.getDestIPEnd());
	        	subUr.setDestNatIp(firewall.getDestNatIP());
	        	
	        	// Service 
	        	if(!firewall.getTcpPort().equals("") && (firewall.getTcpPort()!=null)){
	        		subUr.setServiceTcpStatus("Y");
	        		subUr.setServiceTcpPort(firewall.getTcpPort());
	        	} else subUr.setServiceTcpStatus("N");
	        	
	        	if(!firewall.getUdpPort().equals("") && (firewall.getUdpPort()!=null)){
	        		subUr.setServiceUdpStatus("Y");
	        		subUr.setServiceUdpPort(firewall.getUdpPort());
	        	} else subUr.setServiceUdpStatus("N");
	        	
	        	if(!firewall.getOtherPort().equals("") && (firewall.getOtherPort()!=null)){
	        		subUr.setServiceOtherStatus("Y");
	        		subUr.setServiceOtherPort(firewall.getOtherPort());
	        	} else subUr.setServiceOtherStatus("N");
	        	
	        	if(!firewall.getServiceName().equals("") && (firewall.getServiceName()!=null)){
	        	IpMasterTable master = firewallService.getServiceByRefID(firewall.getServiceName());
					String serviceId=(master.getId().getRefKey()+";");
					String serviceName=(master.getShortDesc()+";");
					/*String serviceDesc=(
							master.getShortDesc()+
							":TCP:"+((master.getTcp()!=null)?master.getTcp():"")+
							":UDP:"+((master.getUdp()!=null)?master.getUdp():"")+
							":Other:"+((master.getOther()!=null)?master.getOther():""));
					*/
					String serviceDesc = "";
					String temp = "";
					if(master.getTcp()!=null) temp+=(" - TCP:"+master.getTcp());
					if(master.getUdp()!=null) temp+=(" - UDP:"+master.getUdp());
					if(master.getOther()!=null) temp+=(" - Other:"+master.getOther());
					serviceDesc+=(master.getShortDesc()+temp+"<br>");
				
					//System.out.println("TEST serviceDesc" + serviceDesc);
					
					subUr.setServiceId(serviceId);
					subUr.setServiceName(serviceName);
					subUr.setServiceDesc(serviceDesc);
	        	}
	        	
				firewallList.add(subUr);
        	}
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        if(validate.size()==0){
        	for(IpUrFirewall fw : firewallList){
        		String subUrNo = firewallService.genSubUrNo(bean.getUrNo());
        		IpUrFirewallId id = new IpUrFirewallId(bean.getUrNo(), subUrNo.equals("0")?"FW00001":nextVal(subUrNo));
        		fw.setId(id);
        		fw.setUrType("NC");
        		fw.setIsTnp(nwConfigService.isTnp(fw.getSourceIp1()));
        		fw.setRowId(nwConfigService.genRowId());
        		if(!isRejecMode(bean))
        			fw.setChangeType("A");
        		
        		fw.setCreated(new Date());
    			fw.setCreatedBy(sessionUser.getIpUser().getUserId());
    			firewallService.saveOrUpdate(fw);
        	}
        }
        
        List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
		bean.setListFirewall(listFirewall);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 
	
	public void clearSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPFirewallBean firewall = bean.getFirewall();
		firewall.setSourceIPStart("");
		firewall.setSourceIPEnd("");
		firewall.setSourceName("");
		firewall.setSourceEmail("");
		firewall.setSourceVip("");
		bean.setFirewall(firewall);
		setNetworkConfigBean(bean);		
	}
	
	public void clearDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPFirewallBean firewall = bean.getFirewall();
		firewall.setDestIPStart("");
		firewall.setDestIPEnd("");
		firewall.setDestName("");
		firewall.setDestEmail("");
		firewall.setDestVip("");
		bean.setFirewall(firewall);
		setNetworkConfigBean(bean);		
	}
	
	public void editFirewallInit(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");

		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IpUrFirewall firewall = firewallService.findFirewall(urNo, subUrNo);
		IPFirewallBean fwBean = bean.getFirewall();
		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			fwBean.setRowNum(rowInt);
		}		
		fwBean.setSourceIPStart(firewall.getSourceIp1());
		int pos=firewall.getSourceIp2().lastIndexOf(".")+1;
		fwBean.setSourceIPEnd(firewall.getSourceIp2());
		fwBean.setSourceIpEndDisp(firewall.getSourceIp2().substring(pos));
		fwBean.setSourceName(firewall.getSourceHostName());
		fwBean.setSourceEmail(firewall.getSourceEmail());
		fwBean.setSourceVip(firewall.getSourceVip());
		fwBean.setSourceNatIP(firewall.getSourceNatIp());
		
		fwBean.setDestIPStart(firewall.getDestIp1());
		pos=firewall.getDestIp2().lastIndexOf(".")+1;
		fwBean.setDestIpEndDisp(firewall.getDestIp2().substring(pos));
		fwBean.setDestIPEnd(firewall.getDestIp2());
		fwBean.setDestName(firewall.getDestHostName());
		fwBean.setDestEmail(firewall.getDestEmail());
		fwBean.setDestVip(firewall.getDestVip());
		fwBean.setDestNatIP(firewall.getDestNatIp());
		
		fwBean.setTcpCheck(firewall.getServiceTcpStatus().equals("Y"));
		fwBean.setTcpPort(firewall.getServiceTcpPort());
		fwBean.setUdpCheck(firewall.getServiceUdpStatus().equals("Y"));
		fwBean.setUdpPort(firewall.getServiceUdpPort());
		fwBean.setOtherCheck(firewall.getServiceOtherStatus().equals("Y"));
		fwBean.setOtherPort(firewall.getServiceOtherPort());
		List<String> serviceList = new ArrayList<String>();
		String sn = firewall.getServiceName(); 
		if(sn!=null){
			String [] list = sn.split(";");
			for(String service : list){
				serviceList.add(service);
			}
		}
		fwBean.setSelectList(serviceList);
		fwBean.setSearchResult(firewall);
		fwBean.setSubMode("EDIT");

		bean.setFirewall(fwBean);
		setNetworkConfigBean(bean);
	}
	
//	public void editFirewall(){
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
//		IPFirewallBean fwBean = bean.getFirewall();
//		UserSession sessionUser = IPFMWebUtil.getUserSession();
//		
//		
//		String lastIPSource = fwBean.getSourceIPEnd();
//		int p = fwBean.getSourceIPStart().lastIndexOf(".")+1;
//		String endIp = fwBean.getSourceIPStart().substring(0, p)+fwBean.getSourceIPEnd();
//		fwBean.setSourceIPEnd(endIp);
//		
//		
//		String lastIPDest = fwBean.getDestIPEnd();
//		p = fwBean.getDestIPStart().lastIndexOf(".")+1;
//		endIp = fwBean.getDestIPStart().substring(0, p)+fwBean.getDestIPEnd();
//		fwBean.setDestIPEnd(endIp);
//		if(fwBean.getSelectList().size()>0){
//			fwBean.setServiceName(fwBean.getSelectList().get(0));
//		}
//		
//		
//		String validate = new FirewallValidate(fwBean).validate();
//		if (IPFMMessageUtils.hasMessages()) {
////				bean.setErrorMsg(validate);
////				bean.setErrorFlag(true);
//				fwBean.setSourceIPEnd(lastIPSource);
//				fwBean.setDestIPEnd(lastIPDest);
//				bean.setErrorMsg("");
//				bean.setErrorFlag(false);
//				return;
//		} else {
//			IpUrFirewall fw = fwBean.getSearchResult();
//			
//			String lastNumber = fwBean.getSourceIPStart().substring(fwBean.getSourceIPStart().lastIndexOf(".")+1);
//			String sourceIP = (fwBean.getSourceIPEnd().equals(lastNumber))?fwBean.getSourceIPStart():(fwBean.getSourceIPStart()+"-"+lastIPSource);
//			
//			lastNumber = fwBean.getDestIPStart().substring(fwBean.getDestIPStart().lastIndexOf(".")+1);
//			String destIP = (fwBean.getDestIPEnd().equals(lastNumber))?fwBean.getDestIPStart():(fwBean.getDestIPStart()+"-"+lastIPDest);
//			
//			fw.setSourceIp(sourceIP);
//			fw.setSourceIp1(fwBean.getSourceIPStart());
//			fw.setSourceIp2(fwBean.getSourceIPEnd());
//			fw.setSourceHostName(fwBean.getSourceName());
//			fw.setSourceEmail(fwBean.getSourceEmail());
//			fw.setSourceVip(fwBean.getSourceVip());
//			fw.setSourceNatIp(fwBean.getSourceNatIP());
//			
//			fw.setDestIp(destIP);
//			fw.setDestIp1(fwBean.getDestIPStart());
//			fw.setDestIp2(fwBean.getDestIPEnd());
//			fw.setDestHostName(fwBean.getDestName());
//			fw.setDestEmail(fwBean.getDestEmail());
//			fw.setDestVip(fwBean.getDestVip());
//			fw.setDestNatIp(fwBean.getDestNatIP());
//			
//			fw.setServiceStatus((fwBean.getSelectList().size()>0)?"Y":"N");
//			String serviceId = "";
//			String serviceName = "";
//			String serviceDesc = "";
//			
//			for(String sel : fwBean.getSelectList()){
//				fw.setServiceName(sel);
//				IpMasterTable master = firewallService.getServiceByRefID(sel);
//				serviceId+=(master.getId().getRefKey()+";");
//				serviceName+=(master.getShortDesc()+";");
//				serviceDesc+=(
//						master.getShortDesc()+
//						":TCP:"+((master.getTcp()!=null)?master.getTcp():"")+
//						":UDP:"+((master.getUdp()!=null)?master.getUdp():"")+
//						":Other:"+((master.getOther()!=null)?master.getOther():"")+
//						"<br>");
//				
//			}
//			
//			fw.setServiceId(serviceId);
//			fw.setServiceName(serviceName);
//			fw.setServiceDesc(serviceDesc);
//			fw.setServiceTcpStatus(fwBean.getTcpCheck()?"Y":"N");
//			fw.setServiceTcpPort(fwBean.getTcpPort());
//			fw.setServiceUdpStatus(fwBean.getUdpCheck()?"Y":"N");
//			fw.setServiceUdpPort(fwBean.getUdpPort());
//			fw.setServiceOtherStatus(fwBean.getOtherCheck()?"Y":"N");
//			fw.setServiceOtherPort(fwBean.getOtherPort());
//			
//			fw.setCreated(new Date());
//			fw.setCreatedBy(sessionUser.getIpUser().getUserId());
//			firewallService.updateFirewall(fw);
//			
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//			
//			fwBean = new IPFirewallBean();
//			
//			List<SelectItem> select = new ArrayList<SelectItem>();
//			List<IpMasterTable> service = firewallService.getService();
//			System.out.println("List Size >>> "+service.size());
//			for(IpMasterTable items : service){
//				SelectItem item = new SelectItem();
//				item.setLabel(items.getShortDesc());
//				item.setValue(items.getId().getRefKey());
//				select.add(item);
//			}
//			
//			fwBean.setServiveList(select);
//			fwBean.setSelectList(new ArrayList<String>());
//		}
//		
//		List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
//		
//		bean.setListFirewall(listFirewall);
//		bean.setFirewall(fwBean);
//		bean.setSubMode("ADD");
//		setNetworkConfigBean(bean);
//	}
	
	public void deleteFirewall(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IPFirewallBean fwBean = bean.getFirewall();
		IpUrFirewall firewall = firewallService.findFirewall(urNo, subUrNo);
		String changeType = (firewall.getChangeType()!=null)?firewall.getChangeType():""; 
		if(changeType.equals("A")){
			firewallService.delete(firewall);
		} else {
			firewall.setChangeType("D");
			firewallService.updateFirewall(firewall);
		}
		List<IpUrFirewall> listFirewall = firewallService.findByUrNo(bean.getUrNo());
		bean.setListFirewall(listFirewall);
		bean.getFirewall().setSubMode("ADD");
		
		bean.getFirewall().setDestEmail("");
		bean.getFirewall().setDestFound("");
		bean.getFirewall().setDestIPEnd("");
		bean.getFirewall().setDestIPStart("");
		bean.getFirewall().setDestIpEndDisp("");
		bean.getFirewall().setDestNatIP("");
		bean.getFirewall().setDestName("");
		bean.getFirewall().setDestVip("");
		bean.getFirewall().setOtherCheck(false);
		bean.getFirewall().setSelectList(new ArrayList<String>());
		bean.getFirewall().setOtherPort("");
		bean.getFirewall().setServicePort("");
		bean.getFirewall().setServiceName("");
		bean.getFirewall().setSourceEmail("");
		bean.getFirewall().setSourceFound("");
		bean.getFirewall().setSourceIPEnd("");
		bean.getFirewall().setSourceIpEndDisp("");
		bean.getFirewall().setSourceIPStart("");
		bean.getFirewall().setSourceName("");
		bean.getFirewall().setSourceNatIP("");
		bean.getFirewall().setSourceVip("");
		bean.getFirewall().setTcpCheck(false);
		bean.getFirewall().setTcpPort("");
		bean.getFirewall().setUdpCheck(false);
		bean.getFirewall().setUdpPort("");		
		fwBean.setCheckAll(false);
		bean.setFirewall(fwBean);
		setNetworkConfigBean(bean);
		
	}
	
	public void cleanSubUr(String urNo){
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		firewallService.cleanSubUR(urNo);
	}
	
	
	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestFirewall();
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
	        String fileName = ipfmConfigBean.getTemplateRequestFirewall();
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
