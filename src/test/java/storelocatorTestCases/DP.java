package storelocatorTestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP
{
	@DataProvider(name = "myData")
	public Object[][] dpMethod() {
		return new Object[][] { { "63017","Chesterfield" }, { "84095","abc" }, { "6000","xyz" }};
	}
 
    @Test (dataProvider = "myData")
    public void myTest (String zip,String city) {
        System.out.println("Zip code passed is  : " + zip);
        System.out.println("City passed is  : " + city);
    }
}
