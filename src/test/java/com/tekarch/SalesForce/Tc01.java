package com.tekarch.SalesForce;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc01 extends BaseClass {
	public static void main(String[] args) throws IOException {
		errorMessageBlankPassword();
	}

	public static void errorMessageBlankPassword() throws IOException {
		PropertiesUtility propertiesUtility = new PropertiesUtility();
		propertiesUtility.loadFile("loginDataProperties");
		String userid = propertiesUtility.getPropertyData("login.valid.userid");
		String url = propertiesUtility.getPropertyData("url");
		getDrive("Chrome");
		goToUrl(url);

		WebElement userName = driver.findElement(By.id("username"));
		sendText(userName, userid, "username");
		click(userName);

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		click(password);

		WebElement login = driver.findElement(By.id("Login"));
		click(login);

		WebElement error = driver.findElement(By.xpath("//div[text() = 'Please enter your password.']"));
		if (error.isEnabled()) {
			System.out.println("TestCase Pass");
		} else {
			System.out.println("Error message test Case fail");
		}
		driver.close();
	}
}