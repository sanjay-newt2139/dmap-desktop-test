package th.co.ais.ipfm.web.manage.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpUrAccessListTnp;
import th.co.ais.ipfm.domain1.IpUrF5;
import th.co.ais.ipfm.domain1.IpUrF5Id;
import th.co.ais.ipfm.domain1.IpUrFirewall;
import th.co.ais.ipfm.domain1.IpvJobAssign;
import th.co.ais.ipfm.domain1.IpvRetriveF5;
import th.co.ais.ipfm.domain1.MsgUploadError;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.F5Service;
import th.co.ais.ipfm.service.IPUrNwConfigService;
import th.co.ais.ipfm.util.ErrorMessageUtil;
import th.co.ais.ipfm.util.IPFMDataUtility;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;
import th.co.ais.ipfm.util.IPFMExcelUtils;
import th.co.ais.ipfm.web.action.AbstractAction;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;
import th.co.ais.ipfm.web.bean.UserSession;
import th.co.ais.ipfm.web.manage.bean.IPF5Bean;
import th.co.ais.ipfm.web.manage.bean.ReqNWConfigBean;
import th.co.ais.ipfm.web.util.IPFMMessageUtils;
import th.co.ais.ipfm.web.util.IPFMWebUtil;
import th.co.ais.ipfm.web.util.JSFServiceFinderUtil;
import th.co.ais.ipfm.web.validate.F5Validate;


public class NWConfigF5Action extends AbstractAction{
	
	public NWConfigF5Action(){
	}
	
