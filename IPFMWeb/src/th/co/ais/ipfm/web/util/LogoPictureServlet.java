package th.co.ais.ipfm.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import th.co.ais.ipfm.web.bean.IPFMConfigBean;

/**
 * Servlet implementation class LogoPictureServlet
 */
public class LogoPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletContext();
		try{
			IPFMConfigBean configBean = (IPFMConfigBean) JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
			String logoPath = configBean.getLogoPath();
			if(logoPath != null) {
			    // Get the MIME type of the image
			    String mimeType = sc.getMimeType(logoPath);
			    if (mimeType == null) {
			        sc.log("Could not get MIME type of "+logoPath);
			        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			        return;
			    }

			    // Set content type
			    response.setContentType(mimeType);

			    // Set content size
			    File file = new File(logoPath);
			    response.setContentLength((int)file.length());

			    // Open the file and output streams
			    FileInputStream in = new FileInputStream(file);
			    OutputStream out = response.getOutputStream();

			    // Copy the contents of the file to the output stream
			    byte[] buf = new byte[1024];
			    int count = 0;
			    while ((count = in.read(buf)) >= 0) {
			        out.write(buf, 0, count);
			    }
			    in.close();
			    out.close();
				
			}
		} catch(Exception ex) {
			sc.log("Error While trying to Stream Out Logo Servlet.... ", ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
