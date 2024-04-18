package TestNG;

import org.testng.annotations.Test;

public class DemoTestNgTest {
	
@Test(priority=1,invocationCount = 0)
public void admin()
{
System.out.println("adminExecuted successfully");	
}

@Test(priority=2,dependsOnMethods ="admin")
public void doctor()
{
	System.out.println("doctor Executed successfully");
}
@Test(priority=0)
public void patient()
{
System.out.println("patient Executed successfully");	
}
}
