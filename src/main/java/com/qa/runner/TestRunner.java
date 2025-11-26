package com.qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
		(
				features = "./src/main/java/com/qa/features/Home_Newsletter.feature",
				glue = {"com/qa/stepDefinitions"},
				plugin  = {"pretty", "html:test-output","json:json_output/cucumber.json","junit:junitOutput_xml/cucumber.xml" }, //to generate different types of reports like
			//	strict = true, // when step definition is missing for any step TODo implement
				monochrome = true, //it defines console output proper readable format
				dryRun = false,
                publish = true
			//	tags= {"~@Smoke","~@Regression","~@EndToEnd"}

		)

public class TestRunner
{

}