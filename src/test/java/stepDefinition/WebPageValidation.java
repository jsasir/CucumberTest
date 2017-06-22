package stepDefinition;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WebPageValidation {
	
	WebDriver driver;
	
	//Collected the expected values in an ArrayList
	public ArrayList<String> expected_lblVal = new ArrayList<String>(Arrays.asList("Value 1","Value 2","Value 3","Value 4","Value 5" )); 
	public ArrayList<String> expected_txtVal = new ArrayList<String>(Arrays.asList("$122,365.24","$599.00","$850,139.99","$23,329.50","$566.27"));
	
	public ArrayList<String> actual_text_val;
	public ArrayList<String> actual_label_val;
	
	String l_val1;
	String l_val2;
	String l_val3;
	String l_val4;
	String l_val5;
	String t_val1;
	String t_val2;
	String t_val3;
	String t_val4;
	String t_val5;
	String text_total_val;
	String label_total_val;

	
		public ArrayList<Double> extractNumericValues(ArrayList<String> actual_text_val){ //Method to extract only the numbers from given string.  
			  ArrayList<Double> actualNumericVal = new ArrayList<Double>();
			  	  for (int i=0; i <= actual_text_val.size()-1; i++){
			  		actualNumericVal.add(i, Double.parseDouble(actual_text_val.get(i).replaceAll("[^\\d.]+", "").toString()));
			  	  }
			  	  return actualNumericVal;
		}
							
		@Given("^Launch the test Webpage$")  //Instantiating the driver and launching the desired webpage.
		public void launch_the_test_Webpage() throws Throwable {
			System.setProperty("webdriver.chrome.driver","src\\test\\java\\utils\\ChromeDriver\\Chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.exercise1.com/values");
		}
				
		@When("^The webpage is displayed with set of Values$") //Collecting all the web elements (labels and actual text) of the page and keeping in an ArrayList 
		public void the_webpage_is_displayed_with_set_of_Values() throws Throwable {
			l_val1 = driver.findElement(By.id("lbl_val_1")).getText();
			l_val2 = driver.findElement(By.id("lbl_val_2")).getText();
			l_val3 = driver.findElement(By.id("lbl_val_3")).getText();
			l_val4 = driver.findElement(By.id("lbl_val_4")).getText();
			l_val5 = driver.findElement(By.id("lbl_val_5")).getText();
			t_val1 = driver.findElement(By.id("txt_val_2")).getText();
			t_val2 = driver.findElement(By.id("txt_val_2")).getText();
			t_val3 = driver.findElement(By.id("txt_val_3")).getText();
			t_val4 = driver.findElement(By.id("txt_val_4")).getText();
			t_val5 = driver.findElement(By.id("txt_val_5")).getText();
			label_total_val = driver.findElement(By.id("lbl_ttl_val")).getText();
			text_total_val = driver.findElement(By.id("txt_ttl_val")).getText();
			
			actual_label_val = new ArrayList<String>(Arrays.asList(t_val1, t_val2, t_val3, t_val4, t_val5));
			actual_text_val = new ArrayList<String>(Arrays.asList(l_val1, l_val2, l_val3, l_val4, l_val5));
			

		}

		@Then("^Verify the name of value label$") //Validating the expected label values against actual labels
		public void verify_the_name_of_value_label() throws Throwable {
			for (int i=0; i<=expected_lblVal.size()-1; i++){
				Assert.assertEquals("Validating the name of Value Label", expected_lblVal.get(i), actual_label_val.get(i));				
			}
			
		}

		@Then("^Verify the actual value text$")  //Validating the expected text values against actual labels. 
		public void verify_the_actual_value_text() throws Throwable {
			for (int i=0; i<=expected_txtVal.size()-1; i++){
			Assert.assertEquals("Validating the name of actual text Label", expected_txtVal.get(i), actual_text_val.get(i));
			}
		}

		@Then("^Verify the values on the screen are greater than Zero$") //Validating the values present in the page are greater than 0
		public void verify_the_values_on_the_screen_are_greater_than_Zero() throws Throwable {
			
			ArrayList<Double> actualNumericVal = extractNumericValues(actual_text_val); //Extracting the numeric values from the String text value
			for (int i=0; i<=actual_text_val.size()-1; i++){
			Assert.assertNotEquals("Validating the values are greater than 0", 0, actualNumericVal.get(i));
			}
		}

		@Then("^varify the total balance is correctly calculated$") //Verifying the total balance. 
		public void varify_the_total_balance_is_correctly_calculated() throws Throwable {
			Double sum = null;
			ArrayList<Double> actualNumericVal = extractNumericValues(actual_text_val); //Extracting the numeric values from the String text value
			for (int i=0; i<actual_text_val.size()-1; i++){
				sum =+ actualNumericVal.get(i);
			}
			String actualTotalVal = new StringBuilder(Double.toString(sum)).insert(0, '$').toString();
			Assert.assertEquals("The total balance is", text_total_val, actualTotalVal);
		}

		@Then("^verify the values are formatted in currencies$") //Verifying, amount is prefixed with '$' symbol
		public void verify_the_values_are_formatted_in_currencies() throws Throwable {
			for (int i=0; i<=actual_text_val.size()-1; i++){
				Assert.assertEquals("Verifying, amount is prefixed with '$'", '$', actual_text_val.get(i).charAt(0));			
			}
		}

		
		
}
