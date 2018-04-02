package com.hstm.assignment.flux1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.util.FrameworkUtil;

public class AddStudent extends TestBase {

	// Page Factory

	@FindBy(linkText = "People")
	WebElement peopleTabLink;

	@FindBy(linkText = "Add a Student")
	WebElement addStudentLink;

	@FindBy(id = "uc_ue_txtLastName")
	WebElement lastNameTxtBox;

	@FindBy(id = "uc_ue_txtFirstName")
	WebElement firstNameTxtBox;

	@FindBy(id = "uc_ue_txtUsername")
	WebElement userId;

	@FindBy(id = "uc_ue_txtPassword")
	WebElement pwd;

	@FindBy(id = "uc_ue_txtConfirmPassword")
	WebElement confirmPwd;

	@FindBy(id = "uc_ste_c550769c-2a8d-43da-86ad-7bdd1b5db1a2")
	WebElement customFld;

	@FindBy(xpath = "//a[@id='uc_ste_calHireDatecal']/img")
	WebElement hireDateCaleIcon;

	@FindBy(name = "month")
	WebElement optionMn;

	@FindBy(name = "year")
	WebElement optionYr;

	@FindBy(id = "uc_ste_ddlDepartment")
	WebElement departmentName;

	@FindBy(xpath = "//a[@id='uc_ste_calEffectiveDatecal']/img")
	WebElement activeDateCaleIcon;

	@FindBy(xpath = "//div[@id='uc_ste_lsRoles_divLB']//input[@title='Student']")
	WebElement studentRoleCheckbox;

	@FindBy(id = "uc_btnSave")
	WebElement saveBtn;
	
	public static FrameworkUtil fUtil = new FrameworkUtil();
	public static String userID = fUtil.studentUserName();
	public static String fName = fUtil.studentFirstName();
	public static String lName = fUtil.studentLastName();
	public static WebElement data;

	// Initialization

	public AddStudent() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void storeAllStudentData() throws Exception{
		
		fUtil.WriteStudentDataToExcel("D://javaworkspace//HstmAssignmentFramework//src//main//resources//StudentData.xlsx");
	}
	
	public String addStudentDetail() {
		
		peopleTabLink.click();
		addStudentLink.click();
		
		lastNameTxtBox.sendKeys(lName);
		firstNameTxtBox.sendKeys(fName); 
		userId.sendKeys(userID);
		pwd.sendKeys(userID);
		confirmPwd.sendKeys(userID);
		
		/*lastNameTxtBox.sendKeys(fUtil.studentLastName());
		firstNameTxtBox.sendKeys(fUtil.studentFirstName());
		
		String sId = fUtil.studentUserName();
		
		userId.sendKeys(sId);
		pwd.sendKeys(sId);
		confirmPwd.sendKeys(sId)*/;

		fUtil.jsScrollDown();

		Select objSelect = new Select(customFld);
		objSelect.selectByIndex(1);

		// Define HireDate and ActiveDate
		String todayDate = fUtil.currentDate();
		String[] dateArr = todayDate.split("/");
		String day = dateArr[0];
		int month = Integer.parseInt(dateArr[1]);
		int year1 = Integer.parseInt(dateArr[2]);
		int year2 = year1 - 1;
		String year = String.valueOf(year2);

		hireDateCaleIcon.click();

		// Window Switching

		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String ParentWindowId = it.next();
		String ChildWindowId = it.next();

		driver.switchTo().window(ChildWindowId);

		// Select desired date for hire date
		Select mSelect = new Select(optionMn);
		mSelect.selectByIndex(month - 1);

		Select ySelect = new Select(optionYr);
		ySelect.selectByVisibleText(year);

		List<WebElement> dateListBox = new ArrayList<WebElement>();
		dateListBox = driver.findElements(By.xpath("//div[@id='Panel1']/table[2]/tbody/tr/td/input"));

		Iterator<WebElement> itr = dateListBox.iterator();
		while (itr.hasNext()) {
			WebElement dateNum = itr.next();
			if (dateNum.getAttribute("value").trim().equals(day)) {
				dateNum.click();
				break;
			}
		}
		driver.switchTo().window(ParentWindowId);

		Select dptSelect = new Select(departmentName);
		dptSelect.selectByIndex(1);

		activeDateCaleIcon.click();
		
		//Window Switching for activeDate

		Set<String> handler1 = driver.getWindowHandles();
		Iterator<String> it1 = handler1.iterator();
		String ParentWindowId1 = it1.next();
		System.out.println("P2 " + ParentWindowId1);
		String ChildWindowId1 = it1.next();
		System.out.println("C2 " + ChildWindowId1);

		driver.switchTo().window(ChildWindowId1);
		// Select desired date for active date
		Select mSelect1 = new Select(optionMn);
		mSelect1.selectByIndex(month - 1);

		Select ySelect1 = new Select(optionYr);
		ySelect1.selectByVisibleText(year);

		List<WebElement> dateListBox1 = new ArrayList<WebElement>();
		dateListBox1 = driver.findElements(By.xpath("//div[@id='Panel1']/table[2]/tbody/tr/td/input"));

		Iterator<WebElement> itr1 = dateListBox1.iterator();
		while (itr1.hasNext()) {
			WebElement dateNum1 = itr1.next();
			if (dateNum1.getAttribute("value").trim().equals(day)) {
				dateNum1.click();
				break;
			}
		}
		driver.switchTo().window(ParentWindowId1);

		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("arguments[0].scrollIntoView(true);", studentRoleCheckbox);
		studentRoleCheckbox.click();
		saveBtn.click();
		//driver.findElement(By.name("uc$btnSaveAdd")).click();;

		return userID;

	}

	public String validateSuccessfulMessage() {
		List<WebElement> list = new ArrayList<WebElement>();

		list = driver.findElements(By.xpath("//*[@id='uc_validationSummary_s']"));

		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			data = itr.next();
		}
		return data.getText().trim();

	}

}
