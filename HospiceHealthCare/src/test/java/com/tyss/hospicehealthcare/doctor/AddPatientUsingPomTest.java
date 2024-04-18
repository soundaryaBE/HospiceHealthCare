package com.tyss.hospicehealthcare.doctor;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.Base;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.DoctorLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;
import com.healthCare.hospiceHealthCare.objectRepository.PatientAddPage;
@Listeners(com.GenericUtilities.ListenersImplementationClass.class)
public class AddPatientUsingPomTest extends Base {
//	WebDriver driver;
	@Test//(retryAnalyzer = com.GenericUtilities.RetryImplementationClass.class)
	public  void AddPatientUsingPomTest() throws IOException, InterruptedException {
//		DatabaseUtility dUtil=new DatabaseUtility();

		FileUtility fUtil=new FileUtility();
		ExcelUtility eUtil=new ExcelUtility();
//		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
//		String url=fUtil.readDataFromPropertyFile("url");
		//	    String docemail = eUtil.readDataFromExcel("doctor",2,1);
		//    String docpass = eUtil.readDataFromExcel("doctor", 3, 1);
		String patname = eUtil.readDataFromExcel("doctor", 9, 1);
		String contno = eUtil.readDataFromExcel("doctor", 10, 1);
		String email = eUtil.readDataFromExcel("doctor", 11, 1);
//		String patgender = eUtil.readDataFromExcel("doctor", 12, 1);
		String patadd = eUtil.readDataFromExcel("doctor", 13, 1);
		String age = eUtil.readDataFromExcel("doctor", 14, 1);
		String medhis = eUtil.readDataFromExcel("doctor", 15, 1);
		String uniqueEmail = jUtil.getUniqueEmail(email);
		String PatientName = patname+jUtil.getRandomNo();

		//    driver=new ChromeDriver();
		//   wUtil.maximizeWindow(driver);
		//    driver.get(url);
		//  wUtil.waitForPageLoad(driver, 20);
		//    HMSPage hmsPage=new HMSPage(driver);
		//    hmsPage.loginToDoctor();
		//   DoctorLoginPage doctorLoginPage=new DoctorLoginPage(driver);
		//   doctorLoginPage.doctorlogin(docemail, docpass);
		Thread.sleep(1000);
		//  
		PatientAddPage patientaddpage=new PatientAddPage(driver);
		patientaddpage.addPatient(PatientName, contno, uniqueEmail, patadd, age, medhis, PatientName, driver);

		driver.quit();

	} 
}
