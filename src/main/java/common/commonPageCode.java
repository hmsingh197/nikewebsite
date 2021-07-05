package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.StoreLocatorPage;

public class commonPageCode {

	//commonPageCode.specialSendKeys(StoreLocatorPage.findStoreTxtField,"63017",driver);
	
	
	public static void specialSendKeys(String xpath,String textToEnter,WebDriver driver){
		
		for(int i=0; i<=2;i++){
			  try{
			     driver.findElement(By.xpath(xpath)).sendKeys(textToEnter);
			     break;
			  }
			  catch(Exception e){
			     System.out.println(e.getMessage());
			  }
			}
		
		
	}
	
	public static void specialClick(String xpath,WebDriver driver){
		
		
		for(int i=0; i<=2;i++){
			  try{
			     driver.findElement(By.xpath(xpath)).click();
			     break;
			  }
			  catch(Exception e){
			     
			  }
			}
	}
	
	
	public static String getProperty(String propertyName){
		
		
		
		  String propertyValue="";
			
		   try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties")) {

	            Properties prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            propertyValue=prop.getProperty(propertyName);
	  
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
		
		return propertyValue;
		
		
		
	}
	
	
	public static Object[][] getDatabaseData() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		//return new Object[][] { { "63017", "Chesterfield" }, { "84095", "West Jordan" }, { "84002", "Athens" } };
		
		
		// 63017  Chestefield
		// 84095   West Jordan
		
		
		
		
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/training?serverTimezone=UTC", "root", "password");
		   
		Statement st = con.createStatement();
		String sql = ("SELECT * FROM cityzip;");
		ResultSet rs = st.executeQuery(sql);
        int numberOfRows=0;		
		while(rs.next()) { 
			 //row++;
			
			numberOfRows++;
			
			}
		
		System.out.println(numberOfRows);
		rs.beforeFirst();
		
		
	//	System.out.println(numberOfRows);
		String[][]  mydata = new String[numberOfRows][2];
		int row=0;
	//	int col=0;
		
		while(rs.next()) { 
		 String zipcode = rs.getString("zipcode"); 
		 String city = rs.getString("city");
		 mydata[row][0]=zipcode;      
		 mydata[row][1] = city;		 
		 row=row+1;
		 //row++;
		
		 System.out.println(zipcode  +   "---"   +  city);
		
		
		
		}

		con.close();
		return mydata;
		
		
	}

	public static Object[][] getCSVData() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		String[][]  mydata = new String[3][2];
		
		//Read data from csv
		
		
		
		
		return mydata;

	
	
	}
	
   public static Object[][] getJSONData() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		String[][]  mydata = new String[3][2];
		
		//Read data from csv
		
		
		
		
		return mydata;

	
	
	}
	
}
