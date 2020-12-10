<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link href="CSS/bootstrap.css" rel="stylesheet" type="text/css">
<link href="CSS/MYCSS.css" rel="stylesheet" type="text/css">
</head>
<%@page import="com.oop.service.IUserService"%>
<%@page import="com.oop.service.UserServiceImpl"%>
<%@page import="com.oop.model.MainUser"%>

<body>
<%
	//Creating and calling Service Objects
 String username = (String)request.getSession().getAttribute("username"); 

IUserService log = new UserServiceImpl();  
MainUser U = log.selectInfo(username);
%>
<div class="container">
	<div class = "header">
		<h2> Profile Information Summary </h2>
	</div>

<div class="body_sp">

<table class="table">
 <form action = "UpdateControl" method = "POST" class = "form-control">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Field</th>
      <th scope="col">Information</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">User Name</th>
      <td><%=username %></td>
      <input type ="hidden" name = "id" value = "<%=username %>">
    </tr>
    <tr>
      <th scope="row">Full Name</th>
      <td><input type ="text" name = "name" class="form-control"></td>
      
    </tr>
    <tr>
      <th scope="row">Email</th>
      <td><input type ="text" name = "email" class="form-control"></td>
    </tr>
    <tr>
      <th scope="row">NIC</th>
      <td><input type ="text" name = "nic" class="form-control"></td>
    </tr>
    <tr>
      <th scope="row">Phone Number</th>
      <td><input type ="text" name = "phonenumber" class="form-control"></td>
    </tr>
    <tr>
      <th scope="row">Date of Birth</th>
      <td><input type ="text" name = "dob" class="form-control"></td>
    </tr>
  </tbody>
</table>
<br>
<input type="submit" class="btn-success" value="Update" />
</form>

</div>
</div>	
</body>
</html>