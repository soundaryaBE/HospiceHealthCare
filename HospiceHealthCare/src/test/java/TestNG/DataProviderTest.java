package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "data")
	public void getData(String org,String loc,String course)
	{
		System.out.println("organization---->"+org+"location---->"+loc+"course---->"+course);
	}
	
	@DataProvider
public Object[][] data()
{
	Object[][] obj = new Object[2][3];
	obj[0][0]="Qspiders";
	obj[0][1]="bangalore";
	obj[0][2]="manual";
	
	obj[1][0]="jspider";
	obj[1][1]="mysore";
	obj[1][2]="java";
	return obj;
}
}
