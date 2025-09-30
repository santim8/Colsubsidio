package execution.core.magnifie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globant.aut.javacore.restclients.dto.ExecutionResponse;
import com.globant.aut.javacore.restclients.dto.ProjectResponse;
import com.globant.aut.sdk.Assets;
import com.globant.aut.sdk.dashboard.Executions;
import com.globant.aut.sdk.dashboard.Projects;
import com.globant.aut.sdk.model.MagnifAIAsset;
import execution.core.driver.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import execution.reports.ExtentLogger;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MagnifaiManager {
    private static String PROJECT_NAME = "Starter Kit Java SDK santi2";
    private static ObjectMapper mapper = new ObjectMapper();
    public static String PROJECT_ID;
    public static String EXECUTION_ID;

    public static void setProjectId() throws JsonProcessingException {
        String projectId = "";
        var pageableProjects = Projects.list(0, 1000);
        System.out.println("Status: " + pageableProjects.getHttpStatusCode());
        System.out.println("Body:\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pageableProjects.getPageableProjectsResponse()));
        assertEquals(pageableProjects.getHttpStatusCode(), 200);

        List<ProjectResponse> projects = pageableProjects.getPageableProjectsResponse().getProjects();
        boolean notExists = Boolean.TRUE;
        for (ProjectResponse project : projects) {
            String executionName = project.getName();
            if (executionName.toLowerCase().contains(PROJECT_NAME.toLowerCase())) {
                projectId = project.getId();
                System.out.println("Existing Project ID: " + projectId);
                notExists = Boolean.FALSE;
            };
        };

        if (notExists) {
            var createdProject = Projects.create(PROJECT_NAME);
            System.out.println("Status: " + createdProject.getHttpStatusCode());
            System.out.println("Body:\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createdProject.getProjectResponse()));
            projectId = createdProject.getProjectResponse().getId();
            System.out.println("New Project ID: " + projectId);
        };

        PROJECT_ID = projectId;
    }

    public static void setExecutionId() throws JsonProcessingException {
        String executionId = "";
        var pageableExecutions = Executions.getByProject(null, null, PROJECT_ID);
        System.out.println("Status: " + pageableExecutions.getHttpStatusCode());
        System.out.println("Body:\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pageableExecutions.getPageableExecutionsResponse()));
        assertEquals(pageableExecutions.getHttpStatusCode(), 200);

        List<ExecutionResponse> executions = pageableExecutions.getPageableExecutionsResponse().getExecutions();
        boolean notExists = Boolean.TRUE;
        for (ExecutionResponse execution : executions) {
            String executionName = execution.getName();
            if (executionName.contains("Automated Tests " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yy")))) {
                executionId = execution.getId();
                System.out.println("Existing Execution ID: " + executionId);
                notExists = Boolean.FALSE;
            };
        };

        if (notExists) {
            var createdExecution = Executions.create(PROJECT_ID, "Automated Tests " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yy")));
            System.out.println("Status: " + createdExecution.getHttpStatusCode());
            System.out.println("Body:\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createdExecution.getExecutionResponse()));

            executionId = createdExecution.getExecutionResponse().getId();
            System.out.println("New Execution ID: " + executionId);
        };
        EXECUTION_ID = executionId;
    }

    public static void setViewPort(int width, int height) throws IOException, InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int width1 = width;
        int height1 = height;


        String windowSize = js.executeScript("return (window.outerWidth - window.innerWidth + " + width + ") + ',' + (window.outerHeight - window.innerHeight + " + height + "); ").toString();
        System.out.println("Window Size: " + windowSize);
        //Get the values
        width = Integer.parseInt(windowSize.split(",")[0]);
        height = Integer.parseInt(windowSize.split(",")[1]);

        driver.manage().window().setSize(new Dimension(width1, height1));
        Thread.sleep(1000);
        windowSize = js.executeScript("return (window.outerWidth - window.innerWidth + " + width + ") + ',' + (window.outerHeight - window.innerHeight + " + height + "); ").toString();
        System.out.println("set Window Size: " + windowSize);
    }

    public static void attachResultImage(String assetId, String name, BigDecimal resultComparison) throws IOException {
        MagnifAIAsset magnifaiAsset = Assets.get(assetId);
        File resultTmp = new File(ScreenshotUtils.getScreenshotsFolder() + name + ".png");
        Files.write(resultTmp.toPath(), magnifaiAsset.getAssetFile(), StandardOpenOption.CREATE);
        ExtentLogger.pass("Result Image:1, result obtained: " +resultComparison.toString(), true, name);
    }
}
