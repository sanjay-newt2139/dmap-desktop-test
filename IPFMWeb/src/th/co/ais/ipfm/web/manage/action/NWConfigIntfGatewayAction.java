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
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrInterfaceGateway;
import th.co.ais.ipfm.domain1.IpUrInterfaceGatewayId;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.service.IntfGatewayService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPFirewallBean;
import th.co.ais.ipfm.web.manage.bean.IPIntfGatewayBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.IntfGatewayValidate;


public class NWConfigIntfGatewayAction extends AbstractAction {
	private List<SelectItem> networkType;
	
	public NWConfigIntfGatewayAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void editIntfGateway(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
	 try{
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPIntfGatewayBean gatewayBean = bean.getGateway();
		
		String validate = new IntfGatewayValidate(gatewayBean).validate();
		if (IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return;
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
		
//			IpUrInterfaceGateway intf = new IpUrInterfaceGateway();
//			IpUrInterfaceGatewayId id = new IpUrInterfaceGatewayId();
//			id.setUrNo(bean.getUrNo());
//			id.setSubUrNo(intfGatewayService.genSubUrNo(bean.getUrNo()));
//			String subURNo = intfGatewayService.genSubUrNo(bean.getUrNo());
//			id.setSubUrNo(subURNo.equals("0")?"IG00001":nextVal(subURNo));
//			intf.setId(id);
			IpUrInterfaceGateway intf = bean.getListGateway().get(bean.getGateway().getRowNum());
			
			intf.setIpAddress(gatewayBean.getIpAddress());
			intf.setMask(gatewayBean.getMask());
			
			if(gatewayBean.getNetworkType()!=null){
				intf.setNetworkTypeId(gatewayBean.getNetworkType().getValue());
				intf.setNetworkTypeDesc(gatewayBean.getNetworkType().getLabel());
			}
			
			intf.setLocationName(gatewayBean.getLocation());
			intf.setReqVlanId(gatewayBean.getVlanID());
			intf.setReqDesc(gatewayBean.getDescription());
			
			intf.setIsTnp(nwConfigService.isTnp(intf.getIpAddress()));
			intf.setUrType("NC");
			if(!isRejecMode(bean))
				intf.setChangeType("A");
	
			intf.setCreated(new Date());
			intf.setCreatedBy(sessionUser.getIpUser().getUserId());
			intf.setRowId(nwConfigService.genRowId());
			intfGatewayService.saveOrUpdate(intf);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			bean.setGateway(new IPIntfGatewayBean());
			bean.getGateway().setCheckAll(false);
			gatewayBean.setSubMode("ADD");
		}
		
		List<IpUrInterfaceGateway> listGateway = intfGatewayService.findByUrNo(bean.getUrNo());
		bean.setListGateway(listGateway);
		
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}	
	
	public void addIntfGateway(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
	 try{
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPIntfGatewayBean gatewayBean = bean.getGateway();
		
		//TODO:NAT
        //System.out.println("inline -->>> " + lines.size());
        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
        int recordRest = 0;
        List<IpUrInterfaceGateway> listGatewayC = intfGatewayService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listGatewayC!=null && listGatewayC.size()>0) recordRest = listGatewayC.size();
         
        if((recordRest+1)>maxRecord) {     		
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
        	bean.setErrorMsg("");	
        	bean.setErrorFlag(false);
           setNetworkConfigBean(bean);
           return;
        } 
        //TODO:NAT
        
		
		String validate = new IntfGatewayValidate(gatewayBean).validate();
		if (IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return;
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
		
			IpUrInterfaceGateway intf = new IpUrInterfaceGateway();
			IpUrInterfaceGatewayId id = new IpUrInterfaceGatewayId();
			id.setUrNo(bean.getUrNo());
			id.setSubUrNo(intfGatewayService.genSubUrNo(bean.getUrNo()));
			String subURNo = intfGatewayService.genSubUrNo(bean.getUrNo());
			id.setSubUrNo(subURNo.equals("0")?"IG00001":nextVal(subURNo));
			intf.setId(id);
			
			intf.setIpAddress(gatewayBean.getIpAddress());
			intf.setMask(gatewayBean.getMask());
			
			if(gatewayBean.getNetworkType()!=null){
				intf.setNetworkTypeId(gatewayBean.getNetworkType().getValue());
				intf.setNetworkTypeDesc(gatewayBean.getNetworkType().getLabel());
			}
			
			intf.setLocationName(gatewayBean.getLocation());
			intf.setReqVlanId(gatewayBean.getVlanID());
			intf.setReqDesc(gatewayBean.getDescription());
			
			intf.setIsTnp(nwConfigService.isTnp(intf.getIpAddress()));
			intf.setUrType("NC");
			if(!isRejecMode(bean))
				intf.setChangeType("A");
	
			intf.setCreated(new Date());
			intf.setCreatedBy(sessionUser.getIpUser().getUserId());
			intf.setRowId(nwConfigService.genRowId());
			intfGatewayService.saveOrUpdate(intf);
			
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			bean.setGateway(new IPIntfGatewayBean());
		}
		bean.getGateway().setCheckAll(false);
		List<IpUrInterfaceGateway> listGateway = intfGatewayService.findByUrNo(bean.getUrNo());
		bean.setListGateway(listGateway);
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void findIPNode(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		IPIntfGatewayBean gatewayBean = bean.getGateway();
		IpInfo info = intfGatewayService.getIPInfoWithUsedStatus(gatewayBean.getIpAddress());
		gatewayBean.setIpFound("0");
		if(info!=null){
			gatewayBean.setLocation(info.getLocationName());
			gatewayBean.setIpFound("1");
		} else {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Interface Gateway  IP Node"));
		}
		bean.setGateway(gatewayBean);
		setNetworkConfigBean(bean);		
	}
	
	private String nextVal(String subUrNo){
		String resultString = "IG";
		int no =  Integer.parseInt(subUrNo.substring(2));
		String nnn = String.valueOf(++no);
		for(int i=0;i<5-nnn.length();i++) resultString+="0";
		resultString+=nnn;
		return resultString;
	}
	
	public List<SelectItem> getNetworkType() {
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		List<SelectItem> listResult = new ArrayList<SelectItem>();
		List<IpMasterTable> listNodeType = intfGatewayService.getProperty("NW_TYPE");
		
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
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrInterfaceGateway rsGateway = intfGatewayService.findFirewall(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		IPIntfGatewayBean gatewayBean = new IPIntfGatewayBean();
		gatewayBean.setSearchResult(rsGateway);
//		gatewayBean.setJobAssign(jobAssign);
		gatewayBean.setJobAssignList(jobAssignList);
		bean.setGateway(gatewayBean);
		setNetworkConfigBean(bean);
	}
	
	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",2);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrInterfaceGateway> gatewayList = new ArrayList<IpUrInterfaceGateway>();
        
        IntfGatewayValidate intfGWValidate =  new IntfGatewayValidate();
        
      //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord();
        int recordRest = 0;
        List<IpUrInterfaceGateway> listGarewayC = intfGatewayService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listGarewayC!=null && listGarewayC.size()>0) recordRest = maxRecord - listGarewayC.size();
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
        	IPIntfGatewayBean gatewayBean = new IPIntfGatewayBean();
        	gatewayBean.setIpAddress(data.get(0));
        	gatewayBean.setMask(data.get(1));
        	gatewayBean.setNetworkType(new IPFMRichComboItem("",data.get(2)));
        	gatewayBean.setNetworkTypeDesc(data.get(2));
        	gatewayBean.setVlanID(data.get(3));
        	gatewayBean.setDescription(data.get(4));
        	 
        	intfGWValidate.setIntfGateway(gatewayBean);
        	String validateResult = intfGWValidate.validate();
        	
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
        		IpUrInterfaceGateway subUr = new IpUrInterfaceGateway();
	        	
	        	// source 
	        	IpInfo infoSource = intfGatewayService.getIPInfo(gatewayBean.getIpAddress());
	        	if(infoSource!=null){
	        		subUr.setLocationName(infoSource.getLocationName());
	        	}
	        	
	        	subUr.setIpAddress(gatewayBean.getIpAddress());
	        	subUr.setMask(gatewayBean.getMask());
	        	
	        	String nwDesc = gatewayBean.getNetworkTypeDesc();
				subUr.setNetworkTypeId(intfGatewayService.getNetworkTypeId(nwDesc));
				subUr.setNetworkTypeDesc(nwDesc);
				
				subUr.setLocationName(gatewayBean.getLocation());
				subUr.setReqVlanId(gatewayBean.getVlanID());
				subUr.setReqDesc(gatewayBean.getDescription());
				
				subUr.setIsTnp(nwConfigService.isTnp(subUr.getIpAddress()));
				subUr.setUrType("NC");
				subUr.setCreated(new Date());
				subUr.setCreatedBy(sessionUser.getIpUser().getUserId());
				
				gatewayList.add(subUr);
        	}
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        if(validate.size()==0){
        	for(IpUrInterfaceGateway ig : gatewayList){
        		String subUrNo = intfGatewayService.genSubUrNo(bean.getUrNo());
        		IpUrInterfaceGatewayId id = new IpUrInterfaceGatewayId(bean.getUrNo(), subUrNo.equals("0")?"IG00001":nextVal(subUrNo));
        		ig.setId(id);
        		ig.setUrType("NC");
        		if(!isRejecMode(bean))
        			ig.setChangeType("A");
        		
        		ig.setRowId(nwConfigService.genRowId());
        		ig.setIsTnp(nwConfigService.isTnp(ig.getIpAddress()));
        		ig.setCreated(new Date());
        		ig.setCreated(new Date());
    			ig.setCreatedBy(sessionUser.getIpUser().getUserId());
    			intfGatewayService.saveOrUpdate(ig);
        	}
        }
        
        List<IpUrInterfaceGateway> listGareway = intfGatewayService.findByUrNo(bean.getUrNo());
		bean.setListGateway(listGareway);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 

	public void editGatewayInit(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		IpUrInterfaceGateway gateway = intfGatewayService.findFirewall(urNo, subUrNo);
		IPIntfGatewayBean igBean = bean.getGateway();
		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			igBean.setRowNum(rowInt);
		}	
		igBean.setSearchResult(gateway);
		igBean.setIpAddress(gateway.getIpAddress());
		igBean.setMask(gateway.getMask());
		
		IPFMRichComboItem nwType = new IPFMRichComboItem(gateway.getNetworkTypeId(), gateway.getNetworkTypeDesc());
		igBean.setNetworkType(nwType);
		
		igBean.setLocation(gateway.getLocationName());
		igBean.setVlanID(gateway.getReqVlanId());
		igBean.setDescription(gateway.getReqDesc());
		igBean.setSubMode("EDIT");
		bean.setGateway(igBean);
		setNetworkConfigBean(bean);
	}
	
//	public void editGateway(){
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
//		IPIntfGatewayBean igBean = bean.getGateway();
//		UserSession sessionUser = IPFMWebUtil.getUserSession();
//		
//		
//		String validate = new IntfGatewayValidate(igBean).validate();
//		if (IPFMMessageUtils.hasMessages()) {
////			bean.setErrorMsg(validate);
////			bean.setErrorFlag(true);
//			bean.setErrorMsg("");
//			bean.setErrorFlag(false);
//			return;
//		} else {
//			IpUrInterfaceGateway gateway = igBean.getSearchResult();
//			
//			gateway.setIpAddress(igBean.getIpAddress());
//			gateway.setMask(igBean.getMask());
//			
//			if(igBean.getNetworkType()!=null){
//				gateway.setNetworkTypeId(igBean.getNetworkType().getValue());
//				gateway.setNetworkTypeDesc(igBean.getNetworkType().getLabel());
//			}
//			
//			gateway.setLocationName(igBean.getLocation());
//			gateway.setReqVlanId(igBean.getVlanID());
//			gateway.setReqDesc(igBean.getDescription());
//	
//			gateway.setLastUpd(new Date());
//			gateway.setLastUpdBy(sessionUser.getIpUser().getUserId());
//			intfGatewayService.update(gateway);
//		}
//		
//		List<IpUrInterfaceGateway> listGateway = intfGatewayService.findByUrNo(bean.getUrNo());
//		bean.setListGateway(listGateway);
//		bean.setGateway(new IPIntfGatewayBean());
//		setNetworkConfigBean(bean);
//	}
	
