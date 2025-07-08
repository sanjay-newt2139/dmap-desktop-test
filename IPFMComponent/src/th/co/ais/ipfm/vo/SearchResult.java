package th.co.ais.ipfm.vo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1866282050047084538L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	private List resultList;
	private boolean overMaxResultLimit = false;
	private int totalResult = 0;

	public List getResultList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getResultList
		return resultList;
	}

	public void setResultList(List resultList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setResultList
		this.resultList = resultList;
	}

	public boolean isOverMaxResultLimit() { // DMAP Comment : Dead Code Detected - The Following Method has no reference isOverMaxResultLimit
		return overMaxResultLimit;
	}

	public void setOverMaxResultLimit(boolean overMaxResultLimit) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setOverMaxResultLimit
		this.overMaxResultLimit = overMaxResultLimit;
	}

	public int getTotalResult() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getTotalResult
		return totalResult;
	}

	public void setTotalResult(int totalResult) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setTotalResult
		this.totalResult = totalResult;
	}


	
}
