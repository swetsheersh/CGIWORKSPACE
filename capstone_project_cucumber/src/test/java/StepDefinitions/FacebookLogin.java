package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.cucumber.pageobject.Login;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLogin {
	WebDriver driver;
	WebDriverWait wait;
	Login log;
	
	@Given("launch the browser")
	public void launch_the_browser() {
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		this.driver=new ChromeDriver(options);
	    //throw new io.cucumber.java.PendingException();
	}

	@And("Navigate to the URL")
	public void navigate_to_the_url() {
		this.log=new Login(driver);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	   // throw new io.cucumber.java.PendingException();
	}

	@When("enter the username as {string} and password as {string}")
	public void enter_the_username_and_password(String email,String pass) {
		this.log.sendUserName(email);
		this.log.sendPass(pass);
	   // throw new io.cucumber.java.PendingException();
	}

	@And("clickon submit button")
	public void clickon_submit_button() throws InterruptedException {
		this.log.clickLogin();
		Thread.sleep(4000);
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() throws InterruptedException {
		assertEquals(this.driver.getPageSource().contains("mind"),false);
		Thread.sleep(1000);
		driver.manage().deleteAllCookies();
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    this.driver.quit();
	  //  throw new io.cucumber.java.PendingException();
	}
	
	
}