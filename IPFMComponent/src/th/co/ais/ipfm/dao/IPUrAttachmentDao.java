package th.co.ais.ipfm.dao;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.ipfm.domain1.IpUrAttachment;



public interface IPUrAttachmentDao extends IGenericDao<IpUrAttachment, Long>{
	public BigDecimal getSeqNo(String urNo);
	public IpUrAttachment findByFileName(String urNo,String filename,String catagory);
	public List<IpUrAttachment> findByUrNo(String urNo);
	public List<IpUrAttachment> getIpUrAttachmentList(String urNo) throws DataAccessException;
	public List<IpUrAttachment> getIpUrAttachmentList(String urNo,String category) throws DataAccessException;
	public void  updateIpUrAttachment(String urNo ,String tempUrNo) throws DataAccessException;
	public void  deleteIpUrAttachment(String urNo) throws DataAccessException;
	public IpUrAttachment findByUrNoSeq(String urNo,BigDecimal seq );
	public List<IpUrAttachment> findByCategory(String urNo, String category) throws DataAccessException;
	
}
