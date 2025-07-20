package veer.selenium.selenium.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Billpay {
	public WebDriver driver;
	
	public Billpay(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@name='payee.name']")
	WebElement payeename;
	
	@FindBy(xpath="//input[@name='payee.address.street']")
	WebElement Address;
	
	@FindBy(xpath="//input[@name='payee.address.city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='payee.address.state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='payee.address.zipCode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@name='payee.phoneNumber']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='payee.accountNumber']")
	WebElement accountNumber;
	
	@FindBy(xpath="//input[@name='verifyAccount']")
	WebElement verifyAccount;
	
	@FindBy(xpath="//input[@name='amount']")
	WebElement amount;
	
	@FindBy(xpath="//select[@name='fromAccountId']")
	WebElement AccounIds;
	
	@FindBy(xpath="//a[text()='Bill Pay']")
	WebElement billbutton;
	 
	
	public void BillPayment() throws InterruptedException {
//		
		billbutton.click();
		Thread.sleep(1000);
		payeename.sendKeys("joee");
		Address.sendKeys("ufhsnl");
		city.sendKeys("dfsfgdg");
		state.sendKeys("agfESDD");
		zipcode.sendKeys("grhewk");
		phoneNumber.sendKeys("dstgss52346");
		accountNumber.sendKeys("12312345785");
		verifyAccount.sendKeys("12312345785");
		amount.sendKeys("1329");
		
	Select dp=new Select(AccounIds);
    dp.selectByIndex(0);

	}


	
}
