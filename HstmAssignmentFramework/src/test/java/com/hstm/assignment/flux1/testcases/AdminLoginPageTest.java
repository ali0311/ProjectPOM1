package com.hstm.assignment.flux1.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AdminHomePage;
import com.hstm.assignment.flux1.AdminLoginPage;

public class AdminLoginPageTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);

	public AdminLoginPageTest() {
		super();
	}

	@BeforeClass
	public void initialSetUp() {
		log.info("********Initializing*******");
		TestBase.initialization();
		alPage = new AdminLoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		log.info("********Test Title_TC#1*******");
		String title = alPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome to HealthStream", "Actual Title is not matching with expected Title");
	}

	@Test(priority = 2)
	public void hstmLogoTest() {
		log.info("********Test Logo_TC#2*******");
		boolean flag = alPage.validatehstmLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		log.info("********Login to Home Page_TC#3*******");
		ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Site Map", "Title is not Matching!");

	}

	@AfterClass
	public void closeBrowser() {
		log.info("********Closing Browser...New class AdminHomePage Test Begins*******");
		driver.quit();
	}

}
