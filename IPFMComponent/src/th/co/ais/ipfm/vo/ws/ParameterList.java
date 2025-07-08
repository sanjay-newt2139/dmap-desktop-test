package th.co.ais.ipfm.vo.ws;

public class ParameterList implements java.io.Serializable {
	private static final long serialVersionUID = -206748501204990197L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID

	private String parameterType;

	private Parameter[] parameter;

	private ParameterList[] parameterList;

	public String getParameterType() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParameterType
		return parameterType;
	}

	public void setParameterType(String parameterType) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParameterType
		this.parameterType = parameterType;
	}

	public Parameter[] getParameter() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParameter
		return parameter;
	}

	public void setParameter(Parameter[] parameter) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParameter
		this.parameter = parameter;
	}

	public ParameterList[] getParameterList() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getParameterList
		return parameterList;
	}

	public void setParameterList(ParameterList[] parameterList) { // DMAP Comment : Dead Code Detected - The Following Method has no reference setParameterList
		this.parameterList = parameterList;
	}
}
