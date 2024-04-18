package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.AdminAddDoctorPage;
import com.healthCare.hospiceHealthCare.objectRepository.AdminDoctorSpecializationPage;
import com.healthCare.hospiceHealthCare.objectRepository.AdminLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

public class AddDoctorTest extends BaseClass {
	@Test(groups = "regression")
	public  void AddDoctorTest() throws EncryptedDocumentException, IOException   {
				  
		  String SPECL = eUtil.readDataFromExcel("admin", 3, 1);
		  String DOCNAME = eUtil.readDataFromExcel("admin", 4, 1);
		  String DOCCLIADD = eUtil.readDataFromExcel("admin", 5, 1);
		  String DOCCONFEE = eUtil.readDataFromExcel("admin", 6, 1);
		  String DOCCONNUM=eUtil.readDataFromExcel("admin", 7, 1);
		  String DOCEMAIL = eUtil.readDataFromExcel("admin", 8, 1);
		  String DOCNEWPD = eUtil.readDataFromExcel("admin", 9, 1);
		  String DOCCNFPD = eUtil.readDataFromExcel("admin", 10, 1);
//		  String ACTRESULT = eUtil.readDataFromExcel("admin", 11, 1);
//		  String mail = jUtil.getUniqueEmail(DOCEMAIL);
		 
		 
		 
		 
//		 Workbook wb = WorkbookFactory.create(fis);
//		    Sheet sheet = wb.getSheet("admin");
//		    String url = sheet.getRow(0).getCell(1).getStringCellValue();
//		    String username = sheet.getRow(1).getCell(1).getStringCellValue();
//		    String password = sheet.getRow(2).getCell(1).getStringCellValue();
//		    String specl = sheet.getRow(3).getCell(1).getStringCellValue();
//		    String docname = sheet.getRow(4).getCell(1).getStringCellValue();
//		    String docCliAdd = sheet.getRow(5).getCell(1).getStringCellValue();
//		    String docConFee = sheet.getRow(6).getCell(1).getStringCellValue();
//		    String docConNum = sheet.getRow(7).getCell(1).getStringCellValue();
//		    String docemail = sheet.getRow(8).getCell(1).getStringCellValue();
//		    String docNewPD = sheet.getRow(9).getCell(1).getStringCellValue();
//		    String docCnfPD = sheet.getRow(10).getCell(1).getStringCellValue();
//		    String actualResult = sheet.getRow(11).getCell(1).getStringCellValue();
//		    driver.get(url);
//		    driver.findElement(By.name("username")).sendKeys(USERNAME);
//		  HMSPage hMSPage = new HMSPage(driver);
//		  hMSPage.loginToModule();
//		  AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
//		  adminLoginPage.adminLogin(USERNAME, PASSWORD);
		  AdminAddDoctorPage adminAddDoctorPage=new AdminAddDoctorPage(driver);
		  adminAddDoctorPage.addDoctor(driver, SPECL, DOCNAME, DOCCLIADD, DOCCONFEE, DOCCONNUM, DOCEMAIL, DOCNEWPD, DOCCNFPD);	
		  
		  
		 
//		    driver.findElement(By.name("password")).sendKeys(PASSWORD);
//		    driver.findElement(By.name("submit")).click();
//		    driver.findElement(By.xpath("//div[@class='item-media']/following-sibling::div[@class='item-inner']/span[.=' Doctors ']")).click();
//		    driver.findElement(By.xpath("//span[.=' Add Doctor']")).click();
//		    WebElement DocSpec = driver.findElement(By.xpath("//div[@class='form-group']/select[@name='Doctorspecialization']"));
//		    wUtil.selectByValue(driver, DocSpec,SPECL );
//		     Select DocSelect = new Select(DocSpec);
//		     DocSelect.selectByValue(SPECL)
//		     driver.findElement(By.name("docname")).sendKeys(DOCNAME+jUtil.getRandomNo());
//		     driver.findElement(By.name("clinicaddress")).sendKeys(DOCCLIADD);
//		     driver.findElement(By.name("docfees")).sendKeys(DOCCONFEE);
//		     driver.findElement(By.name("doccontact")).sendKeys(DOCCONNUM);
//		     driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Email id']")).sendKeys(mail);
//		     driver.findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys(DOCNEWPD);
//		     driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(DOCCNFPD);
//		     driver.findElement(By.xpath("//button[@type='submit']")).click();
//		     String expResult = wUtil.getAlertText(driver);
	//     String expResult=driver.switchTo().alert().getText();
  //   wUtil.acceptAlert(driver);
//		     //driver.switchTo().alert().accept();
//		     if(ACTRESULT.contains(expResult))
//		     {
//		    	 System.out.println("PASS:doctor info added successfully");
//		     }
//	     else
//		     {
//		    	 System.out.println("FAIL:doctor info not added");
//		     }
//		     driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
//		     driver.findElement(By.xpath("//a[@href='logout.php']")).click();
//		     
//		      driver.quit(); 
		      }
	
	@Test(groups = "smoke")
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