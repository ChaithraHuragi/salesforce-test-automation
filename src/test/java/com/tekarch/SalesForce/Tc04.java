package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc04 extends BaseClass {

	public static void main(String[] args) {
		forgotPassword();
		errorWIthInvalidCred();
	}

	public static void forgotPassword() {

		String expected = "Check Your Email";
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.valid.userid");
		String url = propertiesUtility.getPropertyData("url");
		getDrive("Chrome");
		goToUrl(url);

		WebElement forgot = driver.findElement(By.id("forgot_password_link"));
		click(forgot);

		WebElement usernameInforgot = driver.findElement(By.id("un"));
		waitForElementVisibility(usernameInforgot);
		sendText(usernameInforgot, userid, "username");
		click(usernameInforgot);

		WebElement submit = driver.findElement(By.id("continue"));
		click(submit);

		WebElement checkEmail = driver.findElement(By.className("mb12"));
		waitForElementVisibility(checkEmail);
		String actual = checkEmail.getText();
		if (actual.equalsIgnoreCase(expected))
			System.out.println("Test Case pass");
		else
			System.out.println("TestCase Fail");
		driver.close();

	}

	public static void errorWIthInvalidCred() {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.invalid.userid");
		String pwd = propertiesUtility.getPropertyData("login.invalid.password");
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

		WebElement errMsg = driver.findElement(By.id("chooser_error"));
		if (errMsg.isEnabled()) {
			System.out.println("Error message displaying test case pass");
		} else {
			System.out.println("Error message displaying test case failed");
		}
		driver.close();

	}

}
