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
		super();
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

	@FindBy(css="#requestLoanResult") 
	WebElement LoanOverview;
	
 
//	String Account="16896";
	String Account="13344";
 
public void ApplyLoans(String amt1,String amt2) throws InterruptedException   {
//	Thread.sleep(1500);
	LoanReq.click();
//	Thread.sleep(1000);
	LoanAmt.sendKeys(amt1);
	downPay.sendKeys(amt2);
	selectDropdownByValue(FromAcct,Account);
 
	Thread.sleep(1000);
	ApplyBtn.click();


 
	Thread.sleep(100);
	ApplyBtn.click();
	Thread.sleep(1000);
//	String Overview=LoanOverview.getText();
	System.out.println(LoanOverview.getText());
	

}
 
 




}
