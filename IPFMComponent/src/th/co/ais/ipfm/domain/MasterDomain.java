package th.co.ais.ipfm.domain;

import java.io.Serializable;
import java.util.Date;


public abstract class MasterDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	//default value//
	protected String createdBy; // DMAP Comment : Dead Code Detected - The Following Field has no reference createdBy
	protected Date created; // DMAP Comment : Dead Code Detected - The Following Field has no reference created
	protected String lastUpdBy; // DMAP Comment : Dead Code Detected - The Following Field has no reference lastUpdBy
	protected Date lastUpd; // DMAP Comment : Dead Code Detected - The Following Field has no reference lastUpd
	
	public abstract String getCreatedBy();
	public abstract void setCreatedBy(String createdBy);
	public abstract Date getCreated();
	public abstract void setCreated(Date created);
	public abstract String getLastUpdBy();
	public abstract void setLastUpdBy(String lastUpdBy);
	public abstract Date getLastUpd();
	public abstract void setLastUpd(Date lastUpd);
	
}
