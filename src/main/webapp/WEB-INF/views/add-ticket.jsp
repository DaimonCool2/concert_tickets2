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

    <!--================================
=            Page Title            =
=================================-->
    <section class="page-title">
        <!-- Container Start -->
        <div class="container">
            <div class="row">
                <div class="col-md-8 offset-md-2 text-center">
                    <!-- Title text -->
                    <h3>Add tickets</h3>
                </div>
            </div>
        </div>
        <!-- Container End -->
    </section>
    <!--==================================
=            Blog Section            =
===================================-->

    <section class="blog section">
        <div class="container">
            <div class="row">
                <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0"> </div>

                <div class="col-md-10 offset-md-1 col-lg-6 offset-lg-0">

<!-- onsubmit="return validateAddTicketForm()" -->
                      <form:form method="POST" name="addTicketForm"  modelAttribute="ticket" action="add-new-ticket" enctype="multipart/form-data" class="form">
                        <div class="form-group">
                            <spring:message code="name.of.group" var="placeholderNameOfGroup" />
                        
                            <form:label path="nameOfGroup">${placeholderNameOfGroup}</form:label>
                            <form:input path="nameOfGroup" placeholder='${placeholderNameOfGroup}' onkeyup="clearEmptyNameOfGroup()" class="form-control"/>
			                <form:errors path="nameOfGroup" />
			                <span id="emptyNameOfGroup"> </span>
                            
                        </div>
                        <div class="form-group">
                            <spring:message code="number.of.tickets" var="placeholderNumberOfTickets" />
                        
                            <form:label path="numberOfTickets">${placeholderNumberOfTickets}</form:label>
                            <form:input path="numberOfTickets" placeholder='${placeholderNumberOfTickets}' onkeyup="clearEmptyNumberOfTickets()" class="form-control"/>
			                <form:errors path="numberOfTickets" />
			                <span id="emptyNumberOfTickets"> </span>
                                                
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Music genre</label>                           
                            <select name = "musGenre" class="form-control" id="exampleFormControlSelect1">
                                 <option><spring:message code="rock"/></option>
                                 <option><spring:message code="pop"/></option>
                                 <option><spring:message code="rap"/></option>
                                 <option><spring:message code="jazz"/></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <spring:message code="city" var="placeholderCity" />
                        
                            <form:label path="city">${placeholderCity}</form:label>
                            <form:input path="city" placeholder='${placeholderCity}' onkeyup="clearEmptyCity()" class="form-control"/>
			                <form:errors path="city" />
			                <span id="emptyCity"> </span>
                        
                        </div>
                        <div class="form-group">
                            <spring:message code="location" var="placeholderLocation" />
                        
                            <form:label path="location">${placeholderLocation}</form:label>
                            <form:textarea path="location" placeholder='${placeholderLocation}' onkeyup="clearEmptyLocation()" class="form-control" rows="4" style="height: 100px"/>
			                <form:errors path="location" />
			                <span id="emptyLocation"> </span>
                        
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="inputState">Year</label>
                                <select name = "year" id="inputState" class="form-control">
                                    <option selected>2017</option>
                                     <c:forEach var="i" begin="2017" end="2020">
                                       <option >${i}</option>
                                     </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputState">Month</label>
                                <select name = "month" id="inputState" class="form-control">
                                    <option selected>01</option>
                                    <c:forEach var="i" begin="2" end="12">
                                       <option>
                                         <c:if test="${i < 10}">
                                           0${i}
                                         </c:if>
                                         <c:if test="${i >= 10}">
                                           ${i}
                                         </c:if>
                                       </option>
                                     </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputState">Day</label>
                                <select name = "day" id="inputState" class="form-control">
                                    <option selected>01</option>
                                    <c:forEach var="i" begin="2" end="31">
                                       <option>
                                         <c:if test="${i < 10}">
                                           0${i}
                                         </c:if>
                                         <c:if test="${i >= 10}">
                                           ${i}
                                         </c:if>
                                       </option>
                                     </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputState">Hour</label>
                                <select name = "hour" id="inputState" class="form-control">
                                    <option selected>00</option>
                                    <c:forEach var="i" begin="1" end="23">
                                       <option>
                                         <c:if test="${i < 10}">
                                           0${i}
                                         </c:if>
                                         <c:if test="${i >= 10}">
                                           ${i}
                                         </c:if>
                                       </option>
                                     </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="inputState">Minute</label>
                                <select name = "minute" id="inputState" class="form-control">
                                    <option selected>01</option>
                                     <c:forEach var="i" begin="2" end="59">
                                       <option>
                                         <c:if test="${i < 10}">
                                           0${i}
                                         </c:if>
                                         <c:if test="${i >= 10}">
                                           ${i}
                                         </c:if>
                                       </option>
                                     </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <spring:message code="description" var="placeholderDescription" />
                        
                            <form:label path="description">${placeholderDescription}</form:label>
                            <form:textarea path="description" placeholder='${placeholderDescription}' onkeyup="clearEmptyDescription()" class="form-control" rows="4" style="height: 150px"/>
			                <form:errors path="description" />
                        
                        </div>
                        <div class="form-group">
                           <label for="exampleFormControlFile1">Example file input</label>
                           <input type="file" name = "fileImage" class="form-control-file" id="exampleFormControlFile1" accept="image/x-png,image/gif,image/jpeg" >
                        </div>
                        <div class="form-row">
                         <div class="col-md-4"></div>
                            <div class="col-md-4"> 
                            <button class="btn btn-transparent">Add tickets</button>
                         <div class="col-md-4"></div>
                            </div>
                        </div>
                    </form:form>

                </div>

                <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0"> </div>



            </div>
        </div>
    </section>

    <!--============================
=            Footer            =
=============================-->

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
                            <a class="fa fa-facebook" href=""></a>
                        </li>
                        <li>
                            <a class="fa fa-twitter" href=""></a>
                        </li>
                        <li>
                            <a class="fa fa-pinterest-p" href=""></a>
                        </li>
                        <li>
                            <a class="fa fa-vimeo" href=""></a>
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

    <!-- JAVASCRIPTS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <script src="<c:url value="/resources/plugins/jquery/dist/jquery.slim.js" />"> </script>

    <script src="<c:url value="/resources/plugins/bootstrap/dist/js/popper.min.js" />"></script>
    <script src="<c:url value="/resources/plugins/bootstrap/dist/js/bootstrap.min.js" />"></script>

    <script src="<c:url value="/resources/js/scripts.js" />"></script>

</body>

</html>
