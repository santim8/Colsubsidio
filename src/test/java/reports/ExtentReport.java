package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import execution.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() {}

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/santiago.correa03/IdeaProjects/colsubsidioFramework/target");
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Reporte Automatizado - Suite Colsubsidio");
            spark.config().setReportName("Resultados Pruebas Automatizadas - Colsubsidio");
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File("C:\\Users\\santiago.correa03\\IdeaProjects\\colsubsidioFramework\\target\\Index.html").toURI());
            //TODO change logic
            //Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }


    public static void addAuthors(String[] authors){
        for(String temp: authors){
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addAuthor(String author){
        ExtentManager.getExtentTest().assignAuthor(author);
    }

    public static void addTestCategories(CategoryType[] testCategories){
        for(CategoryType temp: testCategories){
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }

    public static void addUserStory(String userStory){
        ExtentManager.getExtentTest().assignCategory(userStory);
    }

    public static void addTestID(String testID){
        ExtentManager.getExtentTest().assignCategory(testID);
    }

}

