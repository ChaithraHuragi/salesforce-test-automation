package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;
import org.openqa.selenium.support.ui.Select;

public class TC23 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		login();
		leads();
		todaysLeads();
		logout();
		
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
		// Thread.sleep(3000);
		// String expected = "Leads";
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
	
	
	public static void todaysLeads() {
		String expected = "Today's Leads";
		WebElement view = driver.findElement(By.id("fcf"));
		String actual =returnSelectString(view,"Today's Leads");
		System.out.println("actual" + actual);
		if(actual.equals(expected)) {
			System.out.println("Test Case Pass");
		}else {
			System.out.println("test case fail");
		}
	}
	
	

}
