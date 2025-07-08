package th.co.ais.ehr.service;

import java.io.StringReader;
import java.net.URL;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Unmarshaller;

import th.co.ais.ehr.domain.DiffgramApprover;
import th.co.ais.ehr.domain.DiffgramEmployeeProfile;

public class EHRXMLUtil {
	
	static Mapping approvermapping;
	static Mapping employeemapping;
	static Unmarshaller approverunmar;
	static Unmarshaller employeeunmar;
	
	static {
		init();
	}
	
	public final static void init() {
		try {
			URL urlA = EHRXMLUtil.class.getResource("approvermapping.xml");
			URL urlE = EHRXMLUtil.class.getResource("employeeprofilemapping.xml");
			approvermapping = new Mapping();
			employeemapping = new Mapping();
			approvermapping.loadMapping(urlA);
	    	employeemapping.loadMapping(urlE);
	    	approverunmar = new Unmarshaller(approvermapping);
            employeeunmar = new Unmarshaller(employeemapping);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final DiffgramApprover parserApproverMSXML(String xmlstr){
		DiffgramApprover diffgram = null;
		try {
			if (approverunmar==null) init();
			StringReader strReader = new StringReader(xmlstr);
			diffgram = (DiffgramApprover)approverunmar.unmarshal(strReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffgram;
	}
	
	public static final DiffgramEmployeeProfile parserEmployeeMSXML(String xmlstr){
		DiffgramEmployeeProfile diffgram = null;
		try {
			if (employeeunmar==null) init(); 
			StringReader strReader = new StringReader(xmlstr);
			diffgram = (DiffgramEmployeeProfile)employeeunmar.unmarshal(strReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffgram;
	}	
}
