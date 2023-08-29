package SeleniumPOM.Assign.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	
	WebDriverWait wait;
	WebDriver driver;

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement add;
	
	@FindBy(xpath ="//*[@id=\"shopping_cart_container\"]/a")
	WebElement logo;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement fName;
	
	@FindBy(id="last-name")
	WebElement lName;
	
	@FindBy(id="postal-code")
	WebElement zip;
	
	@FindBy(id="continue")
	WebElement conti;
	
	@FindBy(id="finish")
	WebElement finish;
	
	
	
	public Cart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void clickadd() {
		wait.until(ExpectedConditions.elementToBeClickable(add));
		add.click();
	}
	
	public void clicklogo() {
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
	}
	
	public void clickcheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(checkout));
		checkout.click();
	}
	
	public void sendFname(String res) {
		wait.until(ExpectedConditions.elementToBeClickable(fName));
		fName.sendKeys(res);
	}
	
	public void sendLname(String res) {
		wait.until(ExpectedConditions.elementToBeClickable(lName));
		lName.sendKeys(res);
	}
	
	public void sendZip(String res) {
		wait.until(ExpectedConditions.elementToBeClickable(zip));
		zip.sendKeys(res);
	}
	
	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(conti));
		conti.submit();
	}
	
	public void clickfinish() {
		wait.until(ExpectedConditions.elementToBeClickable(finish));
		finish.click();
	}
		
	}
