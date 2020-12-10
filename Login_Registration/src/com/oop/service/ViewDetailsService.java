package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module.Cart;
import module.Part;
import utill.DBconnection;

public class ViewDetailsService {
	
	
		
		//select all part details from system_item table under user selected id and insert into cart table
		
		public static List<Part> displayPartDetails(int id) {
			ArrayList<Part> partList = new ArrayList();
			
			
			try {
				//get DB connection 
				Connection con = DBconnection.getDBConnection();
				Statement stmt = con.createStatement();
				
				String sql1= "select * from system_item where pid='"+id+"'";
				ResultSet rs1= stmt.executeQuery(sql1);
				
				//declaration variables that need to retrieve from system_item table and insert to cart table
				int pid;
				String pname;
				String manufactName;
				String pbody;
				int modelNumber;
				float unitPrice;
				int year;
				String description;
				int quantityStock;
				
				
				
				if(rs1.next()) {
					
					 pid=rs1.getInt(1);
					 pname=rs1.getString(2);
					 manufactName= rs1.getString(3);
					 pbody=rs1.getString(4);
					modelNumber=rs1.getInt(5);
					 unitPrice=rs1.getFloat(6);
					 year =rs1.getInt(7);
					 description=rs1.getString(8);
					 quantityStock=rs1.getInt(9);
					
					Part p=new Part(pid,pname,manufactName,pbody,modelNumber,unitPrice,year,description,quantityStock);
					partList.add(p);
					
				}

			}catch(Exception e){
						e.printStackTrace();
			}
	
	
	
			return partList;

		}

		
		//display added  part details in the cart
		public static ArrayList<Cart> displayAllPartDetails() {
			ArrayList<Cart> partList = new ArrayList();
			
			
			try {
				//get DB connection 
				Connection con = DBconnection.getDBConnection();
				Statement stmt = con.createStatement();
				
				String sql1= "select * from cart";
				ResultSet rs1= stmt.executeQuery(sql1);
				
				//declaration variables 
				int pid;
				String pname;
				String manufactName;
				String pbody;
				int modelNumber;
				float unitPrice;
				int year;
				String description;
				int quantityStock;
				int qty;
				
				
				
				while(rs1.next()) {
					
					 pid=rs1.getInt(1);
					 unitPrice=rs1.getFloat(2);
					 qty=rs1.getInt(3);
					 pname=rs1.getString(4);
					 manufactName= rs1.getString(5);
					 pbody=rs1.getString(6);
					modelNumber=rs1.getInt(7); 
					 quantityStock=rs1.getInt(8);
					
					Cart c=new Cart(pid,unitPrice,qty,pname,manufactName,pbody,modelNumber,quantityStock);
					
					partList.add(c);
				}

			}catch(Exception e){
						e.printStackTrace();
			}
	
	
	
			return partList;

		}

		//validate requested quantity
		public static boolean checkQuantity(int pid, int qty) {
			
			int SQty = 0;
			boolean check = false;
			
			try {
				//get DB connection 
				Connection con = DBconnection.getDBConnection();
				Statement stmt = con.createStatement();
				
				//Retrieve stock quantity value of the user selected part 
				String sql1= "select QuantityInStock from system_item where pid='"+pid+"'";
				
				ResultSet rs1= stmt.executeQuery(sql1);
				
				if(rs1.next())
				{
					SQty = rs1.getInt(1);
				}
			
				if(SQty >= qty)
				{
					check = true;
				}

			}catch(Exception e){
						e.printStackTrace();
			}
	
	
			
			
			return check;
		}

		
		
		//Insert selected part details to the cart table
		public static boolean AddToCart(Cart c) {
			
			boolean rs = false;
			
			try {
				//get DB connection 
				Connection con = DBconnection.getDBConnection();
				
				
				//insert data to the cart table
				String sql= "Insert into cart values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, c.getPartId());
				st.setFloat(2, c.getUnitPrice());
				st.setInt(3, c.getQty());
				st.setString(4, c.getpName());
				st.setString(5, c.getManufactName());
				st.setString(6, c.getBodyStyle());
				st.setInt(7, c.getModelNumber());
				st.setInt(8, c.getQtyStock());
				
				int no = st.executeUpdate();
				
				if(no > 0)
				{
					rs = true;
				}
				

			}catch(Exception e){ 
				e.printStackTrace();
			}
			
			
			
			return rs;
		}
		
		//method for delete an added item from the cart
		
		public static boolean deleteItem(int pid) {
			
			boolean rs=false;
			try {
				
				Connection con = DBconnection.getDBConnection();
				Statement stmt=con.createStatement();
				
				
				//delete statement
				String sql="delete from cart where pid='"+pid+"'";
				int r=stmt.executeUpdate(sql);
				
				if(r>0) {
					rs=true;
				}
					else {
						rs=false;
					}
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return rs;
		}
		
		//method for display cart items details for update process

		public static ArrayList<Cart> displayForUpdate(int id) {
			ArrayList<Cart> cartList = new ArrayList();
			
			
			try {
				//get DB connection 
				Connection con = DBconnection.getDBConnection();
				Statement stmt = con.createStatement();
				
				
				//display cart table details for update 
				String sql1= "select * from cart where pid='"+id+"'";
				ResultSet rs1= stmt.executeQuery(sql1);
				
				
				int pid;
				String pname;
				String manufactName;
				String pbody;
				int modelNumber;
				float unitPrice;
				int quantityStock;
				int qty;
				
				
				
				if(rs1.next()) {
					
					 pid=rs1.getInt(1);
					 unitPrice=rs1.getFloat(2);
					 qty=rs1.getInt(3);
					 pname=rs1.getString(4);
					 manufactName= rs1.getString(5);
					 pbody=rs1.getString(6);
					modelNumber=rs1.getInt(7);
					 quantityStock=rs1.getInt(8);
					
					Cart c=new Cart(pid,unitPrice,qty,pname,manufactName,pbody,modelNumber,quantityStock);
					cartList.add(c);
					
				}

			}catch(Exception e){
						e.printStackTrace();
			}
	
	
	
			return cartList;

		}
		
		
		
		//method for update a requested quantity of the part
		public static boolean updateCart(int id,int qty) {
			boolean rs=false;
			
			try {
				
				//get DB connection 
				Connection con = DBconnection.getDBConnection();
				Statement stmt = con.createStatement();
				
				
				//update statement 
				String sql1= "update cart set qty='"+qty+"' where pid='"+id+"'";
				int rs1= stmt.executeUpdate(sql1);
				if(rs1>0) {
					rs=true;
					
				}else {
					rs=false;
				}
				
				
				
				
			}catch(Exception e)
				{
				e.printStackTrace();
				}
			
			
			return rs;
			
		}
		
		
		
}
