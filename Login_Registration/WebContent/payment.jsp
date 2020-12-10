<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
   
</head>
<body>
<form action="insert" method="post">
    <div class="body">
    <p><strong>Payment Information</strong></p>

    <p>Credit card accepted: </p>
    <input type="radio" id="visa" name="method" value="visa">
    <label for="visa" style="font-family: Verdana">VISA</label>
    <input type="radio" id="mastercard" name="method" value="mastercard">
    <label for="mastercard" style="font-family: Verdana">MasterCard</label>
    <input type="radio" id="paypal" name="method" value="paypal">
    <label for="visa" style="font-family: Verdana">PayPal</label>
    <input type="radio" id="americanexpress" name="method" value="americanexpress">
    <label for="americanexpress"style="font-family: Verdana">AMERICAN EXPRESS</label><br>


    Card Number: <input type="text" id="cnumber" name="cnumber"><br>
    Expire Date: <input type="text" class="datepicker" id="edate" name="edate"><br>
    CVV: <input type="text" id="cvv" name="cvv"><br>
    Name on card: <input type="text" id="cname" name="cname"><br>
    Country: <input type="text" id="country" name="country"><br>
    Address1: <input type="text" id="add1" name="add1"><br>
    Address2: <input type="text" id="add2" name="add2"><br>
    City: <input type="text" id="city" name="city"><br>
    State postal code: <input type="text" id="add1" name="pcode"><br>
    Contact number: <input type="text" id="add1" name="num"><br>
    Email address: <input type="text" id="add1" name="email"><br>
    <input type ="submit" name="submit" value="submit" class="button2">

    </div>

</form>
</body>
</html>