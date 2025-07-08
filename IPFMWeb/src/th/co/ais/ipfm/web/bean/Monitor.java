package th.co.ais.ipfm.web.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import th.co.ais.ipfm.domain.MenuCaption;
import th.co.ais.ipfm.domain.TreeMenu;
import th.co.ais.ipfm.service.TreeMenuService;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class Monitor extends TDL {
	
	private static final long serialVersionUID = -6150677742864628537L;
	 
	public Monitor() {
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
	
	private void initData() {
		tdlRoots = new HashMap();
		
		UserSession userSession = IPFMWebUtil.getUserSession();
		
		TreeMenuService treeService = (TreeMenuService)JSFServiceFinderUtil.getInstance().getBean("treeMenuService");
		ArrayList<TreeMenu> listMenu = treeService.getMornitorListByUser(userSession.getIpUser().getUserId());
		
		//temp For check pos and count
		ArrayList level2 = new ArrayList();
		Map<String,ArrayList> level4 = new HashMap<String, ArrayList>();
		
		for(TreeMenu menu : listMenu){
			int pos = level2.indexOf(menu.getLevel2());
			if(pos<0){
				level2.add(menu.getLevel2());
				ArrayList temp = new ArrayList();
				MenuCaption ms = new MenuCaption();
				ms.setCaption(menu.getLevel4());
				ms.setLinkURL(menu.getActionName());
				temp.add(ms);
				level4.put(menu.getLevel2(), temp);
			} else {
				ArrayList temp = level4.get(menu.getLevel2());
				MenuCaption ms = new MenuCaption();
				ms.setCaption(menu.getLevel4());
				ms.setLinkURL(menu.getActionName());
				temp.add(ms);
				level4.remove(menu.getLevel2());
				level4.put(menu.getLevel2(), temp);
			}
		}
		String title1 = "Mornitor List";
		if (listMenu.size()>0) title1 = listMenu.get(0).getLevel1();
		TDLRoot tdlRoot = new TDLRoot(getNextId(), title1, "" , "" , listMenu.size());
		this.addTDLRoot(tdlRoot);
		
		Iterator itr = level4.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry item = (Map.Entry)itr.next();
			String key = (String)item.getKey();
			ArrayList list = (ArrayList)item.getValue();
			System.out.println(key+" has "+list.size()+" items");
			//TDLType tdlType = new TDLType(getNextId(),key+" ("+list.size()+")", "", 10);
			//TDLType tdlType = new TDLType(getNextId(),key, "", 10);
			String urType = "";
			String actionCode = "";
			if (list!=null && list.size()>0) {
				urType=((MenuCaption)list.get(0)).getUrType();
				actionCode=((MenuCaption)list.get(0)).getAction();
			}
			TDLType tdlType = new TDLType(getNextId(),key, urType , actionCode , 10);
			tdlRoot.addTDLType(tdlType);
		}
		
//		Iterator itr = level4.entrySet().iterator();
//		while(itr.hasNext()){
//			Map.Entry item = (Map.Entry)itr.next();
//			String key = (String)item.getKey();
//			ArrayList list = (ArrayList)item.getValue();
//			System.out.println(key+" has "+list.size()+" items");
//			TDLType tdlType = new TDLType(getNextId(),key, "", 10);
//			tdlRoot.addTDLType(tdlType);
//		}
		expandAll = true;
	}
	

}
