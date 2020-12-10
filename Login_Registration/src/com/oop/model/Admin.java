package com.oop.model;

public class Admin extends MainUser {
	//Attributes
	private String description;
	
	//Default Constructor 
	public Admin()
	{
		
	}

	//Constructor
	public Admin(int id, String uname, String fullname, String email, String nic, String phonenumber,
			String dateofbirth, String type, String password, String cpassword, String description) {
		super(id, uname, fullname, email, nic, phonenumber, dateofbirth, type, password, cpassword);
		this.description = description;
	}

	//Setters and getters 
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//Getter to output the name
	public String getUserType()
	{
		return "admin";
		
	}

	 
	
	
	
	
	
}
