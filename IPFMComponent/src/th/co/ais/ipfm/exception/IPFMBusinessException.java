package th.co.ais.ipfm.exception;



public class IPFMBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // DMAP Comment : Dead Code Detected - The Following Field has no reference serialVersionUID
	
	private String messageCode;
	private String language;
	private String[] arguments;
	private Object obj;
	
	public String[] getArguments() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getArguments
		return arguments;
	}

	public String getLanguage() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getLanguage
		return language;
	}
	
	public String getMessageCode() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getMessageCode
		return messageCode;
	}
	
	public Object getObj() { // DMAP Comment : Dead Code Detected - The Following Method has no reference getObj
		return obj;
	}

	public IPFMBusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IPFMBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IPFMBusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		//this.message= message;
	}

	public IPFMBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public IPFMBusinessException(String messageCode, String language) {
		this.messageCode = messageCode;
		this.language = language;
	}
	
	public IPFMBusinessException(String messageCode, String language, String... arguments) {
		this.messageCode = messageCode;
		this.language = language;
		this.arguments = arguments;
	}
	
	public IPFMBusinessException(Object obj) {
		this.obj = obj;
	}
	
}
