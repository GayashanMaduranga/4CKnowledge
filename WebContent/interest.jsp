
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title> </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap2.css">
  <script src="js/jquery-3.2.1.min.js"> </script>
  <script src="js/bootstrap-4.0.0.js"> </script>
    <script src="js/popper.min.js"> </script>

 


<style type="text/css">
	
	#regForm{	
		
		position: absolute;
    top:100px;
   
    left: 0;
    right: 0;

  
	
	 
		 
		 
		
		
			
		  
		width:600px;
		
		background-color: rgba(255, 255, 255, 0.61);
		border-radius: 8px;
		padding: 10px 40px 40px 40px;
	}
	#regForm h2{
		text-align:center;
		margin:15px 0px;
	}

	

    body { 
 background-color: #005670  ; 
  
}
	
	
	/* The container */
.container {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}

/* Create a custom checkbox */
.checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
    display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}
	
	
	 
	#heading{
		text-align:center;
		color:#fff;
	}
	h2{
	
	padding-bottom:20px;
	}
	
</style>
  
</head>
<body>
<section id = "main"  class="row">
  <div class="container col-sm-7"> </div>
<div id="regForm"  class="container col-sm-5">


 
  <form action="InterestServlet" method="post">
   
    <div class="form-group">
	 <h2>Select your interests</h2>

<table border=0 width="100%" height="100% align="center">
<tr>
<td><label class="container">Artificial Intelligence
  <input type="checkbox" name="interest" VALUE=1 >
  <span class="checkmark"></span>
</label>
</td>
 
<td> <label class="container">Si-Fi
  <input type="checkbox"  name="interest"  VALUE=2 >
  <span class="checkmark"></span>
</label>
</td>
 
</tr>

<tr>
<td><label class="container">Image Processing
  <input type="checkbox"  name="interest" VALUE=3  >
  <span class="checkmark"></span>
</label>
</td>
 
<td> <label class="container">Politics
  <input type="checkbox"   name="interest" VALUE=4 >
  <span class="checkmark"></span>
</label>
</td>

</tr>

<tr>
<td><label class="container">Middleware
  <input type="checkbox"  name="interest" VALUE=5 >
  <span class="checkmark" ></span>
</label>
</td>

 
<td> <label class="container">Religion
  <input type="checkbox"  name="interest" VALUE=6  >
  <span class="checkmark"></span>
</label>
</td>
 
</tr>
</table>
 


    <button type="submit" class="btn btn-default">Continue</button>
	</div>
  </form>
</div>
</section>

</body>
</html>
