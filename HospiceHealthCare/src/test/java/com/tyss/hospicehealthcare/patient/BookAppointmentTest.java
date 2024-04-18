package com.tyss.hospicehealthcare.patient;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.DoctorLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;
import com.healthCare.hospiceHealthCare.objectRepository.PatientAddPage;
import com.healthCare.hospiceHealthCare.objectRepository.PatientLoginPage;

public class BookAppointmentTest {
	@Test
public  void BookAppointmentTest() throws EncryptedDocumentException, IOException, InterruptedException {
	WebDriver driver=null;
	DatabaseUtility dUtil=new DatabaseUtility();
	ExcelUtility eUtil=new ExcelUtility();
	JavaUtility jUtil=new JavaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();

//	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HospiceHealthCare.xlsx");
//	Workbook wb = WorkbookFactory.create(fis);
//	Sheet sh = wb.getSheet("patient");
	String EMAIL=eUtil.readDataFromExcel("doctor", 2, 1);
	String PASSWORD=eUtil.readDataFromExcel("doctor", 3, 1);
    String browser = eUtil.readDataFromExcel("patient", 0, 1);
////			sh.getRow(0).getCell(1).getStringCellValue();
//	String url =eUtil.readDataFromExcel("patient", 1, 1);
//			sh.getRow(1).getCell(1).getStringCellValue();
	String fullname = eUtil.readDataFromExcel("patient", 2, 1);
//			sh.getRow(2).getCell(1).getStringCellValue();
	String address =eUtil.readDataFromExcel("patient", 3, 1);
//			sh.getRow(3).getCell(1).getStringCellValue();
	String city= eUtil.readDataFromExcel("patient", 4, 1);
//			sh.getRow(4).getCell(1).getStringCellValue();
	String gender =eUtil.readDataFromExcel("patient", 5, 1); 
//			sh.getRow(5).getCell(1).getStringCellValue();
	String email = eUtil.readDataFromExcel("patient", 6, 1);
//			sh.getRow(6).getCell(1).getStringCellValue();
	String password = eUtil.readDataFromExcel("patient", 7, 1);
//			sh.getRow(7).getCell(1).getStringCellValue();
	String docspec =eUtil.readDataFromExcel("patient", 8, 1); 
//			sh.getRow(8).getCell(1).getStringCellValue();
	String doctors = eUtil.readDataFromExcel("patient", 9, 1);
//			sh.getRow(9).getCell(1).getStringCellValue();
	String date = eUtil.readDataFromExcel("patient", 10, 1);
//			sh.getRow(10).getCell(1).getStringCellValue();
	String time = eUtil.readDataFromExcel("patient", 11, 1);
//			sh.getRow(11).getCell(1).getStringCellValue();
	String expResult =eUtil.readDataFromExcel("patient", 12, 1);
//			sh.getRow(12).getCell(1).getStringCellValue();
	
		
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else
	{
		driver=new FirefoxDriver();
	}

	wUtil.maximizeWindow(driver);
    driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
    wUtil.waitForPageLoad(driver, 20);
	HMSPage hmsPage=new HMSPage(driver);
	hmsPage.loginToDoctor();
	DoctorLoginPage doctorLoginPage=new DoctorLoginPage(driver);
	doctorLoginPage.doctorlogin(EMAIL, PASSWORD);
//	PatientLoginPage patientLoginPage=new PatientLoginPage(driver);
//	patientLoginPage.doctorlogin(email, password);
    PatientAddPage addpaPatientAddPage=new PatientAddPage(driver);
	addpaPatientAddPage.addPatient(docspec, doctors, email, date, gender, time, expResult, driver);
//	driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
//	driver.findElement(By.xpath("//a[@href='registration.php']")).click();
//	driver.findElement(By.name("full_name")).sendKeys(fullname);
//	driver.findElement(By.name("address")).sendKeys(address);
//	driver.findElement(By.name("city")).sendKeys(city);
//	driver.findElement(By.xpath("//label[@for='rg-female']")).click();
//	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
//	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//	driver.findElement(By.xpath("//input[@placeholder='Password Again']")).sendKeys(password);
//	driver.findElement(By.xpath("//label[@for='agree']")).click();
//	driver.findElement(By.xpath("//button[@name='submit']")).click();
//	driver.switchTo().alert().accept();
//	driver.findElement(By.xpath("//a[@href='user-login.php']")).click();
//	driver.findElement(By.name("username")).sendKeys(email);
//	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//	driver.findElement(By.name("submit")).click();
//	
//	driver.findElement(By.xpath("//span[text()=' Book Appointment '] ")).click();
//	WebElement docSelectDD = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
//	Select Docselect = new Select(docSelectDD);
//	Docselect.selectByValue(docspec);
//	driver.findElement(By.xpath("//input[@name='appdate']")).sendKeys(date);
//	driver.findElement(By.name("apptime")).sendKeys(time);
//	driver.findElement(By.xpath("//button[@class='btn btn-o btn-primary']")).click();
//	String actualresult = driver.switchTo().alert().getText();
//	driver.switchTo().alert().accept();
//	if(actualresult.contains(expResult))
//	{
//		System.out.println("PASS:Your appointment successfully booked");
//	}
//	else
//	{
//		System.out.println("FAIL:Your appointment not booked");
//	}
//	driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
//	driver.findElement(By.xpath("//a[@href='logout.php']")).click();

	driver.quit();
	
}
}
