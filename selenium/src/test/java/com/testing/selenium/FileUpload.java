package com.testing.selenium;

import java.nio.file.Path;
import java.time.Duration;

import javax.tools.JavaFileManager.Location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
  @Test
  public void file() {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/upload");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.id("file-upload")).sendKeys(".lesshst");
	  driver.findElement(By.id("file-submit")).submit();
	  if(driver.getPageSource().contains("File Uploaded!")) {
		  System.out.println("File Uploaded");
	  }else {
		  System.out.println("File not Uploaded");
	  }
	  driver.quit();
  }
}
