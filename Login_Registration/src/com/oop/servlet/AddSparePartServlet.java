package com.seller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.ItemDBUtil;
import com.item.item;
import com.seller.service.SparePartsService;

/**
 * Servlet implementation class AddSparePartServlet
 */
@WebServlet("/AddSparePartServlet")
public class AddSparePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemname = request.getParameter("name");
		Double itemprice = Double.valueOf(request.getParameter("price"));
		String itemcategory = request.getParameter("category");
		Integer itemquantity = Integer.parseInt(request.getParameter("qty"));
		
		 boolean isTrue = SparePartsService.insertSparePart(itemname, itemprice, itemcategory, itemquantity);
		
		//nevigate another page
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ViewSpareParts.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
