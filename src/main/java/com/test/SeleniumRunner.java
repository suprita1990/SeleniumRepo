package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class SeleniumRunner {
	
	public static WebDriver driver = null;
	public static WebDriverHelper wh = null;
	
	public static void main(String[] args) {
		
		System.out.println("hello");
		System.out.println("hi");
		System.out.println("helloworld");
		setWebDriver();
		openHomePage();
		/*driver.findElement(By.id("headerSearch")).sendKeys("Hammer");
		driver.findElement(By.id("headerSearchButton")).click();*/
		wh.sendKeys(UIRepo.txtSearch, "Hammer");
		wh.click(UIRepo.btnSearch);
		if(wh.isElementPresent(UIRepo.verfyPlp)) {
			System.out.println("yep");
		} else {
			System.out.println("no");
		}
		//String text = null;
		
		//System.out.println( driver.findElement(By.cssSelector(".plp-pod:nth-of-type(2) .pod-plp__fulfillment-message")).getText());
		wh.getText(By.cssSelector(".plp-pod:nth-of-type(2) .pod-plp__fulfillment-message"));
		//getText(By.cssSelector(".plp-pod:nth-of-type(2) .pod-plp__fulfillment-message"));
		quitDriver();
	}
	
	public static void setWebDriver() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"Drivers/chromedriver.exe");
		driver = new  ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
		wh = new WebDriverHelper(driver);
		
		System.out.println(wh.getClass());
	}
	 
	public static void openHomePage() {
		driver.get("https://www.homedepot.com/");		
	}

	public static void testGIT() {
		System.out.println("Test GIT");
	}
	
	public static void quitDriver() {
		driver.quit();
	}
	
	
	
	
}
