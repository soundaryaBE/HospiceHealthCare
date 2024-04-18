package com.healthCare.hospiceHealthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLogoutPage {
@FindBy(xpath = "//i[@class='ti-angle-down']")private
WebElement doctorLink;
@FindBy(xpath="//a[@href='logout.php']")private
WebElement logoutlink;


public DoctorLogoutPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}


public WebElement getDoctorLink() {
	return doctorLink;
}


public WebElement getLogoutlink() {
	return logoutlink;
}

public void doctorLogout()
{
	doctorLink.click();
	logoutlink.click();
}

}