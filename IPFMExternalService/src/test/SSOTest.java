package test;

import th.co.ais.sso.service.SSOService;
import Permission.bean.ais.com.SSOResponse;

public class SSOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			String_1 :: username
//			String_2 :: password
//			String_3 :: module
//			String_4 :: ou_type
//			String_5 :: projectCode
			SSOService sso = new SSOService();
			sso.setEndpoint("http://10.240.1.101:7201/EmployeeServiceWebServiceV2/EmployeeServiceWebServiceV2.jws");
			//SSOResponse response = sso.getToken("puttapoa", "Ais.co.th", "IPFM", "2", "SSOCORPTEST");
			SSOResponse response = sso.getToken("IPFMTEST", "ipfmtest", "IPFM", "2", "TIPFMAUTHEN");
			System.out.println("Flag = " + response.getMessage().isFlag());
			System.out.println("ErrorCode = " + response.getMessage().getErrorCode());
			System.out.println("ErrorMesg = " + response.getMessage().getErrorMesg());
			System.out.println("Type = " + response.getMessage().getType());
			System.out.println("TokenId = " + response.getMessage().getTokenId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
