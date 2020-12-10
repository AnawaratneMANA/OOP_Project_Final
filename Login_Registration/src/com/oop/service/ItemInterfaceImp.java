package oop.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oop.model.Item;
import oop.model.SellerItem;
import oop.util.DBConnection;

public class ItemInterfaceImp implements ItemInterface {

	///////////////////////////////////////////////////////////////////////////////////////////
	//adds items to system_item table
	@Override
	public boolean addItem(String name,String manu,String pbody,int model,double uprice,int year,int quan,String des)throws SQLException, ClassNotFoundException {
		
		boolean done = false;
			//connection 
			Connection con  = DBConnection.getDBConnection();
			Statement st = con.createStatement();
		
			String sql = "INSERT INTO system_item VALUES(0,'"+name+"','"+manu+"','"+pbody+"',"+model+","+uprice+","+year+","+quan+",'"+des+"')";
			int i = st.executeUpdate(sql);//method Returns 1 for success and 0 for unsuccess
			
			//check if successful or not
			if( i > 0) {
				done = true;
			} else {
				done = false;
			}
		return done;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<SellerItem> getSelleritems()throws SQLException, ClassNotFoundException {
		
		ArrayList<SellerItem> values = new ArrayList<>();
	
		//connection 
		Connection con  = DBConnection.getDBConnection();
		Statement st = con.createStatement();
		
		String sql = "Select * from item";
		ResultSet rs = st.executeQuery(sql);
			
		while(rs.next()) {
			//getting db values according to column
			int id = rs.getInt("idItem");
			String name = rs.getString("ItemName");
			Double amount = rs.getDouble("Amount");
			String cat = rs.getString("Category");
			int quan = rs.getInt("Quantity");
				
			SellerItem obj = new SellerItem(id,name,amount,cat,quan);//adding to object
				
			values.add(obj);//object adds into array list
		}
	return values;
}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean DeleteItems(String id)throws SQLException, ClassNotFoundException {
		boolean done = false;
		//connection 
		Connection con  = DBConnection.getDBConnection();
		Statement st = con.createStatement();
		
		String sql = "Delete from system_item where pname = '"+id+"'";
		int i = st.executeUpdate(sql);//method Returns 1 for success and 0 for unsuccess
		
		if( i > 0) {
			done = true;
		} else {
			done = false;
		}
		return done;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean DeleteSellerItems(String id)throws SQLException, ClassNotFoundException {
		boolean done = false;
		//connection 
		Connection con  = DBConnection.getDBConnection();
		Statement st = con.createStatement();
		
		String sql = "Delete from item where ItemName ='"+id+"'";
		int i = st.executeUpdate(sql);//method Returns 1 for success and 0 for unsuccess
		
		//check if successful or not
		if( i > 0) {
			done = true;
		} else {
			done = false;
		}
		return done;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Item> getItemList(){
		
		
		ArrayList<Item> values = new ArrayList<>() ;
	
		try {
			
			Connection con  = DBConnection.getDBConnection();
			Statement st = con.createStatement();
		
			String sql = "Select * from system_item";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				//getting db values according to column
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String manu = rs.getString(3);
				String pbody = rs.getString(4);
				int modelNo = rs.getInt(5);
				Double uprice = rs.getDouble(6);
				int year = rs.getInt(7);
				int quan = rs.getInt(8);
				String des = rs.getString(9);
				
					
				Item obj = new Item(id,name,manu,pbody,modelNo,uprice,year,quan,des);//adding to object
					
				values.add(obj);//object adds into array list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return values;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean updateItem(int id, String name, String manu, String pbody, int model, double uprice, int year,int quan, String des)throws SQLException, ClassNotFoundException {
		
		boolean done = false;
		//connection 
		Connection con  = DBConnection.getDBConnection();
		Statement st = con.createStatement();

		String sql = "UPDATE system_item SET pname='"+name+"',manufactName='"+manu+"' ,pbody='"+pbody+"',modelNumber="+model+" ,unitPrice="+uprice+", year="+year+", quantityInStock="+quan+", description='"+des+"' WHERE pid ="+id+"";
		int i = st.executeUpdate(sql);//method Returns 1 for success and 0 for unsuccess
	
		//check if successful or not
		if( i > 0) {
			done = true;
		} else {
			done = false;
		}
		return done;
	}
	
}
