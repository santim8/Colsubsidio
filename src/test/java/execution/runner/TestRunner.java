package execution.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "execution.api.StepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
//        monochrome = true,
//        tags = "@smokeTest",
        //dryRun = true,
//        plugin = {"pretty:target/cucumber/cucumber.txt",
//                "html:target/cucumber/report",
//                "json:target/cucumber.json"}
)
public class TestRunner {
}
