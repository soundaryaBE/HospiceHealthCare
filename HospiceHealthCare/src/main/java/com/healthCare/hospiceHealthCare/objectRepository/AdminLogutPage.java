package com.healthCare.hospiceHealthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Declaration

public class AdminLogutPage {
@FindBy(xpath = "//span[@class='username']")
private WebElement adminButton;
@FindBy(xpath = "//a[contains(text(),'Log Out')]")
private WebElement logoutButton;


//Initialization

public AdminLogutPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}
//Utilization


public WebElement getAdminButton() {
	return adminButton;
}


public WebElement getLogoutButton() {
	return logoutButton;
}

//Bussiness Libraries

public void logoutAdmin()
{
	adminButton.click();
	logoutButton.click();
	
}

}