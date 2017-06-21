package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebPageValidation {
	@Given("^Web page is displayed with Value (\\d+) to Value (\\d+)$")
	public void web_page_is_displayed_with_Value_to_Value(int arg1, int arg2) throws Throwable {
	    
	}

	@When("^Verify the value of \"([^\"]*)\" is \\$\"([^\"]*)\"$")
	public void verify_the_value_of_is_$(String arg1, String arg2) throws Throwable {
	   
	}

	@Then("^The value of \"([^\"]*)\" is \\$\"([^\"]*)\"$")
	public void the_value_of_is_$(String arg1, String arg2) throws Throwable {
	    
	}

}
