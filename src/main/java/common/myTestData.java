package common;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;

public class myTestData {

	
	@DataProvider(name = "myData")
	public Object[][] dpMethod() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//return new Object[][] { { "63017", "Chesterfield" }, { "84095", "West Jordan" }, { "84002", "Athens" } };
		
		
		
		return commonPageCode.getDatabaseData();
		//int[][] myArray = {{10,20},{30,40}};
	}
	
	
	}
