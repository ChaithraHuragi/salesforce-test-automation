package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc19 extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		login();
		oppurtunities();
		quatarlyLink();
		close();
	}

	public static void login() {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.valid.userid");
		String pwd = propertiesUtility.getPropertyData("login.valid.password");
		String url = propertiesUtility.getPropertyData("url");
		getDrive("Chrome");
		goToUrl(url);

		WebElement userName = driver.findElement(By.id("username"));
		sendText(userName, userid, "username");
		click(userName);

		WebElement password = driver.findElement(By.id("password"));
		sendText(password, pwd, "password");
		click(password);

		WebElement login = driver.findElement(By.id("Login"));
		click(login);
	}

	public static void oppurtunities() throws InterruptedException {
		WebElement oppurtunities = driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		waitForElementVisibility(oppurtunities);
		action(oppurtunities);
		click(oppurtunities);
		Thread.sleep(2000);
		WebElement prompt = driver.findElement(By.id("tryLexDialogX"));
		if (prompt.isEnabled()) {
			click(prompt);
			Thread.sleep(2000);
		}
	}
	
	public static void quatarlyLink() throws InterruptedException {
		Thread.sleep(2000);
		String expected = "Opportunity Report ~ Salesforce - Developer Edition";
		WebElement interval = driver.findElement(By.id("quarter_q")); 
		WebElement include = driver.findElement(By.id("open"));
		select(interval,"Current FQ");
		select(include,"All Opportunities");
		WebElement runReport = driver.findElement(By.xpath("//input[@title='Run Report']"));
		click(runReport);
		if(driver.getTitle().equalsIgnoreCase(expected)) {
			System.out.println("Test CAse pass");
		}
		else {
			System.out.println("test case fail");
		}
		
		
	}
	
	
	
}





