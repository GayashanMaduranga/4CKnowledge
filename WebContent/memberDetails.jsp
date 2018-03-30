<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Untitled Document</title>
    <!-- Bootstrap -->
	<link href="css/bootstrap-4.0.0.css" rel="stylesheet">
	<link href="css/navStyles.css" rel="stylesheet" type="text/css">
  </head>
  <body style="padding-top: 0px">
  <nav class="navbar navbar-expand-lg navbar-dark" style="background: #005670; border-bottom: 1px solid white"> 
	  <a class="navbar-brand" href="#">
		  <img src="images/4C Knowledge-logo-200x200.png" width="55" height="46" style="padding: 5px" alt=""/>4CKnowledge</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
      <ul class="navbar-nav mr-auto" id="hideForLarge">
        <li class="nav-item active"> <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> </li>
        <li class="nav-item"> <a class="nav-link" href="#">Members</a> </li>
        <li class="nav-item"> <a class="nav-link" href="#">My Profile</a> </li>
         <li class="nav-item"> <a class="nav-link" href="#">Logout</a> </li>
       
      
      </ul>
      
		<ul  class="navbar-nav">
		<li class="nav-item dropdown "> 
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown2"> <a class="dropdown-item" href="#">My Profile</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Logout</a> </div>
        </li>
		
		</ul>
    </div>
  </nav>
  <main class="container-fluid" >
    <article class="row" style="min-height: 1200px;">
      <nav class="nav col-lg-2" style="background: #005670;" id="hide">
		 
		<div class="navbar d-block" >
	  	<a href="" class="nav-item nav-link text-white sideNavBtn" style="padding-left: 0;"><img src="images/home.svg" alt="" width="40px" style="padding: 8px;"/>Home</a>
		  <a href="" class="nav-item nav-link text-white sideNavBtn" style="padding-left: 0;"><img src="images/user.svg" alt="" width="35px" style="padding: 8px;" />Members</a>
		  <a href="" class="nav-item nav-link text-white sideNavBtn" style="padding-left: 0;"><img src="images/book.svg" alt="" width="34px" style="padding: 8px;"/>Books</a>
	    </div>
		
		</nav>
		
      <section class="col-lg-10" id="content" style="background: #EFEFEF">
        <div class="container-fluid bg-white p-2">
			
          <form class="text-center p-2" action="updatemember" method="post">
			  <h5 class="modal-header">Member Details</h5>
			  
              <div class="form-inline m-3">
              <label for="fnameInput" class="col-4 ">First Name</label>
              <input type="text" class="form-control border-success col-sm-auto col-md-8" id="fnameInput" name="fname" placeholder="Enter First Name" width="100%" value="${selected_member.fname}">
              </div>
			  <div class="form-inline m-3">
              <label for="lnameInput" class="col-4 ">Last Name</label>
              <input type="text" class="form-control col-sm-auto col-md-8 border-success" id="lnameInput" name="lname" placeholder="Enter Last Name" value="${selected_member.lname}">
              </div>
          
			  <div class="form-inline m-3">
              <label for="emailInput" class="col-4 ">Email</label>
               <input type="email" class="form-control col-sm-auto col-md-8 border-success" id="emailInput" name="email" placeholder="Enter Email" value="${selected_member.email}">
              </div>
			  
			  <div class="form-inline m-3">
              <label for="addressInput" class="col-4 ">Address</label>
              <input type="text" class="form-control col-sm-auto col-md-8 border-success" id="addressInput" name="address" placeholder="Enter Address" value="${selected_member.address}">
              </div>
			  
			  <div class="form-inline m-3">
              <label for="mobileInput" class="col-4 ">Mobile</label>
              <input type="text" class="form-control col-sm-auto col-md-8 border-success" id="mobileInput" name="mobile" placeholder="Enter Mobile No." value="${selected_member.mobile}">
              </div>
			  <div class="form-inline m-3">
              <label for="homeTelInput" class="col-4 ">Home Tel.</label>
              <input type="text" class="form-control col-sm-auto col-md-8 border-success" id="homeTelInput" name="homeTel"placeholder="Enter Home Tel." value="${selected_member.homeTel}">
              </div>
			  <div class="form-inline m-3">
              <label for="dobInput" class="col-4 ">Date Of Birth.</label>
              <input type="date" class="form-control col-sm-auto col-md-8 border-success" id="dobInput" name="dob" value="${selected_member.dob}">
              </div>
			  
			  <div class="form-inline m-3">
              <label for="userTypeInput" class="col-4 ">User Type.</label>
             <select class="form-control form-control col-sm-auto col-md-8 border-success" >
				 <option>Member</option>
				 <option>Community Admit</option>
				 <option>Owner</option>
			    </select>
              </div>
		   
			  <section class="mb-5">
				   <h6 class="modal-header mb-5">Member Interests</h6>
			    <div class="container-fluid">
			    <div class="row">
			      <div class="col-lg-6">
					<div class="mb-2">
              <label  class="form-check-inline">Artifitial Inteligence</label>
              <input type="checkbox">
						
              		</div>
					
					<div class="mb-2">
              <label  class="form-check-inline">Si-Fi</label>
              <input type="checkbox">
						
              		</div>
					  
					  <div class="mb-2">
              <label  class="form-check-inline">Image Processing</label>
              <input type="checkbox">
						
              		</div>
				  </div>
			      <div class="col-lg-6">
					<div class="mb-2">
              <label  class="form-check-inline">Politics</label>
              <input type="checkbox">
						
              		</div>
					
					<div class="mb-2">
              <label  class="form-check-inline">Middleware</label>
              <input type="checkbox">
						
              		</div>
					  
					  <div class="mb-2">
              <label  class="form-check-inline">Religion</label>
              <input type="checkbox">
						
              		</div>
				  </div>
		        </div>
			</div>
			</section>
            <button type="submit" class="btn btn-primary ">Update</button>
          </form>
        </div>
      </section>
    </article>
  </main>
  <footer class="d-block clearfix text-center bg-dark text-white">
	   Copyright &copy; Sri Lanka Institute of Information Technology.All Rights Reserved
	  
	  </footer>
<!-- body code goes here -->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
	<script src="js/popper.min.js"></script>
	<script src="js/jquery-3.2.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap-4.0.0.js"></script>
</body><body>
  </body>
</html>