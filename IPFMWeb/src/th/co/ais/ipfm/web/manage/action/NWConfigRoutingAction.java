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
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.domain1.IpUrRouting;
import th.co.ais.ipfm.domain1.IpUrRoutingId;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.service.RoutingService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPFirewallBean;
import th.co.ais.ipfm.web.manage.bean.IPRoutingBean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.RoutingValidate;


public class NWConfigRoutingAction extends AbstractAction{
	
	public NWConfigRoutingAction(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void addRouting(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		try {
			RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
			IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
			IPRoutingBean routingBean = bean.getRouting();
			
			//TODO:NAT
	        //System.out.println("inline -->>> " + lines.size());
	        
	        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
	        int recordRest = 0;
	        List<IpUrRouting> listRoutingC = routingService.findByUrNo(getNetworkConfigBean().getUrNo());
	        if(listRoutingC!=null && listRoutingC.size()>0) recordRest = listRoutingC.size();
	         
	        if((recordRest+1)>maxRecord) {     		
	        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
	        	bean.setErrorMsg("");	
	        	bean.setErrorFlag(false);
	           setNetworkConfigBean(bean);
	           return;
	        } 
	        //TODO:NAT
			
	        
			String validate = new RoutingValidate(routingBean).validate();
			if (IPFMMessageUtils.hasMessages()) {
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				return;
			}else {
				IpUrRouting routing = new IpUrRouting();
				IpUrRoutingId id = new IpUrRoutingId();
				id.setUrNo(bean.getUrNo());
				id.setSubUrNo(routingService.genSubUrNo(bean.getUrNo()));
				String subURNo = routingService.genSubUrNo(bean.getUrNo());
				id.setSubUrNo(subURNo.equals("0")?"RT00001":nextVal(subURNo));
				routing.setId(id);
				
				routing.setIpAddress(routingBean.getIpAddress());
				routing.setMask(routingBean.getMask());
				routing.setInterface(routingBean.getIntf());
				routing.setNextHop(routingBean.getNextHop());
				routing.setReqDesc(routingBean.getDescription());
				routing.setCreated(new Date());
				routing.setCreatedBy(sessionUser.getIpUser().getUserId());
				routing.setRowId(nwConfigService.genRowId());
				routing.setIsTnp(nwConfigService.isTnp(routing.getIpAddress()));
				routing.setUrType("NC");
				if(!isRejecMode(bean))
					routing.setChangeType("A");
				
					routingService.saveOrUpdate(routing);
	
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				bean.setRouting(new IPRoutingBean());
			}
			bean.getRouting().setCheckAll(false);
			List<IpUrRouting> listRouting = routingService.findByUrNo(bean.getUrNo());
			bean.setListRouting(listRouting);
			setNetworkConfigBean(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}

	public void editRouting(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		try {
			RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
			IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
			IPRoutingBean routingBean = bean.getRouting();
			
			String validate = new RoutingValidate(routingBean).validate();
			if (IPFMMessageUtils.hasMessages()) {
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				return;
			}else {
//				IpUrRouting routing = new IpUrRouting();
//				IpUrRoutingId id = new IpUrRoutingId();
//				id.setUrNo(bean.getUrNo());
//				id.setSubUrNo(routingService.genSubUrNo(bean.getUrNo()));
//				String subURNo = routingService.genSubUrNo(bean.getUrNo());
//				id.setSubUrNo(subURNo.equals("0")?"RT00001":nextVal(subURNo));
//				routing.setId(id);
				
				IpUrRouting routing = bean.getListRouting().get(routingBean.getRowNum());
				
				routing.setIpAddress(routingBean.getIpAddress());
				routing.setMask(routingBean.getMask());
				routing.setInterface(routingBean.getIntf());
				routing.setNextHop(routingBean.getNextHop());
				routing.setReqDesc(routingBean.getDescription());
				routing.setCreated(new Date());
				routing.setCreatedBy(sessionUser.getIpUser().getUserId());
				routing.setRowId(nwConfigService.genRowId());
				routing.setIsTnp(nwConfigService.isTnp(routing.getIpAddress()));
				routing.setUrType("NC");
				if(!isRejecMode(bean))
					routing.setChangeType("A");
				
					routingService.saveOrUpdate(routing);
	
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				routingBean.setSubMode("ADD");
				bean.setRouting(new IPRoutingBean());
			}
			bean.getRouting().setCheckAll(false);
			List<IpUrRouting> listRouting = routingService.findByUrNo(bean.getUrNo());
			bean.setListRouting(listRouting);
			setNetworkConfigBean(bean);
		} catch (IPFMBusinessException e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	
	public void findIPNode(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		RoutingService intfGatewayService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
		IPRoutingBean routingBean = bean.getRouting();
		
		IpInfo info = null;
		try {
			info = intfGatewayService.getIPInfoUsedStatus(routingBean.getIpAddress());
			routingBean.setIsFound((info!=null)?"1":"0");
			if(info == null) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),routingBean.getIpAddress()));
				return;
			}
		} catch (IPFMBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		bean.setRouting(routingBean);
		setNetworkConfigBean(bean);		
	}
	
	private String nextVal(String subUrNo){
		String resultString = "RT";
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
		RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrRouting rsRouting = routingService.findFirewall(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		IPRoutingBean routingBean = new IPRoutingBean();
		routingBean.setSearchResult(rsRouting);
//		routingBean.setJobAssign(jobAssign);
		routingBean.setJobAssignList(jobAssignList);
		bean.setRouting(routingBean);
		setNetworkConfigBean(bean);
	}
	
	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",2);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrRouting> routingList = new ArrayList<IpUrRouting>();

      //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord();
        int recordRest = 0;
        List<IpUrRouting> listRoutingC = routingService.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listRoutingC!=null && listRoutingC.size()>0) recordRest = maxRecord - listRoutingC.size();
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
        	IPRoutingBean routingBean = new IPRoutingBean();
        	routingBean.setIpAddress(data.get(0));
        	routingBean.setMask(data.get(1));
        	routingBean.setIntf(data.get(2));
        	routingBean.setNextHop(data.get(3));
        	routingBean.setDescription(data.get(4));
        	 
        	String validateResult = new RoutingValidate(routingBean).validate();
        	
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
        		IpUrRouting subUr = new IpUrRouting();
	        	
        		subUr.setIpAddress(routingBean.getIpAddress());
        		subUr.setMask(routingBean.getMask());
        		subUr.setInterface(routingBean.getIntf());
        		subUr.setNextHop(routingBean.getNextHop());
        		subUr.setReqDesc(routingBean.getDescription());
				
        		routingList.add(subUr);
        	}
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        if(validate.size()==0){
        	for(IpUrRouting rt : routingList){
        		String subUrNo = routingService.genSubUrNo(bean.getUrNo());
        		IpUrRoutingId id = new IpUrRoutingId(bean.getUrNo(), subUrNo.equals("0")?"RT00001":nextVal(subUrNo));
        		rt.setId(id);
        		rt.setUrType("NC");
        		rt.setIsTnp(nwConfigService.isTnp(rt.getIpAddress()));
        		if(!isRejecMode(bean))
        			rt.setChangeType("A");
        		
        		rt.setRowId(nwConfigService.genRowId());
        		rt.setCreated(new Date());
        		rt.setCreated(new Date());
    			rt.setCreatedBy(sessionUser.getIpUser().getUserId());
    			routingService.saveOrUpdate(rt);
        	}
        }
        
        List<IpUrRouting> listRouting = routingService.findByUrNo(bean.getUrNo());
		bean.setListRouting(listRouting);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 
	
	public void editRoutingInit(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");
		RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
		IpUrRouting routing = routingService.findFirewall(urNo, subUrNo);
		IPRoutingBean rtBean = bean.getRouting();
		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			rtBean.setRowNum(rowInt);
		}
		rtBean.setSearchResult(routing);
		rtBean.setIpAddress(routing.getIpAddress());
		rtBean.setMask(routing.getMask());
		rtBean.setIntf(routing.getInterface());
		rtBean.setNextHop(routing.getNextHop());
		rtBean.setDescription(routing.getReqDesc());
		rtBean.setSubMode("EDIT");
		bean.setRouting(rtBean);
		setNetworkConfigBean(bean);
	}
	
//	public void editRouting(){
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
//		IPRoutingBean rtBean = bean.getRouting();
//		UserSession sessionUser = IPFMWebUtil.getUserSession();
//		try {
//			
//			String validate = new RoutingValidate(rtBean).validate();
//			if (IPFMMessageUtils.hasMessages()) {
////				bean.setErrorMsg(validate);
////				bean.setErrorFlag(true);
//				bean.setErrorMsg("");
//				bean.setErrorFlag(false);
//				return;
//			}else {
//				IpUrRouting routing = rtBean.getSearchResult();
//				
//				routing.setIpAddress(rtBean.getIpAddress());
//				routing.setMask(rtBean.getMask());
//				routing.setInterface(rtBean.getIntf());
//				routing.setNextHop(rtBean.getNextHop());
//				routing.setReqDesc(rtBean.getDescription());
//				routing.setLastUpd(new Date());
//				routing.setLastUpdBy(sessionUser.getIpUser().getUserId());
//				
//					routingService.saveOrUpdate(routing);
//	
//				bean.setErrorMsg("");
//				bean.setErrorFlag(false);
//			}
//			
//			List<IpUrRouting> listRouting = routingService.findByUrNo(bean.getUrNo());
//			bean.setListRouting(listRouting);
//			bean.setRouting(new IPRoutingBean());
//			setNetworkConfigBean(bean);
//		
//		} catch (IPFMBusinessException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void deleteRouting(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
		IpUrRouting routing = routingService.findFirewall(urNo, subUrNo);
		String changeType = (routing.getChangeType()!=null)?routing.getChangeType():""; 
		if(changeType.equals("A")){
			routingService.delete(routing);
		} else {
			routing.setChangeType("D");
			routingService.update(routing);
		}
		List<IpUrRouting> listRouting = routingService.findByUrNo(bean.getUrNo());
		bean.setListRouting(listRouting);
		IPRoutingBean rtBean = bean.getRouting();
		rtBean.setDescription("");
		rtBean.setIntf("");
		rtBean.setIpAddress("");
		rtBean.setIsFound("");
		rtBean.setMask("");
		rtBean.setNextHop("");
		rtBean.setSubMode("ADD");
		bean.getRouting().setCheckAll(false);
		setNetworkConfigBean(bean);
		
	}
	
	public void clearDestIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPRoutingBean routing = bean.getRouting();
		routing.setIsFound("0");
		routing.setIpAddress("");
		bean.setRouting(routing);
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
	        String fileName = ipfmConfigBean.getTemplateRequestRouting();
	        downloadFile(path, fileName);	        
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }
	
	public void clearSourceIP(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPRoutingBean routing = bean.getRouting();
		routing.setIsFound("0");
		routing.setIpAddress("");
		routing.setIntf("");
		routing.setNextHop("");
		bean.setRouting(routing);
		setNetworkConfigBean(bean);		
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
