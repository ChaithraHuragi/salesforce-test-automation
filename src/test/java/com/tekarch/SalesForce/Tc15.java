package com.tekarch.SalesForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc15 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		login();
		oppurtunities();
		verifyDropDownView();
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

	public static void verifyDropDownView() {
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("All Opportunities", "Closing Next Month",
				"Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline",
				"Private", "Recently Viewed Opportunities", "Won"));

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
