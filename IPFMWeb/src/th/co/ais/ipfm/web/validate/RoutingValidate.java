package th.co.ais.ipfm.web.validate;

import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.service.RoutingService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.IPRoutingBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class RoutingValidate {
	private IPRoutingBean routing;
	
	public RoutingValidate(){
	}
	
	public RoutingValidate(IPRoutingBean routing){
		this.routing = routing;
	}

	public void setRouting(IPRoutingBean routing) {
		this.routing = routing;
	}

	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		
		if(isEmpty(routing.getIpAddress())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Address");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(routing.getMask())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Mask");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		
		if(!blank){
			if(!isIpAddress(routing.getIpAddress())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Physical Interface IP Node","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Physical Interface IP Node","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isEmpty(routing.getNextHop())) {
				if(!isIpAddress(routing.getNextHop())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Next Hop","255.255.255.255"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Next Hop","255.255.255.255");
					result.append("<li>"+errMsg+"</li>");
				}			
			}
			
			if(!hasIpInfo(routing.getIpAddress())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Physical Interface IP Node"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Physical Interface IP Node");
				result.append("<li>"+errMsg+"</li>");
			}

			if(!isNumber(routing.getMask())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "Mark"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "Mark");
				result.append("<li>"+errMsg+"</li>");
			} else {
				int mask = Integer.parseInt(routing.getMask());
				if((mask<8) || (mask>32)){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059")));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0059"));
					result.append("<li>"+errMsg+"</li>");
				}
			}

			
			if(!isEmpty(routing.getIntf())){
				if(routing.getIntf().length()>1000){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Interface"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Interface");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(routing.getNextHop())){
				if(routing.getNextHop().length()>1000){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Hext Hop"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0034"), "Hext Hop");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(!isEmpty(routing.getDescription())){
				if(routing.getDescription().length()>1000){
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
			RoutingService routingService = (RoutingService)JSFServiceFinderUtil.getInstance().getBean("routingService");
			IpInfo info = null;
			try {
				info = routingService.getIPInfoUsedStatus(ip);
				done = (info!=null);
			} catch (IPFMBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return done;
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
