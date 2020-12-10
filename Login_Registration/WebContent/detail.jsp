<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html lang="en">
<head>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
</head>
<body>

<div class="header">
    <h1>Online vehicle Spare parts management system</h1>
    <img src="images/logo.jpg" alt="logo" height="100" width="100" align="right">
</div>

<div class="topnav">
    <a href="#" >Home</a>
    <a href="#">About Us</a>
    <a href="parts.jsp">Parts</a>
    <a href="#">Support</a>
    <a href="#">Contact</a>
</div>

<div class="row">
    <div class="column">
        <h2>Part details</h2>
        <c:forEach var="part" items="${part}">
        <h4>Part ID: &nbsp;&nbsp;&nbsp;${part.partID}</h4>
        <h4>Part Name:&nbsp;&nbsp;&nbsp;${part.partName}</h4>
         <h4>Manufact Name:&nbsp;&nbsp;&nbsp;${part.manufactName}</h4>
         <h4>Body Style:&nbsp;&nbsp;&nbsp;${part.bodyStyle}</h4>
         <h4>Model Number:&nbsp;&nbsp;&nbsp;${part.modelNumber}</h4>
         
        </c:forEach>
    </div>

    <div class="column">
        <c:forEach var="part" items="${part}">
            <h4>Unit Price:&nbsp;&nbsp;&nbsp;${part.unitPrice}</h4>
            <h4>Manufact Year:&nbsp;&nbsp;&nbsp;${part.year}</h4>
            <h4>Description:&nbsp;&nbsp;&nbsp;${part.description}</h4>
            <h4>Quantity in Stock&nbsp;&nbsp;&nbsp;${part.quantityInStock}</h4>
            
         <form method="post"  action="addTocart">
		<input type="hidden" value="${part.partID}" name="itemID">
		Quantity
		<input type="number" name="quantity" required>
		<input type="submit" value="AddToCart" class="button2">
		</form>

        </c:forEach>
    </div>


</div>

</body>
</html>
