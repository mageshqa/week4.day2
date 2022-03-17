package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggableClassWork {

	public static void main(String[] args) {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// drag drop element
		driver.switchTo().frame(0);

		WebElement sourceElement = driver.findElement(By.id("draggable"));

		Point location = sourceElement.getLocation();
		System.out.println(location);
		int x = location.getX();
		int y = location.getY();
		
		System.out.println(sourceElement.getText());

		Actions action = new Actions(driver);

		action.dragAndDropBy(sourceElement, x+50, y+40);

		System.out.println(sourceElement.getText());

		// close browser
		//driver.quit();

	}

}
