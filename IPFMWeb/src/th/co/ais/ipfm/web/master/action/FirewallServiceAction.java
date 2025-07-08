package th.co.ais.ipfm.web.master.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.web.master.bean.MasterTableBean;
import th.co.ais.ipfm.web.util.IPFMRichComboItem;

public class FirewallServiceAction extends MasterTableAction {
	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}
	
	private List<String> getRefTableList(){
	List<String> refTableList = new ArrayList<String>();
	refTableList.add("SERVICE");
	return refTableList;
}

	@Override
	public String init(String programID) {
//		CommonService commonService = (CommonService)JSFServiceFinderUtil.getInstance().getBean("commonService");
		if(commonService!=null){
			try {
				List<SelectItem> refTableList = new ArrayList<SelectItem>();
//				List<String> refTableStringList = commonService.getMasterRefTableList();
				List<String> refTableStringList = getRefTableList();
				if(refTableStringList!=null && refTableStringList.size()>0){
					for (String str:refTableStringList) {
					    IPFMRichComboItem cbitem = new IPFMRichComboItem();
					    cbitem.setLabel(str);
					    cbitem.setValue(str);
						refTableList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}		

				List<SelectItem> subGroupList = new ArrayList<SelectItem>();
				MasterTableBean	masterTableBean = new MasterTableBean();
				masterTableBean.setMasterTBL(new  IpMasterTable());
				masterTableBean.setRefTableList(refTableList);
				masterTableBean.setRefKeyList(subGroupList);
				masterTableBean.setDisplayForCreate(false);
				masterTableBean.setDisplayForEdit(false);
				masterTableBean.setDisplayOther(false);
				masterTableBean.setDisplayHolidays(false);
				masterTableBean.setDisplayNews(false);
				masterTableBean.setDisplayService(false);
				masterTableBean.setRefKeyComboItem((IPFMRichComboItem)refTableList.get(0).getValue());
				
				List<IpMasterTable> refKeyList = commonService.findMasterTableByRefKey(masterTableBean.getRefKeyComboItem().getValue());
				masterTableBean.setMasterTBLList(refKeyList);
				masterTableBean.setMasterTBL(new IpMasterTable());
				
				if(masterTableBean.getRefKeyComboItem().getValue().equals("SERVICE")){
					masterTableBean.setDisplayService(true);
					masterTableBean.setDisplayOther(false);
					masterTableBean.setDisplayHolidays(false);
					masterTableBean.setDisplayNews(false);
					masterTableBean.setDisplayLogo(false);
					masterTableBean.setDisabledForEdit(false);
					masterTableBean.setDisplayForCreate(true);
					masterTableBean.setDisplayForEdit(false);
				}
				
				setMasterTableBean(masterTableBean);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	 return programID;
	}
}
