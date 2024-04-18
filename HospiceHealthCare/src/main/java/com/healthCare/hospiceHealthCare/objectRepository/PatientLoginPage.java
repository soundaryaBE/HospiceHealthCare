package com.healthCare.hospiceHealthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	@FindBy(name="username")private WebElement
	patientEmailTF;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordTF;
	@FindBy(name="submit")private WebElement loginButton;


	public PatientLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getDoctorEmailTF() {
		return patientEmailTF;
	}


	public WebElement getPasswordTF() {
		return passwordTF;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}

	public void doctorlogin(String docEmail,String docPwd)
	{
		patientEmailTF.sendKeys(docEmail);
		passwordTF.sendKeys(docPwd);
		loginButton.click();
	}
	
}
