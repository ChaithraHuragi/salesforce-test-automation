package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc11 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		login();
		account();
		createNewView();
		//logout();
		//close();
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
	
	public static void account() throws InterruptedException {
		
			Thread.sleep(3000);
			//String current = driver.getWindowHandle();
			WebElement account = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));

			waitForElementVisibility(account);
			action(account);
			click(account);
			Thread.sleep(2000);

			WebElement prompt = driver.findElement(By.xpath("//*[@id='tryLexDialogX'] "));
			if(prompt.isEnabled()) {
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
	
		
			WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
			waitForElementVisibility(createNewView);
			click(createNewView);
			
			WebElement viewName = driver.findElement(By.xpath("//input [@id = 'fname']"));
			sendText(viewName,"docview22" , "viewname ");
			click (viewName);
			
			WebElement viewUniqueName = driver.findElement(By.xpath("//input [@id = 'devname']"));
			sendText(viewUniqueName,"docview22","view uniquename");
			click(viewUniqueName);
		
			WebElement save = driver.findElement(By.xpath("//input[@name = 'save']"));
			click(save);
			
			WebElement check = driver.findElement(By.id("00BDn00000L9SD8_listSelect"));
			if(check.isEnabled()) {
				System.out.println("test case pass");
			}else {
				System.out.println("test case fail");
			}
			
	}
	
}
