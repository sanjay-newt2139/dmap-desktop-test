package th.co.ais.ipfm.web.manage.bean;

import java.io.Serializable;
import java.util.List;

import th.co.ais.ipfm.domain1.IpUrAttachment;

public class AttachFileBean implements Serializable{
	
	private List<IpUrAttachment> listAttach;

	public List<IpUrAttachment> getListAttach() {
		return listAttach;
	}

	public void setListAttach(List<IpUrAttachment> listAttach) {
		this.listAttach = listAttach;
	}
	
	

}
