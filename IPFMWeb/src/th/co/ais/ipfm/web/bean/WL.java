package th.co.ais.ipfm.web.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import th.co.ais.ipfm.domain.MenuCaption;
import th.co.ais.ipfm.domain.TreeMenu;
import th.co.ais.ipfm.service.TreeMenuService;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class WL extends TDL {
	
	private static final long serialVersionUID = -6150677742864628537L;
	
	public WL() {
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
		ArrayList<TreeMenu> listMenu = treeService.getWatchListByUser(userSession.getIpUser().getUserId());
		
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
		String title1 = "Watch List";
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
//			for(int i=0;i<list.size();i++){
//				MenuCaption ms = (MenuCaption)list.get(i);
//				TDLStatus tdlStatus = new TDLStatus(getNextId(),ms.getCaption(),ms.getLinkURL(),5);
//				tdlType.addTDLStatus(tdlStatus);
//			}
		}
		
/*		
		TDLRoot tdlRoot = new TDLRoot(getNextId(),"Watch List (10)", "", 20);
		this.addTDLRoot(tdlRoot);
		TDLType tdlType = new TDLType(getNextId(),"IP Request (xx)", "", 10);
		tdlRoot.addTDLType(tdlType);
		TDLStatus tdlStatus = new TDLStatus(getNextId(),"wait 2 (5)","th.co.ais.ipfm.web.master.action.SystemParameterAction",5);
		tdlType.addTDLStatus(tdlStatus);
		TDLType tdlType2 = new TDLType(getNextId(),"N/W Request (10)", "", 10);
		tdlRoot.addTDLType(tdlType2);
		TDLStatus tdlStatus4 = new TDLStatus(getNextId(),"wait4 (10)","th.co.ais.ipfm.web.master.action.WorkFlowManageAction",5);
		tdlType2.addTDLStatus(tdlStatus4);
*/		
		expandAll = true;
	}
	

}
