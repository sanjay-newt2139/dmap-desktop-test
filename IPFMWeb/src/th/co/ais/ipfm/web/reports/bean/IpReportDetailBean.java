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
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
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
	
	
	public IpReportList getIpReportList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getIpReportList
		return ipReportList;
	}
	public void setIpReportList(IpReportList ipReportList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setIpReportList
		this.ipReportList = ipReportList;
	}
	public int getRowPerPage2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage2
		return rowPerPage2;
	}
	public void setRowPerPage2(int rowPerPage2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage2
		this.rowPerPage2 = rowPerPage2;
	}
	public int getMaxPage2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage2
		return maxPage2;
	}
	public void setMaxPage2(int maxPage2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage2
		this.maxPage2 = maxPage2;
	}
	public int getMaxSearchResult2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult2
		return maxSearchResult2;
	}
	public void setMaxSearchResult2(int maxSearchResult2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult2
		this.maxSearchResult2 = maxSearchResult2;
	}
	public int getFastStepPage2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage2
		return fastStepPage2;
	}
	public void setFastStepPage2(int fastStepPage2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage2
		this.fastStepPage2 = fastStepPage2;
	}
	public int getRowPerPage5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage5
		return rowPerPage5;
	}
	public void setRowPerPage5(int rowPerPage5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage5
		this.rowPerPage5 = rowPerPage5;
	}
	public int getMaxPage5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage5
		return maxPage5;
	}
	public void setMaxPage5(int maxPage5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage5
		this.maxPage5 = maxPage5;
	}
	public int getMaxSearchResult5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult5
		return maxSearchResult5;
	}
	public void setMaxSearchResult5(int maxSearchResult5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult5
		this.maxSearchResult5 = maxSearchResult5;
	}
	public int getFastStepPage5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage5
		return fastStepPage5;
	}
	public void setFastStepPage5(int fastStepPage5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage5
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

	public HtmlModalPanel getPopupModal() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getPopupModal
		return popupModal;
	}
	public void setPopupModal(HtmlModalPanel popupModal) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setPopupModal
		this.popupModal = popupModal;
	}
	
	public String getProgramId() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getProgramId
		return programId;
	}
	public void setProgramId(String programId) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setProgramId
		this.programId = programId;
	}
	public int getRowPerPage1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage1
		return rowPerPage1;
	}
	public void setRowPerPage1(int rowPerPage1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage1
		this.rowPerPage1 = rowPerPage1;
	}
	public int getMaxPage1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage1
		return maxPage1;
	}
	public void setMaxPage1(int maxPage1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage1
		this.maxPage1 = maxPage1;
	}
	public int getMaxSearchResult1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult1
		return maxSearchResult1;
	}
	public void setMaxSearchResult1(int maxSearchResult1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult1
		this.maxSearchResult1 = maxSearchResult1;
	}
	public int getFastStepPage1() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage1
		return fastStepPage1;
	}
	public void setFastStepPage1(int fastStepPage1) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage1
		this.fastStepPage1 = fastStepPage1;
	}
	public int getRowPerPage4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getRowPerPage4
		return rowPerPage4;
	}
	public void setRowPerPage4(int rowPerPage4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setRowPerPage4
		this.rowPerPage4 = rowPerPage4;
	}
	public int getMaxPage4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxPage4
		return maxPage4;
	}
	public void setMaxPage4(int maxPage4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxPage4
		this.maxPage4 = maxPage4;
	}
	public int getMaxSearchResult4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMaxSearchResult4
		return maxSearchResult4;
	}
	public void setMaxSearchResult4(int maxSearchResult4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setMaxSearchResult4
		this.maxSearchResult4 = maxSearchResult4;
	}
	public int getFastStepPage4() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getFastStepPage4
		return fastStepPage4;
	}
	public void setFastStepPage4(int fastStepPage4) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setFastStepPage4
		this.fastStepPage4 = fastStepPage4;
	}
	public List<Iprur001Result1> getResult1List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResult1List
		return result1List;
	}
	public void setResult1List(List<Iprur001Result1> result1List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResult1List
		this.result1List = result1List;
	}
	public List<Iprur001Result4> getResult4List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResult4List
		return result4List;
	}
	public void setResult4List(List<Iprur001Result4> result4List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResult4List
		this.result4List = result4List;
	}
	public Iprur001Result2 getResult2() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResult2
		return result2;
	}
	public void setResult2(Iprur001Result2 result2) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResult2
		this.result2 = result2;
	}
	public Iprur001Result2 getResult5() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResult5
		return result5;
	}
	public void setResult5(Iprur001Result2 result5) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResult5
		this.result5 = result5;
	}
	public String getReqDateFrom() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDateFrom
		return reqDateFrom;
	}
	public void setReqDateFrom(String reqDateFrom) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqDateFrom
		this.reqDateFrom = reqDateFrom;
	}
	public String getReqDateTo() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getReqDateTo
		return reqDateTo;
	}
	public void setReqDateTo(String reqDateTo) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setReqDateTo
		this.reqDateTo = reqDateTo;
	}
	public List<Iprur001Result2> getResult2List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResult2List
		return result2List;
	}
	public void setResult2List(List<Iprur001Result2> result2List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResult2List
		this.result2List = result2List;
	}
	public List<Iprur001Result2> getResult5List() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResult5List
		return result5List;
	}
	public void setResult5List(List<Iprur001Result2> result5List) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResult5List
		this.result5List = result5List;
	}
	
	
	

}
