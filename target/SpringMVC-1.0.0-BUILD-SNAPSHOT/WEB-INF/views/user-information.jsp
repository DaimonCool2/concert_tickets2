<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>

  <!-- SITE TITTLE -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calssimax</title>
  
  <link href="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick-theme.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/jquery-nice-select/css/nice-select.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

 


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
  

</head>

<body class="body-wrapper">


<section>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg  navigation">
					<a class="navbar-brand" href="index.html">
						<img src="<c:url value="/resources/images/logo.png" />" alt="">
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto main-nav ">
							<li class="nav-item active">
								<a class="nav-link" href="index.html">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="dashboard.html">Dashboard</a>
							</li>
							<li class="nav-item dropdown dropdown-slide">
								<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Pages <span><i class="fa fa-angle-down"></i></span>
								</a>
								<!-- Dropdown list -->
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="category.html">Category</a>
									<a class="dropdown-item" href="single.html">Single Page</a>
									<a class="dropdown-item" href="store-single.html">Store Single</a>
									<a class="dropdown-item" href="dashboard.html">Dashboard</a>
									<a class="dropdown-item" href="user-profile.html">User Profile</a>
									<a class="dropdown-item" href="submit-coupon.html">Submit Coupon</a>
									<a class="dropdown-item" href="blog.html">Blog</a>
									<a class="dropdown-item" href="single-blog.html">Single Post</a>
								</div>
							</li>
							<li class="nav-item dropdown dropdown-slide">
								<a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Listing <span><i class="fa fa-angle-down"></i></span>
								</a>
								<!-- Dropdown list -->
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href="#">Action</a>
									<a class="dropdown-item" href="#">Another action</a>
									<a class="dropdown-item" href="#">Something else here</a>
								</div>
							</li>
						</ul>
						<ul class="navbar-nav ml-auto mt-10">
							<li class="nav-item">
								<a class="nav-link login-button" href="index.html">Login</a>
							</li>
							<li class="nav-item">
								<a class="nav-link add-button" href="#"><i class="fa fa-plus-circle"></i> Add Listing</a>
							</li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</div>
</section>
<!--==================================
=            User Profile            =
===================================-->

<section class="user-profile section">
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1 col-lg-4 offset-lg-0">
				<div class="sidebar">
					<!-- User Widget -->
					<div class="widget user-dashboard-profile">
						<!-- User Image -->
						<div class="profile-thumb">
							<img src="<c:url value="/resources/images/user/empty_avatar.png" />" alt="" class="rounded-circle">
						</div>
						<!-- User Name -->
						<h5 class="text-center">Samanta Doe</h5>
						<p>Joined February 06, 2017</p>
					</div>
					<!-- Dashboard Links -->
					<div class="widget user-dashboard-menu">
						<ul>
							<li>
								<a href="dashboard-my-ads.html"><i class="fa fa-user"></i> My Ads</a></li>
							<li>
								<a href="dashboard-favourite-ads.html"><i class="fa fa-bookmark-o"></i> Favourite Ads <span>5</span></a>
							</li>
							<li>
								<a href="dashboard-archived-ads.html"><i class="fa fa-file-archive-o"></i>Archeved Ads <span>12</span></a>
							</li>
							<li>
								<a href="dashboard-pending-ads.html"><i class="fa fa-bolt"></i> Pending Approval<span>23</span></a>
							</li>
							<li>
								<a href="logout.html"><i class="fa fa-cog"></i> Logout</a>
							</li>
							<li>
								<a href="delete-account.html"><i class="fa fa-power-off"></i>Delete Account</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
				<!-- Edit Personal Info -->
				<div class="widget personal-info">
					<h3 class="widget-header user">Edit Personal Information</h3>
					
					
					
