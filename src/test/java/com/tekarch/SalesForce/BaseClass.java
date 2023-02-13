package com.tekarch.SalesForce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver =null;
	public static void getDrive(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "Safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			break;
		default :
			System.out.println("DriverName not recognised");
		}
	}
	
	public static void sendText(WebElement element,String text ,String webElementName) {
		if(element.isDisplayed()) {
			System.out.println("Find Element: " + webElementName);
			element.clear();
			element.sendKeys(text);
		}else {
			System.out.println(webElementName + "WebElement is not found  ");
		}
	}
		public static void goToUrl (String url)  {
			driver.get(url);
			
		}
		
		public static void click(WebElement webElement) {
			webElement.click();
		}
		
		public static void waitForElementVisibility(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		public static void action(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		
		public static void close() {
			driver.close();
		}
		
		public static void select(WebElement element,String value) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		
		}
		
		public static String returnSelectString(WebElement element,String value) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			return select.getFirstSelectedOption().getText();

	}
		public static void clear(WebElement element) {
			element.clear();
		}

}
