package veer.selenium.selenium.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import veer.selenium.selenium.Abstracts;

public class TransferFund extends Abstracts{
	
	public WebDriver driver;

	public TransferFund(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	@FindBy(id="amount")
	WebElement amounts;
	
	@FindBy(id="fromAccountId")
	WebElement options;
	@FindBy(id="toAccountId")
	WebElement optionss;
	
	@FindBy(css="a[href='transfer.htm']")
	WebElement transferbutton;
	
	@FindBy(css="input[value='Transfer']")
	WebElement transfer;
	
	@FindBy(css="#showResult")
	WebElement transferResults;
	
public void TransferFunds(String Acc1,String Acc2) throws InterruptedException {
	transferbutton.click();
	amounts.sendKeys("1290");
	Select dropdown = new Select(options);
	Thread.sleep(1000);
	selectDropdownByVisibleText(options,Acc1);
	Select dropdon = new Select(optionss);
	selectDropdownByValue(optionss,Acc2);
	transfer.click();
	Thread.sleep(1000);
	System.out.println("Account Transfer Details are shown below:");
	System.out.println("=========================================");
	Thread.sleep(1000);
	System.out.println(transferResults.getText());

}

}
