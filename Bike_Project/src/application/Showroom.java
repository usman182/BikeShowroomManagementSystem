package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Showroom 
{
	
	private String receptionist;
	private String infoDesk;
	private String receptionistChair;
	
	public String getReceptionist() 
	{
		return receptionist;
	}

	public void setReceptionist(String receptionist) 
	{
		this.receptionist = receptionist;
	}

	public String getInfoDesk() 
	{
		return infoDesk;
	}

	public void setInfoDesk(String infoDesk) 
	{
		this.infoDesk = infoDesk;
	}

	public String getReceptionistChair() 
	{
		return receptionistChair;
	}

	public void setReceptionistChair(String receptionistChair) 
	{
		this.receptionistChair = receptionistChair;
	}

	
	
	public void AddBike(int engine_number, String model, String name, String color) throws ClassNotFoundException 
	{
		boolean flag2=false;
		
		
		int Engine_Number = engine_number;
		String Model = model;
		String Name = name;
		String Color = color;
		
		Admin objAddBike=new Admin();
		flag2=objAddBike.Add_Bike(engine_number, model, name, color);
		
		
		
		if(flag2==true)
		{
	      System.out.println("Bike Added succesfully");		
		}	
		
		
	}
	
	
	
	
	public String[] searchBike(int engine_Number, String bike_name) throws ClassNotFoundException, SQLException 
	{
		String[] rs = null;
		int Engine_Number=engine_Number;
		boolean flag=false;
		String Name=bike_name;
		Salesperson obj=new Salesperson();
		rs= obj.Search_Bike(engine_Number,bike_name);
		
		/*if(rs.getInt(1) == engine_Number || rs.getString(3) == bike_name)
		{
	      System.out.println("Bike Found succesfully");		
		}*/
		//return rs;
		System.out.println("Showroom");
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
		
		
		return rs;
                
	}
	
	public String[] ChangeDetails(int ID) throws ClassNotFoundException, SQLException  
	{
		String[] rs=null;
		int Emp_ID=ID;
		Admin objAdm=new Admin();
		rs=objAdm.ChangeDetails(ID);
		
		return rs;
                
	}
	
	
	public void DeleteDetail(int Employee_ID) throws ClassNotFoundException, SQLException  
	{
		
		boolean flag=false;
		int Emp_ID=Employee_ID;
		Admin objAdm=new Admin();
		flag=objAdm.DeleteDetails(Employee_ID);
		//flag= objAdm.removeEmp(Emp_ID); 
		
		if(flag==true)
		{
	      System.out.println("Change Emplyee Details succesfully");		
		}
                
	}
	
	public boolean Add_Employee(int employee_id, String employee_name, String employee_address, String employee_phoneNumber, String employee_cnic) throws ClassNotFoundException  
	{
		
		boolean flag=false;
		int Employee_id = employee_id;
		String Employee_name = employee_name;
		String Employee_address = employee_address;
		String Employee_phoneNumber = employee_phoneNumber;
		String Employee_cnic = employee_cnic;
		
		Admin objAdm=new Admin();
		flag= objAdm.AddEmployee(employee_id, employee_name,employee_address, employee_phoneNumber, employee_cnic); 
		
		if(flag==true)
		{
	      System.out.println("Added Employee succesfully");		
		}
            
		return flag; 
	}
	
	
	public boolean Add_Customer(String Name,String CNIC, String Details)  
	{
		
		boolean flag=false;
		String customer_CNIC=CNIC;
		String customer_name=Name;
		String customer_Detail =Details; 
		Salesperson objAdm=new Salesperson();
		flag= objAdm.CustomerDetails(customer_Detail,customer_CNIC,customer_name); 
		
		if(flag==true)
		{
	      System.out.println("Change Emplyee Details succesfully");		
		}
            
		return flag; 
	}
	
	public boolean ShowBikes() throws ClassNotFoundException {
		
		Salesperson salesperson = new Salesperson();
		salesperson.ShowBikes();
		return true;
	}
	
	public ResultSet verifyCustomer(String customer_cnic) throws ClassNotFoundException {
		
		ResultSet flag = null;
		Salesperson salesperson = new Salesperson();
		return flag=salesperson.verifyCustomer(customer_cnic);
	}
	
	
    public String[] EnterItem(int bikeengine_number) throws ClassNotFoundException {
    	String[] flag = null;
		Salesperson salesperson = new Salesperson();
		return flag=salesperson.EnterItem(bikeengine_number);
    }
	
    public String[] bookBike(String bike_name) throws ClassNotFoundException, SQLException 
	{
		String[] rs = null;
		//int Engine_Number=engine_Number;
		boolean flag=false;
		String Name=bike_name;
		Bike obj=new Bike();
		rs= obj.bookBike(bike_name);
		
	
		System.out.println("Showroom");
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
		Bike obj=new Bike();
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
		Bike obj=new Bike();
		rs= obj.purchaseBookBike(bike_Name);
		
	
		System.out.println("Showroom");
		for (int i=1; i<=4; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
		
		
		return rs;
                
	}
	
}
