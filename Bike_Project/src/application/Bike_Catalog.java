package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bike_Catalog 
{

	private String BikeDescription;
	
	
	public String getBikeDescription() 
	{
		return BikeDescription;
	}


	public void setBikeDescription(String bikeDescription) 
	{
		BikeDescription = bikeDescription;
	}


	public String[] Find_Bike(int engine_Number,String bike_name) throws ClassNotFoundException, SQLException 
	{
		
		String[] rs;

		
		DB_Handler bike_DB_obj=new DB_Handler();
		rs= bike_DB_obj.Find_Bike(engine_Number,bike_name);
	
		//System.out.println("hello " + engine_Number);
		/*while (rs.length) {
			System.out.println(rs.getInt(1) + " " + rs.length);
		}*/
		System.out.println("Bike Catalog");
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
		
		return rs;
		
		
	}


	public void ShowBikes() throws ClassNotFoundException {
		
		ResultSet rs = null;
		DB_Handler dbHandler = new DB_Handler();
		rs=dbHandler.getAllBikes();
		
	}
	
}


