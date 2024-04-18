package TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	@Test
	public void assertion1()
	{
		String a="hello";
		String b="helo";
		assertEquals(a, b, "both should be same");
		System.out.println("both same");
		
	}
	@Test
	public void charAssert()
	{
		char a = 'a';
		char b = 'b';
		assertNotEquals(a, b);
		System.out.println("both r not equal");
	}
	@Test
	public void softAssert()
	{
		SoftAssert sa = new SoftAssert();
		int a=10;
		int b=20;
		sa.assertEquals(a, b);
		System.out.println("both not equal");
		sa.assertAll();
	}
	
	@Test
	public void assert2()
	{
		String a=null;
		String b=null;
		assertNull(a,b );
		
}
	@Test
	public void verifyTitle()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		String expRes="Facebook – log in or sign up";
		String actualRes = driver.getTitle();
		//System.out.println(actualRes);
		assertEquals(actualRes, expRes);
	}
}
