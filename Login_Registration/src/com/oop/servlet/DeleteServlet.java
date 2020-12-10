package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ViewDetailsService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		boolean isTrue;
		isTrue=ViewDetailsService.deleteItem(id);
		
		if(isTrue==true) {
			request.setAttribute("message","Successfully deleted...");
			RequestDispatcher dispatcher=request.getRequestDispatcher("ordersummery.jsp");
			dispatcher.forward(request, response);
			
		}else {
			request.setAttribute("message","Delete failed..try again");
			RequestDispatcher dispatcher=request.getRequestDispatcher("ordersummery.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
