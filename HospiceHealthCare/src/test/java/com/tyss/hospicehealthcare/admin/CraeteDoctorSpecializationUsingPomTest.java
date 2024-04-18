package com.tyss.hospicehealthcare.admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.AdminAddDoctorPage;
import com.healthCare.hospiceHealthCare.objectRepository.AdminDoctorSpecializationPage;
import com.healthCare.hospiceHealthCare.objectRepository.AdminLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.AdminLogutPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

//@Listeners(com.GenericUtilities.ListenersImplementationClass.class)

public class CraeteDoctorSpecializationUsingPomTest extends BaseClass {
	@Test(retryAnalyzer = com.GenericUtilities.RetryImplementationClass.class)
	public  void CraeteDoctorSpecializationUsingPomTest() throws IOException {
	//WebDriver driver=null;
	String SPCL=eUtil.readDataFromExcel("admin", 3, 1);
    String aCTUALRESULT=eUtil.readDataFromExcel("admin", 12, 1);
//    if(BROWSER.equals("chrome"))
//    {
// 	   driver=new ChromeDriver();
//    }
//    else
//    {
// 	   driver=new FirefoxDriver();
//    }
//    wUtil.maximizeWindow(driver);
//   wUtil.waitForPageLoad(driver, 15);
//   driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
//    HMSPage hmsPage=new HMSPage(driver);
//    hmsPage.loginToModule();
//    AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
//    adminLoginPage.adminLogin(USERNAME, PASSWORD);
    
    AdminDoctorSpecializationPage adminDoctorSpecializationPage=new AdminDoctorSpecializationPage(driver);
    adminDoctorSpecializationPage.createSpecialization(SPCL, aCTUALRESULT);
      //    driver.quit();
    
    }
}