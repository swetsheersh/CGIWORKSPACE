package com.testing.selenium.Aug17;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Aug17 {
  @Test
  public void f() throws InterruptedException {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.navigate().to("https://www.google.com/");
		  System.out.println(driver.getTitle());
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  System.out.println(driver.getTitle());
		  Thread.sleep(3000);
		  driver.navigate().back();
		  System.out.println(driver.getTitle());
		  Thread.sleep(3000);
		  driver.navigate().forward();
		  System.out.println(driver.getTitle());
	} finally {
		driver.quit();
	}
  }
}