<!-- 					onsubmit="return validateLoginForm()" -->
					<form:form method="POST" name="personalInformationForm" onsubmit="return validatePersonalInformationForm()" modelAttribute="personalInformation" action="update-information">
						<spring:message code="first.name" var="placeholderFirstName" />
						<spring:message code="last.name" var="placeholderLastName" />
						
						<!-- First Name -->
						<div class="form-group">
						
						<form:label path="firstName">${placeholderFirstName}</form:label>
						<form:input path="firstName" placeholder='${placeholderFirstName}' onkeyup="clearEmptyFirstname()" class="form-control"/>
			            <form:errors path="firstName" />
			            <span id="emptyFirstname"> </span>
						
						</div>
						<!-- Last Name -->
						<div class="form-group">
						
						<form:label path="lastName" >${placeholderLastName}</form:label>
						<form:input path="lastName" placeholder='${placeholderLastName}' onkeyup="clearEmptyLastname()" class="form-control"/>
			            <form:errors path="lastName" />
			            <span id="emptyLastname"> </span>
						    
						</div>
						<button type="submit" class="btn btn-transparent">Save My Changes</button>
					</form:form>
					
					
								
				</div>
                
                <div class="widget personal-info">
						<div class="form-group choose-file">
							<i class="fa fa-user text-center"></i>
						    <input type="file" class="form-control-file d-inline" id="input-file">
						 </div>
                </div>
                
				<!-- Change Password -->
				<div class="widget change-password">
					<h3 class="widget-header user">Edit Password</h3>
					
					<form:form method="POST" name="changePasswordForm" onsubmit="return validateChangePasswordForm2()" modelAttribute="changePasswordEntity" action="change-password">		
					
					<spring:message code="current.password" var="placeholderCurrentPassword" />
			        <spring:message code="new.password" var="placeholderNewPassword" />
			        <spring:message code="confirm.new.password" var="placeholderConfirmNewPassword" />			
						
						<!-- Current Password -->
						
						<div class="form-group">

			                <form:label path="currentPassword" >${placeholderCurrentPassword} </form:label>
			                <form:password path="currentPassword" placeholder='${placeholderCurrentPassword}' onkeyup="clearEmptyCurrentPassword()" class="form-control"/>
			                <form:errors path="currentPassword" />
			            	<span id="errorCurrentPassword"> </span>
			            
						</div>
						
						<!-- New Password -->
						
						<div class="form-group">
						
						    <form:label path="newPassword" >${placeholderNewPassword} </form:label>
			                <form:password path="newPassword" placeholder='${placeholderNewPassword}' onkeyup="clearEmptyNewPassword()" class="form-control"/>
			                <form:errors path="newPassword" />
			            	<span id="errorNewPassword"> </span>
			            	
						</div>
						
						<!-- Confirm New Password -->
						
						<div class="form-group">
						
						    <form:label path="confirmNewPassword" >${placeholderConfirmNewPassword} </form:label>
			                <form:password path="confirmNewPassword" placeholder='${placeholderConfirmNewPassword}' onkeyup="clearEmptyConfirmNewPassword()" class="form-control"/>
			                <form:errors path="confirmNewPassword" />
			            	<span id="errorConfirmNewPassword"> </span>
			            	
						</div>
						
						<!-- Submit Button -->
						<button type="submit" class="btn btn-transparent">Change Password</button>
					</form:form>
					
				</div>
				<!-- Change Email Address -->
				<div class="widget change-email mb-0">
					<h3 class="widget-header user">Edit Email Address</h3>
					<form action="#">
						<!-- Current Password -->
						<div class="form-group">
						    <label for="current-email">Current Email</label>
						    <input type="email" class="form-control" id="current-email">
						</div>
						<!-- New email -->
						<div class="form-group">
						    <label for="new-email">New email</label>
						    <input type="email" class="form-control" id="new-email">
						</div>
						<!-- Submit Button -->
						<button class="btn btn-transparent">Change email</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>

<footer class="footer-bottom">
    <!-- Container Start -->
    <div class="container">
      <div class="row">
        <div class="col-sm-6 col-12">
          <!-- Copyright -->
          <div class="copyright">
            <p>Copyright © 2016. All Rights Reserved</p>
          </div>
        </div>
        <div class="col-sm-6 col-12">
          <!-- Social Icons -->
          <ul class="social-media-icons text-right">
              <li><a class="fa fa-facebook" href=""></a></li>
              <li><a class="fa fa-twitter" href=""></a></li>
              <li><a class="fa fa-pinterest-p" href=""></a></li>
              <li><a class="fa fa-vimeo" href=""></a></li>
            </ul>
        </div>
      </div>
    </div>
    <!-- Container End -->
    <!-- To Top -->
    <div class="top-to">
      <a id="top" class="" href=""><i class="fa fa-angle-up"></i></a>
    </div>
