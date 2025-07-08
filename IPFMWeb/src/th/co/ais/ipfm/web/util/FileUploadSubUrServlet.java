package th.co.ais.ipfm.web.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import th.co.ais.ipfm.domain1.IpSubUrAttachment;
import th.co.ais.ipfm.domain1.IpSubUrAttachmentId;
import th.co.ais.ipfm.domain1.IpUrAttachment;
import th.co.ais.ipfm.domain1.IpUrAttachmentId;
import th.co.ais.ipfm.exception.IPFMBusinessException;
import th.co.ais.ipfm.service.IpSubUrAttachmentService;
import th.co.ais.ipfm.service.IpUrAttachmentService;
import th.co.ais.ipfm.util.IPFMUtils;
import th.co.ais.ipfm.web.bean.IPFMConfigBean;

import com.oreilly.servlet.MultipartRequest;

public class FileUploadSubUrServlet extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 2740693677625051632L;

	public FileUploadSubUrServlet(){
	      super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	      throws ServletException, IOException{
		String urNo = request.getParameter("urNo");
		String catagory = request.getParameter("catagory");
		String fileName = request.getParameter("filename");
		
	    String resultString = "1";
	    System.out.println("File Name >> "+fileName);
	    System.out.println("urNo      >> "+urNo);
	    System.out.println("catagory  >> "+catagory);
	    
	    IpSubUrAttachmentService attachmentService = (IpSubUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipSubUrAttachmentService");
	    IpSubUrAttachment attach = attachmentService.findAttachmentSubUr(urNo, fileName, catagory);
	    
	    if(attach!=null && attach.getId() != null && attach.getId().getFileName() != null && !attach.getId().getFileName().equals("")){
	    	String deleteStr = attach.getFileLocation()+"/"+attach.getId().getFileName();
	    	File deleteFile = new File(deleteStr);
	    	System.out.println("I will Delete >>"+deleteStr);
	    	if(deleteFile.exists()){
	    		if(deleteFile.delete()){
	    			System.out.println("Delete >>"+deleteFile.getName());
	    			try {
						attachmentService.deleteSubAttachmentFile(attach);
					} catch (IPFMBusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			resultString="0";
	    		}
	    	}
	    }
	    
	    PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    out.println(resultString);
		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	      throws ServletException, IOException{
		   FileItemFactory factory = new DiskFileItemFactory();
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      
//	      String savePath = getServletConfig().getInitParameter("path"); 
	      IPFMConfigBean ipfmConfigBean = (IPFMConfigBean)JSFServiceFinderUtil.getInstance().getBean("ipfmConfigBean");
	      String savePath = ipfmConfigBean.getAttachPath();
	      String callFunction = "";
	      try{
	    	  long contentLength = Long.parseLong(request.getHeader("Content-Length"));
	    	  if(contentLength > 8200000L) {
				  System.out.println("File size over");
				  callFunction="window.parent.failedUpload();\n";
				 // return;
	    	  }
	    	  
	    	  File attachFolder = new File(savePath);
              if(!attachFolder.exists()) attachFolder.mkdirs();
	    	  MultipartRequest multi = new MultipartRequest(request,savePath,9000000);
		      Enumeration files = multi.getFileNames();
		      String yearFolder = IPFMUtils.changeDateFormat(IPFMUtils.currentDate("dd/MM/yyyy"), "dd/MM/yyyy", "yyyyMM");
		      while (files.hasMoreElements()){
	               String name = (String)files.nextElement();
	               String filename = multi.getFilesystemName(name);
	               String type = multi.getContentType(name);
	               String catagory = multi.getParameter("catagory");
	               String description = multi.getParameter("description");	               
	               String index = multi.getParameter("index");
	               String urNO; String userName,urStatus;
	               
	               if (index!=null && index.trim().length()>0) {
	            	   urNO = multi.getParameter("urNo"+index);
	            	   userName = multi.getParameter("userName"+index);
	            	   urStatus = multi.getParameter("urStatus"+index);
	               }else {
	            	   urNO = multi.getParameter("urNo");
	            	   userName = multi.getParameter("userName");
	            	   urStatus = multi.getParameter("urStatus");
		           }
	               
	               IpSubUrAttachmentService attachmentService = (IpSubUrAttachmentService)JSFServiceFinderUtil.getInstance().getBean("ipSubUrAttachmentService");
	               IpSubUrAttachment attachFile = attachmentService.findAttachmentSubUr(urNO, filename, catagory);
	               if (attachFile !=null) {
	            	   callFunction="window.parent.duplicateFile();\n";
	            	   break;
	               }else{
	               
		               String path = savePath;
		               String yearPath = path+"/"+yearFolder;
		               String fullPath = savePath+"/"+yearFolder+"/"+urNO+"/TempSubUr";
		               String categoryPath = fullPath+"/"+catagory;	               
		               String sourceFile = savePath+"/"+filename;
		               String destFile = fullPath+"/"+filename; 
		               
		       	       File destFolder = new File(path);
		               if(!destFolder.exists()) destFolder.mkdirs();
		               destFolder = new File(yearPath);
		               if(!destFolder.exists()) destFolder.mkdirs();
		               destFolder = new File(fullPath);
		               if(!destFolder.exists()) destFolder.mkdirs();
		               if (index!=null && index.trim().length()>0) {
		            	   destFolder = new File(categoryPath);
			               if(!destFolder.exists()) destFolder.mkdirs();
			               destFile = categoryPath+"/"+filename;		               
		               }
//		               System.out.println("destFile    >> "+destFile);
		       	       
		               File source = new File(sourceFile);
		               File dest = new File(destFile);
		               
		               boolean success = source.renameTo(dest);
		               if (!success) {
		                   // File was not successfully moved
		            	   System.out.println("File Move Success");
		               }
		               
		                //UserSession userSession = IPFMWebUtil.getUserSession();
		               
		               IpSubUrAttachment attach = new IpSubUrAttachment();
		               IpSubUrAttachmentId id = new IpSubUrAttachmentId(urNO,"temp",null,catagory,filename);
		               attach.setId(id);
		               attach.setDescription(description);
		               if (index!=null && index.trim().length()>0) {
		            	   attach.setFileLocation(categoryPath);
		               }else {
		            	   attach.setFileLocation(fullPath);
		               }
		               attach.setCreatedBy(userName);
		               attach.setLastUpdBy(userName);
		               attach.setUrStatus(urStatus);
		               attachmentService.saveAttachFile(attach);
		               //System.out.println("window.parent.successUpload");
		               if (index!=null && index.trim().length()>0){
		            	   callFunction="window.parent.successUploadIndex('"+urNO+"','"+catagory+"','"+index+"');\n";
		               }else{
		            	   callFunction="window.parent.successUpload('"+urNO+"');\n";
		               }
	               }
	          } 
		  } catch(IOException ex){
			  System.out.println("File size over");
			  callFunction="window.parent.failedUpload();\n";
		  } finally{
			  //System.out.print("callFunction = " +callFunction);
			  PrintWriter out = response.getWriter();
		  	  response.setContentType("text/html");
		  	  StringBuffer bf = new StringBuffer();
		  	  bf.append("<script language='javascript'>\n");
		  	  bf.append(callFunction);
		  	  bf.append("</script>\n");
		  	  out.println(bf.toString());
		  	  out.flush();
		  	  out.close();
		  }
	   }


}
