package com.tekarch.SalesForce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;

import com.tekarch.utilityforsaleforce.PropertiesUtility;

public class TC06 extends BaseClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		myProfileOptions();
	}

	public static void myProfileOptions() throws InterruptedException, AWTException {
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

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userMenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(userMenu));
		action.moveToElement(userMenu).build().perform();
		click(userMenu);

		WebElement myProfile = driver.findElement(By.xpath("//a[text()='My Profile']"));
		click(myProfile);
		Thread.sleep(2000);

	 WebElement editProfile =driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		//WebElement editProfile = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		wait.until(ExpectedConditions.visibilityOf(editProfile));
		click(editProfile);
		Thread.sleep(6000);
		driver.switchTo().frame("contactInfoContentId");
		Thread.sleep(3000);

		WebElement about = driver.findElement(By.partialLinkText("About"));
		click(about);


		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.clear();
		sendText(lastName, "Huragi", "LastNAme");

		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
		click(save);

		Thread.sleep(2000);

		WebElement post = driver.findElement(By.id("publisherAttachTextPost"));
		click(post);

		WebElement share = driver.findElement(By.id("publishersharebutton"));
		WebElement file = driver.findElement(By.xpath("//span[text() = 'File']"));
		click(file);
		WebElement upload = driver.findElement(By.id("chatterUploadFileAction"));
		click(upload);
		Thread.sleep(2000);

		// WebElement chooseFile = driver.findElement(By.id("chatterFile"));
		// click(chooseFile); //
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('chatterFile' ).click();");

		Robot rb = new Robot();

		StringSelection str = new StringSelection("F:\\Chaithra\\workspace\\SeleniumWithMaven\\src\\test\\resources\\version1.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		WebElement shareFile = driver.findElement(By.id("publishersharebutton"));
		click(shareFile);

		
	//	JavascriptExecutor executor = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		executor.executeScript("document.getElementById('uploadLink' ).click();");

		driver.switchTo().frame("uploadPhotoContentId");

		Thread.sleep(3000);
		WebElement choosePhoto = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));

		choosePhoto.sendKeys("F:\\Chaithra\\workspace\\SeleniumWithMaven\\src\\test\\resources\\IMG_5053.jpg");
		
		WebElement savePhoto = driver.findElement(By.xpath("//input[@value='Save'][1]"));
		Thread.sleep(3000);
		
		JavascriptExecutor executor1=(JavascriptExecutor) driver;
		executor1.executeScript("document.getElementById('j_id0:uploadFileForm:uploadBtn' ).click();");
		Thread.sleep(4000);	
		//*[@id="j_id0:outer"]/div[1]/div/div/div/div[5]/div[9]
		WebElement size = driver.findElement(By.xpath("//*[@id=\"j_id0:outer\"]/div[1]/div/div/div/div[5]/div[9]"));
		size.getRect();
		
	
		executor1.executeScript("document.getElementById('j_id0:j_id7:save' ).click();");
		Thread.sleep(3000);
		WebElement profileupdate = driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']"));
		if(profileupdate.isEnabled()) {
			System.out.println("Test case pass");
		}else {
			System.out.println("Test case fail");
		}
		
		driver.close();
		
		
		
		
		
		
	}

}
