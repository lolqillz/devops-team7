<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script
  		src="https://code.jquery.com/jquery-3.4.1.min.js"
  		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  		crossorigin="anonymous">
	</script>
	<script type="text/javascript"
    	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">
	</script>
	<title>Login</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<style>
		body{font: 14px sans-serif; }
		.wrapper{ width: 360px; padding: 20px; }
	</style>
</head>
<body>
	<div class="wrapper">
		<h3 class="text-center">Login</h3>
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label>Name</label>
				<input type="text" name="userName" class="form-control">
			</div>
			<div class="form-group">
				<label>Password</label>
				<input type="password" name="password" class="form-control">
			</div>
			<div class="form-group">
				<input type="submit" value="Login" />
			</div>
			<p>Do not have an account?  <a href="<%=request.getContextPath()%>/register.jsp">Register Here</a>
		</form>
	</div>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                name: {
                    required: true,
                    name: true
                },
         
                password: "required",
            },
             
            messages: {
                name: {
                    required: "Please enter name",
                    name: "Please enter a valid name"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>