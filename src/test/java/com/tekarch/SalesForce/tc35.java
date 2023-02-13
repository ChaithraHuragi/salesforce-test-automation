package com.tekarch.SalesForce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class tc35 extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		login();
	allTabs();
	removeMyTab();
		logout();
		close();
		login();
		allTabs();
		verifyRemoveTab();
		

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
	
	public static void logout() throws InterruptedException {
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		action(userMenu);
		click(userMenu);
		WebElement logout = driver.findElement(By.xpath("//a[text() ='Logout']"));
		waitForElementVisibility(logout);
		System.out.println("in logout");
		click(logout);
	}
	public static void allTabs() throws InterruptedException {
		WebElement alltab = driver.findElement(By.xpath("//img[@title ='All Tabs']"));
		waitForElementVisibility(alltab);
		action(alltab);
		click(alltab);
		Thread.sleep(2000);
		/*
		 * WebElement prompt = driver.findElement(By.id("tryLexDialogX")); if
		 * (prompt.isEnabled()) { click(prompt); Thread.sleep(2000); }
		 */
	}
	
	public static void removeMyTab() throws InterruptedException {
		WebElement customize = driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		click(customize);
		Thread.sleep(2000);
		WebElement selectTab = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		//click(selectTab);
		Thread.sleep(4000);
		select(selectTab,"Assets");
		WebElement remove = driver.findElement(By.xpath("//img[@alt ='Remove']"));
		click(remove);
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		click(save);
	}
	public static void verifyRemoveTab() throws InterruptedException {
		String tabRemoved = "Assets";
		WebElement customize = driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		click(customize);
		Thread.sleep(2000);
		WebElement selectTab = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		click(selectTab);
		Select ob = new Select(selectTab);
		List<WebElement> str = ob.getAllSelectedOptions();
		for(WebElement ele : str) {
			String actual = ele.getText();
			if(actual.equals(tabRemoved)) {
				System.out.println("test case fail");
				break;
			}
			
		}
		System.out.println("test case pass");
		WebElement availabletabs= driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		select( availabletabs,"Assets");
		WebElement add = driver.findElement(By.xpath("//img[@alt ='Add']"));
		click(add);
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		click(save);
	}
			
		}
	
	
	
	
