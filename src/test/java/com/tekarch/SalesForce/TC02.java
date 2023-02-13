package com.tekarch.SalesForce;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class TC02 extends BaseClass{
	public static void main(String[] args) {
		login();
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
		sendText(password,pwd,"password");
		click(password);
		
		WebElement login = driver.findElement(By.id("Login"));
		click(login);
		
		WebElement homePage = driver.findElement(By.xpath("//title[text() = 'Home Page ~ Salesforce - Developer Edition']"));
		if(homePage.isEnabled()) {
			System.out.println("Login with valid data is passed");
		}else {
			System.out.println("Login with valid data is Failed");
		}
		driver.close();
	}
}
