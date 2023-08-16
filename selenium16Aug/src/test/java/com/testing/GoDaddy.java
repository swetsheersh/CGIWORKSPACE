package com.testing;

import static org.testng.Assert.assertEquals;

import java.time.Duration;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoDaddy {
  @Test
  public void f() throws Exception{
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://www.godaddy.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  System.out.println(driver.getTitle());
		  assertEquals("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN", driver.getTitle());
		  assertEquals("https://www.godaddy.com/en-in", driver.getCurrentUrl());
		  assertEquals(false,driver.getPageSource().contains(driver.getTitle()));
	} finally {
		driver.quit();
	}
  }
}
