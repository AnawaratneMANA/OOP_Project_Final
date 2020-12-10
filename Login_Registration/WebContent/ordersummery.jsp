<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import ="module.Cart" %>

<%@ page import ="service.ViewDetailsService" %>
<%@ page import ="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="summery.css">

</head>
<body>
            <%
            String Msg=(String)request.getAttribute("message");
                   if(Msg!=null){			  
            
            %>
            <script type="text/javascript">
            var message="<%=Msg %>";
            alert(message);
            </script>
            
            <%
                   }else{
                	   
                	   
                   }
            
            
            %>

<div class="header">
    <h1>Online vehicle Spare parts management system</h1>
    <img src="images/logo.jpg" alt="logo" height="100" width="100" align="right">
</div>

<div class="topnav" style="background:darkcyan ">
    <a href="#" >Home</a>
    <a href="#">About Us</a>
    <a href="parts.jsp">Parts</a>
    <a href="#">Support</a>
    <a href="#">Contact</a>
    
</div>

<div class="row">
    <div class="leftcolumn">
        <div class="card">
            <p><h1><b>Order Summery</b></h1></p>
            
            <div class="fakeimg">
                <table border="1" height="auto"width="auto">
                    <tr>
                       
                        <th colspan="1">ItemID</th>
                        <th colspan="1">ItemName</th>
                        <th>ItemPrice</th>
                        <th colspan="1">Quantity</th>
                        <th colspan="1">ModelNumber</th>
                        <th colspan="1">ModelName</th>
                        <th colspan="1">ManufactName</th>
                        <th colspan="1">Price</th>
						<th>Quantity in stock</th>
						<th>Edit</th>
						<th>Delete</th>
               		 </tr>
                    
                <%
                	float total=0,uPrice=0;
                	 int qty=0,pid=0,qtyStock=0;
                	 String pname=null,bstyle=null,manuName=null;
               
                	 
                	 
                	 //Display added part list 
                 ArrayList<Cart> list = ViewDetailsService.displayAllPartDetails();
                 
                 if(list.size()> 0)
                 {
                
                	 
                	 for(Cart c:list)
                	 {
                 
                 %>
                    <tr>
					<td><%=c.getPartId() %></td>
					<td><%=c.getpName() %></td>
					<td><%=c.getUnitPrice() %></td>
					<td><%=c.getQty() %></td>
					<td><%=c.getModelNumber() %></td>
					<td><%=c.getBodyStyle() %></td>
					<td><%=c.getManufactName() %></td>
					<td><%=c.getQty()*c.getUnitPrice() %></td>
					<td><%=c.getQtyStock() %></td>
					
					<td>
						<form action="UpdateServlet" method="post">
						 <button class="button" type="submit" action="UpdateCart.jsp">Update</button>
							<input type="hidden" name="id" value=<%=c.getPartId() %>>
						</form>
						
						</td><td>
							<form  action="DeleteServlet" method="post">
							 <button class="button" type="submit" action="  ">Delete</button>
							<input type="hidden" name="id" value=<%=c.getPartId() %>>

						</form>
					
					</td>
					
					
                    </tr>
                    
                   <%
                  	  pid=c.getPartId();
                	  qtyStock=c.getQtyStock();
                	  pname=c.getpName();
                	  bstyle=c.getBodyStyle();
                	  manuName=c.getManufactName();
                   	  uPrice=c.getUnitPrice();
                   	  qty=c.getQty();
                   	  total=total+(uPrice*qty);//calculation for sub total of the cart
                   	  
                   	  
                   	  
                   	  
                   	  %>
                    
                  <%
                 }
                 }
                 %>
                    
                </table>

            </div>
            
         
            
            
            
       

        </div>
        <div class="card" style="font-size: 18px">
        <lable>Total amount: &nbsp;<%=total %></lable><br><br>
        
            <form action="payment.jsp">
               <button class="button" type="submit" >Make payment</button>
               </form>



        </div>
    </div>
    <!--<div class="rightcolumn">
        <div class="card">
            <h2 style="color:darkslateblue  "><strong>Lateset Items</strong></h2>
            <div class="fakeimg" style="...">
                <img src="images/latest1.jpg" alt="latest1" height="150" >
            </div>
            <p><b>Sports Car Toyota tocoma tire 2020 March</b></p>
        </div>
        <div class="card">
            <h3>Popular Items</h3>
            <div class="fakeimg">
                <img src="images/latest2.jpg" alt="popular1" height="200" width="200">
                <p><b>2020 New Luxury PU Leather Car Seat</b></p>
            </div>
            <div class="fakeimg">
                <img src="images/popular2.jpg" alt="popular2" width="200" height="200">
                <p><b>Honda 38cm Carbon Fiber Leather Steering Cover</b></p>
            </div>
            <div class="fakeimg">
                <img src="images/popular4.jpg" alt="popular3" height="200" width="200">
                <p><b>Mercedes-Benz Carbon Fiber Custom Steering wheel </b></p>
            </div>-->
        </div>
        <div class="card">

        </div>
    </div>
</div>

<div class="footer">
    <h2>Footer</h2>
</div>

</body>
</html>