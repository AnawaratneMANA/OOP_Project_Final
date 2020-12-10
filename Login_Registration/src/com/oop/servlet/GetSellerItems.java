package oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.SellerItem;
import oop.service.ItemInterface;
import oop.service.ItemInterfaceImp;

/**
 * Servlet implementation class GetSellerItems
 */
@WebServlet("/GetSellerItems")
public class GetSellerItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSellerItems() {
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
		
		try {
			if(request.getParameter("submit")!= null) {
				//creating interface object and call methods
				ItemInterface i = new ItemInterfaceImp();
				List<SellerItem> Items = i.getSelleritems();
				request.setAttribute("Items", Items);
				request.getRequestDispatcher("SellerItems.jsp").forward(request, response);//success
				
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);//fail
			}
			
			//errros
		} catch (Exception e) {
			System.out.println("Seller Item Get Error");
		}
	}

}
