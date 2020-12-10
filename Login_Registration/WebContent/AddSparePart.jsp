<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.seller.service.SparePartsService"%>
<%@page import="com.seller.model.SparePart"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	
</head>
<body>
	<div class="container">
		<div class = "page-header">
			<h1>Product Inventory By Seller</h1>
		</div>
		<div class="row">
			<div class="col-md-7">
				<form  action="AddSparePartServlet" method="post">
				  <div class="form-group">
				    <label for="name">Item Name:</label>
				    <input type="text" class="form-control" id="name" name="name">
				  </div>
				  
				  <div class="form-group">
				    <label for="email">Item Price:</label>
				    <input type="text" class="form-control" id="price" name="price">
				  </div>
				  
				  <div class="form-group">
				    <label for="pwd">Item Category:</label>
				    <input type="text" class="form-control" id="category" name="category">
				  </div>
				  
				   <div class="form-group">
				    <label for="quantity">Item Quantity:</label>
				    <input type="text" class="form-control" id="qty" name="qty">
				  </div>
				  
				  <button type="submit" class="btn">+ADD Item</button>
				  <button type="reset" class="btn1" value="Reset">Reset</button>
				</form>
			<!-- - -<div class="col-md-7">--->
			
				<br/><br/>
				<%
				SparePartsService sparePart = new SparePartsService();
				//SparePart sparePart = (SparePart) request.getAttribute("sparePart");
				System.out.println(sparePart.getOutOfProduct());
				%>	
				<ul class="list-group">
				  	<li class="list-group-item d-flex justify-content-between align-items-center">
				    	Total Products
				    	<span class="badge badge-primary badge-pill"><%=sparePart.getTotalProducts()%></span>
				  	</li>
				  	<li class="list-group-item d-flex justify-content-between align-items-center">
				   		Out of Stocks
				    	<span class="badge badge-primary badge-pill"><%=sparePart.getOutOfProduct()%></span>
				  	</li>
				  	<li class="list-group-item d-flex justify-content-between align-items-center">
				    	Total Items
				    <span class="badge badge-primary badge-pill"><%=sparePart.getTotalItems()%></span>
				  	</li>
				  	<li class="list-group-item d-flex justify-content-between align-items-center">
				    	Categories
				    <span class="badge badge-primary badge-pill"><%=sparePart.getCategories()%></span>
				  	</li>
				  	<br>
				  	 </ul>
				  
				  	 
            		
				  	 <a href =ViewSpareParts.jsp>
				  	 <button type="submit" class="btn btn-primary" >Manage</button>
				  	 </a>
			</div>
	</div>
	</div>
	</div>
</body>
</html>			