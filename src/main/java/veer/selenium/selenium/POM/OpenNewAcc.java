package veer.selenium.selenium.POM;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import veer.selenium.selenium.Abstracts;

public class OpenNewAcc extends Abstracts{
	
	public WebDriver driver;

	public OpenNewAcc(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
 
	}
	
	@FindBy(css="a[href='openaccount.htm']")
	WebElement newAccount;
	
	@FindBy(xpath="//select[@id='type']")
	WebElement dropdowns;
	
	@FindBy(xpath="//input[@value='Open New Account']")
	WebElement NewAccountin;
	@FindBy(xpath="//h1[contains(text(),'Account Opened!')]")
	WebElement OpenedStat;
	@FindBy(xpath="//p[contains(text(),'Congratulations, your account is now open.')]")
	WebElement ThanksText;
	
	
//	Scanner sc=new Scanner(System.in);
//	String AccType=sc.next();
//	System.out.print("Enter the account type");
	
	public void newAcc(String type) throws InterruptedException {
//		explicitwait(5);
//		Thread.sleep(2000);
		newAccount.click();
		explicitwait(5);
		Select dropdown = new Select(dropdowns);
		explicitwait(5);
		dropdown.selectByVisibleText(type);
		Thread.sleep(1000);
		NewAccountin.click();
		String x=OpenedStat.getText();
		System.out.print(x);
		String y=ThanksText.getText();
		System.out.print(y);
	}
	
	
	
	
	

	
}
