package th.co.ais.ipfm.web.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import th.co.ais.ehr.domain.EmployeeProfile;
import th.co.ais.ehr.service.EmployeeProfileService;

public class LoadEHRDataListerner implements ServletContextListener {

	public static final String[] eng_chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext servletContext = arg0.getServletContext();
		try {
			EmployeeProfileService ehrService = (EmployeeProfileService) JSFServiceFinderUtil.getInstance().getBean("ehrService");
			EHRDataContainer container = new EHRDataContainer();
			container.setEhrDatas(new ArrayList<EHRData>());
			for(int i=0; i< eng_chars.length;i++) {
				List<EmployeeProfile> employeeList = ehrService.GetEmployeeProfileByPrefixEngName(eng_chars[i]);
				for(EmployeeProfile emp : employeeList) {
					
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void setToEHRData(EmployeeProfile emp , EHRData ehr) {
		ehr.setEmail(emp.getEmail());
//		ehr.setRoleId(emp.get);
//		ehr.setUserId(userId);
//		ehr.setUserName(userName);
	}
}
