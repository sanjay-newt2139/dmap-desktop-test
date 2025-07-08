package th.co.ais.ipfm.dao;


import java.math.BigDecimal;
import java.util.List;

import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentDto;



public interface IPSubUrAttachmentDao extends IGenericDao<IpSubUrAttachment, Long>{
	public BigDecimal getSeqNo(String urNo, String catagory);
	public IpSubUrAttachment findByFileName(String urNo,String fileName,String catagory);
	public List<IpSubUrAttachment> findByUrNo(String urNo);
	public List<IpSubUrAttachment> getIpUrAttachmentList(String urNo);
	public void  deleteIpUrAttachment(String urNo,String fileName, String catagory);	
	public String findSubUrByUrNoAndSeq(String urNo,String seq);
	public IpSubUrAttachment findAttachmentSubUr(String urNo,String filename,String catagory);
	public List<IpSubUrAttachment> getIpUrAttachment(String urNo,String subUrNo,String status,String createBy);
	public void  deleteIpUrAttachmentSubmit(String urNo,String subUrNo,String status,String createBy);	
	public List<IpSubUrAttachmentDto> getByUrNo(String urNo);
}
