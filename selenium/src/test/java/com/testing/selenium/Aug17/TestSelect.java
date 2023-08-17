package com.testing.selenium.Aug17;



import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestSelect {
  @Test
  public void f() {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://demo.opencart.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.linkText("Desktops")).click();
		  driver.findElement(By.linkText("Mac (1)")).click();
		  driver.findElement(By.id("input-sort")).click();
		  Select sort1=new Select(driver.findElement(By.id("input-sort")));
		  sort1.selectByIndex(5);
	} finally {
		//driver.quit();
	}
  }
}
