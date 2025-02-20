package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
		(
			//	features="/CucumberBDD-CRM/src/main/java/Features/login.feature",

				features = "./src/main/java/Features/login.feature",
				glue = {"stepDefinitions"},
				plugin  = {"pretty", "html:test-output"}
		)

public class TestRunner
{

}
