package com.hstm.assignment.flux1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hstm.assignment.base.TestBase;

public class AdminLoginPage extends TestBase {

	//Page Factory
	
	@FindBy(id="ctl00_content_ctrlMobileLogin_txtUserId")
	WebElement userid;
	
	@FindBy(id="ctl00_content_ctrlMobileLogin_txtPassword")
	WebElement password;
	
	@FindBy(name="ctl00$content$ctrlMobileLogin$btnMobileLogin")
	WebElement submitBtn;
	
	@FindBy(xpath="//img[@id='imgLogo']")
	WebElement hstmLogo;
	
	//Initializing Page Objects
	public AdminLoginPage(){
		PageFactory.initElements(driver, this);	
	}
	
	//Actions
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatehstmLogo(){
		return hstmLogo.isDisplayed();
	}
	
	public AdminHomePage adminLogin(String uId, String pwd){
		userid.sendKeys(uId);
		password.sendKeys(pwd);
		submitBtn.click();
		return new AdminHomePage(); //As after login...it will return AdminHomePage class object
	}
	
	
}
