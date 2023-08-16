package com.testing.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplictWait {
  @Test
  public void f() {
	  WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
      driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
      driver.findElement(By.id("adder")).click();

      WebElement added = driver.findElement(By.id("box0"));
  }
}
