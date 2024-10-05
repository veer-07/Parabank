package veer.selenium.selenium.POM;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veer.selenium.selenium.Abstracts;

public class Registartion extends Abstracts{
 
public WebDriver driver;
	public Registartion(WebDriver driver) {
		super(driver);
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
	
	
//	Scanner sc=new Scanner(System.in);
//	System.out.print("Enter the values");
//	String v=sc.next();
	String name="Jack";
	String lname="sparrow";
	String address="Yoyo colony";
	String cities="Veeerapur";
	String states="Karnataka";
	String zipcode="zipcode";
	String phone="007";
	String ssns="378";
	String urname="Veeran";
	String passwords="1234*";
//	public void name(String fname,String lname) {
//		Fname.sendKeys(fname);
//		Lname.sendKeys(lname);
//	}
//	
//	public void name(String fname,String lname) {
//		
//	}
	
	public  void register() throws InterruptedException {
		explicitwait(500);
		Thread.sleep(1000);
		regi.click();
		Fname.sendKeys(name);
		Lname.sendKeys(lname);
		RAddress.sendKeys(cities);
		city.sendKeys(cities);
		state.sendKeys(states);
		zipcodes.sendKeys(zipcode);
		phones.sendKeys(phone);
		ssn.sendKeys(ssns);
		Uname.sendKeys(urname);
		confirm.sendKeys(urname);
		password.sendKeys(passwords);
		
	}
	
	@FindBy(css="a[href='updateprofile.htm']")
	WebElement updatecontact;
	@FindBy(css="input[value='Update Profile']")
	WebElement updatebutton;
	
	@FindBy(css="#rightPanel")
	WebElement updateMessage;
public void updateContact() throws InterruptedException {
	updatecontact.click();
	Fname.sendKeys(name);
	Lname.sendKeys(lname);
	RAddress.sendKeys(cities);
	city.sendKeys(cities);
	state.sendKeys(states);
	zipcodes.sendKeys(zipcode);
	phones.sendKeys(phone);
	updatebutton.click();
	Thread.sleep(1000);
	System.out.println(updateMessage.getText());
	
		
		
		
		
	}

}
