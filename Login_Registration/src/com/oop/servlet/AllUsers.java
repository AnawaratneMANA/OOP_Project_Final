package oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.User;
import oop.service.UserInterface;
import oop.service.UserInterfaceImp;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/AllUsers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//check if the parameter null 
			if(request.getParameter("submit")!= null) {
				//creating interface object and call methods
				UserInterface u = new UserInterfaceImp();
				List<User> Items = u.GetAllUsers();//getting return type to arraylist
				request.setAttribute("Items", Items);//forwarding array
				request.getRequestDispatcher("userDetails.jsp").forward(request, response);//calling page
				
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
			
			//check errors
		} catch (Exception e) {
			System.out.println("Item Get Error");
		}
		
		
		
	}

}
