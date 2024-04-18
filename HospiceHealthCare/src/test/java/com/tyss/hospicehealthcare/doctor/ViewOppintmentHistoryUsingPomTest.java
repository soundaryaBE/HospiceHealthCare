package com.tyss.hospicehealthcare.doctor;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.DoctorLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.DoctorLogoutPage;
import com.healthCare.hospiceHealthCare.objectRepository.DoctorViewOppointmentHistoryPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

public class ViewOppintmentHistoryUsingPomTest {
	@Test
public  void ViewOppintmentHistoryUsingPomTest() throws EncryptedDocumentException, IOException {
	WebDriver driver;
	DatabaseUtility dUtil=new DatabaseUtility();
	ExcelUtility eUtil=new ExcelUtility();
	JavaUtility jUtil=new JavaUtility();
	String browser = eUtil.readDataFromExcel("doctor", 0, 1);
	WebDriverUtility wUtil=new WebDriverUtility();
	//String url = eUtil.readDataFromExcel(browser, 1, 1);
	String docEmail = eUtil.readDataFromExcel("doctor", 2, 1);
//	//String doctorEmail = jUtil.getUniqueEmail(docEmail);
    String docPwd = eUtil.readDataFromExcel("doctor", 3, 1);
//	String updateConFee = eUtil.readDataFromExcel("doctor", 5, 1);
//  String UPDATEFEE  = updateConFee+jUtil.getRandomNo();
//  String expResult = eUtil.readDataFromExcel("doctor", 4, 1);
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
	driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
	HMSPage hmsPage=new HMSPage(driver);
	hmsPage.loginToDoctor();
	DoctorLoginPage doctorLoginPage=new DoctorLoginPage(driver);
	doctorLoginPage.doctorlogin(docEmail, docPwd);
	DoctorViewOppointmentHistoryPage doctorViewOppointmentHistoryPage=new DoctorViewOppointmentHistoryPage(driver);
	doctorViewOppointmentHistoryPage.doctorViewOppointmentHistory(driver);
	DoctorLogoutPage doctorLogoutPage=new DoctorLogoutPage(driver);
	doctorLogoutPage.doctorLogout();
	driver.quit();
}
}
