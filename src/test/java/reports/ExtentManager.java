package reports;


import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

/**
 * The ExtentManager class provides thread-local management for instances of ExtentTest to support thread safety
 * in concurrent test execution scenarios. This ensures that each thread has its own instance of ExtentTest
 * for proper logging and reporting during test execution.
 */
public class ExtentManager {

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    private ExtentManager(){}

    static ExtentTest getExtentTest(){
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test){
        if(Objects.nonNull(test)) {
            extTest.set(test);
        }
    }

    static void unload(){
        extTest.remove();
    }

}

