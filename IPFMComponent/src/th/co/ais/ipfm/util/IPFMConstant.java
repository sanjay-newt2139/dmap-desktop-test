package th.co.ais.ipfm.util;

public class IPFMConstant {
	
	public static final String MCODE_TIER2TEAM ="T2_TEAM";
	public static final String MCODE_LOCAT ="LOCATION";
	public static final String MCODE_DATA_CEN ="DATA_CEN";
	public static final String MCODE_OFF_USER ="OFF_USER";
	public static final String MCODE_ZONE ="NW_ZONE";
	public static final String MCODE_NWTYPE ="NW_TYPE";
	public static final String MCODE_IPSTS ="IP_STATUS";	
	public static final String MCODE_COMPANY="COMPANY";
	public static final String MCODE_PRIORITY="PRIORITY";
	public static final String MCODE_INSTALLTYPE="INSTL_TYPE";
	//public static final String MCODE_IPTYPELIST="IPTYPELIST";
	public static final String MCODE_IPTYPELIST="IP_TYPE";
	public static final String MCODE_IPCLASS="IP_CLASS";
	
	public static final String LIST_IPVERSION = "LIST_IPVERSION";
	public static final String LIST_IPGROUP = "LIST_IPGROUP";
	public static final String LIST_IPCLASS = "LIST_IPCLASS";
	public static final String LIST_COMPANY = "LIST_COMPANY";
	public static final String LIST_TIER2TEAM = "LIST_TIER2TEAM";
	public static final String LIST_NETWORKZONE = "LIST_NETWORKZONE";
	public static final String LIST_NETWORKTYPE = "LIST_NETWORKTYPE";
	
	public static final String DEFAULT_IP_VERSION = "DEFAULT_IP_VERSION";
	
	public static final String MODE_NEW ="NEW";
	public static final String MODE_EDIT ="EDIT";
	public static final String MODE_VIEW ="VIEW";
	public static final String MODE_REJECT ="REJECT";
	public static final String MODE_APPROVE ="APPROVE";
	public static final String MODE_ASSIGN_IP ="ASSIGN";
	public static final String MODE_CALL_PM ="PM";
	public static final String MODE_TEAM ="TEAM";
	public static final String MODE_USER ="USER";
	public static final String MODE_REJECT_MRG ="REJECT_MRG";
	public static final String MODE_REJECT_TEAM ="REJECT_TEAM";
	
	public static final String ACTION_DRAFT ="SaveDraft";
	public static final String ACTION_DELETE ="Delete";
	public static final String ACTION_MRG_APPR ="ManagerApprove";
	public static final String ACTION_MRG_REJ ="ManagerReject";
	public static final String ACTION_SEND_FOR_MRG_APPR ="SendForApprove";
	public static final String ACTION_SENDFORASSIGN ="SendForAssign";
	public static final String ACTION_ASSIGN ="Assign";
	public static final String ACTION_REJECT ="Reject";
	public static final String ACTION_DEL ="DEL";
	public static final String ACTION_OWNER_APPR ="OwnerApprove";
	public static final String ACTION_ACTM ="ACTM";
	public static final String ACTION_OWNER ="OWNER";
	
	public static final String URTYPE_USER_REQ_IP ="IP23";
	public static final String URTYPE_PLANNING_REQ_IP ="IP12";
	public static final String URTYPE_NETWORK_CONFIG ="NC";
	
	public static final String URTYPENAME_USER_REQ_IP ="User Request IP";
	public static final String URTYPENAME_PLANNING_REQ_IP ="Planning Request IP";
	public static final String URTYPENAME_NETWORK_CONFIG ="Request Network Config";
	
	public static final String CATEGORY_NETWORK_DIAGRAM ="NW";
	public static final String CATEGORY_APPLICATION_FLOW ="AF";
	public static final String CATEGORY_NETWORK_CONFIG ="NC";
	
