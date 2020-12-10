<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="oop.model.SellerItem"%>
 
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
<title>Seller Notification</title>
</head>
<body>

<h2>Seller Notification</h2>
<h4>Items That Seller needs to Add to System</h4>
<table border="1">
<tr>
<th>Item ID</th>
<th>Item Name</th>
<th>Unit Price Rs.</th>
<th>Category</th>
<th>Available Stock</th>
<th>Delete</th>
</tr>
<% for (int i = 0 ; i < array.size(); i++ ){ %>
<tr>
<% SellerItem item = (SellerItem)array.get(i) ;%>
<td><%= item.getId() %></td>
<td><%= item.getItemname() %></td>
<td><%= item.getItemprice() %></td>
<td><%= item.getItemcategory() %></td>
<td><%= item.getItemquantity() %></td>
<td>
<form action="DeleteSellerItems" method="post">
<input type="hidden" name="id" value="<%=item.getItemname()%>">
<input type="Submit" value="Delete">
</form>
</td>

</tr>
<%} %>
</table>

<br>
<br>

<h4>Add Items To System DB</h4>
	<form action="AddItemToSystem" method="post">
	<table>
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
<br>
<br>



<hr/>
</body>
</html>
