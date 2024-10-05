package veer.selenium.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import veer.selenium.selenium.POM.POM;

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
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			POM c=new POM(driver);
			c.login("veeresh","1234*");
			
			String a=driver.findElement(By.cssSelector(".title")).getText();
			
			boolean z=a.equalsIgnoreCase("Accounts Overview");
			System.out.println(z);
			c.AccInfo();
			c.TransferFunds("16674","13788");
//			String SAVINGS;
//			newAcc(SAVINGS);
//			newAcc();
//			driver.findElement(By.xpath("//*[contains(@href,'open')]")).click();
//			Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='type']")));
////			dropdown.selectByIndex(1);
//			dropdown.selectByValue("SAVINGS");
//			driver.findElement(By.xpath("))
//			WebElement dropdowns;

//			driver.close();
			
		
			

}}