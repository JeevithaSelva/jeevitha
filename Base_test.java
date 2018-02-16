package test_cases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base_test {
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void set_up() {
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Reports/MyOwnReport.html", true);
		System.setProperty("webdriver.chrome.driver",
				"D:\\NGQ_Oxygen_SeleniumAutomation\\Google_automation\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		//logger.log(LogStatus.PASS, "Navigating to the url");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case passed is "+result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE){
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case is Failed because of: "+result.getThrowable());
				try 
				{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/test-output/"+"/screen_shots/"+result.getName()+".png"));
				System.out.println("Screenshot taken");
				} 
				catch (Exception e)
				{
 				System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
				 String screenShotPath= (System.getProperty("user.dir")+"/test-output/"+"/screen_shots/"+result.getName()+".png");
				logger.log(LogStatus.FAIL, "Please find the below snapshot: " + logger.addScreenCapture(screenShotPath));
		
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getThrowable());
		}
		
		extent.endTest(logger);
	}
	
	@AfterSuite
	public void tear_down() {
		driver.close();
		extent.flush();
		extent.close();
	}
}
