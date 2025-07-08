package th.co.ais.ipfm.vo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1866282050047084538L;
	private List resultList;
	private boolean overMaxResultLimit = false;
	private int totalResult = 0;

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public boolean isOverMaxResultLimit() {
		return overMaxResultLimit;
	}

	public void setOverMaxResultLimit(boolean overMaxResultLimit) {
		this.overMaxResultLimit = overMaxResultLimit;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}


	
}
