package com.tekarch.SalesForce;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc03 extends BaseClass {

	public static void main(String args[]) throws InterruptedException {
		login();
		logout();
		validateCheck();
		close();
	}

	public static void login()  {
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
	
	
	public static void logout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(userMenu));
		action.moveToElement(userMenu).build().perform();
		click(userMenu);

		WebElement logout = driver.findElement(By.xpath("//a[text() ='Logout']"));
		wait.until(ExpectedConditions.visibilityOf(logout));
		click(logout);
		Thread.sleep(3000);

	}
	
	public static void validateCheck() throws InterruptedException {
		Thread.sleep(2000);
		WebElement rememberme = driver.findElement(By.xpath("//*[@id='idcard-identity']"));
		if(rememberme.isEnabled()) {
			System.out.println("TestCase pass");
		}else {
			System.out.println("test case fail");
		}
		
	}
}

