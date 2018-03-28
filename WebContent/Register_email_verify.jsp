<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title> 4C Knowledge</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"> </script>
  <script src="js/bootstrap.min.js"> </script>
  
 


<style type="text/css">
	
	#regForm{	
		
		position: absolute;
    top:100px;
   
    left: 0;
    right: 0;

  
	
	 
		 
		 
		
		
			
		  
		width:500px;
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
<div id="regForm"  class="container col-sm-5">


  <h2>Enter Verification Code</h2>
  <form action="RegisterVerifyServlet" method="post">
   
    

     <div class="form-group">
    <label for="Code">Digit:</label> 
    <input type="number" class="form-control" id="Code" name="Code" placeholder="Enter Verification Code"  pattern="[0-9]*$"  required> 
      
      
   
	
   

    <button type="submit" class="btn btn-default">Continue</button>
    </div>
  </form>
</div>
</section>

</body>
</html>
