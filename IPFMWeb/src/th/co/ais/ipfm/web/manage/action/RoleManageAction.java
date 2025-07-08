package th.co.ais.ipfm.web.manage.action;

import th.co.ais.ipfm.web.action.AbstractAction;

public class RoleManageAction extends AbstractAction{
	public boolean txt1 = false;
	public boolean btn1 = false;
	public boolean txt2 = false;
	public boolean btn2 = false;
	@Override
	public String init() {
		return init(getRequestParameter("programIDParam"));
	}

	@Override
	public String init(String programID) {
		return programID;
	}
	public String memberList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference memberList
		return "IPURS010_02";
	}
	public String advanceSetting() { // DMAP Comment : Dead Code Detected - The Following Method has no reference advanceSetting
		return getRequestParameter("programIDParam");
	}
	public String reqNetworkPage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference reqNetworkPage
		int  page = Integer.parseInt(getRequestParameter("page"));
		if(getRequestParameter("action").equalsIgnoreCase("N")){
			page++;
		}else{
			page--;
		}
		return "IPURS010_0"+page;
	}
	public String memberAdd1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference memberAdd1
		if(getRequestParameter("action").equals("add")){
			txt1 = true;
			btn1 = true;
		}else{
			txt1 = false;
			btn1 = false;
		}
		return null;
	}
	public String memberAdd2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference memberAdd2
		if(getRequestParameter("action").equals("add")){
			txt2 = true;
			btn2 = true;
		}else{
			txt2 = false;
			btn2 = false;
		}
		return null;
	}
	@Override
	public boolean validate() { // DMAP Comment : Dead Code Detected - The Following Method has no reference validate
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTxt1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isTxt1
		return txt1;
	}

	public void setTxt1(boolean txt1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTxt1
		this.txt1 = txt1;
	}

	public boolean isBtn1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isBtn1
		return btn1;
	}

	public void setBtn1(boolean btn1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setBtn1
		this.btn1 = btn1;
	}

	public boolean isTxt2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isTxt2
		return txt2;
	}

	public void setTxt2(boolean txt2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTxt2
		this.txt2 = txt2;
	}

	public boolean isBtn2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isBtn2
		return btn2;
	}

	public void setBtn2(boolean btn2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setBtn2
		this.btn2 = btn2;
	}
	
	
}
