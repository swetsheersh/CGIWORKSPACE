package com.testing.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Test {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");
	  WebElement ele=driver.findElement(By.name("q"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	 // js.executeScript("alert('search webdriver')");
	  //Thread.sleep(5000);
	  ele.sendKeys("selenium webdriver");
	  Thread.sleep(1000);
	  //ele.submit();
	  WebElement clk= driver.findElement(By.name("btnK"))/*.click()*/;
	  js.executeScript("arguments[0].click()", clk);   ///click 
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,50)");
  }
}
