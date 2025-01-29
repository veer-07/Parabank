package ExtentReprt;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class rpt {
	


 

public static ExtentReports  config() {
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
	reporter.config().setReportName("Automation report");
	reporter.config().setDocumentTitle("Practice report");
	
	ExtentReports r=new ExtentReports();
	 
	r.attachReporter(reporter);
	r.setSystemInfo("SDET", "VEER");
	return r;
}

}