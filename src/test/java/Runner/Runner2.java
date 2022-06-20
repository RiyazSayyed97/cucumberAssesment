package Runner;

import org.testng.annotations.Test;

import abstracted.CustomisedRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/Features/Widgettesting.feature" }, glue = {
		"StepDefinitions" }, monochrome = true)

public class Runner2 extends CustomisedRunner {


	
	@Test
	public void runScenarios() {
		

		System.out.println("test is running");
	}

}
