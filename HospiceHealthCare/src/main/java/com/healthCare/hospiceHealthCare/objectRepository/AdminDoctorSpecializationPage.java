package com.healthCare.hospiceHealthCare.objectRepository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GenericUtilities.ExcelUtility;

public class AdminDoctorSpecializationPage {
//Declaration
	@FindBy(xpath = "//span[text()= ' Doctors ']")
	private WebElement Doctorbutton;
	@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
	private WebElement doctorSpecializationButton;
	@FindBy(name ="doctorspecilization")private
	WebElement specializationTextField;
	@FindBy(name="submit")private WebElement submitButton;
	@FindBy(xpath="//p[@style='color:red;']")private
	WebElement actualRes;
	
	//Initialization
	public AdminDoctorSpecializationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	
	public WebElement getDoctorbutton() {
		return Doctorbutton;
	}







	public WebElement getDoctorSpecializationButton() {
		return doctorSpecializationButton;
	}







	public WebElement getSpecializationTextField() {
		return specializationTextField;
	}







	public WebElement getSubmitButton() {
		return submitButton;
	}







	public WebElement getActualRes() {
		return actualRes;
	}







	//bussiness Libraries
	public void createSpecialization(String specl,String actualResult ) throws EncryptedDocumentException, IOException
	{
		ExcelUtility eUtil=new ExcelUtility();
//		String specl1 = eUtil.readDataFromExcel(specl, 3, 1);
		Doctorbutton.click();
		doctorSpecializationButton.click();
		specializationTextField.sendKeys(specl);
		submitButton.click();
		
		String expResult = "Doctor Specialization added successfully !!";
	//	Assert.fail();
		assertTrue(actualResult.contains(expResult));
		System.out.println("all done");
		
		
//		if(actualResult.contains(expResult))
//	    {
//	    	System.out.println("Pass:Doctor specialization added successfully");
//	    }
//	    else
//	    {
//	    	System.out.println("Fail:Doctor specialization is not added successfully");
//	    }
		
		
		
	}
	
	
}
