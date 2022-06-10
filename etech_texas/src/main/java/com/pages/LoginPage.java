package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtils;

public class LoginPage {

	WebDriver driver = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="OrgID")
	private WebElement uid;

	@FindBy(id="Username")
	private WebElement uname;

	@FindBy(id="txtPassword")
	private WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;

	

	public void validLogin(){
		DriverUtils.sendKey(uid, "168");		
		DriverUtils.sendKey(uname, "kkL@mail.com");
		DriverUtils.sendKey(password, "Kamal@1?");
		DriverUtils.click(loginBtn);
	}
}
