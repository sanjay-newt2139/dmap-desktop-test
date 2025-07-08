package th.co.ais.ipfm.service;

import th.co.ais.ipfm.domain1.IpFunction;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.vo.UserVO;

public interface ILoginService {
	
	public IpUser getIPUser(String userId) throws IPFMBusinessException;
	public IpUser addUser(IpUser ipUser) throws IPFMBusinessException;
	public IpUser updateUser(IpUser ipUser) throws IPFMBusinessException;
	public String getSysdate() throws IPFMBusinessException;
	public boolean checkInLdap(String userName, String password)throws IPFMBusinessException;
	public UserVO login(String userName, String password) throws IPFMBusinessException;
	public String getNews() throws IPFMBusinessException;
	public IpFunction getIpFunction(String funcId) throws IPFMBusinessException;
	public IpUser getEhrByUserId(String userId) throws IPFMBusinessException;
	public void addIpRoleMemberByUser(IpUser ipUser) throws IPFMBusinessException;
	public void updateSessionId(String userId, String sessionId) throws IPFMBusinessException;
	public IpUser findUserBySessionId(String userId, String sessionId) throws IPFMBusinessException;
	public void checkNewUser(String userId) throws IPFMBusinessException;
}
