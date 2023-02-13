import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TekArchApp {

	public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();

	WebDriver driver = new ChromeDriver();
	driver.get("https://qa-tekarch.firebaseapp.com/");
	Thread.sleep(2000);
	
	By ob1 = By.id("email_field");
	WebElement emailBox = driver.findElement(ob1);
	emailBox.sendKeys("admin123@gmail.com");
	Thread.sleep(2000);
	
	By ob2 = By.id("password_field");
	WebElement passwordBox = driver.findElement(ob2);
	
	if(passwordBox.isDisplayed()) {
		passwordBox.sendKeys("admin123");
	}else
	{
		System.out.println("Webelement not found");
	}
	Thread.sleep(2000);
	
	By ob3 = By.xpath("/html/body/div[1]/button");
	WebElement loginButton = driver.findElement(ob3);
	loginButton.click();
	Thread.sleep(2000);

	By ob4=By.id("name");
	WebElement name = driver.findElement(ob4);
	name.sendKeys("Chaithra");
	Thread.sleep(2000);
	
	By ob5=By.id("lname");
	WebElement fatName = driver.findElement(ob5);
	fatName.sendKeys("Huragi");
	Thread.sleep(2000);
	
	By ob6=By.id("postaladdress");
	WebElement postal = driver.findElement(ob6);
	postal.sendKeys("Ranebennur");
	Thread.sleep(2000);
	
	By ob7=By.className("bootbutton");
	WebElement submitEle= driver.findElement(ob7);
	submitEle.click();
//	Thread.sleep(2000);
	}

}
