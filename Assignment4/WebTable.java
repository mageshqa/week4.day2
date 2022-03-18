package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/table.html ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// get table
		WebElement mainTable = driver.findElement(By.tagName("table"));
		List<WebElement> tableRows = mainTable.findElements(By.tagName("tr"));
		System.out.println("Total Rows Count is " + tableRows.size());
		String progressValue = "";
		int colCount = 0;
		Set<String> progressCount = new TreeSet<String>();

		for (int i = 0; i < tableRows.size(); i++) {
			WebElement tableCols = tableRows.get(i);
			List<WebElement> eachDataField = tableCols.findElements(By.tagName("td"));
			colCount = eachDataField.size();

			for (int j = 0; j < eachDataField.size(); j++) {

				// System.out.println(eachDataField.get(j).getText());

				if (eachDataField.get(j).getText().equalsIgnoreCase("Learn to interact with Elements")) {

					progressValue = eachDataField.get(j + 1).getText();

				}

				if (j == 1) {
					progressCount.add(eachDataField.get(j).getText());

					if (progressCount.size() == 2) {
						driver.findElement(By.xpath("//td[text()='30%']//following::input")).click();

					}
				}

			}

		}

		System.out.println("Total Columns Count is " + colCount);

		System.out.println("Progress Value for Learn to interact with Elements is " + progressValue);

		System.out.println(progressCount);

		String leastProgress = Collections.min(progressCount);

		// driver.quit();

	}

}
