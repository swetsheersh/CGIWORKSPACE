package com.testing.selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class FirstTest {
	@Test
	public void mytest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		String title=driver.getTitle();
		assertEquals("Web form", title);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textbox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		textbox.sendKeys("selenium");
		submitButton.click();
		
		WebElement message=driver.findElement(By.id("message"));
		String value=message.getText();
		assertEquals("Received!", value);
		
		driver.quit();
		
	}

}
