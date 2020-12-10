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
 * Servlet implementation class createAdmin
 */
@WebServlet("/CreateAdmin")
public class CreateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//declarations and getparameters
		String un = request.getParameter("UID");
		String des = request.getParameter("DES");
		try {
			//creating interface object and call methods
			UserInterface u = new UserInterfaceImp();
			boolean x = u.UpgradeToAdmin(un, des);
			
			//check about return
			if (x == true){
				RequestDispatcher resd = request.getRequestDispatcher("done.jsp");
				resd.forward(request, response);
			} else {
				RequestDispatcher resd = request.getRequestDispatcher("error.jsp");
				resd.forward(request, response);
			}
			//error check
		} catch(Exception e) {
				System.out.println("Create admin error");
		}
	}

}
