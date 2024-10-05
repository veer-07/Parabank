package veer.selenium.selenium.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import veer.selenium.selenium.Abstracts;

public class POM  extends Abstracts{
		public WebDriver driver;
		@FindBy(css=".input")
		WebElement username;
		@FindBy(css = "input[type='password']")
		WebElement password;
//		WebElement pass;
		@FindBy(css = "input[type='submit']")
		WebElement submit;
		
		
		
		
		
		public POM(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
     
		}
		
		
				
		//a[contains(@href,'register')]  
//		public void registration(String uname,String pass) {
//			regi.click();
//			username.sendKeys(uname);
//			password.sendKeys(pass);
//		}
		public void login(String Uname,String passwords) throws InterruptedException {
			
			username.sendKeys(Uname);
			password.sendKeys(passwords);
			submit.click();
			
		}
		@FindBy(xpath="//tr/td")
		List<WebElement> acc;
		
		@FindBy(id="accountTable")
		List<WebElement> aa;
		
		
		public void AccInfo() throws InterruptedException {
			for(WebElement a:aa) {
				System.out.println("Account Overview");
				System.out.println("==============================");
				Thread.sleep(1000);
				System.out.println(a.getText()+"   ");
			}
			
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
			selectDropdownByVisibleText(options,Acc1);
			Select dropdon = new Select(optionss);
			selectDropdownByValue(optionss,Acc2);
			transfer.click();
			Thread.sleep(1000);
			System.out.println("Account Transfer Details are shown below:");
			System.out.println("=========================================");
			System.out.println(transferResults.getText());
		
		}
		}
		
		
		
		
		
		
		

		
		




