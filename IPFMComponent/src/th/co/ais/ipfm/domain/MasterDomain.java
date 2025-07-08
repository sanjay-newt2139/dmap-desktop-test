package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.Date;


public abstract class MasterDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//default value//
	protected String createdBy;
	protected Date created;
	protected String lastUpdBy;
	protected Date lastUpd;
	
	public abstract String getCreatedBy();
	public abstract void setCreatedBy(String createdBy);
	public abstract Date getCreated();
	public abstract void setCreated(Date created);
	public abstract String getLastUpdBy();
	public abstract void setLastUpdBy(String lastUpdBy);
	public abstract Date getLastUpd();
	public abstract void setLastUpd(Date lastUpd);
	
}
