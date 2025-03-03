package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Login.feature",
        glue = "stepDefinitions",
        tags = "@ScenarioValide or @ScenarioInvalide",
        plugin = {"pretty","html:target\\Rapports\\Rapport.html"}
)
public class Runner {
}
