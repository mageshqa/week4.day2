package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableWebTable {

	public static void main(String[] args) {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// get names from web table
		WebElement entireTable = driver.findElement(By.tagName("table"));
		List<WebElement> allRows = entireTable.findElements(By.tagName("tr"));

		List<String> namesBeforeSort = new ArrayList<String>();

		for (int i = 0; i < allRows.size(); i++) {
			WebElement eachRow = allRows.get(i);

			List<WebElement> allCols = eachRow.findElements(By.tagName("td"));

			for (int j = 0; j < allCols.size(); j++) {
				if (j == 1) {
					namesBeforeSort.add(allCols.get(j).getText());
				}

			}

		}

		System.out.println("Names before sorting are " + namesBeforeSort);
		Collections.sort(namesBeforeSort);
		System.out.println("Names after sorting through codes " + namesBeforeSort);

		// sort table by names
		driver.findElement(By.xpath("//th[text()='Name']")).click();

		// get names from web table after sorting
		WebElement tableSorted = driver.findElement(By.tagName("table"));
		List<WebElement> rowsSorted = tableSorted.findElements(By.tagName("tr"));

		List<String> namesAfterSort = new ArrayList<String>();

		for (int k = 0; k < rowsSorted.size(); k++) {

			WebElement eachRowsSorted = rowsSorted.get(k);
			List<WebElement> colsSorted = eachRowsSorted.findElements(By.tagName("td"));

			for (int l = 0; l < colsSorted.size(); l++) {
				if (l == 1) {
					namesAfterSort.add(colsSorted.get(l).getText());
				}
			}

		}

		System.out.println("Names after sorting are " + namesAfterSort);

		// compare before and after sort

		if (namesBeforeSort.equals(namesAfterSort)) {
			System.out.println("Congrats! Sorting functionality in page works!!");
		}

		// close driver
		driver.quit();
	}

}
