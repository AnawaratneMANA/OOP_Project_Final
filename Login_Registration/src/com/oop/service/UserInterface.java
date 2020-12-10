package oop.service;

import java.util.List;

import oop.model.User;

public interface UserInterface {
	
	
	public List<User> GetUserData(String value);
	public boolean UpgradeToAdmin(String uname,String des);
	public boolean DeleteUser(String id);
	public List<User> GetAllUsers();
}
