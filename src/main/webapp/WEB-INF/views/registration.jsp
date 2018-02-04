<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
    <title>Registration</title>

    <link href="<c:url value="/resources/css/styleForRegistration.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <script type="text/javascript">
    function doAjax() {
      var usern = document.forms["registration"]["username"].value
      if(usern.length > 2){
      $.ajax({
        url: 'check-if-user-exist',
        data: ({username : $('#username').val()}),
        success: function(data) {
        	document.getElementById('checkIfUserExist').textContent = data;
        }
      });
      } else {
       document.getElementById('checkIfUserExist').textContent=null
       }
    }
  </script>
    
  <script type="text/javascript">
  function clearErrorUsername() {
	  var usern = document.forms["registration"]["username"].value
      if(usern.length > 2){
          document.getElementById('errorUsername').textContent=null 
      } 
  }
  </script>
  
  <script type="text/javascript">
  function clearErrorPassword() {
      document.getElementById('errorPassword').textContent=null 
  }
  </script>
  
  <script type="text/javascript">
  function clearErrorConfirmPassword() {
      document.getElementById('errorConfirmPassword').textContent=null 
  }
  </script>
    
  
  <script type="text/javascript">
   function validateForm1() { 
	    var emptyField;
	   
	    var flag = false;
        var username = document.forms["registration"]["username"].value; 
        var password = document.forms["registration"]["password"].value; 
        var confirmPassword = document.forms["registration"]["confirmPassword"].value;

        if(username != "" && password != "" && confirmPassword != ""){
            flag = true;
        } else {
        
        	 $.ajax({
     	        url: 'get-message-empty-field',
     	        dataType: "text", 
     	        async: false,
     	        success: function(data) {
     	          emptyField = data;		          
     	        }
     	      });   
        
        if (username == "") { 
	        document.getElementById('checkIfUserExist').textContent = emptyField;    	      
        } 
        if (password == "") { 
	      	document.getElementById('errorPassword').textContent = emptyField;	            
        } 
        if (confirmPassword == "") { 
      	   document.getElementById('errorConfirmPassword').textContent = emptyField; 
        } 

        }
        
        return flag;
 } 
   </script> 
   
   <script type="text/javascript">
     function validateForm2() {
 	   var flag = false;
        
       if(validateForm1()){
           var passwordPattern = /[a-zA-Z0-9_\\-]{6,}/;
           var usernamePattern = /[a-zA-Z0-9_\\-]{3,}/;
    	   var password = document.forms["registration"]["password"].value;
           var username = document.forms["registration"]["username"].value; 

           if(username.match(usernamePattern) != null && password.match(passwordPattern) != null && (password == document.forms["registration"]["confirmPassword"].value)){
           flag = true;
           } else {

           if(username.match(usernamePattern) == null){
    		   $.ajax({
        	        url: 'get-message-username-pattern-error',
        	        dataType: "text", 
        	        async: false,
        	        success: function(data) {
        		        document.getElementById('checkIfUserExist').textContent = data;    	      
        	        }
        	      });		   
           } 
    	   
    	   if(password.match(passwordPattern) == null){
    		   $.ajax({
        	        url: 'get-message-password-pattern-password',
        	        dataType: "text", 
        	        async: false,
        	        success: function(data) {
        	        	document.getElementById('errorPassword').textContent = data;		          
        	        }
        	      });		   
           } else {
               if(password != document.forms["registration"]["confirmPassword"].value){
            	   $.ajax({
           	        url: 'get-message-confirm-password-pattern-error',
           	        dataType: "text", 
           	        async: false,
           	        success: function(data) {
                        document.getElementById('errorConfirmPassword').textContent = data;
           	        }
           	      });
               }
           }

           }
       }
       return flag;
     }
  </script>
   
  
    
</head>

<body>



<div class="container">
    <div class="panel-heading">
        <div class="panel-title text-center">
            <h1 class="title"><spring:message code="registration" /></h1>
            <hr/>
        </div>
    </div>

    <form:form method="POST" name="registration" onsubmit="return validateForm2()" modelAttribute="regUser" action="register" class="form-horizontal">

<!--         <div class="form-group input"> -->
<!--             <label class="col-md-4 control-label"><fmt:message key="mail"/></label> -->
<!--             <div class="col-md-4 inputGroupContainer"> -->
<!--                 <div class="input-group"> -->
<!--                     <span class="input-group-addon"><i class="fa fa-envelope"></i></span> -->
<%--                     <input name="email" placeholder="<fmt:message key="mail"/>" class="form-control" type="text" --%>
<%--                            value="${param.email}"> --%>
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->


        <div class="form-group input">
            <form:label path="username" class="col-md-4 control-label"><spring:message code="username" /></form:label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                    <form:input path="username" onkeyup="doAjax(); clearErrorUsername()" class="form-control" /> 
                </div>
                <form:errors path="username" id="errorUsername"/>
			<span id="checkIfUserExist"> </span>
            </div>
        </div>


        <div class="form-group input">
            <form:label path="password" class="col-md-4 control-label"><spring:message code="password" /></form:label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
			        <form:password path="password" onkeyup="clearErrorPassword()" class="form-control"/>
                </div>
                <form:errors path="password" />
                <span id="errorPassword"> </span>  
            </div>
        </div>

        <div class="form-group input">
            <form:label path="confirmPassword" class="col-md-4 control-label"><spring:message code="confirm.password" /></form:label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                    <form:password path="confirmPassword" onkeyup="clearErrorConfirmPassword()" class="form-control"/>			        
                </div>
                <form:errors path="confirmPassword" />
                <span id="errorConfirmPassword"> </span>  
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button"><spring:message code="register.button" /> <span
                        class="fa fa-search"></span></button>
            </div>
        </div>

  </form:form>
</div>


</body>

</html>
