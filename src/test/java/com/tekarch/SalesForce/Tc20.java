package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc20 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		login();
		leads();
		logout();
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

	
	public static void leads() throws InterruptedException {
		//Thread.sleep(3000);
		String expected = "Leads";
		WebElement leads = driver.findElement(By.xpath("//a[text()='Leads']"));
		waitForElementVisibility(leads);
		action(leads);
		click(leads);
		Thread.sleep(2000);
		WebElement prompt = driver.findElement(By.id("tryLexDialogX"));
		if (prompt.isEnabled()) {
			click(prompt);
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		WebElement leadPage = driver.findElement(By.xpath("//h1[text() = 'Leads']"));
		String actual = leadPage.getText();
		System.out.println("actual:" + actual);
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Test case pass");
		}else {
			System.out.println("Test case failed");
		}
		
	}
	
	public static void logout() throws InterruptedException {
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		action(userMenu);
		click(userMenu);
		WebElement logout = driver.findElement(By.xpath("//a[text() ='Logout']"));
		waitForElementVisibility(logout);
		System.out.println("in logout");
		click(logout);
		
	}
	}


