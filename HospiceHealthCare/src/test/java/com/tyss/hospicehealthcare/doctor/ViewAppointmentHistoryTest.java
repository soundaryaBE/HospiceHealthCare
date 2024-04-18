package com.tyss.hospicehealthcare.doctor;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ViewAppointmentHistoryTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	WebDriver driver;
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HospiceHealthCare.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("doctor");
	String browser = sh.getRow(0).getCell(1).getStringCellValue();
	String url = sh.getRow(1).getCell(1).getStringCellValue();
	String docEmail= sh.getRow(2).getCell(1).getStringCellValue();
	String docPwd = sh.getRow(3).getCell(1).getStringCellValue();
	String patientname = sh.getRow(6).getCell(1).getStringCellValue();
	if(browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}
	driver.get(url);
	
	driver.findElement(By.name("username")).sendKeys(docEmail);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(docPwd);
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//li/a[@href='appointment-history.php']")).click();
	String expURL = "/doctor/appointment-history.php";
String URL=driver.getCurrentUrl();
assertTrue(URL.contains(expURL));
//if(URL.contains("/doctor/appointment-history.php"))
//    {
//	   System.out.println("PASS:appointmenthistory page viewed");
//  }
//else
//{
//	System.out.println("FAIL:appointmenthistory page not viewed");
//}
driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
driver.findElement(By.xpath("//a[@href='logout.php']")).click();
driver.quit();
}
}
