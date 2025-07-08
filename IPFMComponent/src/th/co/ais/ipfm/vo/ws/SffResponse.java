package th.co.ais.ipfm.vo.ws;

public class SffResponse implements java.io.Serializable {
	private static final long serialVersionUID = -3763787766268896141L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	private String errorMessage;

	private ParameterList parameterList;

	public String getErrorMessage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getErrorMessage
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setErrorMessage
		this.errorMessage = errorMessage;
	}

	public ParameterList getParameterList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParameterList
		return parameterList;
	}

	public void setParameterList(ParameterList parameterList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParameterList
		this.parameterList = parameterList;
	}
}
