package com.healthCare.hospiceHealthCare.objectRepository;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class EditDoctorDetailsPage {
@FindBy(xpath="//a[@href='edit-profile.php']/parent::p[@class='links cl-effect-1']")
private WebElement editProfileLink;
@FindBy(name="docfees")private
WebElement consulFeeTF;
@FindBy(xpath="//button[@name='submit']")private
WebElement submitButton;
@FindBy(xpath = "//i[@class='ti-angle-down']")private WebElement
doctorButton;
@FindBy(xpath = "//a[@href='logout.php']")private WebElement
logoutLink;


public EditDoctorDetailsPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}


public WebElement getEditProfileLink() {
	return editProfileLink;
}


public WebElement getConsulFeeTF() {
	return consulFeeTF;
}


public WebElement getSubmitButton() {
	return submitButton;
}

public void editDoctorDetail(String UPDATEFEE,WebDriver driver,String expResult)
{
	WebDriverUtility wUtil=new WebDriverUtility();
	editProfileLink.click();
	consulFeeTF.clear();
	consulFeeTF.sendKeys(UPDATEFEE);
	submitButton.click();
	String actualResult = wUtil.getAlertText(driver);
	wUtil.acceptAlert(driver);
	assertTrue(actualResult.contains(expResult));
//	if(actualResult.contains(expResult))
//	{
//		System.out.println("PASS:Doctor Details updated Successfully");
//	}
//	else
//	{
//		System.out.println("FAIL:Doctor Details not updated");
//	}

	doctorButton.click();
	logoutLink.click();
	
}

}
