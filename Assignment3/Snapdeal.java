package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws IOException {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("pushDenied")).click();

		// click mens fashion
		driver.findElement(By.xpath("//span[contains(text(),'Men')]")).click();

		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

		// get total shoe items
		WebElement shoeCount = driver
				.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following::span"));
		System.out.println("Number of Shoes is " + shoeCount.getText());

		// click training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// select sort by low to high
		driver.findElement(By.className("sort-label")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]"));

		// get price of each product
		List<WebElement> productList = driver.findElements(By.className("product-title"));
		List<String> productPriceList = new ArrayList<String>();

		for (WebElement price : productList) {

			// WebElement price = driver.findElement(By.tagName("span"));
			productPriceList.add(
					price.findElement(By.xpath("(//p[@class='product-title']/following::div//span)[2]")).getText());
		}

		System.out.println(productPriceList);

		// enter price range to filter
		driver.findElement(By.xpath("//input[@class='input-filter']")).clear();
		driver.findElement(By.xpath("//input[@class='input-filter']")).sendKeys("900");

		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200");

		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();

		// filter by navy color
		driver.findElement(By.xpath("//span[@class='filter-color-tile Black ']")).click();

		// mouse over and click 1st resulting shoe
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.className("picture-elem"))).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		// get price and discount of product
		WebElement priceOfShoe = driver.findElement(By.className("payBlkBig"));
		WebElement percentDiscount = driver.findElement(By.xpath("(//span[@class='payBlkBig']/following::span)[1]"));

		System.out.println("Price is Rs" + priceOfShoe.getText());
		System.out.println("Discount is " + percentDiscount.getText());

		// take snapshot
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File img = new File("./Screenshot/Snapdeal.jpg");
		FileUtils.copyFile(screenshot, img);

		// close current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i")).click();

		// close main window
		driver.close();

	}

}
