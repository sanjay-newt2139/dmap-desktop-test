package th.co.ais.ipfm.web.manage.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterfaceId;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.service.PhyInterfaceService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPPhyInterfaceBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.PhysicalInterfaceValidate;


public class NWConfigPhyInterfaceAction extends AbstractAction{
	private List<SelectItem> nodeType;
	private List<SelectItem> portStatus;
	private List<SelectItem> speedPort;
	private List<SelectItem> trunkNo;
	
	public NWConfigPhyInterfaceAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void addPhyInterface(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
	 try{
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPPhyInterfaceBean intfBean = bean.getPhyInterface();
		
		//TODO:NAT
        //System.out.println("inline -->>> " + lines.size());
        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
        int recordRest = 0;
        List<IpUrPhysicalInterface> listPhyIntfC = phyIntfService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listPhyIntfC!=null && listPhyIntfC.size()>0) recordRest = listPhyIntfC.size();
         
        if((recordRest+1)>maxRecord) {     		
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
        	bean.setErrorMsg("");	
        	bean.setErrorFlag(false);
           setNetworkConfigBean(bean);
           return;
        } 
        //TODO:NAT
		
		String validate = new PhysicalInterfaceValidate(intfBean).validate();
		if (IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return;
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
			IpUrPhysicalInterface intf = new IpUrPhysicalInterface();
			IpUrPhysicalInterfaceId id = new IpUrPhysicalInterfaceId();
			id.setUrNo(bean.getUrNo());
			id.setSubUrNo(phyIntfService.genSubUrNo(bean.getUrNo()));
			String subURNo = phyIntfService.genSubUrNo(bean.getUrNo());
			id.setSubUrNo(subURNo.equals("0")?"PI00001":nextVal(subURNo));
			intf.setId(id);
			
			intf.setIpNode(intfBean.getIpNode());
			intf.setHostName(intfBean.getHostName());
			intf.setMacAddress(intfBean.getMacAddress());
			intf.setLocationName(intfBean.getLocation());
			intf.setFloor(intfBean.getFloor());
			intf.setVlanId(intfBean.getVlanID());
			intf.setInterfaceDesc(intfBean.getInterfaceDesc());
			
			if(intfBean.getIntfNodeType()!=null){
				intf.setInterfaceNodeId(intfBean.getIntfNodeType().getValue());
				intf.setInterfaceNodeDesc(intfBean.getIntfNodeType().getLabel());
			}
			
			if(intfBean.getPortStatus()!=null){
				intf.setPortStatusId(intfBean.getPortStatus().getValue());
				intf.setPortStatusDesc(intfBean.getPortStatus().getLabel());
			}
			
			if(intfBean.getSpeedPort()!=null){
				intf.setSpeedPortId(intfBean.getSpeedPort().getValue());
				intf.setSpeedPortDesc(intfBean.getSpeedPort().getLabel());
			}
			
			intf.setEnclosure(intfBean.getEnclosure());
			intf.setReqRemarks(intfBean.getReqRemark());
			
			intf.setIsTnp(nwConfigService.isTnp(intf.getIpNode()));
			intf.setUrType("NC");
			if(!isRejecMode(bean))
				intf.setChangeType("A");
			
			intf.setCreated(new Date());
			intf.setCreatedBy(sessionUser.getIpUser().getUserId());
			intf.setLastUpd(new Date());
			intf.setLastUpdBy(sessionUser.getIpUser().getUserId());
			
			intf.setRowId(nwConfigService.genRowId());
			intf.setPiType(bean.getPhyInterface().getPiType());
			if(StringUtils.equals("T", bean.getPhyInterface().getPiType())){
				intf.setTrunkNo(bean.getPhyInterface().getTrunkNo());
			}
			phyIntfService.saveOrUpdate(intf);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			if(StringUtils.equals("T", bean.getPhyInterface().getPiType())){
				bean.setPhyInterface(new IPPhyInterfaceBean());
				bean.getPhyInterface().setPiType("T");
			}else{
				bean.setPhyInterface(new IPPhyInterfaceBean());
			}
			
		}
		bean.getPhyInterface().setCheckAll(false);
		List<IpUrPhysicalInterface> listPhyIntf = phyIntfService.findByUrNo(bean.getUrNo());
		bean.setListPhysicalInterface(listPhyIntf);
		
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void editPhyInterface(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
	 try{
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPPhyInterfaceBean intfBean = bean.getPhyInterface();
		
		String validate = new PhysicalInterfaceValidate(intfBean).validate();
		if (IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return;
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
//			IpUrPhysicalInterface intf = new IpUrPhysicalInterface();
//			IpUrPhysicalInterfaceId id = new IpUrPhysicalInterfaceId();
//			id.setUrNo(bean.getUrNo());
//			id.setSubUrNo(phyIntfService.genSubUrNo(bean.getUrNo()));
//			String subURNo = phyIntfService.genSubUrNo(bean.getUrNo());
//			id.setSubUrNo(subURNo.equals("0")?"PI00001":nextVal(subURNo));
//			intf.setId(id);
			IpUrPhysicalInterface intf = bean.getListPhysicalInterface().get(intfBean.getRowNum());
			
			intf.setIpNode(intfBean.getIpNode());
			intf.setHostName(intfBean.getHostName());
			intf.setMacAddress(intfBean.getMacAddress());
			intf.setLocationName(intfBean.getLocation());
			intf.setFloor(intfBean.getFloor());
			intf.setVlanId(intfBean.getVlanID());
			intf.setInterfaceDesc(intfBean.getInterfaceDesc());
			
			if(intfBean.getIntfNodeType()!=null){
				intf.setInterfaceNodeId(intfBean.getIntfNodeType().getValue());
				intf.setInterfaceNodeDesc(intfBean.getIntfNodeType().getLabel());
			}
			
			if(intfBean.getPortStatus()!=null){
				intf.setPortStatusId(intfBean.getPortStatus().getValue());
				intf.setPortStatusDesc(intfBean.getPortStatus().getLabel());
			}
			
			if(intfBean.getSpeedPort()!=null){
				intf.setSpeedPortId(intfBean.getSpeedPort().getValue());
				intf.setSpeedPortDesc(intfBean.getSpeedPort().getLabel());
			}
			
			intf.setEnclosure(intfBean.getEnclosure());
			intf.setReqRemarks(intfBean.getReqRemark());
			
			intf.setIsTnp(nwConfigService.isTnp(intf.getIpNode()));
			intf.setUrType("NC");
			if(!isRejecMode(bean))
				intf.setChangeType("A");
			
			intf.setCreated(new Date());
			intf.setCreatedBy(sessionUser.getIpUser().getUserId());
			intf.setLastUpd(new Date());
			intf.setLastUpdBy(sessionUser.getIpUser().getUserId());
			
			intf.setRowId(nwConfigService.genRowId());
			
			phyIntfService.saveOrUpdate(intf);
						
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			bean.setPhyInterface(new IPPhyInterfaceBean());
			if(StringUtils.equals("T", intf.getPiType())){
				bean.getPhyInterface().setPiType("T");
			}
			bean.getPhyInterface().setCheckAll(false);
			intfBean.setSubMode("ADD");
		}
		
		List<IpUrPhysicalInterface> listPhyIntf = phyIntfService.findByUrNo(bean.getUrNo());
		bean.setListPhysicalInterface(listPhyIntf);
		
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void findIPNode(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		IPPhyInterfaceBean phyIntf = bean.getPhyInterface();
		IpInfo info = phyIntfService.getIPInfoWithUsedStatus(phyIntf.getIpNode());
		phyIntf.setIpFound("0");
		if(info!=null){
			phyIntf.setHostName(info.getHostName());
			phyIntf.setMacAddress(info.getMacAddress());
			phyIntf.setLocation(info.getLocationName());
			phyIntf.setVlanID(info.getVlanId());
			phyIntf.setReqRemark(info.getT3Remark());
			phyIntf.setIpFound("1");
			
		} else {
			phyIntf.setHostName("");
			phyIntf.setMacAddress("");
			phyIntf.setLocation("");
			phyIntf.setVlanID("");
			phyIntf.setReqRemark("");
			phyIntf.setIpFound("0");
		}
		bean.setPhyInterface(phyIntf);
		setNetworkConfigBean(bean);		
	}
	
	private String nextVal(String subUrNo){
		String resultString = "PI";
		int no =  Integer.parseInt(subUrNo.substring(2));
		String nnn = String.valueOf(++no);
		for(int i=0;i<5-nnn.length();i++) resultString+="0";
		resultString+=nnn;
		return resultString;
	}
	
	public List<SelectItem> getNodeType(){
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		List<SelectItem> listResult = new ArrayList<SelectItem>();
		List<IpMasterTable> listNodeType = phyIntfService.getProperty("ND_TYPE");
		
		for(IpMasterTable nodeType : listNodeType){
			IPFMRichComboItem cbitem = new IPFMRichComboItem();
			cbitem.setLabel(nodeType.getShortDesc());
			cbitem.setValue(nodeType.getId().getRefKey());
			listResult.add(new SelectItem(cbitem, cbitem.getLabel()));
		}
		return listResult;
	}
	
	public List<SelectItem> getPortStatus(){
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		List<SelectItem> listResult = new ArrayList<SelectItem>();
		List<IpMasterTable> listNodeType = phyIntfService.getProperty("PORT_STS");
		
		for(IpMasterTable nodeType : listNodeType){
			IPFMRichComboItem cbitem = new IPFMRichComboItem();
			cbitem.setLabel(nodeType.getShortDesc());
			cbitem.setValue(nodeType.getId().getRefKey());
			listResult.add(new SelectItem(cbitem, cbitem.getLabel()));
		}
		return listResult;
	}
	
	public List<SelectItem> getSpeedPort(){
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		List<SelectItem> listResult = new ArrayList<SelectItem>();
		List<IpMasterTable> listNodeType = phyIntfService.getProperty("SPEED_PORT");
		
		for(IpMasterTable nodeType : listNodeType){
			IPFMRichComboItem cbitem = new IPFMRichComboItem();
			cbitem.setLabel(nodeType.getShortDesc());
			cbitem.setValue(nodeType.getId().getRefKey());
			listResult.add(new SelectItem(cbitem, cbitem.getLabel()));
			
		}
		return listResult;
	}
	
	public void findSubUr(){
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		
		ReqNWConfigBean bean = getNetworkConfigBean();
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrPhysicalInterface rsPi = phyIntfService.findPhyInterface(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		IPPhyInterfaceBean piBean = new IPPhyInterfaceBean();
		piBean.setSearchResult(rsPi);
//		piBean.setJobAssign(jobAssign);
		piBean.setJobAssignList(jobAssignList);
		bean.setPhyInterface(piBean);
		setNetworkConfigBean(bean);
	}
	
	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",3);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrPhysicalInterface> phyInterfaceList = new ArrayList<IpUrPhysicalInterface>();

      //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord();
        int recordRest = 0;
        List<IpUrPhysicalInterface> listPhyIntfC = phyIntfService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listPhyIntfC!=null && listPhyIntfC.size()>0) recordRest = maxRecord - listPhyIntfC.size();
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
        	IPPhyInterfaceBean phyIntfBean = new IPPhyInterfaceBean();
        	phyIntfBean.setIpNode(data.get(0).trim());
        	phyIntfBean.setFloor(data.get(1).trim());
        	phyIntfBean.setIntfNodeType(new IPFMRichComboItem("", data.get(2).trim()));
        	phyIntfBean.setIntfNodeTypeDesc(data.get(2).trim());
        	phyIntfBean.setInterfaceDesc(data.get(3).trim());
        	phyIntfBean.setPortStatus(new IPFMRichComboItem("", data.get(4).trim()));
        	phyIntfBean.setPortStatusDesc(data.get(4).trim());
        	phyIntfBean.setSpeedPort(new IPFMRichComboItem("", data.get(5).trim()));
        	phyIntfBean.setSpeedPortDesc(data.get(5).trim());
        	phyIntfBean.setEnclosure(data.get(6).trim());
        	 
        	String validateResult = new PhysicalInterfaceValidate(phyIntfBean).validate();
        	
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
        		IpUrPhysicalInterface subUr = new IpUrPhysicalInterface();
	        	
	        	// source 
	        	IpInfo infoSource = phyIntfService.getIPInfo(phyIntfBean.getIpNode());
	        	if(infoSource!=null){
	        		subUr.setHostName(infoSource.getHostName());
	        		subUr.setMacAddress(infoSource.getMacAddress());
	        		subUr.setLocationName(infoSource.getLocationName());
	        		subUr.setVlanId(infoSource.getVlanId());
	        	}
	        	
	        	subUr.setIpNode(phyIntfBean.getIpNode());
	        	subUr.setFloor(phyIntfBean.getFloor());
	        	subUr.setInterfaceDesc(phyIntfBean.getInterfaceDesc());
				
	        	String intfDesc = phyIntfBean.getIntfNodeTypeDesc();
				subUr.setInterfaceNodeId(phyIntfService.getIntfNodeTypeId(intfDesc));
				subUr.setInterfaceNodeDesc(intfDesc);
				
				String statusDesc = phyIntfBean.getPortStatusDesc();
				subUr.setPortStatusId(phyIntfService.getStatusId(statusDesc));
				subUr.setPortStatusDesc(statusDesc);
				
				String portDesc = phyIntfBean.getSpeedPortDesc();
				subUr.setSpeedPortId(phyIntfService.getSpeedPortId(portDesc));
				subUr.setSpeedPortDesc(portDesc);
				
				
				subUr.setEnclosure(phyIntfBean.getEnclosure());
		
				subUr.setCreated(new Date());
				subUr.setCreatedBy(sessionUser.getIpUser().getUserId());
				subUr.setLastUpd(new Date());
				subUr.setLastUpdBy(sessionUser.getIpUser().getUserId());
				phyInterfaceList.add(subUr);
        	}
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        if(validate.size()==0){
        	for(IpUrPhysicalInterface pi : phyInterfaceList){
        		String subUrNo = phyIntfService.genSubUrNo(bean.getUrNo());
        		IpUrPhysicalInterfaceId id = new IpUrPhysicalInterfaceId(bean.getUrNo(), subUrNo.equals("0")?"PI00001":nextVal(subUrNo));
        		pi.setId(id);
        		pi.setUrType("NC");
        		pi.setIsTnp(nwConfigService.isTnp(pi.getIpNode()));
        		pi.setRowId(nwConfigService.genRowId());
        		if(!isRejecMode(bean))
        			pi.setChangeType("A");
        		
        		pi.setCreated(new Date());
        		pi.setCreated(new Date());
    			pi.setCreatedBy(sessionUser.getIpUser().getUserId());
    			phyIntfService.saveOrUpdate(pi);
        	}
        }
        
        List<IpUrPhysicalInterface> listPhyIntf = phyIntfService.findByUrNo(bean.getUrNo());
		bean.setListPhysicalInterface(listPhyIntf);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 
	
	public void editPhyInterfaceInit(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");
		
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		IpUrPhysicalInterface phyInterface = phyIntfService.findPhyInterface(urNo, subUrNo);
		IPPhyInterfaceBean piBean = bean.getPhyInterface();
		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			piBean.setRowNum(rowInt);
		}	
		
		piBean.setSearchResult(phyInterface);
		piBean.setIpNode(phyInterface.getIpNode());
		piBean.setHostName(phyInterface.getHostName());
		piBean.setMacAddress(phyInterface.getMacAddress());
		piBean.setLocation(phyInterface.getLocationName());
		piBean.setFloor(phyInterface.getFloor());
		piBean.setVlanID(phyInterface.getVlanId());
		piBean.setInterfaceDesc(phyInterface.getInterfaceDesc());
		piBean.setPiType(phyInterface.getPiType());
		
		IPFMRichComboItem nodeType = new IPFMRichComboItem(phyInterface.getInterfaceNodeId(), phyInterface.getInterfaceNodeDesc());
		piBean.setIntfNodeType(nodeType);
		
		IPFMRichComboItem nodePort = new IPFMRichComboItem(phyInterface.getPortStatusId(), phyInterface.getPortStatusDesc());
		piBean.setPortStatus(nodePort);
		
		IPFMRichComboItem nodeSpeed = new IPFMRichComboItem(phyInterface.getSpeedPortId(), phyInterface.getSpeedPortDesc());
		piBean.setSpeedPort(nodeSpeed);
		
		piBean.setEnclosure(phyInterface.getEnclosure());
		piBean.setReqRemark(phyInterface.getReqRemarks());
		
		piBean.setSubMode("EDIT");
		bean.setPhyInterface(piBean);
		setNetworkConfigBean(bean);
	}
	
//	public void editPhyInterface(){
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
//		IPPhyInterfaceBean piBean = bean.getPhyInterface();
//		UserSession sessionUser = IPFMWebUtil.getUserSession();
//		
//		
//		String validate = new PhysicalInterfaceValidate(piBean).validate();
//		if (IPFMMessageUtils.hasMessages()) {
////			bean.setErrorMsg(validate);
////			bean.setErrorFlag(true);
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//			return;
//		} else {
//			IpUrPhysicalInterface intf = piBean.getSearchResult();
//			
//			intf.setIpNode(piBean.getIpNode());
//			intf.setHostName(piBean.getHostName());
//			intf.setMacAddress(piBean.getMacAddress());
//			intf.setLocationName(piBean.getLocation());
//			intf.setFloor(piBean.getFloor());
//			intf.setVlanId(piBean.getVlanID());
//			intf.setInterfaceDesc(piBean.getInterfaceDesc());
//			
//			if(piBean.getIntfNodeType()!=null){
//				intf.setInterfaceNodeId(piBean.getIntfNodeType().getValue());
//				intf.setInterfaceNodeDesc(piBean.getIntfNodeType().getLabel());
//			}
//			
//			if(piBean.getPortStatus()!=null){
//				intf.setPortStatusId(piBean.getPortStatus().getValue());
//				intf.setPortStatusDesc(piBean.getPortStatus().getLabel());
//			}
//			
//			if(piBean.getSpeedPort()!=null){
//				intf.setSpeedPortId(piBean.getSpeedPort().getValue());
//				intf.setSpeedPortDesc(piBean.getSpeedPort().getLabel());
//			}
//			
//			intf.setEnclosure(piBean.getEnclosure());
//			intf.setReqRemarks(intf.getReqRemarks());
//	
//			intf.setCreated(new Date());
//			intf.setCreatedBy(sessionUser.getIpUser().getUserId());
//			phyIntfService.update(intf);
//			
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//		}
//		
//		List<IpUrPhysicalInterface> listPhyIntf = phyIntfService.findByUrNo(bean.getUrNo());
//		bean.setListPhysicalInterface(listPhyIntf);
//		bean.setPhyInterface(new IPPhyInterfaceBean());
//		setNetworkConfigBean(bean);
//	}
	
	public void deleteInterface(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		IpUrPhysicalInterface intf = phyIntfService.findPhyInterface(urNo, subUrNo);
		String changeType = (intf.getChangeType()!=null)?intf.getChangeType():""; 
		if(changeType.equals("A")){
			phyIntfService.delete(intf);
		} else {
			intf.setChangeType("D");
			phyIntfService.update(intf);
		}
		List<IpUrPhysicalInterface> listPhyIntf = phyIntfService.findByUrNo(bean.getUrNo());
		bean.setListPhysicalInterface(listPhyIntf);
		IPPhyInterfaceBean infBean = bean.getPhyInterface();
		infBean.setEnclosure("");
		infBean.setFloor("");
		infBean.setHostName("");
		infBean.setInterfaceDesc("");
		infBean.setIntfNodeType(new IPFMRichComboItem("",""));
		infBean.setIntfNodeTypeDesc("");
		infBean.setIpFound("");
		infBean.setIpNode("");
		infBean.setLocation("");
		infBean.setMacAddress("");
		infBean.setPortStatus(new IPFMRichComboItem("",""));
		infBean.setPortStatusDesc("");
		infBean.setReqRemark("");
		infBean.setSpeedPort(new IPFMRichComboItem("",""));
		infBean.setSpeedPortDesc("");
		infBean.setVlanID("");
		infBean.setSubMode("ADD");
		if(StringUtils.equals("T", bean.getPhyInterface().getPiType())){
			bean.getPhyInterface().setPiType("T");
		}
		bean.getPhyInterface().setCheckAll(false);
		setNetworkConfigBean(bean);
		
	}
	
	public void clearSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPPhyInterfaceBean intf = bean.getPhyInterface();
		intf.setIpFound("0");
		intf.setIpNode("");
		intf.setHostName("");
		intf.setMacAddress("");
		intf.setLocation("");
		intf.setVlanID("");
		intf.setReqRemark("");

		bean.setPhyInterface(intf);
		setNetworkConfigBean(bean);		
	}
	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestPhysicalInterface();
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
	        String fileName = ipfmConfigBean.getTemplateRequestPhysicalInterface();
	        downloadFile(path, fileName);	        
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	
	public List<SelectItem> getTrunkNo(){
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		List<SelectItem> listResult = new ArrayList<SelectItem>();
		List<IpMasterTable> listNodeType = phyIntfService.getProperty("TRUNK_NO");
		
		for(IpMasterTable nodeType : listNodeType){
			IPFMRichComboItem cbitem = new IPFMRichComboItem();
			cbitem.setLabel(nodeType.getShortDesc());
			cbitem.setValue(nodeType.getId().getRefKey());
			listResult.add(new SelectItem(cbitem, cbitem.getLabel()));
		}
		return listResult;
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
