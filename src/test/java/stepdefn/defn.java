package stepdefn;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import veer.selenium.selenium.Abstracts;
import veer.selenium.selenium.POM.POM;
import veer.selenium.selenium.POM.Registartion;

public class defn  extends POM{

	public defn(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Given("i landed on the bank site")
	
	public void i_landed_on_the_bank_site() throws InterruptedException {
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@Given("^i want to write a step with username (.+) and password (.+)$")
	
	public void step_with_username_and_password(String Uname, String pass) throws InterruptedException, IOException{
		
		Registartion r=new Registartion(driver);
//		r.register(Uname,  pass, pass, pass, pass, pass, pass, pass, pass, pass);
		
	}
}
