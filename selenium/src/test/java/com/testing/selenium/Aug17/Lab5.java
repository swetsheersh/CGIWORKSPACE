package com.testing.selenium.Aug17;



import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Lab5 {
  @Test
  public void f() throws InterruptedException {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://demo.opencart.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  assertEquals("Your Store", driver.getTitle());
		  driver.findElement(By.linkText("My Account")).click();
		  driver.findElement(By.linkText("Register")).click();
		 /* List<WebElement> l1=driver.findElements(By.cssSelector("input.form-control"));
		  for(WebElement web:l1) {
			  System.out.println(web);
		  }*/
		  assertEquals("Register Account",driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText());
		  WebElement fname=driver.findElement(By.id("input-firstname"));
			fname.sendKeys("swet");
			WebElement lname=driver.findElement(By.id("input-lastname"));
			lname.sendKeys("sheersh");
			WebElement email=driver.findElement(By.id("input-email"));
			email.sendKeys("Test@gmail.com");
			WebElement pass=driver.findElement(By.xpath("//input[@id='input-password']"));
			pass.sendKeys("Test@123");
			//scroll page
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			//
			Thread.sleep(2000);
			WebElement news=driver.findElement(By.xpath("//*[@id=\"input-newsletter-yes\"]"));
			//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			//WebElement checkboxElement = wait.until(ExpectedConditions.elementToBeClickable(news));
			//wait.until(d->news.isEnabled());
			news.click();
			Thread.sleep(2000);
			WebElement check=driver.findElement(By.name("agree"));
			check.click();
			WebElement submit1=driver.findElement(By.cssSelector(".btn-primary"));
			submit1.submit();
	} finally {
		driver.quit();
	}
  }
}
