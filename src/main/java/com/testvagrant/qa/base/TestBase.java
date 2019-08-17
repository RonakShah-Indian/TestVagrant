package com.testvagrant.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.testvagrant.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	static String url= "https://www.cleartrip.com/";
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/testvagrant"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome") || browserName.equals("Chrome")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-geolocation");
			option.addArguments("disable-notifications");
			setDriverPath();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/resources/chromedriver");
			driver = new ChromeDriver(option);
		}
		else if(browserName.equals("FF") || browserName.equals("firefox") || browserName.equals("Firefox")){
			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			option.addPreference("app.update.enabled", false);
			option.addPreference("geo.enabled", false);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/resources/geckodriver");
			driver = new FirefoxDriver(option);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);
	}

	public boolean isFound(WebElement element) {
		Long timeOut = TestUtil.IMPLICIT_WAIT;
		try {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
				if (element.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
					return true;
				} else {
					return false;
				}
			}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			return false;
		}
	}

	public void waitForAnElement() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void waitForLoading() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	private static void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "/resources/chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "/resources/chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "/resources/chromedriver_linux");
		}
	}
}
