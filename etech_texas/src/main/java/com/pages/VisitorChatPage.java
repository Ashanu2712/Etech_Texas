package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverUtils;

public class VisitorChatPage {

	WebDriver driver = null;
	public VisitorChatPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName="input")
	private WebElement clickHere;

	@FindBy(id="imgH")
	private WebElement onBtn;

	public void initiateChat(){
		DriverUtils.click(clickHere);
		DriverUtils.click(onBtn);

	}
}
