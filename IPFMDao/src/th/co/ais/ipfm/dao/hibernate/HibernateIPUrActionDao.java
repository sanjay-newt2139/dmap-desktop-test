package th.co.ais.ipfm.dao.hibernate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.dao.IPUrActionDao;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpWfConfig;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;
import th.co.ais.ipfm.util.IPFMConstant;




public class HibernateIPUrActionDao extends HibernateGenericDao<IpUrAction> implements IPUrActionDao{
	
	@Override
	public List<IpUrAction> getURActionList(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.addOrder(Order.asc("lastUpd"));
		return criteria.list();
	}

	@Override
	public void deleteByUrNo(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACTION AC WHERE AC.UR_NO=?";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
		
	}

	@Override
	public void deleteBySubUrNo(String urNo, String subUrNo, String urStatus) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACTION AC WHERE AC.UR_NO=? AND AC.SUB_UR_NO = ? AND AC.UR_STATUS = ? ";
		session.createSQLQuery(sql).setString(0, urNo).setString(1, subUrNo).setString(2, urStatus).executeUpdate();
		
	}
	
	@Override
	public IpUrAction findUrAction(String urNo, String subUrNo)
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		List<IpUrAction> result = criteria.list();
		return (result.size()!=0)?result.get(0):null;
	}
	
	
	@Override
	public List<IpUrAction> findUrActions(String urNo,String subUrNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		criteria.addOrder(Order.asc("actionSeq"));
		List<IpUrAction> result = criteria.list();
		return result;
	}	

	@Override
	public Date getSLADate(Date reqDate,String urType,String pm) {
		return getSLADate(reqDate,urType,pm,"N");
	}
	
	@Override
	public Integer getValueSLADate(String urType,String pm,String isImpact){
		Session session = getSessionFactory().getCurrentSession();
		Integer sla =  (Integer) session.createSQLQuery("SELECT SLA FROM IP_WF_CONFIG WHERE UR_TYPE='"+urType+"' AND IMPACT_STATUS='"+isImpact+"' AND PM_TEAM='"+pm+"'")
			.addScalar("SLA", Hibernate.INTEGER).uniqueResult();
		return sla;
	}
	
	@Override
	public Integer getValueOLADate(String urType,String nodeId) {
		Session session = getSessionFactory().getCurrentSession();
		Integer ola =  (Integer) session.createSQLQuery("SELECT OLA FROM IP_WF_CONFIG_DETAIL WHERE UR_TYPE='"+urType+"' AND NODE_ID='"+nodeId+"'")
			.addScalar("OLA", Hibernate.INTEGER).uniqueResult();
		return ola;
	}
	
	@Override
	public Date getSLADate(Date reqDate,String urType,String pm,String isImpact){
		Session session = getSessionFactory().getCurrentSession();
		String sla =  (String) session.createSQLQuery("SELECT SLA FROM IP_WF_CONFIG WHERE UR_TYPE='"+urType+"' AND IMPACT_STATUS='"+isImpact+"' AND PM_TEAM='"+pm+"'")
			.addScalar("SLA", Hibernate.STRING).uniqueResult();
		if(sla==null 
//				|| sla.equals("0")
		){
			return reqDate;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reqDate);
		calendar.add(Calendar.DATE, Integer.parseInt(sla));

		int nonwork = nonWorkDay(reqDate,calendar.getTime());		
		int holiday = getHoliday(reqDate,calendar.getTime()); 
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(calendar.getTime());
		calendar1.add(Calendar.DATE, nonwork + holiday);
		
		while (true) {
			if (calendar.getTime().compareTo(calendar1.getTime()) > -1) break;
			calendar.add(Calendar.DATE, 1);
			int nonwork1 = nonWorkDay(calendar.getTime(),calendar1.getTime());
			int holiday1 = getHoliday(calendar.getTime(),calendar1.getTime());
			
			if (nonwork1==0 && holiday1==0) break;
			
			calendar.setTime(calendar1.getTime());
			calendar1.add(Calendar.DATE, nonwork1 + holiday1);
		}
		
		return calendar1.getTime();
	}
	
	public int nonWorkDay(Date start,Date end){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
	    int count = 0;
		for(;!calendar.getTime().after(end);calendar.add(Calendar.DATE,1)) {
			if((calendar.getTime().getDay()==0) || (calendar.getTime().getDay()==6)) count++;
		}
		return count;
	}
	
	public int getHoliday(Date start,Date end){
		SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy",new Locale("EN", "en"));
		Session session = getSessionFactory().getCurrentSession();
		String sql="SELECT COUNT(DISTINCT HOLIDAY_DATE) AS HOLIDAY_DAYS FROM IP_MASTER_TABLE WHERE REF_TABLE='HOLIDAY' AND ACTIVE_STATUS=1 ";
		sql+="AND HOLIDAY_DATE BETWEEN (TO_DATE('"+smf.format(start)+"','dd/mm/yyyy')) AND (TO_DATE('"+smf.format(end)+"','dd/mm/yyyy'))";
		Integer holiday =  (Integer) session.createSQLQuery(sql)
			.addScalar("HOLIDAY_DAYS", Hibernate.INTEGER).uniqueResult();
		return holiday;
	}

	@Override
	public Date getOLADate(Date reqDate,String urType,String nodeId) {
		Session session = getSessionFactory().getCurrentSession();
		String ola =  (String) session.createSQLQuery("SELECT OLA FROM IP_WF_CONFIG_DETAIL WHERE UR_TYPE='"+urType+"' AND NODE_ID='"+nodeId+"'")
			.addScalar("OLA", Hibernate.STRING).uniqueResult();
		if(ola==null 
//				|| ola.equals("0")
		){
			return reqDate;
		}
				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reqDate);
		calendar.add(Calendar.DATE, Integer.parseInt(ola));
    
		int nonwork = nonWorkDay(reqDate,calendar.getTime());		
		int holiday = getHoliday(reqDate,calendar.getTime()); 
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(calendar.getTime());
		calendar1.add(Calendar.DATE, nonwork + holiday);
		while (true) {
			if (calendar.getTime().compareTo(calendar1.getTime()) > -1) break;
			calendar.add(Calendar.DATE, 1);
			int nonwork1 = nonWorkDay(calendar.getTime(),calendar1.getTime());
			int holiday1 = getHoliday(calendar.getTime(),calendar1.getTime());
			
			if (nonwork1==0 && holiday1==0) break;
			
			calendar.setTime(calendar1.getTime());
			calendar1.add(Calendar.DATE, nonwork1 + holiday1);
		}
		
		return calendar1.getTime();
	}

	@Override
	public List<IpUrAction> listActionByStatus(String urNo, String status) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", status));
		return criteria.list();
	}

	@Override
	public void deleteByRowID(String rowID) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACTION AC WHERE AC.ROW_ID=?";
		session.createSQLQuery(sql).setString(0, rowID).executeUpdate();
	}

	@Override
	public void deleteNA(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		String sql = "DELETE FROM IP_UR_ACTION AC WHERE AC.UR_NO=? AND AC.SUB_UR_NO='NA'";
		session.createSQLQuery(sql).setString(0, urNo).executeUpdate();
	}

	@Override
	public List<IpUrAction> listActionByOwner(String urNo, String owner) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",owner,Hibernate.STRING));
		return criteria.list();
	}

	@Override
	public boolean isOwnerApproveAll(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_WAIT_OWNER));
		return (criteria.list().size()==0);
	}

	@Override
	public void updateAction(String urNo,String urStatus , String callFunc, String callMode,
			IpUser user) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE IP_UR_ACTION ");			
		sql.append("SET	UR_STATUS = ? ");	
		sql.append(",	ACTION_NAME=(SELECT DISTINCT SUB_UR_STATUS_NAME FROM IP_UR_STATUS WHERE UR_TYPE='NC' AND SUB_UR_STATUS_ID = ? ) ");
		sql.append(",	CALL_FUNCTION_ID=? ");		
		sql.append(",	CALL_MODE=? ");		
		sql.append(",	UPDATE_BY = ? ");		
		sql.append(",	UPDATE_DATE = sysdate ");		
		sql.append("WHERE UR_NO=? ");			
		session.createSQLQuery(sql.toString())
			.setString(0, urStatus)
			.setString(1, urStatus)
			.setString(2, callFunc)
			.setString(3, callMode)
			.setString(4, user.getUserId())
			.setString(5, urNo)
			.executeUpdate();
	}
	@Override
	public void updateActionReject(String urNo,String urStatus , String callFunc, String callMode,
			IpUser user , IpUser reqUser) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE IP_UR_ACTION ");			
		sql.append("SET	UR_STATUS = ? ");	
		sql.append(",	ACTION_NAME=(SELECT DISTINCT SUB_UR_STATUS_NAME FROM IP_UR_STATUS WHERE UR_TYPE='NC' AND SUB_UR_STATUS_ID = ? ) ");
		sql.append(",	CALL_FUNCTION_ID=? ");		
		sql.append(",	CALL_MODE=? ");		
		sql.append(",	ACTION_USER_ID = ? ");	
		sql.append(",	ACTION_USER = ? ");	
		sql.append(",	UPDATE_BY = ? ");	
		sql.append(",	UPDATE_DATE = sysdate ");		
		sql.append("WHERE UR_NO=? ");			
		session.createSQLQuery(sql.toString())
			.setString(0, urStatus)
			.setString(1, urStatus)
			.setString(2, callFunc)
			.setString(3, callMode)
			.setString(4, reqUser.getUserId())
			.setString(5, reqUser.getUserName() + reqUser.getPhone())
			.setString(6, user.getUserId())
			.setString(7, urNo)
			.executeUpdate();
	}

	@Override
	public boolean isOwnerRejectAll(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_REJECT_OWNER));
		return (criteria.list().size()==0);
	}



	@Override
	public List<IpUrAction> listActionForActm(String urNo,IpUser user) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_WAIT_ACTM));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",user.getUserId(),Hibernate.STRING));
		return criteria.list();
	}

	@Override
	public List<IpUrAction> listActionTeam(String urNo, IpUser user) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_ACTM_TEAM));
		return criteria.list();
	}

	@Override
	public boolean isInRole(String user, String RoleId) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(DISTINCT role_id) as num ");
		sql.append("from ip_role_member ");				
		sql.append("where user_id = ? and role_id=? ");
		Integer count =  (Integer) (session.createSQLQuery(sql.toString())
			.addScalar("num", Hibernate.INTEGER)
			.setString(0, user)
			.setString(1, RoleId))
			.uniqueResult(); 
		
		return (count>0);
	}

	@Override
	public boolean isSendMailACTM(String user) {
		boolean done = false;
		String [] roleId = {"R9","R10","R11","R12","R13","R14","R15","R16","R17"};
		Map<String, String> teamId = new HashMap<String, String>();
		teamId.put("R9", "N9");   teamId.put("R10", "N10"); teamId.put("R15", "N11"); 
		teamId.put("R12", "N12"); teamId.put("R13", "N17"); teamId.put("R14", "N13"); 
		teamId.put("R15", "N15"); teamId.put("R16", "N14");	teamId.put("R17", "R16");
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpRoleMember.class);
		criteria.add(Restrictions.eq("userId", user));
		
		criteria.add(Restrictions.in("roleId", roleId));
		List<IpRoleMember> roleList = criteria.list();
		for(IpRoleMember role : roleList){
			Criteria criteriaCW = session.createCriteria(IpWfConfigDetail.class);
			criteriaCW.add(Restrictions.eq("id.urType", "NC"));
			criteriaCW.add(Restrictions.eq("id.nodeId", teamId.get(role.getRoleId())));
			IpWfConfigDetail result = (IpWfConfigDetail)criteriaCW.uniqueResult(); 
			done = (done || result.getEmailStatus().equals("Y")); 
		}
		
		return done;
	}

	@Override
	public void deleteACTM(String urNo,IpUser user) {
		StringBuffer sql = new StringBuffer();
		Session session = getSessionFactory().getCurrentSession();		
		sql.append("DELETE FROM IP_UR_ACTION ");					
		sql.append("WHERE UR_NO=? ");					
		sql.append("AND UR_STATUS='WAIT_ACTM' ");	
		if (user!=null) {
			sql.append("AND INSTR(';'||ACTION_USER_ID||';' , ';'||?||';' )>0 ");	
			session.createSQLQuery(sql.toString())
				.setString(0, urNo)
				.setString(1, user.getUserId())
				.executeUpdate();
		}else{
			session.createSQLQuery(sql.toString())
				.setString(0, urNo)
				.executeUpdate();
		}
		
	}

	@Override
	public List<IpUrAction> listWaitTeamProcess(String urNo,IpUser user){
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		String [] status = {IPFMConstant.STATUS_WAIT_TEAM,IPFMConstant.STATUS_REJECT_TEAM};
		criteria.add(Restrictions.in("urStatus", status));		
		//criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_WAIT_TEAM)); modiied by bob, For fix Force Complete Flow.
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",user.getUserId(),Hibernate.STRING));
		return criteria.list();
	}

	@Override
	public List<IpUrAction> findActionStatus(IpUrAction action, String ststus) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", action.getUrNo()));
		criteria.add(Restrictions.eq("urType", action.getUrType()));
		criteria.add(Restrictions.eq("subUrNo", action.getSubUrNo()));
		criteria.add(Restrictions.eq("subUrType", action.getSubUrType()));
		criteria.add(Restrictions.eq("urStatus", ststus));
		return criteria.list();
	}
	
	@Override
	public boolean isDelegateAble(String urNo, String subUrNo,String userId) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		String [] status = {IPFMConstant.STATUS_WAIT_ACTM,IPFMConstant.STATUS_ACTM_TEAM,IPFMConstant.STATUS_WAIT_TEAM};
		criteria.add(Restrictions.in("urStatus", status));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",userId,Hibernate.STRING));
		return (criteria.list().size()==0);

	}
	
	@Override
	public boolean isRejectAble(String urNo, String subUrNo,String userId)throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		String [] status = {IPFMConstant.STATUS_WAIT_ACTM,IPFMConstant.STATUS_ACTM_TEAM,IPFMConstant.STATUS_WAIT_TEAM};
		criteria.add(Restrictions.in("urStatus", status));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",userId,Hibernate.STRING));
		return (criteria.list().size()==0);

	}	


	@Override
	public List<IpUrAction> listPMAssign(String urNo, IpUser user) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", IPFMConstant.STATUS_WAIT_PM));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",user.getUserId(),Hibernate.STRING));
		return criteria.list();
	}

	@Override
	public int getOLADateFromNodeID(String roleId) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OLA FROM IP_WF_CONFIG_DETAIL where NODE_ID=?");
		Integer count =  (Integer) (session.createSQLQuery(sql.toString())
				.addScalar("OLA", Hibernate.INTEGER)
				.setString(0, roleId))
				.uniqueResult();
		return count;
	}

	@Override
	public IpWfConfig getSLADateImpact(String isImpact) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpWfConfig.class);
		criteria.add(Restrictions.eq("urType", "NC"));
		criteria.add(Restrictions.eq("impactStatus", isImpact));
		criteria.addOrder(Order.desc("sla"));
		List<IpWfConfig> list = criteria.list(); 
		return (IpWfConfig)((list.size()!=0)?list.get(0):null);
	}

	@Override
	public String isOverSla(String urNo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select decode(sign(sla_date - trunc(sysdate)),-1,'Y','N') ");
		sql.append("from ip_ur_action ");
		sql.append("where ur_no = '"+urNo+"' ");					
		
		Session session = getSessionFactory().getCurrentSession();
		String overSla = (String)session.createSQLQuery(sql.toString()).uniqueResult();
		return overSla;
	}

	@Override
	public IpUrAction findUrActionNotify(String urNo,String status,String userId) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("urStatus", status));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",userId,Hibernate.STRING));
		List<IpUrAction> ipUrActionList = criteria.list();
		if (ipUrActionList.size()>0) {
			return ipUrActionList.get(0);
		}
		return null;
	}

	@Override
	public IpUrAction findUrAction(String urNo, String subUrNo, String user)
			throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",user,Hibernate.STRING));
		List<IpUrAction> result = criteria.list();
		return (result.size()!=0)?result.get(0):null;
	}

	@Override
	public int getUnFinishUR(String urNo) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(SUB_UR_NO) as num "); 					
		sql.append("FROM IP_UR_ACTION ");					
		sql.append("WHERE UR_NO=? ");					
		sql.append("AND UR_STATUS IN ('WAIT_ACTM','WAIT_ACTM_TEAM','WAIT_TEAM','WAIT_PM') ");
		
		Session session = getSessionFactory().getCurrentSession();
		Integer num = (Integer)(session.createSQLQuery(sql.toString())
				.addScalar("num", Hibernate.INTEGER))
				.setString(0, urNo)
				.uniqueResult();

		return num;
	}
	
	@Override
	public List<IpUrAction> findActionByURAndStatus(String urNo, String[] status) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.in("urStatus", status));
		return (criteria.list());
	}
	
	@Override
	public List<IpUrAction> findActionBySubURAndStatus(String urNo,String subUrNo, String[] status) throws Exception {
		Session session = getSessionFactory().getCurrentSession();
		StringBuffer sql = new StringBuffer();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		criteria.add(Restrictions.in("urStatus", status));
		return (criteria.list());
	}

	@Override
	public List<IpUrAction> listAction(String urNo, IpUser user, String status) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		if(!isEmpty(status)){
			criteria.add(Restrictions.eq("urStatus", status));
		}
		if(user!=null){
			criteria.add(Restrictions.sqlRestriction("INSTR(';'||{alias}.ACTION_USER_ID||';' , ';'||?||';' )>0",user.getUserId(),Hibernate.STRING));
		}

		return criteria.list();
	}
	@Override
	public List<IpUrAction> listAction(String urNo, String subUrNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.add(Restrictions.eq("subUrNo", subUrNo));
		return criteria.list();
	}
	private boolean isEmpty(String value){
		return (value==null) || (value.equals(""));
	}

	@Override
	public Map deletePreviousUrAction(String urNo) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		Map result = new HashMap();
		List<IpUrAction> actionList = criteria.list();
		for(IpUrAction action : actionList){
			String name = action.getUrNo()+":"+action.getSubUrNo();
			Map tmp = new HashMap();
			tmp.put("seq", action.getActionSeq());
			tmp.put("createDate", action.getCreated());
			tmp.put("createBy", action.getCreatedBy());
			result.put(name, tmp);
		}
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM IP_UR_ACTION ");					
		sql.append("WHERE UR_NO=? ");					
		
		session.createSQLQuery(sql.toString())
			.setString(0, urNo)
			.executeUpdate();
		
		return result;
	}

	@Override
	public List<IpUrAction> getURAction(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
	@Override
	public List<IpUrAction> findIpUrActionList(String urNo) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IpUrAction.class);
		criteria.add(Restrictions.eq("urNo", urNo));
		criteria.addOrder(Order.asc("subUrNo"));
		return criteria.list();
	}
	
	@Override
	public BigDecimal getNextActionSeq(String urNo, String urType, String subUrNo) throws Exception{
		Session session = getSessionFactory().getCurrentSession();
		String seqNo =  (String) session.createSQLQuery(
					"SELECT NVL(MAX(ACTION_SEQ),0)+1 as NEWSEQ " +
					"FROM (" +
						"SELECT NVL(ACTION_SEQ,0) as ACTION_SEQ FROM IP_UR_ACTION WHERE UR_NO='"+urNo+"' " +
							" AND UR_TYPE = '"+urType+"' AND SUB_UR_NO = '"+subUrNo+"' " +
						"UNION SELECT NVL(ACTION_SEQ,0) as ACTION_SEQ FROM IP_UR_ACTION_HISTORY WHERE UR_NO='"+urNo+"' " +
							" AND UR_TYPE = '"+urType+"' AND SUB_UR_NO = '"+subUrNo+"') "
				)
				.addScalar("NEWSEQ", Hibernate.STRING).uniqueResult();
		return new BigDecimal(seqNo);
	}
	
	
}
