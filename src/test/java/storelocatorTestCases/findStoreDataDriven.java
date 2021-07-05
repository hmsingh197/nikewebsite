package storelocatorTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.commonPageCode;
import common.myTestData;
import pages.HomePage;
import pages.StoreLocatorPage;

public class findStoreDataDriven extends myTestData {

	WebDriver driver = null;
	


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/BrowserDriver/chromedriver");
		driver = new ChromeDriver();

		driver.get(commonPageCode.getProperty("URL"));
		Reporter.log("Launching Browser with URL " + commonPageCode.getProperty("URL"));

	}

	

	@Test(dataProvider = "myData")
	public void findStoreByZipCode(String zip, String city) throws InterruptedException {
		// Actions
		HomePage.goToStoreLocator(driver);
		StoreLocatorPage.findStoreByZipCityAddress(zip, driver);
		Thread.sleep(5000);
		StoreLocatorPage.validateFirstStoreCity(city, driver);
		// (//div[@class='bw__StoreLocation__cityState']/span[1])[1]

	}

}
