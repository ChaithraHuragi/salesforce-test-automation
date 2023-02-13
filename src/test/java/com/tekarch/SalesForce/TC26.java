package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class TC26 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		login();
		contacts();
		createNewView();
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
	
	public static void createNewView() throws InterruptedException {
		WebElement newViewButton = driver.findElement(By.xpath("//a[normalize-space()='Create New View']"));
		click(newViewButton);
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		
		sendText(viewName,"automation" ,"view name in contacts");
		String expected = "automation";
		System.out.println("Expected:"+ expected);
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		clear(viewUniqueName);
		sendText(viewUniqueName,"Tekarch","unique name in contact view");
		WebElement save = driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		click(save);
		Thread.sleep(3000);
		WebElement selectoption = driver.findElement(By.xpath("//select[@name='fcf']"));
		Select ob = new Select(selectoption);
		WebElement selected = ob.getFirstSelectedOption();
		String actual = selected.getText();
		System.out.println("Actual:"+ actual);
	
		if(actual.equals(expected)) {
			System.out.println("Test case pass");
		}else {
			System.out.println("Test case fail");
		}
	}
}
