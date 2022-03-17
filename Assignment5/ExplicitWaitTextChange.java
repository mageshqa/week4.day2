package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTextChange {

	public static void main(String[] args) {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement appearText = driver.findElement(By.id("btn"));

		System.out.println(appearText.getText());
		appearText.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("1st Alert - " + alert.getText());
		alert.accept();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));

		System.out.println(appearText.getText());

		appearText.click();
		driver.switchTo().alert();
		System.out.println("2nd Alert - " + alert.getText());
		alert.accept();

		// close browser
		driver.quit();

	}

}
