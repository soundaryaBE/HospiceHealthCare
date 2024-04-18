package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.healthCare.hospiceHealthCare.objectRepository.AdminLoginPage;
import com.healthCare.hospiceHealthCare.objectRepository.HMSPage;

public class CompleteReadDataTest {
//@Test(dataProviderClass =CompleteDataProviderTest.class,dataProvider="orgn")
//public void getdata(String inst,String y,String loc)
//{
//	System.out.println("organization--->"+inst+"  "+"location--->"+loc+" "+"course--->"+loc);
//}
	

@Test(dataProviderClass =CompleteDataProviderTest.class,dataProvider="email" )



public void getdata1(String username,String password)
{
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
HMSPage hmsPage=new HMSPage(driver);
hmsPage.loginToModule();
AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
adminLoginPage.adminLogin(username, password);

 }
}
