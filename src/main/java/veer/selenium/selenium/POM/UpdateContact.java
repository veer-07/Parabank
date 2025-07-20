package veer.selenium.selenium.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import veer.selenium.selenium.Abstracts;

public class UpdateContact extends Abstracts{
	
	public WebDriver driver;

	public UpdateContact(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	@FindBy(xpath="//a[text()='Update Contact Info']")
	WebElement uContactButton;
	
	@FindBy(css="form[name='contact']")
	List<WebElement> UpdateProfileData;
	
	@FindBy(id="customer.firstName")
	WebElement cFirstname;
	
	@FindBy(id="customer.lastName")
	WebElement cLastname;
	
	@FindBy(id="customer.address.street")
	WebElement cAddress;
	
	@FindBy(id="customer.address.city")
	WebElement cCity;
	
	@FindBy(id="customer.address.state")
	WebElement cState;
	
	@FindBy(id="customer.address.zipCode")
	WebElement cZipCode;
	
	@FindBy(id="customer.phoneNumber")
	WebElement cPhone;
	 
	@FindBy(css="input[value='Update Profile']")
	WebElement UpdateButton;
	
	@FindBy(xpath="//p[contains(text(),'Your updated address and phone number have been ad')]")
	WebElement UpdatedAssert;
	
	
public void updateFirstname(String Name) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+ cFirstname.getText() );
	
	cFirstname.sendKeys(Name);
	UpdateButton.click();
	
	
}
public void updateLastname(String Lname) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+cLastname.getText() );
	cLastname.sendKeys(Lname);
	UpdateButton.click();
	
}
public void updateAddress(String Address) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+cAddress.getText() );
	cAddress.sendKeys(Address);
	UpdateButton.click();
	
}
public void CIty(String city) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+cCity.getText() );
	cCity.sendKeys(city);
	UpdateButton.click();
	
	
}
public void updatestate(String State) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+cState.getText() );
	cState.sendKeys(State);
	UpdateButton.click();
	
}
public void updateZipcode(String zip) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+cZipCode.getText() );
	cZipCode.sendKeys(zip);
	UpdateButton.click();
	
	
}
public void updatePhone(String phone) throws InterruptedException {
	uContactButton.click();
	System.out.println("Account Existing Profile Details are shown below:"+cPhone.getText() );
	cPhone.sendKeys(phone);
	UpdateButton.click();
}
public void UpdateAllinfo(String Name, String Lname,String Address,String city,String State,String zip,String phone) throws InterruptedException {
	uContactButton.click();
	
	//cFirstname.clear();
	Thread.sleep(1000);
	cFirstname.clear();
	cFirstname.sendKeys(Name);
	cLastname.clear();
	cLastname.sendKeys(Lname);
	cAddress.clear();
	cAddress.sendKeys(Address);
	cCity.clear();
	cCity.sendKeys(city);
	cState.clear();
	cState.sendKeys(State);
	cZipCode.clear();
	cZipCode.sendKeys(zip);
	cPhone.clear();
	cPhone.sendKeys(phone);UpdateButton.click();
	Thread.sleep(1000);
	String PostUpdatemsg= UpdatedAssert.getText();
	Assert.assertEquals(PostUpdatemsg, "Your updated address and phone number have been added to the system.");
}
}
