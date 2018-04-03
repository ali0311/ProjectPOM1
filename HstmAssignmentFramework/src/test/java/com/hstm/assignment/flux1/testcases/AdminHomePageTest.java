package com.hstm.assignment.flux1.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AdminHomePage;
import com.hstm.assignment.flux1.AdminLoginPage;
import com.hstm.assignment.util.FrameworkUtil;

public class AdminHomePageTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);

	public AdminHomePageTest() {
		super();
	}
	

	@BeforeClass
	public void initialSetUp() {
		initialization();
		log.info("********Initializing*******");
		alPage = new AdminLoginPage();
		ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		log.info("********Home Page_TC#1*******");
		String pageTitle = ahPage.validateHomePageTitle();
		Assert.assertEquals(pageTitle, "Site Map", "Title is not Matching!");
	}

	@Test(priority = 2)
	public void adminPageLabelTest() {
		log.info("********Admin Page Label_TC#2*******");
		String adminLabel = ahPage.validateAdminMainPageLabel();
		Assert.assertEquals(adminLabel, "Matt Wilson | HealthStream Main | Administrator", "Label is not Matching!");
	}

	@Test(priority = 3)

	public void clickPeopleTabTest() {
		log.info("********Click on People_TC#3*******");
		String peoplePageTitle = ahPage.clickOnPeopleTab();
		Assert.assertEquals(peoplePageTitle, "People", "Title is not Matching!");
	}

	@Test(priority = 4)

	public void clickCoursesTabTest() {
		log.info("********Click on Course_TC#4*******");
		String coursePageTitle = ahPage.clickOnCoursesTab();
		Assert.assertEquals(coursePageTitle, "Courses", "Title is not Matching!");
	}

	@Test(priority = 5)

	public void clickSimulationTabTest() {
		log.info("********Click on Simulation_TC#5*******");
		String simulationPageTitle = ahPage.clickonSimulationTab();
		Assert.assertEquals(simulationPageTitle, "Simulation", "Title is not Matching!");
	}
	
	@Test(priority = 6)

	public void clickAssessmentsTest() {
		log.info("********Click on Assessment_TC#6*******");
		String assessmentPageTitle = ahPage.clickonAssessmentsTab();
		Assert.assertEquals(assessmentPageTitle, "Assessments", "Title is not Matching!");
	}
	
	@Test(priority = 7)

	public void clickEducationTest() {
		log.info("********Click on Education_TC#7*******");
		String educationPageTitle = ahPage.clickonEducationTab();
		Assert.assertEquals(educationPageTitle, "Education", "Title is not Matching!");
	}
	@Test(priority = 8)

	public void clickReportsTest() {
		log.info("********Click on Reports_TC#8*******");
		String reportsPageTitle = ahPage.clickonReportsTab();
		Assert.assertEquals(reportsPageTitle, "Reports", "Title is not Matching!");
	}
	
	@Test(priority = 9)

	public void clickToolsTest() {
		log.info("********Click on Tools_TC#9*******");
		String toolsPageTitle = ahPage.clickonToolsTab();
		Assert.assertEquals(toolsPageTitle, "Tools", "Title is not Matching!");
	}
	
	@Test(priority = 10)

	public void clickServicesTest() {
		log.info("********Click on Tools_TC#10*******");
		String servicesPageTitle = ahPage.clickonServicesTab();
		Assert.assertEquals(servicesPageTitle, "Services", "Title is not Matching!");
	}
	
	@Test(priority = 11)

	public void clickMyProfileTest() {
		log.info("********Click on Tools_TC#11*******");
		String myProfilePageTitle = ahPage.clickonMyProfileTab();
		Assert.assertEquals(myProfilePageTitle, "My Profile", "Title is not Matching!");
	}
	
	@AfterClass
	public void closeBrowser(){
		log.info("********Closing Browser...New class Search Affiliation Test Begins*******");
		driver.quit();
	}
	
	
}
