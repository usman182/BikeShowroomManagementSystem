package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin 
{
	private String AdminName;
	private String AdminID;
	
 	
	
	public String getAdminName() 
	{
		return AdminName;
	}

	public void setAdminName(String adminName) 
	{
		AdminName = adminName;
	}

	public String getAdminID()
	{
		return AdminID;
	}

	public void setAdminID(String adminID)
	{
		AdminID = adminID;
	}

	public boolean Add_Bike(int engine_number, String model, String name, String color) throws ClassNotFoundException 
	{   
		//String BikeName=bikeName;
		boolean Inventoryflag=false;
		int Engine_Number = engine_number;
		String Model = model;
		String Name = name;
		String Color = color;
		Inventory objAddBike=new Inventory();
		Inventoryflag= objAddBike.Add_Bike(engine_number,model,name,color);
		
		return Inventoryflag;
		//Admin db =Admin.getInstance();  Add_Bike(bikemodel,Engine_ID,bike_Model,BikePrice);
       // db.add_bike(bike_name.getText(), bike_Id.getText(), BikePrice.getText());
    }
	
	/*
	 
	 public void nominee_details_handler(ActionEvent e) throws SQLException, ClassNotFoundException {
        Administrator db =Administrator.getInstance();
        db.add_nominee(nominee_name.getText(), nominee_username.getText(), nominee_age.getText(), nominee_password.getText(),nominee_party.getText(),nominee_username,nominee_invalid_details,nominee_submit_details);
    }
	 
	 */
	
	synchronized public String[] ChangeDetails(int ID) throws ClassNotFoundException, SQLException 
	{
		String[] rs = null;
		
		
		DB_Handler obj = new DB_Handler();
		rs=obj.getEmp(ID);
		
		boolean successfull = true;
		
		successfull=obj.ChangeDetails(rs);
	
		/*try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery("select * from employee");
		
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		//rs=obj.ChangeDetails(ID);
		
		//ResultSet sucessfull = null; 
		//sucessfull = obj.ChangeDetail(ID, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		return rs;
		
		//obj.SaveEmp(ID, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		
		//return true;
	}
	
	synchronized public boolean DeleteDetails(int Employee_Id) throws ClassNotFoundException, SQLException {
		
		ResultSet rs = null;
		
		
		DB_Handler obj = new DB_Handler();
		//rs=obj.getEmp(Employee_Id);
		
	
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery("select * from employee");
		
		/*while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
		}*/
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean sucessfull = true; 
		sucessfull = obj.removeEmp(Employee_Id);
		
		return sucessfull;
	}
	
	public boolean removeEmp(int Id) 
	{
		
		boolean chngeFlag=false;
		int get_id;
		DB_Handler DBobj=new DB_Handler();
		/*get_id=DBobj.getEmp(Id);
		if(get_id!=0)
		{
		 DB_Handler NewObj=new DB_Handler();	
		 chngeFlag= NewObj.ChangeDetail(get_id);
	     
		}*/
		
		if(chngeFlag==true)
		{
			return chngeFlag;
		}
		
		return chngeFlag;
		
		//Admin db =Admin.getInstance();
        //db.ChangeDetails(bike_nambike_Id.getText());
		
	}
	
	public boolean AddEmployee(int employee_id, String employee_name, String employee_address, String employee_phoneNumber, String employee_cnic) throws ClassNotFoundException 
	{
		boolean chngeFlag=false;
		int get_id;
		DB_Handler DBobj=new DB_Handler();
		chngeFlag=DBobj.EnterEmp(employee_id, employee_name,employee_address, employee_phoneNumber, employee_cnic);
		
		
		if(chngeFlag==true)
		{
			return chngeFlag;
		}
		
		return chngeFlag;
	  	
	}

}
