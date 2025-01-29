package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {

	public static WebDriver driver;
	
	public static WebDriver initialization() throws IOException {
		Properties prp=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\veere\\eclipse-workspace\\selenium\\src\\main\\java\\Resource\\global.properties");
		prp.load(fis);	
		String browserName=prp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
//			WebDriverManager.chromedriver().setup(); 
			driver=new ChromeDriver();
			
		}
		else {
//			prp.getProperty("Edge");
//			WebDriverManager.edgedriver().setup(); 
			driver=new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		return driver;
	}

	 
}
