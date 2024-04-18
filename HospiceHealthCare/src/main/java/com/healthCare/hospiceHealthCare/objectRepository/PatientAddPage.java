package com.healthCare.hospiceHealthCare.objectRepository;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PatientAddPage {

	@FindBy(xpath="//span[text()=' Patients ']") 
	private WebElement patientsLink;
	@FindBy(xpath="//a[@href='add-patient.php']")
	private WebElement addPatientButton;
	@FindBy(name="patname")private
	WebElement patientNameTF;
	@FindBy(name="patcontact")private
	WebElement contactTF;
	@FindBy(xpath = "//input[@placeholder='Enter Patient Email id']")
	private WebElement patEmailTF;
	@FindBy(xpath = "//label[@for='rg-female']")private
	WebElement gender;
	@FindBy(name="pataddress")private WebElement patADDTf;
	@FindBy(name="patage")private WebElement patAgeTF;
	@FindBy(name="medhis")private WebElement medHistory;
	@FindBy(xpath = "//button[@name='submit']")private WebElement submitButton;
	@FindBy(xpath="//span[text()=' Patients ']")private WebElement patientLink;
	@FindBy(xpath="//a[@href='manage-patient.php']")private
	WebElement managePatientLink;

	public PatientAddPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPatientsLink() {
		return patientsLink;
	}

	public WebElement getAddPatientButton() {
		return addPatientButton;
	}

	public WebElement getPatientNameTF() {
		return patientNameTF;
	}

	public WebElement getContactTF() {
		return contactTF;
	}

	public WebElement getPatEmailTF() {
		return patEmailTF;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getPatADDTf() {
		return patADDTf;
	}

	public WebElement getPatAgeTF() {
		return patAgeTF;
	}

	public WebElement getMedHistory() {
		return medHistory;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getPatientLink() {
		return patientLink;
	}

	public WebElement getManagePatientLink() {
		return managePatientLink;
	}

	public void addPatient(String patname,String contno,String email,String patadd,String age,String medhis,String PatientName,WebDriver driver) throws InterruptedException
	{
		patientsLink.click();
		addPatientButton.click();
		patientNameTF.sendKeys(patname);
		Thread.sleep(1000);
		contactTF.sendKeys(contno);
		patEmailTF.sendKeys(email);
		gender.click();
		patADDTf.sendKeys(patadd);
		patAgeTF.sendKeys(age);
		medHistory.sendKeys(medhis);
		Thread.sleep(1000);
		submitButton.click();
		patientLink.click();
		managePatientLink.click();
		System.out.println("PatientNameb  "+PatientName);
		WebElement addedPat = driver.findElement(By.xpath("//td[text()='"+PatientName+"']"));
		//td[text()='kirubaRani209']

		String actualres =addedPat.getText();
		System.out.println("actualres"+actualres);

		assertTrue(actualres.contains(PatientName));
		//	if(actualres.contains(PatientName))
		//	{
		//		
		//		
		//		System.out.println("PASS:patient added successfully");
		//	}
		//	else
		//	{
		//		System.out.println("FAIL:patient not added");
		//	}
	}

}
