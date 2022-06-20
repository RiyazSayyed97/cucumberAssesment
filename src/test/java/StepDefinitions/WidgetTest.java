package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactMe;

public class WidgetTest {
	@After(order = 1)
	public void cleanUp() {
		ContactMe.refreshBrowser();
	}

	@Given("User should be on test bench")
	public void user_should_be_on_test_bench() throws IOException {
		ContactMe.confirmCorrectUrl();
	}

	@When("^user enters (.*) in full name field$")
	public void user_enters_in_full_name_field(String string) {
		ContactMe.enterName(string);
	}

	@When("^user enters (.*) in email field$")
	public void user_enters_in_email_field(String email) {
		ContactMe.sendEmail(email);
	}

	@When("selects gender")
	public void selects_gender() {
		ContactMe.chooseGender();
	}

	@When("selects reason")
	public void selects_reason() throws InterruptedException {
		ContactMe.selectForJobs();
	}

	@When("clicks on simple alert")
	public void clicks_on_simple_alert() {
		ContactMe.acceptSimpleAlert();
	}

	@When("clicks on alert with dismiss option")
	public void clicks_on_alert_with_dismiss_option() {
		ContactMe.dismissPrompt();
	}

	@Then("mouseovers on images")
	public void mouseovers_on_images() {
		ContactMe.moveToElem();
	}

}
