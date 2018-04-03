/*
 * @Author Ali
 * @Version 1.0
 */
package com.hstm.assignment.flux1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.util.FrameworkUtil;

public class AddAssignment extends TestBase {

	// Page Factory

	@FindBy(linkText = "Assignments")
	WebElement assginmentLink;

	@FindBy(id = "uc_ft_aga")
	WebElement addAssignLink;

	@FindBy(id = "uc_txtAssignmentName")
	WebElement assignName;

	@FindBy(id = "uc_txtDescription")
	WebElement assignDesc;

	@FindBy(id = "uc_lnkAddCourses")
	WebElement selectCrsLink;

	@FindBy(id = "txtSearchString")
	WebElement crsSearch;

	@FindBy(id = "btnSearch")
	WebElement searchBtn;

	@FindBy(id = "rC_ctl00_cC")
	WebElement crsSelect;

	@FindBy(id = "btnSelect")
	WebElement selectBtn;

	@FindBy(id = "uc_assignmentTiming_calEffectiveDate")
	WebElement effectiveDate;

	@FindBy(id = "uc_assignmentTiming_calStartDate")
	WebElement startDate;

	@FindBy(id = "uc_assignmentTiming_calFixedDueDate")
	WebElement dueDate;

	@FindBy(id = "btnSave")
	WebElement saveBtn;

	public static WebElement data;

	// Initialization

	public AddAssignment() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public String addAssignmentDetail(String aName, String aDesc) throws Exception {

		assginmentLink.click();
		addAssignLink.click();
		assignName.sendKeys(aName);
		assignDesc.sendKeys(aDesc);

		FrameworkUtil fUtil = new FrameworkUtil();
		fUtil.jsScrollDown();
		selectCrsLink.click();
		String courseDataPath = System.getProperty("user.dir")
				+ "//src//main//java//com//hstm//assignment//testdata//CourseData.xlsx";
		String crsName = fUtil.ReadStudentDataFromExcel(courseDataPath, 1, 0);
		crsSearch.sendKeys(crsName);
		searchBtn.click();
		crsSelect.click();
		selectBtn.click();
		String pDate = fUtil.selectPastDate();
		effectiveDate.clear();
		effectiveDate.sendKeys(pDate);
		startDate.clear();
		startDate.sendKeys(pDate);
		String fDate = fUtil.selectFutureDate();
		dueDate.sendKeys(fDate);
		saveBtn.click();
		return aName;

	}

	public String validateSuccessfulMessage() {
		List<WebElement> list = new ArrayList<WebElement>();

		list = driver.findElements(By.id("uc_validationSummary_s"));

		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			data = itr.next();
		}
		return data.getText().trim();

	}

}
