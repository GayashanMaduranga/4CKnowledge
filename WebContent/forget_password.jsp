<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title> 4C Knowledge</title>

  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"> </script>
  <script src="js/bootstrap.min.js"> </script>
  
 


<style type="text/css">
	
	#forgetpassword{	
		
		position: absolute;
    top:100px;
   
    left: 0;
    right: 0;

  
	
	 
		 
		 
		
		
			
		  
		width:500px;
		background-color: rgba(255, 255, 255, 0.61);
		border-radius: 8px;
		padding: 10px 40px 40px 40px;
	}
	#forgetpassword h2{
		text-align:center;
		margin:15px 0px;
	}

	/*body{
		background:url('img/background.jpg');
		background-repeat:no-repeat;
		background-size:100%;
	}*/

    body { 
 background-color: #005670  ; 
  
}

	
	
	#heading{
		text-align:center;
		color:#fff;
	}
</style>
  
</head>
<body>
<section id = "main"  class="row">
  <div class="container col-sm-7"> </div>
<div id="forgetpassword"  class="container col-sm-5">


  <h2>Enter Your Email Address</h2>
  <form action="forgetPwd" method="post">
   
    

     <div class="form-group">
    <label for="Email">Email address:</label> 
    <input type="email" class="form-control" id="Email" placeholder="Enter Email Address" name="Email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"  required> 
      

    
   
	
   

    <button type="submit" class="btn btn-default">Send Verification</button>
  </div>
  </form>
  
</div>
</section>

</body>
</html>
