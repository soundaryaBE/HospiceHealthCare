package com.tyss.hospicehealthcare.doctor;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.DoctorLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.EditDoctorDetailsPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

public class EditDoctorProfileUsingPomTest {
	@Test
public void EditDoctorProfileUsingPomTest() throws EncryptedDocumentException, IOException, InterruptedException {
	WebDriver driver;
	DatabaseUtility dUtil=new DatabaseUtility();
	ExcelUtility eUtil=new ExcelUtility();
	FileUtility fUtil=new FileUtility();
	JavaUtility jUtil=new JavaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	String browser = eUtil.readDataFromExcel("doctor", 0, 1);
	//String url = eUtil.readDataFromExcel(browser, 1, 1);
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
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver, 10);
	driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
	HMSPage hmsPage=new HMSPage(driver);
	hmsPage.loginToDoctor();
	DoctorLoginPage doctorLoginPage=new DoctorLoginPage(driver);
	doctorLoginPage.doctorlogin(docEmail, docPwd);
	Thread.sleep(2000);
	
	EditDoctorDetailsPage editDoctorDetailsPage=new EditDoctorDetailsPage(driver);
			editDoctorDetailsPage.editDoctorDetail(UPDATEFEE, driver, expResult);
			
	
}
}
