package execution.repositories;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportImplementation {

    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;

    private ReportImplementation() {
    }

    public static void initialize() {
        sparkReporter = new ExtentSparkReporter("C:/Users/santi/IdeaProjects/colsubsidio/target");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void setTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void sendLog(Status status, String message) {
        test.log(status, message);
    }

    public static void flush() {
        extent.flush();
    }
}
