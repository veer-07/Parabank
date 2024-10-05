package veer.selenium.selenium.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import veer.selenium.selenium.Abstracts;

public class FundTransactions extends Abstracts{
	
	public WebDriver driver;

	public FundTransactions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	@FindBy(css="a[href='findtrans.htm']")
	WebElement FundButton;
	
	@FindBy(css="#transactionId")
	WebElement transId;
	@FindBy(css="#AccountId")
	WebElement accnum;
	
	@FindBy(css="#amount")
	WebElement ammount;
	
	@FindBy(css="#fromDate")
	WebElement frmDate;
	
	@FindBy(css="#toDate")
	WebElement toDate;
	
	@FindBy(css="#transactionDate")
	WebElement transDate;
	
	@FindBy(css="button[type='submit']")
	WebElement FindTransaction;
	
public void TransferFundsById(String id) throws InterruptedException {
	FundButton.click();
	selectDropdownByValue(accnum,"16674");
	transId.sendKeys(id);
	FindTransaction.click();

}
public void TransferFundsByDate(String MMDDYY) throws InterruptedException {
	FundButton.click();
	selectDropdownByValue(accnum,"16674");
	transDate.sendKeys(MMDDYY);
	FindTransaction.click();

}
public void TransferFundsByDateRange(String MMDDYY,String MMDDYY1) throws InterruptedException {
	FundButton.click();
	selectDropdownByValue(accnum,"16674");
	frmDate.sendKeys(MMDDYY);
	toDate.sendKeys(MMDDYY1);
	FindTransaction.click();

}
public void Amount(String amt) throws InterruptedException {
	FundButton.click();
	selectDropdownByValue(accnum,"16674");
	ammount.sendKeys(amt);
	FindTransaction.click();

}

}
