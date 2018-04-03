/*
 * @Author Ali
 * @Version 1.0
 */

package com.hstm.assignment.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hstm.assignment.util.FrameworkUtil;
import com.hstm.assignment.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String configPath = System.getProperty("user.dir")
			+ "//src//main//java//com//hstm//assignment//config//config.properties";
	public static String currentDir = System.getProperty("user.dir");
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(configPath);
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			String chromeDriverPath= currentDir + prop.getProperty("chromePath");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			String firefoxDriverPath=currentDir + prop.getProperty("firefoxPath");
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();

		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(FrameworkUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(FrameworkUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
