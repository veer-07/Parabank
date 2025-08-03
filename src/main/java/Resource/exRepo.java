package Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class exRepo{

	
	public static ExtentReports repo() {
		
		String path=System.getProperty("user.dir")+"//repor//index.html";
		ExtentSparkReporter r=new ExtentSparkReporter(path);
		r.config().setDocumentTitle("AUtomation Reports");
		r.config().setReportName("Results");
		
		ExtentReports e=new ExtentReports();
		e.attachReporter(r);
		e.setSystemInfo("SDET", "VEER");
		return e;
	}
	
	
}
