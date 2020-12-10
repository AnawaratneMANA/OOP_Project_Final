package com.oop.model;

public class Seller extends MainUser{

	//Attributes 
	private String company;
	
	//Default constructor 
	public Seller()
	{
		
	}

	//Constructor
	public Seller(int id, String uname, String fullname, String email, String nic, String phonenumber,
			String dateofbirth, String type, String password,  String cpassword, String company) {
		super(id, uname, fullname, email, nic, phonenumber, dateofbirth, type, password , cpassword);
		this.company = company;
	}

	//Setters and getters 
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	//Getter to output the name
		public String getUserType()
		{
			return "seller";
			
		}
	
	
}
