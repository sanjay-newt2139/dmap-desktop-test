package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain.Suggestion;
import th.co.ais.ipfm.domain1.IpFunction;
 
public interface IMainMenuDao extends IGenericDao<IpFunction, Long>{
	public List<IpFunction> listMenuByUserID(String userID) throws Exception;
//	public String findGroupByUser(String userID);
	public List<Suggestion> listProject();
	public List<IpFunction> findAllMenu();
	public IpFunction findMenuByRowId(Integer rowId);
	public List<IpFunction> findMenuLevel1ByUserId(String userId)throws Exception;
}
