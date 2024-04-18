package TestNG;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class SampleTest extends BaseClass {
	@Test(groups="smoke")
public void sampleTest1()
{
	System.out.println("---sampleTest1---");
}
	@Test(groups="smoke")
	public void sampleTest2()
	{
		System.out.println("---sample test2---");
	}
	@Test
	public void sampleTest3()
	{
		System.out.println("---sample test 3---");
	}
}
