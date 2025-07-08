package th.co.ais.ipfm.domain1;

import java.util.ArrayList;
import java.util.List;

public class SearchIP  {
     private String ipAddress;
     private String ipVersion;
     private String ipSubmask;
     private String ipv4digit1;
     private String ipv4digit2;
     private String ipv4digit3;
     private String ipv4digit4;
     private String ipv6digit1;
     private String ipv6digit2;
     private String ipv6digit3;
     private String ipv6digit4;
     private String ipv6digit5;
     private String ipv6digit6;
     private String vsubmask = "16";
     private IpMaskDisplay ipMaskDisplay;
     private List<IpUrIpResult> ipUrIpResultList = new ArrayList<IpUrIpResult>();
     private List<IpLevel2> ipLevel2List = new ArrayList<IpLevel2>();
     private List<IpInfo> ipInfoList = new ArrayList<IpInfo>();
     
    public SearchIP() {
    }
    
    public SearchIP(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
	public String getIpAddress() {
        return this.ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(String ipVersion) {
		this.ipVersion = ipVersion;
	}

	public String getIpSubmask() {
		return ipSubmask;
	}

	public void setIpSubmask(String ipSubmask) {
		this.ipSubmask = ipSubmask;
	}

	public String getIpv4digit1() {
		return ipv4digit1;
	}

	public void setIpv4digit1(String ipv4digit1) {
		this.ipv4digit1 = ipv4digit1;
	}

	public String getIpv4digit2() {
		return ipv4digit2;
	}

	public void setIpv4digit2(String ipv4digit2) {
		this.ipv4digit2 = ipv4digit2;
	}

	public String getIpv4digit3() {
		return ipv4digit3;
	}

	public void setIpv4digit3(String ipv4digit3) {
		this.ipv4digit3 = ipv4digit3;
	}

	public String getIpv4digit4() {
		return ipv4digit4;
	}

	public void setIpv4digit4(String ipv4digit4) {
		this.ipv4digit4 = ipv4digit4;
	}

	public String getIpv6digit1() {
		return ipv6digit1;
	}

	public void setIpv6digit1(String ipv6digit1) {
		this.ipv6digit1 = ipv6digit1;
	}

	public String getIpv6digit2() {
		return ipv6digit2;
	}

	public void setIpv6digit2(String ipv6digit2) {
		this.ipv6digit2 = ipv6digit2;
	}

	public String getIpv6digit3() {
		return ipv6digit3;
	}

	public void setIpv6digit3(String ipv6digit3) {
		this.ipv6digit3 = ipv6digit3;
	}

	public String getIpv6digit4() {
		return ipv6digit4;
	}

	public void setIpv6digit4(String ipv6digit4) {
		this.ipv6digit4 = ipv6digit4;
	}

	public String getIpv6digit5() {
		return ipv6digit5;
	}

	public void setIpv6digit5(String ipv6digit5) {
		this.ipv6digit5 = ipv6digit5;
	}

	public String getIpv6digit6() {
		return ipv6digit6;
	}

	public void setIpv6digit6(String ipv6digit6) {
		this.ipv6digit6 = ipv6digit6;
	}

	public List<IpUrIpResult> getIpUrIpResultList() {
		return ipUrIpResultList;
	}

	public void setIpUrIpResultList(List<IpUrIpResult> ipUrIpResultList) {
		this.ipUrIpResultList = ipUrIpResultList;
	}

	public List<IpLevel2> getIpLevel2List() {
		return ipLevel2List;
	}

	public void setIpLevel2List(List<IpLevel2> ipLevel2List) {
		this.ipLevel2List = ipLevel2List;
	}

	public List<IpInfo> getIpInfoList() {
		return ipInfoList;
	}

	public void setIpInfoList(List<IpInfo> ipInfoList) {
		this.ipInfoList = ipInfoList;
	}

	public String getVsubmask() {
		return vsubmask;
	}

	public void setVsubmask(String vsubmask) {
		this.vsubmask = vsubmask;
	}
	
	public IpMaskDisplay getIpMaskDisplay() {
		return ipMaskDisplay;
	}

	public void setIpMaskDisplay(IpMaskDisplay ipMaskDisplay) {
		this.ipMaskDisplay = ipMaskDisplay;
	}

	public boolean isLinkIP(){
		//if (vsubmask==null|| vsubmask.trim().length()==0 || vsubmask.equalsIgnoreCase("32")) return false;
		//return true;
		return false;
	}

}


