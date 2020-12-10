package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ViewDetailsService;

//@WebServlet("/UpdateServlet1")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pid=Integer.parseInt(request.getParameter("id"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		
		boolean check;
		check=ViewDetailsService.checkQuantity(pid, qty);

		if(check==true) 
		{
		
			boolean isTrue;
			isTrue=ViewDetailsService.updateCart(pid, qty);
		
			if(isTrue==true) {
				RequestDispatcher dis=request.getRequestDispatcher("ordersummery.jsp");
				dis.forward(request, response);
			}
			else 
			{
				RequestDispatcher dis=request.getRequestDispatcher("UpdateCart.jsp");
				dis.forward(request, response);
			
			}
		}
		else
		{
			
		
			
			request.setAttribute("message","Update failed..Enter an valid quantity value");
			RequestDispatcher dispatcher=request.getRequestDispatcher("ordersummery.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
