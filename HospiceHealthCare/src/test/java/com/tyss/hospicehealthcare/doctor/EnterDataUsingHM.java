package com.tyss.hospicehealthcare.doctor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class EnterDataUsingHM {
public static void main(String[] args) throws IOException {
	WebDriver driver;
	ExcelUtility eUtil=new ExcelUtility();
	FileUtility fUtil=new FileUtility();
	JavaUtility jUtil=new JavaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	String browser = fUtil.readDataFromPropertyFile("browser");
	String url = eUtil.readDataFromExcel("doctor", 1, 1);
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HospiceHealthCare.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("hm");
	int rowCount = sh.getLastRowNum();
	if(browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver, 15);
	driver.get(url);
	HashMap<String, String> map=eUtil.readMultipleData("hm", 0)	;
	for (int i = 0; i <= rowCount; i++) {
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
	}
	for (Entry<String, String> m : map.entrySet()) 
	{
		driver.findElement(By.name(m.getKey())).sendKeys(m.getValue());
		//driver.findElement(By.name(m.getKey()).sendKeys(m.getValue());
				
	
	
	
}
}
}
