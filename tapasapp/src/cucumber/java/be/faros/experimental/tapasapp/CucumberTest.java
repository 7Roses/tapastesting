package be.faros.experimental.tapasapp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Main class for cucumber. Can configure the location of features, etc.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/resources/features", plugin = {"pretty", "html:target/cucumber"})
@DirtiesContext
public class CucumberTest {
}