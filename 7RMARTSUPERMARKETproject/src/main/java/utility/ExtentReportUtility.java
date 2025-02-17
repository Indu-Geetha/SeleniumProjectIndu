package utility;

import com.aventstack.extentreports.ExtentReports;//imported ExtentReports 
import com.aventstack.extentreports.reporter.ExtentSparkReporter;//imported ExtentSparkReporter

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static and final instance of ExtentReports
																			// is created

	public synchronized static ExtentReports createExtentReports() {// Ensures thread safety
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("SevenRMartSuperMarket");// Sets the report name to "SevenRMartSuperMarket"

		extentReports.attachReporter(reporter);// Attaches the ExtentSparkReporter to the ExtentReports instance,
		// all logs will be written to the HTML file.

		extentReports.setSystemInfo("organization", "Obsqura");// Adds system information to the report
		extentReports.setSystemInfo("Name", "Indu");
		return extentReports;

	}

}
