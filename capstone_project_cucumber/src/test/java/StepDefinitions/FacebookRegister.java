package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.cucumber.pageobject.Register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookRegister {
	
	WebDriver driver;
	WebDriverWait wait;
	Register reg;
	
	@Given("launch the browser for register")
	public void launch_the_browser() {
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		this.driver=new ChromeDriver(options);
	    //throw new io.cucumber.java.PendingException();
	}
	
	@And("Navigate to the Register URL")
	public void navigate_to_the_register_url() {
		this.reg=new Register(driver);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@When("enter the data")
	public void enter_the_data() throws InterruptedException {
		reg.create();
		  reg.sendfirstName("fname");
		  reg.sendlastName("lname");
		  reg.sendEmail("email@gmail.com");
		  reg.resendEmail("email@gmail.com");
		  reg.sendpass("pass");
		  reg.sendday(String.valueOf((int)Double.parseDouble("11.0")));
		  reg.sendmonth(String.valueOf((int)Double.parseDouble("2.0")));
		  reg.sendyear(String.valueOf((int)Double.parseDouble("1998.0")));
		  reg.clickgender("Male");
	}

	@And("click submit button")
	public void click_submit_button() throws InterruptedException {
		reg.clickSubmit();
		 Thread.sleep(6000);
	}

	@Then("user should be Registered Successfully")
	public void user_should_be_registered_successfully() throws InterruptedException {
		assertEquals(driver.getCurrentUrl().contains("recover"), Boolean.parseBoolean("false"));
	}
	
	@Then("Close the browser register")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(2000);
	    this.driver.quit();
	  //  throw new io.cucumber.java.PendingException();
	}
}
