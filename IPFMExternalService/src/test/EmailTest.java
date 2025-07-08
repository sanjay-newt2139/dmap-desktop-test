package test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import th.co.ais.email.service.EMailService;
import th.co.ais.email.service.TestMailModel;

public class EmailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/**
 * 
<bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
	<property name="host" value="mail.corp.ais900.org"/>
	<property name="port" value="25"/>
</bean>

<bean id="emailService" class="th.co.ais.email.service.EMailService">
	<property name="sender" ref="mailSender"/>
	<property name="velocityEngine" ref="velocityEngine"/>
</bean>

<bean id="velocityEngine" class="org.springframework.ui.velocity.VelocityEngineFactoryBean">
	<property name="velocityProperties">
		<value>
			resource.loader=class
			class.resource.loader.class=org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
		</value>
	</property>
</bean>
 * 
 * 		
 */
		
		try {
			VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
            HashMap< String, Object> velocityPropertiesMap = new HashMap();
			velocityPropertiesMap.put("resource.loader", "class");
			velocityPropertiesMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			velocityEngine.setVelocityPropertiesMap(velocityPropertiesMap);

			JavaMailSenderImpl javamail = new JavaMailSenderImpl();
			javamail.setHost("mail.corp.ais900.org");
			javamail.setPort(25);
			
			
			
			EMailService service = new EMailService();
			service.setSender(javamail);
			service.setVelocityEngine(velocityEngine.createVelocityEngine());//from spring not call createVelocityEngine
			
			//prepare parameter
			String[] to = {"boonchen55@aispilot.org"};
            String[] cc = null;
            String from = "kittil45@ais.co.th";
			
            Map model = new HashMap();
            TestMailModel testmodel = new TestMailModel();
            testmodel.setEmailAddress("chatchai.k@optimussoft.com");
            testmodel.setUserName("chatchai.k");
            model.put("template1", testmodel);

			service.sendMail(to, cc, from, EMailService.TEMPLATE_1, model);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
