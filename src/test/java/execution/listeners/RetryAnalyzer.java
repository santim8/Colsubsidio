package execution.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 1;
    private static final int MAX_INT= 2;
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