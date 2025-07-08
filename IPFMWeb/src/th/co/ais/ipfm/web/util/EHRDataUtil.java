package th.co.ais.ipfm.web.util;

import org.apache.commons.jxpath.JXPathContext;

public class EHRDataUtil {
	private static EHRDataUtil ehrDataUtil;
	private EHRDataContainer container;
	private JXPathContext jxpContext;
	
	private EHRDataUtil() {
	//	jxpContext = JXPath
	}
	
	public static EHRDataUtil getInstance(EHRDataContainer ehrContainer) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getInstance
		if(ehrDataUtil == null) {
			ehrDataUtil = new EHRDataUtil();
		}
		if(ehrDataUtil.container != null) {
			ehrDataUtil.container = null;
		}
		ehrDataUtil.container = ehrContainer;
		ehrDataUtil.jxpContext = JXPathContext.newContext(ehrDataUtil.container);
		return ehrDataUtil;
	}

	protected static EHRDataUtil getEhrDataUtil() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getEhrDataUtil
		return ehrDataUtil;
	}

	protected static void setEhrDataUtil(EHRDataUtil ehrDataUtil) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setEhrDataUtil
		EHRDataUtil.ehrDataUtil = ehrDataUtil;
	}
	
}
