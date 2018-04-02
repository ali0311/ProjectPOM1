package com.hstm.assignment.flux1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AddStudent;
import com.hstm.assignment.util.FrameworkUtil;
public class ManageStudentPage extends TestBase {
	
	//Page Factory
	
	@FindBy(linkText = "People")
	WebElement peopleTabLink;
	
	@FindBy(linkText = "Manage Students")
	WebElement manageStudentLink;
	
	@FindBy(id = "ctl00_CPH_txtUserID")
	WebElement userIDSrchBox;
	
	@FindBy(id = "ctl00_CPH_adminBar_ctl00_btnSearch")
	WebElement srchBtn;
	
	@FindBy(id = "ctl00_CPH_grdS_ctl02_lnkName")
	WebElement userNameLink;
	
	public WebElement data;
	
	//Initialization
	
	public ManageStudentPage(){
	
		PageFactory.initElements(driver, this);
	}
	
	public String validateUserLabel() throws Exception{
		
		//Read Student Details
		
		FrameworkUtil fUtil = new FrameworkUtil();
		String studentUserId =fUtil.ReadStudentDataFromExcel("D://javaworkspace//HstmAssignmentFramework//src//main//resources//StudentData.xlsx", 1, 0);
		peopleTabLink.click();
		manageStudentLink.click();
		System.out.println(studentUserId);
		userIDSrchBox.sendKeys(studentUserId);
		srchBtn.click();
		userNameLink.click();
		
		
		List<WebElement> list = new ArrayList<WebElement>();

		list = driver.findElements(By.xpath("//li[@class='rtLI rtFirst rtLast']//span[@class='rtIn']"));

		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			data = itr.next();
		}
		return data.getAttribute("title").trim();
	}

}
