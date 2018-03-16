<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en" style="height:100%">
<head>

  <!-- SITE TITTLE -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calssimax</title>
  
    <link href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick-theme.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/jquery-nice-select/css/nice-select.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">



</head>

<body class="body-wrapper" style="position: relative; min-height: 100%; ">

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
<section class="page-search">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Advance Search -->
				<div class="advance-search">
                      <form:form method="GET" action="/find-tickets" name = "searchTicketForm" modelAttribute="searchTicket">
						<div class="form-row">
							<div class="form-group col-md-4">
							    <spring:message code="name.of.group" var="placeholderNameOfGroup"/>
								<form:input path="nameOfGroup" class="form-control" id="inputtext4" placeholder='${placeholderNameOfGroup}' />
							</div>
							<div class="form-group col-md-3">
				                <spring:message code="city" var="placeholderCity"/>
								<form:input path="city" class="form-control" id="inputCategory4" placeholder='${placeholderCity}' />
							</div>
							<div class="form-group col-md-3">
				                <spring:message code="music.genre" var="placeholderMusicGenre"/>
								<input name="musGenre" class="form-control" id="inputLocation4" placeholder='${placeholderMusicGenre}' />
							</div>
							<div class="form-group col-md-2">							
								<button type="submit" class="btn btn-primary"><spring:message code="search.tickets" /></button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="section-sm">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="search-result bg-gray">
					<h2>Results For "Rock"</h2>
					<p>${ fn:length(listOfTickets) } Results</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="category-sidebar">
					<div class="widget category-list">
	<h4 class="widget-header">All Category</h4>
	<form method="GET" action="find-tickets" id="genre_form">
	<input type="hidden" name="musGenre" id="musGenre" value=""/>
	<ul class="category-list">
		<li><a href="" onclick="rock(); return false;">Rock <span>93</span></a></li>
		<c:set var="val1"><spring:message code="rock"/></c:set>
	    
		<li><a href="" onclick="pop(); return false;">Pop <span>233</span></a></li>
		<c:set var="val2"><spring:message code="pop"/></c:set>
	    
		<li><a href="" onclick="jazz(); return false;">Jazz  <span>183</span></a></li>
		<c:set var="val3"><spring:message code="jazz"/></c:set>
	    
		<li><a href="" onclick="rap(); return false;">Rap <span>343</span></a></li>
		<c:set var="val4"><spring:message code="rap"/></c:set>
	</ul>
	</form>
</div>

				</div>
			</div>
			<div class="col-md-9">
				<div class="category-search-filter">
					<div class="row">
						<div class="col-md-6">
							<strong>Sort</strong>
							<select onchange="changeFunc(value)">
								<option value="sort_by_price">Sort by price</option>
								<option value="sort_by_name">Sort by name</option>
								<option value="sort_by_date">Sort by date</option>
								<option value="sort_by_city">Sort by city</option>
							</select>
						</div>
					</div>
				</div>
				<div class="product-grid-list">
					<div class="row mt-30" id="sortContainer">
	<c:forEach items="${listOfTickets}" var="ticket">
	<div class="sort col-sm-12 col-lg-4 col-md-6">
<div class="product-item bg-light">
	<div class="card">
		<div class="thumb-content">
			 <div class="sort-price price">${ ticket.price }</div> 
			    <c:if test="${not empty ticket.imageForPage }">
				  <img class="card-img-top img-fluid" src="data:image/gif;base64,${ ticket.imageForPage }" style="height:170px; width: 260px" alt="Card image cap">
				</c:if>
				<c:if test="${empty ticket.imageForPage }">	
				<img class="card-img-top img-fluid" src="<c:url value="/resources/images/home/empty_photo.png" />" style="height:170px; width: 260px" alt="Card image cap">
				</c:if>
		</div>
		<div class="card-body">
		    <h4 class="sort-name-of-group card-title">${ ticket.nameOfGroup }</h4>
		    <ul class="list-inline product-meta">
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-music"></i><spring:message code="${ fn:toLowerCase( ticket.musicGenre )}"/> </a>
		    	</li>
               
		    	<li class="list-inline-item">
		    		<a href="" class="sort-date"><i class="fa fa-calendar"></i>${ ticket.dateOfTheEventForPage }</a>
		    	</li>
		    </ul>
		    <p class="card-text"><i class="	fa fa-envelope-o"></i> <spring:message code="quantity"/>: ${ ticket.numberOfTickets }</p>		 
		    <p class="sort-city card-text"><i class="fa fa-map-o"></i> <spring:message code="city"/> ${ ticket.city }</p>
            <p class="card-text"><i class="fa fa-street-view"></i>${ ticket.location }</p>
            
            <a class="btn btn-outline-primary btn-block"  href="search/${ticket.ticketId}">Больше инф.</a>
<%--               <button type="submit" class="btn btn-outline-primary btn-block"  onclick="window.location.href='/search/${ticket.ticketId}'">Больше инф.</button> --%>
            
		</div>
	</div>
</div>    
</div>
	</c:forEach>				
	
	
                        
</div>
						
</div>
						
</div>
</div>
</div>
</section>
<!--============================
=            Footer            =
=============================-->

<!-- Footer Bottom -->
<footer class="footer-bottom" style="position: absolute; bottom: 0; width:100%">
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
              <li><a class="fa fa-vk" href="https://vk.com/id218566133"></a></li>
            </ul>
        </div>
      </div>
    </div>
    <!-- Container End -->
    <!-- To Top -->
    <div class="top-to">
      <a i d="top" class="" href=""><i class="fa fa-angle-up"></i></a>
    </div>
</footer>




<script>
function rock(){
	document.getElementById('musGenre').value='${val1}';
	document.getElementById('genre_form').submit();
}
function pop(){
	document.getElementById('musGenre').value='${val2}';
	document.getElementById('genre_form').submit();
}
function jazz(){
	document.getElementById('musGenre').value='${val3}';
	document.getElementById('genre_form').submit();
} 
function rap(){
	document.getElementById('musGenre').value='${val4}';
	document.getElementById('genre_form').submit();
}



 function changeFunc($i) {
	console.log('here')	
 	var $divs = $("div.sort");
  	if($i == "sort_by_price"){
	     var sortByPrice = $divs.sort(function (a, b) {
       	    	return $(a).find("div.sort-price").text() - $(b).find("div.sort-price").text();
          });
         $("#sortContainer").html(sortByPrice);
    }
  	if($i == "sort_by_name"){
	     var sortByName = $divs.sort(function (a, b) {
                return $(a).find("h4.sort-name-of-group").text().localeCompare($(b).find("h4.sort-name-of-group").text());
         });
        $("#sortContainer").html(sortByName);
    }
  	if($i == "sort_by_date"){
	     var sortByDate = $divs.sort(function (a, b) {
   	    	    return new Date($(a).find("a.sort-date").text()) - new Date($(b).find("a.sort-date").text());
         });
        $("#sortContainer").html(sortByDate);
    }
  	if($i == "sort_by_city"){
	     var sortByCity = $divs.sort(function (a, b) {
                return $(a).find("p.sort-city").text().localeCompare($(b).find("p.sort-city").text());		     
         });
        $("#sortContainer").html(sortByCity);
    }
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