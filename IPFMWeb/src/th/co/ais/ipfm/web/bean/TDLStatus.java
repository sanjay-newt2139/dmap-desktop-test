package th.co.ais.ipfm.web.bean;

import java.util.ArrayList;
import java.util.Iterator;

import org.richfaces.model.TreeNode;

public class TDLStatus implements TreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7155620465939481885L;
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
	
	public void addChild(Object identifier, TreeNode child) {
		throw new UnsupportedOperationException("TDLStatus do not have children");
	}

	public TreeNode getChild(Object id) {
		throw new UnsupportedOperationException("TDLStatus do not have children");
	}

	public Iterator getChildren() {
		// TODO: Fix me!
		return new ArrayList().iterator(); // work around limitation for TreeNode
	}

	public Object getData() {
		return this;
	}

	public TreeNode getParent() {
		return tdlType;
	}

	public boolean isLeaf() {
		return true;
	}

	public void removeChild(Object id) {
		throw new UnsupportedOperationException("TDLStatus do not have children");
	}

	public void setData(Object data) {
	}

	public void setParent(TreeNode parent) {
		this.tdlType = (TDLType) parent;
	}

	public TDLType getTdlType() {
		return tdlType;
	}

	public void setTdlType(TDLType tdlType) {
		this.tdlType = tdlType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}
	public String getType() {
		return "tdlStatus";
	}

	public String getUrType() {
		return urType;
	}
	public void setUrType(String urType) {
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
