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
	private static final long serialVersionUID = 6831863694596474846L;

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

	public void addTDLType(TDLType tdlType) {
		addChild(Long.toString(tdlType.getId()), tdlType);
		tdlType.setParent(this);
	}
	
	public void addChild(Object identifier, TreeNode child) {
		tdlTypes.put(identifier, child);
	}

	public TreeNode getChild(Object id) {
		return (TreeNode) tdlTypes.get(id);
	}

	public Iterator getChildren() {
		return tdlTypes.entrySet().iterator();
	}

	public Object getData() {
		return this;
	}

	public TreeNode getParent() {
		return tdl;
	}

	public boolean isLeaf() {
		return tdlTypes.isEmpty();
	}

	public void removeChild(Object id) {
		tdlTypes.remove(id);
	}

	public void setData(Object data) {
	}

	public void setParent(TreeNode parent) {
		tdl = (TDL) parent;
	}

	public long getId() {
		return id;
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

	public TDL getTdl() {
		return tdl;
	}

	public void setTdl(TDL tdl) {
		this.tdl = tdl;
	}

	public String getType() {
		return "tdlRoot";
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
