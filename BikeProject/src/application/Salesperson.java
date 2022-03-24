package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Salesperson 
{
	private String receiptDetails;
	private int SalespersonId;
	private String SalespersonsName;
	
	public String getReceiptDetails() 
	{
		return receiptDetails;
	}

	public void setReceiptDetails(String receiptDetails) 
	{
		this.receiptDetails = receiptDetails;
	}

	public int getSalespersonId() 
	{
		return SalespersonId;
	}

	public void setSalespersonId(int salespersonId)
	{
		SalespersonId = salespersonId;
	}

	public String getSalespersonsName() 
	{
		return SalespersonsName;
	}

	public void setSalespersonsName(String salespersonsName) 
	{
		SalespersonsName = salespersonsName;
	}

	
	public boolean remove_Bike(String bikemodel,int Engine_ID)
	{
		int engine_id=Engine_ID;
		String bike_Model=bikemodel;
		boolean removeFlag=false;
		Bike bike_obj=new Bike();
		removeFlag= bike_obj.Remove_Bike(bike_Model,engine_id);
		
		return removeFlag;
		
	}
	
	public void Find_Bike(String bikeName) 
	{
		Bike bike = new Bike();
		int engineNumber = bike.getBikeEngine();
		String model = bike.getBikeModel();
		String name = bike.getBikeName();
		String color = bike.getBikeColor();
	}

	public boolean CustomerDetails(String customer_Detail,String customer_CNIC,String customer_name) 
	{
		return true; 
	}
	
	public String[] Search_Bike(int engine_Number,String bike_name) throws ClassNotFoundException, SQLException
	{
		String[] rs;
		int Engine_Number=engine_Number;

		String Name=bike_name;
		
	
		Bike bike_obj=new Bike();
		rs= bike_obj.Find_Bike(engine_Number,bike_name);
		
		System.out.println("Salesperson");
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
	
		
		return rs;
	}

	public void ShowBikes() throws ClassNotFoundException {
		Customer customer = new Customer();
		customer.ShowBikes();
		
	}

	public void makeNewSale() {
		Customer customer = new Customer();
		customer.makeNewSale();
		
	}

	public ResultSet verifyCustomer(String customer_cnic) throws ClassNotFoundException {
		ResultSet flag = null;
		Customer customer = new Customer();
		return flag=customer.verifyCustomer(customer_cnic);
	}

	public String[] EnterItem(int bikeengine_number) throws ClassNotFoundException {
		String[] flag = null;
		Bike bike = new Bike();
		return flag=bike.EnterItem(bikeengine_number);
	}
	
	
}
