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
 * Servlet implementation class UpdateSystemItems
 */
@WebServlet("/UpdateSystemItems")
public class UpdateSystemItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSystemItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//check null and set parameters
			int id=0,model = 0,year = 0,quan = 0;
			double uprice = 0;
			if(request.getParameter("IID") != null) {
				id = Integer.parseInt(request.getParameter("IID").trim());
			}
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
			boolean x = i.updateItem(id,name,manu,pbody,model,uprice,year,quan,Des);
			
			
			if (x == true){
				RequestDispatcher resd = request.getRequestDispatcher("done.jsp");//pass
				resd.forward(request, response);
			} else {
				RequestDispatcher resd = request.getRequestDispatcher("error.jsp");//fail
				resd.forward(request, response);
			}
			//errors
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
