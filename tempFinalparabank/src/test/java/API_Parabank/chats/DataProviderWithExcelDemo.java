package API_Parabank.chats;

 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class DataProviderWithExcelDemo {
     
   
 
//   @BeforeMethod
//    public void setUp() {
//	   	WebDriver driver=new ChromeDriver();
//        driver.get("https://www.bing.com");
//        driver.manage().window().maximize();
// 
//    }
 
    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
    public void search(String keyWord1, String keyWord2) throws InterruptedException {
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	POM c=new POM(driver);
		c.login(keyWord1,keyWord2);
      driver.quit();
    }
 
//    @AfterMethod
//    public void burnDown() {
//        driver.quit();
//    }
 
}