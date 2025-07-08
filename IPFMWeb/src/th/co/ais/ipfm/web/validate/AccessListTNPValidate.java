package th.co.ais.ipfm.web.validate;

import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.service.AccessListTNPService;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.IPAccessListTNPBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class AccessListTNPValidate {
	private IPAccessListTNPBean tnp;
	
	public AccessListTNPValidate(){
	}
	
	public AccessListTNPValidate(IPAccessListTNPBean tnp){
		this.tnp = tnp;
	}

	public void setTNP(IPAccessListTNPBean tnp) {
		this.tnp = tnp;
	}

	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		
		if(isEmpty(tnp.getSourceIP())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Source IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Source IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(tnp.getDestIP())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Destination IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Destination IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(tnp.getImpact())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Impact"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Impact");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(!blank){
			if(!isIpAddress(tnp.getSourceIP())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List TNP Source IP","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List TNP Source IP","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(tnp.getDestIP())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List TNP Destination IP","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List TNP Destination IP","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!hasIpInfo(tnp.getSourceIP())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List TNP Source IP"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List TNP Source IP");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!hasIpInfo(tnp.getDestIP())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List TNP Destination IP"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List TNP Destination IP");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isEmpty(tnp.getSourceInterfaceNode())){
				if(tnp.getSourceInterfaceNode().length()>1000){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For TNP Source IP"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Source Interface at Node");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(tnp.getSourceInterfaceNetwork())){
				if(tnp.getSourceInterfaceNetwork().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Source Interface at Network"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Source Interface at Network");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(tnp.getDestInterfaceNode())){
				if(tnp.getDestInterfaceNode().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Destination Interface at Node"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Destination Interface at Node");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(tnp.getDestInterfaceNetwork())){
				if(tnp.getDestInterfaceNetwork().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Destination Interface at Network"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Destination Interface at Network");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(tnp.getDescription())){
				if(tnp.getDescription().length()>500){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Description"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Description");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(tnp.getImpact())){
				if(tnp.getImpact().length()>1000){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Impact"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Impact");
					result.append("<li>"+errMsg+"</li>");
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
			AccessListTNPService tnpService = (AccessListTNPService)JSFServiceFinderUtil.getInstance().getBean("accessListTNPService");
			IpInfo info = tnpService.getIPInfoWithUsedStatus(ip);
			done = (info!=null);
		}
		return done;
	}
	
	private boolean isServiceFound(String serviceName){
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IpMasterTable master = firewallService.getServiceByRefID(serviceName);
		return (master!=null);
	}
	
	private boolean isEmpty(String value){
		return (value==null) || (value.equals(""));
	}
	
	

}
