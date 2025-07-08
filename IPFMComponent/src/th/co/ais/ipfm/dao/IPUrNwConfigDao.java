package th.co.ais.ipfm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPRole;
import th.co.ais.ipfm.domain1.IpRoleMember;
import th.co.ais.ipfm.domain1.IpUrNwConfig;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.domain1.IpvJobAssign;

public interface IPUrNwConfigDao extends IGenericDao<IpUrNwConfig, Long>{
	public String getTempURNo() throws DataAccessException;
	public String getURNo() throws DataAccessException;
	public IpUrNwConfig findByUrNo(String urNo)throws DataAccessException;
	public List<Map> listManager(IpUser user);
	public IpvJobAssign getJobAssign(String urNo,String subUrNo);
	public List<IpvJobAssign> getJobAssignDetail(String urNo,String subUrNo);
	public List<IpRoleMember> finByRoleId(String roleId);
	public Map<String,String> getIpOwner(String ip);
	
	public List<IpRoleMember> listPersonAssign(String teamId);
	public boolean isJobComplete(String urNo,String subUrNo);
	public IPRole getRoleData(String roleId);
	
	public IpRoleMember getRoleMemberData(String roleId,String userId);
	
}


