package com.hstm.assignment.flux1.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AddStudent;
import com.hstm.assignment.flux1.AdminHomePage;
import com.hstm.assignment.flux1.AdminLoginPage;
import com.hstm.assignment.flux1.SearchAffiliationPage;

public class AddStudentTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	SearchAffiliationPage saPage;
	AddStudent aStudent;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);
	
	public AddStudentTest(){
		super();
	}
	
	@BeforeClass
	public void initialSetUp(){
	initialization(); 
	log.info("********Initializing*******");
	alPage=new AdminLoginPage();
	saPage=new SearchAffiliationPage();
	ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));	
	saPage.searchAffiliation();
	}
	
	//@Test(priority=1, invocationCount=3)
	@Test(priority=1)
	public void addStudentDetailsTest() throws Exception{
		log.info("********Add Stdudent Details_TC#1*******");
		aStudent = new AddStudent();
		String newStudent=aStudent.addStudentDetail();
		aStudent.storeAllStudentData();
		System.out.println("New Student Created "+newStudent);
		
	}
	@Test(priority=2)
	public void successfulStdntAddingTest(){
		
		log.info("********Successful Stdudent Adding Test_TC#2*******");
		String messageTag = aStudent.validateSuccessfulMessage();
		Assert.assertEquals(messageTag,"The student was saved successfully.", "Unable to create new Student!");
		
	}
	
	@AfterClass
	public void closeBrowser(){
		log.info("********Closing Browser...New class ManageStudentPageTest Test Begins*******");
		driver.quit();
	}
	
	
	
}
