package be.faros.experimental.tapasapp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;

/**
 * TODO 01 (Let's read: Some Cucumber boilerplate)
 * This is just some boilerplate code which is required to set up Cucumber within our system.
 *
 * You can use it to configure several things, like the directory for the feature descriptions, and the additional plugins that you want to use.
 *
 * It will also be used to run our tests (simply run it as a Test)
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/resources/features", plugin = {"pretty", "html:target/cucumber"})
@DirtiesContext
public class CucumberTest {
}