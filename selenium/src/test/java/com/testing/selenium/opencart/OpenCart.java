package com.testing.selenium.opencart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class OpenCart {
	@Test
	public void f() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		WebElement fname=driver.findElement(By.id("input-firstname"));
		fname.sendKeys("swet");
		WebElement lname=driver.findElement(By.id("input-lastname"));
		lname.sendKeys("sheersh");
		WebElement email=driver.findElement(By.id("input-email"));
		email.sendKeys("swet.kr.mis@gmail.com");
		WebElement pass=driver.findElement(By.xpath("//input[@id='input-password']"));
		pass.sendKeys("swet@123");
		//WebElement news=driver.findElement(By.xpath("//input[@id='input-newsletter-yes']"));
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		//WebElement checkboxElement = wait.until(ExpectedConditions.elementToBeClickable(news));
		//wait.until(d->news.isEnabled());
		//news.click();
		//WebElement check=driver.findElement(By.name("agree"));
		//check.click();
		WebElement submit1=driver.findElement(By.cssSelector(".btn-primary"));
		submit1.submit();
		}
}
