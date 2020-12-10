package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.Cart;
import module.Part;
import service.ViewDetailsService;

/**
 * Servlet implementation class AddtoCartServlet
 */
//@WebServlet("/AddtoCartServlet")
public class AddtoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = null,manuName = null,bStyle = null;
		float uprice = 0;
		int modelNo = 0,stockQuantity = 0;
		
		int pid=Integer.parseInt(request.getParameter("itemID"));
		int qty=Integer.parseInt(request.getParameter("quantity"));
		
		
		boolean result = ViewDetailsService.checkQuantity(pid,qty);
		
		if(result == true)
		{
		
		List<Part> li = ViewDetailsService.displayPartDetails(pid);
		
			if(li.size() > 0)
			{
				for(Part p : li)
				{
					name = p.getPartName();
					manuName = p.getManufactName();
					bStyle = p.getBodyStyle();
					uprice = p.getUnitPrice();
					modelNo = p.getModelNumber();
					stockQuantity = p.getQuantityInStock();
				}
		
		
				Cart c = new Cart(pid,uprice,qty,name,manuName,bStyle,modelNo,stockQuantity);
				
				boolean rs = ViewDetailsService.AddToCart(c);
				
				if(rs = true)
				{
				RequestDispatcher rd = request.getRequestDispatcher("ordersummery.jsp");
				rd.forward(request, response);
				}
				else
				{
					List<Part> part=ViewDetailsService.displayPartDetails(pid);
					request.setAttribute("part", part);
					RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
					rd.forward(request, response);
					
				}
		
			}
		
		}	
		
		else 
		{
			List<Part> part=ViewDetailsService.displayPartDetails(pid);
			request.setAttribute("part", part);
			RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			rd.forward(request, response);
			
		}
		

		
		
		
		
		
	}

}
