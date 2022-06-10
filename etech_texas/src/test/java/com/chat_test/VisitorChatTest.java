package com.chat_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.Base.TestBase;
import com.pages.VisitorChatPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisitorChatTest extends TestBase{

	WebDriver driver = null;
	VisitorChatPage vp = null;

	@BeforeSuite
	public void setup(){
		log.info("Opening Edge Browser");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		log.info("Opening URL");
		driver.get("https://www.etechcareers.com/buttons/qa/language.html");
		vp = new VisitorChatPage(driver);
	}

	@Test
	public void verifyStartChat(){

		vp.initiateChat();
	}
}
