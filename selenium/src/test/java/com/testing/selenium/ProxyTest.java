package com.testing.selenium;
import org.testng.annotations.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class ProxyTest {
	@Test
	public void f() {
		Proxy proxy = new Proxy();
	    proxy.setHttpProxy("<HOST:PORT>");
	    ChromeOptions options = new ChromeOptions();
	    //options.setCapability("proxy", proxy);
	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://www.google.com/");
	    driver.manage().window().maximize();
	    driver.quit();
	}
}
