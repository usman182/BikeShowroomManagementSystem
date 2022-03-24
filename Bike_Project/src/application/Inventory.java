package application;

import java.sql.ResultSet;

public class Inventory 
{
	
	public void EnterBike(String bikeName, int BikeId, int Quantity, String price) 
	{
		
	}
	
	public boolean Bike_Remove(String model,int Engine_ID) 
	{
        boolean DBFlag=false;
		String bike_model=model;
		int Bike_EngineID=Engine_ID;
		DB_Handler bike_remove_obj=new DB_Handler();
		DBFlag= bike_remove_obj.remove_Bike(bike_model,Bike_EngineID);
		
		return DBFlag;
		
	}
	
	//Add_Bike(BikeName,Engine_ID,bike_Model,BikePrice);
	
	public boolean Add_Bike(int engine_number, String model, String name, String color) throws ClassNotFoundException
	{
		//String Bike_Name=BikeName;
		boolean BikeFlag=false;
		int Engine_Number = engine_number;
		String Model = model;
		String Name = name;
		String Color = color;
		Bike objAddBike=new Bike();
		BikeFlag= objAddBike.Enter_Bike(engine_number,model,name,color);
		
		return BikeFlag;

		
	}

	public String[] getBike_Details(int bikeengine_number) throws ClassNotFoundException {
		String[] flag = null;
		DB_Handler dbhandler = new DB_Handler();
		return flag=dbhandler.restock_Bike(bikeengine_number);
	}
	

}
