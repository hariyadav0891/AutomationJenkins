package tests;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReports {

	private  static ExtentReports extent;

    public static ExtentReports getReportObject() {

//        String path = System.getProperty("user.dir") + "/reports/index.html";
//        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//
//        reporter.config().setReportName("Automation Test Report");
//        reporter.config().setDocumentTitle("Test Results");
//
//        extent = new ExtentReports();
//        extent.attachReporter(reporter);
    	
    	ExtentSparkReporter spark = new ExtentSparkReporter("reports/index.html");

    	ExtentReports extent = new ExtentReports();
//    	extent.attachReporter(spark);
//
//        extent.setSystemInfo("Tester", "Hari");
//        extent.setSystemInfo("Environment", "QA");

        return extent;
    }

}
