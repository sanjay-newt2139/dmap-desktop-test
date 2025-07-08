package th.co.ais.ipfm.service;

import java.util.List;
import java.util.Map;

import th.co.ais.ipfm.domain.Suggestion;
import th.co.ais.ipfm.domain1.IpFunction;

public interface MainMenuService {
	public Map listMenuByUserID(String userID) throws Exception;
	public List<Suggestion> listProject();
	public List<IpFunction> findAllMenu();
	public IpFunction findMenuByRowId(Integer rowId);
	public List<IpFunction> findMenuLevel1ByUserId(String userId)  throws Exception;;
}
 