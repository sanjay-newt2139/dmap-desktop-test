package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.Project;


public interface ProjectDao extends IGenericDao<Project, Long> {

	public List<Project> getProjectList() throws DataAccessException;
}
