package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Bike 
{
	
	private int BikeId;
	private int BikeEngine;
	private String BikeModel;
	private String BikeName;
	private String BikeColor;
	
	
	
	
	public int getBikeId()
	{
		return BikeId;
	}

	public void setBikeId(int bikeId) 
	{
		BikeId = bikeId;
	}

	public int getBikeEngine()
	{
		return BikeEngine;
	}

	public void setBikeEngine(int bikeEngine)
	{
		BikeEngine = bikeEngine;
	}

	public String getBikeModel() 
	{
		return BikeModel;
	}

	public void setBikeModel(String bikeModel) 
	{
		BikeModel = bikeModel;
	}

	public String getBikeName() 
	{
		return BikeName;
	}

	public void setBikeCompanyName(String bikeName) 
	{
		BikeName = bikeName;
	}

	public String getBikeColor() 
	{
		return BikeColor;
	}

	public void setBikeColor(String bikeColor) 
	{
		BikeColor = bikeColor;
	}

	public void Create_Bike(String BikeName, int BikeId, String Quantity, String price) 
	{
		
	}
	
	public boolean Enter_Bike(int engine_number, String model, String name, String color) throws ClassNotFoundException
	{
		boolean AddBikeFlag=false;
		int Engine_Number = engine_number;
		String Model = model;
		String Name = name;
		String Color = color;
		DB_Handler objAddBike=new DB_Handler();
		AddBikeFlag= objAddBike.create_Bike(engine_number,model,name,color);
		
		return AddBikeFlag;
	}
	
	
	
	public String[] Find_Bike(int engine_Number,String bike_name) throws ClassNotFoundException, SQLException 
	{
	 
		String[] rs;
		int Engine_Number=engine_Number;
		boolean flag=false;
		String Name=bike_name;
		
		boolean SearchFlag=false;
		Bike_Catalog bike_obj=new Bike_Catalog();
		rs= bike_obj.Find_Bike(engine_Number,bike_name);
		
		
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
	
		
		return rs;
		
	}

	public void ShowBikes() throws ClassNotFoundException {
		Bike_Catalog bikecatalog = new Bike_Catalog();
		bikecatalog.ShowBikes();
		
	}

	public String[] EnterItem(int bikeengine_number) throws ClassNotFoundException {
		String[] flag = null;
		Inventory inventory = new Inventory();
		return flag=inventory.getBike_Details(bikeengine_number);
	}
	
	
	public String[] bookBike(String bike_name) throws ClassNotFoundException, SQLException 
	{
		String[] rs = null;
		//int Engine_Number=engine_Number;
		boolean flag=false;
		String Name=bike_name;
		DB_Handler obj=new DB_Handler();
		rs= obj.bookBike(bike_name);
		
	
		
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
		
		
		return rs;
                
	}
	
	public String[] manageInventory(int engine_Number) throws ClassNotFoundException, SQLException 
	{
		String[] rs = null;
		//int Engine_Number=engine_Number;
		boolean flag=false;
		int Name=engine_Number;
		DB_Handler obj=new DB_Handler();
		rs= obj.manageInventory(engine_Number);
		
	
		System.out.println("Showroom");
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
		
		
		return rs;
                
	}
	
	public String[] purchaseBookBike(String bike_Name) throws ClassNotFoundException, SQLException 
	{
		String[] rs = null;
		//int Engine_Number=engine_Number;
		boolean flag=false;
		String Name=bike_Name;
		DB_Handler obj=new DB_Handler();
		rs= obj.purchaseBookBike(bike_Name);
		
	
		System.out.println("Showroom");
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
		
		
		return rs;
                
	}
	
}
