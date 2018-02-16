package test_cases;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Google_search extends Base_test{
	
	@Test
	public void search_text() {
		logger = extent.startTest("Searching the text in search field");
		logger.log(LogStatus.PASS, "search the keyword in google search");
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		logger.log(LogStatus.PASS, "searched keyword is displaying");
	}

	@Test
	public void print_the_text() {
		logger = extent.startTest("Printing the languages");
		List<WebElement> e = driver.findElements(By.xpath(".//*[@id='_eEe']"));
		Collections.reverse(e);
		for (WebElement element : e) {
		    String link = element.getAttribute("href");
		    System.out.println("Link: " + link + ", Title: " + element.getText());
		}
	}
	
}
