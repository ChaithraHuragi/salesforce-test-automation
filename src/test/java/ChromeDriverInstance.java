import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverInstance {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	
		By ob1 = By.className("gLFyf");
		WebElement  googleSearch = driver.findElement(ob1);
		googleSearch.sendKeys("Selenium");
		Thread.sleep(2000);
	//	googleSearch.click();
		
		By ob2 = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]");
		WebElement searchButton = driver.findElement(ob2);
		searchButton.click();	
		
	//	driver.close();
	}

}
