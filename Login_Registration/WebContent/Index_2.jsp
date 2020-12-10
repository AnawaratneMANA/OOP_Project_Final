<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table, tr, td {
  border: 1px solid black;
}

tr,td {
  padding: 10px;
}
</style>
<title>Admin panel</title>
</head>
<body>
<h3>User Controller</h3>



<h4>Search User By UserName</h4>
<form action="GetUser" method="post">
<input type="text" name="UN">
<input type="submit" value="Search User">
</form>


<h4>Get all users</h4>
<form action="AllUsers" method="post">
<input type="submit" name="submit" value="Show Seller data">
</form>


<br><br><br><br>
<h3>Item Controller</h3>

<h4>Alter System Items</h4>
<form action="GetSysItems" method="post">
<input type="submit" name="submit" value="get data">
</form>

<h4>Seller Notification</h4>
<form action="GetSellerItems" method="post">
<input type="submit" name="submit" value="Show Seller data">
</form>


</body>
</html>