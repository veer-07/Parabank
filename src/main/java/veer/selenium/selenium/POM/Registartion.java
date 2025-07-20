package veer.selenium.selenium.POM;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import veer.selenium.selenium.Abstracts;

public class Registartion extends Abstracts{
 
public WebDriver driver;
	public Registartion(WebDriver driver) {
		super( );
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'register')]")
	WebElement regi;
	@FindBy(css="input[id='customer.firstName']")
	WebElement Fname;
	@FindBy(css="input[id='customer.lastName']")
	WebElement Lname;
	@FindBy(css="input[id='customer.address.street']")
	WebElement RAddress;
	@FindBy(css="input[id='customer.address.city']")
	WebElement city;
	@FindBy(css="input[id='customer.address.state']")
	WebElement state;
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	WebElement zipcodes;
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	WebElement phones;
	@FindBy (xpath="//input[@id='customer.ssn']")
	WebElement ssn;
	@FindBy(css="input[id='customer.username']")
	WebElement Uname;
	@FindBy(css="input[id='customer.password']")
	WebElement password;
	@FindBy(css="#repeatedPassword")
	WebElement confirm;
	@FindBy(css="input[value='Register']")
	WebElement RegButton;
	@FindBy(css="a[href='logout.htm']")
	WebElement logout;
	@FindBy(xpath="//span[@id=\'customer.username.errors\']")
	WebElement dupName;
	
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now logged in.')]")
	WebElement loginmsg;
	
	

	
	public  void register(String name, String lname,String address,String cities,String states,String zipcode,String phone, String ssns, String uname, String Password,String con) throws InterruptedException, IOException {
//		explicitwait(500);
//		Thread.sleep(1000);
		regi.click();
		Fname.sendKeys(uname);
		Lname.sendKeys(lname);
		RAddress.sendKeys(cities);
		city.sendKeys(cities);
		state.sendKeys(states);
		zipcodes.sendKeys(zipcode);
		phones.sendKeys(phone);
		ssn.sendKeys(ssns);
		Uname.sendKeys(uname);
		password.sendKeys(Password);
		confirm.sendKeys(con);
//		getScreenshot("testcase"+""+Math.random(),driver);
//		Thread.sleep(100);
		RegButton.click();
//		Thread.sleep(100);
	//	String msgs = loginmsg.getText();
	//	System.out.println(msgs);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement loginMessage = wait.until(ExpectedConditions.visibilityOf(loginmsg));
		String msgs = dupName.getText();
		Assert.assertTrue(false, msgs);
		System.out.println(msgs);
		String msg = loginmsg.getText();
			System.out.println(msgs);
		
	}
	
	@FindBy(css="a[href='updateprofile.htm']")
	WebElement updatecontact;
	
	@FindBy(css="input[value='Update Profile']")
	WebElement updatebutton;
	
	@FindBy(css="#rightPanel")
	WebElement updateMessage;
	
public void DuplicateAcc(String name, String lname,String address,String cities,String states,String zipcode,String phone, String ssns, String uname, String Password,String con) throws InterruptedException, IOException {
	 
	
		explicitwait(500);
//		Thread.sleep(1000);
		regi.click();
		Fname.sendKeys(uname);
		Lname.sendKeys(lname);
		RAddress.sendKeys(cities);
		city.sendKeys(cities);
		state.sendKeys(states);
		zipcodes.sendKeys(zipcode);
		phones.sendKeys(phone);
		ssn.sendKeys(ssns);
		Uname.sendKeys(uname);
		password.sendKeys(Password);
		confirm.sendKeys(con);
//		getScreenshot("testcase"+""+Math.random(),driver);
		Thread.sleep(100);
		RegButton.click();
//		
		String msg = dupName.getText();
		boolean isDuplicateShown = msg.contains("already exists");
		Assert.assertFalse(isDuplicateShown, "Duplicate name found: " + msg);
		
		
		
		
	}

}
