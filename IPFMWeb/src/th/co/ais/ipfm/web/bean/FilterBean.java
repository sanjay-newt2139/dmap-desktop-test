package th.co.ais.ipfm.web.bean;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import org.richfaces.model.Ordering;

public class FilterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3669546309109117471L;

	protected String filterColumn1;
	protected String filterColumn2;
	protected String filterColumn3;
	protected String filterColumn4;
	protected String filterColumn5;
	protected String filterColumn6;
	protected String filterColumn7;
	protected String filterColumn8;
	protected String filterColumn9;
	protected String filterColumn10;
	protected String filterColumn11;

	public FilterBean() {
		this.filterColumn1 = "";
		this.filterColumn2 = "";
		this.filterColumn3 = "";
		this.filterColumn4 = "";
		this.filterColumn5 = "";
		this.filterColumn6 = "";
		this.filterColumn7 = "";
		this.filterColumn8 = "";	
		this.filterColumn9 = "";
		this.filterColumn10 = "";
		this.filterColumn11 = "";
	}

	public String getFilterColumn11() {
		return filterColumn11;
	}

	public void setFilterColumn11(String filterColumn11) {
		this.filterColumn11 = filterColumn11;
	}

	public String getFilterColumn9() {
		return filterColumn9;
	}

	public void setFilterColumn9(String filterColumn9) {
		this.filterColumn9 = filterColumn9;
	}
	
	public String getFilterColumn1() {
		return filterColumn1;
	}

	public void setFilterColumn1(String filterColumn1) {
		this.filterColumn1 = filterColumn1;
	}

	public String getFilterColumn2() {
		return filterColumn2;
	}

	public void setFilterColumn2(String filterColumn2) {
		this.filterColumn2 = filterColumn2;
	}

	public String getFilterColumn3() {
		return filterColumn3;
	}

	public void setFilterColumn3(String filterColumn3) {
		this.filterColumn3 = filterColumn3;
	}

	public String getFilterColumn4() {
		return filterColumn4;
	}

	public void setFilterColumn4(String filterColumn4) {
		this.filterColumn4 = filterColumn4;
	}

	public String getFilterColumn5() {
		return filterColumn5;
	}

	public void setFilterColumn5(String filterColumn5) {
		this.filterColumn5 = filterColumn5;
	}

	public String getFilterColumn6() {
		return filterColumn6;
	}

	public void setFilterColumn6(String filterColumn6) {
		this.filterColumn6 = filterColumn6;
	}

	public String getFilterColumn7() {
		return filterColumn7;
	}

	public void setFilterColumn7(String filterColumn7) {
		this.filterColumn7 = filterColumn7;
	}

	public String getFilterColumn8() {
		return filterColumn8;
	}

	public void setFilterColumn8(String filterColumn8) {
		this.filterColumn8 = filterColumn8;
	}
	public String getFilterColumn10() {
		return filterColumn10;
	}

	public void setFilterColumn10(String filterColumn10) {
		this.filterColumn10 = filterColumn10;
	}

}
