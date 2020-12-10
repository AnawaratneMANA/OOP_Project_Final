package oop.service;


import java.sql.SQLException;
import java.util.List;

import oop.model.Item;
import oop.model.SellerItem;

public interface ItemInterface {
	
	
	public boolean addItem(String name,String manu,String pbody,int model,double uprice,int year,int quan,String des)throws SQLException, ClassNotFoundException;
	public List<SellerItem> getSelleritems()throws SQLException, ClassNotFoundException;
	public boolean DeleteItems(String id)throws SQLException, ClassNotFoundException;
	public List<Item> getItemList();
	boolean DeleteSellerItems(String id) throws SQLException, ClassNotFoundException;
	public boolean updateItem(int id, String name, String manu, String pbody, int model, double uprice, int year,int quan, String des)throws SQLException, ClassNotFoundException;

}
