package com.oop.service;

import com.oop.model.Admin;
import com.oop.model.Buyer;
import com.oop.model.Seller;
import com.oop.model.MainUser;

public interface IUserService {
	
	//Add/Update methods
	public boolean addNewUser(MainUser obj);
	public boolean addAdmin(Admin obj);
	public boolean addSeller(Seller obj);
	public boolean addBuyer(Buyer obj);
	public boolean UpdateUser(MainUser obj);
	

	//Select Methods
	public MainUser selectInfo(String obj);
	
	//Delete Methods
	public boolean deleteUser(String id);
}
