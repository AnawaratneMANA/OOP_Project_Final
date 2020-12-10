package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import module.Part;
import service.ViewDetailsService;

@WebServlet("/PartDetailsServlet")
public class PartDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PartDetailsServlet() {
        super();

    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int pID = Integer.parseInt(request.getParameter("itemID"));

		ViewDetailsService.displayPartDetails(pID);   // call method to display user selected part details
		
		List<Part> part=ViewDetailsService.displayPartDetails(pID);
		request.setAttribute("part", part);
	
	}catch(Exception e) {
		
		e.printStackTrace();
	
	}
	
		RequestDispatcher dis =request.getRequestDispatcher("detail.jsp");
		dis.forward(request, response);

		
	}

}
