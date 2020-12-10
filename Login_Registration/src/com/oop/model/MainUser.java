package com.oop.model;

public class MainUser {
	//Attributes 
	private int id;
	private String uname;
	private String fullname;
	private String email;
	private String nic;
	private String phonenumber;
	private String dateofbirth;
	private String type;
	private String password;
	private String cpassword;
	
	//Default Constructor
	public MainUser()
	{
		
	}
	
	//Constructors 
	public MainUser(int id, String uname, String fullname, String email, String nic, String phonenumber, String dateofbirth,
			String type, String password, String cpassword) {
		super();
		this.id = id;
		this.uname = uname;
		this.fullname = fullname;
		this.email = email;
		this.nic = nic;
		this.phonenumber = phonenumber;
		this.dateofbirth = dateofbirth;
		this.type = type;
		this.password = password;
		this.cpassword = cpassword;
	}

	//Methods (Setters and getters)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}

	public void seCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	
	
}
