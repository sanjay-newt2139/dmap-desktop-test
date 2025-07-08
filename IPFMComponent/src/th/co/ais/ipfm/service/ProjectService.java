package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.Project;
import th.co.ais.ipfm.exception.IPFMBusinessException;




public interface ProjectService {

	public List<Project> getProjectList() throws IPFMBusinessException;
	
}
