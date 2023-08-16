package com.testing;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon {
  @Test
  public void f() throws Exception {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  System.out.println(driver.getTitle());
		  //driver.findElement(By.id("nav-hamburger-menu")).click();
		  //Thread.sleep(5000);
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		  WebElement ele=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
		  wait.until(d->ele.isDisplayed());
		  ele.click();
		  assertEquals("Watch Free Web Series & Short Films Online | Amazon miniTV", driver.getTitle());
		  driver.navigate().to("https://www.amazon.in/");
		  driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")).click();
		  assertEquals("Amazon.in Bestsellers: The most popular items on Amazon", driver.getTitle());
		  driver.navigate().to("https://www.amazon.in/");
		 
	} finally {
		driver.quit();
	}
  }
}
