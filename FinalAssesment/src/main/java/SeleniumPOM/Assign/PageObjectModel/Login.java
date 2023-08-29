package SeleniumPOM.Assign.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	WebDriverWait wait;
	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(id="login-button")
	WebElement submit;

	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void sendUser(String uname) {
		userName.sendKeys(uname);
	}
	
	public void sendPass(String pas) {
		pass.sendKeys(pas);
	}
	
	public void clickSubmit() {
		this.submit.submit();
	}
}
