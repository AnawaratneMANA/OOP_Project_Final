<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="CSS/MYCSS.css" rel="stylesheet" type="text/css">
<link href="CSS/bootstrap.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/muli:n3:default.js" type="text/javascript"></script>

<!-- Check Box enable/disable Script -->
<script>
//Admin Optional Field enable 
function EnableDisableTextBox(chkPassport) {
    var txtPassportNumber = document.getElementById("txtPassportNumber");
    txtPassportNumber.disabled = chkPassport.checked ? false : true;
    if (!txtPassportNumber.disabled) {
        txtPassportNumber.focus();
    }
}

//Seller Optional Field enable 
function EnableDisableTextBox1(chkPassport1) {
    var txtPassportNumber = document.getElementById("txtPassportNumber1");
    txtPassportNumber.disabled = chkPassport1.checked ? false : true;
    if (!txtPassportNumber1.disabled) {
        txtPassportNumber1.focus();
    }
}

//Buyer Optinal Field enable 
function EnableDisableTextBox3(chkPassport3) {
    var txtPassportNumber = document.getElementById("txtPassportNumber3");
    txtPassportNumber.disabled = chkPassport3.checked ? false : true;
    if (!txtPassportNumber3.disabled) {
        txtPassportNumber3.focus();
    }
}

</script>


</head>

<!-- Main section-->
<body>
<div class="container">
  <div class="header">
 	<h1>Registration form Vehicle Database</h1>
 	
 	  <!-- Navigation Bar-->

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	  <!-- Links -->
  	<ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Selling</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Buying</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">About Us</a>
    </li>
  	</ul>
</nav>
 	
  </div>

  <div class="left"> 
  </div>
  <div class="body">
    <div class="form-control">
     
     <!-- Registration form-->
      <form action = "UserControl" method = "POST">
        <br><br>
        <h4>Registration Form Vehicle Database</h4>
        <hr>
        <h5>General</h5>
        <font class="align-baseline">Username :</font>
        <input type="text" class="form-control" name = "username">
        <font class="align-baseline">Full name :</font>
        <input type="text" class="form-control" name = "fullname">
        <font class="align-baseline">Email :</font>
        <input type="email" class="form-control" name ="email">
        <font class="align-baseline">NIC :</font>
        <input type="text" class="form-control" name = "nic">
        <font class="align-baseline">Phone Number :</font>
        <input type="phone" class="form-control" name = "phone"> <br>
        <input type="date" name = "date">
        <font class="align-baseline">Date of Birth  :</font><br><br>
      <input type="checkbox" name = "type" value = "P">
      <font class="align-baseline">Create Account as a Premium user</font>
      <br>
      <input type="checkbox" name = "type" value = "S">
      <font class="align-baseline">Create Account as a Standard user</font>
      
	<br>
      <hr>

       <h5>Passwords</h5>
       
        
        
        <font class="align-baseline">Create Passwords :</font>
        <input type="text" class="form-control" name = "password">
        <font class="align-baseline">Confirm Passwords :</font>
        <input type="text" class="form-control" name = "cpassword">
 
<hr>

        <h5>Human Verification</h5>
        <table width="50%" border="0">
  <tbody>
    <tr>
      <td rowspan="2"><img src="Photos/captcha.jpg" width="116" height="50" alt=""/></td>
      <td>   <font class="align-content-md-start">Enter the given numbers</font></td>
    </tr>
    <tr>
      <td><input type="text" class="form-control" name = "human"></td>
    </tr>
  </tbody>
</table>

<hr>
<h5>Optional Details</h5>
<font>Select only one user type</font> <br><br>

<!-- Admin Optional -->
 <label for="chkPassport">
    <input type="checkbox" id="chkPassport" onclick="EnableDisableTextBox(this)" name = "utype" value = "A" />
    Admin?
</label>
<br />
Description:
<input type="text" id="txtPassportNumber" disabled="disabled" name = "descrip"/>
<br><br>
<!-- Seller Optional -->
 <label for="chkPassport1">
    <input type="checkbox" id="chkPassport1" onclick="EnableDisableTextBox1(this)" name = "utype" value = "S" />
    Seller?
</label>
<br />
Comnany name :
<input type="text" id="txtPassportNumber1" disabled="disabled" name = "company"/>
<br><br>
<!-- Buyer Optional -->
 <label for="chkPassport3">
    <input type="checkbox" id="chkPassport3" onclick="EnableDisableTextBox3(this)" name = "utype" value = "B" />
    Buyer?
</label>
<br />
Credit Card Number:
<input type="text" id="txtPassportNumber3" disabled="disabled" name = "card"/><br><br>


<input type="submit" class="btn-success" value  = "Submit"><br><br>


      </form>
    </div>
  </div>
  <div class="footer">
  	
  	<!-- Footer-->
  	<p style="color: aliceblue">Add infomation to the footer</p>
  </div>
  
</div>
</body>
</html>
