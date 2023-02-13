package com.tekarch.SalesForce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc10 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		login();
		account();
		createAccount();
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
	
	public static void account() throws InterruptedException {
		
			Thread.sleep(3000);
			String current = driver.getWindowHandle();
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
	public static void createAccount() throws InterruptedException{
			WebElement createNew = driver.findElement(By.id("createNew"));
			Thread.sleep(2000);
			click(createNew);
			Thread.sleep(2000);
			WebElement accountinlist = driver.findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[4]"));
			click(accountinlist);
			
			WebElement accName =driver.findElement(By.xpath("//*[@id=\"acc2\"]"));
			waitForElementVisibility(accName);
			sendText(accName, "chaka", "accountName");
			click(accName);
			WebElement type = driver.findElement(By.xpath("//*[@id='acc6']"));
			Select ob1= new Select(type);
			ob1.selectByValue("Technology Partner");
			
			WebElement priority= driver.findElement(By.xpath("//*[@id = '00NDn00000Sjaix']"));
			Select ob2= new Select(priority);
			ob2.selectByValue("High");
			
			WebElement save = driver.findElement(By.xpath("//*[@name='save']"));
			click(save);
			WebElement topName = driver.findElement(By.className("topName"));
			if(topName.isEnabled()) {
				System.out.println("Test case pass");
			}else {
				System.out.println("tst case fail");
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