</footer>

  <script type="text/javascript">
  function clearEmptyFirstname() {
      document.getElementById('emptyFirstname').textContent=null  
  }
  </script>
  
  <script type="text/javascript">
  function clearEmptyLastname() {
      document.getElementById('emptyLastname').textContent=null 
  }
  </script>
  
  <script type="text/javascript">
  function validatePersonalInformationForm() {
	  var flag = false; 
	  
	  var emptyField;
	  var firstName = document.forms["personalInformationForm"]["firstName"].value; 
      var lastName = document.forms["personalInformationForm"]["lastName"].value;

      if(firstName != "" && lastName != ""){
          flag = true;
      } else {

//     	  jQuery.noConflict();
    	  $.ajax({
     	        url: 'get-message-empty-field',
     	        dataType: "text", 
     	        async: false,
     	        success: function(data) {
     	            emptyField = data;		          
     	        }
     	      });

      
      if (firstName == "") {
          document.getElementById('emptyFirstname').textContent = emptyField;
      } 
      if (lastName == "") { 
	      document.getElementById('emptyLastname').textContent = emptyField;	            
      }    
      }  
      return flag;
  }
  </script>
  
  <script type="text/javascript">
  function clearEmptyCurrentPassword() {
      document.getElementById('errorCurrentPassword').textContent=null  
  }
  </script>
  
  <script type="text/javascript">
  function clearEmptyNewPassword() {
      document.getElementById('errorNewPassword').textContent=null 
  }
  </script>
  
  <script type="text/javascript">
  function clearEmptyConfirmNewPassword() {
      document.getElementById('errorConfirmNewPassword').textContent=null 
  }
  </script>
  

  <script type="text/javascript">
  function validateChangePasswordForm1() {
	  var flag = false; 
	  
	  var emptyField;
	  var currentPassword = document.forms["changePasswordForm"]["currentPassword"].value; 
      var newPassword = document.forms["changePasswordForm"]["newPassword"].value;
      var confirmNewPassword = document.forms["changePasswordForm"]["confirmNewPassword"].value;

      if(currentPassword != "" && newPassword != "" && confirmNewPassword != ""){
          flag = true;
      } else {
          
//     	  jQuery.noConflict();
    	  $.ajax({
     	        url: 'get-message-empty-field',
     	        dataType: "text", 
     	        async: false,
     	        success: function(data) {
     	            emptyField = data;		          
     	        }
     	      });
      
      if (currentPassword == "") {
          document.getElementById('errorCurrentPassword').textContent = emptyField;
      } 
      if (newPassword == "") { 
	      document.getElementById('errorNewPassword').textContent = emptyField;	            
      }   
      if (confirmNewPassword == "") { 
	      document.getElementById('errorConfirmNewPassword').textContent = emptyField;	            
      }   
      }  
      return flag;
  }
  </script>
  
  <script type="text/javascript">
     function validateChangePasswordForm2() {
 	   var flag = false;
        
       if(validateChangePasswordForm1()){
           var passwordPattern = /[a-zA-Z0-9_\\-]{6,}/;
    	   var password = document.forms["changePasswordForm"]["newPassword"].value;

           if(password.match(passwordPattern) != null && (password == document.forms["changePasswordForm"]["confirmNewPassword"].value)){

        	   //jQuery.noConflict();
        	   $.ajax({
       	        url: 'check-current-password',
       	        async: false,
       		    type: 'post',
       	        data: ({currentPassword : $('#currentPassword').val()}),
       	        success: function(data) {
           	        if(data == true){
       	        	flag = true; 
           	        } else {
           	        	$.ajax({
                	        url: 'get-message-current-password-is-wrong',
                	        dataType: "text", 
                	        async: false,
                	        success: function(data) {
                       	        document.getElementById('errorCurrentPassword').textContent = data;		          
                	        }
                	      });
           	        flag = false;    
               	    }
       	        	
           	    }
       	      });    
           
           } else {
 	   
    	   if(password.match(passwordPattern) == null){
    		   $.ajax({
        	        url: 'get-message-password-pattern-password',
        	        dataType: "text", 
        	        async: false,
        	        success: function(data) {
        	        	document.getElementById('errorNewPassword').textContent = data;		          
        	        }
        	      });		   
           } else {
               if(password != document.forms["changePasswordForm"]["confirmNewPassword"].value){
            	   $.ajax({
           	        url: 'get-message-confirm-password-pattern-error',
           	        dataType: "text", 
           	        async: false,
           	        success: function(data) {
                        document.getElementById('errorConfirmNewPassword').textContent = data;
           	        }
           	      });
               }
           }

           }
       }
       return flag;
     }
  </script>

      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

      <script src="<c:url value="/resources/plugins/jquery/jquery.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/tether/js/tether.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/raty/jquery.raty-fa.js" />"> </script>
      <script src="<c:url value="/resources/plugins/bootstrap/dist/js/popper.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/bootstrap/dist/js/bootstrap.min.js" />"> </script>      
      <script src="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/bootstrap-slider.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/slick-carousel/slick/slick.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/jquery-nice-select/js/jquery.nice-select.min.js" />"> </script>
      <script src="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.js" />"> </script>
      <script src="<c:url value="/resources/plugins/smoothscroll/SmoothScroll.min.js" />"> </script>
      <script src="<c:url value="/resources/https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw" />"> </script>
      <script src="<c:url value="/resources/js/scripts.js" />"> </script>

</body>

</html>