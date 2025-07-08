package th.co.ais.ipfm.web.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.richfaces.component.UITree;
import org.richfaces.model.TreeNode;

import th.co.ais.ipfm.domain.MenuCaption;
import th.co.ais.ipfm.domain.TreeMenu;
import th.co.ais.ipfm.service.TreeMenuService;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class TDL implements TreeNode {
	/**
	 *
	 */
	private static final long serialVersionUID = -3530085227471752526L;
	protected Map tdlRoots = null;
	protected Object state1;
	protected Object state2;
	protected List<TDLStatus> tdlStatusList;
	protected Set<TDLStatus> selectedTdlStatusSet = new HashSet<TDLStatus>();
	protected List<TDLStatus> selectedTdlStatusList = new ArrayList<TDLStatus>(); 

	public TDL() {
		//initData();
		tdlStatusList = new ArrayList<TDLStatus>();
		tdlStatusList.addAll(getTDLAsList());
	}	
	
	public Map getTdlRoots() {
		if (this.tdlRoots==null) {
			initData();
		}
		return this.tdlRoots;
	}

	public void setTdlRoots(Map tdlRoots) {
		this.tdlRoots = tdlRoots;
	}

	public void addTDLRoot(TDLRoot tdlRoot) {
		addChild(Long.toString(tdlRoot.getId()), tdlRoot);
	}
	
	public void addChild(Object identifier, TreeNode child) {
		getTdlRoots().put(identifier, child);
		child.setParent(this);
	}

	public TreeNode getChild(Object id) {
		return (TreeNode) getTdlRoots().get(id);
	}

	public Iterator getChildren() {
		return getTdlRoots().entrySet().iterator();
	}

	public Object getData() {
		//initData();
		return this;
	}

	public TreeNode getParent() {
		return null;
	}

	public boolean isLeaf() {
		return getTdlRoots().isEmpty();
	}

	public void removeChild(Object id) {
		getTdlRoots().remove(id);
	}

	public void setData(Object data) {
	}

	public void setParent(TreeNode parent) {
	}

	public String getType() {
		return "tdl";
	}
	
	
	protected long nextId = 0;
	protected long getNextId() {
		return nextId++;
	}
	
	private void initData() {
		tdlRoots = new HashMap();
		UserSession userSession = IPFMWebUtil.getUserSession();
		
		TreeMenuService treeService = (TreeMenuService)JSFServiceFinderUtil.getInstance().getBean("treeMenuService");
		ArrayList<TreeMenu> listMenu = treeService.getToDoListByUser(userSession.getIpUser().getUserId());
		
		//temp For check pos and count
		ArrayList level2 = new ArrayList();
		Map<String,ArrayList> level4 = new LinkedHashMap<String, ArrayList>();
		
		for(TreeMenu menu : listMenu){
			int pos = level2.indexOf(menu.getLevel2());
			if(pos<0){
				level2.add(menu.getLevel2());
				ArrayList temp = new ArrayList();
				MenuCaption ms = new MenuCaption();
				ms.setCaption(menu.getLevel4());
				ms.setLinkURL(menu.getActionName());
				ms.setAction(menu.getActionCode());
				ms.setUrType(menu.getUrType());
				temp.add(ms);
				level4.put(menu.getLevel2(), temp);
			} else {
				ArrayList temp = level4.get(menu.getLevel2());
				MenuCaption ms = new MenuCaption();
				ms.setCaption(menu.getLevel4());
				ms.setLinkURL(menu.getActionName());
				ms.setAction(menu.getActionCode());
				ms.setUrType(menu.getUrType());
				temp.add(ms);
				level4.remove(menu.getLevel2());
				level4.put(menu.getLevel2(), temp);
			}
		}
		String title1 = "To Do List";
		int counter = 0;
		if (listMenu.size()>0) title1 = listMenu.get(0).getLevel1();
		TDLRoot tdlRoot = new TDLRoot(getNextId(), title1, "" , "" , listMenu.size());
		this.addTDLRoot(tdlRoot);
		
		Iterator itr = level4.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry item = (Map.Entry)itr.next();
			String key = (String)item.getKey();
			ArrayList list = (ArrayList)item.getValue();
//			System.out.println(key+" has "+list.size()+" items");
			//TDLType tdlType = new TDLType(getNextId(),key+" ("+list.size()+")", "", 10);
			String urType = "";
			String actionCode = "";
			if (list!=null && list.size()>0) {
				urType=((MenuCaption)list.get(0)).getUrType();
				actionCode=((MenuCaption)list.get(0)).getAction();
			}
			TDLType tdlType = new TDLType(getNextId(),key, urType , actionCode , 10);
			tdlRoot.addTDLType(tdlType);
			for(int i=0;i<list.size();i++){
				MenuCaption ms = (MenuCaption)list.get(i);
				TDLStatus tdlStatus = new TDLStatus(getNextId(),ms.getCaption(),ms.getUrType(),ms.getAction(),5);
				tdlType.addTDLStatus(tdlStatus);
			}
		}
		
/*
		TDLRoot tdlRoot = new TDLRoot(getNextId(),"TO Do List ("+level2.size()+")", "", 20);
		this.addTDLRoot(tdlRoot);
		TDLType tdlType = new TDLType(getNextId(),"IP Request (xx)", "", 10);
		tdlRoot.addTDLType(tdlType);
		TDLStatus tdlStatus = new TDLStatus(getNextId(),String.valueOf((new Date()).getTime()),"th.co.ais.ipfm.web.master.action.SystemParameterAction",5);
		tdlType.addTDLStatus(tdlStatus);
		TDLType tdlType2 = new TDLType(getNextId(),"N/W Request (10)", "", 10);
		tdlRoot.addTDLType(tdlType2);
		TDLStatus tdlStatus4 = new TDLStatus(getNextId(),"wait4 (10)","th.co.ais.ipfm.web.master.action.WorkFlowManageAction",5);
		tdlType2.addTDLStatus(tdlStatus4);
*/		
		expandAll = true;
	}
	
	public boolean isExpandAll() {
		return expandAll;
	}

	public void setExpandAll(boolean expandAll) {
		this.expandAll = expandAll;
	}


	protected boolean expandAll = false;

	public Boolean nodeOpened(UITree tree) {
		 if (expandAll) {
			 return Boolean.TRUE;
		 }
		 	return null;
	}
	
	public Object getState1() {
		return state1;
	}
	
	public void setState1(Object state1) {
		this.state1 = state1;
	}
	
	public Object getState2() {
		return state2;
	}
	
	public void setState2(Object state2) {
		this.state2 = state2;
	}
	
	public void walk(TreeNode node, List<TreeNode> appendTo, Class<? extends TreeNode> type) {
		if (type.isInstance(node)){
			appendTo.add(node);
		}
		Iterator<Map.Entry<Object, TreeNode>> iterator = node.getChildren();
		while(iterator.hasNext()) {
			walk(iterator.next().getValue(), appendTo, type);
		}
		
	}
	
	public ArrayList getTDLAsList(){
		ArrayList appendTo = new ArrayList();
		walk(this, appendTo, TDLStatus.class);
		return appendTo;
	}
	
	public List<TDLStatus> getTdlStatusList() {
		return tdlStatusList;
	}

	public void setTdlStatusList(List<TDLStatus> tdlStatusList) {
		this.tdlStatusList = tdlStatusList;
	}

	public void takeSelection() {
		selectedTdlStatusList.clear();
		selectedTdlStatusList.addAll(selectedTdlStatusSet);
	}

	public Set<TDLStatus> getSelectedTdlStatusSet() {
		return selectedTdlStatusSet;
	}

	public void setSelectedTdlStatusSet(Set<TDLStatus> selectedTdlStatusSet) {
		this.selectedTdlStatusSet = selectedTdlStatusSet;
	}

	public List<TDLStatus> getSelectedTdlStatusList() {
		return selectedTdlStatusList;
	}

	public void setSelectedTdlStatusList(List<TDLStatus> selectedTdlStatusList) {
		this.selectedTdlStatusList = selectedTdlStatusList;
	}
	


}
