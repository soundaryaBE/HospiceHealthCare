package com.tyss.hospicehealthcare.doctor;

import java.io.IOException;

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

public class addPatientUsingUtilityTest {
	@Test
public void addPatientUsingUtilityTest() throws IOException, InterruptedException {
	WebDriver driver;
	ExcelUtility eUtil = new ExcelUtility();
    FileUtility	fUtil = new FileUtility();
    JavaUtility	jUtil=new JavaUtility();
    WebDriverUtility wUtil = new WebDriverUtility();
    String docemail = eUtil.readDataFromExcel("doctor",2,1);
    String docpass = eUtil.readDataFromExcel("doctor", 3, 1);
    String browser = fUtil.readDataFromPropertyFile("browser");
    String patname = eUtil.readDataFromExcel("doctor", 9, 1);
    String contno = eUtil.readDataFromExcel("doctor", 10, 1);
    String email = eUtil.readDataFromExcel("doctor", 11, 1);
    String patgender = eUtil.readDataFromExcel("doctor", 12, 1);
    String patadd = eUtil.readDataFromExcel("doctor", 13, 1);
    String age = eUtil.readDataFromExcel("doctor", 14, 1);
    String medhis = eUtil.readDataFromExcel("doctor", 14, 1);
    String uniqueEmail = jUtil.getUniqueEmail(email);
    String PatientName = patname+jUtil.getRandomNo();
    
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
driver.get(eUtil.readDataFromExcel("doctor", 1, 1));
driver.findElement(By.name("username")).sendKeys(docemail);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(docpass);
Thread.sleep(1000);
driver.findElement(By.name("submit")).click();
driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
driver.findElement(By.xpath("//a[@href='add-patient.php']")).click();
driver.findElement(By.name("patname")).sendKeys(PatientName);
driver.findElement(By.name("patcontact")).sendKeys(contno);
driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")).sendKeys(uniqueEmail);
System.out.println("uniqueEmail="+uniqueEmail);
driver.findElement(By.xpath("//label[@for='rg-female']")).click();
driver.findElement(By.name("pataddress")).sendKeys(patadd);
driver.findElement(By.name("patage")).sendKeys(age);
driver.findElement(By.name("medhis")).sendKeys(medhis);
driver.findElement(By.name("submit")).click();
driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
driver.findElement(By.xpath("//a[@href='manage-patient.php']")).click();
WebElement addedPat = driver.findElement(By.xpath("//td[text()='"+PatientName+"']"));
String actualresu = addedPat.getText();
if(actualresu.contains(PatientName))
{
	System.out.println("PASS:patient added successfully");
}
else
{
	System.out.println("FAIL:patient not added");
}


driver.quit();		

}


	
}

