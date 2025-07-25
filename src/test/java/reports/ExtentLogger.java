package reports;


import com.aventstack.extentreports.MediaEntityBuilder;
import utils.ScreenshotUtils;

public final class ExtentLogger {


    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }


    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        if (isScreenshotNeeded) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void info(String message, boolean isScreenshotNeeded) {
        if (isScreenshotNeeded) {
            ExtentManager.getExtentTest().info(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            info(message);
        }
    }

    public static void pass(String message, boolean isScreenshotNeeded, String fileName) {
        if (isScreenshotNeeded) {
            String base = ScreenshotUtils.convertFileToBase64(ScreenshotUtils.getScreenshotPath(fileName));
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base).build());
        } else {
            info(message);
        }
    }
}