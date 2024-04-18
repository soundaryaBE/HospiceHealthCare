package com.healthCare.hospiceHealthCare.objectRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorViewOppointmentHistoryPage {
@FindBy(xpath = "//li/a[@href='appointment-history.php']")
private WebElement appointmentHistoryLink;


public DoctorViewOppointmentHistoryPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}


public WebElement getAppointmentHistoryLink() {
	return appointmentHistoryLink;
}

public void doctorViewOppointmentHistory(WebDriver driver)
{
	appointmentHistoryLink.click();
	String expURL = "/doctor/appointment-history.php";
	String URL=driver.getCurrentUrl();
	assertTrue(URL.contains(expURL));
//	if(URL.contains("/doctor/appointment-history.php"))
//	    {
//		   System.out.println("PASS:appointmenthistory page viewed");
//	  }
//	else
//	{
//		System.out.println("FAIL:appointmenthistory page not viewed");
//	}
}
}
