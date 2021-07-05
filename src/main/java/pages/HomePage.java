package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HomePage {

	//WebElements present on page
	//Function on page
	
	
	public static String findAStoreLink ="//a[text()='FIND A STORE']";
	
	
	public static void goToStoreLocator(WebDriver driver) {
		
		
		Reporter.log("Clicking Find a Store Link");
		driver.findElement(By.xpath(findAStoreLink)).click();
		
		
		
	}
	
	
}
