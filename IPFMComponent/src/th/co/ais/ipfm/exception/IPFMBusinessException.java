package th.co.ais.ipfm.exception;



public class IPFMBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messageCode;
	private String language;
	private String[] arguments;
	private Object obj;
	
	public String[] getArguments() {
		return arguments;
	}

	public String getLanguage() {
		return language;
	}
	
	public String getMessageCode() {
		return messageCode;
	}
	
	public Object getObj() {
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
