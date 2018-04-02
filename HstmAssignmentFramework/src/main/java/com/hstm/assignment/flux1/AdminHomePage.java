package com.hstm.assignment.flux1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hstm.assignment.base.TestBase;

public class AdminHomePage extends TestBase {

	// Page Factory

	/*
	 * @FindBy(
	 * xpath="//*[@id='identity-bar']/tbody/tr/td[@class='txxs' and @height='23']"
	 * ) WebElement adminLabel
	 */;

	@FindBy(linkText = "People")
	WebElement peopleTabLink;

	@FindBy(linkText = "Courses")
	WebElement courseLink;

	@FindBy(linkText = "Simulation")
	WebElement simulationLink;

	@FindBy(linkText = "Assessments")
	WebElement assessmentsLink;

	@FindBy(linkText = "Education")
	WebElement educationLink;

	@FindBy(linkText = "Reports")
	WebElement reportsLink;

	@FindBy(linkText = "Tools")
	WebElement toolsLink;

	@FindBy(linkText = "Services")
	WebElement servicesLink;

	@FindBy(linkText = "My Profile")
	WebElement myProfileLink;

	public static WebElement data;

	// initializing

	public AdminHomePage() {

		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public String validateAdminMainPageLabel() {

		List<WebElement> list = new ArrayList<WebElement>();

		list = driver.findElements(By.xpath("//*[@id='identity-bar']/tbody/tr/td[@class='txxs' and @height='23']"));

		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			data = itr.next();
		}
		return data.getText().trim();

	}

	public String clickOnPeopleTab() {
		peopleTabLink.click();
		return driver.getTitle();
	}

	public String clickOnCoursesTab() {
		courseLink.click();
		return driver.getTitle();
	}

	public String clickonSimulationTab() {
		simulationLink.click();
		return driver.getTitle();
	}

	public String clickonAssessmentsTab() {
		assessmentsLink.click();
		return driver.getTitle();
	}

	public String clickonEducationTab() {
		educationLink.click();
		return driver.getTitle();
	}

	public String clickonReportsTab() {
		reportsLink.click();
		return driver.getTitle();
	}

	public String clickonToolsTab() {
		toolsLink.click();
		return driver.getTitle();
	}

	public String clickonServicesTab() {
		servicesLink.click();
		return driver.getTitle();
	}

	public String clickonMyProfileTab() {
		myProfileLink.click();
		return driver.getTitle();
	}

}
