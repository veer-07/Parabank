package veer.selenium.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import veer.selenium.selenium.POM.Registartion;

public class BaseT {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
//	driver.get("")
	driver.get("https://parabank.parasoft.com/parabank/index.htm");
//	POM p=new POM(driver);
//	p.login("veeresh","1234*");
//	
//	String a=driver.findElement(By.cssSelector(".title")).getText();
//	
//	boolean z=a.equalsIgnoreCase("Accounts Overview");
//	System.out.println(a);
////	String SAVINGS;
////	newAcc(SAVINGS);
//	OpenNewAcc as=new OpenNewAcc(driver);
//	as.newAcc();
	
	Registartion r=new Registartion(driver);
	r.register();
	}

}
