package test;

import java.util.List;

import th.co.ais.ehr.domain.EmployeeProfile;
import th.co.ais.ehr.service.EmployeeProfileService;



public class EHRTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int rowIndex = 20;
			int rowsPerPage = 20;
			int page = (rowIndex/rowsPerPage);
			System.out.println("page = " + page);
			
			int first = page*rowsPerPage;
			System.out.println("first = " + first);
			
			int last = ((page+1)*rowsPerPage)-1;
			System.out.println("last = " + last);
//			String ipVersion = "4.0";
//			if (ipVersion.indexOf(".")>-1) {
//				ipVersion = ipVersion.substring(0, ipVersion.indexOf("."));
//			}
//			System.out.println(ipVersion);
//			WS_OM_OMEHRServicesSoapProxy proxy = new WS_OM_OMEHRServicesSoapProxy();
//			GetEmployeeProfileByPrefixPinResponseGetEmployeeProfileByPrefixPinResult result =  proxy.getEmployeeProfileByPrefixPin("00032351");
//			//org.tempuri.ListAllApproverResponseListAllApproverResult result = proxy.listAllApprover("00000293", "50064777");
//			//System.out.println(result);
//			System.out.println((result.get_any()[1]).getAsString());
//			//fix bug thai language
//			String xml = StringEscapeUtils.unescapeHtml(s);
//			System.out.println(xml);
//			EmployeeServiceWebServiceV2Proxy ssoService = new EmployeeServiceWebServiceV2Proxy();
//			ssoService.setEndpoint("http://10.240.1.101:7201/EmployeeServiceWebServiceV2/EmployeeServiceWebServiceV2.jws");
//			SSOResponse response = ssoService.getToken("a", "a", "a", "a", "a");
//			System.out.println(response);
			//test ehr
//			EmployeeProfileService ehrService = new EmployeeProfileService();
//			ehrService.setEndpoint("http://test-omservices.ais.co.th/ExternalServices/WS_OM_OMEHRServices.asmx");
//			ehrService.setPassword("Ais.co.th");
//			ehrService.setUsername("corp-aispilot\\ehr_test1");
////			ehrService.setEndpoint("http://omservices.ais.co.th/ExternalServices/WS_OM_OMEHRServices.asmx");
////			ehrService.setPassword("IPS#serv3");
////			ehrService.setUsername("corp-ais900\\ipfmservice");
////			
////			List<EmployeeProfile> list = ehrService.getEmployeeProfilesByPIN("00027611");
//			List<EmployeeProfile> list = ehrService.getEmployeeProfilesByEmail("samartp@%");
//			System.out.println(list.size());
//			System.out.println(list.get(0).getENGName());
//			System.out.println(list.get(0).getENGSurname());
//			System.out.println(list.get(0).getEmail());
//			System.out.println(list.get(0).getPIN());
//			System.out.println(list.get(0).getPositionID());
//			System.out.println(list.get(0).getPosition());
//			
//			
//			EmployeeProfileService ehrService1 = new EmployeeProfileService();
//			ehrService1.setEndpoint("http://omservices.ais.co.th/ExternalServices/WS_OM_OMEHRServices.asmx");
//			ehrService1.setPassword("Ais.co.th");
//			ehrService1.setUsername("corp-aispilot\\ehr_test1");
////			
//			List<EmployeeProfile> list = ehrService.getEmployeeProfilesByPIN("00027611");
//			List<EmployeeProfile> list1 = ehrService1.getEmployeeProfilesByEmail("boonyakn@%");
//			System.out.println(list1.size());
//			System.out.println(list1.get(0).getENGName());
//			System.out.println(list1.get(0).getENGSurname());
//			System.out.println(list1.get(0).getEmail());
//			System.out.println(list1.get(0).getPIN());
//			System.out.println(list1.get(0).getPositionID());
//			System.out.println(list1.get(0).getPosition());
			
//			List<Approver> aprlist = ehrService.listAllApprover("00000293", "50064777");
//			System.out.println(aprlist.size());
//			System.out.println(aprlist.get(0).getName());
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
