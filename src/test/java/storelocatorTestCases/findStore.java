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
import org.testng.annotations.Test;

import common.commonPageCode;
import pages.HomePage;
import pages.StoreLocatorPage;


public class findStore {
	
	WebDriver driver = null;
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(commonPageCode.getProperty("URL"));
		Reporter.log("Launching Browser with URL " + commonPageCode.getProperty("URL"));
		
	}
	
	
	
	@Test
	public void findStoreByZipCode() throws InterruptedException{
		//Actions
		HomePage.goToStoreLocator(driver);
		StoreLocatorPage.findStoreByZipCityAddress("63017",driver);
		Thread.sleep(5000);
		StoreLocatorPage.validateFirstStoreCity("Chesterfield",driver);
		//(//div[@class='bw__StoreLocation__cityState']/span[1])[1]
	
	}
	
	
	
	@Test(enabled=false)
	public void findStoreCity() throws InterruptedException{
		
		HomePage.goToStoreLocator(driver);
		StoreLocatorPage.findStoreByZipCityAddress("London",driver);
		
	//	driver.quit();
	//	driver.findElement(By.xpath("//button[@id='mapsearchbtn']")).click();
		
	}
	
	

}
