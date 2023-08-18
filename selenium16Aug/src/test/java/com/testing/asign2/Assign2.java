package com.testing.asign2;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assign2 {
	ChromeOptions options;
	WebDriver driver;
	@BeforeMethod
	public void first() {
		options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver=new ChromeDriver(options);
	}
	@Test(priority = 1)
	public void f() throws InterruptedException {
		//webdriver object with options
//		ChromeOptions options=new ChromeOptions();
//		  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		  WebDriver driver=new ChromeDriver(options);
		  try {
			  //navigating to page
			  driver.get("https://opensource-demo.orangehrmlive.com");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  //geting webelement
			  WebElement uname=driver.findElement(By.name("username"));
			  WebElement pass=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
			  WebElement login=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			  //blank username and pass.
			  login.submit();
			  Thread.sleep(3000);
			  String txt=uname.getAttribute("class");
			  Thread.sleep(2000);
			  assertEquals(txt,"oxd-input oxd-input--focus oxd-input--error");
			  //blank pass
			  uname.sendKeys("Test");
			  login.submit();
			  Thread.sleep(3000);
			  String txt1=pass.getAttribute("class");
			  assertEquals(txt1,"oxd-input oxd-input--active oxd-input--error");
			  Thread.sleep(2000);
			  //blank username
			  driver.navigate().refresh();
			 
			//geting webelement again due to refresh
			  uname=driver.findElement(By.name("username"));
			  pass=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
			  login=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			  uname.clear();
			  
			  Thread.sleep(3000);
			  pass.sendKeys("Test@123");
			  login.submit();
			  Thread.sleep(3000);
			  String txt2=uname.getAttribute("class");
			  Thread.sleep(2000);
			  assertEquals(txt2,"oxd-input oxd-input--active oxd-input--error");
			  
			  
			  //invalid username and password
			  Thread.sleep(3000);
			  uname.sendKeys("Test");
			  login.submit();
			  String msg=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
			  assertEquals(msg,"Invalid credentials");
			  
			  //valid username and password
			  
			//geting webelement again due to refresh
			  uname=driver.findElement(By.name("username"));
			  pass=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
			  login=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			  
			  uname.sendKeys("Admin");
			  pass.sendKeys("admin123");
			  Thread.sleep(1000);
			  login.submit();
			  Thread.sleep(2000);
			  assertEquals("OrangeHRM", driver.getTitle());
			  assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		} finally {
			driver.quit();
		}
	}
	@Test(priority = 2)
	public void logout() throws InterruptedException {
		try {
			//navigating to page
			  driver.get("https://opensource-demo.orangehrmlive.com");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//geting webelement again due to refresh
			  WebElement uname=driver.findElement(By.name("username"));
			  WebElement pass=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
			  WebElement login=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			  
			  uname.sendKeys("Admin");
			  pass.sendKeys("admin123");
			  Thread.sleep(1000);
			  login.submit();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/img")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.linkText("Logout")).click();
			  Thread.sleep(3000);
			  assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		} finally {
			driver.quit();
		}
	}
	@Test(priority = 0)
	public void empadd() throws InterruptedException {
		try {
			//navigating to page
			  driver.get("https://opensource-demo.orangehrmlive.com");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//geting webelement again due to refresh
			  WebElement uname=driver.findElement(By.name("username"));
			  WebElement pass=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
			  WebElement login=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
			  
			  uname.sendKeys("Admin");
			  pass.sendKeys("admin123");
			  Thread.sleep(1000);
			  login.submit();
			  Thread.sleep(2000);
			  //click admin
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
			  Thread.sleep(3000);
			  //click add
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			  Thread.sleep(2000);
			  //click select admin
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")).click();
			  
//			  Select sort1=new Select(driver.findElement(By.xpath("//div[@role='listbox']")));
//			  sort1.selectByIndex(0);
			 //selecting admin
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")).sendKeys(Keys.DOWN);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ENTER);
			  Thread.sleep(1000);
			  //input name
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("Odis  Adalwin");
			  //searching
			  Thread.sleep(3000);
			  
			  //selecting name
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys(Keys.DOWN);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys(Keys.ENTER);
			  Thread.sleep(1000);
			  
			  //selecting status
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.DOWN);
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ENTER);
			  Thread.sleep(2000);
			  
			  //Input Username
			  
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("Admin1");
			  //password
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("Test@123");
			  //confirm password
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("Test@123");
			  
			  //submit form
			  
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).submit();
			  Thread.sleep(Duration.ofSeconds(10));
			  assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
			  Thread.sleep(2000);
		} finally {
			driver.quit();
		}
	}
}
