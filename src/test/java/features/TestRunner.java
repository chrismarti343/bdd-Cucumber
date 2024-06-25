package features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/features",  // Path to your feature file
            glue = "steps",
            plugin = {"pretty","json:target/report/cucumber.json",
                    "html:target/report/cucumber.html"} // Package containing step definitions                       // Package containing step definitions
    )
    public class TestRunner {
    }
