package com.healthCare.hospiceHealthCare.objectRepository;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class AdminAddDoctorPage {
 //Declaration
	
	@FindBy(xpath = "//div[@class='item-media']/following-sibling::div[@class='item-inner']/span[.=' Doctors ']") 
	private WebElement doctorsDropDownButton;
	@FindBy(xpath = "//span[.=' Add Doctor']")
	private WebElement addDoctorButton;
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement doctorSpecializationButton;
	@FindBy(name="docname")
	private WebElement doctonameTF;
	@FindBy(name="clinicaddress")
	private WebElement clinicAddress;
	@FindBy(name="docfees")private WebElement doctorFee;
	@FindBy(name="doccontact")
	private WebElement docContact;
	@FindBy(xpath = "//input[@placeholder='Enter Doctor Email id']")
	private WebElement docEmail;
	@FindBy(xpath = "//input[@placeholder='New Password']")private 
	WebElement docNewPwd;
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement docConfPwd;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	@FindBy(xpath = "//i[@class='ti-angle-down']")private
	WebElement adminLink;
	@FindBy(xpath = "//a[@href='logout.php']")private
	WebElement logoutLink;
	
	//Initialization

	public AdminAddDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//utilization
	public WebElement getDoctorsDropDownButton() {
		return doctorsDropDownButton;
	}


	public WebElement getAddDoctorButton() {
		return addDoctorButton;
	}


	public WebElement getDoctoeSpecializationButton() {
		return doctorSpecializationButton;
	}


	public WebElement getDoctonameTF() {
		return doctonameTF;
	}


	public WebElement getClinicAddress() {
		return clinicAddress;
	}


	public WebElement getDoctorFee() {
		return doctorFee;
	}


	public WebElement getDocContact() {
		return docContact;
	}


	public WebElement getDocEmail() {
		return docEmail;
	}


	public WebElement getDocNewPwd() {
		return docNewPwd;
	}


	public WebElement getDocConfPwd() {
		return docConfPwd;
	}


	public WebElement getSubmit() {
		return submit;
	}
    //Business Libraries
	public void addDoctor(WebDriver driver, String spcl,String docname,String docCliAdd,String docConFee,String docConNum,String docemail,String docNewPD,String docCnfPD ) throws EncryptedDocumentException, IOException
	{
		doctorsDropDownButton.click();
		addDoctorButton.click();
		doctorSpecializationButton.click();
		WebDriverUtility wUtil=new WebDriverUtility();
		ExcelUtility eUtil = new ExcelUtility();
		JavaUtility	jUtil=new JavaUtility();
		String SPECL = eUtil.readDataFromExcel("admin", 3, 1);
		 String DOCEMAIL = eUtil.readDataFromExcel("admin", 8, 1);
		String mail = jUtil.getUniqueEmail(DOCEMAIL);
		String ACTRESULT = eUtil.readDataFromExcel("admin", 11, 1);
		wUtil.selectByValue(driver, doctorSpecializationButton,SPECL);
	
		doctonameTF.sendKeys(docname);
		clinicAddress.sendKeys(docCliAdd);
		doctorFee.sendKeys(docConFee);
		docContact.sendKeys(docConNum);
		docEmail.sendKeys(mail);
		docNewPwd.sendKeys(docNewPD);
		docConfPwd.sendKeys(docCnfPD);
		submit.click();
		
		String expResult = wUtil.getAlertText(driver);
		wUtil.acceptAlert(driver);
		assertTrue(ACTRESULT.contains(expResult));
//		 if(ACTRESULT.contains(expResult))
//	     {
//	    	 System.out.println("PASS:doctor info added successfully");
//	     }
//     else
//	     {
//	    	 System.out.println("FAIL:doctor info not added");
//	     }
//
		adminLink.click();
		logoutLink.click();
		
	}
	
	
	//Declaration
	

	}

