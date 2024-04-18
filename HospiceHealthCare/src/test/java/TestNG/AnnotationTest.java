package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest {
@Test
public void oneTest()
{
	System.out.println("Test1");
}
@Test
public void twoTet()
{
	System.out.println("Test2");
}
@BeforeSuite
public void bs_1()
{
	System.out.println("beforeSuite1");
}
@AfterSuite
public void as_1()
{
	System.out.println("afterSuite1");
}
@BeforeSuite
public void bs_2()
{
	System.out.println("beforeSuie2");
}
@AfterSuite
public void as_2()
{
	System.out.println("afterSuite2");
}
@BeforeClass
public void bc()
{
	System.out.println("launchBrowser1");
}
@AfterClass
public void ac()
{
	System.out.println("closeBrowser1");
}
@BeforeClass
public void ac2()
{
	System.out.println("launch browser2");
}
@AfterClass
public void bf2()
{
	System.out.println("closeBrowser2");
}
@BeforeMethod
public void bm()
{
	System.out.println("login1");
}
@AfterMethod
public void am()
{
	System.out.println("logout1");
}
@BeforeMethod
public void bm1()
{
	System.out.println("login2");
}
@AfterMethod
public void am1()
{
	System.out.println("logout2");
}
}
