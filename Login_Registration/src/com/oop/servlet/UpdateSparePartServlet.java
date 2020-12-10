package com.seller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.model.SparePart;
import com.seller.service.SparePartsService;


@WebServlet("/UpdateSparePartServlet")
public class UpdateSparePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSparePartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Integer itemId = Integer.parseInt(request.getParameter("sparePartID"));
		String itemname = request.getParameter("name");
		Double itemprice = Double.valueOf(request.getParameter("price"));
		String itemcategory = request.getParameter("category");
		Integer itemquantity = Integer.parseInt(request.getParameter("qty"));
		
		SparePart sp = new SparePart();
		sp.setId(itemId);
		sp.setItemname(itemname);
		sp.setItemprice(itemprice);
		sp.setItemcategory(itemcategory);
		sp.setItemquantity(itemquantity);
		
		SparePartsService.updateSparepart(sp);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewSpareParts.jsp");
		dispatcher.forward(request, response);
		
	}

}
