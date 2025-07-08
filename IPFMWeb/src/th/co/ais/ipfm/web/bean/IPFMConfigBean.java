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
	
	public String getMaxRecordPath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxRecordPath
		return maxRecordPath;
	}

	public void setMaxRecordPath(String maxRecordPath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxRecordPath
		this.maxRecordPath = maxRecordPath;
	}

	public String getMaxRecordFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxRecordFile
		return maxRecordFile;
	}

	public void setMaxRecordFile(String maxRecordFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxRecordFile
		this.maxRecordFile = maxRecordFile;
	}

	public String getLogoPath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLogoPath
		return logoPath;
	}

	public void setLogoPath(String logoPath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLogoPath
		this.logoPath = logoPath;
	}

	public String getLogoBackupPath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLogoBackupPath
		return logoBackupPath;
	}

	public void setLogoBackupPath(String logoBackupPath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setLogoBackupPath
		this.logoBackupPath = logoBackupPath;
	}

	public IPFMConfigBean(){
	}

	public int getRowPerPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage
		this.rowPerPage = rowPerPage;
	}

	public int getMaxPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage
		return maxPage;
	}

	public void setMaxPage(int maxPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage
		this.maxPage = maxPage;
	}

	public int getMaxSearchResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult
		return maxSearchResult;
	}

	public void setMaxSearchResult(int maxSearchResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult
		this.maxSearchResult = maxSearchResult;
	}

	public int getFastStepPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage
		return fastStepPage;
	}

	public void setFastStepPage(int fastStepPage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage
		this.fastStepPage = fastStepPage;
	}
	
	public String getAttachPath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAttachPath
		return attachPath;
	}

	public void setAttachPath(String attachPath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAttachPath
		this.attachPath = attachPath;
	}

	public int getUserOnlineMsTime(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserOnlineMsTime
		return this.userOnlineTime * 60 * 1000;
	}

	public int getUserOnlineTime() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUserOnlineTime
		return userOnlineTime;
	}

	public void setUserOnlineTime(int userOnlineTime) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUserOnlineTime
		this.userOnlineTime = userOnlineTime;
	}
	public int getTreesMsTime(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getTreesMsTime
		return this.treesTime * 60 * 1000;
	}
	public int getTreesTime() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTreesTime
		return treesTime;
	}

	public void setTreesTime(int treesTime) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTreesTime
		this.treesTime = treesTime;
	}

	public static long getSerialversionuid() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSerialversionuid
		return serialVersionUID;
	}

	public String getWebCounterFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWebCounterFile
		return webCounterFile;
	}

	public void setWebCounterFile(String webCounterFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWebCounterFile
		this.webCounterFile = webCounterFile;
	}

	public String getAssingIpUserRequestIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssingIpUserRequestIP
		return assingIpUserRequestIP;
	}

	public void setAssingIpUserRequestIP(String assingIpUserRequestIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssingIpUserRequestIP
		this.assingIpUserRequestIP = assingIpUserRequestIP;
	}

	public String getTemplateUR23Assign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateUR23Assign
		return templateUR23Assign;
	}

	public void setTemplateUR23Assign(String templateUR23Assign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateUR23Assign
		this.templateUR23Assign = templateUR23Assign;
	}

	public String getAssingIpPlanningRequestIP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAssingIpPlanningRequestIP
		return assingIpPlanningRequestIP;
	}

	public void setAssingIpPlanningRequestIP(String assingIpPlanningRequestIP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAssingIpPlanningRequestIP
		this.assingIpPlanningRequestIP = assingIpPlanningRequestIP;
	}

	public String getTemplateUR12Assign() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateUR12Assign
		return templateUR12Assign;
	}

	public void setTemplateUR12Assign(String templateUR12Assign) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateUR12Assign
		this.templateUR12Assign = templateUR12Assign;
	}

	public String getTemplatePath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplatePath
		return templatePath;
	}

	public void setTemplatePath(String templatePath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplatePath
		this.templatePath = templatePath;
	}

	public int getMaxReqIP4T2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxReqIP4T2
		return maxReqIP4T2;
	}

	public void setMaxReqIP4T2(int maxReqIP4T2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxReqIP4T2
		this.maxReqIP4T2 = maxReqIP4T2;
	}

	public int getMaxReqIP4T3() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxReqIP4T3
		return maxReqIP4T3;
	}

	public void setMaxReqIP4T3(int maxReqIP4T3) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxReqIP4T3
		this.maxReqIP4T3 = maxReqIP4T3;
	}
	
	public String getIpfmUserManualPath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmUserManualPath
		return ipfmUserManualPath;
	}

	public void setIpfmUserManualPath(String ipfmUserManualPath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmUserManualPath
		this.ipfmUserManualPath = ipfmUserManualPath;
	}

	public String getIpfmUserManualFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmUserManualFile
		return ipfmUserManualFile;
	}

	public void setIpfmUserManualFile(String ipfmUserManualFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmUserManualFile
		this.ipfmUserManualFile = ipfmUserManualFile;
	}

	public String getIpfmUserManualFile2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmUserManualFile2
		return ipfmUserManualFile2;
	}

	public void setIpfmUserManualFile2(String ipfmUserManualFile2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmUserManualFile2
		this.ipfmUserManualFile2 = ipfmUserManualFile2;
	}

	public String getWebCounterPath() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getWebCounterPath
		return webCounterPath;
	}

	public void setWebCounterPath(String webCounterPath) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setWebCounterPath
		this.webCounterPath = webCounterPath;
	}

	public String getHomeUrl() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getHomeUrl
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setHomeUrl
		this.homeUrl = homeUrl;
	}

	public int getSuggestSize() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSuggestSize
		return suggestSize;
	}

	public void setSuggestSize(int suggestSize) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSuggestSize
		this.suggestSize = suggestSize;
	}

	public String getRequestFirewall() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestFirewall
		return requestFirewall;
	}

	public void setRequestFirewall(String requestFirewall) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestFirewall
		this.requestFirewall = requestFirewall;
	}

	public String getTemplateRequestFirewall() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestFirewall
		return templateRequestFirewall;
	}

	public void setTemplateRequestFirewall(String templateRequestFirewall) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestFirewall
		this.templateRequestFirewall = templateRequestFirewall;
	}

	public String getRequestAccessListTNP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestAccessListTNP
		return requestAccessListTNP;
	}

	public void setRequestAccessListTNP(String requestAccessListTNP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestAccessListTNP
		this.requestAccessListTNP = requestAccessListTNP;
	}

	public String getTemplateRequestAccessListTNP() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestAccessListTNP
		return templateRequestAccessListTNP;
	}

	public void setTemplateRequestAccessListTNP(String templateRequestAccessListTNP) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestAccessListTNP
		this.templateRequestAccessListTNP = templateRequestAccessListTNP;
	}

	public String getRequestAcessListCDN() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestAcessListCDN
		return requestAcessListCDN;
	}

	public void setRequestAcessListCDN(String requestAcessListCDN) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestAcessListCDN
		this.requestAcessListCDN = requestAcessListCDN;
	}

	public String getTemplateRequestAcessListCDN() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestAcessListCDN
		return templateRequestAcessListCDN;
	}

	public void setTemplateRequestAcessListCDN(String templateRequestAcessListCDN) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestAcessListCDN
		this.templateRequestAcessListCDN = templateRequestAcessListCDN;
	}

	public String getRequestInterfaceGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestInterfaceGateway
		return requestInterfaceGateway;
	}

	public void setRequestInterfaceGateway(String requestInterfaceGateway) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestInterfaceGateway
		this.requestInterfaceGateway = requestInterfaceGateway;
	}

	public String getTemplateRequestInterfaceGateway() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestInterfaceGateway
		return templateRequestInterfaceGateway;
	}

	public void setTemplateRequestInterfaceGateway( // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestInterfaceGateway
			String templateRequestInterfaceGateway) {
		this.templateRequestInterfaceGateway = templateRequestInterfaceGateway;
	}

	public String getRequestPhysicalInterface() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestPhysicalInterface
		return requestPhysicalInterface;
	}

	public void setRequestPhysicalInterface(String requestPhysicalInterface) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestPhysicalInterface
		this.requestPhysicalInterface = requestPhysicalInterface;
	}

	public String getTemplateRequestPhysicalInterface() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestPhysicalInterface
		return templateRequestPhysicalInterface;
	}

	public void setTemplateRequestPhysicalInterface( // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestPhysicalInterface
			String templateRequestPhysicalInterface) {
		this.templateRequestPhysicalInterface = templateRequestPhysicalInterface;
	}

	public String getRequestRequestRouting() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestRequestRouting
		return requestRequestRouting;
	}

	public void setRequestRequestRouting(String requestRequestRouting) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestRequestRouting
		this.requestRequestRouting = requestRequestRouting;
	}

	public String getTemplateRequestRouting() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestRouting
		return templateRequestRouting;
	}

	public void setTemplateRequestRouting(String templateRequestRouting) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestRouting
		this.templateRequestRouting = templateRequestRouting;
	}

	public String getRequestF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRequestF5
		return requestF5;
	}

	public void setRequestF5(String requestF5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRequestF5
		this.requestF5 = requestF5;
	}

	public String getTemplateRequestF5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTemplateRequestF5
		return templateRequestF5;
	}

	public void setTemplateRequestF5(String templateRequestF5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTemplateRequestF5
		this.templateRequestF5 = templateRequestF5;
	}

	public String getIpfmtraininglFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmtraininglFile
		return ipfmtraininglFile;
	}

	public void setIpfmtraininglFile(String ipfmtraininglFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmtraininglFile
		this.ipfmtraininglFile = ipfmtraininglFile;
	}

	public String getIpfmRequestNwFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmRequestNwFile
		return ipfmRequestNwFile;
	}

	public void setIpfmRequestNwFile(String ipfmRequestNwFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmRequestNwFile
		this.ipfmRequestNwFile = ipfmRequestNwFile;
	}

	public String getIpfmUrStatusFile() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmUrStatusFile
		return ipfmUrStatusFile;
	}

	public void setIpfmUrStatusFile(String ipfmUrStatusFile) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmUrStatusFile
		this.ipfmUrStatusFile = ipfmUrStatusFile;
	}

	public String getIpfmTemplate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpfmTemplate
		return ipfmTemplate;
	}

	public void setIpfmTemplate(String ipfmTemplate) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpfmTemplate
		this.ipfmTemplate = ipfmTemplate;
	}
	
}
