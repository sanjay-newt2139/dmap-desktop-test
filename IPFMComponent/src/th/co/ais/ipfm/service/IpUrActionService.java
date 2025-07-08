package th.co.ais.ipfm.service;

import java.util.Date;
import java.util.List;

import th.co.ais.ipfm.domain1.IpEmailNotify;
import th.co.ais.ipfm.domain1.IpUrAction;
import th.co.ais.ipfm.domain1.IpUser;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IpUrActionService {
	public void saveEmailNotify(IpEmailNotify notify)  throws IPFMBusinessException ;
	public void updateEmailNotify(IpEmailNotify notify);
	public IpEmailNotify findByResponce(String urNo,String userId);
	public IpEmailNotify findByResponce(String emailCode);
	public boolean isSendEmail(String type,String id);
	public void deleteNotify(String urNo,String urStatus);
	public List<IpUrAction> listAction(String urNo, IpUser user, String mode);
	public List<IpUrAction> listAction(String urNo, String subUrNo);
	public Date getSLADate(Date reqDate,String urType,String pmTeam);
	public Date getOLADate(Date reqDate,String urType,String nodeId);
	public List<IpUrAction> getIpUrAction(String urNo);
}
