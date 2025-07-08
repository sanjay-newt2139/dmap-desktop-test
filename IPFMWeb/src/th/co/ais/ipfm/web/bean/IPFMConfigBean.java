package th.co.ais.ipfm.web.bean;

public class IPFMConfigBean {
	private static final long serialVersionUID = -2382081872985903096L;

	private int rowPerPage;
	private int maxPage;
	private int maxSearchResult;
	private int fastStepPage;
	private int userOnlineTime; // Minute
	private int treesTime; //Minute
	private int maxReqIP4T2; //Month
	private int maxReqIP4T3; //Month
	private int suggestSize = 20;
	private String homeUrl;
	private String attachPath;
	private String ipfmUserManualPath;
	private String ipfmUserManualFile;
	private String ipfmUserManualFile2;
	private String webCounterPath;
	private String webCounterFile;
	
	private String assingIpUserRequestIP;
	private String templateUR23Assign;
	
	private String assingIpPlanningRequestIP;
	private String templateUR12Assign;
	 
	private String requestFirewall;
	private String templateRequestFirewall;
	
	private String requestAccessListTNP;
	private String templateRequestAccessListTNP;
	
	private String requestAcessListCDN;
	private String templateRequestAcessListCDN;
	
	private String requestInterfaceGateway;
	private String templateRequestInterfaceGateway;
	
	private String requestPhysicalInterface;
	private String templateRequestPhysicalInterface;
	
	private String requestRequestRouting;
	private String templateRequestRouting;
	
	private String requestF5;
	private String templateRequestF5;
	
	private String templatePath;
	private String logoPath;
	private String logoBackupPath;
	
	private String maxRecordPath;
	private String maxRecordFile;
	
	private String ipfmtraininglFile;
	private String ipfmRequestNwFile;
	private String ipfmUrStatusFile;
	private String ipfmTemplate;
	
	public String getMaxRecordPath() {
		return maxRecordPath;
	}

	public void setMaxRecordPath(String maxRecordPath) {
		this.maxRecordPath = maxRecordPath;
	}

	public String getMaxRecordFile() {
		return maxRecordFile;
	}

