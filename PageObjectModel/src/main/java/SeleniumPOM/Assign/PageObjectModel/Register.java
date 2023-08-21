package SeleniumPOM.Assign.PageObjectModel;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
	
	WebDriver driver; 
	WebDriverWait wait;
	
	@FindBy(linkText = "Create new account")
	WebElement signUp;
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement surName;
	
	@FindBy(name="reg_email__")
	WebElement email;
	
	@FindBy(name="reg_email_confirmation__")
	WebElement reEmail;
	
	@FindBy(name="reg_passwd__")
	WebElement pass;
	
	@FindBy(name="birthday_month")
	WebElement month;
	
	@FindBy(name="birthday_year")
	WebElement year;
	
	@FindBy(name="birthday_day")
	WebElement day;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label")
	WebElement Male;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/label")
	WebElement Female;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[3]/label")
	WebElement Custom;
	
	@FindBy(name="preferred_pronoun")
	WebElement pronoun;
	
	@FindBy(name="custom_gender")
	WebElement cgen;
	
	@FindBy(name="websubmit")
	WebElement submit;

	public Register(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void create() throws InterruptedException {
		this.signUp.click();
		Thread.sleep(2000);
	}
	
	public void sendfirstName(String name) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.firstName));
		this.firstName.sendKeys(name);
	}
	
	public void sendlastName(String name) {
		this.surName.sendKeys(name);
	}
	
	public void sendEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void resendEmail(String email) {
		this.reEmail.sendKeys(email);
	}
	
	public void sendpass(String pass) {
		this.pass.sendKeys(pass);
	}
	
	public void sendmonth(String mon) {
		Select sel=new Select(this.month);
		sel.selectByValue(mon);
	}
	
	public void sendyear(String year) {
		Select sel=new Select(this.year);
		sel.selectByValue(year);
	}
	
	public void sendday(String day) {
		Select sel=new Select(this.day);
		sel.selectByValue(day);
	}
	
	public void clickgender(String gen) throws InterruptedException {
		if(gen=="Custom") {
			Actions act=new Actions(this.driver);
			act.moveToElement(this.Custom).perform();
			Thread.sleep(1000);
			this.Custom.click();
			Thread.sleep(2000);
			this.wait.until(ExpectedConditions.elementToBeClickable(this.pronoun));
			Select sel=new Select(this.pronoun);
			sel.selectByIndex(1);
			Thread.sleep(1000);
			this.cgen.sendKeys("Test");
		}else if(gen=="Female"){
			Actions act=new Actions(this.driver);
			act.moveToElement(this.Female).perform();
			Thread.sleep(1000);
			this.Female.click();
		}else {
			Actions act=new Actions(this.driver);
			act.moveToElement(this.Male).perform();
			Thread.sleep(1000);
			this.Male.click();
		}
	}
	
	public void clickSubmit() {
		this.submit.click();
	}
	
}
