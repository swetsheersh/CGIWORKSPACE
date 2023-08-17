package com.testing.selenium.Aug17;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WindowHandle {
  @Test
  public void f() throws InterruptedException {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://letcode.in/windows");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  String parent=driver.getWindowHandle();
		  driver.findElement(By.id("home")).click();
		  Thread.sleep(3000);
		  List<String> l1=new ArrayList<String>(driver.getWindowHandles());
		  for(String i:l1) {
			  System.out.println(l1.size());
		  }
		  driver.switchTo().window(l1.get(1));
		  System.out.println(driver.getCurrentUrl());
		  Thread.sleep(3000);
		  driver.switchTo().window(l1.get(0));
		  System.out.println(driver.getCurrentUrl());
	  }finally {
		  driver.quit();
	  }
  }
}
