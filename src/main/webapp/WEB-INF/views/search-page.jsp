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
						<img src="images/logo.png" alt="">
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
					<form>
						<div class="form-row">
							<div class="form-group col-md-4">
								<input type="text" class="form-control" id="inputtext4" placeholder="Name of group">
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control" id="inputCategory4" placeholder="City">
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control" id="inputLocation4" placeholder="Music genre">
							</div>
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
<section class="section-sm">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="search-result bg-gray">
					<h2>Results For "Rock"</h2>
					<p>123 Results</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="category-sidebar">
					<div class="widget category-list">
	<h4 class="widget-header">All Category</h4>
	<ul class="category-list">
		<li><a href="category.html">Rock <span>93</span></a></li>
		<li><a href="category.html">Pop <span>233</span></a></li>
		<li><a href="category.html">Jazz  <span>183</span></a></li>
		<li><a href="category.html">Rap <span>343</span></a></li>
	</ul>
</div>

				</div>
			</div>
			<div class="col-md-9">
				<div class="category-search-filter">
					<div class="row">
						<div class="col-md-6">
							<strong>Sort</strong>
							<select>
								<option>Most Recent</option>
								<option value="1">Most Popular</option>
								<option value="2">Lowest Price</option>
								<option value="4">Highest Price</option>
							</select>
						</div>
					</div>
				</div>
				<div class="product-grid-list">
					<div class="row mt-30">
<div class="col-sm-12 col-lg-4 col-md-6">
							<!-- product card -->
<div class="product-item bg-light">
	<div class="card">
		<div class="thumb-content">
			 <div class="price">15000 тнг</div> 
			<a href="">
				<img class="card-img-top img-fluid" src="<c:url value="/resources/images/products/aria_big.jpg" />" style="height:170px; width: 260px" alt="Card image cap">
			</a>
		</div>
		<div class="card-body">
		    <h4 class="card-title"><a href="">Ария</a></h4>
		    <ul class="list-inline product-meta">
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-music"></i>Рок</a>
		    	</li>
               
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-calendar"></i>26 Nov. 2017. 15:30</a>
		    	</li>
		    </ul>
		    <p class="card-text"><i class="fa fa-map-o"></i> Город Караганда</p>
            <p class="card-text"><i class="fa fa-street-view"></i> Шахтер. улица какая-то</p>

            <button type="submit" class="btn btn-outline-primary btn-block">Больше инф.</button>
            
		</div>
	</div>
</div>    
</div>
                        
                        <div class="col-sm-12 col-lg-4 col-md-6">
							<!-- product card -->
<div class="product-item bg-light">
	<div class="card">
		<div class="thumb-content">
			 <div class="price">15000 тнг</div> 
			<a href="">
				<img class="card-img-top img-fluid" src="<c:url value="/resources/images/products/aria_big.jpg" />" style="height:170px; width: 260px" alt="Card image cap">
			</a>
		</div>
		<div class="card-body">
		    <h4 class="card-title"><a href="">Ария</a></h4>
		    <ul class="list-inline product-meta">
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-music"></i>Рок</a>
		    	</li>
               
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-calendar"></i>26 Nov. 2017. 15:30</a>
		    	</li>
		    </ul>
		    <p class="card-text"><i class="fa fa-map-o"></i> Город Караганда</p>
            <p class="card-text"><i class="fa fa-street-view"></i> Шахтер. улица какая-то</p>

            <button type="submit" class="btn btn-outline-primary btn-block">Больше инф.</button>
            
		</div>
	</div>
</div>    
</div>
                        
                        <div class="col-sm-12 col-lg-4 col-md-6">
							<!-- product card -->
<div class="product-item bg-light">
	<div class="card">
		<div class="thumb-content">
			 <div class="price">15000 тнг</div> 
			<a href="">
				<img class="card-img-top img-fluid" src="<c:url value="/resources/images/products/aria_big.jpg" />" style="height:170px; width: 260px" alt="Card image cap">
			</a>
		</div>
		<div class="card-body">
		    <h4 class="card-title"><a href="">Ария</a></h4>
		    <ul class="list-inline product-meta">
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-music"></i>Рок</a>
		    	</li>
               
		    	<li class="list-inline-item">
		    		<a href=""><i class="fa fa-calendar"></i>26 Nov. 2017. 15:30</a>
		    	</li>
		    </ul>
		    <p class="card-text"><i class="fa fa-map-o"></i> Город Караганда</p>
            <p class="card-text"><i class="fa fa-street-view"></i> Шахтер. улица какая-то</p>

            <button type="submit" class="btn btn-outline-primary btn-block">Больше инф.</button>
            
		</div>
	</div>
</div>    
</div>
					

                        
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