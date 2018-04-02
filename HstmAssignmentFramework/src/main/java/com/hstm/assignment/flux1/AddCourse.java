package com.hstm.assignment.flux1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.util.FrameworkUtil;

public class AddCourse extends TestBase {

	// Page Factory

	@FindBy(linkText = "Courses")
	WebElement courseTabLink;

	@FindBy(linkText = "Add a Course")
	WebElement addCourseLink;

	@FindBy(id = "cc_txtCourseName")
	WebElement crsTitle;

	@FindBy(id = "cc_txtDescription")
	WebElement crsDesc;

	@FindBy(id = "cc_lnkAddCategories")
	WebElement crsCtgLink;

	@FindBy(xpath = "//*[@id='cc_tc']/ul/li/ul/li[1]/div/label/input")
	WebElement sltCtg;

	@FindBy(id = "adminBar_ctl00_btnSelect")
	WebElement selectBtn;

	@FindBy(id = "cc_btnSave")
	WebElement saveBtn;

	@FindBy(id = "courseContainer_hlkTest")
	WebElement addTestLink;

	@FindBy(id = "cc_txtName")
	WebElement testName;

	@FindBy(id="cc_radECTH_Input")
	WebElement hrSelect;

	@FindBy(id = "cc_radECTM_Input")
	WebElement mnSelect;

	@FindBy(id = "courseContainer_QuestionGroups_ctl00_linkGroupEditor")
	WebElement defGrpLink;

	@FindBy(id = "courseContainer_btnAddNewQuestion")
	WebElement addQueLink;

	@FindBy(id = "courseContainer_btnSubmit")
	WebElement continueBtn;

	@FindBy(id = "cc_txtQuestionName")
	WebElement QueName;
	
	@FindBy(xpath = "//*[@id='cc_q_contentIframe']")
	WebElement CrsText;

	@FindBy(id = "courseContainer_QuestionList1_Questions_ctl00_chkRequired")
	WebElement selectQue;

	@FindBy(id = "courseContainer_btnUpdateMandatory")
	WebElement umBtn;

	@FindBy(id = "courseContainer_ft_cc_lnkPublish")
	WebElement pblshLink;
	
	@FindBy(id = "courseContainer_btnQuickPublish")
	WebElement quickPbsh;

	@FindBy(id = "courseContainer_btnConfirm")
	WebElement cnfrmLink;

	public static FrameworkUtil fUtil = new FrameworkUtil();
	public static String crstitle = fUtil.courseName();
	public static WebElement data;

	// Initialization

	public AddCourse() {
		PageFactory.initElements(driver, this);

	}

	// Actions	

	public void storeCourseData() throws Exception {

		fUtil.WriteCourseDatatoExcel("D://javaworkspace//HstmAssignmentFramework//src//main//resources//CourseData.xlsx");
	}
	

	public String addCourseDetail() {

		courseTabLink.click();
		addCourseLink.click();
		crsTitle.sendKeys(crstitle);
		crsDesc.sendKeys("Course added for Automation purposes");
		
		fUtil.jsScrollDown();
		crsCtgLink.click();
		sltCtg.click();
		selectBtn.click();
		saveBtn.click();
		addTestLink.click();
		testName.clear();
		testName.sendKeys("Test1");
		
		hrSelect.sendKeys("2");
		mnSelect.sendKeys("2");
		
		saveBtn.click();
		defGrpLink.click();
		addQueLink.click();
		continueBtn.click();
		QueName.sendKeys("First Question");
		CrsText.sendKeys("Q-1. 2+2 is equal to 4. True or False ?");
		
		saveBtn.click();
		selectQue.click();
		umBtn.click();
		pblshLink.click();
		quickPbsh.click();
		cnfrmLink.click();

		return crstitle;

	}

	public String courseSuccessfulMessage() {

		List<WebElement> list = new ArrayList<WebElement>();

		list = driver.findElements(By.id("courseContainer_validationSummary_s"));

		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			data = itr.next();
		}
		return data.getText().trim();
	}

}
