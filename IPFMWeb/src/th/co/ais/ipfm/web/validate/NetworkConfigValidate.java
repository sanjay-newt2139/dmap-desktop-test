package th.co.ais.ipfm.web.validate;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import th.co.ais.ipfm.domain1.IpUrPhysicalInterface;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;

public class NetworkConfigValidate {
	
	private ReqNWConfigBean bean;
	public NetworkConfigValidate(){
	}
	
	public NetworkConfigValidate(ReqNWConfigBean bean){
		this.bean = bean;
	}

	public void setBean(ReqNWConfigBean bean) {
		this.bean = bean;
	}
	
	public boolean validate() {
		boolean flagValid = true;
		if((bean.getSubject()==null) || (bean.getSubject().equals(""))){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Subject"));
			flagValid = false;
		}
		if((bean.getObjective()==null) || (bean.getObjective().equals(""))){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Objective"));
			flagValid = false;
		}

		if((bean.getIsPeroiod()==null) || (bean.getIsPeroiod().equals(""))){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Period"));
			flagValid = false;
		} else if(bean.getIsPeroiod().equals("Y")){
			
			if(bean.getPeriodStart()==null){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Start Date"));
				flagValid = false;
			} else {
				try {
					if (IPFMDataUtility.convertDateByPattern(bean.getPeriodStart()).before(IPFMDataUtility.convertDateByPattern(new Date()))) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0041")));
						flagValid = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(bean.getPeriodEnd()==null){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "End Date"));
				flagValid = false;
			}
			
			try{
				if(!(bean.getPeriodStart()==null) && !(bean.getPeriodEnd()==null)){
					if(bean.getPeriodEnd().before(bean.getPeriodStart())){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0023")));
						flagValid = false;
					}

				}
			} catch (Exception ex){
				
			}
		}
		if((bean.getRequestFor()==null) || (bean.getRequestFor().equals(""))){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Request For"));
			flagValid = false;
		}
		
		if(!(bean.getFirewallCheck() || bean.getAccessListCheck() || bean.getAccessTNPCheck()
			|| bean.getPhysicalCheck() || bean.getGatewayCheck() || bean.getRoutingCheck() || bean.getF5Check())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0024")));
			flagValid = false;
		}
		
		if((bean.getListFirewall()== null || bean.getListFirewall().size() == 0) && 
				(bean.getListAccessList()== null || bean.getListAccessList().size() == 0) && 
				(bean.getListAccessTNP()== null || bean.getListAccessTNP().size() == 0) && 
				(bean.getListGateway()== null || bean.getListGateway().size() == 0)&& 
				(bean.getListF5()== null || bean.getListF5().size() == 0) && 
				(bean.getListRouting()== null || bean.getListRouting().size() == 0) && 
				(bean.getListPhysicalInterface()== null || bean.getListPhysicalInterface().size() == 0)) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0078")));
			flagValid = false;			
		}
		
