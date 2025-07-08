package th.co.ais.ipfm.web.util;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.util.IPFMUtils;

public class ExportUtils {
	
	public static byte[] exportIPLevel3(List<IpInfo> ipInfoList) {
		byte[] inputSteam = null;
		Vector<String> header = new Vector();
		IpInfo ipInfo = null;
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();
			
			header.add(new String("IP Address"));
			header.add(new String("VLAN"));
			header.add(new String("IP Status"));
			header.add(new String("Expire Date"));
			header.add(new String("Host Name"));
			header.add(new String("System Name"));
			header.add(new String("Mask"));
			header.add(new String("Gateway"));
			header.add(new String("System Owner Name"));
			header.add(new String("Nat IP"));
			
			XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
			style.setFillForegroundColor(new XSSFColor(new Color(189,208,49)));
			style.setFillBackgroundColor(new XSSFColor(new Color(189,208,49)));
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			
			XSSFFont font = (XSSFFont) workbook.createFont();
	        font.setFontName("Arial");
	        font.setFontHeightInPoints((short) 10);
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
	        font.setColor(HSSFColor.WHITE.index);
	        style.setFont(font);
		    
		    
		    XSSFCellStyle cellStyleHead = (XSSFCellStyle) workbook.createCellStyle(); 
//		    cellStyleHead.setFont(font);
		    
		    Iterator rows = header.iterator();
			
		    int totalNoOfRows=1;	
		    int currentRow=0;
		    
//		    XSSFRow rowHead =  sheet.createRow(currentRow++);
//		    XSSFCell cellHead;
//		    cellHead = rowHead.createCell(0);
//		    cellHead.setCellType(Cell.CELL_TYPE_STRING);
//		    cellHead.setCellValue("TR Report");
//		    cellHead.setCellStyle(cellStyleHead);
		    
		    while (rows.hasNext () && currentRow<totalNoOfRows){
		        XSSFRow row =  sheet.createRow(currentRow++);               
		
		        for (int i = 0; i < header.size(); i++) {
		        	
		            XSSFCell cell=row.createCell(i);
		            Object val=rows.next();
		            if( val instanceof String){
		                cell.setCellValue(val.toString());
		                cell.setCellType(Cell.CELL_TYPE_STRING);
		                cell.setCellStyle(style);
		            }
		        }
		    } 
		    
		    int index = 0;
		    String value = "";
		    if(ipInfoList != null && ipInfoList.size() > 0){
		    	for (int j = 0; j < ipInfoList.size(); j++) {
		    		ipInfo = ipInfoList.get(j);
		    		
		    		XSSFRow row =  sheet.createRow(currentRow++);
			    	index = 0;	
			    	XSSFCell cell;
			
		        	for(int i = 0;i < header.size();i++){ 
		        		
		        		if(i == 0){
		        			value = (ipInfo != null)?ipInfo.getIpAddress():"";
		        		}else if (i == 1) {
		        			value = (ipInfo != null)?ipInfo.getVlanId():"";
						}else if (i == 2) {
							value = (ipInfo != null)?ipInfo.getIpStatusName():"";
						}else if (i == 3) {
							value = (ipInfo != null)?IPFMUtils.cnvDateToString(ipInfo.getExpiredDate(), "DD/MM/YYYY"):"";
						}else if (i == 4) {
							value = (ipInfo != null)?ipInfo.getHostName():"";
						}else if (i == 5) {
							value = (ipInfo != null)?ipInfo.getSystemName():"";
						}else if (i == 6) {
							value = (ipInfo != null)?ipInfo.getIpSubmask():"";
						}else if (i == 7) {
							value = (ipInfo != null)?ipInfo.getGateway():"";
						}else if (i == 8) {
							value = (ipInfo != null)?ipInfo.getSystemOwnerName():"";
						}else if (i == 9) {
							value = (ipInfo != null)?ipInfo.getNatIp():"";
						}
		        		
					    cell = row.createCell(index++);   	
					    cell.setCellType(Cell.CELL_TYPE_STRING);
					    cell.setCellValue(value);
			
			    	}
			    }
		    	
			    for(int s=0;s<header.size();s++){
			    	sheet.autoSizeColumn(s);
				}
		    }    

		 
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        workbook.write(baos); 
	        inputSteam = baos.toByteArray();
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return inputSteam;
	}
}
