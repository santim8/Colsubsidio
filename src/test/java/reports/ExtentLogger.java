package reports;


import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentLogger {


    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }


    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }

 /*   public static void pass(String message, boolean isScreenshotNeeded) {
        if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }
    }*/

   /* public static void pass(String message, boolean isScreenshotNeeded, String base64Image) {
        if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        }
        else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            fail(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded, String base64Image) {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        }
        else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            skip(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded, String base64Image) {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        }
        else {
            skip(message);
        }
    }

    public static void info(String message, boolean isScreenshotNeeded) {
        if(PropertyUtils.get(ConfigProperties.INFOSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().info(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            info(message);
        }
    }

    public static void info(String message, boolean isScreenshotNeeded, String base64Image) {
        if(PropertyUtils.get(ConfigProperties.INFOSTEPSREPORTSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        }
        else {
            info(message);
        }
    }*/
}