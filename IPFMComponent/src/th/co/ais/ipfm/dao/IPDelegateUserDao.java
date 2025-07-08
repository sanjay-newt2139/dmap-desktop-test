package th.co.ais.ipfm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpDelegateUser;
import th.co.ais.ipfm.domain1.IpUser;


public interface IPDelegateUserDao extends IGenericDao<IpDelegateUser, Long> {

	public List<IpDelegateUser> getDelegateDataList(String userId) throws DataAccessException;
	public String  getCheckExistingData(IpDelegateUser ipDelegateUser,IpUser ipUser) throws DataAccessException;
	public List<IpDelegateUser> deleteDelegate(String delegateUserId,String userId)throws DataAccessException;
	public List<IpDelegateUser> getDelegateAdminList(String userId) throws DataAccessException;
	public void updateDelegate(IpDelegateUser ipDelegateUser,IpUser ipUser) throws DataAccessException;
}
