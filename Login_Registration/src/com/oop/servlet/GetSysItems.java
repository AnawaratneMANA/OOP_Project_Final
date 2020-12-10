package oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.Item;
import oop.service.ItemInterface;
import oop.service.ItemInterfaceImp;

/**
 * Servlet implementation class AlterItems
 */
@WebServlet("/GetSysItems")
public class GetSysItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSysItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			if(request.getParameter("submit")!= null) {
				//creating interface object and call methods
				ItemInterface i = new ItemInterfaceImp();
				List<Item> Items = i.getItemList();
				request.setAttribute("Items", Items);
				request.getRequestDispatcher("ItemController.jsp").forward(request, response);
				
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);//fail
			}
			
			
			//errros
		} catch (Exception e) {
			System.out.println("Item Get Error");
		}
		
		
		
	}

}
