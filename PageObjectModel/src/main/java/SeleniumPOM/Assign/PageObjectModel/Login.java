package SeleniumPOM.Assign.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	WebDriver driver; 
	WebDriverWait wait;
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(name="login")
	WebElement login;

	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void sendUserName(String uname) {
		this.userName.sendKeys(uname);
	}
	
	public void sendPass(String pass) {
		this.pass.sendKeys(pass);
	}
	
	public void clickLogin() {
		this.wait.until(ExpectedConditions.elementToBeClickable(login));
		this.login.submit();
	}
	
}
