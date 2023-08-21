package SeleniumPOM.Assign.PageObjectModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterSuite;

public class RegisterTest {
	WebDriver driver;
	Register reg;
	
  @Test
  public void verifyRegister() throws Exception {
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
	  
	 // Thread.sleep(3000);
	  //reg=new Register(driver);
	  reg.create();
	  reg.sendfirstName("Saurav");
	  reg.sendlastName("CGI");
	  reg.sendEmail("saurav@gmail.com");
	  reg.resendEmail("saurav@gmail.com");
	  reg.sendpass("Test@123");
	  reg.sendday("12");
	  reg.sendmonth("5");
	  reg.sendyear("1990");
	  reg.clickgender("Custom");
	  reg.clickSubmit();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executing Test...");
	  this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  this.reg=new Register(driver);
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Register Test...");
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  this.driver=new ChromeDriver(options);
  }

  @AfterSuite
  public void afterSuite() {
	 // this.driver.quit();
  }

}
