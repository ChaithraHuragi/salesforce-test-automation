package com.tekarch.SalesForce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc08 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		login();
		userMenuDropDown();
		devloperConsole();
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

		WebElement rememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		click(rememberMe);

		WebElement login = driver.findElement(By.id("Login"));
		click(login);
	}

	public static void userMenuDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(userMenu));
		action.moveToElement(userMenu).build().perform();
		click(userMenu);

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

	public static void devloperConsole() {
		WebElement devCons = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		click(devCons);

		Set<String> handles = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		for (String handle : handles) {
			if (!current.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}

		}
		driver.close();
		System.out.println("test case pass");
		driver.switchTo().window(current);

	}

}
