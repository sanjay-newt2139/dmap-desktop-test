package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.ProjectDao;
import th.co.ais.ipfm.domain1.Project;


public class HibernateProjectDao extends HibernateGenericDao<Project> implements ProjectDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectList() throws DataAccessException {
		Session session = this.getVsfmSessionFactory().getCurrentSession();
		List<Project> projectList = new ArrayList<Project>();
		try{
			/**
			 * No Table TRN_MASTER_PROJECT_UR
			StringBuffer sqlBuff = new StringBuffer();
			sqlBuff.append("select * from TRN_MASTER_PROJECT_UR t " +
					" order by UPPER(t.PROJECT_ID)");
			List list = session.createSQLQuery(sqlBuff.toString())
							.addScalar("PROJECT_ID").addScalar("PROJECT_NAME")
							.addScalar("PROJECT_MANAGER_PIN").list();
			Iterator iter = list.iterator();
			Project project;
			while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				project = new Project();
				project.setProjectId((String)obj[0]);
				project.setProjectName((String)obj[1]);
				project.setProjectManagerPin((String)obj[2]);
				projectList.add(project);
			} 
			**/
		}catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		return projectList;
	}
}
