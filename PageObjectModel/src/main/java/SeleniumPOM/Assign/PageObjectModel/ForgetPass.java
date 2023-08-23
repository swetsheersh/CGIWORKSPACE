package SeleniumPOM.Assign.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetPass {
	
	WebDriver driver; 
	WebDriverWait wait;
	
	@FindBy(linkText = "Forgotten password?")
	WebElement forgetPass;
	
	@FindBy(xpath = "//*[@id=\"identify_email\"]")
	WebElement email;
	
	@FindBy(name="did_submit")
	WebElement search;
	
	@FindBy(linkText = "Cancel")
	WebElement cancle;

	public ForgetPass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void clickFPass() {
		this.forgetPass.click();
	}
	
	public void sendEmail(String email) {
		this.wait.until(ExpectedConditions.elementToBeClickable(cancle));
		this.email.sendKeys(email);
	}
	
	public void clickSearch() {
		this.search.submit();
	}
	
	
}
