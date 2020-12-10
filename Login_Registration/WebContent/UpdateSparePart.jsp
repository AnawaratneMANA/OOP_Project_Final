<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.seller.service.SparePartsService"%>
<%@page import="com.seller.model.SparePart"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<!-- - -<link href="css/style.css" rel="stylesheet" type="text/css"/>--->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  	
</head>
<body>
	
	<div class="container">
		<div class = "page-header">
			<h1>Update Inventory By Seller</h1>
		</div>
		
		<div class="row">
		<div class="col-75">
				<%
					SparePart sparePart = (SparePart) request.getAttribute("sparePart");
				%>
				<form  action="UpdateSparePartServlet" method="post">
				  <div class="form-group">
				    <label for="name" class="fas fa-bars"> Item Name:</label>
				    <input type="text" class="form-control" id="name" name="name" value="<%=sparePart.getItemname()%>" />
				  </div>
				  
				  <div class="form-group">
				    <label for="email" class="fas fa-bars"> Item Price:</label>
				    <input type="text" class="form-control" id="price" name="price"  value="<%=sparePart.getItemprice()%>" />
				  </div>
				  
				  <div class="form-group">
				    <label for="pwd" class= "fas fa-bars"> Item Category:</label>
				    <input type="text" class="form-control" id="category" name="category"  value="<%=sparePart.getItemcategory()%>" />
				  </div>
				  
				   <div class="form-group">
				    <label for="quantity" class = "fas fa-bars"> Item Quantity:</label>
				    <input type="text" class="form-control" id="qty" name="qty"  value="<%=sparePart.getItemquantity()%>" />
				  </div>
				  
				  <input type="hidden" name="sparePartID" value="<%=sparePart.getId() %>" />
				  <button type="submit" class="btn">Update Item</button>
				</form>
			</div>
			
		</div>	
	</div>
</body>
</html>