	public void setMaxRecordFile(String maxRecordFile) {
		this.maxRecordFile = maxRecordFile;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getLogoBackupPath() {
		return logoBackupPath;
	}

	public void setLogoBackupPath(String logoBackupPath) {
		this.logoBackupPath = logoBackupPath;
	}

	public IPFMConfigBean(){
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMaxSearchResult() {
		return maxSearchResult;
	}

	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
	}

	public int getFastStepPage() {
		return fastStepPage;
	}

	public void setFastStepPage(int fastStepPage) {
		this.fastStepPage = fastStepPage;
	}
	
	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public int getUserOnlineMsTime(){
		return this.userOnlineTime * 60 * 1000;
	}

	public int getUserOnlineTime() {
		return userOnlineTime;
	}

	public void setUserOnlineTime(int userOnlineTime) {
		this.userOnlineTime = userOnlineTime;
	}
	public int getTreesMsTime(){
		return this.treesTime * 60 * 1000;
	}
	public int getTreesTime() {
		return treesTime;
	}

	public void setTreesTime(int treesTime) {
		this.treesTime = treesTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getWebCounterFile() {
		return webCounterFile;
	}

	public void setWebCounterFile(String webCounterFile) {
		this.webCounterFile = webCounterFile;
	}

	public String getAssingIpUserRequestIP() {
		return assingIpUserRequestIP;
	}

	public void setAssingIpUserRequestIP(String assingIpUserRequestIP) {
		this.assingIpUserRequestIP = assingIpUserRequestIP;
	}

	public String getTemplateUR23Assign() {
		return templateUR23Assign;
	}

	public void setTemplateUR23Assign(String templateUR23Assign) {
		this.templateUR23Assign = templateUR23Assign;
	}

	public String getAssingIpPlanningRequestIP() {
		return assingIpPlanningRequestIP;
	}

	public void setAssingIpPlanningRequestIP(String assingIpPlanningRequestIP) {
		this.assingIpPlanningRequestIP = assingIpPlanningRequestIP;
	}

	public String getTemplateUR12Assign() {
		return templateUR12Assign;
	}

	public void setTemplateUR12Assign(String templateUR12Assign) {
		this.templateUR12Assign = templateUR12Assign;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public int getMaxReqIP4T2() {
		return maxReqIP4T2;
	}

	public void setMaxReqIP4T2(int maxReqIP4T2) {
		this.maxReqIP4T2 = maxReqIP4T2;
	}

	public int getMaxReqIP4T3() {
		return maxReqIP4T3;
	}

	public void setMaxReqIP4T3(int maxReqIP4T3) {
		this.maxReqIP4T3 = maxReqIP4T3;
	}
	
	public String getIpfmUserManualPath() {
		return ipfmUserManualPath;
	}

	public void setIpfmUserManualPath(String ipfmUserManualPath) {
		this.ipfmUserManualPath = ipfmUserManualPath;
	}

	public String getIpfmUserManualFile() {
		return ipfmUserManualFile;
	}

	public void setIpfmUserManualFile(String ipfmUserManualFile) {
		this.ipfmUserManualFile = ipfmUserManualFile;
	}

	public String getIpfmUserManualFile2() {
		return ipfmUserManualFile2;
	}

	public void setIpfmUserManualFile2(String ipfmUserManualFile2) {
		this.ipfmUserManualFile2 = ipfmUserManualFile2;
	}

	public String getWebCounterPath() {
		return webCounterPath;
	}

	public void setWebCounterPath(String webCounterPath) {
		this.webCounterPath = webCounterPath;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public int getSuggestSize() {
		return suggestSize;
	}

	public void setSuggestSize(int suggestSize) {
		this.suggestSize = suggestSize;
	}

	public String getRequestFirewall() {
		return requestFirewall;
	}

	public void setRequestFirewall(String requestFirewall) {
		this.requestFirewall = requestFirewall;
	}

	public String getTemplateRequestFirewall() {
		return templateRequestFirewall;
	}

	public void setTemplateRequestFirewall(String templateRequestFirewall) {
		this.templateRequestFirewall = templateRequestFirewall;
	}

	public String getRequestAccessListTNP() {
		return requestAccessListTNP;
	}

	public void setRequestAccessListTNP(String requestAccessListTNP) {
		this.requestAccessListTNP = requestAccessListTNP;
	}

	public String getTemplateRequestAccessListTNP() {
		return templateRequestAccessListTNP;
	}

	public void setTemplateRequestAccessListTNP(String templateRequestAccessListTNP) {
		this.templateRequestAccessListTNP = templateRequestAccessListTNP;
	}

	public String getRequestAcessListCDN() {
		return requestAcessListCDN;
	}

	public void setRequestAcessListCDN(String requestAcessListCDN) {
		this.requestAcessListCDN = requestAcessListCDN;
	}

	public String getTemplateRequestAcessListCDN() {
		return templateRequestAcessListCDN;
	}

	public void setTemplateRequestAcessListCDN(String templateRequestAcessListCDN) {
		this.templateRequestAcessListCDN = templateRequestAcessListCDN;
	}

	public String getRequestInterfaceGateway() {
		return requestInterfaceGateway;
	}

	public void setRequestInterfaceGateway(String requestInterfaceGateway) {
		this.requestInterfaceGateway = requestInterfaceGateway;
	}

	public String getTemplateRequestInterfaceGateway() {
		return templateRequestInterfaceGateway;
	}

	public void setTemplateRequestInterfaceGateway(
			String templateRequestInterfaceGateway) {
		this.templateRequestInterfaceGateway = templateRequestInterfaceGateway;
	}

	public String getRequestPhysicalInterface() {
		return requestPhysicalInterface;
	}

	public void setRequestPhysicalInterface(String requestPhysicalInterface) {
		this.requestPhysicalInterface = requestPhysicalInterface;
	}

	public String getTemplateRequestPhysicalInterface() {
		return templateRequestPhysicalInterface;
	}

	public void setTemplateRequestPhysicalInterface(
			String templateRequestPhysicalInterface) {
		this.templateRequestPhysicalInterface = templateRequestPhysicalInterface;
	}

	public String getRequestRequestRouting() {
		return requestRequestRouting;
	}

	public void setRequestRequestRouting(String requestRequestRouting) {
		this.requestRequestRouting = requestRequestRouting;
	}

	public String getTemplateRequestRouting() {
		return templateRequestRouting;
	}

	public void setTemplateRequestRouting(String templateRequestRouting) {
		this.templateRequestRouting = templateRequestRouting;
	}

	public String getRequestF5() {
		return requestF5;
	}

	public void setRequestF5(String requestF5) {
		this.requestF5 = requestF5;
	}

	public String getTemplateRequestF5() {
		return templateRequestF5;
	}

	public void setTemplateRequestF5(String templateRequestF5) {
		this.templateRequestF5 = templateRequestF5;
	}

	public String getIpfmtraininglFile() {
		return ipfmtraininglFile;
	}

	public void setIpfmtraininglFile(String ipfmtraininglFile) {
		this.ipfmtraininglFile = ipfmtraininglFile;
	}

	public String getIpfmRequestNwFile() {
		return ipfmRequestNwFile;
	}

	public void setIpfmRequestNwFile(String ipfmRequestNwFile) {
		this.ipfmRequestNwFile = ipfmRequestNwFile;
	}

	public String getIpfmUrStatusFile() {
		return ipfmUrStatusFile;
	}

	public void setIpfmUrStatusFile(String ipfmUrStatusFile) {
		this.ipfmUrStatusFile = ipfmUrStatusFile;
	}

	public String getIpfmTemplate() {
		return ipfmTemplate;
	}

	public void setIpfmTemplate(String ipfmTemplate) {
		this.ipfmTemplate = ipfmTemplate;
	}
	
}
