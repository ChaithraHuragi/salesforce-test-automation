package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class Tc13 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		login();
		account();
		mergeAccounts();
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
	WebElement account = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
	Actions action = new Actions(driver);
	waitForElementVisibility(account);
	action.moveToElement(account).build().perform();
	click(account);
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

public static void mergeAccounts() throws InterruptedException {
	WebElement merge = driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
	click(merge);
	WebElement textbox = driver.findElement(By.xpath("//input[@id='srch']"));
	click(textbox);
	sendText(textbox,"Chaithra","Chaithra account to merge");
	//Thread.sleep(3000);
	WebElement findAccounts = driver.findElement(By.xpath("//input[@name='srchbutton']"));
	click(findAccounts);
	Thread.sleep(3000);
	WebElement next = driver.findElement(By.xpath("//*[@id='stageForm']/div/div[2]/div[5]/div/input[1]"));
	click(next);
	//*[@id="stageForm"]/div/div[2]/div[5]/div/input[1]
	Thread.sleep(2000);
	WebElement mergebutton = driver.findElement(By.xpath("//input[@value=' Merge ']"));
	click(mergebutton);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	WebElement home = driver.findElement(By.xpath("//h2[normalize-space()='Home']"));
	if(home.isEnabled()) {
		System.out.println("Test case Pass");
	}else {
		System.out.println("test case fail");
	}
	
}


}

