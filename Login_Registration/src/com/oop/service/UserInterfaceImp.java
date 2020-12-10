package oop.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oop.model.User;
import oop.util.DBConnection;

public class UserInterfaceImp implements UserInterface {

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<User> GetUserData(String value) {
		
		ArrayList<User> values = new ArrayList<>();

		try {
			//connection 
			Connection con  = DBConnection.getDBConnection();
			Statement st;
			st = con.createStatement();
			String sql = "SELECT * FROM user WHERE username LIKE '%"+value+"%'";
			ResultSet rs = st.executeQuery(sql);
				
			while(rs.next()) {
				//getting db values according to column
				int id = rs.getInt("iduser");
				String uname =rs.getString("username");
				String fullname =rs.getString("fullname");
				String email = rs.getString("email");
				String nic = rs.getString("nic");
				String phone = rs.getString("phonenumber");
				String dob = rs.getString("dateofbirth");
				String type = rs.getString("type");
				
				User obj = new User(id,uname,fullname,email,nic,phone,dob,type);//adding to object
					
				values.add(obj);//object adds into array list
			}
		} catch (SQLException e) {
			System.out.println("GetUser error");
		}
		
		return values;	
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean UpgradeToAdmin(String uname,String des) {
		
		boolean done = false;
		int i = 0;
		
		try {
			//connection 
			Connection con  = DBConnection.getDBConnection();
			Statement st = con.createStatement();
		
			String sql = "Select * from user where username = '"+uname+"'";//
			
			String sql2 = "Update user set type = 'A' where username = '"+uname+"'";
			String sql3 = "Insert into admin values(0,'"+des+"','"+uname+"')";
			String sql4 = "Delete from buyer where username = '"+ uname+"'";//
			String sql5 = "Delete from seller where username = '"+ uname+"'";//
		
			
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			//getting db values according to column
			String x = rs.getString("type");
			if(x.equalsIgnoreCase("b")) {
					
					i = st.executeUpdate(sql4);//method Returns 1 for success and 0 for unsuccess
					i = i + st.executeUpdate(sql2);	//method Returns 1 for success and 0 for unsuccess
					i = i + st.executeUpdate(sql3);//method Returns 1 for success and 0 for unsuccess
					
					
			} else if(x.equalsIgnoreCase("s")) {
					
					i = st.executeUpdate(sql5);//method Returns 1 for success and 0 for unsuccess
					i = i + st.executeUpdate(sql2);	//method Returns 1 for success and 0 for unsuccess
					i = i + st.executeUpdate(sql3); //method Returns 1 for success and 0 for unsuccess
			}
			//check if successful or not
			if( i > 2) { 
				done = true;
			}
			
		} catch(Exception e) {
			System.out.println(" UpgradeToAdmin error");
			e.printStackTrace();
		}
		return done;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean DeleteUser(String id) {
		boolean done = false;
		try {
			int i=0;
			//connection 
			Connection con  = DBConnection.getDBConnection();
			Statement st = con.createStatement();
			
			String sql = "DELETE FROM user WHERE username='"+id+"'" ;
			String sql2 = "Select type from user WHERE username ='"+id+"'";
			String sql3 = "Delete FROM buyer where username = '"+id+"'";
			String sql4 = "Delete FROM seller where username = '"+id+"'";
			String sql5= "Delete FROM admin where username = '"+id+"'";

			
			ResultSet rs = st.executeQuery(sql2);
			rs.next();
			String x = rs.getString("type");//getting db values according to column
			if(x.equalsIgnoreCase("a")) {
				i = st.executeUpdate(sql5);//method Returns 1 for success and 0 for unsuccess
			}
			if(x.equalsIgnoreCase("b")) {
				i = st.executeUpdate(sql3);//method Returns 1 for success and 0 for unsuccess
			}
			if(x.equalsIgnoreCase("s")) {	
				i = st.executeUpdate(sql4);//method Returns 1 for success and 0 for unsuccess
			}
			
			i = i + st.executeUpdate(sql);//method Returns 1 for success and 0 for unsuccess
			
			//check if successful or not(all executions happend)
			if( i > 1) {
				done = true;
			} else {
				done = false;
			}
			
		}catch(Exception e) {
			System.out.println("DeleteUser error");
			e.printStackTrace();
		}
		
		return done;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<User> GetAllUsers() {
		ArrayList<User> values = new ArrayList<>();
		
		//connection 
		Connection con  = DBConnection.getDBConnection();
		try {
			Statement st = con.createStatement();
			String sql = "Select * from user";
			ResultSet rs = st.executeQuery(sql);
				
			while(rs.next()) {
				//getting db values according to column and adds to object
				User obj = new User();
				obj.setId(rs.getInt(1));//adding to object
				obj.setUname(rs.getString(2));//adding to object
				obj.setFullname(rs.getString(3));//adding to object
				obj.setEmail(rs.getString(4));//adding to object
				obj.setNic(rs.getString(5));//adding to object
				obj.setPhonenumber(rs.getString(6));//adding to object
				obj.setDateofbirth(rs.getString(7));//adding to object
				obj.setType(rs.getString(8));//adding to object
				
				values.add(obj);//object adds into array list
				
			}

		}catch(Exception e) {
			
		}	
		return values;
	}

}
