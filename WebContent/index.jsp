<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title> 4C Knowledge</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"> </script>
  <script src="js/bootstrap.min.js"> </script>
  <link href="css/navStyles.css" rel="stylesheet" type="text/css">

<style type="text/css">
	
	
	
	
	
	#logo{
		font-size: 40px;
		
	}
	 #regForm{
		/*
		margin-top:0% ;
		margin-left:55% ;*/
		position:relative;
	}
	
	#loginForm{
	
	/*	margin-top:-30px;
		margin-left:40%;
		position:initial;*/
		color:#fff;	
	}
	
	#regForm{
		width:480px;
		background-color: rgba(255, 255, 255, 0.61);
		border-radius: 8px;
		padding: 10px 40px 40px 40px;
	}
  
	#regForm h2{
		text-align:center;
		margin:15px 0px;
	}

	/*body{
		background:url('img/background.jpg');
		background-repeat:no-repeat;
		background-size:100%;
	}*/

    body { 
  background: url('images/background.jpg') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

	
	#heading{
		text-align:center;
		color:#fff;
	}
	
	
	table, th, td {
    border: 0px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 3px;
}

#mainTable
	table, th, td {
	 
    border: 0px solid black;
    border-collapse: collapse;
    
}
#mainTable  {
	padding: 0px;
    width: 10%;
    margin-top:0% ;
    margin-left:60% ;
    position:relative; 
    
}
</style>




</head>


<body>

<div class="navbar-brand" >
	
 <a id="logo" href="index.jsp" style=" text-decoration:none; color:white ;'" >
		  <img src="images/4C Knowledge-logo-200x200.png" width="100" height="80" style="padding: 5px;" alt=""/>4CKnowledge</a>
</div>
<table id="mainTable">
<tr>
<td>
<header class="row">


<div  id="loginForm" class="container col-sm-6">

  <form class="form-inline" action="loginServlet" method="post">
    <table align="left" >
    <tr>
    <td>
   <label for="email">Email:</label>
      </td>
      <td>
        <label for="pwd">Password:</label>
       </td>
     </tr>
     <tr>
     <td>
      <input type="email" class="form-control" id="Email" placeholder="Enter email" name="Email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
    </td>
    
  	<td>
    
    
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
  
    </td>
    <td>
    <div class="form-group">
    <button type="submit" class="btn btn-default">Login</button>
	 </div>
	 </td></tr>
	 <tr><td colspan=2>
    <div class="form-group">
      <label>  <a href="forget_password.jsp"  style="color:black;">Forgot Password? </a></label>
	 
    </div>
    </td>
    </tr>
    </table>
  </form>
</div>
</header>
</td>
</tr>

<tr>
<td>

<section id = "main" class="row">
<div class="container col-sm-7">

</div>

<table align=center >
    <tr>
    <td>
<div id="regForm" class="container col-sm-5">
  <h2>Member Registration</h2>
  
    
  <form action="registerServlet" method="post">
  
   
    <div class="form-group">
      <label for="memName">First Name:</label>
      <input type="text" class="form-control" id="memName" placeholder="Enter Member Name" name="Fnname" pattern="[A-Za-z ]{1,40}" required  title="Member Name should only contain letters. e.g. Saman" >
    </div>
    
    <div class="form-group">
      <label for="memName">Last Name:</label>
      <input type="text" class="form-control" id="memName" placeholder="Enter Member Name" name="Lname" pattern="[A-Za-z ]{1,40}" required  title="Member Name should only contain letters. e.g. Saman" >
    </div>
    

     <div class="form-group">
    <label for="Email">Email address:</label> 
    <input type="text" class="form-control" id="Email" placeholder="Enter Email Address" name="Email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"  required> 
	</div>
      <div class="form-group">
      <label for="shopName">Current Address:</label>
      <input type="text" class="form-control" id="CAddress" placeholder="Enter Current Address" name="CAddress"   required  title="Text and numbers" >
    </div>

    
    <div class="form-group">
      <label for="memMob">Mobile :</label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter Mobile Number" name="mobile" pattern="[0-9-+]{10,10}" title="Mobile Number should contain only 10 numbers" required >

    </div>

 <div class="form-group">
      <label for="memHome">Home Tel :</label>
      <input type="text" class="form-control" id="Hometel" placeholder="Enter Home Telephone Number" name="Hometel" pattern="[0-9-+]{10,10}" title="Home Telephone Number should contain only 10 numbers" required >

    </div>
     <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"  required >

    </div>
    
       <div class="form-group">
      <label for="password">Confirm Password:</label>
      <input type="password" class="form-control" id="Cpassword" placeholder="Confirm Password" name="Cpassword"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"  required >

    </div>
	
    <div class="form-group">
      <label for="dob">Date of Birth:</label>
      <input type="date" class="form-control" id="dob" name="dob" required >
    </div>

    <button type="submit" class="btn btn-default">Become a Member!</button>
     
  </form>
  
  
</div>
</td>
    </tr>
    </table>

</section>

</td>
</tr>
</table>
</body>
</html>
