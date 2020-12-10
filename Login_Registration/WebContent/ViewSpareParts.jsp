<%@page import="com.seller.service.SparePartsService"%>
<%@page import="com.seller.model.SparePart"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container">
	<div class = "row">
		<div class = "col-md-4">
			<h3>Item List</h3>
		</div>
		<div class = "col-md-4">
		<br>
		<form action="" method="get">
			<input type="text" class="form-control" name="searchWord" placeholder="Search here....."/>
		</form>
		
		</div>
		<br><br>
		<div class ="col-md-4 text-right">
			<a href="AddSparePart.jsp">
		<button type="button" class="btn btn-success">Back</button>
		</a>
		</div>
		</div>
		<table class = "table table-hover">
		<thead>
		<tr>
			<th>Item id</th>
			<th>Item Name</th>
			<th>Item price</th>
			<th>Item category</th>
			<th>Item quantity</th>
			<th>Actions</th>
		</tr>
		</thead>
		<tbody>
		<%
			ArrayList<SparePart> arrayList;
			
			String searchKeyword = request.getParameter("searchWord");
			if(searchKeyword == null) {
				arrayList = SparePartsService.getSpareParts();
			} else {
				arrayList = SparePartsService.searchSpareParts(searchKeyword);
			}
			
			for(SparePart sparePart : arrayList){
			%>
			 <tr>
				<td> <%=sparePart.getId() %> </td>
				<td> <%=sparePart.getItemname() %> </td>
				<td> <%=sparePart.getItemprice() %> </td>
				<td> <%=sparePart.getItemcategory() %> </td>
				<td> <%=sparePart.getItemquantity() %> </td>
				<td>
					<form method="POST" action="DeleteSparePartServlet">
						<input type="hidden" name="sparePartID" value="<%=sparePart.getId() %>" /> 
						<input type="submit" value="Delete" class="btn btn-danger"/>
					</form>
				</td>
				<td>
					<form method="POST" action="GetSparePartServlet">
						<input type="hidden" name="sparePartID" value="<%=sparePart.getId() %>" /> 
						<input type="hidden" name="sparePartName" value="<%=sparePart.getItemname() %>" /> 
						<input type="hidden" name="sparePartPrice" value="<%=sparePart.getItemprice() %>" /> 
						<input type="hidden" name="sparePartCategory" value="<%=sparePart.getItemcategory() %>" /> 
						<input type="hidden" name="sparePartQuantity" value="<%=sparePart.getItemquantity() %>" /> 
						
						<input type="submit" value="Update" class="btn btn-warning"/>
					</form>
				</td>
			</tr>			
			<%	
			   }
            %>
		</tbody>
		</table>
	</div>
</body>
</html>