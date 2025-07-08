package th.co.ais.ipfm.web.validate;

import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.service.IntfGatewayService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.IPIntfGatewayBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class IntfGatewayValidate {
	private IPIntfGatewayBean intfGateway;
	
	public IntfGatewayValidate(){
	}
	
	public IntfGatewayValidate(IPIntfGatewayBean intfGateway){
		this.intfGateway = intfGateway;
	}

	public void setIntfGateway(IPIntfGatewayBean intfGateway) {
		this.intfGateway = intfGateway;
	}

	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		
		if(isEmpty(intfGateway.getIpAddress())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(intfGateway.getMask())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(!isNumber(intfGateway.getMask())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "Mask"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "Mask");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		//if(isEmpty(intfGateway.getNetworkTypeDesc())){
			if (intfGateway.getNetworkType().getLabel()==null || intfGateway.getNetworkType().getLabel().trim().length()==0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Type"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Network Type");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}else if((intfGateway.getNetworkType().getValue()==null) && intfGateway.getNetworkType().getLabel().trim().length()>0){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Type"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0095"), "Network Type");
				result.append("<li>"+errMsg+"</li>");
				blank = true;
			}
		//}
		
		if(!blank){
			if(!isIpAddress(intfGateway.getIpAddress())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Interface Gateway IP Node","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Interface Gateway IP Node","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!hasIpInfo(intfGateway.getIpAddress())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Interface Gateway  IP Node"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Interface Gateway  IP Node");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(intfGateway.getNetworkType()!=null){
				if(!hasNetworkType(intfGateway.getNetworkType().getLabel())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069")));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"));
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
//			if(intfGateway.getNetworkTypeDesc()!=null){
//				if(!hasNetworkType(intfGateway.getNetworkTypeDesc())){
//			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Network Type"));
//					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0069"),"Network Type");
//					result.append("<li>"+errMsg+"</li>");
//				}
//			}
			
			int mask = Integer.parseInt(intfGateway.getMask());
			if((mask<8) || (mask>32)){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059"));
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isEmpty(intfGateway.getVlanID())){
				if(!isNumber(intfGateway.getVlanID())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "VLAN ID"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "VLAN ID");
					result.append("<li>"+errMsg+"</li>");
				} else {
					int vlanId = Integer.parseInt(intfGateway.getVlanID());
					if((vlanId < 1) || (vlanId>4096)) {
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0198")));
						String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0198"));
						result.append("<li>"+errMsg+"</li>");
					}
				}
			}
			
			if(!isEmpty(intfGateway.getDescription())){
				if(intfGateway.getDescription().length()>1000){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Description"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Description");
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
			IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
			IpInfo info = intfGatewayService.getIPInfoWithUsedStatus(ip);
			done = (info!=null);
		}
		return done;
	}
	
	private boolean hasNetworkType(String type){
		IntfGatewayService intfGatewayService = (IntfGatewayService)JSFServiceFinderUtil.getInstance().getBean("intfGatewayService");
		return intfGatewayService.hasNetworkType(type);
	}
	
	
	
	private boolean isServiceFound(String serviceName){
		FirewallService firewallService = (FirewallService)JSFServiceFinderUtil.getInstance().getBean("firewallService");
		IpMasterTable master = firewallService.getServiceByRefID(serviceName);
		return (master!=null);
	}
	
	private boolean isEmpty(String value){
		return (value==null) || (value.equals(""));
	}
	
	public boolean isNumber(String str) {
		if (str == null || str.length() == 0)
			return false;
	    for (int i = 0; i < str.length(); i++) {
	    	if (!Character.isDigit(str.charAt(i)))
	    		return false;
	    }
	    return true;
	}
	
	

}
