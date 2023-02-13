package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc33 extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		login();
		home();
		validateHome();
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
	public static void home() throws InterruptedException {
		WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
		waitForElementVisibility(home);
		action(home);
		click(home);
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
		Thread.sleep(2000);
		}
	

	
	public static void validateHome() {
		 WebElement myProfile = driver.findElement(By.xpath("//h1/a[@href='/_ui/core/userprofile/UserProfilePage']"));
		 String expected = myProfile.getText();
		 System.out.println("Expected:" + expected);
		 click(myProfile);
		 WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		 action(userMenu);
		 click(userMenu);
		 WebElement userMenuMyProfile = driver.findElement(By.xpath("//a[text() ='My Profile']"));
		 click(userMenuMyProfile);
		 WebElement profilename = driver.findElement(By.id("tailBreadcrumbNode"));
		 String actual = profilename.getText().trim();
		 System.out.println("actual:" + actual);
		 if(actual.equals(expected)) {
			 System.out.println("test case pass");
		 }else {
			 System.out.println("Test case fail");
		 }
		 
	}
}
