<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<title>Register</title>
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
		<h3 class="text-center">Register</h3>
		<form action="register" method="post">
			<div class="form-group">
				<label>Name</label>
				<input type="text" name="userName" class="form-control">
			</div>
			<div class="form-group">
				<label>Password</label>
				<input type="password" name="password" class="form-control">
			</div>
			<div class="form-group">
				<label>Email</label>
				<input type="text" name="email" class="form-control">
			</div>
			<div class="form-group">
				Language: <select name="language">
					<option>English</option>
					<option>Spanish</option>
					<option>French</option>
				</select>
			</div>	
			<% String result=(String)request.getAttribute("register-output");
				if (result==null) { result="";} %>
			<p><%= result %></p>
			<div class="form-group">
				<input type="submit" value="Register" />
			</div>
			<p>Already have an account?  <a href="<%=request.getContextPath()%>/login">Login Here</a>
		</form>
	</div>
</body>
</html>