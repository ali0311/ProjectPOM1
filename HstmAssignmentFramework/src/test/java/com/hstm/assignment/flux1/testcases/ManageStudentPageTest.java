package com.hstm.assignment.flux1.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AddStudent;
import com.hstm.assignment.flux1.AdminHomePage;
import com.hstm.assignment.flux1.AdminLoginPage;
import com.hstm.assignment.flux1.ManageStudentPage;
import com.hstm.assignment.flux1.SearchAffiliationPage;
import com.hstm.assignment.util.FrameworkUtil;

public class ManageStudentPageTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	SearchAffiliationPage saPage;
	AddStudent aStudent;
	ManageStudentPage msPage;
	FrameworkUtil fUtil;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);

	public ManageStudentPageTest() {

		super();
	}

	@BeforeClass
	public void initialSetUp() {
		log.info("********Initializing*******");
		initialization();
		alPage = new AdminLoginPage();
		saPage = new SearchAffiliationPage();
		ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));
		saPage.searchAffiliation();

	}

	@Test(priority = 1)
	public void validateUserLabelTest() throws Exception {
		
		log.info("********Validate User Label Test_TC#1*******");
		msPage = new ManageStudentPage();
		String userLblName = msPage.validateUserLabel();
		fUtil = new FrameworkUtil();
		String lastName = fUtil.ReadStudentDataFromExcel(
				"D://javaworkspace//HstmAssignmentFramework//src//main//resources//StudentData.xlsx", 1, 1);
		String firstName = fUtil.ReadStudentDataFromExcel(
				"D://javaworkspace//HstmAssignmentFramework//src//main//resources//StudentData.xlsx", 1, 2);
		String stuName = firstName + " " + lastName;

		Assert.assertEquals(userLblName, stuName, "UserLable not matched");

	}

	@AfterClass
	public void closeBrowser() {
		
		log.info("********Closing Browser...New class AddCourseTest Test Begins*******");
		driver.quit();

	}

}
