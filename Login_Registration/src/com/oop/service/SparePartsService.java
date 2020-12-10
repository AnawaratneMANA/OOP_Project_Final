package com.seller.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.item.DBConnect;
import com.item.item;
import com.seller.model.SparePart;

public class SparePartsService {
	private static final String Integr = null;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static item sparePart;
	private static Object request;
	private static int qty;   
	
	public static boolean insertSparePart(String itemname,double itemprice, String itemcategory,int itemquantity){
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO item VALUES (0,'"+itemname+"','"+itemprice+"','"+itemcategory+"','"+itemquantity+"')";
			int  rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false; 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static ArrayList<SparePart> getSpareParts() {
		ArrayList<SparePart> spareParts = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection(); 
			stmt = con.createStatement();
			String sql = "select * from item";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				SparePart sparePart = new SparePart();
				
				sparePart.setId(rs.getInt(1));
				sparePart.setItemname(rs.getString(2));
				sparePart.setItemprice(Double.parseDouble(rs.getString(3)));
				sparePart.setItemcategory(rs.getString(4));
				sparePart.setItemquantity(Integer.parseInt(rs.getString(5)));
				
				spareParts.add(sparePart);
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return spareParts;
	}
	
	public static ArrayList<SparePart> searchSpareParts(String keyword) {
		ArrayList<SparePart> spareParts = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection(); 
			stmt = con.createStatement();
			String sql = "select * from item where ItemName like '%"+keyword+"%' or Amount like '%"+keyword+"%' or Category like '%"+keyword+"%' or Quantity like '%"+keyword+"%'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				SparePart sparePart = new SparePart();
				
				sparePart.setId(rs.getInt(1));
				sparePart.setItemname(rs.getString(2));
				sparePart.setItemprice(Double.parseDouble(rs.getString(3)));
				sparePart.setItemcategory(rs.getString(4));
				sparePart.setItemquantity(Integer.parseInt(rs.getString(5)));
				
				spareParts.add(sparePart);
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return spareParts;
	}
	
	public static void deletSparePart(int sparePartId) {
		
		try {
			con = DBConnect.getConnection();
			
			PreparedStatement ps = con.prepareStatement("delete from item where idItem=?");
			ps.setInt(1, sparePartId);
			ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateSparepart(SparePart sparePart) {
		
		try {
			con = DBConnect.getConnection();
			String sql="Update item set ItemName=?,Amount=?,Category=?,Quantity=? where idItem="+sparePart.getId();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,sparePart.getItemname());
			ps.setDouble(2, sparePart.getItemprice());
			ps.setString(3, sparePart.getItemcategory());
			ps.setInt(4, sparePart.getItemquantity());
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				System.out.print("Record Updated Successfully");
			} else {
				System.out.print("There is a problem in updating Record.");
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//getOutOfProduct in the System
	public static int getOutOfProduct() {
		
		
		//SparePart sparePart = new SparePart();
		
		try {
			con = DBConnect.getConnection();
			//stmt = con.createStatement();
			String sql = "Select count(idItem) as 'outofproducts' from item where Quantity = ? ";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setObject(1, 0);
			ResultSet rs = stm.executeQuery();
			rs.next();
			String str = rs.getString("outofproducts");
            int qty = Integer.parseInt(str);
			System.out.println("Testing : " + qty); //Testing
			return qty;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
					
}	
		
	
	//getTotalProducts in the system
	public static int getTotalProducts() {
		
		try {
			con = DBConnect.getConnection();
			//stmt = con.createStatement();
			String sql = "Select count(idItem) as 'Totalproducts' from item";
			PreparedStatement stm = con.prepareStatement(sql);
			//stm.setObject(1, 0);
			ResultSet rs = stm.executeQuery();
			rs.next();
			String str = rs.getString("Totalproducts");
            int tot = Integer.parseInt(str);
			System.out.println("Testing : " + tot); //Testing
			return tot;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//getTotalItems in the system 
	public static int getTotalItems() {
		
		try {
			con = DBConnect.getConnection();
			//stmt = con.createStatement();
			String sql = "Select SUM(Quantity) AS 'TotalItems' from item";
			PreparedStatement stm = con.prepareStatement(sql);
			//stm.setObject(1, 0);
			ResultSet rs = stm.executeQuery();
			rs.next();
			String str = rs.getString("TotalItems");
            int totitem = Integer.parseInt(str);
			System.out.println("Testing : " + totitem); //Testing
			return totitem;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static int getCategories() {
		
		try {
			con = DBConnect.getConnection();
			//stmt = con.createStatement();
			String sql = "Select COUNT(category) AS 'TotalCategory' from item";
			PreparedStatement stm = con.prepareStatement(sql);
			//stm.setObject(1, 0);
			ResultSet rs = stm.executeQuery();
			rs.next();
			String str = rs.getString("TotalCategory");
            int totcategory = Integer.parseInt(str);
			System.out.println("Testing : " + totcategory); //Testing
			return totcategory;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}	
}
	








