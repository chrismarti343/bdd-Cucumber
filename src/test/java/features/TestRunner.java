package features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/features",  // Path to your feature file
            glue = "steps"                        // Package containing step definitions
    )
    public class TestRunner {
    }
