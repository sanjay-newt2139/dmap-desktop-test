package th.co.ais.ipfm.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import th.co.ais.ipfm.web.bean.IPFMConfigBean;

/**
 * Servlet implementation class ExportDownload
 */
public class ExportDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		String tempPath = ipfmConfigBean.getTemplatePath();
		String data = "test";
		String fileName = "test.txt";
		String filePath = tempPath + "/" +request.getParameter("fileName");
//		fileName = request.getParameter("fileName");
		
		BufferedOutputStream output = null;
		try {
		    // Open file.

		    // Init servlet response.
		    response.reset();	            
		    response.setContentType("application/octet-stream");
		    response.setContentLength((int) data.length());
		    response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
		    output = new BufferedOutputStream(response.getOutputStream());

		    // Write file contents to response.
		    output.write(data.getBytes());
		    // Finalize task.
		    output.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
		    // Gently close streams.
			if(output != null)
				output.close();
		}
	}

}
