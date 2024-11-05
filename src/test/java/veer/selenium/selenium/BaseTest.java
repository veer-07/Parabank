package veer.selenium.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import veer.selenium.selenium.POM.ApplyLoan;
import veer.selenium.selenium.POM.OpenNewAcc;
import veer.selenium.selenium.POM.POM;
import veer.selenium.selenium.POM.Registartion;
import veer.selenium.selenium.POM.TransferFund;

public class BaseTest  extends POM{
	public WebDriver driver;
		public BaseTest(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	//
		public static void main(String[] args) throws InterruptedException {
	// 
			
			WebDriver driver=new ChromeDriver();
//			System.setProperty("chromedriver","C:\\Users\\veere\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chromium-driver.exe" );
//			driver.get("")
			
			String Uname="rafkj";
			String Pass="87589";
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			
			Registartion R=new Registartion(driver);
//			R.register(Uname,Pass);
			
			Thread.sleep(1000);
			POM c=new POM(driver);
			c.login(Uname,Pass);
			
			String a=driver.findElement(By.cssSelector(".title")).getText();
			
			boolean z=a.equalsIgnoreCase("Accounts Overview");
			System.out.println(z);
			c.AccInfo();
//			c.AccoutNumbersCreated();

			
			//			Thread.sleep(1500);
//			OpenNewAcc ad=new OpenNewAcc(driver);
//			ad.newAcc("SAVINGS");
////			ad.n
//			TransferFund t=new TransferFund(driver);
//			t.TransferFunds("34878","24999");
//			
//			Registartion r=new Registartion(driver);
//			r.updateContact();
////			ApplyLoan AL=new ApplyLoan(driver);
////			AL.ApplyLoans("902789","9920");
			
			
			
//			String SAVINGS;
			
//			newAcc();
//			driver.findElement(By.xpath("//*[contains(@href,'open')]")).click();
//			Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='type']")));
////			dropdown.selectByIndex(1);
//			dropdown.selectByValue("SAVINGS");
//			driver.findElement(By.xpath("))
//			WebElement dropdowns;

//			driver.close();
			
		
			

}}