package th.co.ais.ipfm.web.bean;

import java.io.Serializable;

import org.richfaces.model.Ordering;

public class SortColumnBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5479804437030566135L;

	protected String sortColumn1;
	protected String sortColumn2;
	protected String sortColumn3;
	protected String sortColumn4;
	protected String sortColumn5;
	protected String sortColumn6; 
	protected String sortColumn7; 
	protected String sortColumn8; 
	protected String sortColumn9;
	protected String sortColumn10;
	protected String sortColumn11;
	
	public SortColumnBean() {
		this.sortColumn1 = Ordering.UNSORTED.name();
		this.sortColumn2 = Ordering.UNSORTED.name();
		this.sortColumn3 = Ordering.UNSORTED.name();
		this.sortColumn4 = Ordering.UNSORTED.name();
		this.sortColumn5 = Ordering.UNSORTED.name();
		this.sortColumn6 = Ordering.UNSORTED.name();
		this.sortColumn7 = Ordering.UNSORTED.name();
		this.sortColumn8 = Ordering.UNSORTED.name();
		this.sortColumn9 = Ordering.UNSORTED.name();
		this.sortColumn10 = Ordering.UNSORTED.name();
		this.sortColumn11 = Ordering.UNSORTED.name();
	}
	
	
	
	public String getSortColumn9() {
		return sortColumn9;
	}



	public void setSortColumn9(String sortColumn9) {
		this.sortColumn9 = sortColumn9;
	}



	public String getSortColumn1() {
		return sortColumn1;
	}

	public void setSortColumn1(String sortColumn1) {
		this.sortColumn1 = sortColumn1;
	}

	public String getSortColumn2() {
		return sortColumn2;
	}

	public void setSortColumn2(String sortColumn2) {
		this.sortColumn2 = sortColumn2;
	}

	public String getSortColumn3() {
		return sortColumn3;
	}

	public void setSortColumn3(String sortColumn3) {
		this.sortColumn3 = sortColumn3;
	}

	public String getSortColumn4() {
		return sortColumn4;
	}

	public void setSortColumn4(String sortColumn4) {
		this.sortColumn4 = sortColumn4;
	}

	public String getSortColumn5() {
		return sortColumn5;
	}

	public void setSortColumn5(String sortColumn5) {
		this.sortColumn5 = sortColumn5;
	}

	public String getSortColumn6() {
		return sortColumn6;
	}

	public void setSortColumn6(String sortColumn6) {
		this.sortColumn6 = sortColumn6;
	}

	public String getSortColumn7() {
		return sortColumn7;
	}

	public void setSortColumn7(String sortColumn7) {
		this.sortColumn7 = sortColumn7;
	}
	
	public String getSortColumn8() {
		return sortColumn8;
	}

	public void setSortColumn8(String sortColumn8) {
		this.sortColumn8 = sortColumn8;
	}
	
	public String getSortColumn10() {
		return sortColumn10;
	}
	
	public void setSortColumn10(String sortColumn10) {
		this.sortColumn10 = sortColumn10;
	}
	public String getSortColumn11() {
		return sortColumn11;
	}
	
	public void setSortColumn11(String sortColumn11) {
		this.sortColumn11 = sortColumn11;
	}

}
