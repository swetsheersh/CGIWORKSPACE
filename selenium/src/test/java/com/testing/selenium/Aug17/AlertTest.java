package com.testing.selenium.Aug17;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AlertTest {
  @Test
  public void f() {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://letcode.in/alert");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.id("accept")).click();
		  Alert al= driver.switchTo().alert();
		  System.out.println(al.getText());
		  al.accept();
		  driver.findElement(By.id("confirm")).click();
		  Alert al1= driver.switchTo().alert();
		  System.out.println(al1.getText());
		  al1.dismiss();
		  driver.findElement(By.id("prompt")).click();
		  Alert al2= driver.switchTo().alert();
		  al2.sendKeys("test");
		  System.out.println(al2.getText());
		  al2.accept();
	  }finally {
		  //driver.quit();
	  }
  }
}
