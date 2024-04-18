package com.tyss.hospicehealthcare.admin;

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
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class CreateDoctorSpecializationTest {
	@Test
public  void CreateDoctorSpecializationTest() throws EncryptedDocumentException, IOException {
	WebDriver driver;
	ExcelUtility eUtil = new ExcelUtility();
    FileUtility	fUtil = new FileUtility();
    JavaUtility	jUtil=new JavaUtility();
    WebDriverUtility wUtil = new WebDriverUtility();
   String BROWSER = fUtil.readDataFromPropertyFile("browser");
   if(BROWSER.equals("chrome"))
   {
	   driver=new ChromeDriver();
   }
   else
   {
	   driver=new FirefoxDriver();
   }
    wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver, 10);
	String URL = eUtil.readDataFromExcel("admin", 0, 1);
    String username = eUtil.readDataFromExcel("admin", 1, 1);   
    String password = eUtil.readDataFromExcel("admin", 2, 1);
    String specl = eUtil.readDataFromExcel("admin", 3, 1);
    driver.get(URL);
    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.xpath("//div[@class='item-media']/following-sibling::div[@class='item-inner']/span[.=' Doctors ']")).click();
    driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
    driver.findElement(By.name("doctorspecilization")).sendKeys(specl);
    driver.findElement(By.name("submit")).click();
    String expResult = "Doctor Specialization added successfully !!";
    WebElement actualRes = driver.findElement(By.xpath("//p[@style='color:red;']"));
   String actualResult = actualRes.getText();
    if(actualResult.contains(expResult))
    {
    	System.out.println("Pass:Doctor specialization added successfully");
    }
    else
    {
    	System.out.println("Fail:Doctor specialization is not added successfully");
    }
    driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
    driver.findElement(By.xpath("//a[@href='logout.php']")).click();
    
    
    driver.quit();
}
}
