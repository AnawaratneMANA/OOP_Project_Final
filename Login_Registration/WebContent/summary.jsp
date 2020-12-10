<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.oop.service.IUserService"%>
<%@page import="com.oop.service.UserServiceImpl"%>
<%@page import="com.oop.model.MainUser"%>

<!DOCTYPE html>
<html>
<head>
<link href="CSS/bootstrap.css" rel="stylesheet" type="text/css">
<link href="CSS/MYCSS.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Summary</title>
</head>
<body>
<% 
//Creating and calling Service Objects
 String username = (String)//Creating and calling Service Objects
 String username = (String)request.getSession().getAttribute("username"); 

IUserService log = new UserServiceImpl();  
MainUser U = log.selectInfo(username);nformation Summary </h2>
	</div>

<div class="body_sp">

<table class="table">
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
      
    </tr>
    <tr>
      <th scope="row">Full Name</th>
      <td><%=U.getFullname() %></td>
      
    </tr>
    <tr>
      <th scope="row">Email</th>
      <td><%=U.getEmail() %></td>
    </tr>
    <tr>
      <th scope="row">NIC</th>
      <td><%=U.getNic() %></td>
    </tr>
    <tr>
      <th scope="row">Phone Number</th>
      <td><%=U.getPhonenumber() %></td>
    </tr>
    <tr>
      <th scope="row">Date of Birth</th>
      <td><%=U.getDateofbirth() %></td>
    </tr>
    <tr>
      <th scope="row">Type</th>
      <td><%=U.getType() %></td>
    </tr>
  </tbody>
</table>
<br>
<a href = "updateform.jsp"><input type="button" class="btn-success" value="Update" /></a>

<form action = "DeleteControl" method = "POST">
<input type="hidden" name="username" value = "<%=username %>"> <!-- assign the value-->
<br>
<a href = "#"><input type="submit" class="btn-danger" value="Delete" /></a>
</form>
<br>
<a href = "#"><input type="button" class="btn-danger" value="Confirm -> Profile Page" /></a>
</div>
</div>		
<table>

<tr>

	<td> <%=U.getEmail() %></td>
	
</tr>

</table>
		
</body>
</html>