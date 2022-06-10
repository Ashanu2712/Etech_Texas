package com.chat_test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Base.TestBase;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AgentLoginTest extends TestBase{
	WebDriver driver = null;
	LoginPage lp = null;

	@BeforeSuite
	public void setup(){
		log.info("Opening Mozilla Browser");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		log.info("Opening URL");
		driver.get("https://staging.enterice.com/chat");
		lp= new LoginPage(driver);
	}

	@AfterMethod
	@AfterSuite
	public void tearDown(){
		driver.close();
	}

	@Test
	public void verifyAgentLogin(){
		lp.validLogin();
		String expTitle = "ICE Agent Console";
		String actTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expTitle);
	}

}
