package com.testing.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FluentWaitTest {
  @Test
  public void f() {
	 // WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		Wait wait=new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		
		WebElement ele=driver.findElement(By.name("q1"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		ele.sendKeys("Selenium Latest Version");
		ele.submit();
		driver.close();
			  
  }
}
