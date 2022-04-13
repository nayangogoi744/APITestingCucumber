package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/APITest.feature",
		glue="stepDef",monochrome=true,
		stepNotifications = true)
public class TestRunner {

}
