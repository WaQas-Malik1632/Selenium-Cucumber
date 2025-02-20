package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.json.Json;

@RunWith(Cucumber.class)
@CucumberOptions
		(
			//	features="/CucumberBDD-CRM/src/main/java/Features/login.feature",
				features = "./src/main/java/Features/login.feature",
				glue = {"stepDefinitions"},
				plugin  = {"pretty", "html:test-output","json:json_output/cucumber.json","junit:junitOutput_xml/cucumber.xml" }, //to generate different types of reports like
			//	strict = true, // when step definition is missing for any step TO Do implement
				monochrome = true, //it defines proper readable format
				dryRun = false
			//	tags= {"~@Smoke","~@Regression","~@EndToEnd"}

		)

public class TestRunner
{

}
