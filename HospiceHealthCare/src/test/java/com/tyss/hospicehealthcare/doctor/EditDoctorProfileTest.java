package com.tyss.hospicehealthcare.doctor;

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

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;

public class EditDoctorProfileTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver;
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HospiceHealthCare.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("doctor");
//		String browser = sh.getRow(0).getCell(1).getStringCellValue();
//		String url = sh.getRow(1).getCell(1).getStringCellValue();
//		String docEmail= sh.getRow(2).getCell(1).getStringCellValue();
//		String docPwd = sh.getRow(3).getCell(1).getStringCellValue();
//		String expResult = sh.getRow(4).getCell(1).getStringCellValue();
//		String updateConFee = sh.getRow(5).getCell(1).getStringCellValue();
		DatabaseUtility dUtil=new DatabaseUtility();
		ExcelUtility eUtil=new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		String browser = eUtil.readDataFromExcel("doctor", 0, 1);
		String url = eUtil.readDataFromExcel(browser, 1, 1);
		String docEmail = eUtil.readDataFromExcel("doctor", 2, 1);
		//String doctorEmail = jUtil.getUniqueEmail(docEmail);
		String docPwd = eUtil.readDataFromExcel("doctor", 3, 1);
		String updateConFee = eUtil.readDataFromExcel("doctor", 5, 1);
	  String UPDATEFEE  = updateConFee+jUtil.getRandomNo();
	  String expResult = eUtil.readDataFromExcel("doctor", 4, 1);
		if(browser.equals("chrome"))
			
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(docEmail);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(docPwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//p[@class='links cl-effect-1']/a[@href=\"edit-profile.php\"]")).click();
		WebElement consulFee =driver.findElement(By.name("docfees"));
		consulFee.clear();
		consulFee.sendKeys(UPDATEFEE);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		String actualResult = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(actualResult.contains(expResult))
		{
			System.out.println("PASS:Doctor Details updated Successfully");
		}
		else
		{
			System.out.println("FAIL:Doctor Details not updated");
		}
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		driver.quit();
	}
	

}
