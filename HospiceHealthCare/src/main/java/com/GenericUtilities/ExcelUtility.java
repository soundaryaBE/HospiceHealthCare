package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	String value=sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
	return value;
	
}

public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount=sh.getLastRowNum();
	return rowCount;
}

public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	sh.createRow(rowNo).createCell(cellNo).setCellValue(data);
	FileOutputStream fout=new FileOutputStream(IpathConstant.ExcelPath);
	wb.write(fout);
	wb.close();
}
public HashMap<String, String> readMultipleData(String sheetName,int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount=sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
for (int i = 0; i <=rowCount; i++) {
	String key=sh.getRow(i).getCell(cellNo).getStringCellValue();
	String value=sh.getRow(i).getCell(cellNo+1).getStringCellValue();
	map.put(key, value);
                        }
	return map;
}
}
