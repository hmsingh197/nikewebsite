package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import common.commonPageCode;

public class StoreLocatorPage {
	
	//WebElement
	//Functions
	
	
	public static String findStoreTxtField ="//input[@placeholder='Enter city, address or postcode']" ;
	public static String findStoreButton ="//div[@class='bw__SearchBarFlagship__submit']" ;
	
	
	
	public static void findStoreByZipCityAddress(String ZipCityAddress, WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Reporter.log("Searching by  " + ZipCityAddress);
		commonPageCode.specialSendKeys(findStoreTxtField,ZipCityAddress,driver);
		Thread.sleep(3000);
		Reporter.log("Clicking Find Button");
		commonPageCode.specialClick(findStoreButton,driver);
		
	}

	
	public static void validateFirstStoreCity(String validationCity,WebDriver driver) throws InterruptedException {
		
		
		Thread.sleep(5000);
		String actualCity = driver.findElement(By.xpath("(//div[@class='bw__StoreLocation__cityState']/span[1])[1]")).getText() ;
		if(!(actualCity.split(",")[0]).equals(validationCity)) {
			
			Assert.fail("Actual City and Validation City did not match. Actual City :"  +  actualCity + " Validation City : " +  validationCity);
			
			
		}else
			
			Reporter.log("Actual City and Validation City match. Actual City :"  +  actualCity + " Validation City : " +  validationCity);
		
		
		
		
		
	}
	
	
	
	
	
}
