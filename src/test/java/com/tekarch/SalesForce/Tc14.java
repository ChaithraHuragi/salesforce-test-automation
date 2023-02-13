package com.tekarch.SalesForce;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tc14 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		createAccountReport();
	}
	public static void createAccountReport() throws InterruptedException {
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
			WebElement accountHistory = driver.findElement(By.xpath("//a[text() = 'Accounts with last activity > 30 days']"));
			click(accountHistory);
			
	//		WebElement noThanks = driver.findElement(By.xpath("//button[text() = 'No Thanks']"));
	//		click(noThanks);
			
			WebElement from = driver.findElement(By.xpath("//img[@id=\"ext-gen152\"]"));
			wait.until(ExpectedConditions.visibilityOf(from));
			click(from);
			
			WebElement today = driver.findElement(By.xpath("//button[text() = 'Today']"));
			wait.until(ExpectedConditions.visibilityOf(today));
			click(today);
			
			WebElement save =driver.findElement(By.xpath("//button[@id = 'ext-gen49']"));
			click(save);
			
			WebElement reportName = driver.findElement(By.xpath("//input[@name = 'reportName']"));
			sendText(reportName, "Test report5", "reportName");
			click(reportName);
			
			
			WebElement reportUniqueName = driver.findElement(By.xpath("//input[@name = 'reportDevName']"));
			//reportUniqueName.clear();
			sendText(reportUniqueName, "Tekarch5", "reportUniqueName");
			click(reportUniqueName);
			Thread.sleep(5000);			
			//WebElement saveandrun = driver.findElement(By.xpath("//*[@id='ext-gen297']"));
		//WebElement saveandrun= driver.findElement(By.id("ext-gen297"));
		//	wait.until(ExpectedConditions.elementToBeClickable(saveandrun));
		//	click(saveandrun);
			//if(saveandrun.isEnabled())
			//	System.out.println("saggfgtytygyt");
			//action.moveToElement(saveandrun).build().perform();
		//	click(saveandrun);
		//	saveandrun.submit();
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("document.getElementById('ext-gen297' ).click();");
			
	}
}
