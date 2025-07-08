package th.co.ais.ipfm.dao;

import java.util.List;

import th.co.ais.ipfm.domain.NCAssign;
import th.co.ais.ipfm.domain.NCData;
import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpUrFirewallId;
import th.co.ais.ipfm.domain1.IpUrStatus;

public interface IIPStatusDAO  extends IGenericDao<IpUrStatus, Long>{
	public IpUrStatus getSubStatus(String urType,String subUrStatus);
	public IpUrStatus getStatus(String urType,String urStatus);

}
