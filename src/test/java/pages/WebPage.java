package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage {

	WebDriver driver;
	
	WebElement t_val1 = driver.findElement(By.id("txt_val_1"));
	WebElement t_val2 = driver.findElement(By.id("txt_val_2"));
	WebElement t_val3 = driver.findElement(By.id("txt_val_3"));
	WebElement t_val4 = driver.findElement(By.id("txt_val_4"));
	WebElement t_val5 = driver.findElement(By.id("txt_val_5"));
	
	
}
