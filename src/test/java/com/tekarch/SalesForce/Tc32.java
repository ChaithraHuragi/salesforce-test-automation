package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc32 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		login();
		contacts();
		createNewContact();
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
	
	public static void createNewContact() {
		WebElement newButton = driver.findElement(By.xpath("(//input[@title='New'])[1]"));
		click(newButton);
		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		sendText(lastName,"Indian" ,"last name in create new contact");
		WebElement acctName = driver.findElement(By.id("con4"));
		sendText(acctName,"Global Media","Account Name ");
		WebElement save = driver.findElement(By.xpath("//input[@value='Save & New']"));
		click(save);
		WebElement error = driver.findElement(By.xpath("//div[@class='errorMsg']"));
		if(error.isEnabled()) {
			System.out.println("test case pass");
		}else {
			System.out.println("test case fail");
		}
		
		
	}
}
