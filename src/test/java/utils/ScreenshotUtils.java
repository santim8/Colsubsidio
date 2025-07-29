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
import java.util.Base64;


final public class ScreenshotUtils {

    private ScreenshotUtils (){}

    protected static String SCREENSHOTS_FOLDER = "src/test/resources/images/";

    public static String getScreenshotsFolder() {
        return SCREENSHOTS_FOLDER;
    }

    public static String getScreenshotPath(String fileName) {
        return SCREENSHOTS_FOLDER + fileName + ".png";
    }

    public static String getBase64Image() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        return ts.getScreenshotAs(OutputType.BASE64);
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
        Path screenshotPath = Paths.get(SCREENSHOTS_FOLDER, fileName + ".png");
        if (!Files.exists(screenshotPath)) {
            return null;
        }
        return  Files.exists(screenshotPath) ? screenshotPath.toFile() : null;
    }

    public static String convertFileToBase64(String filePath) {
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new RuntimeException("Error converting file to Base64: " + e.getMessage());
        }
    }
}
