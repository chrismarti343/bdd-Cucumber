package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/java/resources/features/userOperations.feature",
                    "src/test/java/resources/features/getPost.feature"},  // Path to your feature file
            glue = "steps",
            plugin = {"pretty","json:src/test/java/report/cucumber.json",
                    "html:src/test/java/report/cucumber.html"} // Package containing step definitions                       // Package containing step definitions
    )
    public class TestRunner {
    }
