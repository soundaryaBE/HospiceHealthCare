package TestNG;

import org.testng.annotations.DataProvider;

public class CompleteDataProviderTest {
//@DataProvider(name="orgn")
//public Object[][] data()
//{
//Object[][] obj = new Object[2][3];
//obj[0][0]="Jspider";
//obj[0][1]="chennai";
//obj[0][2]="automation";
//obj[1][0]="Qspiders";
//obj[1][1]="bangalore";
//obj[1][2]="java";
//return obj;
//}

@DataProvider(name="email")
public Object[][] data1()
{
	Object[][] obj = new Object[2][2];
	obj[0][0]="admin";
	obj[0][1]="Test@12345";
	obj[1][0]="kani44@gmail.com";
	obj[1][1]="12345";
	return obj;
			
}

}
