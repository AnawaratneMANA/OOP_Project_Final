package oop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.service.ItemInterface;
import oop.service.ItemInterfaceImp;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameter
		String id = request.getParameter("id");
	
		//creating interface object and call methods
		ItemInterface i = new ItemInterfaceImp();
		try {
			boolean x = i.DeleteItems(id);
			
			//check the return
			if (x == true){
				//success
				RequestDispatcher resd = request.getRequestDispatcher("done.jsp");
				resd.forward(request, response);
			} else {
				//fail
				RequestDispatcher resd = request.getRequestDispatcher("error.jsp");
				resd.forward(request, response);
			}
			//errors
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Delete servlet error");
		}
	}

}
