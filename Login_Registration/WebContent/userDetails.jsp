<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="oop.model.User"%>
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
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
<th>User ID</th>
<th>UserName</th>
<th>Full name</th>
<th>Email Address</th>
<th>NIC No</th>
<th>Phone No</th>
<th>Date of Birth</th>
<th>User Type</th>
<th>Delete User</th>
</tr>

<tr>
<% for (int i = 0 ; i < array.size(); i++ ){ %>
<% User u = (User)array.get(i) ;%>
<td><%= u.getId() %></td>
<td><%= u.getUname() %></td>
<td><%= u.getFullname() %></td>
<td><%= u.getEmail() %></td>
<td><%= u.getNic() %></td>
<td><%= u.getPhonenumber() %></td>
<td><%= u.getDateofbirth() %></td>
<td><%= u.getType() %></td>
<td>
<form action="RemoveUser" method="post">
<input type="hidden" name="VAL" value="<%=u.getUname()%>">
<input type="submit" value="Delete">
</form>

</td>
</tr>
<%} %>
</table>

<br><br>

<h4>Upgrade to admin</h4>
<form action="CreateAdmin" method="post">
User Name: 
<input type="text" name="UID">
Description :  
<input type="text" name="DES">

<input type="submit" value="Submit">
</form>


</body>
</html>