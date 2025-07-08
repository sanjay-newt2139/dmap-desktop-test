package th.co.ais.ipfm.dao;


import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain.IPParameter;
import th.co.ais.ipfm.domain1.IpUrIpDetail;
import th.co.ais.ipfm.domain1.IpUser;


public interface IPUrIPDetailDao extends IGenericDao<IpUrIpDetail, Long>{

	public String getURNo() throws DataAccessException;
	public String getTempURNo() throws DataAccessException;
	public IpUrIpDetail getIPUrIpDetail(String urNo) throws DataAccessException;
	public int countSearchUR(IpUrIpDetail ipUrIpDetail) throws DataAccessException;
	public List<IpUrIpDetail> searchUR(IpUrIpDetail ipUrIpDetail,IpUser ipUser) throws DataAccessException;
	public List<IpUrIpDetail> searchUR(IpUrIpDetail ipUrIpDetail,String subUrPack,IpUser ipUser) throws DataAccessException;
}
