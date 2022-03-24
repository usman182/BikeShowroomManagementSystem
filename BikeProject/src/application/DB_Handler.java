package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Handler 
{
	
	public String[] getEmp(int ID) throws ClassNotFoundException 
	{
		
		FileHandling obj=new FileHandling();
	    String fname1="Employee.txt";
	    obj.Create_File(fname1);
		
			ResultSet rs = null;
			String[] arr = new String[5];
			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
			
			String sql = "select employee_id from employee where employee_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, ID);
			statement.execute();
			
			Statement statement3 = con.createStatement();
			ResultSet rs2 = statement3.executeQuery(sql);
			
			String emp_name=rs.getString(1);
			String emp_id=rs.getString(2);
			String emp_address=rs.getString(3);
			String emp_phone_number=rs.getString(4);
			String emp_cnic=rs.getString(5);
			//start of writing
			
				   BufferedWriter bw = null;
	       	       PrintWriter pw = null;
	        	   FileWriter fw = null; 	
	        	   
	        	  synchronized (this) {
	        	   try { 
	         		   
	         		   fw = new FileWriter(fname1, true); 
	         		   bw = new BufferedWriter(fw);
	         		   pw = new PrintWriter(bw); 
	         		   pw.println(emp_name+" "+emp_id+" "+emp_address+" "+emp_phone_number+" "+emp_cnic+" "); 
	         		   
	         		   
	         		   pw.flush(); 
	         		   
	         	   }
	         	   
	         	   catch (IOException io) 
	     		   {
	     			   
	     		   }
	         	   
	         	   finally 
	         	   {
	         		   try 
	         		   {
	         			   bw.close();
	        			   fw.close(); 
	         			   pw.close();
	         			   
	         			   }
	         		   
	         		   catch (IOException io) 
	         		   {
	         			   
	         		   }
	         		   
	         		   
	         	   }
			
	        	  }
			while (rs.next()) {
				for (int i=1; i<5; i++) {
					arr[i] = rs.getString(i);
				}
			}
			
			
			
			
			
			
			
			/*String sql2 = "UPDATE FROM employee WHERE employee_id=?";
			PreparedStatement statement2 = con.prepareStatement(sql2);
			statement2.setInt(1, Id);
			statement2.execute();*/
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
			return arr;
	}
	
	public ResultSet ChangeDetail(int id, String name, String address, String phoneNumber, String cnic) throws ClassNotFoundException    //ChangeDetail(get_id);
	{
		ResultSet rs = null;
		String fname1="Employee.txt";
		
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		String sql2 = "UPDATE FROM employee WHERE employee_id=?";
		PreparedStatement statement2 = con.prepareStatement(sql2);
		statement2.setInt(1, id);
		statement2.setString(1, name);
		statement2.setString(1, address);
		statement2.setString(1, phoneNumber);
		statement2.setString(1, cnic);
		statement2.execute();
		
		Statement statement3 = con.createStatement();
		ResultSet rs2 = statement3.executeQuery(sql2);
		
		String emp_name=rs2.getString(1);
		String emp_id=rs2.getString(2);
		String emp_address=rs2.getString(3);
		String emp_phone_number=rs2.getString(4);
		String emp_cnic=rs2.getString(5); 
		
		BufferedWriter bw = null; 
	    PrintWriter pw = null;
 	    FileWriter fw = null; 	
 	   
 	   synchronized (this) {
 	   try { 
  		   
  		   fw = new FileWriter(fname1, true); 
  		   bw = new BufferedWriter(fw);
  		   pw = new PrintWriter(bw); 
  		   pw.println(emp_name+" "+emp_id+" "+emp_address+" "+emp_phone_number+" "+emp_cnic+" "); 
  		   
  		   
  		   pw.flush(); 
  		   
  	   }
  	   
  	   catch (IOException io) 
		   {
			   
		   }
  	   
  	   finally 
  	   {
  		   try 
  		   {
  			   bw.close();
 			   fw.close(); 
  			   pw.close();
  			   
  			   }
  		   
  		   catch (IOException io) 
  		   {
  			   
  		   }
  		   
  		   
  	   }
		
 	   }
	
	//end of writing
		
		return rs2;
		
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
		return rs;
		
	}
	
	public ResultSet SaveEmp(int id, String name, String address, String phoneNumber, String cnic) throws ClassNotFoundException {
		
		String fname1="Employee.txt";
		ResultSet rs = null;
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		String sql2 = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement2 = con.prepareStatement(sql2);
		statement2.setInt(1, id);
		statement2.setString(1, name);
		statement2.setString(1, address);
		statement2.setString(1, phoneNumber);
		statement2.setString(1, cnic);
		statement2.execute();
		
		Statement statement3 = con.createStatement();
		ResultSet rs2 = statement3.executeQuery(sql2);
		
		String emp_name=rs2.getString(1);
		String emp_id=rs2.getString(2);
		String emp_address=rs2.getString(3);
		String emp_phone_number=rs2.getString(4);
		String emp_cnic=rs2.getString(5);  
		//
		
		BufferedWriter bw = null; 
	    PrintWriter pw = null;
 	    FileWriter fw = null; 	
 	   
 	   synchronized (this) {
 	   try { 
  		   
  		   fw = new FileWriter(fname1, true); 
  		   bw = new BufferedWriter(fw);
  		   pw = new PrintWriter(bw); 
  		   pw.println(emp_name+" "+emp_id+" "+emp_address+" "+emp_phone_number+" "+emp_cnic+" "); 
  		   
  		   
  		   pw.flush(); 
  		   
  	   }
  	   
  	   catch (IOException io) 
		   {
			   
		   }
  	   
  	   finally 
  	   {
  		   try 
  		   {
  			   bw.close();
 			   fw.close(); 
  			   pw.close();
  			   
  			   }
  		   
  		   catch (IOException io) 
  		   {
  			   
  		   }
  		   
  		   
  	   }
		
 	   }
	
	//end of writing
		
		return rs2;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public boolean removeEmp(int Id) throws ClassNotFoundException 
	{
		ResultSet rs = null;
		String fname1="Employee.txt";
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		String sql = "DELETE FROM employee WHERE employee_id=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, Id);
		statement.execute();
		
		//
		String emp_name=rs.getString(1);
		String emp_id=rs.getString(2);
		String emp_address=rs.getString(3);
		String emp_phone_number=rs.getString(4);
		String emp_cnic=rs.getString(5);  
		
		//
		
		BufferedWriter bw = null; 
	    PrintWriter pw = null;
 	    FileWriter fw = null; 	
 	   
 	   synchronized (this) {
 	   try { 
  		   
  		   fw = new FileWriter(fname1, true); 
  		   bw = new BufferedWriter(fw);
  		   pw = new PrintWriter(bw); 
  		   pw.println(emp_name+" "+emp_id+" "+emp_address+" "+emp_phone_number+" "+emp_cnic+" "); 
  		   
  		   
  		   pw.flush(); 
  		   
  	   }
  	   
  	   catch (IOException io) 
		   {
			   
		   }
  	   
  	   finally 
  	   {
  		   try 
  		   {
  			   bw.close();
 			   fw.close(); 
  			   pw.close();
  			   
  			   }
  		   
  		   catch (IOException io) 
  		   {
  			   
  		   }
  		   
  		   
  	   }
		
 	   }
	
	//end of writing
		
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public boolean EnterEmp(int employee_id, String employee_name, String employee_address, String employee_phoneNumber, String employee_cnic) throws ClassNotFoundException 
	{
		
			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
			
			String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, employee_id);
			statement.setString(2, employee_name);
			statement.setString(3, employee_address);
			statement.setString(4, employee_phoneNumber);
			statement.setString(5, employee_cnic);
			statement.execute();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		boolean	flag=true;
		 return flag;
		
	}
	
	public void EnterCustomerDetails(String details) {
		
	}
	
	public String[] Find_Bike(int engine_Number,String bike_name) throws ClassNotFoundException
	{
		ResultSet rs = null;
		String fname1="Bike.txt";
		String[] arr = new String[5];
			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
			String sql = "select * from bike where engine_number=?";
			PreparedStatement stat = con.prepareStatement(sql);
			
			stat.setInt(1, engine_Number);
			//stat.setString(2, "?");
			//stat.setString(2, bike_name);
			rs = stat.executeQuery();
			
			String engine_number=rs.getString(1);
			String bike_name1=rs.getString(2);
			
			BufferedWriter bw = null; 
		    PrintWriter pw = null;
	 	    FileWriter fw = null; 	
	 	   
	 	   synchronized (this) {
	 	   try { 
	  		   
	  		   fw = new FileWriter(fname1, true); 
	  		   bw = new BufferedWriter(fw);
	  		   pw = new PrintWriter(bw); 
	  		   pw.println(engine_number+" "+bike_name1+" "); 
	  		   
	  		   
	  		   pw.flush(); 
	  		   
	  	   }
	  	   
	  	   catch (IOException io) 
			   {
				   
			   }
	  	   
	  	   finally 
	  	   {
	  		   try 
	  		   {
	  			   bw.close();
	 			   fw.close(); 
	  			   pw.close();
	  			   
	  			   }
	  		   
	  		   catch (IOException io) 
	  		   {
	  			   
	  		   }
	  		   
	  		   
	  	   }
			
	 	   }
		
		//end of writing
			
			System.out.println("hello");
			while (rs.next()) {
				for (int i=1; i<=4; i++) {
					arr[i] = rs.getString(i);
					System.out.print(arr[i] + " ");
				}
				//System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			System.out.println();
			
			//arr[i] = rs.getInt(2);
			//System.out.println(arr[i] + " ");
			//System.out.println(rs.getString(2) + " ");
			/*for (int i=2; i<=4; i++) {
				arr[i] = rs.getString(i);
				System.out.println(arr[i] + " ");
			}*/
			
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
			return arr;
		
		
		
	}
	
	public boolean remove_Bike(String bike_model,int Bike_EngineID)
	{
		boolean RemoveFlag=false;
		//queries
		
		return RemoveFlag; 
		
	}
	
	//create_Bike(BikeName,Engine_ID,bike_Model,BikePrice);
	
	public boolean create_Bike(int engine_number, String model, String name, String color) throws ClassNotFoundException
	{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
			
			String sql = "INSERT INTO bike VALUES (?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, engine_number);
			statement.setString(2, model);
			statement.setString(3, name);
			statement.setString(4, color);
			statement.execute();
			
			//Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from bike");
			
			
			/*while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}*/
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		boolean AddBikeFlag=true;
		//queries
		
		return AddBikeFlag; 
		
	}
	
	public ResultSet getAllBikes() throws ClassNotFoundException {
		ResultSet rs = null;
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		String sql = "select * from bike";
		PreparedStatement stat = con.prepareStatement(sql);
		
		rs = stat.executeQuery();
		
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
		
		
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
	return rs;
	
	}

	public ResultSet GetCustomer(String customer_cnic) throws ClassNotFoundException {
		ResultSet rs = null;
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		String sql = "select customer_cnic from customer where customer_cnic=?";
		PreparedStatement stat = con.prepareStatement(sql);
		
		rs = stat.executeQuery();
		stat.setString(8, customer_cnic);
		
		/*while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}*/
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
		return rs;
	}

	public String[] restock_Bike(int bikeengine_number) throws ClassNotFoundException {
		String[] rs = null;
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		String sql = "DELETE FROM bike WHERE engine_number=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, bikeengine_number);
		statement.execute();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public boolean ChangeDetails(String[] rs) throws ClassNotFoundException, SQLException {
		
		ResultSet rs2 = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bikeshowroom", "root", "shadow123");
		
		String sql2 = "UPDATE FROM employee WHERE employee_id=?";
		PreparedStatement statement2 = con.prepareStatement(sql2);
		statement2.setString(1, rs[1]);
		statement2.execute();
		
		
		return true;
	}
}
