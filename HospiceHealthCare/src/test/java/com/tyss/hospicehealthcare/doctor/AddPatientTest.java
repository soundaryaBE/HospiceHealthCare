package com.tyss.hospicehealthcare.doctor;

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

import com.GenericUtilities.JavaUtility;

public class AddPatientTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver;
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HospiceHealthCare.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("doctor");
		String browser = sh.getRow(0).getCell(1).getStringCellValue();
		String url = sh.getRow(1).getCell(1).getStringCellValue();
		String docEmail= sh.getRow(2).getCell(1).getStringCellValue();
		String docPwd = sh.getRow(3).getCell(1).getStringCellValue();
		String patname = sh.getRow(9).getCell(1).getStringCellValue();
		String conno = sh.getRow(10).getCell(1).getStringCellValue();
		String emai= sh.getRow(11).getCell(1).getStringCellValue();
		String gender = sh.getRow(12).getCell(1).getStringCellValue();
		String patadd = sh.getRow(13).getCell(1).getStringCellValue();
		String patage = sh.getRow(14).getCell(1).getStringCellValue();
		String patmedhis= sh.getRow(15).getCell(1).getStringCellValue();
		
		
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(docEmail);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(docPwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(By.xpath("//a[@href='add-patient.php']")).click();
		driver.findElement(By.name("patname")).sendKeys(patname);
		driver.findElement(By.name("patcontact")).sendKeys(conno);
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")).sendKeys(emai);
		driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		driver.findElement(By.name("pataddress")).sendKeys(patadd);
		driver.findElement(By.name("patage")).sendKeys(patage);
		driver.findElement(By.name("medhis")).sendKeys(patmedhis);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(By.xpath("//a[@href='manage-patient.php']")).click();
		WebElement addedPat = driver.findElement(By.xpath("//td[text()='kirubaRani']"));
		String actualresu = addedPat.getText();
		if(actualresu.contains(patname))
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
