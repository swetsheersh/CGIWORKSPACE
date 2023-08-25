package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.cucumber.pageobject.ForgetPass;
import com.selenium.cucumber.pageobject.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgetPassStep {
	
	WebDriver driver;
	WebDriverWait wait;
	ForgetPass forPass;
	
	@Given("launch the browser for forget pass")
	public void launch_the_browser_for_forget_pass() {
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		this.driver=new ChromeDriver(options);
	}

	@And("Navigate to the forget pass URL")
	public void navigate_to_the_forget_pass_url() {
		this.forPass=new ForgetPass(driver);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@When("enter the email")
	public void enter_the_email() throws InterruptedException {
		this.forPass.clickFPass();;
		 Thread.sleep(2000);
		 this.forPass.sendEmail("email@gmail.com");
	}

	@And("clickon search button")
	public void clickon_search_button() throws InterruptedException {
		this.forPass.clickSearch();
		Thread.sleep(5000);
	}

	@Then("Recovery page should be displayed")
	public void recovery_should_be_displayed() {
		assertEquals(this.driver.getPageSource().contains("Recover"), Boolean.parseBoolean("true"));
		driver.manage().deleteAllCookies();
	}

	@And("Close the browser tab")
	public void close_the_browser_tab() {
	    this.driver.quit();
	}
}
