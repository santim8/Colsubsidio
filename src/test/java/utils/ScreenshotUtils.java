package utils;

import execution.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


final public class ScreenshotUtils {

    private ScreenshotUtils (){}

    protected static String SCREENSHOTS_FOLDER = "src/test/resources/images";

    public static String getScreenshotsFolder() {
        return SCREENSHOTS_FOLDER;
    }

    public static String getScreenshotPath(String fileName) {
        return SCREENSHOTS_FOLDER + File.separator + fileName;
    }

    public static String getBase64Image() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        return ts.getScreenshotAs(OutputType.BASE64);
    }
    public static File getFileImage(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File ss = ts.getScreenshotAs(OutputType.FILE);
        File screenshotReference = new File(getScreenshotsFolder() + fileName);
        FileUtils.copyFile(ss, screenshotReference);
        return screenshotReference;
    }

    public static void takeScreenScreenShootAndSaved(String fileName) throws IOException {
        getFileImage(fileName);
    }

    public static File getFileImage2(String fileName) throws IOException {
        return new File(getScreenshotsFolder() + File.separator + fileName);
    }


    public static File captureAndSaveScreenshot(String fileName) throws IOException {
        try {
            File screenshotFile = captureScreenshot();
            File destinationFile = createDestinationFile(fileName);
            saveScreenshot(screenshotFile, destinationFile);
            return destinationFile;
        } catch (Exception e) {
            throw new IOException("Screenshot capture failed", e);
        }
    }

    private static void saveScreenshot(File screenshotFile, File destinationFile) {
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot to file", e);
        }
    }

    private static File createDestinationFile(String fileName) {
        return new File(getScreenshotPath(fileName));
    }

    public static File captureScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        return ts.getScreenshotAs(OutputType.FILE);
    }

    public static File getScreenshotFile(String fileName) {
        Path screenshotPath = Paths.get(SCREENSHOTS_FOLDER, fileName);
        if (!Files.exists(screenshotPath)) {
            return null;
        }
        return  Files.exists(screenshotPath) ? screenshotPath.toFile() : null;
    }


}
