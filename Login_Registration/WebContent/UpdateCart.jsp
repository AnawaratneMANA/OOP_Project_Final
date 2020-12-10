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
<style>

* {
    box-sizing: border-box;
}

body {
    font-family: Verdana;
    padding: 10px;
    background-color: #f1f1f1;
}

/* Header/Blog Title */
.header {
    padding: 30px;
    text-align: center;
    background-color:#7581a3;

}

.header h1 {
    font-size: 50px;
}

/* Style the top navigation bar */
.topnav {
    overflow: hidden;
    background-color: darkseagreen;
}

/* Style the topnav links */
.topnav a {
    float: left;
    display: block;
    background:darkcyan;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
    background-color:darkseagreen;
    color: black;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
    float: left;
    width: 100%;
}

/* Right column */
.rightcolumn {
    float: left;
    width: 25%;
    background-color: #f1f1f1;
    padding-left: 20px;
}

/* Fake image */
.fakeimg {
    background: #a0c4b0;
    width: 100%;
    padding: 20px;
}

/* Add a card effect for articles */
.card {
    font-family: Verdana;
    font-size: 18px;
    background-color:#619c9e;
    padding:20px;
    margin-top: 20px;
}
.button{
    border-radius: 12px;
    font-size: 18px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Footer */
.footer {
    padding: 20px;
    text-align: center;
    background: #ddd;
    margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
    .leftcolumn, .rightcolumn {
        width: 100%;
        padding: 0;
    }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
    .topnav a {
        float: none;
        width: 100%;
    }
}



</style>
</head>
<body>

<div class="header">
    <h1>Online vehicle Spare parts management system</h1>
    <img src="images/logo.jpg" alt="logo" height="100" width="100" align="right">
</div>

<div class="topnav" style="background:darkcyan ">
    <a href="#" >Home</a>
    <a href="#">About Us</a>
    <a href="#">Parts</a>
    <a href="#">Support</a>
    <a href="#">Contact</a>
    
</div>

<div class="row">
    <div class="leftcolumn">
        <div class="card">
            <p><h1><b>Update My Cart</b></h1></p>
            
            <div class="fakeimg" style="height:200px;">
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
                    </tr>
                    
                    
                  
                 <%
                 int id = (Integer)request.getAttribute("id");
                 
                 ArrayList<Cart> list = ViewDetailsService.displayForUpdate(id);
               
              
                 
                 
                 if(list.size()> 0)
                 {
                
                	 
                	 for(Cart c:list)
                	 {
                 
                 %>
                    <tr>
					<td><%=c.getPartId() %></td>
					<td><%=c.getpName() %></td>
					<td><%=c.getUnitPrice() %></td>
					
					
					<td>
					<form action="UpdateServlet1" method="post">
					<input type= "hidden" name="id" value="<%=c.getPartId()%>">
					<input type="number" value="<%=c.getQty() %>"  name="qty" required>
					<input type="submit" value="updateQuantity">
				
					</form>
					</td>
					
					<td><%=c.getModelNumber() %></td>
					<td><%=c.getBodyStyle() %></td>
					<td><%=c.getManufactName() %></td>
					<td><%=c.getQty()*c.getUnitPrice() %></td>
					<td><%=c.getQtyStock() %></td>
					
                    </tr>
                    
                  <%
                 }
                 }
                  %>  
                </table>
			
            </div>
         
                    
                    <!--  <br><br> <br><label for="total">Cart SubTotal: </label>-->

            </form>

        </div>
        <div class="card" style="font-size: 18px">
           
      


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