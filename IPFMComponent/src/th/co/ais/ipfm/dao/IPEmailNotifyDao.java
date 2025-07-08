package th.co.ais.ipfm.dao;


import th.co.ais.ipfm.domain1.IpEmailNotify;



public interface IPEmailNotifyDao extends IGenericDao<IpEmailNotify, Long>{
	public IpEmailNotify findByResponce(String urNo,String userId);
	public IpEmailNotify findByResponce(String emailCode);
	public boolean isSendEmail(String type,String id);
	public void deleteNotibyByStatus(String urNo,String urStatus);
	public void deleteNotibyByUrNo(String urNo);
	public void deleteByUser(String urNo,String userId,String status);
	public void deleteByUser(String userId,String status);
	public IpEmailNotify findLastEmailNotifyByUserId(String userId);
}
