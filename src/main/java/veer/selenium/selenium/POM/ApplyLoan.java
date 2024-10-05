package veer.selenium.selenium.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import veer.selenium.selenium.Abstracts;

public class ApplyLoan extends Abstracts{
	
	public WebDriver driver;

	public ApplyLoan(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	@FindBy(css="input[id='amount']")
	WebElement LoanAmt;
	
	@FindBy(css="a[href='requestloan.htm']")
	WebElement LoanReq;
	
	@FindBy(css="#downPayment")
	WebElement downPay;
//	
	@FindBy(css="#fromAccountId")
	WebElement FromAcct;
//	
	@FindBy(xpath="//input[@value='Apply Now']")
	WebElement ApplyBtn;
//	
//	@FindBy(css="#toDate")
//	WebElement toDate;
//	
//	@FindBy(css="#transactionDate")
//	WebElement transDate;
//	
//	@FindBy(css="button[type='submit']")
//	WebElement FindTransaction;
//	
//	@FindBy(css="#rightPanel")
//	WebElement TranResults;
	
public void ApplyLoans(String amt1,String amt2) throws InterruptedException   {
//	Thread.sleep(1500);
	LoanReq.click();
//	Thread.sleep(1000);
	LoanAmt.sendKeys(amt1);
	downPay.sendKeys(amt2);
	selectDropdownByValue(FromAcct,"13566");
	Thread.sleep(1000);
	ApplyBtn.click();
	
	
	
	
//	selectDropdownByValue(accnum,"16674");
//	transId.sendKeys(id);
//	FindTransaction.click();

}




}
