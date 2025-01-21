package veer.selenium.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import veer.selenium.selenium.POM.OpenNewAcc;
import veer.selenium.selenium.POM.POM;
import veer.selenium.selenium.POM.Registartion;

public class BaseT {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
//	driver.get("")
	driver.get("https://parabank.parasoft.com/parabank/index.htm");
//	POM p=new POM(driver);
//	p.login("Veeraa","12345*");
//	
//	String a=driver.findElement(By.cssSelector(".title")).getText();
//	
//	boolean z=a.equalsIgnoreCase("Accounts Overview");
//	System.out.println(a);
////	String SAVINGS;
////	newAcc();
//	OpenNewAcc as=new OpenNewAcc(driver);
//	as.newAcc("Savings");
//	
//	driver.findElement(By.cssSelector("a[href='openaccount.htm']")).click();
//	
	Registartion r=new Registartion(driver);
	r.register("Veeraa","12345*");
	}

}
