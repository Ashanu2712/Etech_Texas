package com.chat_test;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Base.TestBase;
import com.pages.ChatPage;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChatTest extends TestBase{

	WebDriver driver = null;
	ChatPage cp = null;
	LoginPage lp = null;

	@BeforeSuite
	public void setup(){
		log.info("Opening Mozilla Browser");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		log.info("Opening URL");
		driver.get("https://staging.enterice.com/chat");
		cp= new ChatPage(driver);
		lp = new LoginPage(driver);
	}

	@AfterSuite
	public void tearDown(){
		driver.close();
	}

	@Test(priority=1)
	public void verifyCloseChat(){
		lp.validLogin();
		cp.closeChat();
	}


	@Test(priority=2)
	public void verifyAgentLogout(){

		cp.logoutAgent();
		String expTitle = "ICE | Login";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

}
