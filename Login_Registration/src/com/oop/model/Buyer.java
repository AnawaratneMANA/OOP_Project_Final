package com.oop.model;

public class Buyer extends MainUser{

	//Attributes 
	private String credit;
	
	//Default constructor
	public Buyer()
	{
		
	}

	//Constructor 
	public Buyer(int id, String uname, String fullname, String email, String nic, String phonenumber,
			String dateofbirth, String type, String password, String cpassword, String credit) {
		super(id, uname, fullname, email, nic, phonenumber, dateofbirth, type, password , cpassword);
		this.credit = credit;
	}

	//Setters and getters
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	//Getter to output the name
		public String getUserType()
		{
			return "buyer";
			
		}
	
	
	

	
}
