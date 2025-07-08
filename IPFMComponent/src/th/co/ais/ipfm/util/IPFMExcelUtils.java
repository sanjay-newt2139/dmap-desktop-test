package th.co.ais.ipfm.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class IPFMExcelUtils {
	private String inputFile;
	private File inputWorkbook;
	
	public IPFMExcelUtils(){
	}
	
	public IPFMExcelUtils(String filename){
		this.inputFile=filename;
		this.inputWorkbook=new File(inputFile);
	}
	
	public IPFMExcelUtils(File fp){
		this.inputWorkbook=fp;
	}
	
	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	} 
	
	@SuppressWarnings("unchecked")
	public ArrayList getSheet(int sheetNo) throws IOException  {
		ArrayList listResult = new ArrayList();
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(sheetNo);
			
			for(int row=2;row<sheet.getRows();row++){
				Map<String, String> rows = new HashMap<String, String>();
				for(int col=0;col<sheet.getColumns();col++){
					Cell nameRef = sheet.getCell(col, 0);
					String fieldName = nameRef.getContents().trim();
					Cell cell = sheet.getCell(col, row);
					String value=cell.getContents();
					rows.put(fieldName, value);
					
				}
				listResult.add(rows);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return listResult;
	}
	@SuppressWarnings("unchecked")
	public ArrayList getData(File file,String sheetName) throws IOException  {
		ArrayList listResult = new ArrayList();
		Workbook w;
		try {
			w = Workbook.getWorkbook(file);
			Sheet sheet = w.getSheet(sheetName);
			
			boolean eofFlag = false;			
			int rowIndex = 2;
			int columnsCount = 0;
			while(!eofFlag && columnsCount<sheet.getColumns()){
				Cell cell = sheet.getCell(columnsCount, 0);
				String value=cell.getContents();	
				columnsCount++;				
				if (value==null || value.trim().length()==0){
					eofFlag=true;
					break;				
				}
			}
			eofFlag = false;
			while(!eofFlag && rowIndex<sheet.getRows()){	
				int rowsEofCount = 1;				
				Map<Integer, String> rows = new LinkedHashMap<Integer, String>();
				for(int col=0;col<columnsCount;col++){
					Cell cell = sheet.getCell(col, rowIndex);
					String value=cell.getContents();
					if(value==null || value.trim().length()==0){
						if (rowsEofCount==columnsCount) {
							eofFlag=true;
							break;
						}
						rowsEofCount++;						
					}
					rows.put(col, value);
				}
				if(!eofFlag){
					rowIndex++;
					listResult.add(rows);
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return listResult;
	}
	@SuppressWarnings("unchecked")
	public ArrayList getData(String inputFile, String sheetName) throws IOException  {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		ArrayList listResult = new ArrayList();
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(sheetName);
			
			boolean eofFlag = false;			
			int rowIndex = 2;
			int columnsCount = 0;
			while(!eofFlag && columnsCount<sheet.getColumns()){
				Cell cell = sheet.getCell(columnsCount, 0);
				String value=cell.getContents();	
				columnsCount++;				
				if (value==null || value.trim().length()==0){
					eofFlag=true;
					break;				
				}
			}
			eofFlag = false;
			while(!eofFlag && rowIndex<sheet.getRows()){	
				int rowsEofCount = 1;				
				Map<Integer, String> rows = new LinkedHashMap<Integer, String>();
				for(int col=0;col<columnsCount;col++){
					Cell cell = sheet.getCell(col, rowIndex);
					String value=cell.getContents();
					if(value==null || value.trim().length()==0){
						if (rowsEofCount==columnsCount) {
							eofFlag=true;
							break;
						}
						rowsEofCount++;						
					}
					rows.put(col, value);
				}
				if(!eofFlag){
					rowIndex++;
					listResult.add(rows);
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return listResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getSheet(String sheetName) throws IOException  {
		ArrayList listResult = new ArrayList();
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(sheetName);
			
			for(int row=2;row<sheet.getRows();row++){
				Map<String, String> rows = new HashMap<String, String>();
				boolean hasValue = false;
				for(int col=0;col<sheet.getColumns();col++){
					Cell nameRef = sheet.getCell(col, 0);
					String fieldName = nameRef.getContents().trim();
					Cell cell = sheet.getCell(col, row);
					String value=cell.getContents();
					rows.put(fieldName, value);
					boolean notEmpty = (value!=null) && !(value.equals(""));
					hasValue=(hasValue || notEmpty); 
				}
				if(hasValue) listResult.add(rows);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return listResult;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList getSheet(String sheetName,int headerLine) throws IOException  {
		ArrayList listResult = new ArrayList();
		//File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(sheetName);
			
			for(int row=headerLine;row<sheet.getRows();row++){
				Map<Integer, String> rows = new HashMap<Integer, String>();
				boolean hasValue = false;
				for(int col=0;col<sheet.getColumns();col++){
					Cell nameRef = sheet.getCell(col, 0);
					String fieldName = nameRef.getContents().trim();
					Cell cell = sheet.getCell(col, row);
					String value=cell.getContents();
					rows.put(col, value);
					boolean notEmpty = (value!=null) && !(value.equals(""));
					hasValue=(hasValue || notEmpty); 
				}
				if(hasValue) listResult.add(rows);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return listResult;
	}
}
