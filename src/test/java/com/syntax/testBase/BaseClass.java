package com.syntax.testBase;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.syntax.utils.ConfigUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass   {

	public static WebDriver driver;
	public static String browser = ConfigUtility.getProperty("browser");


	@BeforeMethod(alwaysRun = true)
	public static void setUp() {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(ConfigUtility.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		driver.quit();
	}

}
