package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.MainUser;
import com.oop.service.IUserService;
import com.oop.service.UserServiceImpl;

/**
 * Servlet implementation class UpdateControl
 */
@WebServlet("/UpdateControl")
public class UpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControl() {
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
				//Getting inputs from the Update form
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String nic = request.getParameter("nic");
				String phonenumber = request.getParameter("phonenumber");
				String dob = request.getParameter("dob");
				
				
				//Creating a object from Admin
				MainUser user = new MainUser();
				
				//Set all information which are to updated on User table 
				user.setUname(id);
				user.setFullname(name);
				user.setEmail(email);
				user.setNic(nic);
				user.setPhonenumber(phonenumber);
				user.setDateofbirth(dob);
				
				
				//Calling the update function 
				//Creating a Object from the Loginservice class
				IUserService log = new UserServiceImpl();
				//Executing the function
				boolean isAdded = log.UpdateUser(user);
				if (isAdded == true)
				{
					System.out.println("Success Updated User");
					
					//Redirect user to the summary page
					response.sendRedirect(request.getContextPath() + "/summary.jsp");
					
				}
	}

}
