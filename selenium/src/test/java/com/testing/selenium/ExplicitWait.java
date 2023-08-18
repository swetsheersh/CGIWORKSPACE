package com.testing.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class ExplicitWait {
  @Test
  public void f() {
	  WebDriver driver=new ChromeDriver();
      driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
      WebElement revealed=driver.findElement(By.id("revealed"));
      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
      driver.findElement(By.id("reveal")).click();
     // wait.until(d-> revealed.isDisplayed());
      wait.until(ExpectedConditions.visibilityOf(revealed));
      revealed.sendKeys("Displayed");
      
      
  }
}
