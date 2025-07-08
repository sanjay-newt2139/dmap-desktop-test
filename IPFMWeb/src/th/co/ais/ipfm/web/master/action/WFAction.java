package th.co.ais.ipfm.web.master.action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import javax.faces.context.FacesContext;

import th.co.ais.ipfm.domain1.IpWfConfig;
import th.co.ais.ipfm.domain1.IpWfConfigDetail;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.WorkFlowService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.master.bean.WFBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;

public class WFAction extends AbstractAction {
	/********************** MenuAuthenticationAction ***********************/
	public WFBean wfBean;
	

	
	public WFBean getWfBean() {
		return (WFBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("wfBean");
	}

	public void setWfBean(WFBean wfBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("wfBean", wfBean);
	}

	
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		WorkFlowService workFlowService = (WorkFlowService)JSFServiceFinderUtil.getInstance().getBean("workFlowService");
		WFBean  bean = new WFBean();
		try{
			IpWfConfig  ipWfConfigPlanning  = workFlowService.getIpWfConfig("IP12");
			List<IpWfConfigDetail> ipWfConfigPlanningList =  workFlowService.getIpWfConfigDetailList("IP12");
			int total =0;
			for(IpWfConfigDetail obj : ipWfConfigPlanningList){
				String  ola = obj.getOla().toString();
				total = total+Integer.parseInt(ola);
			}
			bean.setTotal(total);
			bean.setIpWfConfigPlanningList(ipWfConfigPlanningList);
			bean.setIpWfConfig(ipWfConfigPlanning);
			setWfBean(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return programID;
	}
	
	public void tabUserRquest(){
		WorkFlowService workFlowService = (WorkFlowService)JSFServiceFinderUtil.getInstance().getBean("workFlowService");
		WFBean  bean = getWfBean();
		try{
			IpWfConfig  ipWfConfigUserRequest  = workFlowService.getIpWfConfig("IP23");
			List<IpWfConfigDetail> ipWfConfigUserRequestList =  workFlowService.getIpWfConfigDetailList("IP23");
			int total =0;
			for(IpWfConfigDetail obj : ipWfConfigUserRequestList){
				String  ola = obj.getOla().toString();
				total = total+Integer.parseInt(ola);
			}
			bean.setTotal(total);
			bean.setIpWfConfigUserRequestList(ipWfConfigUserRequestList);
			bean.setIpWfConfig(ipWfConfigUserRequest);
			setWfBean(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void tabNwConfig(){
		WorkFlowService workFlowService = (WorkFlowService)JSFServiceFinderUtil.getInstance().getBean("workFlowService");
		WFBean  bean = getWfBean();
		try{
			IpWfConfig  ipWfConfigNwConfig  = workFlowService.getIpWfConfig("NC");
			List<IpWfConfigDetail> ipWfConfigRequestNetworkList =  workFlowService.getIpWfConfigDetailList("NC");
			bean.setIpWfConfigRequestNetworkList(ipWfConfigRequestNetworkList);
			bean.setIpWfConfig(ipWfConfigNwConfig);
			
			int  maxOla = workFlowService.maxOla();
			int baseNCSLA=0;
			int slaTnpWithoutImpact=0;
			int slaTnpWithImpact=0;
			int slaCdnWithoutImpact=0;
			int slaCdnWithImpact=0;
			//--------- Get OLA of Team Process ------------------------------
			for(IpWfConfigDetail obj : ipWfConfigRequestNetworkList){
				if("N4".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					baseNCSLA = Integer.parseInt(ola) + maxOla;	
				}
			}
			
			//--------------------SLA(TNP without Impact)  & SLA(TNP with Impact)----------------------------------
			for(IpWfConfigDetail obj : ipWfConfigRequestNetworkList){
/*				if("N6".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithoutImpact = baseNCSLA + Integer.parseInt(ola);	
				}
				if("N8".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithImpact = slaTnpWithoutImpact +Integer.parseInt(ola);
				}*/
				if("N4".equals(obj.getId().getNodeId())||
				   "N5".equals(obj.getId().getNodeId()) ||
				   "N6".equals(obj.getId().getNodeId()) ||
				   "N9".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithoutImpact = slaTnpWithoutImpact + Integer.parseInt(ola);	
				}
				if("N4".equals(obj.getId().getNodeId())||
				   "N5".equals(obj.getId().getNodeId())||
				   "N6".equals(obj.getId().getNodeId())||
				   "N8".equals(obj.getId().getNodeId())||
				   "N9".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithImpact = slaTnpWithImpact + Integer.parseInt(ola);
				}
			}
			
			//--------------------SLA(CDN without Impact)  & SLA(CDN with Impact) ----------------------------------
			int maxNodeCdn =0;
			for(IpWfConfigDetail obj : ipWfConfigRequestNetworkList){
				if("N10".equals(obj.getId().getNodeId())||
				   "N11".equals(obj.getId().getNodeId())||
				   "N12".equals(obj.getId().getNodeId())||
				   "N13".equals(obj.getId().getNodeId())||
				   "N14".equals(obj.getId().getNodeId())||
				   "N15".equals(obj.getId().getNodeId())||
				   "N16".equals(obj.getId().getNodeId())||
				   "N17".equals(obj.getId().getNodeId())){
			        if (Integer.parseInt(obj.getOla().toString()) > maxNodeCdn) {
			        	maxNodeCdn = Integer.parseInt(obj.getOla().toString());
			        }
				}
			}
			for(IpWfConfigDetail obj : ipWfConfigRequestNetworkList){
				if("N4".equals(obj.getId().getNodeId())||
					"N5".equals(obj.getId().getNodeId())||
				    "N7".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaCdnWithoutImpact = slaCdnWithoutImpact + Integer.parseInt(ola);	
				}
				if("N4".equals(obj.getId().getNodeId())||
				   "N5".equals(obj.getId().getNodeId())||
				   "N7".equals(obj.getId().getNodeId())||	
				   "N8".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaCdnWithImpact = slaCdnWithImpact + Integer.parseInt(ola);
				}
			}

			bean.getIpWfConfig().setSlaTnpWithoutImpact(slaTnpWithoutImpact);
			bean.getIpWfConfig().setSlaTnpWithImpact(slaTnpWithImpact);
			bean.getIpWfConfig().setCdnWithoutImpact(slaCdnWithoutImpact+maxNodeCdn);
			bean.getIpWfConfig().setCdnWithImpact(slaCdnWithImpact+maxNodeCdn);
			setWfBean(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void save(){
		WorkFlowService workFlowService = (WorkFlowService)JSFServiceFinderUtil.getInstance().getBean("workFlowService");
		WFBean  bean = getWfBean();
		UserSession userSession = IPFMWebUtil.getUserSession();
		try{
			bean.getIpWfConfig().setLastUpdBy(userSession.getIpUser().getUserId());
			
			if("IP12".equals(bean.getIpWfConfig().getUrType())){
				BigDecimal  sla = new BigDecimal(bean.getTotal());
				bean.getIpWfConfig().setSla(sla);
			    workFlowService.save(bean.getIpWfConfig(), bean.getIpWfConfigPlanningList(),bean.getUserInfo().getUserId());
			}else if("IP23".equals(bean.getIpWfConfig().getUrType())){
				BigDecimal  sla = new BigDecimal(bean.getTotal());
				bean.getIpWfConfig().setSla(sla);
				workFlowService.save(bean.getIpWfConfig(), bean.getIpWfConfigUserRequestList(),bean.getUserInfo().getUserId());
			}else{
				workFlowService.save(bean.getIpWfConfig(), bean.getIpWfConfigRequestNetworkList(),bean.getUserInfo().getUserId());
				onkeyOlaNwConfig();
			}
			IPFMMessageUtils.addMessageInfo(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0012")));
			
		}catch (IPFMBusinessException ipfme){
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
	}
	
	public void onkeyOlaPalning(){
		WFBean  bean = getWfBean();
		try{
			int total =0;
			for(IpWfConfigDetail obj : bean.getIpWfConfigPlanningList()){
				String  ola = obj.getOla().toString();
				total = total+Integer.parseInt(ola);
			}
			bean.setTotal(total);
			setWfBean(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onkeyOlaUserRequest(){
		WFBean  bean = getWfBean();
		try{
			int total =0;
			for(IpWfConfigDetail obj : bean.getIpWfConfigUserRequestList()){
				String  ola = obj.getOla().toString();
				total = total+Integer.parseInt(ola);
			}
			bean.setTotal(total);
			setWfBean(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onkeyOlaNwConfig(){
		WorkFlowService workFlowService = (WorkFlowService)JSFServiceFinderUtil.getInstance().getBean("workFlowService");
		WFBean  bean = getWfBean();
		try{
			//int  maxOla = workFlowService.maxOla();
			int baseNCSLA=0;
			int slaTnpWithoutImpact=0;
			int slaTnpWithImpact=0;
			int slaCdnWithoutImpact=0;
			int slaCdnWithImpact=0;
			
			IpWfConfigDetail  ipWfConfigDetail =  bean.getIpWfConfigRequestNetworkList().get(0);
			int maxOla = Integer.parseInt(ipWfConfigDetail.getOla().toString());  
			for(IpWfConfigDetail obj : bean.getIpWfConfigRequestNetworkList()){

		        if (Integer.parseInt(obj.getOla().toString()) > maxOla) {
		        	maxOla = Integer.parseInt(obj.getOla().toString());
		        }
			}
			
			//--------- Get OLA of Team Process ------------------------------
			for(IpWfConfigDetail obj : bean.getIpWfConfigRequestNetworkList()){
				if("N4".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					baseNCSLA = Integer.parseInt(ola) + maxOla;	
				}
			}
			
			//--------------------SLA(TNP without Impact)  & SLA(TNP with Impact)----------------------------------
/*			for(IpWfConfigDetail obj : bean.getIpWfConfigRequestNetworkList()){
				if("N6".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithoutImpact = baseNCSLA + Integer.parseInt(ola);	
				}
				if("N8".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithImpact = slaTnpWithoutImpact +Integer.parseInt(ola);
				}
			}*/
			for(IpWfConfigDetail obj : bean.getIpWfConfigRequestNetworkList()){
				if("N4".equals(obj.getId().getNodeId())||
				   "N5".equals(obj.getId().getNodeId()) ||
				   "N6".equals(obj.getId().getNodeId()) ||
				   "N9".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithoutImpact = slaTnpWithoutImpact + Integer.parseInt(ola);	
				}
				if("N4".equals(obj.getId().getNodeId())||
				   "N5".equals(obj.getId().getNodeId())||
				   "N6".equals(obj.getId().getNodeId())||
				   "N8".equals(obj.getId().getNodeId())||
				   "N9".equals(obj.getId().getNodeId())){
					String  ola = obj.getOla().toString();
					slaTnpWithImpact = slaTnpWithImpact + Integer.parseInt(ola);
				}
			}
			//--------------------SLA(CDN without Impact)  & SLA(CDN with Impact) ----------------------------------
			int maxNodeCdn =0;
			for(IpWfConfigDetail obj : bean.getIpWfConfigRequestNetworkList()){
				if("N10".equals(obj.getId().getNodeId())||
				   "N11".equals(obj.getId().getNodeId())||
				   "N12".equals(obj.getId().getNodeId())||
				   "N13".equals(obj.getId().getNodeId())||
				   "N14".equals(obj.getId().getNodeId())||
				   "N15".equals(obj.getId().getNodeId())||
				   "N16".equals(obj.getId().getNodeId())||
				   "N17".equals(obj.getId().getNodeId())){
			        if (Integer.parseInt(obj.getOla().toString()) > maxNodeCdn) {
			        	maxNodeCdn = Integer.parseInt(obj.getOla().toString());
			        }
				}
			}
			for(IpWfConfigDetail obj : bean.getIpWfConfigRequestNetworkList()){
				if("N4".equals(obj.getId().getNodeId())||
						"N5".equals(obj.getId().getNodeId())||
					    "N7".equals(obj.getId().getNodeId())){
						String  ola = obj.getOla().toString();
						slaCdnWithoutImpact = slaCdnWithoutImpact + Integer.parseInt(ola);	
					}
					if("N4".equals(obj.getId().getNodeId())||
					   "N5".equals(obj.getId().getNodeId())||
					   "N7".equals(obj.getId().getNodeId())||	
					   "N8".equals(obj.getId().getNodeId())){
						String  ola = obj.getOla().toString();
						slaCdnWithImpact = slaCdnWithImpact + Integer.parseInt(ola);
				}
			}

			bean.getIpWfConfig().setSlaTnpWithoutImpact(slaTnpWithoutImpact);
			bean.getIpWfConfig().setSlaTnpWithImpact(slaTnpWithImpact);
			bean.getIpWfConfig().setCdnWithoutImpact(slaCdnWithoutImpact+maxNodeCdn);
			bean.getIpWfConfig().setCdnWithImpact(slaCdnWithImpact+maxNodeCdn);
			setWfBean(bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
}
