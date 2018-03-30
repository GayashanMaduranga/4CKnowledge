<!DOCTYPE html>
<%@page import="com.sliit.entities.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sliit.datamodel.MemberDao"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>4CKnowledge</title>
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
        <li class="nav-item"> <a class="nav-link" href="displaymembers">Members</a> </li>
        <li class="nav-item"> <a class="nav-link" href="profiledetails">My Profile</a> </li>
         <li class="nav-item"> <a class="nav-link" href="logout">Logout</a> </li>
       
      
      </ul>
      
		<ul  class="navbar-nav">
		<li class="nav-item dropdown "> 
			<a class="nav-link dropdown-toggle" href="" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> ${user.email} </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown2"> <a class="dropdown-item" href="profiledetails">My Profile</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="logout">Logout</a> </div>
        </li>
		
		</ul>
    </div>
  </nav>
  <main class="container-fluid" >
    <article class="row" style="min-height: 1200px;">
      <nav class="nav col-lg-2" style="background: #005670;" id="hide">
		 
		<div class="navbar d-block" >
	  	<a href="" class="nav-item nav-link text-white sideNavBtn" style="padding-left: 0;"><img src="images/home.svg" alt="" width="40px" style="padding: 8px;"/>Home</a>
		  <a href="displaymembers" class="nav-item nav-link text-white sideNavBtn" style="padding-left: 0;"><img src="images/user.svg" alt="" width="35px" style="padding: 8px;" />Members</a>
		  <a href="" class="nav-item nav-link text-white sideNavBtn" style="padding-left: 0;"><img src="images/book.svg" alt="" width="34px" style="padding: 8px;"/>Books</a>
	    </div>
		
		</nav>
		
      <section class="col-lg-10" id="content" style="background: #EFEFEF">
        <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-6"><h3 style="display: inline">Members</h3></div>
			  <div class="col-md-6">
			  <form class="form-inline my-2 my-lg-0 float-right" action="search">
        <input class="form-control form" type="search" placeholder="Search" aria-label="Search" name="search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      	</form>
			  </div>
		  </div>

			
	    </div>
		<div class="container">
		  
		  <div class="row">
		   
			 <%
			 ArrayList<Member> members = null;
			 if(session.getAttribute("members")==null){
			 	MemberDao dao = new MemberDao();
			 	members = (ArrayList<Member>)dao.getAllMembers();
			 	session.setAttribute("members", members);
			 }else{
				 members = (ArrayList<Member>)session.getAttribute("members");
			 }
			 	System.out.println(members.size());
			 	for(int i=0;i<members.size();i++){
			 		%>
			 		
			 <section class="col-md-5" style="background: #FFFFFF;margin: 20px;padding: 10px;">
			  <div class="d-block clearfix">
				  
				<a href="removemember?id=<%=String.valueOf(i) %>" class="float-right" ><img src="images/trash-alt.svg" alt="" width="35px" style="padding: 8px;"/></a>
				<a href="" class="float-right" ><img src="images/edit.svg" alt="" width="40px" style="padding: 8px;"/></a>
			  </div>
				
				<div class="d-block" style="border-bottom: : 1px solid black">
					<h6><%=members.get(i).getFullName() %></h6>
					<label>Email :</label>
					<label><%=members.get(i).getEmail() %></label>
				</div>
				<div class="text-center">
				<button class="btn btn-light " style="border: 1px solid #888585"onclick="window.location.href='displaymemberdetails?id=<%=String.valueOf(i) %>'">View Profile</button>
				
				</div>
				
			 </section>
			 		
			 	<%	
	 		
			 	}
			 
			 %>
		    
	      </div>
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