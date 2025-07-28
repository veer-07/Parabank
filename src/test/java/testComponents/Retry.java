package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
 
	
	int start=0;
 int max=1;
 
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(start<max) {
			start++;
			return true;
		}
		return false;
	}

}
