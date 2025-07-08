package execution.listeners;

import execution.annotations.FrameworkAnnotation;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;

import java.lang.reflect.Method;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
        System.out.println("Suite finished: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
        System.out.println("Suite finished: " + suite.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String nameTest = "test " + result.getTestContext().getSuite().getName();
        Object[] parameters = result.getParameters();
        if (parameters != null && parameters.length > 0) {
            nameTest += "- identification: " + parameters[0];
        }
        ExtentReport.createTest(nameTest);

        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        FrameworkAnnotation annotation = method.getAnnotation(FrameworkAnnotation.class);

        if (annotation != null) {
            ExtentReport.addAuthors(annotation.authors());
            ExtentReport.addTestCategories(annotation.testCategory());

            ExtentReport.addUserStory("us-azure-id+"+ annotation.userStory());
            ExtentReport.addTestID("test+azure+id"+annotation.testID());

            if ((annotation.userStory() != null && !annotation.userStory().isEmpty())) {
                ExtentReport.addUserStory("us_azure_id="+ annotation.userStory());
            }

            if ((annotation.testID() != null && !annotation.testID().isEmpty())) {
                ExtentReport.addTestID("test_azure_id="+annotation.testID());
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeeded: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped");
    }
}