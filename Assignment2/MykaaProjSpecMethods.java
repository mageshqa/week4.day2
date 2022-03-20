package week4.day2;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MykaaProjSpecMethods {
	public RemoteWebDriver driver;

	@Parameters({"URL","BROWSER"})
	@BeforeMethod
	public void beforeMethod(String url, String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
