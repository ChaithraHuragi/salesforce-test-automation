package com.tekarch.SalesForce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc36 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		login();
		home();
		todaysDateLink();
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
		Thread.sleep(3000);
		WebElement prompt = driver.findElement(By.id("tryLexDialogX"));
		if (prompt.isEnabled()) {
			click(prompt);
			Thread.sleep(2000);
		}
	}

	public static void todaysDateLink() throws InterruptedException {
		WebElement today = driver.findElement(By.xpath("//td/a[@href='/00U/c?md0=2023&md3=42']"));
		click(today);
		WebElement eightpm = driver.findElement(By.xpath("//a[normalize-space()='8:00 PM']"));
		click(eightpm);
		WebElement subjectimg = driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
		click(subjectimg);
		String baseWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!baseWindowHandle.equals(handle))
				driver.switchTo().window(handle);
		}
		WebElement other = driver.findElement(By.xpath("//li[@class='listItem4']//a[1]"));
		click(other);
		Thread.sleep(3000);
		driver.switchTo().window(baseWindowHandle);
		WebElement end = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[4]/table/tbody/tr[3]/td[4]/div/span/span/input"));
		click(end);

		WebElement ninepm = driver.findElement(By.xpath("//*[@id='timePickerItem_42']"));
		click(ninepm);
		WebElement save = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		click(save);
		WebElement calender = driver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[29]/span[1]/div[1]/div[1]/div[1]/span[1]/a[1]/span[1]"));
		if (calender.isEnabled()) {
			System.out.println("test case pass");
		} else {
			System.out.println("test case fail");
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
}