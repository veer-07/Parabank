package Extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutoReport{

	
	public static ExtentReports repo() {
	String path=System.getProperty("user.dir")+"//Actions//index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Auto Results");
	reporter.config().setDocumentTitle("Test  Results");
	
	ExtentReports r=new ExtentReports();
	r.setSystemInfo("SDET", "VEER");
	return r;
}
}