package th.co.ais.ipfm.web.bean;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.richfaces.model.TreeNode;

public class TDLType implements TreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6514596192023597908L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
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
	
	public void addTDLStatus(TDLStatus tdlStatus) { // DMAP Comment : Dead Code Detected - The Following Method has no reference addTDLStatus
		addChild(Long.toString(tdlStatus.getId()), tdlStatus);
		tdlStatus.setParent(this);
	}
	public void addChild(Object identifier, TreeNode child) {
		tdlStatuses.put(identifier, child);
	}

	public TreeNode getChild(Object id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChild
		return (TreeNode) tdlStatuses.get(id);
	}

	public Iterator getChildren() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChildren
		return tdlStatuses.entrySet().iterator();
	}

	public Object getData() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getData
		return this;
	}

	public TreeNode getParent() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParent
		return tdlRoot;
	}

	public boolean isLeaf() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isLeaf
		return tdlStatuses.isEmpty();
	}

	public void removeChild(Object id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference removeChild
		tdlStatuses.remove(id);
	}

	public void setData(Object data) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setData
	}

	public void setParent(TreeNode parent) {
		this.tdlRoot = (TDLRoot) parent;
	}

	public String getTitle() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTitle
		return title;
	}

	public void setTitle(String title) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTitle
		this.title = title;
	}

	public int getCounter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getCounter
		return counter;
	}

	public void setCounter(int counter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setCounter
		this.counter = counter;
	}

	public long getId() {
		return id;
	}

	public TDLRoot getTdlRoot() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTdlRoot
		return tdlRoot;
	}

	public void setTdlRoot(TDLRoot tdlRoot) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTdlRoot
		this.tdlRoot = tdlRoot;
	}

	public String getType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getType
		return "tdlType";
	}

	public String getAction() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getAction
		return action;
	}

	public void setAction(String action) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setAction
		this.action = action;
	}

	public String getUrType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getUrType
		return urType;
	}

	public void setUrType(String urType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setUrType
		this.urType = urType;
	}

}
