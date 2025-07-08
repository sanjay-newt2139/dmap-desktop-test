package th.co.ais.ipfm.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;


import th.co.ais.ipfm.dao.IPDetailDao;
import th.co.ais.ipfm.domain.IPDetail;
import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.vo.IPDetailVO;

public class HibernateIPDetailDao extends HibernateGenericDao<IPDetail> implements IPDetailDao {

	
	@Override
	public List<IPDetail> search(IPDetailVO DTO, int maxResult) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPDetail.class);
		if(maxResult>0){
			criteria.setMaxResults(maxResult);	
		}
		String ipadress1="";
		String ipadress2="";
		
			if("6".equals(DTO.getIpVersion())){
				
							if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && !"".equals(DTO.getStIp4()) && !"".equals(DTO.getStIp5()) && !"".equals(DTO.getStIp6())){
								ipadress1 = DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getStIp4()+"."+DTO.getStIp5()+"."+DTO.getStIp6();
							}
							
							if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && !"".equals(DTO.getStIp4()) && !"".equals(DTO.getStIp5()) && !"".equals(DTO.getEdIp1())){
								ipadress2= DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getStIp4()+"."+DTO.getStIp5()+"."+DTO.getEdIp1();
							}
			}else if("4".equals(DTO.getIpVersion())){
				
							if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && !"".equals(DTO.getStIp4())){
								ipadress1 = DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getStIp4();
							}
							
							if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && !"".equals(DTO.getEdIp1())){
								ipadress2= DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getEdIp1();
							}								
			}
			
					/// Check  null 
					if(!"".equals(ipadress1) && !"".equals(ipadress2) ){
					  criteria.add(Expression.and(Expression.ge("ipAddress",ipadress1),Expression.le("ipAddress",ipadress2)));
					}
					if(DTO.getIpStatusId()!= null){
						criteria.add(Restrictions.eq("ipStatusId", DTO.getIpStatusId()));
					}
					if(!"".equals(DTO.getHostName())){
						criteria.add(Restrictions.ilike("hostName", DTO.getHostName()));
					}
					if(DTO.getLocationId()!= null){
						criteria.add(Restrictions.eq("locationId", DTO.getLocationId()));
					}
					if(DTO.getNetworkZoneId()!= null){
						criteria.add(Restrictions.eq("networkZoneId", DTO.getNetworkZoneId()));
					}
					if(DTO.getNetworkType()!= null){
						criteria.add(Restrictions.eq("networkType", DTO.getNetworkType()));
					}
					if(DTO.getReqestFromTeamId()!= null){
						criteria.add(Restrictions.eq("reqestFromTeamId", DTO.getReqestFromTeamId()));
					}
					if(!"".equals(DTO.getUrRefer())){
						criteria.add(Restrictions.ilike("urRefer", DTO.getUrRefer()));
					}
					if(!"".equals(DTO.getProjectId())){
						criteria.add(Restrictions.eq("projectId", DTO.getProjectId()));
					}
					if(DTO.getProjectManager()!= null){
						criteria.add(Restrictions.eq("projectManager", DTO.getProjectManager()));
					}
					if(!"".equals(DTO.getEffDateFrom()) && !"".equals(DTO.getEffDateTo())){
						criteria.add(Expression.and(Expression.ge("effDate",DTO.getEffDateFrom()),Expression.le("effDate",DTO.getEffDateTo())));
					}
					if(!"".equals(DTO.getExpDateFrom()) && !"".equals(DTO.getExpDateTo())){
						criteria.add(Expression.and(Expression.ge("expDate",DTO.getExpDateFrom()),Expression.le("expDate",DTO.getExpDateTo())));
					}
					if(DTO.getTier1TeamId()!=null || DTO.getTier2TeamId()!= null){
						criteria.add(Expression.or(Expression.eq("tier1TeamId", DTO.getTier1TeamId()),Expression.eq("tier2TeamId", DTO.getTier2TeamId())));
						/* criteria.add(Restrictions.eq("tier3TeamId", DTO.getTier3TeamId()));*/
					}

		return criteria.list();

	}

	@Override
	public int countSearchIPDetail(IPDetailVO DTO) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPDetail.class);
		String ipadress1="";
		String ipadress2="";
		
			if("6".equals(DTO.getIpVersion())){
				
					if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && 
					   !"".equals(DTO.getStIp4()) && !"".equals(DTO.getStIp5()) && !"".equals(DTO.getStIp6())){
						ipadress1 = DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getStIp4()+"."+DTO.getStIp5()+"."+DTO.getStIp6();
					}
					
					if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && 
					   !"".equals(DTO.getStIp4()) && !"".equals(DTO.getStIp5()) && !"".equals(DTO.getEdIp1())){
						ipadress2= DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getStIp4()+"."+DTO.getStIp5()+"."+DTO.getEdIp1();
					}
			}else if("4".equals(DTO.getIpVersion())){
				
							if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && 
							   !"".equals(DTO.getStIp4())){
								ipadress1 = DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getStIp4();
							}
							if(!"".equals(DTO.getStIp1()) && !"".equals(DTO.getStIp2()) && !"".equals(DTO.getStIp3()) && 
							   !"".equals(DTO.getEdIp1())){
								ipadress2= DTO.getStIp1()+"."+DTO.getStIp2()+"."+DTO.getStIp3()+"."+DTO.getEdIp1();
							}								
			}
			
					/// Check  null 
					if(!"".equals(ipadress1) && !"".equals(ipadress2) ){
					  criteria.add(Expression.and(Expression.ge("ipAddress",ipadress1),Expression.le("ipAddress",ipadress2)));
					}
					if(DTO.getIpStatusId()!= null){
						criteria.add(Restrictions.eq("ipStatusId", DTO.getIpStatusId()));
					}
					if(!"".equals(DTO.getHostName())){
						criteria.add(Restrictions.ilike("hostName", DTO.getHostName()));
					}
					if(DTO.getLocationId()!= null){
						criteria.add(Restrictions.eq("locationId", DTO.getLocationId()));
					}
					if(DTO.getNetworkZoneId()!= null){
						criteria.add(Restrictions.eq("networkZoneId", DTO.getNetworkZoneId()));
					}
					if(DTO.getNetworkType()!= null){
						criteria.add(Restrictions.eq("networkType", DTO.getNetworkType()));
					}
					if(DTO.getReqestFromTeamId()!= null){
						criteria.add(Restrictions.eq("reqestFromTeamId", DTO.getReqestFromTeamId()));
					}
					if(!"".equals(DTO.getUrRefer())){
						criteria.add(Restrictions.ilike("urRefer", DTO.getUrRefer()));
					}
					if(!"".equals(DTO.getProjectId())){
						criteria.add(Restrictions.eq("projectId", DTO.getProjectId()));
					}
					if(DTO.getProjectManager()!= null){
						criteria.add(Restrictions.eq("projectManager", DTO.getProjectManager()));
					}
					if(!"".equals(DTO.getEffDateFrom()) && !"".equals(DTO.getEffDateTo())){
						criteria.add(Expression.and(Expression.ge("effDate",DTO.getEffDateFrom()),Expression.le("effDate",DTO.getEffDateTo())));
					}
					if(!"".equals(DTO.getExpDateFrom()) && !"".equals(DTO.getExpDateTo())){
						criteria.add(Expression.and(Expression.ge("expDate",DTO.getExpDateFrom()),Expression.le("expDate",DTO.getExpDateTo())));
					}
					if(DTO.getTier1TeamId()!=null || DTO.getTier2TeamId()!= null){
						criteria.add(Expression.or(Expression.eq("tier1TeamId", DTO.getTier1TeamId()),Expression.eq("tier2TeamId", DTO.getTier2TeamId())));
						/* criteria.add(Restrictions.eq("tier3TeamId", DTO.getTier3TeamId()));*/
					}
					
		criteria.setProjection(Projections.rowCount());
		return ((Integer)criteria.list().get(0)).intValue();
	}
	
	
	@Override
	public IPDetail searchIPDetail(IPDetailVO DTO)throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IPDetail.class);
		
		//criteria.add(Restrictions.eq("tier3Id",""));
		criteria.add(Restrictions.eq("ipAddress", DTO.getIpAddress()));
		criteria.add(Expression.or(Expression.eq("tier1TeamId",DTO.getTier1TeamId()), 
				     Expression.eq("tier2TeamId",DTO.getTier2TeamId())));


		return (IPDetail)criteria.uniqueResult();
	}





}
