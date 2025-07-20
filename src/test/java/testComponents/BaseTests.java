package testComponents;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

 

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {

	public static WebDriver driver;
	 private static int counter = 0;
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
	
	public String getScreenshot(  String testCaseName, WebDriver driver) throws IOException {
		
	   
		TakesScreenshot ts = (TakesScreenshot)driver;
        counter++;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//repor//" +  counter+testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//repor//" + testCaseName + ".png";
		
	}

	public void closeBrowser() throws InterruptedException {
				
		driver.close();
	}
	 
}
