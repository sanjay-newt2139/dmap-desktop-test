package th.co.ais.sms.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;


public class SMSService {
	public static final String TEMPLATE_1 = "Template1";
	public static final String TEMPLATE_OVERSLA = "OverSLATemplate";
	public static final String DOUBLE_QOUTE = "\"";
	public static final String SPACE = " ";
	private static final Logger logger = Logger.getLogger(SMSService.class);
	private String shellcommand = null;
	private VelocityEngine velocityEngine;
	
	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}
	
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	public String getShellcommand() {
		return shellcommand;
	}
	
	public void setShellcommand(String shellcommand) {
		this.shellcommand = shellcommand;
	}
	
	public void sendSMS(String srcMSISDN, String desMSISDN, String template, Map model){
		try {
			String text = VelocityEngineUtils.mergeTemplateIntoString(
            		velocityEngine, "th/co/ais/sms/service/sms" + template + ".vm", model);
            
			String command = shellcommand + SPACE + DOUBLE_QOUTE + srcMSISDN + DOUBLE_QOUTE + SPACE + DOUBLE_QOUTE + desMSISDN + DOUBLE_QOUTE + SPACE + DOUBLE_QOUTE + "UR : " + text + DOUBLE_QOUTE;
			System.out.println(command);
			Runtime rtime = Runtime.getRuntime();
			Process child = rtime.exec(command);
			logger.error(command);
		} catch (Exception e) {
			logger.error("SMSService:sendSMS", e);
		}
	}
}
