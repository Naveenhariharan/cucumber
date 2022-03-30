package com.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePhoneValidationSteps {
	static WebDriver driver;
	long startTime1;
	String name1;
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	   
	}

	@Given("user login by entering valid crendentials")
	public void user_login_by_entering_valid_crendentials() {
	     
		try {
			
			WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
			close.click();
		}catch (Exception e) {
			
		}
	    
	}

	@When("user search mobile")
	public void user_search_mobile() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("samsung",Keys.ENTER);
		
		
	   
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
		 WebElement mobile = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F12 (Sky Blue, 64 GB)']"));
	        name1 = mobile.getText();
	       System.out.println(name1);
	       mobile.click();
	    
	}

	@Then("user validate the mobile names")
	public void user_validate_the_mobile_names() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String X : child) {
			
			if (!parent.equals(X)) {
				driver.switchTo().window(X);
				
	   
	}



}
}
}