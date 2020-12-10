package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utill.DBconnection;



public class PaymentService {


	
	public static boolean insertPayment(String type,int cnum,String  exdt,int cvv,String name,String country,String add1,String add2, String city,int pcode,String pnum,String email) {
		
		boolean IsSuccess=false;
	
		
		
		try {
			//get DB connection
			Connection con = DBconnection.getDBConnection();
			Statement stmt = con.createStatement();
			
			
			String sql="insert into payment values(0,'"+type+"','"+cnum+"','"+exdt+"','"+cvv+"','"+name+"','"+country+"','"+add1+"','"+add2+"','"+city+"','"+pcode+"','"+pnum+"','"+email+"')";
			
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				IsSuccess=true;
			}else
				IsSuccess=false;
		    		
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}	
			
		                  
		
		
		
		return IsSuccess;
		
		
		
		
		
	}
	
	
	
	
}
