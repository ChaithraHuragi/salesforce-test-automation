package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc17 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		login();
		oppurtunities();
		oppurtunitiesPipelineLink();
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
	
	public static void oppurtunitiesPipelineLink() {
		String expected = "Opportunity Pipeline" ;
		WebElement pipeLine =driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
		click(pipeLine);
		WebElement actualTitle = driver.findElement(By.xpath("//h1[text()='Opportunity Pipeline']"));
		String actual = actualTitle.getText();
		if(actual.equals(expected)) {
			System.out.println("Test case pass");
		}else {
			System.out.println("test case fail");
		}
		
	}

}
