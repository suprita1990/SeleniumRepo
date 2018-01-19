package com.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverHelper {
	WebDriver driver = null;
	long maxImplicitWait = 45;
	public WebDriverHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By elementBy) {
		boolean elementPresent = false;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		try {
			elementPresent = driver.findElement(elementBy).isDisplayed();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(maxImplicitWait,TimeUnit.SECONDS);
		return elementPresent;
	}
	
	public void sendKeys(By elementBy, String text) {
		if(isElementPresent(elementBy)) {
			driver.findElement(elementBy).sendKeys(text);
		}		
	}
	
	public void click(By elementBy) {
		if(isElementPresent(elementBy)) {
			driver.findElement(elementBy).click();
		}
	}
	public String getText(By elementBy) {
		String text = "";
		if(isElementPresent(elementBy)) {
			text = driver.findElement(elementBy).getText();
		}
		System.out.println("Text is : "+text);
		return text;
	}
	
	
}
