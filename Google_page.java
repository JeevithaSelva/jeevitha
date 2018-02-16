package test_cases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Google_page extends Base_test{

	@Test
	public void verify_the_title() {
		logger = extent.startTest("Verify title in the application");
		logger.log(LogStatus.PASS, "Verify the title of the application");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Gogle");
	}
	
	@Test
	public void verify_text() {
		logger = extent.startTest("Verify text in the application");
		logger.log(LogStatus.PASS, "verifying the expected text in the application");
		System.out.println("search test case is calling");
		if (driver.getPageSource().contains("I'm Feeling Lucky")){
			logger.log(LogStatus.PASS, "Expected text is displaying");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Expected text is not displaying");
		}
	}
}
