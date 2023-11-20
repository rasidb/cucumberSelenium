package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/cucumber-reports/rerun.txt",
        glue = "com.stepDefinitions"
)

public class FailedTestRunner {

}
