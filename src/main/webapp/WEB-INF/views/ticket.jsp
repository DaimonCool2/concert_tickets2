<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
  <!-- SITE TITTLE -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calssimax</title>
  <!-- PLUGINS CSS STYLE -->
    <link href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick-theme.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/jquery-nice-select/css/nice-select.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    
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
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ml-auto main-nav ">
                <li class="nav-item active">
                  <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="dashboard.html">Dashboard</a>
                </li>
                <li class="nav-item dropdown dropdown-slide">
                  <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Pages <span><i class="fa fa-angle-down"></i></span> </a>
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
                  <a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Listing <span><i class="fa fa-angle-down"></i></span> </a>
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
  <section class="page-search">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <!-- Advance Search -->
          <div class="advance-search">
            <form>
              <div class="form-row">
                <div class="form-group col-md-4">
                  <input type="text" class="form-control" id="inputtext4" placeholder="What are you looking for"> </div>
                <div class="form-group col-md-3">
                  <input type="text" class="form-control" id="inputCategory4" placeholder="Category"> </div>
                <div class="form-group col-md-3">
                  <input type="text" class="form-control" id="inputLocation4" placeholder="Location"> </div>
                <div class="form-group col-md-2">
                  <button type="submit" class="btn btn-primary">Search Now</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--===================================
=            Store Section            =
====================================-->
  <section class="section bg-gray">
    <!-- Container Start -->
    <div class="container">
      <div class="row">
        <!-- Left sidebar -->
        <div class="col-md-8">
          <div class="product-details">
            <h1 class="product-title">${ ticket.nameOfGroup }</h1>
            <div class="product-meta">
              <ul class="list-inline">
                <li class="list-inline-item">
                  <a href=""><i class="fa fa-music"></i> <spring:message code="${ fn:toLowerCase( ticket.musicGenre )}"/></a>
                </li>
                <li class="list-inline-item">
                  <a href=""><i class="fa fa-calendar"></i> ${ ticket.dateOfTheEventForPage }</a>
                </li>
                <li class="list-inline-item">
                  <a href=""><i class="fa fa-map-o"></i> <spring:message code="city"/> ${ ticket.city }</a>
                </li>
                <li class="list-inline-item">
                  <a href=""><i class="fa fa-street-view"></i> ${ ticket.location }</a>
                </li>
              </ul>
            </div>
            <div id="carouselExampleIndicators" class="product-slider carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                <c:if test="${not empty ticket.imageForPage }">
                  <img class="d-block w-100" src="data:image/gif;base64,${ ticket.imageForPage }" alt="Ticket"> 
				</c:if>
				<c:if test="${empty ticket.imageForPage }">	
				<img class="d-block w-100" src="<c:url value="/resources/images/home/empty_photo.png" />" alt="Ticket">
				</c:if>
				</div>
              </div>
            </div>
            <div class="content">
              <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                  <h3 class="tab-title"> <spring:message code="description"/></h3>
                  <p>${ ticket.description }</p>

                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="sidebar">
            <div class="widget price text-center">
              <h4>Price</h4>
              <p>${ ticket.price } тнг.</p>
            </div>
            <c:choose>
    		  <c:when test="${ticket.numberOfTickets > 0 && isValidDate}">
              <div class="widget price text-center" style="background-color: white">
                <h4 style="color: #5572f9"> <spring:message code="number.of.tickets"/></h4>
                <p style="color: #5572f9">${ ticket.numberOfTickets }</p>
              </div>
              <div class="widget">
               <form method="POST" action = "/buy-ticket" onsubmit="return checkNumberOfTickets()">
               <input type = "hidden" id = "ticketId" value = "${ ticket.ticketId }" />
                <input class="form-control" name = "numberOfTickets" id="numberOfTickets" type="number" value="1" min="1" max="100000">
                <span id = "unacceptableNumberOfTickets"> </span>
                <br>
                <button type="submit" class="btn btn-primary btn-block">Buy</button>
                </form>
              </div>    		
              </c:when> 
                 
              <c:when test="${!isValidDate}">
              <div class="widget price text-center" style="background-color: white">
                <h4 style="color: red"> <spring:message code="date.has.expired"/></h4>
              </div> 		
              </c:when> 
              
              <c:when test="${ticket.numberOfTickets == 0}">
              <div class="widget price text-center" style="background-color: white">
                <h4 style="color: red"> <spring:message code="no.tickets"/></h4>
              </div> 		
              </c:when> 
              
            </c:choose>

            <!-- User Profile widget -->
            <div class="widget user">
              <h4>Jonathon Andrew</h4>
              <p class="member-time">Дмитрий дашко</p>
              <a href="">See all ads</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Container End -->
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
            <li>
              <a class="fa fa-vk" href="https://vk.com/id218566133"></a>
            </li>
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
  <script>
   function checkNumberOfTickets(){
	  var flag = false;
	  jQuery.noConflict();
      $.ajax({
	        url: '/check-acceptable-number-of-tickets',
	        async: false,
		    type: 'get',
	        data: ({
		        numberOfTickets : $('#numberOfTickets').val(),
		        ticketId : $('#ticketId').val()
		        }),
	        success: function(data) {
    	        if(data == false){
    	        	$.ajax({
             	        url: '/get-message-unacceptable-number-of-tickets',
             	        dataType: "text", 
             	        async: false,
             	        success: function(data) {
                    	  document.getElementById('unacceptableNumberOfTickets').textContent = data;		          
             	        }
             	      });    
	        	flag = false; 
    	        } else {
        	    flag = true;    
        	    }	
    	    }, error: function(){
		    	window.location.replace("/system-error");
	        }
	      });
      return flag;
   }
  </script>
  
  <!-- JAVASCRIPTS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
    <script src="<c:url value="/resources/plugins/jquery/dist/jquery.slim.js" />"> </script>

    <script src="<c:url value="/resources/plugins/raty/jquery.raty-fa.js" />"></script>
    <script src="<c:url value="/resources/plugins/bootstrap/dist/js/popper.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/bootstrap-slider.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/slick-carousel/slick/slick.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/jquery-nice-select/js/jquery.nice-select.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.js" />"></script>
    <script src="<c:url value="/resources/plugins/smoothscroll/SmoothScroll.min.js" />"></script>
    <script src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw" />"></script>
    <script src="<c:url value="/resources/js/scripts.js" />"></script>

</body>

</html>
