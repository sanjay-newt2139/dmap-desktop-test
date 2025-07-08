package th.co.ais.ipfm.service;

import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.exception.IPFMBusinessException;

public interface IpUrAttachmentService {
	public void saveAttachFile(IpUrAttachment attach);
	public IpUrAttachment findAttachment(String urNo,String filename,String catagory);
	public void deleteAttachmentFile(IpUrAttachment attachFile)throws IPFMBusinessException;
	public void updateAttachFileName(String tempUrNo,String urNo)throws IPFMBusinessException;
	public void updateAttachFileNameByCategory(String tempUrNo,String urNo)throws IPFMBusinessException;
	public void attachFile(IpUrAttachment ipUrAttachment) throws IPFMBusinessException;
	public List<IpUrAttachment> listFilesByUrNo(String urNo);
	public IpUrAttachment findAttatchment(String urNo,String seq);
	public List<IpUrAttachment> listFilesByCategory(String urNo, String category);
	public void updateAttachFile(String tempUrNo,String urNo,String updateBy);
	public void updateAttachFileByCategory(String tempUrNo,String urNo,String updateBy) throws IPFMBusinessException;
}
