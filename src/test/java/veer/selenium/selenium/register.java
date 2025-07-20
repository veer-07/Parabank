package veer.selenium.selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import veer.selenium.selenium.POM.Registartion;
import org.testng.annotations.Test;
public class register {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
//		driver.get("")
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		Registartion r=new Registartion(driver);
<<<<<<< HEAD
		r.register("veer",  "Password@12");
=======
//		r.register("veer",  "Password@12");
>>>>>>> 0bbdd3592a8011b54c47fb1918e2b78d61926ea0
//		r.updateContact();
 
		
		
		
 
	}

}
