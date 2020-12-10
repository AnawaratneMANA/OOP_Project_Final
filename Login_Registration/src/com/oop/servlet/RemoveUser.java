package oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oop.service.UserInterface;
import oop.service.UserInterfaceImp;

/**
 * Servlet implementation class RemoveUser
 */
@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getparamers
		String id = request.getParameter("VAL");
		//creating interface object and call methods
		UserInterface i = new UserInterfaceImp();
		try {
			boolean x = i.DeleteUser(id);//get return value
			
			if (x == true){
				RequestDispatcher resd = request.getRequestDispatcher("done.jsp");//pass
				resd.forward(request, response);
			} else {
				RequestDispatcher resd = request.getRequestDispatcher("error.jsp");//fail
				resd.forward(request, response);
			}
			//error
		} catch (Exception e) {
			System.out.println("Delete servlet error");
		}
	}
		
		
}

