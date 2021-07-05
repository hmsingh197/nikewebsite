package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testingfordatabase {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
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
		
		
		
	}

}
