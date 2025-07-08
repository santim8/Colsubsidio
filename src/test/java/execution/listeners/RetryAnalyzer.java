package execution.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * The RetryAnalyzer class implements the IRetryAnalyzer interface from TestNG
 * and provides a mechanism to rerun failed test cases. It determines whether
 * a test should be retried based on a predefined maximum retry count.
 *
 * This class is primarily utilized within the retry mechanism by setting it
 * as the RetryAnalyzer in TestNG annotations.
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 1;
    private static final int MAX_INT= 1;
    @Override
    public boolean retry(ITestResult iTestResult) {

        if(!iTestResult.isSuccess()){
            if(MAX_INT > count){
                count++;
                System.out.println("tin");
                return true;
            }
        }
        return false;
    }
}