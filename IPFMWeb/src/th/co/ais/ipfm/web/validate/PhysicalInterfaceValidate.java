package th.co.ais.ipfm.web.validate;

import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;

import th.co.ais.ipfm.service.PhyInterfaceService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.IPPhyInterfaceBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class PhysicalInterfaceValidate {
	private IPPhyInterfaceBean phyInterface;
	
	public PhysicalInterfaceValidate(){
	}
	
	public PhysicalInterfaceValidate(IPPhyInterfaceBean phyInterface){
		this.phyInterface = phyInterface;
	}

	public void setPhyInterface(IPPhyInterfaceBean phyInterface){
		this.phyInterface = phyInterface;
	}

	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		if(isEmpty(phyInterface.getIpNode())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface IP Node"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface IP Node");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
//		if(isEmpty(phyInterface.getIntfNodeTypeDesc())){
//			if((phyInterface.getIntfNodeType()==null)){
//		IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface IP Node Type"));
//				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface IP Node Type");
//				result.append("<li>"+errMsg+"</li>");
//				blank = true;
//			}
			if (phyInterface.getIntfNodeType().getLabel()==null || phyInterface.getIntfNodeType().getLabel().trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Node Type"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Node Type");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}else if((phyInterface.getIntfNodeType().getValue()==null) && phyInterface.getIntfNodeType().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Physical Interface Node Type"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Physical Interface Node Type");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}
//		}
		
//		if(isEmpty(phyInterface.getPortStatusDesc())){
			if((phyInterface.getPortStatus()==null) || phyInterface.getPortStatus().getLabel().trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Port Status"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Port Status");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}else if((phyInterface.getPortStatus().getValue()==null) && phyInterface.getPortStatus().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Physical Interface Port Status"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Physical Interface Port Status");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}
//		}
		
//		if(isEmpty(phyInterface.getSpeedPortDesc())){
//			if((phyInterface.getSpeedPort()==null)){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Speed Port"));
//				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Speed Port");
//				result.append("<li>"+errMsg+"</li>");
//				blank = true;
//			}
			if (phyInterface.getSpeedPort().getLabel()==null || phyInterface.getSpeedPort().getLabel().trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Speed Port"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Physical Interface Speed Port");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}else if((phyInterface.getSpeedPort().getValue()==null) && phyInterface.getSpeedPort().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Physical Interface Speed Port"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Physical Interface Speed Port");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}
//		}
		
		if(!blank){
			if(!isIpAddress(phyInterface.getIpNode())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Physical Interface IP Node","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Physical Interface IP Node","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!hasIpInfo(phyInterface.getIpNode())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Physical Interface IP Node"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Physical Interface IP Node");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isEmpty(phyInterface.getFloor())){
				if(phyInterface.getFloor().length()>10){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Floor"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Floor");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(phyInterface.getInterfaceDesc())){
				if(phyInterface.getInterfaceDesc().length()>1000){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Interface Description"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Interface Description");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(phyInterface.getEnclosure())){
				if(phyInterface.getEnclosure().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Enclosure"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Enclosure");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(phyInterface.getIntfNodeType().getLabel()!=null){
				if(!hasPropMaster(phyInterface.getIntfNodeType().getLabel(),"ND_TYPE")){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Interface Node Type"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Interface Node Type");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(phyInterface.getPortStatus().getLabel()!=null){
				if(!hasPropMaster(phyInterface.getPortStatus().getLabel(),"PORT_STS")){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Port Status"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Port Status");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(phyInterface.getSpeedPort().getLabel()!=null){
				if(!hasPropMaster(phyInterface.getSpeedPort().getLabel(),"SPEED_PORT")){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Speed Port"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Speed Port");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(phyInterface.getVlanID())){
				if(!isNumber(phyInterface.getVlanID())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "VLAN ID"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "VLAN ID");
					result.append("<li>"+errMsg+"</li>");
				} else {
					int vlanId = Integer.parseInt(phyInterface.getVlanID());
					if((vlanId < 1) || (vlanId>4096)) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0198")));
						String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0198"));
						result.append("<li>"+errMsg+"</li>");
					}
				}
			}
			
		}
		
		
		return result.toString();
	}
	
	private boolean isIpAddress(String iPaddress){
        String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        final Pattern IP_PATTERN =
              Pattern.compile(IPADDRESS_PATTERN);
        return IP_PATTERN.matcher(iPaddress).matches();
	}
	
	private boolean isIpBrfore(String start,String end){
		boolean done = false;
		if(isIpAddress(start) && isIpAddress(end)){
			int pos1 = start.lastIndexOf(".")+1;
			int pos2 = end.lastIndexOf(".")+1;
			int st = Integer.parseInt(start.substring(pos1));
			int en = Integer.parseInt(end.substring(pos2));
			done=(st<=en);
		}
		
		return done;
	}
	
	private boolean isSameIPGroup(String start,String end){
		boolean done = false;
		if(isIpAddress(start) && isIpAddress(end)){
			int pos1 = start.lastIndexOf(".");
			int pos2 = end.lastIndexOf(".");
			String st = start.substring(0,pos1);
			String ed = end.substring(0,pos2);
			done = st.equals(ed);
		}
		return done;
	}
	
	private boolean hasIpInfo(String ip){
		boolean done = false;
		if(isIpAddress(ip)){
			PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
			IpInfo info = phyIntfService.getIPInfoWithUsedStatus(ip);
			done = (info!=null);
		}
		return done;
	}
	
	
	private boolean isEmpty(String value){
		return (value==null) || (value.equals(""));
	}
	
	private boolean hasPropMaster(String type,String ref){
		PhyInterfaceService phyIntfService = (PhyInterfaceService)JSFServiceFinderUtil.getInstance().getBean("phyInterfaceService");
		return phyIntfService.hasProperty(type, ref);
	}
	
	
	private boolean isNumber(String str) {
		if (str == null || str.length() == 0)
			return false;
	    for (int i = 0; i < str.length(); i++) {
	    	if (!Character.isDigit(str.charAt(i)))
	    		return false;
	    }
	    return true;
	}
	

}
