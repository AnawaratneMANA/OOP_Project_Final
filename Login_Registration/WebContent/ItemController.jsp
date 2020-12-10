<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="oop.model.Item"%>
 
 <%ArrayList array = (ArrayList)request.getAttribute("Items"); %>
 
<!DOCTYPE html>
<html>
<head>
<style>
table {
  border: 1px solid black;
}

tr,td {
  padding: 10px;
}

</style>
<meta charset="ISO-8859-1">
<title>System Item controller</title>
</head>
<body>


<table border="1">
<tr>
<th>Item ID</th>
<th>Item Name</th>
<th>Manufacturer</th>
<th>Pbody</th>
<th>Model No</th>
<th>Unit Price Rs.</th>
<th>Year</th>
<th>Available Stock</th>
<th>Description</th>
<th>Delete</th>
</tr>
<% for (int i = 0 ; i < array.size(); i++ ){ %>
<tr>
<% Item item = (Item)array.get(i) ;%>
<td><%= item.getPartID() %></td>
<td><%= item.getPartName() %></td>
<td><%= item.getManufactName() %></td>
<td><%= item.getBodyStyle() %></td>
<td><%= item.getModelNumber() %></td>
<td><%= item.getUnitPrice() %></td>
<td><%= item.getYear() %></td>
<td><%= item.getQuantityInStock() %></td>
<td><%= item.getDescription() %></td>
<td>
<form action="DeleteItem" method="post">
<input type="hidden" name="id" value="<%= item.getPartName() %>" >
<input type="Submit" value="Submit">
</form>

</td>
</tr>
<%} %>
</table>

<br><br>
<br><br>
<h4>Update System Items</h4>
<form action="UpdateSystemItems" method="post">
	<table>
	<tr><td>Item ID :</td><td><input type="text" name="IID" ></td></tr>
	<tr><td>Item Name :</td><td><input type="text" name="INAME" ></td></tr>
	<tr><td>Manufacture Name :</td><td><input type="text" name="IMANU"></td></tr>
	<tr><td>Pbody :</td><td><input type="text" name="IPB"></td></tr>
	<tr><td>Model Number :</td><td><input type="text" name="IMN"></td></tr>
	<tr><td>Unit price :</td><td><input type="text" name="IUP"></td></tr>
	<tr><td>Year :</td><td><input type="text" name="IY"></td></tr>
	<tr><td>Quantity :</td><td><input type="text" name="IQ"></td></tr>
	<tr><td>Description :</td><td><input type="text" name="IDES"></td></tr>
	<tr><td></td><td><input type="submit" value="Submit" name="SUBMIT"></td></tr>
	</table>
</form>






</body>
</html>