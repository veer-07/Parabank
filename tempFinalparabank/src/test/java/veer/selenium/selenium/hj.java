package veer.selenium.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hj {
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://practice.expandtesting.com/dynamic-table");
	String check ="Chrome";
	Thread.sleep(1000);
	
	
////	String names=driver.findElement(By.xpath("//tr/th[1][text()='"+Check+"']")).getAttribute(Check);
////	
////	
////	WebElement v=driver.findElement(By.xpath("//tbody/tr/td[text()='"+check+"']"));
//WebElement x=	driver.findElement(By.cssSelector("#table-description"));
////	System.out.println(v.getText());
////	WebElement b=driver.findElement(By.cssSelector("li[class='breadcrumb-item'] a"));
//	
//	String attr=x.getAttribute("id");
//	System.out.println(attr);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,450)");
//	WebElement table=driver.findElement(By.cssSelector(".table table-striped"));
//	driver.switchTo().frame(table);	
//	WebElement a=driver.findElement(By.cssSelector(".col-md-6 tr td:nth-child(3)"));
//	System.out.println(a.getText());
	
	
//	//tr/td[text()='Chrome']/following-sibling::td[contains(text(),' "+ % +" ')]
	WebElement chromeCpu = driver.findElement(By.xpath("//td[text()='Chrome']/following-sibling::td[contains(text(),'%')]"));
    String chromeCpuValue = chromeCpu.getText();
    System.out.println(chromeCpu.getAttribute(chromeCpuValue));
    
    WebElement target=driver.findElement(By.xpath("//tr/td[(text()='Chrome')]"));
    
    WebElement cpu=driver.findElement(By.xpath("//tr/th[(text()='CPU')]"));

    // Find the value in the yellow label
    WebElement yellowLabel = driver.findElement(By.xpath("//p[@id='chrome-cpu'] [substring-after(text(),'Chrome CPU: ')]"));
    String yellowLabelValue = yellowLabel.getText();

    // Print and compare the values
    System.out.println(target.getText()+" "+cpu.getText()+ chromeCpuValue);
    System.out.println( yellowLabelValue);

    if (chromeCpuValue.equals(yellowLabelValue)) {
        System.out.println("The CPU load matches the value in the yellow label!");
    } else {
        System.out.println("The CPU load does not match.");
    }
}
}