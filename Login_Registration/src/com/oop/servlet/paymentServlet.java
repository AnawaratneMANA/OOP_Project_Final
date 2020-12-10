package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PaymentService;



//@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type=request.getParameter("method");
		int cnum=Integer.parseInt(request.getParameter("cnumber"));
        String  exdt=request.getParameter("edate");
         int cvv=Integer.parseInt(request.getParameter("cvv"));
         String name=request.getParameter("cname");
         String country =request.getParameter("country");
         String add1=request.getParameter("add1");
         String add2=request.getParameter("add2");
         String city=request.getParameter("city");
         int pcode=Integer.parseInt(request.getParameter("pcode"));
         String pnum=request.getParameter("num");
         String email=request.getParameter("email");
         
         boolean IsTrue;
		
      IsTrue  = PaymentService.insertPayment(type, cnum, exdt, cvv, name, country, add1, add2, city, pcode, pnum, email);
         
      if(IsTrue==true) {
    	  
    	  RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
    	  dis.forward(request, response);
      }else {
    	  RequestDispatcher dis2=request.getRequestDispatcher("unsuccess.jsp");
    	  dis2.forward(request, response);
      }
      
    
	}

}
