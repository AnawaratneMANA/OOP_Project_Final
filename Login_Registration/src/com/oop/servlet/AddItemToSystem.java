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
 * Servlet implementation class ItemManager
 */
@WebServlet("/AddItemToSystem")
public class AddItemToSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemToSystem() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
			//declarations
			int model = 1,year = 1,quan = 1;
			double uprice = 1;
			//check null and get parameter values
			if(request.getParameter("IMN") != null) {
				model = Integer.parseInt(request.getParameter("IMN").trim());
			}
			if(request.getParameter("IU") != null) {
				uprice = Double.parseDouble("IU");
			}
			if(request.getParameter("IY") != null) {
				year = Integer.parseInt(request.getParameter("IY").trim());
			}
			if(request.getParameter("IQ") != null) {
				quan = Integer.parseInt(request.getParameter("IQ").trim());
			}
			
			
			String name = request.getParameter("INAME");
			String manu = request.getParameter("IMANU");
			String pbody = request.getParameter("IPB");
			String Des = request.getParameter("IDES");
			
			
			//creating interface object and call methods
			ItemInterface i = new ItemInterfaceImp();
			boolean x = i.addItem(name,manu,pbody,model,uprice,year,quan,Des);
			
			//check successful or unsuccessful
			if (x == true){
				RequestDispatcher resd = request.getRequestDispatcher("done.jsp");
				resd.forward(request, response);
			} else {
				RequestDispatcher resd = request.getRequestDispatcher("error.jsp");
				resd.forward(request, response);
			}
			//check about errors
		}catch (NumberFormatException e) {
			System.out.println("NumberFormatException ");
		} catch (SQLException e) {
			System.out.println("SQLException");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (java.lang.NullPointerException e) {
			System.out.println("null");
		}
		
	}

}
