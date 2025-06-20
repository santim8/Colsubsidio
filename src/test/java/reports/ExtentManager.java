package reports;


import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

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

