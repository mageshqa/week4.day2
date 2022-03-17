package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// drag drop element
		driver.switchTo().frame(0);

		WebElement sourceElement = driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		Point location = sourceElement.getLocation();
		int x = location.getX();
		int y = location.getY();

		Actions action = new Actions(driver);

		action.dragAndDropBy(sourceElement, x + 40, y + 40).perform();

		// close browser
		driver.quit();
	}

}
