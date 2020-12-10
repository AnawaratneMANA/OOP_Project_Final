<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!doctype html>
    <html>
    <head>
    <meta charset="utf-8">
    <title>index.html</title>
    <link href="CSS/LoginCSS.css" rel="stylesheet" type="text/css">
    <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css">
    <!--Script From Adobe-->
    </head>
    <body>
    <header id="header">
      <h1>Vehicle Spare Parts Management</h1>
    </header>
   
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
   
    <main class="main">
      <div id="main-left">
        <h2>Vehicle Spare Part Database </h2>
       
       	<img src="Photos/unnamed.jpg" width="100%" height="100%" alt=""/>
<p>We Import a large collection of spare parts from all over the world for various models and manufactures, following are some of the major manufactures that we are in partnership with.</p>
<ol>
  <li>Mitsubishi </li>
  <li>Nissan </li>
  <li>Honda </li>
  <li>BMW </li>
  <li>Toyota </li>
  <li>Lexus</li>
</ol>
        <ul>
          <li>Get Used and Brand new component for your vehicle with out service </li>
          <li>Membership offers and discount are now ready for Premium users</li>
          <li>Exrended warrenty periods for 90% parts for purchasing online</li>
          <li>We accept credit/Debit/Paypal</li>
          <li>for OEM parts let us know.</li>
        </ul>
      <p>&nbsp;</p>
      </div>
    <div id="main-right">
      <div class="cta">
        <h3>Login Section</h3>
        <p>Login to the site to access our latest collection of spare parts</p>
    </div>
      <div class="container login-container">
    <div class="row">
      <div class="col-md-10 login-form-2" >
        <h3>Vehicle Spare Parts System Login </h3>
        <form action = "LoginControl" method = "POST">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Your Email *" value="" name ="email"/>
            </div>
          <div class="form-group">
            <input type="password" class="form-control" placeholder="Your Password *" value="" name = "password"/>
            </div>
          <div class="form-group">
            <div class="col text-left">
              <input type="submit" class="btnSubmit" value="Login"  name = "submit"/>
				<p></p>
              </div>
              <div class="col text-left">
              <a href = "reg.jsp"><input type="button" class="btnSubmit" value="Sign Up" /></a>
              </div>
            </div>
          <div class="form-group">
            <a href="reg.html" class="ForgetPwd">Forget Password?</a>
            </div>
          </form>
        </div>
      </div>
  </div>
    </div>
    </main>
    <footer class="footer">
     <!--Add Stuff to the footer-->
    </footer>
    </body>
    </html>