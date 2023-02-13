package com.tekarch.SalesForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class TC21 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		login();
		leads();
		verifyDropDown();
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

	public static void verifyDropDown() {
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("All Open Leads", "My Unread Leads",
				"Recently Viewed Leads", "Today's Leads", "View - Custom 1", "View - Custom 2"));
		WebElement view = driver.findElement(By.id("fcf"));
		Select select = new Select(view);
		List<WebElement> list = select.getOptions();
		ArrayList<String> actual = new ArrayList<String>();

		for (WebElement ele : list) {
			String text = ele.getText();
			System.out.println(ele.getText());
			actual.add(text);
		}
		System.out.println("*************");
		System.out.println(actual);
		System.out.println(expected);
		if (expected.equals(actual)) {
			System.out.println("Test Case passed");
		} else {
			System.out.println("Test case failed");
		}

	}
}
