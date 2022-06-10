package com.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.LoginPage;
import com.utility.PropertiesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase{

	static WebDriver driver = null;
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark= null;
	public static ExtentTest test= null;
	public static Logger log = Logger.getLogger("TestBase");


	public static WebDriver initalization() {

		String browser = PropertiesUtils.readProperty("browser");	
		if(browser.equalsIgnoreCase("chrome")) {
			log.info("Opening Chrome Browser");
			WebDriverManager.chromedriver().setup();
			//			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			log.info("Opening Mozilla Browser");
			System.setProperty("webdriver.gecko.driver", "E:/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		log.info("Opening URL");
		return driver;
	}
	public void reportInit() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}

	public String captureScreenshot(String name) {
		log.info("capturing screenshot for failed testcase");
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"/screenshots/"+name+"_"+getDate()+".jpg";
		File dest= new File(path);	
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = sdf.format(new Date());

		return date;
	}

	public LoginPage loadLoginPage(){
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
}

