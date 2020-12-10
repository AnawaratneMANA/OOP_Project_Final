package com.seller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.model.SparePart;

/**
 * Servlet implementation class GetSparePartServlet
 */
@WebServlet("/GetSparePartServlet")
public class GetSparePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSparePartServlet() {
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
		response.setContentType("text/html");

		SparePart sp = new SparePart();
		
		Integer itemId = Integer.parseInt(request.getParameter("sparePartID"));
		String itemname = request.getParameter("sparePartName");
		Double itemprice = Double.valueOf(request.getParameter("sparePartPrice"));
		String itemcategory = request.getParameter("sparePartCategory");
		Integer itemquantity = Integer.parseInt(request.getParameter("sparePartQuantity"));
		
		sp.setId(itemId);
		sp.setItemname(itemname);
		sp.setItemprice(itemprice);
		sp.setItemcategory(itemcategory);
		sp.setItemquantity(itemquantity);
 		
		request.setAttribute("sparePart", sp);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateSparePart.jsp");
		dispatcher.forward(request, response);
	}

}
