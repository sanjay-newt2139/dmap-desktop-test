package th.co.ais.ipfm.service;

import java.math.BigDecimal;
import java.util.List;

import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentDto;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IpSubUrAttachmentService {
	public BigDecimal getSeqNo(String urNo, String subUrNo, String catagory) throws Exception;
	public IpSubUrAttachment findByFileName(String urNo,String fileName,String catagory) throws Exception;
	public List<IpSubUrAttachment> findByUrNo(String urNo) throws Exception;
	public List<IpSubUrAttachment> getIpUrAttachmentList(String urNo) throws Exception;
	public void  deleteIpUrAttachment(String urNo,String fileName, String catagory) throws Exception;
	public String findSubUrByUrNoAndSeq(String urNo,String seq) throws Exception;
	
	public IpSubUrAttachment findAttachmentSubUr(String urNo,String filename,String catagory);
	public void deleteSubAttachmentFile(IpSubUrAttachment attachFile)throws IPFMBusinessException;
	public void saveAttachFile(IpSubUrAttachment attach);
	public List<IpSubUrAttachmentDto> getByUrNo(String urNo);
}
