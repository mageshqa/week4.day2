package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailClassExercise {

	public static void main(String[] args) {

		// setup driver and prepare browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enter from station
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("TPJ" + Keys.ENTER);

		// enter to station
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MS" + Keys.ENTER);

		// uncheck sort by date
		WebElement sortDateBox = driver.findElement(By.id("chkSelectDateOnly"));

		// search trains
		driver.findElement(By.id("buttonFromTo")).click();

		if (sortDateBox.isSelected()) {
			sortDateBox.click();
		}

		// get train names from table

		WebElement trainTable = driver.findElement(By.xpath("(//table[contains(@class,'TrainList ')])[2]"));
		List<WebElement> rowsTrain = trainTable.findElements(By.tagName("tr"));

		for (int i = 0; i < rowsTrain.size(); i++) {
			WebElement colsTrain = rowsTrain.get(i);
			List<WebElement> eachTrainName = colsTrain.findElements(By.tagName("td"));

			// System.out.println("Train names are " + eachTrain.get(1).getText());

			if (eachTrainName.get(1).getText().contains("CHENNAI")) {
				System.out.println(eachTrainName.get(1).getText());
			}

		}

		// close browser
		driver.quit();

	}

}
