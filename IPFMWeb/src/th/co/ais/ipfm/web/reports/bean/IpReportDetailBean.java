/**
 * 
 */
package th.co.ais.ipfm.web.reports.bean;

import java.io.Serializable;
import java.util.List;

import org.richfaces.component.html.HtmlModalPanel;

import th.co.ais.ipfm.domain1.IpReportList;
import th.co.ais.ipfm.domain1.Iprur001Result1;
import th.co.ais.ipfm.domain1.Iprur001Result2;
import th.co.ais.ipfm.domain1.Iprur001Result3;
import th.co.ais.ipfm.domain1.Iprur001Result4;

/**
 * @author Administrator
 *
 */
public final class IpReportDetailBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String programId;
	
	private int rowPerPage1;
	private int maxPage1;
	private int maxSearchResult1;
	private int fastStepPage1;
	
	private int rowPerPage2;
	private int maxPage2;
	private int maxSearchResult2;
	private int fastStepPage2;
	
	private int rowPerPage4;
	private int maxPage4;
	private int maxSearchResult4;
	private int fastStepPage4;
	
	private int rowPerPage5;
	private int maxPage5;
	private int maxSearchResult5;
	private int fastStepPage5;
	
	private IpReportList ipReportList;
	
	
	public IpReportList getIpReportList() {
		return ipReportList;
	}
	public void setIpReportList(IpReportList ipReportList) {
		this.ipReportList = ipReportList;
	}
	public int getRowPerPage2() {
		return rowPerPage2;
	}
	public void setRowPerPage2(int rowPerPage2) {
		this.rowPerPage2 = rowPerPage2;
	}
	public int getMaxPage2() {
		return maxPage2;
	}
	public void setMaxPage2(int maxPage2) {
		this.maxPage2 = maxPage2;
	}
	public int getMaxSearchResult2() {
		return maxSearchResult2;
	}
	public void setMaxSearchResult2(int maxSearchResult2) {
		this.maxSearchResult2 = maxSearchResult2;
	}
	public int getFastStepPage2() {
		return fastStepPage2;
	}
	public void setFastStepPage2(int fastStepPage2) {
		this.fastStepPage2 = fastStepPage2;
	}
	public int getRowPerPage5() {
		return rowPerPage5;
	}
	public void setRowPerPage5(int rowPerPage5) {
		this.rowPerPage5 = rowPerPage5;
	}
	public int getMaxPage5() {
		return maxPage5;
	}
	public void setMaxPage5(int maxPage5) {
		this.maxPage5 = maxPage5;
	}
	public int getMaxSearchResult5() {
		return maxSearchResult5;
	}
	public void setMaxSearchResult5(int maxSearchResult5) {
		this.maxSearchResult5 = maxSearchResult5;
	}
	public int getFastStepPage5() {
		return fastStepPage5;
	}
	public void setFastStepPage5(int fastStepPage5) {
		this.fastStepPage5 = fastStepPage5;
	}
	private List<Iprur001Result1> result1List;
	private List<Iprur001Result4> result4List;	
	private List<Iprur001Result2> result2List;
	private List<Iprur001Result2> result5List;
	private Iprur001Result2 result2;	
	private Iprur001Result2 result5;	
	
	private String reqDateFrom;
	private String reqDateTo;
	

	private HtmlModalPanel popupModal;

	public HtmlModalPanel getPopupModal() {
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) {
		this.popupModal = popupModal;
	}
	
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public int getRowPerPage1() {
		return rowPerPage1;
	}
	public void setRowPerPage1(int rowPerPage1) {
		this.rowPerPage1 = rowPerPage1;
	}
	public int getMaxPage1() {
		return maxPage1;
	}
	public void setMaxPage1(int maxPage1) {
		this.maxPage1 = maxPage1;
	}
	public int getMaxSearchResult1() {
		return maxSearchResult1;
	}
	public void setMaxSearchResult1(int maxSearchResult1) {
		this.maxSearchResult1 = maxSearchResult1;
	}
	public int getFastStepPage1() {
		return fastStepPage1;
	}
	public void setFastStepPage1(int fastStepPage1) {
		this.fastStepPage1 = fastStepPage1;
	}
	public int getRowPerPage4() {
		return rowPerPage4;
	}
	public void setRowPerPage4(int rowPerPage4) {
		this.rowPerPage4 = rowPerPage4;
	}
	public int getMaxPage4() {
		return maxPage4;
	}
	public void setMaxPage4(int maxPage4) {
		this.maxPage4 = maxPage4;
	}
	public int getMaxSearchResult4() {
		return maxSearchResult4;
	}
	public void setMaxSearchResult4(int maxSearchResult4) {
		this.maxSearchResult4 = maxSearchResult4;
	}
	public int getFastStepPage4() {
		return fastStepPage4;
	}
	public void setFastStepPage4(int fastStepPage4) {
		this.fastStepPage4 = fastStepPage4;
	}
	public List<Iprur001Result1> getResult1List() {
		return result1List;
	}
	public void setResult1List(List<Iprur001Result1> result1List) {
		this.result1List = result1List;
	}
	public List<Iprur001Result4> getResult4List() {
		return result4List;
	}
	public void setResult4List(List<Iprur001Result4> result4List) {
		this.result4List = result4List;
	}
	public Iprur001Result2 getResult2() {
		return result2;
	}
	public void setResult2(Iprur001Result2 result2) {
		this.result2 = result2;
	}
	public Iprur001Result2 getResult5() {
		return result5;
	}
	public void setResult5(Iprur001Result2 result5) {
		this.result5 = result5;
	}
	public String getReqDateFrom() {
		return reqDateFrom;
	}
	public void setReqDateFrom(String reqDateFrom) {
		this.reqDateFrom = reqDateFrom;
	}
	public String getReqDateTo() {
		return reqDateTo;
	}
	public void setReqDateTo(String reqDateTo) {
		this.reqDateTo = reqDateTo;
	}
	public List<Iprur001Result2> getResult2List() {
		return result2List;
	}
	public void setResult2List(List<Iprur001Result2> result2List) {
		this.result2List = result2List;
	}
	public List<Iprur001Result2> getResult5List() {
		return result5List;
	}
	public void setResult5List(List<Iprur001Result2> result5List) {
		this.result5List = result5List;
	}
	
	
	

}
