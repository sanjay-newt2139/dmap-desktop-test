package th.co.ais.ipfm.web.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CallToServlet {
	private String msg;
	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}             

	public void doCall() throws IOException{
		System.out.println("call Servlet >> servlet/FileUploadServlet");
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			response.sendRedirect("servlet/FileUploadServlet");
			facesContext.responseComplete();
	}
}