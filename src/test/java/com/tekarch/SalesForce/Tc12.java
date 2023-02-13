package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tc12 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		editView();
	}
	public static void editView() throws InterruptedException {
		getDrive("Chrome");
		goToUrl("https://login.salesforce.com");

		WebElement userName = driver.findElement(By.id("username"));
		sendText(userName, "chaithrahuragi@tekarch.com", "username");
		click(userName);

		WebElement password = driver.findElement(By.id("password"));
		sendText(password,"Samarth@2016","password");
			click(password);
			
			WebElement login = driver.findElement(By.id("Login"));
			click(login);
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			String current = driver.getWindowHandle();
			WebElement account = driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
			Actions action = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(account));	
			action.moveToElement(account).build().perform();
			click(account);
			Thread.sleep(2000);
			
			WebElement prompt = driver.findElement(By.xpath("//*[@id='tryLexDialogX'] "));
			click(prompt);
		
			WebElement view = driver.findElement(By.xpath("//select[@id = 'fcf']"));
			Select ob = new Select(view);
			ob.selectByVisibleText("docview");
			
			WebElement edit = driver.findElement(By.xpath("//a[text() = 'Edit']"));
			click(edit);
			
			WebElement viewName = driver.findElement(By.xpath("//input [@id = 'fname']"));
			sendText(viewName,"docviewEdited" , "viewname ");
			click (viewName);
			WebElement save = driver.findElement(By.xpath("//input[@name = 'save']"));
			click(save);
			
			
			
	}

}
