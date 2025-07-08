package test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import th.co.ais.sms.service.SMSService;
import th.co.ais.sms.service.TestSMSModel;

public class SMSTest {
	public static void main(String[] args) {
		try {
			VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
            HashMap< String, Object> velocityPropertiesMap = new HashMap();
			velocityPropertiesMap.put("resource.loader", "class");
			velocityPropertiesMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			velocityEngine.setVelocityPropertiesMap(velocityPropertiesMap);
			
			Map model = new HashMap();
            TestSMSModel testmodel = new TestSMSModel();
            testmodel.setUserName("chatchai.k");
            model.put("template1", testmodel);
			
			SMSService service = new SMSService();
			service.setVelocityEngine(velocityEngine.createVelocityEngine());
			service.setShellcommand("./data1/sendsms");
			service.sendSMS("0819853241", "0819853241", SMSService.TEMPLATE_1, model);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
