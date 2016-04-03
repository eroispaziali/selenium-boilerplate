package io.lofrattini.test;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MySeleniumTest {
	
	private WebDriver driver;
	
	@Before
	public void init() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// Capabilities
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.LINUX);
		
		// Properties
		String driverUrl = System.getProperty("selenium", "http://192.168.99.100:4444");
		
		// Connect to Selenium grid
		// Console is at %s/grid/console
		String compiledUrl = String.format("%s/wd/hub", driverUrl);
		driver = new RemoteWebDriver(new URL(compiledUrl), capabilities);
	}
	
	@Test
	public void myTestMethod() throws Exception {
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page title: " + title);
		assertEquals("Google", title);
		
		WebElement input = driver.findElement(By.name("q"));
		input.sendKeys("Selenium HQ");
		input.submit();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
