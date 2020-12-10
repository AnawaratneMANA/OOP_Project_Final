package com.oop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oop.model.Admin;
import com.oop.model.Buyer;
import com.oop.model.Seller;
import com.oop.model.MainUser;
import com.oop.util.DBConnection;

public class UserServiceImpl implements IUserService {

	//Attributes 
	private static  Connection conn;
	
	//Constructor 
	public UserServiceImpl ()
	{
		conn = DBConnection.getDBConnection();
	}
	
	@Override
	public boolean addNewUser(MainUser obj)  {

		String sql = "INSERT INTO user values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setObject(1, 0);
			stm.setObject(2, obj.getUname());
			stm.setObject(3, obj.getFullname());
			stm.setObject(4, obj.getEmail());
			stm.setObject(5, obj.getNic());
			stm.setObject(6, obj.getPhonenumber());
			stm.setObject(7, obj.getDateofbirth());
			stm.setObject(8, obj.getType());
			stm.setObject(9, obj.getPassword());
			
			//validation
			int res = stm.executeUpdate();
			return res>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addAdmin(Admin obj) {
		
		String sql = "INSERT INTO admin values(?,?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setObject(1, 0);
			stm.setObject(2, obj.getDescription());
			stm.setObject(3, obj.getUname());
			
			//validation
			int res = stm.executeUpdate();
			return res>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addSeller(Seller obj) {
		
		String sql = "INSERT INTO seller values(?,?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setObject(1, 0);
			stm.setObject(2, obj.getCompany());
			stm.setObject(3, obj.getUname());
			
			//validation
			int res = stm.executeUpdate();
			return res>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addBuyer(Buyer obj) {
		
		String sql = "INSERT INTO buyer values(?,?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setObject(1, 0);
			stm.setObject(2, obj.getCredit());
			stm.setObject(3, obj.getUname());
			
			//validation
			int res = stm.executeUpdate();
			return res>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MainUser selectInfo(String obj) {
		
		MainUser N = new MainUser();
		
		String sql = "SELECT * FROM user WHERE username = ?";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setObject(1, obj);
			ResultSet rs    =   stm.executeQuery();
			//Assign all the values to the User Object 
			rs.next();
			N.setFullname(rs.getString("fullname"));
			N.setEmail(rs.getString("email"));
			N.setNic(rs.getString("nic"));
			N.setPhonenumber(rs.getString("phonenumber"));
			N.setDateofbirth(rs.getString("dateofbirth"));
			N.setType(rs.getString("type"));
			N.setPassword(rs.getString("password"));
			
			
			return N;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean UpdateUser(MainUser obj) {
		String sql = "UPDATE user SET fullname=?,email=?, nic=?, phonenumber=?, dateofbirth=? WHERE username = ?";
		int ret = -1;
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, obj.getFullname());
			stm.setString(2, obj.getEmail());
			stm.setString(3, obj.getNic());
			stm.setString(4, obj.getPhonenumber());
			stm.setString(5, obj.getDateofbirth());
			stm.setString(6, obj.getUname());
			
			ret = stm.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ret>0;
	}

	@Override
	public boolean deleteUser(String id) {
		
		//return value 
		int ret = -1;
		//Delete from child tables first
		UserServiceImpl.deleteChild(id);
		
		//Delete from the parent table 
		String sql = "DELETE FROM user WHERE username =?";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	//Child table cleaning method 
	public static void deleteChild(String id)
	{
		//Delete from the Admin if exist
		String sql1 = "DELETE FROM admin WHERE username =?";
		try {
			PreparedStatement stm1 = conn.prepareStatement(sql1);
			stm1.setString(1, id);
			stm1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Delete from Seller if exist
		String sql2 = "DELETE FROM seller WHERE username =?";
		try {
			PreparedStatement stm2 = conn.prepareStatement(sql2);
			stm2.setString(1, id);
			stm2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Delete from Buyer if exist
		String sql3 = "DELETE FROM buyer WHERE username =?";
		try {
			PreparedStatement stm3 = conn.prepareStatement(sql3);
			stm3.setString(1, id);
			stm3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
