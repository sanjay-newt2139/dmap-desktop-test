package th.co.ais.sms.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;


public class SMSService {
	public static final String TEMPLATE_1 = "Template1"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_1
	public static final String TEMPLATE_OVERSLA = "OverSLATemplate"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_OVERSLA
	public static final String DOUBLE_QOUTE = "\"";
	public static final String SPACE = " ";
	private static final Logger logger = Logger.getLogger(SMSService.class);
	private String shellcommand = null;
	private VelocityEngine velocityEngine;
	
	public VelocityEngine getVelocityEngine() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVelocityEngine
		return velocityEngine;
	}
	
	public void setVelocityEngine(VelocityEngine velocityEngine) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVelocityEngine
		this.velocityEngine = velocityEngine;
	}
	
	public String getShellcommand() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getShellcommand
		return shellcommand;
	}
	
	public void setShellcommand(String shellcommand) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setShellcommand
		this.shellcommand = shellcommand;
	}
	
	public void sendSMS(String srcMSISDN, String desMSISDN, String template, Map model){ // DMAP Comment : Dead Code Detected - The Following Method has no reference sendSMS
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