		if (bean.getFirewallCheck() && (bean.getListFirewall()== null || bean.getListFirewall().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Firewall"));
			flagValid = false;	
		}
		if (bean.getAccessListCheck() && (bean.getListAccessList()== null || bean.getListAccessList().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Access List For CDN"));
			flagValid = false;	
		}
		if (bean.getAccessTNPCheck() && (bean.getListAccessTNP()== null || bean.getListAccessTNP().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Access List For TNP"));
			flagValid = false;	
		}		
		if (bean.getPhysicalCheck() && (bean.getListPhysicalInterface()== null || bean.getListPhysicalInterface().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Physical Interface"));
			flagValid = false;	
		}
		if (bean.getGatewayCheck() && (bean.getListGateway()== null || bean.getListGateway().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Interface Gateway"));
			flagValid = false;	
		}
		if (bean.getRoutingCheck() && (bean.getListRouting()== null || bean.getListRouting().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Routing"));
			flagValid = false;	
		}		
		if (bean.getF5Check() && (bean.getListF5()== null || bean.getListF5().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"F5"));
			flagValid = false;	
		}
		
		if((bean.getSelectedManager()==null) || (bean.getSelectedManager().size()==0)){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0037")));
			flagValid = false;
		}
		return flagValid;
		
		
	}
	
	public boolean validateSaveDraft(){
		boolean flagValid = true;
		
		if(!(bean.getFirewallCheck() || bean.getAccessListCheck() || bean.getAccessTNPCheck()
			|| bean.getPhysicalCheck() || bean.getGatewayCheck() || bean.getRoutingCheck() || bean.getF5Check())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0024")));
			flagValid = false;
		}
		
		if((bean.getListFirewall()== null || bean.getListFirewall().size() == 0) && 
				(bean.getListAccessList()== null || bean.getListAccessList().size() == 0) && 
				(bean.getListAccessTNP()== null || bean.getListAccessTNP().size() == 0) && 
				(bean.getListGateway()== null || bean.getListGateway().size() == 0)&& 
				(bean.getListF5()== null || bean.getListF5().size() == 0) && 
				(bean.getListRouting()== null || bean.getListRouting().size() == 0) && 
				(bean.getListPhysicalInterface()== null || bean.getListPhysicalInterface().size() == 0)) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0078")));
			flagValid = false;			
		}
		
		if (bean.getFirewallCheck() && (bean.getListFirewall()== null || bean.getListFirewall().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Firewall"));
			flagValid = false;	
		}
		if (bean.getAccessListCheck() && (bean.getListAccessList()== null || bean.getListAccessList().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Access List For CDN"));
			flagValid = false;	
		}
		if (bean.getAccessTNPCheck() && (bean.getListAccessTNP()== null || bean.getListAccessTNP().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Access List For TNP"));
			flagValid = false;	
		}		
		if (bean.getPhysicalCheck() && (bean.getListPhysicalInterface()== null || bean.getListPhysicalInterface().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Physical Interface"));
			flagValid = false;	
		}
		if (bean.getGatewayCheck() && (bean.getListGateway()== null || bean.getListGateway().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Interface Gateway"));
			flagValid = false;	
		}
		if (bean.getRoutingCheck() && (bean.getListRouting()== null || bean.getListRouting().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"Routing"));
			flagValid = false;	
		}		
		if (bean.getF5Check() && (bean.getListF5()== null || bean.getListF5().size() == 0) ){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0092"),"F5"));
			flagValid = false;	
		}
		
		return flagValid;
		
		
	}
	
	public String checkUnProcess(List list) throws Exception {
		String result = "";
		int index = 0;
		try{
			for(Object obj : list){
				
				Field fieldIsApprove = obj.getClass().getDeclaredField("isApprove");
				fieldIsApprove.setAccessible(true);
				String isApprove = (String)fieldIsApprove.get(obj);
				fieldIsApprove.setAccessible(false);
				
				Field fieldIsReject = obj.getClass().getDeclaredField("isReject");
				fieldIsReject.setAccessible(true);
				String isReject = (String)fieldIsReject.get(obj);
				fieldIsReject.setAccessible(false);
				
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);
				Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
				fieldSubUrNO.setAccessible(true);
				String subUrNo = (String)fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);
				fieldId.setAccessible(false);
				
				
				if((isApprove==null || isApprove.equals(""))
						&& (isReject==null || isReject.equals(""))){
					result+=(","+subUrNo);
				}
				index++;
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return (result.equals(""))?result:result.substring(1); 
	}
	
	public String checkUnProcessForTrunk(List list) throws Exception {
		String result = "";
		int index = 0;
		try{
			for(Object obj : list){
				
				if(obj instanceof IpUrPhysicalInterface){
				
					Field fieldPiType = obj.getClass().getDeclaredField("piType");
					fieldPiType.setAccessible(true);
					String piType = (String)fieldPiType.get(obj);
					fieldPiType.setAccessible(false);
					
					Field fieldTrunkFlag = obj.getClass().getDeclaredField("trunkFlag");
					fieldTrunkFlag.setAccessible(true);
					String trunkFlag = (String)fieldTrunkFlag.get(obj);
					fieldTrunkFlag.setAccessible(false);
					
					if(StringUtils.equals("T", piType) && StringUtils.equals("N", trunkFlag)){
						continue;
					}
				}
				Field fieldIsApprove = obj.getClass().getDeclaredField("isApprove");
				fieldIsApprove.setAccessible(true);
				String isApprove = (String)fieldIsApprove.get(obj);
				fieldIsApprove.setAccessible(false);
				
				Field fieldIsReject = obj.getClass().getDeclaredField("isReject");
				fieldIsReject.setAccessible(true);
				String isReject = (String)fieldIsReject.get(obj);
				fieldIsReject.setAccessible(false);
				
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);
				Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
				fieldSubUrNO.setAccessible(true);
				String subUrNo = (String)fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);
				fieldId.setAccessible(false);
				
				
				if((isApprove==null || isApprove.equals(""))
						&& (isReject==null || isReject.equals(""))){
					result+=(","+subUrNo);
				}
				index++;
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return (result.equals(""))?result:result.substring(1); 
	}
	
	public String checkRemark(List list , String urStatus)throws Exception {
		String result = "";
		int index = 0;
		try{
			Field FieldSysOwnerRemark = null;
			for(Object obj : list){
//				if(obj instanceof IpUrPhysicalInterface){
//					Field fieldPiType = obj.getClass().getDeclaredField("piType");
//					fieldPiType.setAccessible(true);
//					String piType = (String)fieldPiType.get(obj);
//					fieldPiType.setAccessible(false);
//					
//					Field fieldTrunkFlag = obj.getClass().getDeclaredField("trunkFlag");
//					fieldTrunkFlag.setAccessible(true);
//					String trunkFlag = (String)fieldTrunkFlag.get(obj);
//					fieldTrunkFlag.setAccessible(false);
//					
//					if(StringUtils.equals("T", piType) && StringUtils.equals("N", trunkFlag)){
//						continue;
//					}
//				}
				
				if (urStatus!=null && urStatus.equals(IPFMConstant.STATUS_WAIT_OWNER))  {
					FieldSysOwnerRemark = obj.getClass().getDeclaredField("sysOwnerRemark");
				}else if (urStatus!=null && urStatus.equals(IPFMConstant.STATUS_WAIT_TEAM))  {
					FieldSysOwnerRemark = obj.getClass().getDeclaredField("teamRemark");
				}else{
					FieldSysOwnerRemark = obj.getClass().getDeclaredField("sysOwnerRemark");
				}
				FieldSysOwnerRemark.setAccessible(true);
				String sysOwnerRemark = (String)FieldSysOwnerRemark.get(obj);
				FieldSysOwnerRemark.setAccessible(false);
				
				Field fieldIsReject = obj.getClass().getDeclaredField("isReject");
				fieldIsReject.setAccessible(true);
				String isReject = (String)fieldIsReject.get(obj);
				fieldIsReject.setAccessible(false);
				
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);
				Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
				fieldSubUrNO.setAccessible(true);
				String subUrNo = (String)fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);
				fieldId.setAccessible(false);
				
				
				if(isReject != null ) {
					if((isReject.equals("Y")) && (sysOwnerRemark==null || sysOwnerRemark.equals(""))){
						result+=(","+subUrNo);
					}
				} else {
					if((sysOwnerRemark==null || sysOwnerRemark.equals(""))) {
						result+=("," + subUrNo);
					}
				}
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return (result.equals(""))?result:result.substring(1); 
	}
	
	public String checkRemarkForTrunk(List list , String urStatus)throws Exception {
		String result = "";
		int index = 0;
		try{
			Field FieldSysOwnerRemark = null;
			for(Object obj : list){
				if(obj instanceof IpUrPhysicalInterface){
					Field fieldPiType = obj.getClass().getDeclaredField("piType");
					fieldPiType.setAccessible(true);
					String piType = (String)fieldPiType.get(obj);
					fieldPiType.setAccessible(false);
					
					Field fieldTrunkFlag = obj.getClass().getDeclaredField("trunkFlag");
					fieldTrunkFlag.setAccessible(true);
					String trunkFlag = (String)fieldTrunkFlag.get(obj);
					fieldTrunkFlag.setAccessible(false);
					
					if(StringUtils.equals("T", piType) && StringUtils.equals("N", trunkFlag)){
						continue;
					}
				}
				
				if (urStatus!=null && urStatus.equals(IPFMConstant.STATUS_WAIT_OWNER))  {
					FieldSysOwnerRemark = obj.getClass().getDeclaredField("sysOwnerRemark");
				}else if (urStatus!=null && urStatus.equals(IPFMConstant.STATUS_WAIT_TEAM))  {
					FieldSysOwnerRemark = obj.getClass().getDeclaredField("teamRemark");
				}else{
					FieldSysOwnerRemark = obj.getClass().getDeclaredField("sysOwnerRemark");
				}
				FieldSysOwnerRemark.setAccessible(true);
				String sysOwnerRemark = (String)FieldSysOwnerRemark.get(obj);
				FieldSysOwnerRemark.setAccessible(false);
				
				Field fieldIsReject = obj.getClass().getDeclaredField("isReject");
				fieldIsReject.setAccessible(true);
				String isReject = (String)fieldIsReject.get(obj);
				fieldIsReject.setAccessible(false);
				
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);
				Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
				fieldSubUrNO.setAccessible(true);
				String subUrNo = (String)fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);
				fieldId.setAccessible(false);
				
				
				if(isReject != null ) {
					if((isReject.equals("Y")) && (sysOwnerRemark==null || sysOwnerRemark.equals(""))){
						result+=(","+subUrNo);
					}
				} else {
					if((sysOwnerRemark==null || sysOwnerRemark.equals(""))) {
						result+=("," + subUrNo);
					}
				}
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return (result.equals(""))?result:result.substring(1); 
	}
	
	public String checkACTMRemark(List list){
		String result = "";
		int index = 0;
		try{
			for(Object obj : list){
				if(obj instanceof IpUrPhysicalInterface){
					Field fieldPiType = obj.getClass().getDeclaredField("piType");
					fieldPiType.setAccessible(true);
					String piType = (String)fieldPiType.get(obj);
					fieldPiType.setAccessible(false);
					
					Field trunkFlagType = obj.getClass().getDeclaredField("trunkFlag");
					trunkFlagType.setAccessible(true);
					String trunkFlag = (String)trunkFlagType.get(obj);
					trunkFlagType.setAccessible(false);
					
					Field trunkNoType = obj.getClass().getDeclaredField("trunkNo");
					trunkNoType.setAccessible(true);
					String trunkNo = (String)trunkNoType.get(obj);
					trunkNoType.setAccessible(false);
					
					if(StringUtils.equals("T", piType) && StringUtils.equals("N", trunkFlag)){
						continue;
					}
				}
				Field fieldACTMRemark = obj.getClass().getDeclaredField("actmRemark");
				fieldACTMRemark.setAccessible(true);
				String sysOwnerRemark = (String)fieldACTMRemark.get(obj);
				fieldACTMRemark.setAccessible(false);
				
				
				
				Field fieldId = obj.getClass().getDeclaredField("id");
				fieldId.setAccessible(true);
				Object idObj = fieldId.get(obj);
				Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
				fieldSubUrNO.setAccessible(true);
				String subUrNo = (String)fieldSubUrNO.get(idObj);
				fieldSubUrNO.setAccessible(false);
				fieldId.setAccessible(false);
				
				
				
				if(sysOwnerRemark.equals("") || sysOwnerRemark==null){
					result+=(","+subUrNo);
				}
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (result.equals(""))?result:result.substring(1); 
	}
	
	public String checkPIAssignDetail(List list) {
		String result = "";
		int index = 0;
		try{
			for(Object obj : list){
//				if(obj instanceof IpUrPhysicalInterface){
//					Field fieldPiType = obj.getClass().getDeclaredField("piType");
//					fieldPiType.setAccessible(true);
//					String piType = (String)fieldPiType.get(obj);
//					fieldPiType.setAccessible(false);
//					
//					Field trunkFlagType = obj.getClass().getDeclaredField("trunkFlag");
//					trunkFlagType.setAccessible(true);
//					String trunkFlag = (String)trunkFlagType.get(obj);
//					trunkFlagType.setAccessible(false);
//					
//					Field trunkNoType = obj.getClass().getDeclaredField("trunkNo");
//					trunkNoType.setAccessible(true);
//					String trunkNo = (String)trunkNoType.get(obj);
//					trunkNoType.setAccessible(false);
//					
//					if(StringUtils.equals("T", piType) && StringUtils.equals("N", trunkFlag)){
//						continue;
//					}
//				}
				
				Field fieldIsReject = obj.getClass().getDeclaredField("isReject");
				Field fieldIsApprove = obj.getClass().getDeclaredField("isApprove");
				fieldIsReject.setAccessible(true);
				String isReject = (String)fieldIsReject.get(obj);
				fieldIsReject.setAccessible(false);
				
				fieldIsApprove.setAccessible(true);
				String isApprove = (String)fieldIsApprove.get(obj);
				fieldIsApprove.setAccessible(false);
				
				if ((isApprove==null || isApprove.equals("")) && (isReject == null || isReject.equals(""))) {
					continue;
				}
				
				if(isReject == null || isReject.equals("") || isReject.equals("N")) {
					Field networkRackName = obj.getClass().getDeclaredField("networkRackName");
					networkRackName.setAccessible(true);
					String networkRackNameStr = (String)networkRackName.get(obj);
					networkRackName.setAccessible(false);
					
					Field networkDevice = obj.getClass().getDeclaredField("networkDevice");
					networkDevice.setAccessible(true);
					String networkDeviceStr = (String)networkDevice.get(obj);
					networkDevice.setAccessible(false);				
					
					Field networkPort = obj.getClass().getDeclaredField("networkPort");
					networkPort.setAccessible(true);
					String networkPortStr = (String)networkPort.get(obj);
					networkPort.setAccessible(false);				
					
					Field networkLocationDesc = obj.getClass().getDeclaredField("networkLocationDesc");
					networkLocationDesc.setAccessible(true);
					String networkLocationDescStr = (String)networkLocationDesc.get(obj);
					networkLocationDesc.setAccessible(false);		
					
					Field networkFloor = obj.getClass().getDeclaredField("networkFloor");
					networkFloor.setAccessible(true);
					String networkFloorStr = (String)networkFloor.get(obj);
					networkFloor.setAccessible(false);					
					
					Field fieldId = obj.getClass().getDeclaredField("id");
					fieldId.setAccessible(true);
					Object idObj = fieldId.get(obj);
					Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
					fieldSubUrNO.setAccessible(true);
					String subUrNo = (String)fieldSubUrNO.get(idObj);
					fieldSubUrNO.setAccessible(false);
					fieldId.setAccessible(false);
					
					if(isStrEmpty(networkRackNameStr) || isStrEmpty(networkDeviceStr) || isStrEmpty(networkLocationDescStr) || isStrEmpty(networkFloorStr) || isStrEmpty(networkPortStr)){
						result+=(","+subUrNo);
					}
				}
				index++;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (result.equals(""))?result:result.substring(1); 		
	}
	
	public String checkPIAssignDetailForTrunk(List list) {
		String result = "";
		int index = 0;
		try{
			for(Object obj : list){
				if(obj instanceof IpUrPhysicalInterface){
					Field fieldPiType = obj.getClass().getDeclaredField("piType");
					fieldPiType.setAccessible(true);
					String piType = (String)fieldPiType.get(obj);
					fieldPiType.setAccessible(false);
					
					Field trunkFlagType = obj.getClass().getDeclaredField("trunkFlag");
					trunkFlagType.setAccessible(true);
					String trunkFlag = (String)trunkFlagType.get(obj);
					trunkFlagType.setAccessible(false);
					
					Field trunkNoType = obj.getClass().getDeclaredField("trunkNo");
					trunkNoType.setAccessible(true);
					String trunkNo = (String)trunkNoType.get(obj);
					trunkNoType.setAccessible(false);
					
					if(StringUtils.equals("T", piType) && StringUtils.equals("N", trunkFlag)){
						continue;
					}
				}
				
				Field fieldIsReject = obj.getClass().getDeclaredField("isReject");
				Field fieldIsApprove = obj.getClass().getDeclaredField("isApprove");
				fieldIsReject.setAccessible(true);
				String isReject = (String)fieldIsReject.get(obj);
				fieldIsReject.setAccessible(false);
				
				fieldIsApprove.setAccessible(true);
				String isApprove = (String)fieldIsApprove.get(obj);
				fieldIsApprove.setAccessible(false);
				
				if ((isApprove==null || isApprove.equals("")) && (isReject == null || isReject.equals(""))) {
					continue;
				}
				
				if(isReject == null || isReject.equals("") || isReject.equals("N")) {
					Field networkRackName = obj.getClass().getDeclaredField("networkRackName");
					networkRackName.setAccessible(true);
					String networkRackNameStr = (String)networkRackName.get(obj);
					networkRackName.setAccessible(false);
					
					Field networkDevice = obj.getClass().getDeclaredField("networkDevice");
					networkDevice.setAccessible(true);
					String networkDeviceStr = (String)networkDevice.get(obj);
					networkDevice.setAccessible(false);				
					
					Field networkPort = obj.getClass().getDeclaredField("networkPort");
					networkPort.setAccessible(true);
					String networkPortStr = (String)networkPort.get(obj);
					networkPort.setAccessible(false);				
					
					Field networkLocationDesc = obj.getClass().getDeclaredField("networkLocationDesc");
					networkLocationDesc.setAccessible(true);
					String networkLocationDescStr = (String)networkLocationDesc.get(obj);
					networkLocationDesc.setAccessible(false);		
					
					Field networkFloor = obj.getClass().getDeclaredField("networkFloor");
					networkFloor.setAccessible(true);
					String networkFloorStr = (String)networkFloor.get(obj);
					networkFloor.setAccessible(false);					
					
					Field fieldId = obj.getClass().getDeclaredField("id");
					fieldId.setAccessible(true);
					Object idObj = fieldId.get(obj);
					Field fieldSubUrNO = idObj.getClass().getDeclaredField("subUrNo");
					fieldSubUrNO.setAccessible(true);
					String subUrNo = (String)fieldSubUrNO.get(idObj);
					fieldSubUrNO.setAccessible(false);
					fieldId.setAccessible(false);
					
					if(isStrEmpty(networkRackNameStr) || isStrEmpty(networkDeviceStr) || isStrEmpty(networkLocationDescStr) || isStrEmpty(networkFloorStr) || isStrEmpty(networkPortStr)){
						result+=(","+subUrNo);
					}
				}
				index++;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (result.equals(""))?result:result.substring(1); 		
	}
	
	private boolean isStrEmpty(String str) {
		if(str == null || str.equals("")) {
			return true;
		} else {
			return false;
		}
	}
}
