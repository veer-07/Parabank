package API_Parabank.chats;

 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

 

public class POM   {
		public WebDriver driver;
		@FindBy(css=".input")
		WebElement username;
		@FindBy(css = "input[type='password']")
		WebElement password;
//		WebElement pass;
		@FindBy(css = "input[type='submit']")
		WebElement submit;
		
		
		
		
		
		public POM(WebDriver driver) {
			super( );
			this.driver = driver;
			PageFactory.initElements(driver, this);
     
		}
		
		
				
		//a[contains(@href,'register')]  
//		public void registration(String uname,String pass) {
//			regi.click();
//			username.sendKeys(uname);
//			password.sendKeys(pass);
//		}
		public void login(String Uname,String passwords) throws InterruptedException {
			
			username.sendKeys(Uname);
			password.sendKeys(passwords);
			submit.click();
			
		}
		@FindBy(xpath="//tr/td")
		List<WebElement> acc;
		
		@FindBy(id="accountTable")
		List<WebElement> aa;
		
		
		public void AccInfo() throws InterruptedException {
			for(WebElement a:aa) {
				System.out.println("Account Overview");
				System.out.println("==============================");
				Thread.sleep(1000);
				System.out.println(a.getText()+"   ");
			}
			
			
			
		}
		@FindBy(xpath="//tr/td/a")
		List<WebElement> Accounts;

		@FindBy(xpath="//div[@id='rightPanel']")
		WebElement  ActivityDetails;
		
//		int len=Accounts;
//		
//		String[] textArray = new String[len];
		
		public  String[] AccoutNumbersCreated(String Acnumber) {
			 String[] textArray = new String[Accounts.size()];
		        
			for(int i=0;i<Accounts.size();i++) {
				
				 textArray[i] = Accounts.get(i).getText();
	        
			
			if (textArray[i]==Acnumber){
				
			}}
			for (String text : textArray) {
	            System.out.println("Available accounts are: "+text);
	            
	        }
			 
	       
	        return textArray;
			
				}
//			for(WebElement a:Accounts) {
//				
//				System.out.println("The avilable/created account numbers are as follows: ");
//				
//				System.out.println(a.getText());
//				a.click();
//				ActivityDetails.getText();
				
//				acnum.add(a);
				
//}
//		}
		
		String acc1="24999";
		@FindBy(css="a[href='activity.htm?id='24999']")
		WebElement AccountNum;
		
//			public void ParticularAccountInfo(String Acnumber) {
//				for(int i=0;i<Accounts.size();i++) {
//					if (textArray[i]==Acnumber){
//						
//				}
//				
//			}
//			
		}
		
		

		
		
		
		
		
		
			
		

		
		
		
		
		
		

		
		




