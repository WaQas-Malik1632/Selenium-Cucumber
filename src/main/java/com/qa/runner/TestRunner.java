package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
				features = "./src/main/java/com/qa/features/NewsletterSubscribe.feature",
				glue = {"com/qa/stepDefinitions"},
				plugin  = {"pretty", "html:test-output","json:json_output/cucumber.json","junit:junitOutput_xml/cucumber.xml" }, //to generate different types of reports like
			//	strict = true, // when step definition is missing for any step TODo implement
				monochrome = true, //it defines console output proper readable format
				dryRun = false
			//	tags= {"~@Smoke","~@Regression","~@EndToEnd"}

		)

public class TestRunner
{

}