	public void deleteGateway(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		IpUrInterfaceGateway gateway = intfGatewayService.findFirewall(urNo, subUrNo);
		String changeType = (gateway.getChangeType()!=null)?gateway.getChangeType():""; 
		if(changeType.equals("A")){
			intfGatewayService.delete(gateway);
		} else {
			gateway.setChangeType("D");
			intfGatewayService.update(gateway);
		}
		List<IpUrInterfaceGateway> listGateway = intfGatewayService.findByUrNo(bean.getUrNo());
		bean.setListGateway(listGateway);
		IPIntfGatewayBean igBean = bean.getGateway();
		igBean.setSubMode("ADD");
		igBean.setDescription("");
		igBean.setIpAddress("");
		igBean.setIpFound("");
		igBean.setLocation("");
		igBean.setMask("");
		igBean.setNetworkType(new IPFMRichComboItem("",""));
		igBean.setNetworkTypeDesc("");
		igBean.setDescription("");
		igBean.setVlanID("");
		bean.getGateway().setCheckAll(false);
		setNetworkConfigBean(bean);
		
	}
	
	public void clearSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPIntfGatewayBean gateway = bean.getGateway();
		gateway.setIpFound("0");
		gateway.setIpAddress("");
		gateway.setLocation("");
		bean.setGateway(gateway);
		setNetworkConfigBean(bean);		
	}
	
	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestInterfaceGateway();
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
	        String fileName = ipfmConfigBean.getTemplateRequestInterfaceGateway();
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
