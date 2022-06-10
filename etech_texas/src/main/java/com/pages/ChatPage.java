package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtils;

public class ChatPage {

	WebDriver driver = null;
	public ChatPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="profiledd")
	private WebElement profile;

	@FindBy(xpath= "//em[@xpath='1']")
	private WebElement close;

	@FindBy(xpath="//label[@xpath='1']")
	private WebElement survey;

	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath="//span[contains(text(),'Tea Break')]")
	private WebElement logoutReason;

	@FindBy(xpath="//input[@value='OK']")
	private WebElement okBtn;

	@FindBy(xpath="//span[contains(text(),'Success')]")
	private WebElement disposition;


	public void closeChat(){
		DriverUtils.click(close);
		driver.switchTo().alert().accept();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", disposition);
		DriverUtils.click(survey);
		DriverUtils.click(submit);
	}

	public void logoutAgent(){
		DriverUtils.click(profile);
		DriverUtils.click(logout);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logoutReason);
		DriverUtils.click(okBtn);
	}
}
