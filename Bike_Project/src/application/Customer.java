package application;

import java.sql.ResultSet;

public class Customer {
	
	private String id;
	private String name;
	private String address;
	private String phone_number;
	public void ShowBikes() throws ClassNotFoundException {
		Sale sale = new Sale();
		sale.ShowBikes();
		
	}
	public void makeNewSale() {
		Sale sale = new Sale();
		sale.createSale();
		
	}
	public ResultSet verifyCustomer(String customer_cnic) throws ClassNotFoundException {
		ResultSet rs = null;
		DB_Handler dbhandler = new DB_Handler();
		return rs=dbhandler.GetCustomer(customer_cnic);
	}
	
}