	public static final String STATUS_DRAFT ="DRAFT";
	public static final String STATUS_WAIT_MRG ="WAIT_MRG";
	public static final String STATUS_REJECT_MRG = "REJECT_MRG";
	public static final String STATUS_WAIT_OWNER = "WAIT_OWNER";
	public static final String STATUS_WAIT_ASSIGN = "WAIT_ASSIGN";
	public static final String STATUS_REJECT_OWNER = "REJECT_OWNER";
	public static final String STATUS_APPROVE_OWNER = "APPROVE_OWNER";
	public static final String STATUS_WAIT_CONFIG = "WAIT_CONFIG";
	public static final String STATUS_WAIT_CONFIG_REJECT = "WAIT_CONFIG_REJECT";
	public static final String STATUS_COMPLETE = "COMPLETE";
	public static final String STATUS_REJECT_PM = "REJECT_PM";
	public static final String STATUS_CANCEL = "CANCEL";
	public static final String STATUS_DELETE = "DEL";
	public static final String STATUS_CLOSE = "CLOSE";
	public static final String STATUS_CLOSE_UR = "Close UR";
	public static final String STATUS_MGR_APPROVED = "APPROVE_MRG";
	public static final String STATUS_APPROVED_OWNER = "APPROVE_MRG";
	public static final String STATUS_REJECT_UR = "REJECT_UR";
	public static final String STATUS_WAIT_PM = "WAIT_PM";
	public static final String STATUS_WAIT_ACTM = "WAIT_ACTM";
	public static final String STATUS_COMPLETE_ACTM = "COMPLETE_ACTM";
	public static final String STATUS_WAIT_TEAM = "WAIT_TEAM";
	public static final String STATUS_COMPLETE_TEAM_WAIT = "COMPLETE_TEAM_WAIT";
	public static final String STATUS_REJECT_TEAM_WAIT = "REJECT_TEAM_WAIT";
	public static final String STATUS_ACTM_TEAM = "WAIT_ACTM_TEAM";
	public static final String STATUS_COMPLETE_TEAM = "COMPLETE_TEAM";
	public static final String STATUS_REJECT_TEAM = "REJECT_TEAM";
	public static final String STATUS_WAIT_USER = "WAIT_USER";
	public static final String STATUS_PM_ASSIGN = "PM_ASSIGN";
	public static final String STATUS_USER_COMPLTE = "USER_CLOSE_COMPLETE";
	public static final String STATUS_USER_REJECT = "USER_CLOSE_REJECT";
	public static final String STATUS_PM_DELEGATE = "PM_DELEGATE";
	public static final String STATUS_REJECT_PM_WAIT = "REJECT_PM_WAIT";
	public static final String STATUS_COMPLETE_PM = "COMPLETE_PM";
	public static final String STATUS_SENT_MRG = "SENT_MRG";
	
	public static final String STATUS_REJECT_BY_CDN = "REJECT_CDN";
	public static final String STATUS_REJECT_BY_CDN_NAME = "Reject By CDN Team";
	
	public static final String STATUS_REJECT_BY_PLANNING = "REJECT_PLANNING";
	
	public static final String STATUS_REJECT_BY_PLANNING_NAME = "Reject By Planning Team";
	
	
	public static final String YES ="Y";
	public static final String NO ="N";
	public static final String IPSTATUS ="N";
	public static final String Found ="Found";
	
	public static final String DRAFT ="DRAFT";
	public static final String WAIT_ASSIGN ="WAIT_ASSIGN";
	
	public static final String RESULT_SUCCESS ="000";
	public static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

		// Report Status
	public static final String REPORT_COMPLETE = "Completed";
	public static final String REPORT_WAITING = "Waiting";
	public static final String REPORT_ERROR = "Error";
	
	
	public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

	public static final String TIER1 = "T1";
	public static final String TIER2 = "T2";
	public static final String TIER3 = "T3";
	public static final String TIER12 = "T12";
	public static final String TIER123 = "T123";
	public static final String TIER23 = "T23";
	
	public static final String WAITFORAPPROVE = "Waiting For Approve";
	public static final String WAITFORASSIGN = "Waiting For Team Assign";
	public static final String DRAFTUR = "Draft UR";
	
	public static final String RESULT = "RESULT";
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	
	public static final String IPINFO_LIST = "IPINFO_LIST";
}
