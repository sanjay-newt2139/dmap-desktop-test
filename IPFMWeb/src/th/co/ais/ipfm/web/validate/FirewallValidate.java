package th.co.ais.ipfm.web.validate;

import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.IPFirewallBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class FirewallValidate {
	private IPFirewallBean firewall;
	
	public FirewallValidate(){
	}
		
	public FirewallValidate(IPFirewallBean bean) {
		this.firewall = bean;
	}

	public void setFirewallBean(IPFirewallBean bean) {
		this.firewall = bean;
	}
	
	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		
		if(isEmpty(firewall.getSourceIPStart())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"Firewall Source IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Firewall Source IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(firewall.getSourceIPEnd())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"Firewall Source IP End"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Firewall Source IP End");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}		
		
		if(isEmpty(firewall.getDestIPStart())){	
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"Firewall Destination IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Firewall Destination IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(firewall.getDestIPEnd())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"Firewall Destination IP End"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Firewall Destination IP End");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}		
		
		if(!blank){
			if(!isIpAddress(firewall.getSourceIPStart())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Source IP Start","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Source IP Start","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(firewall.getSourceIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Source IP End","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Source IP End","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(firewall.getDestIPStart())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Destination IP Start","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Destination IP Start","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(firewall.getDestIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Destination IP End","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0038"), "Firewall Destination IP End","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if((isIpAddress(firewall.getDestIPStart()) && isIpAddress(firewall.getDestIPEnd()) && !isSamePlaningTeam())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088")));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088"));
				result.append("<li>"+errMsg+"</li>");				
			}
			
			if((isIpAddress(firewall.getDestIPStart()) && isIpAddress(firewall.getDestIPEnd()) && !isSameSystemOwn())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089")));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089"));
				result.append("<li>"+errMsg+"</li>");
			}
			/*
			if(!isEmpty(firewall.getSourceNatIP()) && !isIpAddress(firewall.getSourceNatIP())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Source Nat IP","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Source Nat IP","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}			
			
			if(!isEmpty(firewall.getDestNatIP()) && !isIpAddress(firewall.getDestNatIP())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Destination Nat IP End","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Firewall Destination Nat IP End","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}			
			*/
			if(!isSameIPGroup(firewall.getSourceIPStart(),firewall.getSourceIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Firewall Source IP"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Firewall Source IP");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isSameIPGroup(firewall.getDestIPStart(),firewall.getDestIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Firewall Destination IP"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Firewall Destination IP");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpBrfore(firewall.getSourceIPStart(),firewall.getSourceIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Firewall Source IP End"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Firewall Source IP End");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpBrfore(firewall.getDestIPStart(),firewall.getDestIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Firewall Destination IP End"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Firewall Destination IP End");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(firewall.getSourceIPStart().equals(firewall.getSourceIPEnd())){
				if(!hasIpInfo(firewall.getSourceIPStart())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Source IP"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Source IP");
					result.append("<li>"+errMsg+"</li>");
				}
			} else {
				if(!hasIpInfo(firewall.getSourceIPEnd())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Source IP End"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Source IP End");
					result.append("<li>"+errMsg+"</li>");
				}				
			}
			
			if(firewall.getDestIPStart().equals(firewall.getDestIPEnd())){
				if(!hasIpInfo(firewall.getDestIPStart())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Destination IP"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Destination IP");
					result.append("<li>"+errMsg+"</li>");
				}
			} else {
				if(!hasIpInfo(firewall.getDestIPEnd())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Destination IP End"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Firewall Destination IP End");
					result.append("<li>"+errMsg+"</li>");
				}				
			}
			
			if((!isEmpty(firewall.getServiceName()))){
				String serviceName = (firewall.getServiceName()!=null)?firewall.getServiceName():"";
				if(!isServiceFound(serviceName)){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0049")));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0049"));
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			boolean emptyPort = isEmpty(firewall.getTcpPort()) && isEmpty(firewall.getUdpPort()) && isEmpty(firewall.getOtherPort());
			boolean serviceSelect = isEmpty(firewall.getServiceName());
			if(emptyPort && serviceSelect){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0050")));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0050"));
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isEmpty(firewall.getTcpPort())){
				if(firewall.getTcpPort().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "TCP Port"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "TCP Port");
					result.append("<li>"+errMsg+"</li>");
				}
				if(!isFormatPort(firewall.getTcpPort())){
					
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"), "TCP Port"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0212"), "TCP Port");
					result.append("<li>"+errMsg+"</li>");
		
				}
			}
			
			if(!isEmpty(firewall.getUdpPort())){
				if(firewall.getUdpPort().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "UDP Port"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "UDP Port");
					result.append("<li>"+errMsg+"</li>");
				}
				if(!isFormatPort(firewall.getUdpPort())){
					
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0212"), "TCP Port"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0213"), "UDP Port");
					result.append("<li>"+errMsg+"</li>");
		
				}
			}
			
			if(!isEmpty(firewall.getOtherPort())){
				if(firewall.getOtherPort().length()>100){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Other Port"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Other Port");
					result.append("<li>"+errMsg+"</li>");
				}
			}
		
		
			
		}
		
		
		
		
		return result.toString();
	}
	
	private boolean isFormatPort(String iPort){
		boolean check = false;
		iPort= iPort.replaceAll("-",",");
		String[] iPortArray = iPort.split(",");
        String Port_PATTERN = 
		"^([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$";
        final Pattern x =
              Pattern.compile(Port_PATTERN);
        for(String pop : iPortArray){
        	check = x.matcher(pop).matches();
        	if(check == false)
        	{
        		break;
        	}
        }
        
        
        return check;
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
			FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
			IpInfo info = firewallService.getIPInfoWithUsedStatus(ip);
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

	private boolean isSameSystemOwn() {
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		String stIp  = firewall.getDestIPStart().trim();
		String endIp = firewall.getDestIPEnd().trim();
		StringBuffer result = new StringBuffer("");
			try {
			String ipStart = IPFMDataUtility.convertIpStringToBinary(stIp);
			String ipEnd = IPFMDataUtility.convertIpStringToBinary(endIp);
			int count = firewallService.fineIpinfo(ipStart, ipEnd);
			if(count>0){
				int countsystemOwnerTeamID  = firewallService.findSystemOwnerTeamID(ipStart, ipEnd);
				if(countsystemOwnerTeamID>1){
					return false;
///////					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089")));
//					errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0089"));
//					result.append("<li>"+errMsg+"</li>");
//					bean.setErrorFlag(true);
//					firewall.setDestIPEnd("");
				}
				
//				bean.setErrorMsg(result.toString());
			}	
			}catch(Exception e) {
				e.printStackTrace();
			}

		return true;
	}
	
	
	private boolean isSamePlaningTeam() {
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		String stIp  = firewall.getDestIPStart().trim();
		String endIp = firewall.getDestIPEnd().trim();
		StringBuffer result = new StringBuffer("");
			
			try {
			String ipStart = IPFMDataUtility.convertIpStringToBinary(stIp);
			String ipEnd = IPFMDataUtility.convertIpStringToBinary(endIp);
			int count = firewallService.fineIpinfo(ipStart, ipEnd);
			if(count>0){
				int countT2TeamId  = firewallService.findTier2TeamID(ipStart, ipEnd);
				if(countT2TeamId>1){
					return false;
///					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088")));
//					errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0088"));
//					result.append("<li>"+errMsg+"</li>");
//					bean.setErrorFlag(true);
//					firewall.setDestIPEnd("");
				}
			}	
			}catch(Exception e) {
				e.printStackTrace();
			}

		return true;
	}
	

}
