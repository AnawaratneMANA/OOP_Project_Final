package com.seller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.service.SparePartsService;

/**
 * Servlet implementation class DeleteSparePartServlet
 */
@WebServlet("/DeleteSparePartServlet")
public class DeleteSparePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sparePartID = request.getParameter("sparePartID");
		
		SparePartsService.deletSparePart(Integer.parseInt(sparePartID));
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewSpareParts.jsp");
		dispatcher.forward(request, response);
	}

}
