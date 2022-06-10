package com.utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionUtils {

	public static void radioButtuon(List<WebElement> radios, String value){
		for (WebElement radio : radios) {
			if(radio.getAttribute("value").equalsIgnoreCase(value)){
				radio.click();
				break;
			}
		}
	}

	public static void select(WebElement element, String value){
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static void checkbox(List<WebElement> checkboxes, List<String> values) {
		for (String value : values) {
			for (WebElement checkbox : checkboxes) {
				if(checkbox.getAttribute("value").equalsIgnoreCase(value)){
					checkbox.click();
					break;
				}
			}
		}
	}

	public static boolean checkLink(WebElement ele){
		return ele.isEnabled();

	}
	public static boolean checkLogo(WebElement ele)
	{
		return ele.isDisplayed();
	}
	
	public static boolean checkCheckox(WebElement ele)
	{
		return ele.isSelected();
	}
	
	public static void mouseClick(WebDriver driver, WebElement target){
		Actions act = new Actions(driver);
		act.click(target).build().perform();
	}
}
