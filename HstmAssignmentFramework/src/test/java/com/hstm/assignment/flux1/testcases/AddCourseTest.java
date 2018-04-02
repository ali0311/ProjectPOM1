package com.hstm.assignment.flux1.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AddCourse;
import com.hstm.assignment.flux1.AddStudent;
import com.hstm.assignment.flux1.AdminHomePage;
import com.hstm.assignment.flux1.AdminLoginPage;
import com.hstm.assignment.flux1.SearchAffiliationPage;

public class AddCourseTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	SearchAffiliationPage saPage;
	AddStudent aStudent;
	AddCourse aCourse;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);

	public AddCourseTest() {
		super();
	}

	@BeforeClass
	public void initialSetUp() {
		initialization();
		log.info("********Initializing*******");
		alPage = new AdminLoginPage();
		saPage = new SearchAffiliationPage();
		ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));
		saPage.searchAffiliation();
	}

	@Test(priority = 1)
	public void addCourseDetailTest() throws Exception {
		
		log.info("********Add Course Details_TC#1*******");
		aCourse = new AddCourse();
		String courseName = aCourse.addCourseDetail();
		aCourse.storeCourseData();
		System.out.println("New added course " + courseName);

	}

	@Test(priority = 2)
	public void successfulCrsAddingTest() {

		log.info("********Successful Course Adding Test_TC#1*******");
		String messageTag = aCourse.courseSuccessfulMessage();
		System.out.println(messageTag);
		String expMsg = "A publish request has been successfully submitted.\n"
		+"To view the status of this request, click the link below to go to Request Manager.";
		Assert.assertEquals(messageTag, expMsg, "There something Wrong...course isn't created");

	}

	@AfterClass
	public void closeBrowser() {
		
		log.info("********Closing Browser...New class AddAssignmentTest Test Begins*******");
		driver.quit();

	}

}
