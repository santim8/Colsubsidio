package execution.listeners;

import execution.annotations.FrameworkAnnotation;
import org.testng.*;
import reports.ExtentReport;

import java.lang.reflect.Method;
import java.util.Arrays;

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
        if(Arrays.stream(result.getParameters()).findAny().isEmpty()) {
            return;
        }

        String nameTest = "test " + result.getTestContext().getCurrentXmlTest().getName();
        Object[] parameters = result.getParameters();

        //corregir
        if (parameters != null && parameters.length >= 2 && parameters[0] != null && parameters[1] != null) {
            nameTest += " " + parameters[0] + "-" + parameters[1];
        }
        ExtentReport.createTest(nameTest);


        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        FrameworkAnnotation annotation = method.getAnnotation(FrameworkAnnotation.class);

        if (annotation == null) {
            throw new SkipException("El test " + result.getName() +
                    " debe tener la anotación @FrameworkAnnotation");
        }

        ExtentReport.addAuthors(annotation.authors());
        ExtentReport.addTestCategories(annotation.testCategory());
        if ((annotation.userStory() != null && !annotation.userStory().isEmpty())) {
            ExtentReport.addUserStory("us_azure_id=" + annotation.userStory());
        }

        if ((annotation.testID() != null && !annotation.testID().isEmpty())) {
            ExtentReport.addTestID("test_azure_id=" + annotation.testID());
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