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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hstm.assignment.base.TestBase;

public class SearchAffiliationPage extends TestBase {

	// PageFactory - OR

	@FindBy(linkText = "Tools")
	WebElement toolsLink;

	@FindBy(linkText = "Manage Organizations")
	WebElement manageOrgLink;

	@FindBy(id = "txtOrgName")
	WebElement orgSearchBox;

	@FindBy(id = "btnSearch")
	WebElement searchBtn;

	@FindBy(linkText = "ACME HealthCare")
	WebElement orgLinkName;

	@FindBy(id = "txtSearch")
	WebElement affSearchBox;

	@FindBy(linkText = "GEN01 - ACME General Medical Center")
	WebElement affLinkName;
	
/*	@FindBy(xpath="//td//a[@href='/HLC/Admin/ChangeAffiliation.aspx']")
	WebElement affLabel; */
	
	public WebElement data;

	// Element Initialization

	public SearchAffiliationPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String searchAffiliation() {
		toolsLink.click();
		manageOrgLink.click();
		orgSearchBox.sendKeys(prop.getProperty("orgExtId"));
		searchBtn.click();
		orgLinkName.click();
		affSearchBox.sendKeys(prop.getProperty("affiliationName"));
		searchBtn.click();
		affLinkName.click();

		return driver.getTitle();

	}
	
	public String affiliationNameLabel(){
		
		List<WebElement> list = new ArrayList<WebElement>();

		list = driver.findElements(By.xpath("//td//a[@href='/HLC/Admin/ChangeAffiliation.aspx']"));

		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			data = itr.next();
		}
		return data.getText().trim();
	}
	
	

}
