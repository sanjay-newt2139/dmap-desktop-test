package th.co.ais.ipfm.web.bean;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.richfaces.model.TreeNode;

public class TDLType implements TreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6514596192023597908L;
	private long id;
	private Map tdlStatuses = new LinkedHashMap();
	private String title;
	private String urType;
	private String action;	
	private int counter; 
	private TDLRoot tdlRoot;

	public TDLType(long id, String title, String action, int counter) {
		this.id = id;
		this.title = title;
		this.action = action;
		this.counter = counter;
	}
	
	public TDLType(long id, String title,String urType, String action, int counter) {
		this.id = id;
		this.title = title;
		this.urType = urType;
		this.action = action;
		this.counter = counter;
	}
	
	public TDLType(long id) {
		this.id = id;
	}
	
	public void addTDLStatus(TDLStatus tdlStatus) {
		addChild(Long.toString(tdlStatus.getId()), tdlStatus);
		tdlStatus.setParent(this);
	}
	public void addChild(Object identifier, TreeNode child) {
		tdlStatuses.put(identifier, child);
	}

	public TreeNode getChild(Object id) {
		return (TreeNode) tdlStatuses.get(id);
	}

	public Iterator getChildren() {
		return tdlStatuses.entrySet().iterator();
	}

	public Object getData() {
		return this;
	}

	public TreeNode getParent() {
		return tdlRoot;
	}

	public boolean isLeaf() {
		return tdlStatuses.isEmpty();
	}

	public void removeChild(Object id) {
		tdlStatuses.remove(id);
	}

	public void setData(Object data) {
	}

	public void setParent(TreeNode parent) {
		this.tdlRoot = (TDLRoot) parent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public long getId() {
		return id;
	}

	public TDLRoot getTdlRoot() {
		return tdlRoot;
	}

	public void setTdlRoot(TDLRoot tdlRoot) {
		this.tdlRoot = tdlRoot;
	}

	public String getType() {
		return "tdlType";
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrType() {
		return urType;
	}

	public void setUrType(String urType) {
		this.urType = urType;
	}

}
