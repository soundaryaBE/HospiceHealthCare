package com.healthCare.hospiceHealthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Declaration
public class HMSPage {
@FindBy(xpath = "//a[@href='hms/admin']")
private WebElement adminLoginButton;
@FindBy(xpath = "//a[@href='hms/doctor/']")
private WebElement doctorLoginButton;
@FindBy(xpath = "//a[@href='hms/user-login.php']")
private WebElement patientLoginButton;


//Intialization
 


public HMSPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}

//Utilization
public WebElement getAdminLoginButton() {
	return adminLoginButton;
}


public WebElement getDoctorLoginButton() {
	return doctorLoginButton;
}


public WebElement getPatientLoginButton() {
	return patientLoginButton;
}

//Bussiness Libraries
public void loginToModule()
{
	adminLoginButton.click();
	
}
public void loginToDoctor()
{
	doctorLoginButton.click();
}
public void loginToPatient()
{
	patientLoginButton.click();
}
}