	public ReqNWConfigBean getNetworkConfigBean() {
		return (ReqNWConfigBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("networkConfigBean");
	}

	public void setNetworkConfigBean(ReqNWConfigBean networkConfigBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("networkConfigBean", networkConfigBean);
	}
	
	public void retrieveData(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IPF5Bean f5Bean = bean.getF5();
			f5Bean.setRetriveFound(false);
				if(validate()){
						    bean.setInsertF5Mode(true);
						    //f5Bean.setRetriveFound(false);
						
							IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
							List<IpvRetriveF5> retriveList = f5Service.retriveF5(f5Bean.getVip(), f5Bean.getIpPort(), bean.getUrNo());
							String errMsg ="";
							if(retriveList.size()==0){
								IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0067")));
								bean.setErrorMsg("");
								bean.setErrorFlag(false);
								
//								errMsg = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0067"));
								//f5Bean.setRetriveFound(true);								
//								bean.setErrorMsg(errMsg);
//								bean.setErrorFlag(true);
							}else {
								IpvRetriveF5  ipvRetriveF5 =  retriveList.get(0);
								bean.getF5().setIsSnatIP(ipvRetriveF5.getIsSnapIp());
								bean.getF5().setSnatIp(ipvRetriveF5.getSnapIp());
								bean.getF5().setPersistence(ipvRetriveF5.getIsPersistence());
								bean.getF5().setMethod(ipvRetriveF5.getMethod());
								bean.setErrorMsg("");
								bean.setErrorFlag(false);
								//if(!isMatchVipIndexCache(f5Bean)) { 
									IpUrF5 f5 = new IpUrF5();
									IpUrF5Id id = new IpUrF5Id();
									for(IpvRetriveF5 retrive : retriveList){
											id.setUrNo(bean.getUrNo());
											//id.setUrNo(retrive.getUrNo());
											id.setSubUrNo(f5Service.genSubUrNo(bean.getUrNo()));
											String subURNo = f5Service.genSubUrNo(bean.getUrNo());
											id.setSubUrNo(subURNo.equals("0")?"F500001":nextVal(subURNo));
											f5.setId(id);
											
											f5.setVipAddress(retrive.getIpAddress());
											f5.setVipPort(retrive.getVipPort());
											f5.setIsSnapIp(retrive.getIsSnapIp());
											f5.setSnapIp(retrive.getSnapIp());
											f5.setIsPersistence(retrive.getIsPersistence());
											f5.setMethod(retrive.getMethod());
											f5.setPoolIpAddress(retrive.getPoolIpAddress());
											f5.setPoolIpPort(retrive.getPoolIpPort());
											f5.setPoolWeight(retrive.getPoolWeight());
											
											f5.setCreated(new Date());
											f5.setCreatedBy(sessionUser.getIpUser().getUserId());
											f5.setRowId(nwConfigService.genRowId());
											if(!isRejecMode(bean))
												f5.setChangeType("A");
											
											f5.setUrType("NC");
											f5.setIsTnp(nwConfigService.isTnp(f5.getVipAddress()));
											
											f5Service.saveOrUpdate(f5);
											


//											f5Bean.setSnatIp(f5.getSnapIp());
//											f5Bean.setIsSnatIP(f5.getIsSnapIp());
//											if(f5.getIsSnapIp()!=null){
//												f5Bean.setIsSnatIPTxt(f5.getIsSnapIp().equals("Y")?"Yes":"No");
//											} else {
//												f5Bean.setIsSnatIPTxt("No");
//											}
//											f5Bean.setPersistence(f5.getIsPersistence());
//											if(f5.getIsPersistence()!=null){
//												f5Bean.setPersistenceTxt(f5.getIsPersistence().equals("Y")?"Yes":"No");
//											} else {
//												f5Bean.setPersistenceTxt("No");
//											}
//											f5Bean.setMethod(f5.getMethod());
//											if(f5.getMethod()!=null){
//												if(f5.getMethod().equals("RR")){
//													f5Bean.setMethodTxt("Round Robin");
//												} else if(f5.getMethod().equals("RT")){
//													f5Bean.setMethodTxt("Ratio");
//												}
//											}
											bean.setInsertF5Mode(false);
		
										}
								//} 
									//f5Bean.setSubMode("ADD");
									f5Bean.setIpPool("");
									f5Bean.setIpPoolPort("");
									//f5Bean.setIpPort("");
									f5Bean.setIpWeight("");
									f5Bean.setIsFound("");
									f5Bean.setIsSnatIP("");
									f5Bean.setIsSnatIPTxt("");
									f5Bean.setMethod("");
									f5Bean.setMethodTxt("");
									f5Bean.setPersistence("");
									f5Bean.setPersistenceTxt("");
									
									f5Bean.setSnatIp("");
									//f5Bean.setVip("");
									bean.getF5().setCheckAll(false);
							f5Bean.setRetriveFound(true);
							isMatchVipIndexCache(f5Bean);
						 }

						List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
						f5Bean.setCheckAll(false);
						bean.setF5(f5Bean);
						bean.setListF5(listF5);
						setNetworkConfigBean(bean);
						
				}

	}
	
	public void otherIp(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		bean.setInsertF5Mode(true);
		boolean checkAll = bean.getF5().isCheckAll();
		IPF5Bean f5 = bean.getF5();
		IPF5Bean f5Bean = new IPF5Bean();
		bean.setF5(f5Bean);
//		f5Bean.setRetriveFound(f5.getRetriveFound());
		f5Bean.setVipIndexCache(f5.getVipIndexCache());
		bean.getF5().setCheckAll(checkAll);
		setNetworkConfigBean(bean);
	}
	
	public void addData(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
	 try{
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPF5Bean f5Bean = bean.getF5();
		
		//TODO:NAT
        //System.out.println("inline -->>> " + lines.size());
        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord(); 
        int recordRest = 0;
        List<IpUrF5> listF5C = f5Service.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listF5C!=null && listF5C.size()>0) recordRest = listF5C.size();
         
        if((recordRest+1)>maxRecord) {     		
        	IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
        	bean.setErrorMsg("");	
        	bean.setErrorFlag(false);
           setNetworkConfigBean(bean);
           return;
        } 
        //TODO:NAT
        
        
		if(f5Bean.getVip()!=null && f5Bean.getVip().trim().length()>0){
			if (IPFMDataValidateUtil.validateIPFormat(f5Bean.getVip())){
				IpInfo info = f5Service.getIPInfo(f5Bean.getVip().trim());
				if (info == null) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),f5Bean.getVip().trim()));
					
				}else if (info.getVip() == null || !info.getVip().toUpperCase().trim().equalsIgnoreCase("Y")) {
					//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0094"),f5Bean.getVip().trim()));
					
				}
			}
		}
			
		if(f5Bean.getMethod()!=null){
			if(f5Bean.getMethod().equals("RR")){
				f5Bean.setMethodTxt("Round Robin");
			} else if(f5Bean.getMethod().equals("RT")){
				f5Bean.setMethodTxt("Ratio");
			}
		}
		
		F5Validate f5Validate = new F5Validate(f5Bean);
		String validate = f5Validate.validate();

		f5Bean.setRetriveFound(false);		
		
		if(IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return;
		}
		
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
			if(!isMatchVipIndexCache(f5Bean)) {
				List<IpvRetriveF5> retriveList = f5Service.retriveF5(f5Bean.getVip(), f5Bean.getIpPort(), bean.getUrNo());
				if(retriveList == null || retriveList.size() == 0) {
					f5Bean.setRetriveFound(false);
				} else {
					f5Bean.setRetriveFound(true);
				}
			}
			
			if(f5Bean.getRetriveFound() == false) {
				IpUrF5 f5 = new IpUrF5();
				IpUrF5Id id = new IpUrF5Id();
				id.setUrNo(bean.getUrNo());
				id.setSubUrNo(f5Service.genSubUrNo(bean.getUrNo()));
				String subURNo = f5Service.genSubUrNo(bean.getUrNo());
				id.setSubUrNo(subURNo.equals("0")?"F500001":nextVal(subURNo));
				f5.setId(id);
				
				f5.setVipAddress(f5Bean.getVip());
				f5.setVipPort(f5Bean.getIpPort());
				f5.setIsSnapIp(f5Bean.getIsSnatIP());
				f5.setSnapIp(f5Bean.getSnatIp());
				f5.setIsPersistence(f5Bean.getPersistence());
				f5.setMethod(f5Bean.getMethod());
				f5.setPoolIpAddress(f5Bean.getIpPool());
				f5.setPoolIpPort(f5Bean.getIpPoolPort());
				f5.setPoolWeight(f5Bean.getIpWeight());
				
				f5.setRowId(nwConfigService.genRowId());
				f5.setUrType("NC");
				f5.setIsTnp(nwConfigService.isTnp(f5.getVipAddress()));
				if(!isRejecMode(bean))
					f5.setChangeType("A");
				
				f5.setCreated(new Date());
				f5.setCreatedBy(sessionUser.getIpUser().getUserId());
				
				if(bean.getListF5() != null) {
					bean.getListF5().add(f5);
				}
				
				if(f5Validate.validateWeightOver(bean.getListF5()).equals("")) {
					f5Service.saveOrUpdate(f5);
				} else {
					bean.getListF5().remove(f5);
					return;
				}
				
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				
				f5.setPoolIpAddress(f5Bean.getIpPool());
				f5.setPoolIpPort(f5Bean.getIpPoolPort());
				f5.setPoolWeight(f5Bean.getIpWeight());
				
				f5Bean.setIpPool("");
				f5Bean.setIpPoolPort("");
				f5Bean.setIpWeight("");
				
				bean.setF5(f5Bean);
				// add some thing
				f5Bean.setSnatIp(f5.getSnapIp());
				f5Bean.setIsSnatIP(f5.getIsSnapIp());
				if(f5.getIsSnapIp()!=null){
					f5Bean.setIsSnatIPTxt(f5.getIsSnapIp().equals("Y")?"Yes":"No");
				} else {
					f5Bean.setIsSnatIPTxt("No");
				}
				f5Bean.setPersistence(f5.getIsPersistence());
				if(f5.getIsPersistence()!=null){
					f5Bean.setPersistenceTxt(f5.getIsPersistence().equals("Y")?"Yes":"No");
				} else {
					f5Bean.setPersistenceTxt("No");
				}
				f5Bean.setMethod(f5.getMethod());
				if(f5.getMethod()!=null){
					if(f5.getMethod().equals("RR")){
						f5Bean.setMethodTxt("Round Robin");
					} else if(f5.getMethod().equals("RT")){
						f5Bean.setMethodTxt("Ratio");
					}
				}
				bean.setCurrentTab("F5");
				List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
				//bean.setInsertF5Mode(false);
				IPF5Bean f5NewBean =  new IPF5Bean();
				f5NewBean.setVip(f5Bean.getVip());
				f5NewBean.setIpPort(f5Bean.getIpPort());
				f5NewBean.setVipIndexCache(f5Bean.getVipIndexCache());
				f5NewBean.setRetriveFound(f5Bean.getRetriveFound());
				bean.setF5(f5NewBean);
				bean.setListF5(listF5);
				bean.getF5().setCheckAll(false);

			}
		}
		setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
	}
	
	private boolean isMatchVipIndexCache(IPF5Bean f5Bean) {
		boolean isMatch = false;
		
		if(f5Bean.getVipIndexCache() == null) {
			f5Bean.setVipIndexCache(new HashSet<String>());
		}
		
		Set<String> vipIndexCache = f5Bean.getVipIndexCache();
		String vipIndex =formatVipIndex(f5Bean);
		isMatch = vipIndexCache.contains(vipIndex);
		if(!isMatch) {
			vipIndexCache.add(vipIndex);
		} 
		return isMatch;
	}
	
	private String formatVipIndex(IPF5Bean f5Bean) {
		return f5Bean.getVip()+ "-" + f5Bean.getIpPort();
	}
	

	public void editF5(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		UserSession sessionUser = IPFMWebUtil.getUserSession();
	 try{
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		IPF5Bean f5Bean = bean.getF5();
		if(f5Bean.getVip()!=null && f5Bean.getVip().trim().length()>0){
			if (IPFMDataValidateUtil.validateIPFormat(f5Bean.getVip())){
				IpInfo info = f5Service.getIPInfo(f5Bean.getVip().trim());
				if (info == null) {
					IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0048"),f5Bean.getVip().trim()));
					
				}else if (info.getVip() == null || !info.getVip().toUpperCase().trim().equalsIgnoreCase("Y")) {
					//IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0094"),f5Bean.getVip().trim()));
					
				}
			}
		}
		
		if(f5Bean.getMethod()!=null){
			if(f5Bean.getMethod().equals("RR")){
				f5Bean.setMethodTxt("Round Robin");
			} else if(f5Bean.getMethod().equals("RT")){
				f5Bean.setMethodTxt("Ratio");
			}
		}

		F5Validate f5Validate = new F5Validate(f5Bean);
		String validate = f5Validate.validate();
		
		if(IPFMMessageUtils.hasMessages()) {
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
			return;
		}
		if(!validate.equals("")){
//				bean.setErrorMsg(validate);
//				bean.setErrorFlag(true);
		} else {
	//			IpUrF5 f5 = new IpUrF5();
	//			IpUrF5Id id = new IpUrF5Id();
	//			id.setUrNo(bean.getUrNo());
	//			id.setSubUrNo(f5Service.genSubUrNo(bean.getUrNo()));
	//			String subURNo = f5Service.genSubUrNo(bean.getUrNo());
	//			id.setSubUrNo(subURNo.equals("0")?"F500001":nextVal(subURNo));
	//			f5.setId(id);
			IpUrF5 f5 = bean.getListF5().get(f5Bean.getRowNum());
			
			f5.setVipAddress(f5Bean.getVip());
			f5.setVipPort(f5Bean.getIpPort());
			f5.setIsSnapIp(f5Bean.getIsSnatIP());
			f5.setSnapIp(f5Bean.getSnatIp());
			f5.setIsPersistence(f5Bean.getPersistence());
			f5.setMethod(f5Bean.getMethod());
			f5.setPoolIpAddress(f5Bean.getIpPool());
			f5.setPoolIpPort(f5Bean.getIpPoolPort());
			f5.setPoolWeight(f5Bean.getIpWeight());
			
			f5.setRowId(nwConfigService.genRowId());
			f5.setUrType("NC");
			f5.setIsTnp(nwConfigService.isTnp(f5.getVipAddress()));
			if(!isRejecMode(bean))
				f5.setChangeType("A");
			
			f5.setCreated(new Date());
			f5.setCreatedBy(sessionUser.getIpUser().getUserId());
			
			f5.setPoolIpAddress(f5Bean.getIpPool());
			f5.setPoolIpPort(f5Bean.getIpPoolPort());
			f5.setPoolWeight(f5Bean.getIpWeight());			
			
			if(!f5Validate.validateWeightOver(bean.getListF5()).equals("")) {
				List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
				if(listF5 != null && listF5.size() > 0) {
					bean.setListF5(listF5);
				}
				bean.setErrorMsg("");
				bean.setErrorFlag(false);
				return;
			} else {
				f5Service.saveOrUpdate(f5);
				IPF5Bean f5BeanNew = new IPF5Bean();
				f5BeanNew.setVip(f5Bean.getVip());
				f5BeanNew.setIpPort(f5Bean.getIpPort());
				f5BeanNew.setVipIndexCache(f5Bean.getVipIndexCache());
				f5BeanNew.setRetriveFound(f5Bean.getRetriveFound());
				bean.setF5(f5BeanNew);
				f5Bean.setSubMode("ADD");
			}
		}

				bean.setCurrentTab("F5");
				List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
				//bean.setInsertF5Mode(false);
				bean.setListF5(listF5);
				bean.getF5().setCheckAll(false);				
				setNetworkConfigBean(bean);
		
		}catch (Exception e) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0008")));
		}
		
	}
	
	
	//id.setSubUrNo(subURNo.equals("0")?"RT00001":nextVal(subURNo));
	private String nextVal(String subUrNo){
		String resultString = "F5";
		int no =  Integer.parseInt(subUrNo.substring(2));
		String nnn = String.valueOf(++no);
		for(int i=0;i<5-nnn.length();i++) resultString+="0";
		resultString+=nnn;
		return resultString;
	}
	
	public void initEdit(ActionEvent event){
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		String rowNumber = getRequestParameter("rowNumber");
		
		ReqNWConfigBean bean = getNetworkConfigBean();
		IPF5Bean f5Bean = bean.getF5();
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IpUrF5Id id = new IpUrF5Id(urNo, subUrNo);
		IpUrF5 f5 = f5Service.getF5ById(id);
		int rowInt = 0;
		if(rowNumber != null && !rowNumber.equals("")) {
			rowInt = Integer.parseInt(rowNumber);
			f5Bean.setRowNum(rowInt);
		}
		bean.setEditUrF5(f5);
		f5Bean.setSubMode("EDIT");
		f5Bean.setIpPool(f5.getPoolIpAddress());
		f5Bean.setIpPoolPort(f5.getPoolIpPort());
		f5Bean.setIpPort(f5.getVipPort());
		f5Bean.setIpWeight(f5.getPoolWeight());
//		f5Bean.setIsFound();
		f5Bean.setSnatIp(f5.getSnapIp());
		f5Bean.setIsSnatIP(f5.getIsSnapIp());
		if(f5.getIsSnapIp()!=null){
			f5Bean.setIsSnatIPTxt(f5.getIsSnapIp().equals("Y")?"Yes":"No");
		} else {
			f5Bean.setIsSnatIPTxt("No");
		}
		f5Bean.setPersistence(f5.getIsPersistence());
		if(f5.getIsPersistence()!=null){
			f5Bean.setPersistenceTxt(f5.getIsPersistence().equals("Y")?"Yes":"No");
		} else {
			f5Bean.setPersistenceTxt("No");
		}
		f5Bean.setMethod(f5.getMethod());
		if(f5.getMethod()!=null){
			if(f5.getMethod().equals("RR")){
				f5Bean.setMethodTxt("Round Robin");
			} else if(f5.getMethod().equals("RT")){
				f5Bean.setMethodTxt("Ratio");
			}
		}		


		f5Bean.setVip(f5.getVipAddress());
		
		bean.setF5(f5Bean);
		
		setNetworkConfigBean(bean);		
	}
		
