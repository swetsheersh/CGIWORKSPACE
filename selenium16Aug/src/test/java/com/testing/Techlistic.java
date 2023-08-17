package com.testing;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;

public class Techlistic {
  @Test
  public void f() {
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  WebDriver driver=new ChromeDriver(options);
	  try {
		  driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  System.out.println(driver.getTitle());
		  driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[2]/input")).sendKeys("Ram");
		  driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[5]/input")).sendKeys("Doe");
		  driver.findElement(By.xpath("//*[@id=\"sex-0\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"exp-1\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).sendKeys("16 Aug 2023");
		  driver.findElement(By.xpath("//*[@id=\"profession-0\"]")).sendKeys("Manual Tester");
		  driver.findElement(By.xpath("//*[@id=\"profession-1\"]")).sendKeys("Automation Tester");
		  driver.findElement(By.xpath("//*[@id=\"tool-1\"]")).sendKeys("Selenium IDE");
		  driver.findElement(By.xpath("//*[@id=\"tool-2\"]")).sendKeys("Selenium Webdriver");
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  driver.findElement(By.xpath("//*[@id=\"continents\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"continents\"]/option[1]")).click();
		  driver.findElement(By.xpath("//*[@id=\"selenium_commands\"]/option[2]")).click();
		  //driver.findElement(By.xpath("//*[@id=\"photo\"]")).click();
		  //driver.findElement(By.xpath("//*[@id=\"photo\"]")).sendKeys("google.side");
		  //driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[28]/div[2]/div/a")).click();
		  //driver.navigate().back();
		  //driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
//		  driver.findElement(By.xpath("")).sendKeys("");
	} finally {
		//driver.quit();
	}
  }
}
