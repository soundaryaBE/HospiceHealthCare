package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.healthCare.hospiceHealthCare.objectRepository.AdminLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.AdminLogutPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;


public class BaseClass {
	public DatabaseUtility dUtil=new DatabaseUtility();
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil=new JavaUtility();
    public WebDriver driver;
    public static WebDriver sdriver;
    
    
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
    @BeforeMethod(alwaysRun = true)
	public void login() throws IOException
	{
		String URL=fUtil.readDataFromPropertyFile("url");
		String USERNAME=fUtil.readDataFromPropertyFile("username");
		String PASSWORD=fUtil.readDataFromPropertyFile("password");
		driver.get(URL);
		HMSPage hmsPage=new HMSPage(driver);
		hmsPage.loginToModule();
		AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
		adminLoginPage.adminLogin(USERNAME, PASSWORD);
		Reporter.log("---logged in to appln---",true);
	}
    @AfterMethod(alwaysRun = true)
    public void logoutFromAppl()
    {
    	AdminLogutPage adminLogutPage=new AdminLogutPage(driver);
    	adminLogutPage.getLogoutButton();
    	Reporter.log("---logged out successfully---",true);
    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser()
    {
    	driver.quit();
    	Reporter.log("---close the driver--",true);
    }
  @AfterSuite(alwaysRun = true)
  public void closeDB() throws SQLException
  {
	  dUtil.closeDB();
	  Reporter.log("---DB Closed---",true);
  }

}

