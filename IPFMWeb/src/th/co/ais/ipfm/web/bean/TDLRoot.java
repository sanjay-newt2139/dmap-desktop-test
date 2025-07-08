package th.co.ais.ipfm.web.bean;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.richfaces.model.TreeNode;

public class TDLRoot implements TreeNode {
	private long id;
	private Map tdlTypes = new LinkedHashMap();
	private String title;
	private String action;
	private String urType;	
	private int counter;
	private TDL tdl;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831863694596474846L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	public TDLRoot(long id, String title,String urType, String action, int counter) {
		this.id = id;
		this.title = title;
		this.urType = urType;
		this.action = action;
		this.counter = counter;
	}
	
	public TDLRoot(long id, String title, String action, int counter) {
		this.id = id;
		this.title = title;
		this.action = action;
		this.counter = counter;
	}
	
	public TDLRoot(long id) {
		this.id = id;
	}

	public void addTDLType(TDLType tdlType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference addTDLType
		addChild(Long.toString(tdlType.getId()), tdlType);
		tdlType.setParent(this);
	}
	
	public void addChild(Object identifier, TreeNode child) {
		tdlTypes.put(identifier, child);
	}

	public TreeNode getChild(Object id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChild
		return (TreeNode) tdlTypes.get(id);
	}

	public Iterator getChildren() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getChildren
		return tdlTypes.entrySet().iterator();
	}

	public Object getData() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getData
		return this;
	}

	public TreeNode getParent() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParent
		return tdl;
	}

	public boolean isLeaf() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isLeaf
		return tdlTypes.isEmpty();
	}

	public void removeChild(Object id) { // DMAP Comment : Dead Code Detected - The Following Method has no reference removeChild
		tdlTypes.remove(id);
	}

	public void setData(Object data) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setData
	}

	public void setParent(TreeNode parent) {
		tdl = (TDL) parent;
	}

	public long getId() {
		return id;
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

	public TDL getTdl() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTdl
		return tdl;
	}

	public void setTdl(TDL tdl) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTdl
		this.tdl = tdl;
	}

	public String getType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getType
		return "tdlRoot";
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
