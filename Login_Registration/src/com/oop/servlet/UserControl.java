package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.model.Admin;
import com.oop.model.Buyer;
import com.oop.model.Seller;
import com.oop.model.MainUser;
import com.oop.service.IUserService;
import com.oop.service.UserServiceImpl;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting information from the form
		String uname = request.getParameter("username");
		
		//Add username to a session variable
		HttpSession session = request.getSession();
	    session.setAttribute("username", uname);
	    
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String nic = request.getParameter("nic");
		String phone = request.getParameter("phone");
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		
		//Passwords
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		
		//Human verification
		String human = request.getParameter("human");
		
		//Rest of the optional inputs 
		String utype = request.getParameter("utype");
		String admin_descrip = request.getParameter("descrip");
		String seller_company = request.getParameter("company");
		String buyer_card = request.getParameter("card");
		
		//Determine what kind of user registering 
		if(utype.contentEquals("A"))
		{
			//Creating a object from Admin
			Admin user = new Admin();
			
			//Set all information to the User
			user.setUname(uname);
			user.setFullname(fullname);
			user.setEmail(email);
			user.setNic(nic);
			user.setPhonenumber(phone);
			user.setDateofbirth(date);
			user.setType(type);
			user.setPassword(password);
			user.seCpassword(cpassword);
			user.setDescription(admin_descrip);
			
			//Creating a Object from the Loginservice class
			IUserService log = new UserServiceImpl();
			
			//Creating a variable from the interface
			boolean isAdded = log.addNewUser(user);
			if (isAdded == true)
			{
				System.out.println("Success Adding User");
				
			}
			//Creating another variable and add the specific User
			boolean isAddedAdmin = log.addAdmin(user);
			if (isAddedAdmin == true)
			{
				System.out.println("Success Adding Admin");
				
				//Redirect user to the summary page
				response.sendRedirect(request.getContextPath() + "/summary.jsp");
			}
		}
		else if(utype.contentEquals("S"))
		{
			//Creating a object from Seller
			Seller user = new Seller();
			
			//Set all information to the User
			user.setUname(uname);
			user.setFullname(fullname);
			user.setEmail(email);
			user.setNic(nic);
			user.setPhonenumber(phone);
			user.setDateofbirth(date);
			user.setType(type);
			user.setPassword(password);
			user.seCpassword(cpassword);
			user.setCompany(seller_company);
			
			//Creating a Object from the Loginservice class
			IUserService log = new UserServiceImpl();
			
			//Creating a variable from the interface
			boolean isAdded = log.addNewUser(user);
			if (isAdded == true)
			{
				System.out.println("Success Adding User");
			}
			
			//Creating another variable and add the specific User
			boolean isAddedSeller = log.addSeller(user);
			if (isAddedSeller == true)
			{
				System.out.println("Success Adding Seller");
				
				//Redirect user to the summary page
				response.sendRedirect(request.getContextPath() + "/summary.jsp");
			}
		}
		else if(utype.contentEquals("B"))
		{
			//Creating a object from Buyer
			Buyer user = new Buyer();
			
			//Set all information to the User
			user.setUname(uname);
			user.setFullname(fullname);
			user.setEmail(email);
			user.setNic(nic);
			user.setPhonenumber(phone);
			user.setDateofbirth(date);
			user.setType(type);
			user.setPassword(password);
			user.seCpassword(cpassword);
			user.setCredit(buyer_card);
			
			
			//Creating a Object from the Loginservice class
			IUserService log = new UserServiceImpl();
			
			//Creating a variable from the interface
			boolean isAdded = log.addNewUser(user);
			if (isAdded == true)
			{
				System.out.println("Success Adding User");
			}
			
			//Creating another variable and add the specific User
			boolean isAddedBuyer = log.addBuyer(user);
			if (isAddedBuyer == true)
			{
				System.out.println("Success Adding Buyer");
				
				//Redirect user to the summary page
				response.sendRedirect(request.getContextPath() + "/summary.jsp");
			}
		}	
	}

}
