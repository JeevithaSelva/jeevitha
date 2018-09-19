package grid;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test_cases.Indirect_Scenarios.TC13_Distributor_low_touch_quote_creation;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.MalformedURLException;

public class Node {
   public WebDriver driver;
   public String URL, Node;
   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
   
   //@Parameters("browser")
   @BeforeTest
   public void launchapp() throws MalformedURLException {
      //String URL = "https://partner-itg.itcs.hpe.com/";
      System.out.println(" Executing on CHROME");
      DesiredCapabilities cap = DesiredCapabilities.chrome();
      cap.setBrowserName("chrome");
      String Node = "http://16.166.226.190:5555//wd/hub";
      driver = new RemoteWebDriver(new URL(Node), cap);
      System.out.println("client machine is working");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //driver.get(URL);

   }
   
   @Test
   public void calculatepercent() throws Exception {
//	   driver.findElement(By.id("USER")).sendKeys("VALIDATION_HPE_US_DIS_X_07@YOPMAIL.COM");
//		driver.findElement(By.id("PASSWORD")).sendKeys("Passport_1!");
//		driver.findElement(By.id("sign-in-btn")).click();
	   TC13_Distributor_low_touch_quote_creation qc = new TC13_Distributor_low_touch_quote_creation();
	   qc.PPR_quote_creation();
   }
   
//   @AfterTest
//   public void closeBrowser() {
//      driver.quit();
//   }
}