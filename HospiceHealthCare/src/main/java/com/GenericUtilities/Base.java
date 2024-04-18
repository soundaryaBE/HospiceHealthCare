package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.healthCare.hospiceHealthCare.objectRepository.DoctorLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

public class Base {

	public static WebDriver sdriver;
	
	public WebDriver driver;
	ExcelUtility eUtil=new ExcelUtility();
	DatabaseUtility dUtil = new DatabaseUtility();
	FileUtility fUtil = new FileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	@BeforeSuite(alwaysRun = true)
	    public void connectToDB() throws SQLException
	    {
	    	dUtil.connectToDB();
	    	Reporter.log("DB connected",true);
	    }
	    
	    //@Parameters("BROWSER")
	   
	@BeforeClass(alwaysRun = true)
	    //public void launchBrowser(String BROWSER) throws IOException
	    public void launchBrowser() throws IOException
	    {
	    	String BROWSER=fUtil.readDataFromPropertyFile("browser");
	    	if(BROWSER.equals("chrome"))
	    	{
	    		driver=new ChromeDriver();
	    	}
	    	else if (BROWSER.equals("firefox"))
	    	{
				driver=new FirefoxDriver();
			}
	    	else if (BROWSER.equals("edge")) 
	    	{
				driver=new EdgeDriver();
			}
	    	else if (BROWSER.equals("safari")) 
	    	{
				driver=new SafariDriver();
			}
	    	else
	    	{
	    		Reporter.log("--invalid browser---",true);
	    	}
	    	sdriver=driver;
	    	
	    	wUtil.maximizeWindow(driver);
	    	wUtil.waitForPageLoad(driver, 20);
	    	
	    	    }
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		String URL=fUtil.readDataFromPropertyFile("url");
		 String docemail = eUtil.readDataFromExcel("doctor",2,1);
		 String docpass = eUtil.readDataFromExcel("doctor", 3, 1);
		driver.get(URL);
		HMSPage hmsPage=new HMSPage(driver);
	    hmsPage.loginToDoctor();
	    DoctorLoginPage doctorLoginPage=new DoctorLoginPage(driver);
	    doctorLoginPage.doctorlogin(docemail, docpass);
	    Reporter.log("---logged in to appln---",true);
	}
}
