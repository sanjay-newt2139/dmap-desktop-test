package th.co.ais.ipfm.web.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.ipfm.domain1.IpMasterTable;
import th.co.ais.ipfm.service.CommonService;
import th.co.ais.ipfm.util.IPFMConstant;

public class IPFMComboBoxUtil {
	private Logger log = Logger.getLogger(getClass());
	private static IPFMComboBoxUtil instance = null;
	private HashMap componentMap = null;
	
	private IPFMComboBoxUtil(){

	}
	
	public static synchronized IPFMComboBoxUtil getInstance() {
        if (instance == null) {
            instance = new IPFMComboBoxUtil();
        }
        return instance;
    }
	
	public static void reloadComponent(){
		instance = null;
	}
	
	public void loadComponent(){
		CommonService service = null;
		try{
			service = (CommonService) JSFServiceFinderUtil.getInstance().getBean("commonService");
			componentMap = service.getAllMasterList();
			
		}catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.loadComponent : "+e);
			e.printStackTrace();
		}finally{
			service = null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getLocationComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_LOCAT) && componentMap.get(IPFMConstant.MCODE_LOCAT)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_LOCAT)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_LOCAT))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getLocation : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getDataCenterComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_DATA_CEN) && componentMap.get(IPFMConstant.MCODE_DATA_CEN)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_DATA_CEN)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_DATA_CEN))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getDataCenter : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getOfficeUserComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_OFF_USER) && componentMap.get(IPFMConstant.MCODE_OFF_USER)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_OFF_USER)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_OFF_USER))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getOfficeUser : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getNWTypeComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_NWTYPE) && componentMap.get(IPFMConstant.MCODE_NWTYPE)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_NWTYPE)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_NWTYPE))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getNWType : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getTier2TeamComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_TIER2TEAM) && componentMap.get(IPFMConstant.MCODE_TIER2TEAM)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_TIER2TEAM)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_TIER2TEAM))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getId().getRefKey());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getTier2Team : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getZoneComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_ZONE) && componentMap.get(IPFMConstant.MCODE_ZONE)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_ZONE)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_ZONE))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getZone : "+e);
		}
		return returnList;
	}	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getIPStatusComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPSTS) && componentMap.get(IPFMConstant.MCODE_IPSTS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPSTS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPSTS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPStatus : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCompanyComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_COMPANY) && componentMap.get(IPFMConstant.MCODE_COMPANY)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_COMPANY)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_COMPANY))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getCompany : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getPriorityComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_PRIORITY) && componentMap.get(IPFMConstant.MCODE_PRIORITY)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_PRIORITY)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_PRIORITY))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getPriority: "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getInstallTypeComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_INSTALLTYPE) && componentMap.get(IPFMConstant.MCODE_INSTALLTYPE)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_INSTALLTYPE)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_INSTALLTYPE))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getInstallType: "+e);
		}
		return returnList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getIPTypeListComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPTYPELIST) && componentMap.get(IPFMConstant.MCODE_IPTYPELIST)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPTYPELIST)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPTYPELIST))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPTypeList: "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getIPClassComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setLabel(str.getShortDesc());
						cbitem.setValue(str.getId().getRefKey());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}
	@SuppressWarnings("unchecked")
	public List<SelectItem> getIPClassComboBoxItemsShort(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setValue(str.getId().getRefKey());
						cbitem.setLabel(str.getShortDesc());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getRequestFromTeamComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setValue(str.getId().getRefKey());
						cbitem.setLabel(str.getShortDesc());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getProjectIdComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setValue(str.getId().getRefKey());
						cbitem.setLabel(str.getShortDesc());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getProjectManagerComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setValue(str.getId().getRefKey());
						cbitem.setLabel(str.getShortDesc());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getSystemOwnerComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setValue(str.getId().getRefKey());
						cbitem.setLabel(str.getShortDesc());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}
	@SuppressWarnings("unchecked")
	public List<SelectItem> getSystemOwnerTeamComboBoxItems(){
		List returnList = new ArrayList();
		IPFMRichComboItem cbitem = null;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.MCODE_IPCLASS) && componentMap.get(IPFMConstant.MCODE_IPCLASS)!=null){
				if(((List)componentMap.get(IPFMConstant.MCODE_IPCLASS)).size()>0){
					for (IpMasterTable str:((List<IpMasterTable>)componentMap.get(IPFMConstant.MCODE_IPCLASS))) {
						cbitem = new IPFMRichComboItem();
						cbitem.setValue(str.getId().getRefKey());
						cbitem.setLabel(str.getShortDesc());
						returnList.add(new SelectItem(cbitem, cbitem.getLabel()));
					}
				}
			}			
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPClass : "+e);
		}
		return returnList;
	}

	public int getIPVersion(){
		int ipVersion = 4;
		if(componentMap==null){
			loadComponent();
		}
		try {
			if(componentMap.containsKey(IPFMConstant.DEFAULT_IP_VERSION) && componentMap.get(IPFMConstant.DEFAULT_IP_VERSION)!=null){
				ipVersion = ((BigDecimal)componentMap.get(IPFMConstant.DEFAULT_IP_VERSION)).intValue();
			}
		} catch (Exception e) {
			log.error("ERROR IN IPFMComboBoxUtil.getIPVersion : "+e);
		}
		return ipVersion;
	}
	

}