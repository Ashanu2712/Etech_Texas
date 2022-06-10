package com.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtils {
	static WebDriver driver = null;

	public static void sendKey(WebElement element, String value){
		element.clear();
		element.sendKeys(value);
	}

	public static void click(WebElement element){

		element.click();

	}

	public static void clear(WebElement element){

		element.clear();

	}
	
	public static String getText(WebElement element){
		return element.getText();

	}

	public static void clickList(List<WebElement> elements){
		for (WebElement element : elements) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			element.click();
		}
	}

	public static ArrayList<String> getTextList(List<WebElement> elements) throws Exception{
		ArrayList<String> actuals = new ArrayList<String>();

		for (WebElement element : elements) {
			actuals.add(element.getText());
		}
		return actuals;
	}
	

	public static void windowHandler(List<WebElement> elements, WebDriver driver) throws Exception {

		String mainWindow = driver.getWindowHandle();

		for (WebElement link : elements) {
			link.click();

			Set<String>windows=driver.getWindowHandles();
			for(String window:windows ){
				driver.switchTo().window(window);
				if(!mainWindow.equals(window)){
					Thread.sleep(3000);
					driver.close();
				}
				driver.switchTo().window(mainWindow);
			}
		}
	}

	public static String popupAlert(){
		String alert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alert;
	}
	
	public static void selectComboList(WebElement country, List<WebElement> selects,String option) 
	{
		country.click();
		for(WebElement select:selects)
		{
			if (select.getText().equalsIgnoreCase(option)) 
			{
				select.click();
				break;
			}
		}
	}

}