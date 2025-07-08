package th.co.ais.ipfm.web.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpvRetriveF5;
import th.co.ais.ipfm.service.F5Service;
import th.co.ais.ipfm.service.FirewallService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.web.manage.bean.IPF5Bean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class F5Validate {
	private IPF5Bean f5;
	
	public F5Validate(){
	}
	
	public F5Validate(IPF5Bean f5){
		this.f5 = f5;
	}

	public void setF5(IPF5Bean f5) {
		this.f5 = f5;
	}

	public String validate(){
		StringBuffer result = new StringBuffer("");
		boolean blank = false;
		
		if(isEmpty(f5.getVip())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"VIP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "VIP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(f5.getIpPort())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"),"VIP Port"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "VIP Port");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		if(isEmpty(f5.getIsSnatIP())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SNAT IP"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SNAT IP");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		if(isEmpty(f5.getPersistence())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Persistence"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Persistence");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(f5.getMethod())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Method"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Method");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		} 
		
		if(isEmpty(f5.getIpPool())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Pool"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Pool");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		if(isEmpty(f5.getIpPoolPort())){
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Pool Port"));
			String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "IP Pool Port");
			result.append("<li>"+errMsg+"</li>");
			blank = true;
		}
		
		
		if(!blank){
			if((f5.getMethod().equals("RT") || f5.getMethodTxt().equals("Ratio")) && (isEmpty(f5.getIpWeight()))){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Weight(%)"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Weight(%)");
				result.append("<li>"+errMsg+"</li>");
	
			}				
			
			if(!isEmpty(f5.getIpWeight()) && !isNumber(f5.getIpWeight())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "Weight(%)"));
				String errMsg2 = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "Weight(%)");
				result.append("<li>"+errMsg2+"</li>");
			}			
			
			if(!isNumber(f5.getIpPort())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"),"VIP Port"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "VIP Port");
				result.append("<li>"+errMsg+"</li>");				
			}
			
			if(!isNumber(f5.getIpPoolPort())) {
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "IP Pool Port"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0002"), "IP Pool Port");
				result.append("<li>"+errMsg+"</li>");				
			}
			
			if(!isIpAddress(f5.getVip().trim())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "VIP","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "VIP","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
				
			} else {
				if(!isVip(f5.getVip().trim())){
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0094"),f5.getVip().trim()));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0094"), f5.getVip().trim());
					result.append("<li>"+errMsg+"</li>");
				}				
			}
			
			if(!isIpAddress(f5.getIpPool())){
				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "IP Pool","255.255.255.255"));
				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "IP Pool","255.255.255.255");
				result.append("<li>"+errMsg+"</li>");
			}
			
			if(f5.getIsSnatIP().equals("Y")) {
				if(isEmpty(f5.getSnatIp())) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SNAT IP"));
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "SNAT IP");
					result.append("<li>"+errMsg+"</li>");
				} else  {
					if(!isIpAddress(f5.getSnatIp())){
						IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "SNAT IP","255.255.255.255"));
						String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0105"), "SNAT IP","255.255.255.255");
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
	
//	public boolean validateWeightOver(List<IpUrF5> f5List) {
//		if((f5.getMethod().equals("RT") || f5.getMethodTxt().equals("Ratio")) && (!isEmpty(f5.getIpWeight()) && (isNumber(f5.getIpWeight()))) ) {
//			if(weight > 100) {
//				IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0199")));
//				String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0199"));
//				return false;
//			}
//		}
//		return true;
//	}
	
	
	public String validateWeightOver(List<IpUrF5> f5List) {
		StringBuffer result = new StringBuffer("");
		if(f5List != null && f5List.size() > 0) {
			HashSet<String> ipAddressSet = new HashSet<String>();
			for(IpUrF5 f5: f5List) {
				if(f5 != null && f5.getVipAddress() != null  && !"".equals(f5.getVipAddress())) {
					String vipAddress = f5.getVipAddress();
					String vipPort = f5.getVipPort();
					ipAddressSet.add(vipAddress+"-"+vipPort);
				}
			}
			
			for(String vipAddressAndPort : ipAddressSet) {
//				String vipAddressAndPort = vipAddressAndPort;
				String[] vipAddressAndPorts = vipAddressAndPort.split("-");
				String vipAddress = vipAddressAndPorts[0];
				String vipAddressPort = vipAddressAndPorts[1];
				int sumWeight = 0;
				for(IpUrF5 f5: f5List) {
					if(f5 != null && f5.getVipAddress() != null  && !"".equals(f5.getVipAddress())) {
						String vip = f5.getVipAddress();
						String vipPort = f5.getVipPort();
						if(vipAddress.equals(vip) && vipAddressPort.equals(vipPort)) {
							if(f5.getPoolWeight() != null && !"".equals(f5.getPoolWeight()) && (f5.getMethod().equals("RT"))) {
								int f5PoolWeight = Integer.parseInt(f5.getPoolWeight());
								sumWeight+=f5PoolWeight;
								continue;
							}
						}
					}
				}
				if(sumWeight > 100) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0199"), vipAddress + " Port " + vipAddressPort));	
					String errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0199"), vipAddress + "Port " + vipAddressPort);
					result.append("<li>"+errMsg+"</li>");
				}
			}
		}
		return result.toString();
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
	
	
	public boolean isVip(String ip){
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IpInfo info = f5Service.getIPInfoWithStatus(ip);
		if (info == null || info.getVip() == null || !info.getVip().toUpperCase().trim().equalsIgnoreCase("Y")) {
			return false;
		}
		return true;
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
