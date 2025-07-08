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
 * Servlet implementation class TestDownload
 */
public class TemplateDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemplateDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
		String tempPath = ipfmConfigBean.getTemplatePath();
		String fileName = "";
		String filePath = tempPath + "/" +request.getParameter("fileName");
		fileName = request.getParameter("fileName");
		
		
		if(request.getParameter("attachFilePath") != null && null != request.getParameter("attachFileName")) {
			//String attachmentPath = ipfmConfigBean.getAttachPath();
			filePath = request.getParameter("attachFilePath") + "/"+ request.getParameter("attachFileName");
			fileName = request.getParameter("attachFileName");
		}
		
		
		File file = new File(filePath);
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try {
		    // Open file.
		    input = new BufferedInputStream(new FileInputStream(file));

		    // Init servlet response.
		    response.reset();	            
		    response.setContentType("application/octet-stream");
		    response.setContentLength((int) file.length());
		    response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
		    output = new BufferedOutputStream(response.getOutputStream());

		    // Write file contents to response.
		    byte[] buffer = new byte[1024];
		    int length;
		    while ((length = input.read(buffer)) > 0) {
		        output.write(buffer, 0, length);
		    }
		    // Finalize task.
		    output.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
		    // Gently close streams.
			if(input != null)
				input.close();
			
			if(output != null)
				output.close();
		}
	}

}
