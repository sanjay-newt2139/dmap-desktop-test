package test;

import th.co.ais.ldap.domain.LDAPResMsg;
import th.co.ais.ldap.service.LDAPService;

public class LDAPTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LDAPService ldap = new LDAPService();
			ldap.setEndpoint("http://authenldap.ais.co.th/corporate.asmx");
			LDAPResMsg msg = ldap.authenLDAP("puttapoa", "Ais.co.th", "CORP");
			System.out.println(msg.getDETAIL());
			System.out.println(msg.getSTATUS());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
