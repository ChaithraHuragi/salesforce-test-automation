package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc29 extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		login();
		contacts();
		myContactView();
	//	logout();
	//	close();
		
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
	
	public static void myContactView() throws InterruptedException {
		WebElement myContacts = driver.findElement(By.id("fcf"));
		select(myContacts,"My Contacts");
		WebElement contactName = driver.findElement(By.xpath("//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		//String expected = contactName.getText();
		//System.out.println("Expected:" + expected);
		click(contactName);
		Thread.sleep(2000);
		WebElement topName = driver.findElement(By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
		String actual = topName.getText();
		System.out.println("actual : " + actual);
		//click(topName);
		
		if(topName.isEnabled()) {
			System.out.println("Test Case pass");
		}else {
			System.out.println("Test case fail");
		}

		
	}
	

}
