package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc07 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		login();
		userMenuDropDown();
		mySettings();
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

		WebElement rememberMe = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		click(rememberMe);

		WebElement login = driver.findElement(By.id("Login"));
		click(login);
	}
	public static void userMenuDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(userMenu));
		action.moveToElement(userMenu).build().perform();
		click(userMenu);
		
	}
	public static void mySettings() throws InterruptedException {
			
			WebElement mySettings = driver.findElement(By.xpath("//a[text() = 'My Settings']"));
			click(mySettings);
			Thread.sleep(4000);
			
			WebElement personal = driver.findElement(By.xpath("//span[text() = 'Personal']"));
			waitForElementVisibility(personal);
			click(personal);
			
			WebElement  loginhistory = driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
			click(loginhistory);
			
			WebElement download = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
			click(download);
			
			WebElement personal1 = driver.findElement(By.xpath("//span[text() = 'Personal']"));
			waitForElementVisibility(personal1);
			click(personal1);
			
			WebElement displayandLayout = driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
			waitForElementVisibility(displayandLayout);
			click(displayandLayout);
			
			WebElement customizeTab = driver.findElement(By.xpath("//span[@id = 'CustomizeTabs_font']"));
			click(customizeTab);
			
			WebElement customApp = driver.findElement(By.id("p4"));
			Select ob = new Select(customApp);
			ob.selectByVisibleText("Salesforce Chatter");
			
			WebElement selectAvailable = driver.findElement(By.xpath("//select[@id='duel_select_0']"));
			Select ob1 = new Select(selectAvailable);
			ob1.selectByVisibleText("Reports");
			
			WebElement rightArrow = driver.findElement(By.xpath("//img[@title='Add']"));
			click(rightArrow);
			
			WebElement selected = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
			Select ob2 = new Select(selected);
			ob2.selectByVisibleText("Reports");
			WebElement displayandLayout1 = driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
			//wait.until(ExpectedConditions.visibilityOf(displayandLayout1));
			waitForElementVisibility(displayandLayout1);
			click(displayandLayout1);
			
			
			WebElement email = driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
			click(email);
			
			WebElement myEmail = driver.findElement(By.xpath("//a[@id='EmailSettings_font']"));
			click(myEmail);
			
			WebElement emailName = driver.findElement(By.xpath("//input[@id='sender_name']"));
			waitForElementVisibility(emailName);
			sendText(emailName, "chaithra huragi", "Email Name");
			
			WebElement emailId = driver.findElement(By.id("sender_email"));
			sendText(emailId, "chaithrahuragi@tekarch.com","emailid");
			
			
			
			WebElement save = driver.findElement(By.xpath("//input[@title='Save']"));
			if(save.isEnabled()) {
				System.out.println("Test case pass");
			}else {
				System.out.println("test case fail");
			}
			click(save);
			driver.switchTo().alert().accept();
			
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
