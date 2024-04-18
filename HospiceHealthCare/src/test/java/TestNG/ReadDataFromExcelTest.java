package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.WebDriverUtility;
import com.healthCare.hospiceHealthCare.objectRepository.AdminLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

public class ReadDataFromExcelTest {
@Test(dataProviderClass = DPTest.class,dataProvider = "readDataFromExcel")
public void getData(String username,String password)
{
	WebDriver driver=new ChromeDriver(); 
	WebDriverUtility wUtil=new WebDriverUtility();
	wUtil.maximizeWindow(driver);
	driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
	wUtil.waitForPageLoad(driver, 10);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	HMSPage hmsPage=new HMSPage(driver);
	hmsPage.loginToModule();
	AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
	adminLoginPage.adminLogin(username, password);
	
}
}
