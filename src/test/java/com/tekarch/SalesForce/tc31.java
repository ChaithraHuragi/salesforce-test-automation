package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class tc31 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		login();
		contacts();
		cancelCreateNewView();
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
	public static void contacts() throws InterruptedException {
		// Thread.sleep(3000);
		// String expected = "Leads";
		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		waitForElementVisibility(contacts);
		action(contacts);
		click(contacts);
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
	
	public static void cancelCreateNewView() throws InterruptedException {
		WebElement newViewButton = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		click(newViewButton);
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		
		sendText(viewName,"ABCD" ,"view name in contacts");
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		clear(viewUniqueName);
		sendText(viewUniqueName,"EFGH","unique name in contact view");
		WebElement cancel = driver.findElement(By.xpath("//input[@value='Cancel']"));
		click(cancel);
		Thread.sleep(3000);
		WebElement contacts1 = driver.findElement(By.xpath("//h2[text ()= ' Home']"));
		if(contacts1.isEnabled()) {
			System.out.println("Test case Pass");
		}else {
			System.out.println("Test case fail");
		}
}
}