//	public void updateF5Detail(){
//		String urNo = getRequestParameter("urNo");
//		String subUrNo = getRequestParameter("subUrNo");
//		
//		ReqNWConfigBean bean = getNetworkConfigBean();
//		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
//		IpUrF5Id id = new IpUrF5Id(urNo, subUrNo);
//		IpUrF5 f5 = f5Service.getF5ById(id);
//		
//		f5.setPoolIpPort(bean.getEditUrF5().getPoolIpPort());
//		f5.setPoolWeight(bean.getEditUrF5().getPoolWeight());
//		f5Service.saveOrUpdate(f5);
//		
//		List<IpUrF5> listF5 = f5Service.findByUrNo(urNo);
//		bean.setListF5(listF5);
//		setNetworkConfigBean(bean);
//	}
	
	public void findSubUr(){
		String urNo = getRequestParameter("urNo");
		String subUrNo = getRequestParameter("subUrNo");
		
		ReqNWConfigBean bean = getNetworkConfigBean();
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		
		IpUrF5 rsF5 = f5Service.findFirewall(urNo, subUrNo);
//		IpvJobAssign jobAssign  = nwConfigService.getJobAssign(urNo, subUrNo);
		List<IpvJobAssign> jobAssignList  = nwConfigService.getJobAssignList(urNo, subUrNo);
		IPF5Bean f5Bean = new IPF5Bean();
		f5Bean.setSearchResult(rsF5);
//		f5Bean.setJobAssign(jobAssign);
		f5Bean.setJobAssignList(jobAssignList);
		bean.setF5(f5Bean);
		setNetworkConfigBean(bean);
	}
	
	public void listener(UploadEvent event) throws Exception{
		IPUrNwConfigService nwConfigService = (IPUrNwConfigService)JSFServiceFinderUtil.getInstance().getBean("ipUrNwConfigService");
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		UserSession sessionUser = IPFMWebUtil.getUserSession();
		
        UploadItem item = event.getUploadItem();
        File uplaoded = item.getFile();
        IPFMExcelUtils excelFile = new IPFMExcelUtils(uplaoded);
        ArrayList lines = new IPFMExcelUtils(uplaoded).getSheet("Data",3);
        List<MsgUploadError> validate = new ArrayList<MsgUploadError>();
        List<IpUrF5> f5List = new ArrayList<IpUrF5>();
        boolean hasError = false;
        F5Validate f5Validate = new F5Validate(); 
        
      //TODO:NAT
        //System.out.println("inline -->>> " + lines.size());        
        int maxRecord = IPFMWebUtil.webConfigMaxRecord();
        int recordRest = 0;
        List<IpUrF5> listF5C = f5Service.findByUrNo(getNetworkConfigBean().getUrNo());
        if(listF5C!=null && listF5C.size()>0) recordRest = maxRecord - listF5C.size();
        else recordRest = maxRecord;
        
        if(lines!=null && lines.size()>recordRest) {
        	MsgUploadError error = new MsgUploadError();
    		error.setRowNumber("-");
    		error.setDescription(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0211"),"" + maxRecord));
    		validate.add(error);
    		
        	ReqNWConfigBean bean = getNetworkConfigBean();        	
        	bean.setValidateResult(validate);
            bean.setErrorFlag(true);
            setNetworkConfigBean(bean);
            return;
        } 
        //TODO:NAT
        
        int rowCount = 0;
        
        for(int pos=0;pos<lines.size();pos++){
        	Map<Integer,String> data = (Map<Integer,String>)lines.get(pos);
        	IPF5Bean f5Bean = new IPF5Bean();
        	f5Bean.setVip(data.get(0).trim());
        	f5Bean.setIpPort(data.get(1).trim());
        	f5Bean.setIsSnatIP(data.get(2).trim());
        	f5Bean.setSnatIp(data.get(3).trim());
        	f5Bean.setPersistence(data.get(4).trim());
        	f5Bean.setMethodTxt(data.get(5).trim());
    		if(data.get(5).trim().equals("Ratio")){
    			f5Bean.setMethod("RT");
    		} else if(data.get(5).trim().equals("Round Robin")){
    			f5Bean.setMethod("RR");
    		}        	
        	f5Bean.setIpPool(data.get(6).trim());
        	f5Bean.setIpPoolPort(data.get(7).trim());
        	f5Bean.setIpWeight(data.get(8).trim());
        	
        	f5Validate.setF5(f5Bean); 
        	String validateResult = f5Validate.validate();
        	
        	if((validateResult!=null) && !validateResult.equals("")){
        		MsgUploadError error = new MsgUploadError();
        		error.setRowNumber(String.valueOf(pos+1));
        		error.setDescription(validateResult);
        		rowCount++;
        		validate.add(error);
        		System.out.println("Error inline "+error.getRowNumber());
        		System.out.println("Error Msg >> "+error.getDescription());
        		hasError = true;
        	}
        	
        	if(!hasError){
        		IpUrF5 subUr = new IpUrF5();
	        	
        		subUr.setVipAddress(f5Bean.getVip());
        		subUr.setVipPort(f5Bean.getIpPort());
        		subUr.setIsSnapIp(f5Bean.getIsSnatIP());
        		subUr.setSnapIp(f5Bean.getSnatIp());
        		subUr.setIsPersistence(f5Bean.getPersistence());
        		if(f5Bean.getMethodTxt().equals("Ratio")){
        			subUr.setMethod("RT");
        		} else if(f5Bean.getMethodTxt().equals("Round Robin")){
        			subUr.setMethod("RR");
        		}
        		
        		subUr.setPoolIpAddress(f5Bean.getIpPool());
        		subUr.setPoolIpPort(f5Bean.getIpPoolPort());
        		subUr.setPoolWeight(f5Bean.getIpWeight());
				
        		f5List.add(subUr);
        		
        	}
        	hasError = false;
        }
        
        
        ReqNWConfigBean bean = getNetworkConfigBean();
        String validateWeightError = f5Validate.validateWeightOver(f5List);
        if(validate.size()==0 && validateWeightError.equals("")){
        	for(IpUrF5 f5 : f5List){
        		String subUrNo = f5Service.genSubUrNo(bean.getUrNo());
        		IpUrF5Id id = new IpUrF5Id(bean.getUrNo(), subUrNo.equals("0")?"F500001":nextVal(subUrNo));
        		f5.setId(id);
        		f5.setUrType("NC");
        		f5.setIsTnp(nwConfigService.isTnp(f5.getVipAddress()));
        		if(!isRejecMode(bean))
        			f5.setChangeType("A");
        		
        		f5.setRowId(nwConfigService.genRowId());
        		f5.setCreated(new Date());
        		f5.setCreatedBy(sessionUser.getIpUser().getUserId());
        		f5Service.saveOrUpdate(f5);
        	}
        } else if(!validateWeightError.equals("")) {
    		MsgUploadError error = new MsgUploadError();
    		error.setRowNumber("For Ratio Weight Only ");
    		error.setDescription(validateWeightError);
    		validate.add(error);        	
        }
        
        List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
		bean.setListF5(listF5);
        bean.setValidateResult(validate);
        bean.setErrorFlag(validate.size()>0);
        setNetworkConfigBean(bean);
    } 
	
	public void deleteF5(String urNo,String subUrNo){
		ReqNWConfigBean bean = getNetworkConfigBean();
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IpUrF5 f5 = f5Service.findFirewall(urNo, subUrNo);
		String changeType = (f5.getChangeType()!=null)?f5.getChangeType():""; 
		if(changeType.equals("A")){
			f5Service.delete(f5);
		} else {
			f5.setChangeType("D");
			f5Service.update(f5);
		}
		List<IpUrF5> listF5 = f5Service.findByUrNo(bean.getUrNo());
		bean.setListF5(listF5);
//		if(!bean.getF5().getRetriveFound()) {
//			bean.setF5(new IPF5Bean());
//		}
		IPF5Bean f5Bean = bean.getF5();
		f5Bean.setSubMode("ADD");
		f5Bean.setIpPool("");
		f5Bean.setIpPoolPort("");
		//f5Bean.setIpPort("");
		f5Bean.setIpWeight("");
		f5Bean.setIsFound("");
		f5Bean.setIsSnatIP("");
		f5Bean.setIsSnatIPTxt("");
		f5Bean.setMethod("");
		f5Bean.setMethodTxt("");
		f5Bean.setPersistence("");
		f5Bean.setPersistenceTxt("");
		f5Bean.setRetriveFound(false);
		f5Bean.setSnatIp("");
		//f5Bean.setVip("");
		bean.getF5().setCheckAll(false);
		
		Set<String> vipCacheIndexReplace = new HashSet<String>();
		for(IpUrF5 f5New : bean.getListF5()) {
			vipCacheIndexReplace.add(f5New.getVipAddress()+"-"+f5New.getVipPort());
		}
		bean.getF5().setVipIndexCache(vipCacheIndexReplace);
        setNetworkConfigBean(bean);
		
	}
	
	
	public void findIPNode(ActionEvent event){
		ReqNWConfigBean bean = getNetworkConfigBean();
		F5Service f5Service = (F5Service)JSFServiceFinderUtil.getInstance().getBean("f5Service");
		IPF5Bean f5Bean = bean.getF5();
		
		IpInfo info = f5Service.getIPInfoWithStatus(f5Bean.getIpPool());
		f5Bean.setIsFound((info!=null)?"1":"0");
		if(info == null) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0148"),f5Bean.getIpPool()));
			f5Bean.setIpPool("");
			f5Bean.setIpPoolPort("");
		}
		bean.setF5(f5Bean);
		setNetworkConfigBean(bean);		
	}
	
	public void errorMessage(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		System.out.println("System Error Message for F5");
		System.out.println("Message >> "+bean.getF5().getErrorMessage());		
		setNetworkConfigBean(bean);
	}
	
	public void checkFileTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestF5();
	        File file = new File(path,fileName);
	        if (!file.isFile()) IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0065")));
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }

	
	public void downloadTemplate() {
		try{
	        IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	        String path = ipfmConfigBean.getTemplatePath();
	        String fileName = ipfmConfigBean.getTemplateRequestF5();
	        downloadFile(path, fileName);	        
		}catch (IPFMBusinessException ipfme){
			ipfme.printStackTrace();
			IPFMMessageUtils.addMessageError(ipfme.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0066")));
		}
    }

	@Override
	public String init() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String init(String programID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		ReqNWConfigBean bean = getNetworkConfigBean();
		F5Validate f5Validate = new F5Validate();
		if ("".equals(bean.getF5().getVip()) ||  "".equals(bean.getF5().getIpPort()) ) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0085")));
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
//			String errMsg  = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0085"));
			flgValid = false;
//			bean.setErrorMsg(errMsg);
//			bean.setErrorFlag(true);
		} else if(!f5Validate.isVip(bean.getF5().getVip())) {
			IPFMMessageUtils.addMessageError(IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0201")));
			bean.setErrorMsg("");
			bean.setErrorFlag(false);
//			String errMsg  = IPFMDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0085"));
			flgValid = false;
			
		}
          setNetworkConfigBean(bean);
          
		return flgValid;
	}
	
	public void clearSnatIP(){
		ReqNWConfigBean bean = getNetworkConfigBean();
		if (bean.getF5().getIsSnatIP()!=null && bean.getF5().getIsSnatIP().equalsIgnoreCase("N")) {
			bean.getF5().setSnatIp("");
		} else if(bean.getF5().getIsSnatIP()!=null && bean.getF5().getIsSnatIP().equalsIgnoreCase("Y")){
			bean.getF5().setSnatIp(bean.getF5().getVip());
		}
		setNetworkConfigBean(bean);
	}
}

