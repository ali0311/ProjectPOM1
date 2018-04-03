package com.hstm.assignment.flux1.testcases;

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
import com.hstm.assignment.flux1.SearchAffiliationPage;

public class SearchAffiliationPageTest extends TestBase {

	AdminLoginPage alPage;
	AdminHomePage ahPage;
	SearchAffiliationPage saPage;
	Logger log = Logger.getLogger(AdminLoginPageTest.class);
	
	public SearchAffiliationPageTest(){
		
		super();
	}
	
	@BeforeClass
	public void initialSetUp(){
	initialization();
	log.info("********Initializing*******");
	alPage=new AdminLoginPage();
	saPage=new SearchAffiliationPage();
	ahPage = alPage.adminLogin(prop.getProperty("userId"), prop.getProperty("password"));	
	
	}
	
	@Test(priority=1)
	public void searchAffiliationTest(){
		log.info("********Search Affiliation Page_TC#1*******");
		String title=saPage.searchAffiliation();
		Assert.assertEquals(title, "Site Map", "Title is not Matching!");
	}
	@Test(priority=2)
	public void affiliationNameLabelTest(){
		log.info("********Affiliation Name Label_TC#2*******");
		String affLabelName =saPage.affiliationNameLabel();
		Assert.assertEquals(affLabelName, "ACME General Medical Center", "Affiliation Label is not Matching!");
	}
	
	@AfterClass
	public void closeBrowser(){
		log.info("********Closing Browser...New class AddStudent Test Begins*******");
		driver.quit();
	}
	
	
	
}
