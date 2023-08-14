package com.testing.selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeOption {
  @Test
  public void f() {
	  ChromeOptions option=new ChromeOptions();
	  option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  //option.setPageLoadStrategy(PageLoadStrategy.EAGER);
	  //option.setPageLoadStrategy(PageLoadStrategy.NONE);
	  WebDriver driver=new ChromeDriver(option);
	  try {
		  driver.get("https://google.com");
	  } finally {
		  driver.quit();
	  } 
	  
  }
}
