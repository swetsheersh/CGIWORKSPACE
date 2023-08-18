package com.testing.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  driver.findElement(By.linkText("All")).click();
	  Thread.sleep(2000);
	  WebElement ele=driver.findElement(By.linkText("New Releases"));	 
	  Actions act=new Actions(driver);
//	  act.moveToElement(ele).perform();
//	  Thread.sleep(2000);
	  //ele.click();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  //WebElement clk= driver.findElement(By.xpath("//*[@id=\"hmenu-canvas\"]"))/*.click()*/;
	  //js.executeScript("arguments[0].click()", clk);   ///click 
	  
	  
	  WebElement ele1=driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]"));
	  act.moveToElement(ele1).perform();
	  Thread.sleep(2000);
//	  ele=driver.findElement(By.linkText("New Releases"));
//	  act.moveToElement(ele).perform();
	  //ele.click();
	  
	  WebElement clk= driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[2]"));
	  act.moveToElement(clk).perform();
	  clk.click();
	  
	  Thread.sleep(3000);
	  System.out.println(driver.getCurrentUrl());
	  driver.navigate().back();
	  System.out.println(driver.getCurrentUrl());
	 }
}
