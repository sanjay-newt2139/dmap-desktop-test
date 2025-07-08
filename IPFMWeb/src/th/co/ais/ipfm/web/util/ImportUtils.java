package th.co.ais.ipfm.web.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.richfaces.model.UploadItem;

import com.ctc.wstx.util.DataUtil;

import th.co.ais.ipfm.domain1.IpInfo;
import th.co.ais.ipfm.domain1.IpInfoTemp;
import th.co.ais.ipfm.util.IPFMConstant;
import th.co.ais.ipfm.util.IPFMDataValidateUtil;

public class ImportUtils implements Serializable {
	
	private static Logger logger = Logger.getLogger(ImportUtils.class);
	private static final char DEFAULT_TRIM_WHITESPACE = ' ';
	private static final String TYPE_STRING = "TYPE_STRING";
	private static final String PATTEN_DATE_DEFAULT = "dd/MM/yyyy";
	
	
	
	

	public static HashMap importIpLevel3_IPFM(UploadItem item,String username){
		InputStream inputStream = null;
		List<IpInfoTemp> ipInfoTempList = new ArrayList<IpInfoTemp>();
		IpInfoTemp ipInfoTemp;
		int totalColumn = 10;
		HashMap resultMap = new HashMap();
		String result = "SUCCESS";
		boolean checknatip = false;
		
		try{
			if(item != null){
				inputStream = new FileInputStream(item.getFile());
				
				String value;
				Object obj;
				int startRow = 2;
				XSSFCell cell = null;
				XSSFRow row = null;
				XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
				
				XSSFSheet sheet = workBook.getSheetAt(0);
				Iterator rowList = sheet.rowIterator ();
				while(rowList.hasNext()){
					ipInfoTemp = new IpInfoTemp();
					row = (XSSFRow) rowList.next();
					if(row.getRowNum()+1 >= startRow){
						for (int i = 0;i < totalColumn; i++) {
							cell = row.getCell(i);
							value = null;
							if(cell != null){
								obj = getValueFromCell(cell, TYPE_STRING);
			                    value = (obj != null)?obj.toString():"";
			                    value = leftTrim(value);
			                    value = rightTrim(value);
			                    logger.debug("column :"+(i+1)+" :"+value);
							}else{
								logger.debug("column :"+(i+1)+" :"+"null");
							}
							
							if(row.getRowNum()+1 == 1){
								
							}
							
							//IP Address
		                    if(i == 0 && value != null){ 
		                    	ipInfoTemp.setIpAddress(value);
		                    	
		                    //VLAN
		                    }else if (i == 1 && value != null) {
		                    	ipInfoTemp.setVlanId(value);
		                    	
							//IP Status
							}else if (i == 2 && value != null) {
								ipInfoTemp.setIpStatus(value);
								
							//Expire Date
							}else if (i == 3 && value != null) {
								ipInfoTemp.setExpiredDate(stringToDate(value, PATTEN_DATE_DEFAULT));
								
							//Host Name
							}else if (i == 4 && value != null) {	
								ipInfoTemp.setHostName(value);
	                    		
							//System Name
							}else if (i == 5 && value != null) {
								ipInfoTemp.setSystemName(value);
	                    		
							//Mask
							}else if (i == 6 && value != null) {
								ipInfoTemp.setIpSubmask(value);
								
							//Gateway
							}else if (i == 7 && value != null) {
								ipInfoTemp.setGateway(value);
								
							//System Owner Name
							}else if (i == 8 && value != null) {
								ipInfoTemp.setSystemOwnerName(value);
								
							//NAT IP	
							}else if (i == 9 && value != null) {
								ipInfoTemp.setNatIp(value);	
							}
		                    
		                    ipInfoTemp.setCreatedBy(username);
		                    ipInfoTemp.setLastUpdBy(username);
		                    ipInfoTemp.setTemplateType("IPFM");
						}
						ipInfoTempList.add(ipInfoTemp);
					}
				}
			}
		 }catch (Exception e) {
			e.printStackTrace();
			result = "FAIL";
		 }finally{
			try{
				if(inputStream != null)
					inputStream.close();
				if (item != null && item.isTempFile() && item.getFile().isFile()) {
	                item.getFile().delete();
	            }
	            item = null;
			}catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 
		 
		  resultMap.put(IPFMConstant.IPINFO_LIST, ipInfoTempList);
		  resultMap.put(IPFMConstant.RESULT, result);
		 
		 return resultMap;
	} 
	
	public static HashMap importIpLevel3_ICTAP(UploadItem item,String username){
		InputStream inputStream = null;
		List<IpInfoTemp> ipInfoTempList = new ArrayList<IpInfoTemp>();
		IpInfoTemp ipInfoTemp;
		int totalColumn = 30;
		HashMap resultMap = new HashMap();
		String result = "SUCCESS";
		int rowIndex = 0;
		String gateway = "";
		try{
			if(item != null){
				inputStream = new FileInputStream(item.getFile());
				
				String value;
				Object obj;
				int startRow = 6;
				XSSFCell cell = null;
				XSSFRow row = null;
				XSSFWorkbook workBook = new XSSFWorkbook(inputStream); 
				
				XSSFSheet sheet = workBook.getSheet("IP");
				Iterator rowList = sheet.rowIterator ();
				while(rowList.hasNext()){
					ipInfoTemp = new IpInfoTemp();
					row = (XSSFRow) rowList.next();
					if(row.getRowNum()+1 >= startRow){
						for (int i = 0;i < totalColumn; i++) {
							cell = row.getCell(i);
							value = null;
							if(cell != null){
								obj = getValueFromCell(cell, TYPE_STRING);
			                    value = (obj != null)?obj.toString():"";
			                    value = leftTrim(value);
			                    value = rightTrim(value);
			                    logger.debug("column :"+(i+1)+" :"+value);
							}else{
								logger.debug("column :"+(i+1)+" :"+"null");
							}
							
							if(row.getRowNum()+1 == 1){
								
							}
							
							//IP Address
		                    if(i == 4 && value != null){ 
		                    	ipInfoTemp.setIpAddress(value);
		                    	
		                    //VLAN
		                    }else if (i == 27 && value != null) {
		                    	ipInfoTemp.setVlanId(value);
		                    	
							//IP Status
							}else if (i == 11 && value != null) {
								ipInfoTemp.setIpStatus(value);
								
							//Expire Date
//							}else if (i == 3 && value != null) {
//								ipInfoTemp.setExpiredDate(stringToDate(value, PATTEN_DATE_DEFAULT));
								
							//Host Name
							}else if (i == 25 && value != null) {	
								ipInfoTemp.setHostName(value);
	                    		
							//System Name
							}else if (i == 13 && value != null) {
								ipInfoTemp.setSystemName(value);
	                    		
							//Mask
							}else if (i == 5 && value != null) {
								ipInfoTemp.setIpSubmask(value);
								
							//Gateway
//							}else if (i == 7 && value != null) {
//								ipInfoTemp.setGateway(value);
								
							//System Owner Name
							}else if (i == 15 && value != null) {
								ipInfoTemp.setSystemOwnerName(value);
								
							}
		                    ipInfoTemp.setCreatedBy(username);
		                    ipInfoTemp.setLastUpdBy(username);
		                    ipInfoTemp.setTemplateType("ICTAP");
						}
						if(StringUtils.equals("Gateway", ipInfoTemp.getIpStatus())){
							gateway = ipInfoTemp.getIpAddress();
							ipInfoTemp.setGateway(gateway);
							ipInfoTempList.get(rowIndex-1).setGateway(gateway);
						}else{
							ipInfoTemp.setGateway(gateway);
						}
						ipInfoTempList.add(ipInfoTemp);
						rowIndex++;
					}
				}
			}
		 }catch (Exception e) {
			e.printStackTrace();
			result = "FAIL";
		 }finally{
			try{
				if(inputStream != null)
					inputStream.close();
				if (item != null && item.isTempFile() && item.getFile().isFile()) {
	                item.getFile().delete();
	            }
	            item = null;
			}catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 resultMap.put(IPFMConstant.RESULT, result);
		 resultMap.put(IPFMConstant.IPINFO_LIST, ipInfoTempList);
		 return resultMap;
	} 
	
	
	/** For Excel Read **/
	private static Object getValueFromCell(Cell cell,String type){
		Object o = null;
		if(cell != null){
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					o = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					o = cell.getNumericCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					break;
				case Cell.CELL_TYPE_FORMULA:
					break;
				default:;
			}
			
			if(o instanceof Double){
				if(StringUtils.equals(type, TYPE_STRING) && o != null){
					long l = ((Double) o).longValue();
//					NumberFormat nf = new DecimalFormat("##########");
//					String o1 = nf.format(d);
					return l+"";
				}
			}
		}else{
			logger.debug("Cell Is Null");
		}
		return o;
	}
	
	public static String leftTrim(String value){
		return (StringUtils.isNotEmpty(value))?trimLeft(value, DEFAULT_TRIM_WHITESPACE):"";
	}
	
	public static String rightTrim(String value){
		return (StringUtils.isNotEmpty(value))?trimRight(value, DEFAULT_TRIM_WHITESPACE):"";
	}
	
	private static String trimLeft(final String string, final char trimChar)
    {
        final int stringLength = string.length();
        int i;
        
        for (i = 0; i < stringLength && string.charAt(i) == trimChar; i++) {
            /* increment i until it is at the location of the first char that
             * does not match the trimChar given. */
        }

        if (i == 0) {
            return string;
        } else {
            return string.substring(i);
        }
    }

    public static String trimRight(final String string, final char trimChar)
    {
        final int lastChar = string.length() - 1;
        int i;

        for (i = lastChar; i >= 0 && string.charAt(i) == trimChar; i--) {
            /* Decrement i until it is equal to the first char that does not
             * match the trimChar given. */
        }
        
        if (i < lastChar) {
            // the +1 is so we include the char at i
            return string.substring(0, i+1);
        } else {
            return string;
        }
    }
    
    public static Date stringToDate(String value,String patten){
    	try{
	    	if(StringUtils.isNotEmpty(value)){
		    	DateFormat format = new SimpleDateFormat(patten,Locale.ENGLISH);
		    	return format.parse(value);
	    	}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
}
