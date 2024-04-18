package com.healthCare.hospiceHealthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
//Declaration
	@FindBy(name = "username")private WebElement usernameTextField;
	@FindBy(name="password")private WebElement passwordTextField;
	@FindBy(name="submit")private WebElement loginButton;
	
	//Initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	public void adminLogin(String username,String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	//
	
}
