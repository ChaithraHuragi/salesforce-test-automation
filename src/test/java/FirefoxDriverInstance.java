import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverInstance {

		public static void main(String[] args) throws Exception {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.navigate().to("https://www.facebook.com/");
			driver.navigate().back();
			driver.close();
		}
}
