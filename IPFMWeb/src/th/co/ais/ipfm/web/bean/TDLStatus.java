package th.co.ais.ipfm.web.bean;

import java.util.ArrayList;
import java.util.Iterator;

import org.richfaces.model.TreeNode;

public class TDLStatus implements TreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7155620465939481885L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private long id;
	private String title;
	private String action;
	private String urType; 
	private int counter;
	private TDLType tdlType;

	public TDLStatus(long id, String title, String action,int counter) {
		this.id=id;
		this.title=title;
		this.action=action;
		this.counter=counter;
	}	
	public TDLStatus(long id, String title,String urType, String action,int counter) {
		this.id=id;
		this.title=title;
		this.urType=urType;
		this.action=action;
		this.counter=counter;
	}	
	
	public TDLStatus(long id) {
		this.id = id;
	}
	
	public void addChild(Object identifier, TreeNode child) { // DMAP Comment : Dead Code Detected - The Following Method has no reference addChild
		throw new UnsupportedOperationException("TDLStatus do not have children");
	}

	public TreeNode getChild(Object id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChild
		throw new UnsupportedOperationException("TDLStatus do not have children");
	}

	public Iterator getChildren() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChildren
		// TODO: Fix me!
		return new ArrayList().iterator(); // work around limitation for TreeNode
	}

	public Object getData() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getData
		return this;
	}

	public TreeNode getParent() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParent
		return tdlType;
	}

	public boolean isLeaf() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isLeaf
		return true;
	}

	public void removeChild(Object id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference removeChild
		throw new UnsupportedOperationException("TDLStatus do not have children");
	}

	public void setData(Object data) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setData
	}

	public void setParent(TreeNode parent) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParent
		this.tdlType = (TDLType) parent;
	}

	public TDLType getTdlType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTdlType
		return tdlType;
	}

	public void setTdlType(TDLType tdlType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTdlType
		this.tdlType = tdlType;
	}

	public String getAction() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAction
		return action;
	}

	public void setAction(String action) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAction
		this.action = action;
	}

	public int getCounter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCounter
		return counter;
	}

	public void setCounter(int counter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCounter
		this.counter = counter;
	}

	public String getTitle() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle
		return title;
	}

	public void setTitle(String title) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle
		this.title = title;
	}

	public long getId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getId
		return id;
	}
	public String getType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getType
		return "tdlStatus";
	}

	public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
		return urType;
	}
	public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
		this.urType = urType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + counter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TDLStatus other = (TDLStatus) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (counter != other.counter)
			return false;
		return true;
	}

}
