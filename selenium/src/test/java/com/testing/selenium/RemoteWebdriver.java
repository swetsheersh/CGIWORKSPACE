package com.testing.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteWebdriver {
	@Test
	public void f() throws MalformedURLException {
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("http://sso.dev.saucelabs.com/test/guinea-file-upload");
//		WebElement upload = driver.findElement(By.id("myfile"));
//		upload.sendKeys("/Users/sso/the/local/path/to/darkbulb.jpg");
		
		System.setProperty("otel.traces.exporter", "jaeger");
		System.setProperty("otel.exporter.jaeger.endpoint", "http://localhost:14250");
		System.setProperty("otel.resource.attributes", "service.name=selenium-java-client");

		ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://www.example.com"),capabilities);

		driver.get("http://www.google.com");

		driver.quit();
	}

}
