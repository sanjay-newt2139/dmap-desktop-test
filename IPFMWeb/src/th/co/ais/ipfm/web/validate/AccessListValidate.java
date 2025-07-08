package th.co.ais.ipfm.web.validate;

import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.service.AccessListService;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.manage.bean.IPAccessListBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class AccessListValidate {
	private IPAccessListBean cdn;
	
	public AccessListValidate(){
	}
	
	public AccessListValidate(IPAccessListBean cdn){
		this.cdn = cdn;
	}

	public void setCdn(IPAccessListBean cdn) {
		this.cdn = cdn;
	}

	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		
		if(isEmpty(cdn.getSourceIPStart())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Source IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Source IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}

		if(isEmpty(cdn.getSourceIPEnd())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Source IP End"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Source IP End");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}		
		
		if(isEmpty(cdn.getDestIPStart())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Destination IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Destination IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(cdn.getDestIPEnd())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Destination IP End"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Access List For CDN Destination IP End");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}		
		
		if(!blank){
			if(!isIpAddress(cdn.getSourceIPStart())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Source IP Start","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Source IP Start","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(cdn.getSourceIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Source IP End","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Source IP End","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(cdn.getDestIPStart())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Destination IP Start","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Destination IP Start","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpAddress(cdn.getDestIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Destination IP End","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "Access List Destination IP End","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isSameIPGroup(cdn.getSourceIPStart(),cdn.getSourceIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Access List Source IP"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Access List Source IP");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isSameIPGroup(cdn.getDestIPStart(),cdn.getDestIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Access List Destination IP"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0047"), "Access List Destination IP");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpBrfore(cdn.getSourceIPStart(),cdn.getSourceIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Access List Source IP End"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Access List Source IP End");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(!isIpBrfore(cdn.getDestIPStart(),cdn.getDestIPEnd())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Access List Destination IP End"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0051"), "Access List Destination IP End");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(cdn.getSourceIPStart().equals(cdn.getSourceIPEnd())){
				if(!hasIpInfo(cdn.getSourceIPStart())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List Source IP"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List Source IP");
					result.append("<li>"+errMsg+"</li>");
				}
			}
			
			if(cdn.getDestIPStart().equals(cdn.getDestIPEnd())){
				if(!hasIpInfo(cdn.getDestIPStart())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List Destination IP"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"), "Access List Destination IP");
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
			AccessListService cdnService = (AccessListService)JSFServiceFinderUtil.getInstance().getBean("accessListService");
			IpInfo info = cdnService.getIPInfoWithUsedStatus(ip);
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
