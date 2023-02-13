package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc24 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		login();
		leads();
		NewLeadCreation();
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

	public static void leads() throws InterruptedException {
		// Thread.sleep(3000);
		// String expected = "Leads";
		WebElement leads = driver.findElement(By.xpath("//a[text()='Leads']"));
		waitForElementVisibility(leads);
		action(leads);
		click(leads);
		Thread.sleep(2000);
		WebElement prompt = driver.findElement(By.id("tryLexDialogX"));
		if (prompt.isEnabled()) {
			click(prompt);
			Thread.sleep(2000);

		}

	}public static void logout() throws InterruptedException {
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		action(userMenu);
		click(userMenu);
		WebElement logout = driver.findElement(By.xpath("//a[text() ='Logout']"));
		waitForElementVisibility(logout);
		System.out.println("in logout");
		click(logout);
	}

	

	public static void NewLeadCreation() throws InterruptedException {
		String expected = "ABCD";
		WebElement newButton = driver.findElement(By.xpath("(//input[@title='New'])[1]"));
		click(newButton);
		WebElement lastName = driver.findElement(By.xpath("(//input[@id='name_lastlea2'])[1]"));
		sendText(lastName,"ABCD" ,"lastNAme in newLeadCreation");
		WebElement company = driver.findElement(By.xpath("(//input[@id='lea3'])[1]"));
		sendText(company,"ABCD" ,"company in newLeadCreation");
		WebElement save = driver.findElement(By.xpath("(//input[@title='Save'])[2]"));
		click(save);
		WebElement header = driver.findElement(By.xpath("//h2[normalize-space()='ABCD']"));
		String actual =header.getText();
		System.out.println("Actual String:" + actual);
		if (actual.equals(expected)) {
			System.out.println("Test Case pass");
			WebElement delete = driver.findElement(By.xpath("(//input[@title='Delete'])[1]"));
			click(delete);
			driver.switchTo().alert().accept();
			
		}else {
		System.out.println("Test Case Failed");
		}
		Thread.sleep(4000);
	
	}
}
