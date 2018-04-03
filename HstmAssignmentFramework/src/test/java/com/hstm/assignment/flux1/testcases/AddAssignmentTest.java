package com.hstm.assignment.flux1.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AddAssignment;
import com.hstm.assignment.flux1.AddCourse;
import com.hstm.assignment.flux1.AddStudent;
import com.hstm.assignment.flux1.AdminHomePage;
import com.hstm.assignment.flux1.AdminLoginPage;
import com.hstm.assignment.flux1.ManageStudentPage;
import com.hstm.assignment.flux1.SearchAffiliationPage;
import com.hstm.assignment.util.FrameworkUtil;

public class AddAssignmentTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	SearchAffiliationPage saPage;
	AddStudent aStudent;
	AddCourse aCourse;
	ManageStudentPage msPage;
	AddAssignment aaPage;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);
	
	public AddAssignmentTest() {
		super();
	}
	
	@BeforeClass
	public void initialSetUp() throws Exception {
		initialization();
		log.info("********Initializing*******");
		alPage = new AdminLoginPage();
		saPage = new SearchAffiliationPage();
		msPage = new ManageStudentPage();
		ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));
		saPage.searchAffiliation();
		msPage.validateUserLabel();
		
		
	}
	
	@DataProvider
	public Object[][] getInfoFromExcel(){
		log.info("********Get Data From Excel*******");
		FrameworkUtil fUtil = new FrameworkUtil();
		Object[][] tableArray = fUtil.getTestData("sheet1");
		return tableArray;
	}
	
	@Test(priority = 1, dataProvider="getInfoFromExcel")
	public void addAssignmentTest(String AssignmentName, String AssignmentDesc ) throws Exception{
		
		log.info("********Add Assignment Test*******");
		aaPage = new AddAssignment();
		aaPage.addAssignmentDetail(AssignmentName, AssignmentDesc);
		
	}
	
	
	@Test(priority=2)
	public void validateSuccessfulMessageTest(){
		
		log.info("********Validate Successful Test*******");
		String actMsg = aaPage.validateSuccessfulMessage();
		String expMsg = "The individual assignment was saved successfully.";
		Assert.assertEquals(actMsg, expMsg, "There something Wrong...assignment isn't created");
	}
	
	@AfterClass
	public void closeBrowser() {
		
		log.info("********Closing Browser...New class AddAssignmentTest Test Begins*******");
		driver.quit();

	}
	
	
}
