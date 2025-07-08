package th.co.ais.email.service;

import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import th.co.ais.ipfm.dao.IPEmailNotifyDao;
import th.co.ais.ipfm.util.PropertyUtil;


public class EMailService {
	public static final String TEMPLATE_1 = "Template1"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_1
	public static final String TEMPLATE_IPFM = "TemplateIPFM"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM
	public static final String TEMPLATE_IPFM_NC_UR = "TemplateIPFMNCByUr"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_NC_UR
	public static final String TEMPLATE_IPFM_NC_SUBUR = "TemplateIPFMNCBySubUr"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_NC_SUBUR
	public static final String TEMPLATE_IPFM_TEAM_REJECT = "TemplateIPFMTeamReject"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_TEAM_REJECT
	public static final String TEMPLATE_IPFM_ASSIGNIP = "TemplateIPFMAssignIP"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_ASSIGNIP
	public static final String TEMPLATE_IPFM_IPEXPIRE = "TemplateIPFMIPExpire"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_IPEXPIRE
	public static final String TEMPLATE_IPFM_IPEXPIRE_LEVEL2 = "TemplateIPFMIPExpireLevel2"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_IPEXPIRE_LEVEL2
	public static final String TEMPLATE_IPFM_IPEXPIRE_LEVEL2_ASSIGN = "TemplateIPFMIPExpireLevel2Assign";	 // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_IPEXPIRE_LEVEL2_ASSIGN
	public static final String TEMPLATE_IPFM_ASSIGNIP_PLANNING = "PlanningAssignIP"; // DMAP Comment : Dead Code Detected - The Following Field has no reference TEMPLATE_IPFM_ASSIGNIP_PLANNING
	private static final Logger logger = Logger.getLogger(EMailService.class);
	private JavaMailSender sender = null;
	private VelocityEngine velocityEngine;
	private IPEmailNotifyDao ipEmailNotify;
	
	public String getKeyCodeEmail(){ // DMAP Comment : Dead Code Detected - The Following Method has no reference getKeyCodeEmail
		return (UUID.randomUUID()).toString();
	}
	
	public void setIpEmailNotify(IPEmailNotifyDao ipEmailNotify) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpEmailNotify
		this.ipEmailNotify = ipEmailNotify;
	}

	public JavaMailSender getSender() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getSender
		return sender;
	}

	public void setSender(JavaMailSender sender) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setSender
		this.sender = sender;
	}

	public VelocityEngine getVelocityEngine() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getVelocityEngine
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setVelocityEngine
		this.velocityEngine = velocityEngine;
	}

	public void sendMail(final String[] to, final String[] cc, final String from, final String template, final Map model){ // DMAP Comment : Dead Code Detected - The Following Method has no reference sendMail
		System.out.print("Send mail to "+to);
		System.out.print("Send mail cc "+cc);
		System.out.print("Send mail to "+from);
		
		
		try {
			if(sender != null) {
				String endpoint = PropertyUtil.getProperty("MAIL_SERVER");
				String port = PropertyUtil.getProperty("MAIL_PORT");
				
				((JavaMailSenderImpl) sender).setHost(endpoint);
				((JavaMailSenderImpl) sender).setPort(Integer.parseInt(port));
			}
			
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception { // DMAP Comment : Dead Code Detected - The Following Method has no reference prepare
		            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		            message.setTo(to);
		            if(cc!=null && cc.length>0){
						message.setCc(cc);	
					}   
		            message.setFrom(from);
		            
		            String subject = VelocityEngineUtils.mergeTemplateIntoString(
		            		velocityEngine, "th/co/ais/email/service/subject" + template + ".vm", model);
		            message.setSubject(subject);
		            
		            String body = VelocityEngineUtils.mergeTemplateIntoString(
		            		velocityEngine, "th/co/ais/email/service/body" + template + ".vm", model);
		            message.setText(body, true);
		        }
			};
			this.sender.send(preparator);		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("EMailService:sendMail", e);
		}
	}
	
	public void deleteNotify(String urNo,String urStatus){ // DMAP Comment : Dead Code Detected - The Following Method has no reference deleteNotify
		if((urStatus!=null) && !(urStatus.equals(""))){
			ipEmailNotify.deleteNotibyByStatus(urNo, urStatus);
		} else {
			ipEmailNotify.deleteNotibyByUrNo(urNo);
		}
	}
}
