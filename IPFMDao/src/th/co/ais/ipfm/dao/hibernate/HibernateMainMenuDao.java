package th.co.ais.ipfm.dao.hibernate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import th.co.ais.ipfm.dao.IMainMenuDao;
import th.co.ais.ipfm.domain.Suggestion;
import th.co.ais.ipfm.domain1.IpFunction;

public class HibernateMainMenuDao extends HibernateGenericDao<IpFunction> implements IMainMenuDao {

	@Override
	public List<IpFunction> listMenuByUserID(String userId) throws Exception{
		Session session = this.getSessionFactory().getCurrentSession();
		List<IpFunction> result = new ArrayList<IpFunction>();
		try {
			StringBuffer sqlBuff = new StringBuffer();
			sqlBuff.append("select distinct f from IpRoleFunction t , IpRoleMember m , IpFunction f " +
					"where t.id.roleId = m.id.roleId " +
					"and t.id.funcId = f.funcId " +
					"and m.id.userId = '"+userId+"' order by f.menuLevel,f.menuSeq");
			result = session.createQuery(sqlBuff.toString()).list();
			
//			Criteria criteria = session.createCriteria(IpRoleFunction.class);
//			criteria.createAlias("ipFunction", "f");
//			criteria.createAlias("memberCollection", "m");
//			criteria.setFetchMode("memberCollection", FetchMode.SELECT);
//	        criteria.add(Restrictions.eq("m.userId", userId));
//			criteria.addOrder(Order.asc("f.menuLevel"));
//			criteria.addOrder(Order.asc("f.menuSeq"));
//			result = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return result;
	}

//	@Override
//	public String findGroupByUser(String userID) {
//		// TODO Auto-generated method stub
//		Session session = this.getSessionFactory().getCurrentSession();
//		Criteria criteria = session.createCriteria(IpUser.class);
//		criteria.add(Restrictions.eq("userId", userID));
//		IpUser user = (IpUser) criteria.uniqueResult();
//		return user.getUserGroupId();
//	}

	@Override
	public List<Suggestion> listProject() {
		// TODO Auto-generated method stub
		List resultList = new ArrayList<Suggestion>();
		Session session = this.getSessionFactory().getCurrentSession();
		Connection connection = session.connection();
		try{
			StringBuffer sql = new StringBuffer(); 
			sql.append("select A.REF_KEY, A.SHORT_DESC ");
			sql.append("from ip_master_table A ");
			sql.append("where ref_table = 'LOCATION' ");
			sql.append("ORDER BY A.SHORT_DESC ");
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			while(rs.next()){
				resultList.add(new Suggestion(rs.getString("REF_KEY"),rs.getString("SHORT_DESC")));
			}
			rs.close();
			stmt.close();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<IpFunction> findAllMenu() {
		List<IpFunction> resultList = new ArrayList<IpFunction>();
		Session session = this.getSessionFactory().getCurrentSession();
		try{
			StringBuffer sql = new StringBuffer(); 
			sql.append("select t ");
			sql.append("from IPFunction t ");
			sql.append("order by t.funcId asc ");
			
			resultList = session.createQuery(sql.toString()).list();
			Hibernate.initialize(resultList);
			System.out.println("IPFunction size = "+ resultList.size());
			if (resultList==null || resultList.size()==0) {
				resultList = new ArrayList<IpFunction>();
			}else{
//				for (IpFunction ipFunction : resultList){
//					if (ipFunction!=null && ipFunction.getMenuLevel()!=null && ipFunction.getMenuLevel().intValue()==1) {
//						ipFunction.setStatusAdvance("User Request");
//						if (ipFunction.getFuncMatherId().equalsIgnoreCase("F002")) {
//							ipFunction.setStatusAdvance("Search");
//						}
//					}
//				}
			}
			
		} catch (Exception ex){
			ex.printStackTrace();
		}finally{
			//session.close();
		}
		return resultList;
	}

	@Override
	public IpFunction findMenuByRowId(Integer rowId) {
		IpFunction result = new IpFunction();
		Session session = this.getSessionFactory().getCurrentSession();
		try{
			StringBuffer sql = new StringBuffer(); 
			sql.append("select t ");
			sql.append("from IpFunction t ");
			sql.append("where t.rowId = '"+rowId+"' ");
			sql.append("order by funcId asc ");
			
			List<IpFunction> resultList = session.createQuery(sql.toString()).list();
			
			if (resultList==null || resultList.size()>0) {
				result = resultList.get(0);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}finally{
			//session.close();
		}
		return result;
	}

	@Override
	public List<IpFunction> findMenuLevel1ByUserId(String userId) throws Exception{
		Session session = this.getSessionFactory().getCurrentSession();
		List<IpFunction> result = new ArrayList<IpFunction>();
		try { 
			StringBuffer sqlBuff = new StringBuffer();
			sqlBuff.append("select distinct f from IpRoleFunction t , IpRoleMember m , IpFunction f " +
					"where t.id.roleId = m.id.roleId " +
					"and t.id.funcId = f.funcId " +
					"and f.menuLevel = '0' " +
					"and m.id.userId = '"+userId+"' order by f.menuSeq");
			result = session.createQuery(sqlBuff.toString()).list();
			
//			Criteria criteria = session.createCriteria(IpRoleFunction.class);
//			criteria.createAlias("ipFunction", "f");
//			criteria.createAlias("memberCollection", "m");
//			criteria.setFetchMode("memberCollection", FetchMode.SELECT);
//	        criteria.add(Restrictions.eq("m.userId", userId));
//			criteria.addOrder(Order.asc("f.menuLevel"));
//			criteria.addOrder(Order.asc("f.menuSeq"));
//			result = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		return result;
	}

	
	


}
