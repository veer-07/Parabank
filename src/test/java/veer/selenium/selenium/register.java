package veer.selenium.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import veer.selenium.selenium.POM.Registartion;
import org.testng.annotations.Test;
public class register {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
//		driver.get("")
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		Registartion r=new Registartion(driver);
		r.register("veer",  "Password@12");
//		r.updateContact();
 
		
		
		
 
	}

}
