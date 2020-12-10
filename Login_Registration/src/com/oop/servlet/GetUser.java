package oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.User;
import oop.service.UserInterface;
import oop.service.UserInterfaceImp;

/**
 * Servlet implementation class GetUser
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUser() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String uname = request.getParameter("UN");
			//creating interface object and call methods
			UserInterface u = new UserInterfaceImp();
			List<User> Items = u.GetUserData(uname);
			request.setAttribute("Items", Items);
		
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("userDetails.jsp");//success
			dispatcher1.forward(request, response);
			//error
		} catch (Exception e) {
			System.out.println("Item Get Error");
		}

	}

}
