package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IUserService;
import com.oop.service.UserServiceImpl;

/**
 * Servlet implementation class DeleteControl
 */
@WebServlet("/DeleteControl")
public class DeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteControl() {
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
		
		//Getting the ID from the page when click on the delete button
		String id = request.getParameter("username");
		
		//Creating a Object from the Loginservice class
		IUserService log = new UserServiceImpl();
		
		//Creating a variable from the interface
		boolean isAdded = log.deleteUser(id);
		if (isAdded == true)
		{
			System.out.println("Success Deleting User");
			
		}
	}

}
