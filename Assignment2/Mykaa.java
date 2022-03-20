package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Mykaa extends MykaaProjSpecMethods {

	@Test
	public void mykaaTest() throws IOException {
		// mouse over brands
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();

		// brand search box
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");

		// select L'Oreal Paris
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();

		// get page title
		System.out.println("Page Title is " + driver.getTitle());

		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("Page Title Contains the text L'Oreal Paris");
		}

		// sort by
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("(//span[text()='customer top rated']/following::div)[1]")).click();

		// category
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div")).click();

		String shampoo = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();

		if (shampoo.equalsIgnoreCase("shampoo")) {
			System.out.println("Filter for Shampoo is applied.");
		}

		// select shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();

		// move to 2nd window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		windowList.get(1);

		System.out.println("Page Title of 2nd page is " + driver.getTitle());

		// select 360ml
		/*
		 * WebElement selectList = driver.findElement(By.tagName("select")); Select
		 * select = new Select(selectList); select.selectByVisibleText("360ml");
		 */

		System.out.println("MRP of Product is " + driver.findElement(By.xpath("//span[text()='MRP:']/span")).getText());

		driver.findElement(By.xpath("(//div[@class='showBottomAction show']//button)[2]")).click();

		// go to cart bag
		driver.findElement(By.xpath("//span[text()='1']/..")).click();

		// grand total
		String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/following::div")).getText();
		System.out.println("Grand Total is " + grandTotal);

		driver.findElement(By.xpath("//span[text()='PROCEED']/ancestor::button")).click();

		// continue as guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		String grandTotalFinal = driver.findElement(By.xpath("//div[text()='Grand Total']/following::div")).getText();

		if (grandTotal.equals(grandTotalFinal)) {
			System.out.println("Grand Total matches!");
		}

		else {
			System.out.println("Grand Total does not match!");
		}

		// screenshot
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File img = new File("./Screenshot/Nyka.jpg");
		FileUtils.copyFile(screenshot, img);

	}

}
